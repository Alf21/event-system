/**
 * @author Alf21 on 18.12.2015 in project event-system.
 * Copyright (c) 2015 Alf21. All rights reserved.
 * 
 * CO-Credits: AFK System by Steve "$teVe"
 */

package me.alf21.eventsystem;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import me.alf21.util.DropWeapon;
import me.alf21.util.Gate;
import me.alf21.util.GateGroup;
import me.alf21.util.RangeLabel;
import net.gtaun.shoebill.common.dialog.InputDialog;
import net.gtaun.shoebill.common.dialog.ListDialog;
import net.gtaun.shoebill.common.dialog.ListDialogItem;
import net.gtaun.shoebill.common.dialog.MsgboxDialog;
import net.gtaun.shoebill.constant.PlayerKey;
import net.gtaun.shoebill.constant.WeaponModel;
import net.gtaun.shoebill.data.Color;
import net.gtaun.shoebill.data.Location;
import net.gtaun.shoebill.data.Radius;
import net.gtaun.shoebill.data.WeaponData;
import net.gtaun.shoebill.event.player.PlayerKeyStateChangeEvent;
import net.gtaun.shoebill.event.player.PlayerTakeDamageEvent;
import net.gtaun.shoebill.event.player.PlayerWeaponShotEvent;
import net.gtaun.shoebill.object.Checkpoint;
import net.gtaun.shoebill.object.Player;
import net.gtaun.shoebill.object.Timer;
import net.gtaun.shoebill.object.Zone;
import net.gtaun.wl.common.dialog.WlListDialog;
import net.gtaun.wl.lang.LocalizedStringSet;
import net.gtaun.wl.lang.dialog.LanguageSelectionDialog;

public class EventBase {
	private static PlayerData playerPlayerData;
	private static EventData[] eventsList;
	final private static int max_afk_time = 20000;
	private static int eventIndex;
    private static LocalizedStringSet localizedStringSet = EventSystem.getInstance().getLocalizedStringSet();

	public EventBase() {
		EventBase.eventsList = null;
		eventIndex = 0;
	}
	
	/**
	 * public function to call the event dialog
	 * @param player the player
	 */
	public static void eventDialog(Player player) {
		dialog(player);
	}
	
	/**
	 * event dialog
	 * @param player the player
	 */
	private static void dialog(Player player) {
		playerPlayerData = EventSystem.getInstance().getPlayerLifecycleHolder().getObject(player, PlayerData.class);
		
		ListDialog dialog = ListDialog.create(player, EventSystem.getInstance().getEventManagerInstance())
                .caption("{FF8A05}Eventsystem by Alf21")
                .buttonOk(localizedStringSet.get(player, "Dialog.Next"))
                .buttonCancel(localizedStringSet.get(player, "Dialog.Close"))
                .build();
		
		if(playerPlayerData.getCurrentEvent() != null) {
			//DIALOG ITEM: Info about event state
			dialog.getItems().add(ListDialogItem.create()
		            .itemText(localizedStringSet.get(player, "Event.Eventstate") + ": {FFFF00}" + playerPlayerData.getCurrentEvent().getState().getDisplayName(player))
			        .onSelect((listDialogItem, o) -> {
			        	eventDialog(player);
			        })
		            .build());
		}
		
		if(playerPlayerData.getCurrentEvent() == null || playerPlayerData.getCurrentEvent().getOwner() != player)
			if (playerPlayerData.getCurrentEvent() == null) {
				//DIALOG: Join event
				dialog.getItems().add(ListDialogItem.create()
						.itemText(localizedStringSet.get(player, "Event.Join.Join"))
						.onSelect((listDialogItem, o) -> {
							if (eventsList != null && eventsList.length > 0) {
								ListDialog eventsDialog = ListDialog.create(player, EventSystem.getInstance().getEventManagerInstance())
										.caption("{FF8A05}" + localizedStringSet.get(player, "Event.Eventlist"))
										.buttonOk(localizedStringSet.get(player, "Dialog.Next"))
										.buttonCancel(localizedStringSet.get(player, "Dialog.Close"))
										.onClickCancel((handler) -> eventDialog(player))
										.build();

								EventFunctions.sortEventList(eventsList);
								for (EventData eventData : eventsList) {
									String colorString = "";
									if (eventData.isJoinable()) colorString = "{00FF00}";
									else colorString = "{FF0000}";
									eventsDialog.getItems().add(ListDialogItem.create()
											.itemText(colorString + eventData.getName() + "(" + EventFunctions.getDescriptionForEvent(eventData.getClz()).name() + ") - {FFFF00}" + eventData.getOwner().getName())
											.onSelect((listDialogItem2, o2) -> {
												try {
													if (eventData.isJoinable())
														joinEvent(player, eventData);
													else {
														MsgboxDialog.create(player, EventSystem.getInstance().getEventManagerInstance())
																.caption("{FF8A05}" + localizedStringSet.get(player, "Event.Join.Failed.NotAble"))
																.message("{FF0000}" + localizedStringSet.get(player, "Event.Join.Failed.Closed"))
																.buttonOk(localizedStringSet.get(player, "Dialog.Okay"))
																.buttonCancel(localizedStringSet.get(player, "Dialog.Cancel"))
																.parentDialog(dialog)
																.onClickOk((handler) -> eventsDialog.show())
																.onClickCancel((handler) -> eventsDialog.show())
																.build()
																.show();
													}
												} catch (Exception e) {
													System.out.println(e);
													e.printStackTrace();
												}
											})
											.build());
								}

								eventsDialog.show();
							} else {
								MsgboxDialog.create(player, EventSystem.getInstance().getEventManagerInstance())
										.caption("{FF8A05}" + localizedStringSet.get(player, "Event.NoEventAvailable.Caption"))
										.message("{FF0000}" + localizedStringSet.get(player, "Event.NoEventAvailable.Message"))
										.buttonOk(localizedStringSet.get(player, "Dialog.Okay"))
										.buttonCancel(localizedStringSet.get(player, "Dialog.Cancel"))
										.parentDialog(dialog)
										.onClickOk((handler) -> eventDialog(player))
										.onClickCancel((handler) -> eventDialog(player))
										.build()
										.show();
							}
						})
						.build());

				//DIALOG: Create event
				dialog.getItems().add(ListDialogItem.create()
						.itemText(localizedStringSet.get(player, "Event.Create.Create"))
						.onSelect((listDialogItem, o) -> {
							InputDialog.create(player, EventSystem.getInstance().getEventManagerInstance())
									.caption("{FF8A05}" + localizedStringSet.get(player, "Event.Create.Input.Caption"))
									.message(localizedStringSet.get(player, "Event.Create.Input.Message"))
									.buttonCancel(localizedStringSet.get(player, "Dialog.Cancel"))
									.buttonOk(localizedStringSet.get(player, "Dialog.Create"))
									.onClickOk((inputDialog, s) -> {
										if (s.equals("")) {
											MsgboxDialog.create(player, EventSystem.getInstance().getEventManagerInstance())
													.caption("{FF8A05}" + localizedStringSet.get(player, "Event.Create.Failed.Caption"))
													.message("{FF0000}" + localizedStringSet.get(player, "Event.Create.Input.Failed.NoName.Message"))
													.buttonOk(localizedStringSet.get(player, "Dialog.Okay"))
													.buttonCancel(localizedStringSet.get(player, "Dialog.Cancel"))
													.onClickOk((handler) -> inputDialog.show())
													.onClickCancel((handler) -> inputDialog.show())
													.build()
													.show();
										} else if (isEventNameAvailable(s)) {
											ListDialog availableEventsDialog = ListDialog.create(player, EventSystem.getInstance().getEventManagerInstance())
													.caption("{FF8A05}" + localizedStringSet.get(player, "Event.Create.AvailableEventtypes"))
													.buttonOk(localizedStringSet.get(player, "Dialog.Next"))
													.buttonCancel(localizedStringSet.get(player, "Dialog.Close"))
													.onClickCancel((handler) -> inputDialog.show())
													.build();
											for (Class<?> eventClz : EventExtensibleDependencies.getAvailableEventTypes()) {
												availableEventsDialog.getItems().add(ListDialogItem.create()
														.itemText(EventFunctions.getName(player, EventFunctions.getDescriptionForEvent(eventClz).name()))
														.onSelect((listDialogItem2, o2) -> {
															EventDescription description = EventFunctions.getDescriptionForEvent(getEventClass(player, listDialogItem2.getItemText()));
															String message = "{FFFF00}" + localizedStringSet.get(player, "Description") + ":{FFFFFF}\n" + EventFunctions.getDescription(player, description.name());
															if (description.playerValueMin() != -1)
																message += "\n{FFFF00}" + localizedStringSet.get(player, "MinPlayers") + ": {FFFFFF}" + description.playerValueMin();
															if (description.playerValueMax() != -1)
																message += "\n{FFFF00}" + localizedStringSet.get(player, "MaxPlayers") + ": {FFFFFF}" + description.playerValueMax();
															message += "\n{FFFF00}" + localizedStringSet.get(player, "Credits") + ": {FFFFFF}" + description.credits() +
																	"\n\n{FF0000}" + localizedStringSet.get(player, "Event.Create.Question");
															MsgboxDialog.create(player, EventSystem.getInstance().getEventManagerInstance())
																	.caption("{FF8A05}" + localizedStringSet.format(player, "Event.Create.CreateEvent", listDialogItem2.getItemText()))
																	.message(message)
																	.buttonOk(localizedStringSet.get(player, "Dialog.Yes"))
																	.buttonCancel(localizedStringSet.get(player, "Dialog.No"))
																	.onClickOk((handler) -> {
																		createEvent(s, player, getEventClass(player, listDialogItem2.getItemText()));
																		eventDialog(player);
																	})
																	.onClickCancel((handler) -> availableEventsDialog.show())
																	.build()
																	.show();
														})
														.build());
											}
											availableEventsDialog.show();
										} else {
											MsgboxDialog.create(player, EventSystem.getInstance().getEventManagerInstance())
													.caption("{FF8A05}" + localizedStringSet.get(player, "Event.Create.Failed.Caption"))
													.message("{FF0000}" + localizedStringSet.format(player, "Event.IsNotAvailable", s))
													.buttonOk(localizedStringSet.get(player, "Dialog.Okay"))
													.buttonCancel(localizedStringSet.get(player, "Dialog.Cancel"))
													.onClickOk((handler) -> inputDialog.show())
													.onClickCancel((handler) -> inputDialog.show())
													.build()
													.show();
										}
									})
									.onClickCancel((handler) -> eventDialog(player))
									.build()
									.show();
						})
						.build());
			} else {
				EventData eventData = playerPlayerData.getCurrentEvent();

				//DIALOG: Leave event
				dialog.getItems().add(ListDialogItem.create()
						.itemText("{FFFFFF}" + localizedStringSet.get(player, "Event.Leave.Leave") + " - {FFFF00}'" + eventData.getName() + "'{FFFFFF} (" + EventFunctions.getDescriptionForEvent(eventData.getClz()).name() + ")")
						.onSelect((listDialogItem, o) -> {
							MsgboxDialog.create(player, EventSystem.getInstance().getEventManagerInstance())
									.caption("{FFFF00}" + localizedStringSet.get(player, "Event.Leave.Caption"))
									.message("{FF0000}" + localizedStringSet.get(player, "Event.Leave.Message"))
									.buttonOk(localizedStringSet.get(player, "Dialog.Yes"))
									.buttonCancel(localizedStringSet.get(player, "Dialog.No"))
									.onClickOk((targetDialog) -> {
										leaveEvent(player);
										eventDialog(player);
									})
									.onClickCancel((targetDialog) -> eventDialog(player))
									.build()
									.show();
						})
						.build());
			}
		else {
			//DIALOG: Start event
			EventData eventData = playerPlayerData.getCurrentEvent();
			String str = "{FFFF00}" + localizedStringSet.get(player, "Event.Start.Start").toUpperCase() + "{FFFFFF} (" + localizedStringSet.get(player, "Event.Start.WithPreparation") + ")";
			if(eventData.getState() == EventState.WAITING) str = "{FFFF00}" + localizedStringSet.get(player, "Event.Start.Start") + "{FFFFFF} (" + localizedStringSet.get(player, "Event.Start.WithoutPrepatation") + ")";
			if(getAbilityToStart(eventData) == 0 || eventData.getPlayerList().isEmpty()) {
				str = "{FF0000}[" + localizedStringSet.get(player, "Dialog.Disabled") + "]{FFFFFF} " + str;
			}
			else if(getAbilityToStart(eventData) == 1) {
				str = "{00FF00}[" + localizedStringSet.get(player, "Dialog.Enabled") + "]{FFFFFF} " + str;
			}
			if(eventData.getState() == EventState.START || eventData.getState() == EventState.WAITING) {
				dialog.getItems().add(ListDialogItem.create()
			            .itemText(str)
			            .onSelect((listDialogItem, o) -> {
		            		if(eventData.getState() == EventState.START)
		            			prepareStart(eventData);
		            		else startEvent(eventData);
			            })
				        .build());
			}
			
			if(eventData.getState() == EventState.WAITING) {
				dialog.getItems().add(ListDialogItem.create()
			            .itemText(localizedStringSet.get(player, "Event.Start.Unprepare.Unprepare"))
			            .onSelect((listDialogItem, o) -> {
			            	unprepareStart(eventData);
			            	eventDialog(player);
			            })
				        .build());
			}
			
			if(eventData.getState() == EventState.START) {
				//DIALOG: Invite into event
				dialog.getItems().add(ListDialogItem.create()
			            .itemText(localizedStringSet.get(player, "Event.Invite.Invite"))
			            .onSelect((listDialogItem, o) -> {
							int max = getPlayers().size()-1-eventData.getPlayerList().size();
		                	if(max > 0){
				                ListDialog inviteDialog = ListDialog.create(player, EventSystem.getInstance().getEventManagerInstance())
								        .caption("{FF8A05}" + localizedStringSet.get(player, "Event.Invite.ChoosePlayer"))
								        .buttonOk(localizedStringSet.get(player, "Dialog.Next"))
								        .buttonCancel(localizedStringSet.get(player, "Dialog.Cancel")) 
								        .onClickCancel((handler) -> eventDialog(player))
								        .build();
				                
				                for (Player pl : getPlayers()) {
				                	PlayerData plData = EventSystem.getInstance().getPlayerLifecycleHolder().getObject(pl, PlayerData.class);
				                	if(pl != player && !eventData.getPlayerList().contains(player) && plData.getCurrentEvent() == null){
				                		inviteDialog.getItems().add(ListDialogItem.create()
										            .itemText(((pl.getName().equals("")) ? ("") : (pl.getName())))
										            .onSelect((listDialogItem2, o2) -> {
									                	Player target = Player.get(listDialogItem2.getItemText());
									                	
									                	MsgboxDialog.create(player, EventSystem.getInstance().getEventManagerInstance())
															.caption("{FF8A05}" + localizedStringSet.get(player, "Event.Invite.Invited.Owner.Caption")) 
										                    .message("{00FF00}" + localizedStringSet.format(player, "Event.Invite.Invited.Owner.Message", target.getName())) 
										                    .buttonOk(localizedStringSet.get(player, "Dialog.Okay")) 
										                    .buttonCancel(localizedStringSet.get(player, "Dialog.Cancel")) 
										                    .onClickOk((handler) -> eventDialog(player))
										                    .onClickCancel((handler) -> eventDialog(player))
										                    .build() 
										                    .show();
									                	
									                	MsgboxDialog.create(target, EventSystem.getInstance().getEventManagerInstance())
															.caption("{FF8A05}" + localizedStringSet.format(target, "Event.Invite.Invited.Target.Caption", player.getName())) 
										                    .message("{FFFF00}" + localizedStringSet.get(target, "Event.Invite.Invited.Target.Question")) 
										                    .buttonOk(localizedStringSet.get(target, "Dialog.Yes")) 
										                    .buttonCancel(localizedStringSet.get(target, "Dialog.No")) 
										                    .onClickOk((targetDialog) -> {
									                    		if(eventData.getState() == EventState.RUNNING || eventData.getState() == EventState.WAITING) {
									                    			MsgboxDialog.create(target, EventSystem.getInstance().getEventManagerInstance())
																		.caption("{FF8A05}" + localizedStringSet.get(target, "Event.Join.Failed.NotAble")) 
													                    .message("{FFFF00}" + localizedStringSet.get(target, "Event.Join.Failed.EventState"))
													                    .buttonCancel(localizedStringSet.get(target, "Dialog.Okay")) 
													                    .buttonOk(localizedStringSet.get(target, "Dialog.Back")) 
													                    .onClickOk((targetDialog2) -> eventDialog(target))
													                    .onClickCancel((targetDialog2) -> eventDialog(target))
													                    .build() 
													                    .show();
									                    		}
									                    		else if(eventData.getState() == EventState.START || eventData.getState() == EventState.PREPARE) 
									                    			joinEvent(target, eventData);
										                    })
										                    .onClickCancel((targetDialog) -> player.sendMessage(Color.RED, localizedStringSet.format(player, "Event.Invite.NotAccepted", target.getName())))
										                    .build() 
										                    .show();
										            })
										            .build());
				                	}
				            	}
				                
				                inviteDialog.show();
		                	}
		                	else {
		                		MsgboxDialog.create(player, EventSystem.getInstance().getEventManagerInstance())
									.caption("{FF8A05}" + localizedStringSet.get(player, "Dialog.NoPlayersAvailable.Caption")) 
				                    .message("{FF0000}" + localizedStringSet.get(player, "Dialog.NoPlayersAvailable.Message")) 
				                    .buttonCancel(localizedStringSet.get(player, "Dialog.Cancel")) 
				                    .buttonOk(localizedStringSet.get(player, "Dialog.Okay")) 
				                    .parentDialog(dialog)
				                    .onClickOk((handler) -> eventDialog(player))
				                    .onClickCancel((handler) -> eventDialog(player))
				                    .build() 
				                    .show();
		                	}
				        })
				        .build());
			}
			
			//DIALOG: Destroy event
			dialog.getItems().add(ListDialogItem.create()
		            .itemText("{FFFF00}" + localizedStringSet.get(player, "Event.Destroy.Destroy"))
		            .onSelect((listDialogItem, o) -> {
		            	MsgboxDialog.create(player, EventSystem.getInstance().getEventManagerInstance())
							.caption("{FFFF00}" + localizedStringSet.get(player, "Event.Destroy.Caption")) 
		                    .message("{FF0000}" + localizedStringSet.get(player, "Event.Destroy.Question"))  
		                    .buttonOk(localizedStringSet.get(player, "Dialog.Yes")) 
		                    .buttonCancel(localizedStringSet.get(player, "Dialog.No"))
		                    .onClickOk((targetDialog) -> {
								destroyEvent(eventData);
			            		eventDialog(player);
		                    })
		                    .onClickCancel((targetDialog) -> eventDialog(player))
		                    .build() 
		                    .show();
		            })
			        .build());
			
			//DIALOG: Settings
			dialog.getItems().add(ListDialogItem.create()
		            .itemText("{FFFF00}" + localizedStringSet.get(player, "Event.Settings.Settings"))
		            .onSelect((listDialogItem, o) -> {
		            	EventBase.settingsDialog(eventData);
		            })
			        .build());
			
			//DIALOG: Display Members
			dialog.getItems().add(ListDialogItem.create()
		            .itemText(localizedStringSet.get(player, "Event.Member.Members") + " (" + eventData.getPlayerList().size() + ")")
		            .onSelect((listDialogItem, o) -> {
		            	if(!eventData.getPlayerList().isEmpty()) {
		            		ListDialog memberDialog = ListDialog.create(player, EventSystem.getInstance().getEventManagerInstance())
							        .caption("{FF8A05}" + localizedStringSet.get(player, "Event.Member.Memberlist"))
							        .buttonOk(localizedStringSet.get(player, "Dialog.Back"))
							        .buttonCancel(localizedStringSet.get(player, "Dialog.Cancel")) 
							        .onClickCancel((handler) -> eventDialog(player))
							        .build();
		            		for (Player pl : eventData.getPlayerList()) {
		            			memberDialog.getItems().add(ListDialogItem.create()
								            .itemText(((pl.getName().equals("")) ? ("") : (pl.getName())))
								            .onSelect((listDialogItem2, o2) -> {
								                eventDialog(player);
								            })
								            .build());
		                	}
		            		
		            		memberDialog.show();
		            	}
		            	else {
		            		MsgboxDialog.create(player, EventSystem.getInstance().getEventManagerInstance())
								.caption("{FF8A05}" + localizedStringSet.get(player, "Event.Member.Memberlist")) 
			                    .message("{FF0000}" + localizedStringSet.get(player, "Event.Member.NoMembers")) 
			                    .buttonOk(localizedStringSet.get(player, "Dialog.Okay")) 
			                    .buttonCancel(localizedStringSet.get(player, "Dialog.Back")) 
			                    .onClickOk((handler) -> eventDialog(player))
			                    .onClickCancel((handler) -> eventDialog(player))
			                    .build() 
			                    .show();
		            	}
		            })
			        .build());
			
			//DIALOG: Finish event
			if(eventData.getState() == EventState.RUNNING
			|| eventData.getState() == EventState.PAUSE) {
				dialog.getItems().add(ListDialogItem.create()
			            .itemText(localizedStringSet.get(player, "Event.Finish.Finish"))
			            .onSelect((listDialogItem, o) -> {
		            		finishEvent(eventData);
		                	eventDialog(player);
			            })
				        .build());
			}
			//TODO: Resume, Pause, Quit
		}

		if(playerPlayerData.getCurrentEvent() != null) {
			EventData eventData = playerPlayerData.getCurrentEvent();
			
			if(eventData.getLocation() != null && eventData.getState() == EventState.WAITING && eventData.isTeleportable()
			|| eventData.getLocation() != null && player.isAdmin()) {
				//DIALOG: Teleport to event
				dialog.getItems().add(ListDialogItem.create()
			            .itemText(localizedStringSet.get(player, "Event.Teleport.Teleport"))
			            .onSelect((listDialogItem, o) -> {
			            	player.setLocation(eventData.getLocation());
			            })
				        .build());
			}
			
			if(eventData.getState() == EventState.WAITING) {
				//DIALOG: Waiting list
				dialog.getItems().add(ListDialogItem.create()
			            .itemText(localizedStringSet.get(player, "Event.Waiting.Waiting") + "... {FFFF00}[" + localizedStringSet.get(player, "Dialog.Details") + "]")
			            .onSelect((listDialogItem, o) -> {
		            		ListDialog waitingDialog = ListDialog.create(player, EventSystem.getInstance().getEventManagerInstance())
							        .caption("{FF8A05}" + localizedStringSet.get(player, "Dialog.Waiting.ForPlayers"))
							        .buttonOk(localizedStringSet.get(player, "Dialog.Back"))
							        .buttonCancel(localizedStringSet.get(player, "Dialog.Cancel")) 
							        .onClickCancel((handler) -> eventDialog(player))
							        .build();
		            		for (Player pl : eventData.getWaitingForPlayers()) {
					            waitingDialog.getItems().add(ListDialogItem.create()
							            .itemText(((pl.getName().equals("")) ? ("") : (pl.getName())))
							            .onSelect((listDialogItem2, o2) -> {
								            try {
									            eventDialog(player);
								            } catch (Exception e) {
									            System.out.println(e);
									            e.printStackTrace();
								            }
							            })
							            .build());
				            }
		            		
		            		waitingDialog.show();
			            })
				        .build());
			}
		}
		
		addToDialog(player, dialog);
		
		if(playerPlayerData.getCurrentEvent() != null) {
			EventData eventData = playerPlayerData.getCurrentEvent();
			if(eventData.getEventResult() != null) {
				//DIALOG: Last event results
				dialog.getItems().add(ListDialogItem.create()
			            .itemText(localizedStringSet.get(player, "Event.Result.Last"))
			            .onSelect((listDialogItem, o) -> {
		            		EventResult eventResult = eventData.getEventResult();
		            		String string = localizedStringSet.get(player, "Event.Duration") + ": " + EventFunctions.timeToString(eventResult.getTime()) + "\n" +
		            						localizedStringSet.get(player, "Dialog.Winners") + ": " + EventFunctions.arrayToString(eventResult.getWinner()) + "\n" +
		            						localizedStringSet.get(player, "Players") + ": " + EventFunctions.arrayToString(eventResult.getPlayers());
		            		
		            		MsgboxDialog.create(player, EventSystem.getInstance().getEventManagerInstance())
								.caption("{FF8A05}" + localizedStringSet.get(player, "Event.Result.Caption")) 
			                    .message(string) 
			                    .buttonOk(localizedStringSet.get(player, "Dialog.Okay")) 
			                    .buttonCancel(localizedStringSet.get(player, "Dialog.Cancel")) 
			                    .parentDialog(dialog)
			                    .onClickOk((handler) -> eventDialog(player))
			                    .onClickCancel((handler) -> eventDialog(player)) 
			                    .build() 
			                    .show();
			            })
				        .build());
			}
		}
		
		//DIALOG: Language
		dialog.getItems().add(ListDialogItem.create()
	            .itemText("{FFFF00}Change Language (" + EventSystem.getInstance().getLanguageService().getPlayerLanguage(player).getAbbr() + ")")
	            .onSelect((listDialogItem, o) -> {
            		WlListDialog wlListDialog = LanguageSelectionDialog.create(player, EventSystem.getInstance().getEventManager(), EventSystem.getInstance().getLanguageService(), (player1, language) -> {
			            EventSystem.getInstance().setPlayerLanguage(player1, language.getAbbr());
			            eventDialog(player1);
		            });
            		wlListDialog.setClickCancelHandler((handler) -> eventDialog(player));
            		wlListDialog.show();
	            })
		        .build());
		
		dialog.show();
	}
	
	/**
	 * add event class functions to the dialog
	 * @param player the player
	 * @param dialog the main dialog
	 */
	public static void addToDialog(Player player, ListDialog dialog) {
		playerPlayerData = EventSystem.getInstance().getPlayerLifecycleHolder().getObject(player, PlayerData.class);
		EventData eventData = playerPlayerData.getCurrentEvent();
		if(eventData != null) {
			try {
				((Event) eventData.getClz().newInstance()).addToDialog(player, dialog);
			} catch (InstantiationException | IllegalAccessException e) {
				System.out.println(e);
				e.printStackTrace();
			}
		}
	}

	/**
	 * create an event
	 * @param name the event name
	 * @param owner the event owner
	 * @param clz the event class
	 */
	private static void createEvent(String name, Player owner, Class<?> clz) {
		playerPlayerData = EventSystem.getInstance().getPlayerLifecycleHolder().getObject(owner, PlayerData.class);
	//	int eid;
	//	if(eventsList == null) eid = 0;
	//	else eid = eventsList.length;
	//	EventData eventData = new EventData(eid, name, owner, clz);
		EventData eventData = new EventData(eventIndex, name, owner, clz);
		eventIndex++;
		addEvent(eventData);
		playerPlayerData.setCurrentEvent(eventData);
		initGlobalTimer(eventData);
	}
	
	/**
	 * check if event name is available
	 * @param string the events name which need to be checked
	 * @return boolean
	 */
	public static boolean isEventNameAvailable(String string) {
		if(eventsList != null && eventsList.length > 0) {
			for(EventData eventData : eventsList) {
				if(eventData.getName().equals(string))
					return false;
			}
		}
		return true;
	}
	
	/**
	 * let player join event
	 * @param player the player
	 * @param eventData the event
	 */
	private static void joinEvent(Player player, EventData eventData) {
		playerPlayerData = EventSystem.getInstance().getPlayerLifecycleHolder().getObject(player, PlayerData.class);
		
		playerPlayerData.setCurrentEvent(eventData);
		eventData.getPlayerList().add(player);
		if(eventData.getMap() != null) {
			if(eventData.getZone() != null)
				eventData.getZone().show(player, new Color(255,255,255,102));
		}
		
		eventData.getOwner().sendMessage(Color.YELLOW, localizedStringSet.format(eventData.getOwner(), "Event.Join.Joined", player.getName()));
		for(Player player2 : eventData.getPlayerList()) {
			player2.sendMessage(Color.YELLOW, localizedStringSet.format(player2, "Event.Join.Joined", player.getName()));
		}
		
		try {
			((Event) eventData.getClz().newInstance()).onPlayerJoin(player, eventData);
		} catch (InstantiationException | IllegalAccessException e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}
	
	/**
	 * get current event from player
	 * @param player the player
	 * @return EventData
	 */
	public static EventData getEvent(Player player) {
		if(eventsList != null && eventsList.length > 0) {
			for(EventData eventData : eventsList) {
				if(eventData.getOwner() == player)
					return eventData;
				else {
					for(Player member : eventData.getPlayerList()) {
						if(member == player)
							return eventData;
					}
				}
			}
		}
		return null;
	}
	
	/**
	 * add event to the global event list
	 * @param eventData the event
	 */
	private static void addEvent(EventData eventData) {
		if(eventsList != null && eventsList.length > 0) {
			EventData[] events = new EventData[eventsList.length+1];
			int i = 0;
			for(EventData event2 : eventsList) {
				events[i] = event2;
				i++;
			}
			events[i] = eventData;
			eventsList = events;
		}
		else {
			eventsList = new EventData[1];
			eventsList[0] = eventData;
		}
		System.out.println("[EVENT] Event " + eventData.getName() + "(" + EventFunctions.getDescriptionForEvent(eventData.getClz()).name() + ") created by " + eventData.getOwner().getName());
	}
	
	/**
	 * remove event  from global event list
	 * @param eventData the event
	 */
	private static void removeEvent(EventData eventData) {
		if(eventsList != null && eventsList.length > 0) {
			EventData[] events = new EventData[eventsList.length-1];
			int i = 0;
			for(EventData event2 : eventsList) {
				if(event2 != eventData) {
					events[i] = event2;
					i++;
				}
			}
			eventsList = events;
		}
		if(eventData != null) eventData.destroy();
	}
	
	/**
	 * reset the event for all players so close/cut the connection between player and event
	 * @param eventData the event
	 */
	private static void resetEvent(EventData eventData) {
		for(Player player : eventData.getPlayerList()) {
			player.sendMessage(Color.RED, localizedStringSet.format(player, "Event.Destroy.Destroyed", eventData.getName(), eventData.getOwner().getName()));
		}
		for(Player all : EventFunctions.getAllPlayers(eventData)) {
			PlayerData playerData = EventSystem.getInstance().getPlayerLifecycleHolder().getObject(all, PlayerData.class);
			playerData.setCurrentEvent(null);
		}
	}
	
	/**
	 * let player leave his event
	 * @param player the player
	 */
	public static void leaveEvent(Player player) {
		playerPlayerData = EventSystem.getInstance().getPlayerLifecycleHolder().getObject(player, PlayerData.class);
		EventData eventData = playerPlayerData.getCurrentEvent();
		if(eventData == null) eventData = getEvent(player);
		if(eventData != null) {
			if(isEventMember(player)) {
				for(Player players : eventData.getPlayerList()) {
					players.sendMessage(Color.YELLOW, localizedStringSet.format(players, "Event.Leave.Player", player.getName()));
				}
			}
			onPlayerExit(player, eventData);
		}
	}
	
	/**
	 * remove a player from event
	 * @param target the target
	 */
	public static void removePlayer(Player target) {
		playerPlayerData = EventSystem.getInstance().getPlayerLifecycleHolder().getObject(target, PlayerData.class);
		EventData eventData = playerPlayerData.getCurrentEvent();
		if(eventData == null) eventData = getEvent(target);
		if(eventData != null) {
			if(isEventMember(target)) {
				for(Player player : eventData.getPlayerList()) {
					player.sendMessage(Color.YELLOW, localizedStringSet.format(player, "Event.Remove.Player", target.getName()));
				}
			}
			onPlayerExit(target, eventData);
		}
	}
	
	/**
	 * onPlayerExitEvent
	 * @param player the player
	 * @param eventData the event
	 */
	public static void onPlayerExit(Player player, EventData eventData) {
		playerPlayerData = EventSystem.getInstance().getPlayerLifecycleHolder().getObject(player, PlayerData.class);
		try {
			((Event) eventData.getClz().newInstance()).onPlayerExit(player, eventData);
		} catch (InstantiationException | IllegalAccessException e) {
			System.out.println(e);
			e.printStackTrace();
		}
		
		if(eventData.getMap() != null) {
			if(eventData.getZone() != null) {
				eventData.getZone().hide(player);
			}
		}

		resetData(player);
		if(isEventMember(player)) {
			eventData.getWaitingForPlayers().remove(player);
			eventData.getPlayerList().remove(player);
			playerPlayerData.setCurrentEvent(null);
			if(eventData.getPlayerList().isEmpty() && (eventData.getState() == EventState.PREPARE || eventData.getState() == EventState.WAITING))
				unprepareStart(eventData);
			else if(eventData.getState() == EventState.WAITING && eventData.getWaitingForPlayers().isEmpty())
				startEvent(eventData);
		}
		else if(isEventOwner(player)){
			destroyEvent(eventData);
		//TODO: if owner make other member owner
		//TODO: else destroy eventData
		}
	}
	
	/**
	 * check if player is member of any event
	 * @param player the player
	 * @return boolean
	 */
	private static boolean isEventMember(Player player) {
		playerPlayerData = EventSystem.getInstance().getPlayerLifecycleHolder().getObject(player, PlayerData.class);
		EventData eventData = playerPlayerData.getCurrentEvent();
		if(eventData != null && eventData.getOwner() != player) {
			for(Player member : eventData.getPlayerList()) {
				if(member == player)
					return true;
			}
		}
		return false;
	}
	
	/**
	 * check if player is owner of any event
	 * @param player the player
	 * @return boolean
	 */
	private static boolean isEventOwner(Player player) {
		playerPlayerData = EventSystem.getInstance().getPlayerLifecycleHolder().getObject(player, PlayerData.class);
		EventData eventData = playerPlayerData.getCurrentEvent();
		return eventData != null && (eventData.getOwner() == player);
	}
	
	/**
	 * call the event class before destroying and destroy an event
	 * @param eventData the event
	 */
	public static void destroyEvent(EventData eventData) {
		try {
			((Event) eventData.getClz().newInstance()).destroy(eventData);
		} catch (InstantiationException | IllegalAccessException e) {
			System.out.println(e);
			e.printStackTrace();
		}
		EventFunctions.getAllPlayers(eventData).forEach(EventBase::resetData);
		destroyGameTimer(eventData);
		if(eventData.getMap() != null) {
			if(eventData.getZone() != null) {
				eventData.getZone().hideForAll();
				eventData.getZone().destroy();
				eventData.setZone(null);
			}
			eventData.getMap().destroy();
        	eventData.setMap(null);
		}
		EventNPCBase.destroy();
		resetEvent(eventData);
		removeEvent(eventData);
	}
	
	/**
	 * reset data of a player
	 * @param player the player
	 */
	private static void resetData(Player player) {
		playerPlayerData = EventSystem.getInstance().getPlayerLifecycleHolder().getObject(player, PlayerData.class);
		EventData eventData = playerPlayerData.getCurrentEvent();
		if(eventData != null 
		&& eventData.getState() != EventState.START 
		&& eventData.getState() != EventState.PREPARE 
		&& eventData.getState() != EventState.WAITING) {
			player.setWorld(0);
			player.setInterior(0);
			if(eventData.getLocation() != null) 
				player.setLocation(eventData.getLocation());
			resetWeapons(player);
			player.setHealth(playerPlayerData.getHealth());
			player.setArmour(playerPlayerData.getArmour());
			if(playerPlayerData.getColor() != null) 
				player.setColor(playerPlayerData.getColor());
		}
	}

	/**
	 * reset EventData
	 * @param eventData the event
	 * @param completely if true, the eventData will reset completely (without the memberList, eventClass, eventId, eventName, eventOwner)
	 */
	private static void resetEventData(EventData eventData, boolean completely) {
		ArrayList<Player> playerList = new ArrayList<>(eventData.getPlayerList());
		
		if(!completely) {
			boolean joinable = eventData.isJoinable();
			Location spawnLocation = eventData.getLocation();
			
			eventData.reset();
			
			eventData.setJoinable(joinable);
			eventData.setLocation(spawnLocation);
		}
		else eventData.reset();

		eventData.setPlayerList(playerList);
	}
	
	/**
	 * prepare the event before start and set checkpoints to meet players at one point
	 * @param eventData the event
	 */
	private static void prepareStart(EventData eventData) {
		if(isAbleToStart(eventData)) {
			ArrayList<Player> members = eventData.getPlayerList().stream().collect(Collectors.toCollection(ArrayList::new));
			members.add(eventData.getOwner());
			eventData.setWaitingForPlayers(members);
			
			Checkpoint spawnCheckpoint = new Checkpoint() {
				@Override
				public Radius getLocation() {
					return new Radius(eventData.getLocation(), 10.0f);
				}

				@Override
				public void setLocation(Radius newLocation) {

				}

				@Override
				public void onEnter(Player player) {
					playerPlayerData = EventSystem.getInstance().getPlayerLifecycleHolder().getObject(player, PlayerData.class);
					EventData eventData = playerPlayerData.getCurrentEvent();
					if(eventData != null) {
						eventData.getWaitingForPlayers().remove(player);
						if(eventData.getWaitingForPlayers().isEmpty()) {
							startEvent(eventData);
						}
					}
					player.sendMessage(Color.YELLOW, localizedStringSet.get(player, "Event.Waiting.Checkpoint.Enter"));
				}
				
				@Override
				public void onLeave(Player player) {
					playerPlayerData = EventSystem.getInstance().getPlayerLifecycleHolder().getObject(player, PlayerData.class);
					EventData eventData = playerPlayerData.getCurrentEvent();
					if(eventData != null) {
						eventData.getWaitingForPlayers().add(player);
					}
					player.sendMessage(Color.YELLOW, localizedStringSet.get(player, "Event.Waiting.Checkpoint.Leave"));
				}
			};
			for(Player member : eventData.getPlayerList()) {
				member.setCheckpoint(spawnCheckpoint);
				member.sendMessage(Color.YELLOW, localizedStringSet.get(member, "Event.Waiting.Checkpoint.Message.Member"));
			}
			eventData.getOwner().setCheckpoint(spawnCheckpoint);
			eventData.getOwner().sendMessage(Color.YELLOW, localizedStringSet.get(eventData.getOwner(), "Event.Waiting.ForPlayers"));
			eventData.getOwner().sendMessage(Color.YELLOW, localizedStringSet.get(eventData.getOwner(), "Event.Waiting.Checkpoint.Message.Owner"));
			
			eventData.setState(EventState.WAITING);
		} else onStartFailed(eventData);
	}
	
	/**
	 * unprepare event if event is preparing eg. to invite more players
	 * @param eventData the event
	 */
	private static void unprepareStart(EventData eventData) {
		for(Player all : EventFunctions.getAllPlayers(eventData)) {
			all.disableCheckpoint();
			all.sendMessage(Color.YELLOW, localizedStringSet.get(all, "Event.Start.Unprepare.Message"));
		}
		eventData.setWaitingForPlayers(new ArrayList<>());
		eventData.setState(EventState.START);
	}
	
	/**
	 * init the global timer
	 * @param eventData the event
	 */
	private static void initGlobalTimer(EventData eventData) {
		Timer globalTimer = Timer.create(1000, (factualInterval) -> {
			if(eventData.getState() == EventState.RUNNING) {
				if(eventData.getGameTimer() == null) 
					startGameTimer(eventData);
			}
			if(eventData.getEventTextdraws() != null && !eventData.getEventTextdraws().isEmpty()) { //sort the player textdraws
				for(EventTextdraw eventTextdraw : eventData.getEventTextdraws()) {
					Player player = Player.get(eventTextdraw.getTextdraw().getText());
					if(player != null) {
						PlayerData playerData = EventSystem.getInstance().getPlayerLifecycleHolder().getObject(player, PlayerData.class);
						String score = String.valueOf(playerData.getEventScore());
						eventTextdraw.getScoreTextdraw().setText(score);
					}
				}
				Collections.sort(eventData.getEventTextdraws(), (o1, o2) -> {
				    int i1 = Integer.parseInt(o1.getScoreTextdraw().getText());
				    int i2 = Integer.parseInt(o2.getScoreTextdraw().getText());
				    int sComp = Integer.compare(i1, i2);
	
				    if (sComp != 0) {
				       return sComp;
				    } else {
				       String x1 = o1.getTextdraw().getText();
				       String x2 = o2.getTextdraw().getText();
				       return x1.compareTo(x2);
				    }
				});
				int i = 0;
				for(EventTextdraw eventTextdraw : eventData.getEventTextdraws()) {
					eventTextdraw.move(i);
					try {
						((Event) eventData.getClz().newInstance()).updateTextdraws(eventData);
					} catch (Exception e) {
						System.out.println(e);
						e.printStackTrace();
					}
					i++;
				}
			}
			for(Player player : EventFunctions.getAllPlayers(eventData)) {
				PlayerData playerData = EventSystem.getInstance().getPlayerLifecycleHolder().getObject(player, PlayerData.class);
				if((playerData.getPlayerState() == PlayerState.UPDATING) && (System.currentTimeMillis() - max_afk_time >= playerData.getLastUpdate())) {
					onPlayerAFK(player, eventData);
				}
	        }
			try {
				((Event) eventData.getClz().newInstance()).onGlobalTimer(eventData);
			} catch (Exception e) {
				System.out.println(e);
				e.printStackTrace();
			}
		});
		globalTimer.start();
		eventData.setGlobalTimer(globalTimer);
	}
	
	/**
	 * onPlayerAFKEvent
	 * @param player the player
	 * @param eventData the event
	 */
	public static void onPlayerAFK(Player player, EventData eventData) {
		playerPlayerData = EventSystem.getInstance().getPlayerLifecycleHolder().getObject(player, PlayerData.class);
		if(!playerPlayerData.isAFK()) { //TODO
			playerPlayerData.setAFK(true);
		}
		try {
			((Event) eventData.getClz().newInstance()).onPlayerAFK(player, eventData);
		} catch (InstantiationException | IllegalAccessException e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}
	
	/**
	 * call the event class and start the event
	 * @param eventData the event
	 */
	public static void startEvent(EventData eventData) {
		if(isAbleToStart(eventData)) {
			eventData.resetTimer();
			eventData.startTimer();
			for(Player player : eventData.getPlayerList()) {
				player.disableCheckpoint();
				player.playSound(1057);
			}
			eventData.getOwner().disableCheckpoint();
			eventData.getOwner().playSound(1057);
			
			if(eventData.getMap() != null && eventData.getMap().getLocation() != null) {
				for(Player player : EventFunctions.getAllPlayers(eventData)) {
					spawnPlayer(player, eventData);
				}
			}
			else {
				for(Player player : EventFunctions.getAllPlayers(eventData)) {
					player.setWorld(eventData.getId()+1);
					player.setInterior(0);
				}
			}
			for(Player player : EventFunctions.getAllPlayers(eventData)) {
				playerPlayerData = EventSystem.getInstance().getPlayerLifecycleHolder().getObject(player, PlayerData.class);
				playerPlayerData.setEventScore(0);
				playerPlayerData.setColor(player.getColor());
			}

			try {
				((Event) eventData.getClz().newInstance()).start(eventData);
			} catch (InstantiationException | IllegalAccessException e) {
				System.out.println(e);
				e.printStackTrace();
			}
			EventNPCBase.start(eventData);
		
			eventData.setState(EventState.RUNNING);
		} else onStartFailed(eventData);
	}
	
	/**
	 * start the game timer
	 * @param eventData the event
	 */
	private static void startGameTimer(EventData eventData) {
		try {
			if(((Event) eventData.getClz().newInstance()).isGameTimerEnabled() && eventData.getGameTime() > 0) {
				eventData.getGameTimerTextdraw().setText(new SimpleDateFormat("mm:ss").format(new Date((long)((eventData.getGameTime())*1000))));
				for(Player player : EventFunctions.getAllPlayers(eventData)) {
					eventData.getGameTimerTextdraw().show(player);
				}
					
				eventData.setGameTime(eventData.getGameTime()+1);
				Timer gameTimer = Timer.create(1000, eventData.getGameTime()+1, (factualInterval) -> {
					eventData.getGameTimerTextdraw().setText(new SimpleDateFormat("mm:ss").format(new Date((long)((eventData.getGameTime()-1)*1000))));
					eventData.setGameTime(eventData.getGameTime()-1);
					for(Player player : EventFunctions.getAllPlayers(eventData)) {
						eventData.getGameTimerTextdraw().hide(player);
						eventData.getGameTimerTextdraw().show(player);
					}
					if(eventData.getGameTime() == 0) {
						onFinishGameTimer(eventData);
					}
				});
				gameTimer.start();
				eventData.setGameTimer(gameTimer);
			}
		} catch (InstantiationException | IllegalAccessException e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}
	
	/**
	 * onFinishGameTimerEvent
	 * @param eventData the event
	 */
	private static void onFinishGameTimer(EventData eventData) {
		try {
			if(((Event) eventData.getClz().newInstance()).onFinishGameTimer(eventData)) {
				finishEvent(eventData);
			}
		} catch (InstantiationException | IllegalAccessException e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}
	
	/**
	 * stop the game timer
	 * @param eventData the event
	 */
	private static void destroyGameTimer(EventData eventData) {
		try {
			if(((Event) eventData.getClz().newInstance()).isGameTimerEnabled() && eventData.getGameTimer() != null) {
				for(Player player : EventFunctions.getAllPlayers(eventData)) {
					eventData.getGameTimerTextdraw().hide(player);
					PlayerData playerData = EventSystem.getInstance().getPlayerLifecycleHolder().getObject(player, PlayerData.class);
					if(playerData.getColor() != null) player.setColor(playerData.getColor());
				}
				eventData.getGameTimer().stop();
				eventData.getGameTimer().destroy();
				eventData.setGameTimer(null);
				eventData.setGameTime(-1);
			}
		} catch (InstantiationException | IllegalAccessException e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}
 	
	/**
	 * check whether event is able to start
	 * @param eventData the event
	 * @return boolean
	 */
	public static boolean isAbleToStart(EventData eventData) {
		if(eventData.getClz() == null)
			return false;
		EventDescription eventDescription = EventFunctions.getDescriptionForEvent(eventData.getClz());
		if (eventDescription != null) {
			if(EventFunctions.getAllPlayers(eventData).size() > eventDescription.playerValueMax() && eventDescription.playerValueMax() != -1
			|| EventFunctions.getAllPlayers(eventData).size() < eventDescription.playerValueMin() && eventDescription.playerValueMin() != -1)
				return false;
			else if(eventData.getLocation() == null)
				return false;
			else {
				try {
					return !(eventData.getMap() == null && ((Event) eventData.getClz().newInstance()).dependsOnMaps()) && ((Event) eventData.getClz().newInstance()).isAbleToStart(eventData);
				} catch (InstantiationException | IllegalAccessException e) {
					System.out.println(e);
					e.printStackTrace();
				}
			}
		}
		return true;
	}
	
	/**
	 * do something if event is not able to start / the start fails
	 * @param eventData the event
	 */
	public static void onStartFailed(EventData eventData) {
		Player player = eventData.getOwner();
		if(eventData.getClz() != null) {
			EventDescription eventDescription = EventFunctions.getDescriptionForEvent(eventData.getClz());
			if (eventDescription != null) {
				if(EventFunctions.getAllPlayers(eventData).size() > eventDescription.playerValueMax() && eventDescription.playerValueMax() != -1
				|| EventFunctions.getAllPlayers(eventData).size() < eventDescription.playerValueMin() && eventDescription.playerValueMin() != -1) {
					if(eventData.getPlayerList().isEmpty() && eventDescription.playerValueMin() > 1) {
						MsgboxDialog.create(player, EventSystem.getInstance().getEventManagerInstance())
							.caption("{FF8A05}" + localizedStringSet.get(player, "Event.Member.Memberlist"))
				            .message("{FF0000}" + localizedStringSet.get(player, "Event.Member.NoMembers"))
				            .buttonCancel(localizedStringSet.get(player, "Dialog.Cancel"))
				            .buttonOk(localizedStringSet.get(player, "Dialog.Okay"))
				            .onClickOk((handler) -> dialog(player))
				            .onClickCancel((handler) -> dialog(player))
				            .build()
				            .show();
					}
					else if(eventDescription.playerValueMin() > eventData.getPlayerList().size()+1 && eventDescription.playerValueMin() != -1) {
						MsgboxDialog.create(player, EventSystem.getInstance().getEventManagerInstance())
							.caption("{FF8A05}" + localizedStringSet.get(player, "Event.Member.Memberlist"))
				            .message("{FF0000}" + localizedStringSet.get(player, "Event.Member.NotEnoughMembers"))
				            .buttonCancel(localizedStringSet.get(player, "Dialog.Cancel"))
				            .buttonOk(localizedStringSet.get(player, "Dialog.Okay"))
				            .onClickOk((handler) -> dialog(player))
				            .onClickCancel((handler) -> dialog(player))
				            .build()
				            .show();
					}
					else if(eventDescription.playerValueMax() < eventData.getPlayerList().size()+1 && eventDescription.playerValueMax() != -1) {
						MsgboxDialog.create(player, EventSystem.getInstance().getEventManagerInstance())
							.caption("{FF8A05}" + localizedStringSet.get(player, "Event.Member.Memberlist"))
				            .message("{FF0000}" + localizedStringSet.get(player, "Event.Member.TooManyMembers"))
				            .buttonCancel(localizedStringSet.get(player, "Dialog.Cancel"))
				            .buttonOk(localizedStringSet.get(player, "Dialog.Okay"))
				            .onClickOk((handler) -> dialog(player))
				            .onClickCancel((handler) -> dialog(player))
				            .build()
				            .show();
					}
				}
				else if(eventData.getLocation() == null) {
					player.sendMessage(Color.YELLOW, localizedStringSet.get(player, "Event.Start.Failed.NoSpawn"));
				}
				else {
					try {
						if(eventData.getMap() == null && ((Event) eventData.getClz().newInstance()).dependsOnMaps()) {
							player.sendMessage(Color.YELLOW, localizedStringSet.get(player, "Event.Start.Failed.NoMap"));
						}
						else {
							((Event) eventData.getClz().newInstance()).onStartFailed(eventData);
						}
					} catch (InstantiationException | IllegalAccessException e) {
						System.out.println(e);
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	/**
	 * onPlayerDeath()
	 * @param player the player
	 */
	public static void onPlayerDeath(Player player) {
		playerPlayerData = EventSystem.getInstance().getPlayerLifecycleHolder().getObject(player, PlayerData.class);
		EventData eventData = playerPlayerData.getCurrentEvent();
		if(eventData != null) {
			try {
				((Event) eventData.getClz().newInstance()).onPlayerDeath(player);
			} catch (InstantiationException | IllegalAccessException e) {
				System.out.println(e);
				e.printStackTrace();
			}
		}
		player.resetWeapons();
	}
	
	/**
	 * onPlayerSpawn()
	 * @param player the player
	 */
	public static void onPlayerSpawn(Player player) {
		playerPlayerData = EventSystem.getInstance().getPlayerLifecycleHolder().getObject(player, PlayerData.class);
		EventData eventData = playerPlayerData.getCurrentEvent();
		if(eventData != null) {
			if(eventData.getMap() != null && eventData.getMap().getLocation() != null) {
				if(eventData.getState() == EventState.RUNNING)
					spawnPlayer(player, eventData);
			}
			else {
				if(eventData.getState() == EventState.RUNNING) {
					player.setWorld(eventData.getId()+1);
					player.setInterior(0);
				}
			}
			try {
				((Event) eventData.getClz().newInstance()).onPlayerSpawn(player);
			} catch (InstantiationException | IllegalAccessException e) {
				System.out.println(e);
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * onPlayerKeyStateChange()
	 * @param e the PlayerKeyStateChangeEvent
	 */
	public static void onPlayerKeyStateChange(PlayerKeyStateChangeEvent e) {
		Player player = e.getPlayer();
		playerPlayerData = EventSystem.getInstance().getPlayerLifecycleHolder().getObject(player, PlayerData.class);
		EventData eventData = playerPlayerData.getCurrentEvent();
		if(eventData != null) {
			if(player.getKeyState().isKeyPressed(PlayerKey.CTRL_BACK)) {
		        Gate gate = Gate.getNearstGate(player.getLocation(), 20);
		        if (gate != null) {
			        GateGroup group = Gate.getGroup(gate);
			        if (group != null) group.move();
			        else gate.move();
		        }
			}
			try {
				((Event) eventData.getClz().newInstance()).onPlayerKeyStateChange(e);
			} catch (InstantiationException | IllegalAccessException ex) {
				System.out.println(ex);
				ex.printStackTrace();
			}
		}
	}
	
	/**
	 * initialize the setup for event results, call the event class and finish the event
	 * @param eventData the event
	 */
	public static void finishEvent(EventData eventData) {
		if(eventData.getState() == EventState.RUNNING) {
			eventData.stopTimer();
			if(eventData.getCountdownTimer() != null && eventData.getCountdownTimer().isRunning()) {
				eventData.getCountdownTimer().stop();
			}
			String[] winner = new String[0];
			try {
				winner = ((Event) eventData.getClz().newInstance()).getWinner(eventData);
			} catch (InstantiationException | IllegalAccessException e) {
				System.out.println(e);
				e.printStackTrace();
			}
			int i = 0;
			String[] players = new String[eventData.getPlayerList().size()+1];
			for(Player members : eventData.getPlayerList()) {
				players[i] = members.getName();
				i++;
			}
			players[i] = eventData.getOwner().getName();
			EventResult eventResult = new EventResult(winner, eventData.getTime(), players);
			eventData.setEventResult(eventResult);
			
			String timeString = EventFunctions.timeToString(eventData.getTime());
			for(Player all : EventFunctions.getAllPlayers(eventData)) {
				all.sendMessage(Color.YELLOW, localizedStringSet.format(all, "Event.Finish.Message", EventFunctions.getDescriptionForEvent(eventData.getClz()).name(), timeString));
				PlayerData playerData = EventSystem.getInstance().getPlayerLifecycleHolder().getObject(all, PlayerData.class);
				if(playerData.getColor() != null) 
					all.setColor(playerData.getColor());
			}

			EventFunctions.getAllPlayers(eventData).forEach(EventBase::resetData);
			if(eventData.getMap() != null) {
				if(eventData.getZone() != null) {
					eventData.getZone().hideForAll();
					eventData.getZone().destroy();
					eventData.setZone(null);
				}
				eventData.getMap().destroy();
		    	eventData.setMap(null);
			}
			
	    	destroyGameTimer(eventData);
			try {
				((Event) eventData.getClz().newInstance()).finish(eventData);
			} catch (InstantiationException | IllegalAccessException e) {
				System.out.println(e);
				e.printStackTrace();
			}
			EventNPCBase.finish(eventData);
			
			eventData.setState(EventState.START);
		}
	}
	
	/**
	 * get the event class from description
	 * @param player the player to get language file of
	 * @param string the description
	 * @return Class
	 */
	private static Class<?> getEventClass(Player player, String string) {
		for(Class<?> eventClz : EventExtensibleDependencies.getAvailableEventTypes()) {
			String name = EventFunctions.getName(player, EventFunctions.getDescriptionForEvent(eventClz).name());
			if(name.equals(string)) 
				return eventClz;
		}
		return null;
	}
	
	/**
	 * call the event class and add the settings dialog to the main dialog to setup the event
	 * @param eventData the event
	 */
	public static void settingsDialog(EventData eventData) {
		Player player = eventData.getOwner();
		ListDialog settingsDialog = ListDialog.create(player, EventSystem.getInstance().getEventManagerInstance())
                .caption("{FF8A05}" + EventFunctions.getDescriptionForEvent(eventData.getClz()).name() + " - " + localizedStringSet.get(player, "Event.Settings.Settings"))
                .buttonOk(localizedStringSet.get(player, "Dialog.Next"))
                .buttonCancel(localizedStringSet.get(player, "Dialog.Back"))
                .onClickCancel((handler) -> eventDialog(player))
                .build();
		
		//DIALOG: Remove Player
		removeMemberDialog(player, eventData, settingsDialog);
		
		if(eventData.getState() == EventState.START) {
			//DIALOG: Set event EventMap
			try {
				if(((Event) eventData.getClz().newInstance()).dependsOnMaps() || ((Event) eventData.getClz().newInstance()).isAvailableMaps()) {
					settingsDialog.getItems().add(ListDialogItem.create()
				            .itemText(eventData.getMap()==null?"{FF0000}[" + localizedStringSet.get(player, "Dialog.Todo") + "]{FFFFFF} " + localizedStringSet.get(player, "Event.Map.Choose.ChooseMap"):"{00FF00}[" + localizedStringSet.get(player, "Dialog.Done") + "]{FFFFFF} " + localizedStringSet.get(player, "Event.Map.Choose.ChooseMap") + " (" + EventFunctions.getDescriptionForMap(eventData.getMap().getClz()).name() + ")")
				            .onSelect((listDialogItem, o) -> {
				            	try {
				            		List<Class<?>> maps = ((Event) eventData.getClz().newInstance()).getAvailableMaps();
				            		if(!maps.isEmpty()) {
					            		ListDialog mapDialog = ListDialog.create(player, EventSystem.getInstance().getEventManagerInstance())
										        .caption("{FF8A05}" + localizedStringSet.get(player, "Event.Map.Choose.Caption"))
										        .buttonOk(localizedStringSet.get(player, "Dialog.Choose"))
										        .buttonCancel(localizedStringSet.get(player, "Dialog.Back")) 
										        .onClickCancel((handler) -> EventBase.settingsDialog(eventData))
										        .build();

					            		if(((Event) eventData.getClz().newInstance()).isAvailableMaps() && !((Event) eventData.getClz().newInstance()).dependsOnMaps() && eventData.getMap() != null) {
						            		mapDialog.getItems().add(ListDialogItem.create()
										            .itemText("{FFFF00}" + localizedStringSet.get(player, "Event.Map.Unselect"))
										            .onSelect((listDialogItem2, o2) -> {
									            		if(eventData.getZone() != null) {
									            			eventData.getZone().hideForAll();
									            			eventData.getZone().destroy();
									            			eventData.setZone(null);
									            		}
								            			for(EventNPCData npcData : EventNPCFunctions.getEventNPCDatas(eventData)) {
								            				npcData.getFCNPC().kill();
								            			}
										            	eventData.getMap().destroy();
										            	eventData.setMap(null);
										            	EventBase.settingsDialog(eventData);
										            })
										            .build());
					            		}
					            		for(Class<?> eventMap : maps) {
					            			if(eventData.getMap() != null && eventData.getMap().getClz() == eventMap) continue;
						            		EventMapDescription description = EventFunctions.getDescriptionForMap(eventMap);
								            if (description != null) {
									            mapDialog.getItems().add(ListDialogItem.create()
											            .itemText(description.name())
											            .onSelect((listDialogItem2, o2) -> {
												            if(eventData.getMap() != null) {
													            if(eventData.getZone() != null) {
														            eventData.getZone().hideForAll();
														            eventData.getZone().destroy();
														            eventData.setZone(null);
													            }
													            for(EventNPCData npcData : EventNPCFunctions.getEventNPCDatas(eventData)) {
														            npcData.getFCNPC().kill();
													            }
													            eventData.getMap().destroy();
													            eventData.setMap(null);
												            }

												            EventMapBase eventMap2 = new EventMapBase(getMap(eventData, listDialogItem2.getItemText()));
												            eventMap2.create(eventData.getId()+1, 0, 200, 150, eventData, new WeaponData(WeaponModel.DEAGLE, 14));
												            eventData.setMap(eventMap2);
												            Zone eventZone = Zone.create(eventMap2.getMinX(), eventMap2.getMinY(), eventMap2.getMaxX(), eventMap2.getMaxY());
												            eventData.setZone(eventZone);
												            for(Player all : EventFunctions.getAllPlayers(eventData)) {
													            eventZone.show(all, new Color(255,255,255,102));
												            }
												            for(EventNPCData npcData : EventNPCFunctions.getEventNPCDatas(eventData)) {
													            EventNPCFunctions.spawn(npcData.getFCNPC());
												            }
												            MsgboxDialog.create(player, EventSystem.getInstance().getEventManagerInstance())
																.caption("{FF8A05}" + localizedStringSet.get(player, "Event.Map.Information"))
											                    .message(localizedStringSet.format(player, "Event.Map.Created", description.name()) + "{FFFFFF}\n" + localizedStringSet.get(player, "Credits") + ": " + description.credits()
													                    + "\n" + localizedStringSet.get(player, "Description") + ": " + description.description()
													                    + "\n" + localizedStringSet.get(player, "Size") + ": " + description.size().getDisplayName().toUpperCase())
											                    .buttonOk(localizedStringSet.get(player, "Dialog.Next"))
											                    .buttonCancel(localizedStringSet.get(player, "Dialog.Okay"))
											                    .onClickOk((handler2) -> EventBase.settingsDialog(eventData))
											                    .onClickCancel((handler2) -> EventBase.settingsDialog(eventData))
											                    .build()
											                    .show();
											            })
											            .build());
								            }
							            }
					            		mapDialog.show();
				            		}
				            	} catch (Exception e) {
				            		System.out.println(e);
				            		e.printStackTrace();
				            	}
				            })
				            .build());
				}
			} catch (InstantiationException | IllegalAccessException e) {
				System.out.println(e);
				e.printStackTrace();
			}
			
			//DIALOG: Set EventData Location´
			String colorString;
			if(eventData.getLocation() == null) 
				colorString = "{FF0000}[" + localizedStringSet.get(player, "Dialog.Todo") + "]{FFFFFF} ";
			else colorString = "{00FF00}[" + localizedStringSet.get(player, "Dialog.Done") + "]{FFFFFF} ";
			settingsDialog.getItems().add(ListDialogItem.create()
		            .itemText(colorString + localizedStringSet.get(player, "Event.Spawn.Set"))
		            .onSelect((listDialogItem, o) -> {
	            		setEventSpawn(eventData, player.getLocation());
	            		MsgboxDialog.create(player, EventSystem.getInstance().getEventManagerInstance())
							.caption("{FF8A05}" + localizedStringSet.get(player, "Event.Spawn.Created.Caption")) 
		                    .message("{00FF00}" + localizedStringSet.get(player, "Event.Spawn.Created.Message")) 
		                    .buttonOk(localizedStringSet.get(player, "Dialog.Okay")) 
		                    .buttonCancel(localizedStringSet.get(player, "Dialog.Back")) 
		                    .onClickOk((handler2) -> EventBase.settingsDialog(eventData))
		                    .onClickCancel((handler2) -> EventBase.settingsDialog(eventData))
		                    .build() 
		                    .show();
		            })
		            .build());
			
			//DIALOG: Set teleportable
			if(player.isAdmin()) {
				settingsDialog.getItems().add(ListDialogItem.create()
			            .itemText(eventData.isTeleportable()?"{00FF00}[" + localizedStringSet.get(player, "Dialog.Activated") + "]{FFFFFF} " + localizedStringSet.get(player, "Event.Teleport.Teleport"):"{FF0000}[" + localizedStringSet.get(player, "Dialog.Deactivated") + "]{FFFFFF} " + localizedStringSet.get(player, "Event.Teleport.Teleport"))
			            .onSelect((listDialogItem, o) -> {
		            		if(eventData.getLocation() != null) {
			            		eventData.setTeleportable(!eventData.isTeleportable());
			            		EventBase.settingsDialog(eventData);
		            		}
		            		else {
		            			MsgboxDialog.create(player, EventSystem.getInstance().getEventManagerInstance())
									.caption("{FF8A05}" + localizedStringSet.get(player, "Event.Teleport.Failed.Caption")) 
				                    .message("{FF0000}" + localizedStringSet.get(player, "Event.Start.Failed.NoSpawn")) 
				                    .buttonOk(localizedStringSet.get(player, "Dialog.Okay")) 
				                    .buttonCancel(localizedStringSet.get(player, "Dialog.Back")) 
				                    .onClickOk((handler2) -> EventBase.settingsDialog(eventData))
				                    .onClickCancel((handler2) -> EventBase.settingsDialog(eventData))
				                    .build() 
				                    .show();
		            		}
			            })
			            .build());
			}
			
			//DIALOG: Set joinable
			settingsDialog.getItems().add(ListDialogItem.create()
		            .itemText(eventData.isJoinable()?"{00FF00}[" + localizedStringSet.get(player, "Dialog.Activated") + "]{FFFFFF} " + localizedStringSet.get(player, "Event.Join.JoinableEvent"):"{FF0000}[" + localizedStringSet.get(player, "Dialog.Deactivated") + "]{FFFFFF} " + localizedStringSet.get(player, "Event.Join.JoinableEvent"))
		            .onSelect((listDialogItem, o) -> {
	            		eventData.setJoinable(!eventData.isJoinable());
	            		EventBase.settingsDialog(eventData);
		            })
		            .build());
			
			//DIALOG: gametimer time
			try {
				if(((Event) eventData.getClz().newInstance()).isGameTimerEnabled()) {
					settingsDialog.getItems().add(ListDialogItem.create()
				            .itemText(eventData.getGameTime()<0?"{FF0000}[" + localizedStringSet.get(player, "Dialog.Todo") + "]{FFFFFF} " + localizedStringSet.get(player, "Event.Gametimer.Gametimer"):"{00FF00}[" + localizedStringSet.get(player, "Dialog.Done") + "]{FFFFFF} " + localizedStringSet.get(player, "Event.Gametimer.Gametimer") + " (" + eventData.getGameTime() + ")")
				            .onSelect((listDialogItem, o) -> {
			            		InputDialog.create(player, EventSystem.getInstance().getEventManagerInstance())
				            		.caption("{FF8A05}" + localizedStringSet.get(player, "Event.Gametimer.Settings.Caption"))
				            		.message(localizedStringSet.get(player, "Event.Gametimer.Settings.Input.Message"))
				            		.buttonCancel(localizedStringSet.get(player, "Dialog.Back"))
				            		.buttonOk(localizedStringSet.get(player, "Dialog.Enter"))
				            		.onClickOk((dialog, s) -> {
				            			try {
				            				int input = Integer.parseInt(s);
				            				if(input >= 0) {
						            			eventData.setGameTime(input);
						            			EventBase.settingsDialog(eventData);
				            				}
				            				else {
				            					MsgboxDialog.create(player, EventSystem.getInstance().getEventManagerInstance())
													.caption("{FF8A05}" + localizedStringSet.get(player, "Dialog.Error.Error")) 
													.message("{FF0000}" + localizedStringSet.get(player, "Dialog.Error.PositiveNumbers"))
													.buttonOk(localizedStringSet.get(player, "Dialog.Okay")) 
													.buttonCancel(localizedStringSet.get(player, "Dialog.Cancel")) 
													.onClickOk((handler) -> dialog.show())
													.onClickCancel((handler) -> dialog.show())
													.build() 
													.show();
				            				}
				            			} catch(Exception e) {
											MsgboxDialog.create(player, EventSystem.getInstance().getEventManagerInstance())
												.caption("{FF8A05}" + localizedStringSet.get(player, "Dialog.Error.Error")) 
												.message("{FF0000}" + localizedStringSet.get(player, "Dialog.Error.Numbers"))
												.buttonOk(localizedStringSet.get(player, "Dialog.Okay")) 
												.buttonCancel(localizedStringSet.get(player, "Dialog.Cancel")) 
												.onClickOk((handler) -> dialog.show())
												.onClickCancel((handler) -> dialog.show())
												.build() 
												.show();
				            			}
				                    })
				                    .onClickCancel((handler) -> EventBase.settingsDialog(eventData))
				                    .build()
				                    .show();
				            })
				            .build());
				}
			} catch (InstantiationException | IllegalAccessException e) {
				System.out.println(e);
				e.printStackTrace();
			}
		}
		
		try {
			((Event) eventData.getClz().newInstance()).settingsDialog(player, settingsDialog);
		} catch (InstantiationException | IllegalAccessException e) {
			System.out.println(e);
			e.printStackTrace();
		}

		if(eventData.getState() == EventState.START) {
			//DIALOG: reset event settings
			settingsDialog.getItems().add(ListDialogItem.create()
		            .itemText("{FFFF00}" + localizedStringSet.get(player, "Event.Settings.Reset.Reset"))
		            .onSelect((listDialogItem, o) -> {
						MsgboxDialog.create(player, EventSystem.getInstance().getEventManagerInstance())
							.caption("{FF8A05}" + localizedStringSet.get(player, "Event.Settings.Reset.Caption")) 
							.message("{FF0000}" + localizedStringSet.get(player, "Event.Settings.Reset.Question")) 
							.buttonOk(localizedStringSet.get(player, "Dialog.Yes"))
							.buttonCancel(localizedStringSet.get(player, "Dialog.No"))  
							.onClickOk((handler) -> {
								resetEventData(eventData, true);
			            		EventBase.settingsDialog(eventData);
							})
							.onClickCancel((handler) -> EventBase.settingsDialog(eventData))
							.build() 
							.show();
		            })
		            .build());
			
			//DIALOG: Change Eventtype
			if(EventExtensibleDependencies.getAvailableEventTypes().size() > 1) {
				settingsDialog.getItems().add(ListDialogItem.create()
			        .itemText("{FFFF00}" + localizedStringSet.get(player, "Event.Change.Change"))
		            .onSelect((listDialogItem, o) -> {
	            		MsgboxDialog.create(player, EventSystem.getInstance().getEventManagerInstance())
							.caption("{FF8A05}" + localizedStringSet.get(player, "Event.Change.Caption")) 
		                    .message(localizedStringSet.format(player, "Event.Change.Question", EventFunctions.getDescriptionForEvent(eventData.getClz()).name()))
		                    .buttonOk(localizedStringSet.get(player, "Dialog.Yes")) 
		                    .buttonCancel(localizedStringSet.get(player, "Dialog.No")) 
		                    .onClickOk((handler2) -> {
		            			ListDialog availableEventsDialog = ListDialog.create(player, EventSystem.getInstance().getEventManagerInstance())
			                            .caption("{FF8A05}" + localizedStringSet.get(player, "Event.Types.Available"))
			                            .buttonOk(localizedStringSet.get(player, "Dialog.Next"))
			                            .buttonCancel(localizedStringSet.get(player, "Dialog.Close"))
			                            .onClickCancel((handler) -> EventBase.settingsDialog(eventData))
			                            .build();
			            		for(Class<?> eventClz : EventExtensibleDependencies.getAvailableEventTypes()) {
			            			if(eventClz != eventData.getClz()) {
					            		availableEventsDialog.getItems().add(ListDialogItem.create()
					        		            .itemText(EventFunctions.getName(player, EventFunctions.getDescriptionForEvent(eventClz).name()))
					        		            .onSelect((listDialogItem2, o2) -> {
				        		            		EventDescription description = EventFunctions.getDescriptionForEvent(getEventClass(player, listDialogItem2.getItemText()));
					                    			String message = "{FFFF00}" + localizedStringSet.get(player, "Description") + ":{FFFFFF}\n" + EventFunctions.getDescription(player, description.name());
							                    		if(description.playerValueMin() != -1)
					                    					message += "\n{FFFF00}" + localizedStringSet.get(player, "MinPlayers") + ": {FFFFFF}" + description.playerValueMin();
							                    		if(description.playerValueMax() != -1)
					                    					message += "\n{FFFF00}" + localizedStringSet.get(player, "MaxPlayers") + ": {FFFFFF}" + description.playerValueMax();
							                    		message += "\n{FFFF00}" + localizedStringSet.get(player, "Credits") + ": {FFFFFF}" + description.credits() +
							                    		"\n\n{FF0000}" + localizedStringSet.get(player, "Event.Change.ToEvent.Question");
				        		            		MsgboxDialog.create(player, EventSystem.getInstance().getEventManagerInstance())
														.caption("{FF8A05}" + localizedStringSet.format(player, "Event.Change.ToEvent.ToEvent", listDialogItem2.getItemText())) 
									                    .message(message) 
									                    .buttonOk(localizedStringSet.get(player, "Dialog.Yes"))
									                    .buttonCancel(localizedStringSet.get(player, "Dialog.No")) 
									                    .onClickOk((handler) -> {
															resetEventData(eventData, false);
						                    				eventData.setClz(getEventClass(player, listDialogItem2.getItemText()));
															eventDialog(player);
									                    })
									                    .onClickCancel((handler) -> availableEventsDialog.show())
									                    .build() 
									                    .show();
									            })
										        .build());
			            			}
			            		}
			            		availableEventsDialog.show();
		                    })
		                    .onClickCancel((handler2) -> EventBase.settingsDialog(eventData))
		                    .build() 
		                    .show();
			        })
			        .build());
			}
		}
		settingsDialog.show();
	}

	/**
	 * get the spawn / meeting location of an event
	 * @param eventData the event
	 * @return Location
	 */
	static Location getLocation(EventData eventData) {
		if(eventData.getLocation() != null)
			return eventData.getLocation();
		else return eventData.getOwner().getLocation();
	}
	
	/**
	 * set the spawn / meeting location of an event
	 * @param eventData the event
	 * @param location the location
	 */
	static void setEventSpawn(EventData eventData, Location location) {
		eventData.setLocation(location);
	}
	
	/**
	 * do every onPlayerUpdateEvent something
	 * @param player the player
	 */
	public static void checkEvent(Player player) {
		playerPlayerData = EventSystem.getInstance().getPlayerLifecycleHolder().getObject(player, PlayerData.class);
		EventData eventData = playerPlayerData.getCurrentEvent();
		if(eventData != null) {
			if(eventData.getState() == EventState.RUNNING) {
				if(eventData.getMap() != null && eventData.getMap().getLocation() != null) { //re spawn on escaped EventMap
					float 	x = player.getLocation().getX(),
							y = player.getLocation().getY(),
							z = player.getLocation().getZ();
					EventMapBase eventMap = eventData.getMap();
					if(x > eventMap.getMaxX()+10f) {
						player.setLocation(eventMap.getMaxX(), player.getLocation().getY(), player.getLocation().getZ());
					}
					if(x < eventMap.getMinX()-10f) {
						player.setLocation(eventMap.getMinX(), player.getLocation().getY(), player.getLocation().getZ());
					}
					if(y > eventMap.getMaxY()+10f) {
						player.setLocation(player.getLocation().getX(), eventMap.getMaxY(), player.getLocation().getZ());
					}
					if(y < eventMap.getMinY()-10f) {
						player.setLocation(player.getLocation().getX(), eventMap.getMinY(), player.getLocation().getZ());
					}
					if(z < eventMap.getMinZ()) {
						spawnPlayer(player, eventData);
					}
				}
				
				if(eventData.getMap() != null) {
					if(eventData.getMap().getDropWeapons() != null && !eventData.getMap().getDropWeapons().isEmpty()) { //take dropped weapon on move above
						DropWeapon dropWeapon = getDropWeaponInRange(player.getLocation(), eventData, 1);
						if(dropWeapon != null) {
							player.giveWeapon(dropWeapon.getWeaponData());
							player.sendGameText(2000, 3, dropWeapon.getWeaponData().getModel().getName() + ": +" + dropWeapon.getWeaponData().getAmmo());
							eventData.getMap().getDropWeapons().remove(dropWeapon);
							dropWeapon.destroy();
						}
					}
				}
			}
			if(playerPlayerData.isAFK()) { //TODO
				playerPlayerData.setAFK(false);
				player.setHealth(player.getHealth()-playerPlayerData.getDamage());
			}
			try {
				((Event) eventData.getClz().newInstance()).check(player);
			} catch (InstantiationException | IllegalAccessException e) {
				System.out.println(e);
				e.printStackTrace();
			}
		}
		if(!playerPlayerData.getRangeLabels().isEmpty()) {
			for(RangeLabel rangeLabel : playerPlayerData.getRangeLabels()) {
				rangeLabel.update(null, player.getLocation());
			}
		}
	}
	
	/**
	 * get the nearest dropped weapon in range of the location
	 * @param location the location
	 * @param eventData the event
	 * @param range the max range
	 * @return DropWeapon
	 */
	private static DropWeapon getDropWeaponInRange(Location location, EventData eventData, float range) {
		DropWeapon dropWeapon = null;
		float min = -1;
		for(DropWeapon dropWeapon2 : eventData.getMap().getDropWeapons()) {
			float newRange = dropWeapon2.getLocation().distance(location);
			if(newRange <= range && (min == -1 || min > newRange)) {
				min = newRange;
				dropWeapon = dropWeapon2;
			}
		}
		return dropWeapon;
	}
	
	/**
	 * spawn player on event spawn
	 * @param player the player
	 * @param eventData the event
	 */
	private static void spawnPlayer(Player player, EventData eventData) {
		saveWeapons(player);
		playerPlayerData = EventSystem.getInstance().getPlayerLifecycleHolder().getObject(player, PlayerData.class);
		playerPlayerData.setHealth(player.getHealth());
		playerPlayerData.setArmour(player.getArmour());
		player.resetWeapons();
		Random random = new Random();
		player.setLocation(new Location(eventData.getMap().getLocation().getX()+random.nextFloat(), eventData.getMap().getLocation().getY()+random.nextFloat(), eventData.getMap().getLocation().getZ()+1));
		player.setWorld(eventData.getMap().getLocation().getWorldId());
		player.setInterior(eventData.getMap().getLocation().getInteriorId());
	}
	
	/**
	 * save player weapons
	 * @param player the player
	 */
	private static void saveWeapons(Player player) {
		playerPlayerData = EventSystem.getInstance().getPlayerLifecycleHolder().getObject(player, PlayerData.class);
		for (int i = 0; i <= 12; i++) {
			playerPlayerData.getPlayerWeapons().add(player.getWeaponData(i));
		}
	}
	

	/**
	 * reset player weapons
	 * @param player the player
	 */
	private static void resetWeapons(Player player) {
		playerPlayerData = EventSystem.getInstance().getPlayerLifecycleHolder().getObject(player, PlayerData.class);
		player.resetWeapons();
		playerPlayerData.getPlayerWeapons().forEach(player::giveWeapon);
	}
	
	/**
	 * onPlayerWeaponShot()
	 * @param e the PlayerWeaponShotEvent
	 */
	public static void onPlayerWeaponShot(PlayerWeaponShotEvent e) {
		Player player = e.getPlayer();
		playerPlayerData = EventSystem.getInstance().getPlayerLifecycleHolder().getObject(player, PlayerData.class);
		EventData eventData = playerPlayerData.getCurrentEvent();
	/*	
		if(e.getHitPlayer() != null) {
			playerPlayerData = EventSystem.getInstance().getPlayerLifecycleHolder().getObject(e.getHitPlayer(), PlayerData.class);
			if(playerPlayerData.isAFK()) playerPlayerData.setDamage(playerPlayerData.getDamage()+weaponDamage); //TODO
		}
	*/
		if(eventData != null) {
			try {
				((Event) eventData.getClz().newInstance()).onPlayerWeaponShot(e);
			} catch (InstantiationException | IllegalAccessException err) {
				System.out.println(err);
				err.printStackTrace();
			}
		}
	}
	
	/**
	 * onPlayerTakeDamage()
	 * @param e the PlayerTakeDamageEvent
	 */
	public static void onPlayerTakeDamage(PlayerTakeDamageEvent e) {
		Player player = e.getPlayer();
		playerPlayerData = EventSystem.getInstance().getPlayerLifecycleHolder().getObject(player, PlayerData.class);
		EventData eventData = playerPlayerData.getCurrentEvent();
		if(eventData != null) {
			try {
				((Event) eventData.getClz().newInstance()).onPlayerTakeDamage(e);
			} catch (InstantiationException | IllegalAccessException err) {
				System.out.println(err);
				err.printStackTrace();
			}
		}
	}
	
	/**
	 * returns the Integer for the color of styling start dialogitem of main dialog
	 * @param eventData the event
	 * @return int
	 */
	public static int getAbilityToStart(EventData eventData) {
		int i = 1;
		if(eventData.getPlayerList().isEmpty()) {
			return 0;
		}
		else if(eventData.getLocation() == null) {
			return 0;
		}
		else if(eventData.getMap() == null) {
			try {
				if(((Event) eventData.getClz().newInstance()).dependsOnMaps()) {
					return 0;
				}
			} catch (InstantiationException | IllegalAccessException e) {
				System.out.println(e);
				e.printStackTrace();
			}
		}
		try {
			if(eventData.getGameTime() == -1 && ((Event) eventData.getClz().newInstance()).isGameTimerEnabled()) 
				i = -1;
			int i2 = ((Event) eventData.getClz().newInstance()).getAbilityToStart(eventData);
			if(i2 == 0)
				return 0;
			else if(i2 == -1) 
				i = -1;

			EventDescription eventDescription = EventFunctions.getDescriptionForEvent(eventData.getClz());
			if (eventDescription != null && (eventDescription.playerValueMin() > eventData.getPlayerList().size() + 1 && eventDescription.playerValueMin() != -1
					|| eventDescription.playerValueMax() < eventData.getPlayerList().size() + 1 && eventDescription.playerValueMax() != -1))
				return 0;
		} catch (InstantiationException | IllegalAccessException e) {
			System.out.println(e);
			e.printStackTrace();
		}
		return i;
	}
	
	/**
	 * get the global event list
	 * @return EventData[]
	 */
	public static EventData[] getEventsList() {
		return eventsList;
	}
	
	/**
	 * set the global event list
	 * @param eventsList the list of events
	 */
	public static void setEventsList(EventData[] eventsList) {
		EventBase.eventsList = eventsList;
	}
	
	/**
	 * get all online players on the server as a sorted array
	 * @return Player[]
	 */
	public static ArrayList<Player> getPlayers() {
		ArrayList<Player> players = Player.getHumans().stream().collect(Collectors.toCollection(ArrayList::new));
		EventFunctions.sortPlayerlist(players);
		return players;
	}
	
	/**
	 * get EventMapBase by name
	 * @param eventData the event
	 * @param name the EventMap name
	 * @return EventMapBase the searched EventMapBase
	 */
	private static Class<?> getMap(EventData eventData, String name) {
		try {
			for(Class<?> mapClz : ((Event) eventData.getClz().newInstance()).getAvailableMaps()) {
				if(name.equals(EventFunctions.getDescriptionForMap(mapClz).name()))
					return mapClz;
			}
		} catch (InstantiationException | IllegalAccessException e) {
			System.out.println(e);
			e.printStackTrace();
		}
		return null;
	}
	
	//DIALOGS
	/**
	 * dialog to select members who should be removed
	 * @param player the player
	 * @param eventData the event
	 * @param settingsDialog the settingsdialog of main dialog
	 */
	private static void removeMemberDialog(Player player, EventData eventData, ListDialog settingsDialog) {
		settingsDialog.getItems().add(ListDialogItem.create()
	            .itemText(localizedStringSet.get(player, "Event.Remove.Member"))
	            .onSelect((listDialogItem, o) -> {
            		ListDialog memberDialog = ListDialog.create(player, EventSystem.getInstance().getEventManagerInstance())
					        .caption("{FF8A05}" + localizedStringSet.get(player, "Event.Remove.SelectMember"))
					        .buttonOk(localizedStringSet.get(player, "Dialog.Remove"))
					        .buttonCancel(localizedStringSet.get(player, "Dialog.Back")) 
					        .onClickCancel((handler) -> EventBase.settingsDialog(eventData))
					        .build();
            		
            		if(!eventData.getPlayerList().isEmpty()) {
	            		ArrayList<Player> members = eventData.getPlayerList();
            			EventFunctions.sortPlayerlist(members);
            			for (Player pl : members) {
	            			memberDialog.getItems().add(ListDialogItem.create()
							            .itemText(((pl.getName().equals("")) ? ("") : (pl.getName())))
							            .onSelect((listDialogItem2, o2) -> {
						                	Player target = Player.get(listDialogItem2.getItemText());
						                	if(target != null) {
							                	MsgboxDialog.create(player, EventSystem.getInstance().getEventManagerInstance())
													.caption("{FF8A05}" + localizedStringSet.get(player, "Event.Remove.Caption")) 
								                    .message("{FFFF00}" + localizedStringSet.format(player, "Event.Remove.Question", target.getName())) 
								                    .buttonOk(localizedStringSet.get(player, "Dialog.Yes"))
								                    .buttonCancel(localizedStringSet.get(player, "Dialog.No")) 
								                    .onClickOk((handler) -> {
								                    	removePlayer(target);

								                		MsgboxDialog.create(target, EventSystem.getInstance().getEventManagerInstance())
														.caption("{FF8A05}" + localizedStringSet.get(target, "Event.Remove.Removed.Removed")) 
									                    .message("{FF0000}" + localizedStringSet.get(target, "Event.Remove.Removed.Target")) 
									                    .buttonOk(localizedStringSet.get(target, "Dialog.Okay")) 
									                    .buttonCancel(localizedStringSet.get(target, "Dialog.Close")) 
									                    .build() 
									                    .show();

								                		MsgboxDialog.create(player, EventSystem.getInstance().getEventManagerInstance())
														.caption("{FF8A05}" + localizedStringSet.get(player, "Event.Remove.Removed.Removed")) 
									                    .message("{00FF00}" + localizedStringSet.format(player, "Event.Remove.Removed.Owner", target.getName())) 
									                    .buttonOk(localizedStringSet.get(player, "Dialog.Okay")) 
									                    .buttonCancel(localizedStringSet.get(player, "Dialog.Close")) 
									                    .onClickOk((handler2) -> removeMemberDialog(player, eventData, settingsDialog))
									                    .onClickCancel((handler2) -> removeMemberDialog(player, eventData, settingsDialog))
									                    .build() 
									                    .show();
								                    })
								                    .onClickCancel((handler) -> memberDialog.show())
								                    .build() 
								                    .show();
						                	}
						                	else {
						                		settingsDialog.show();
						                	}
							            })
							            .build());
	                	}
	            		memberDialog.show();
            		}
            		else {
            			MsgboxDialog.create(player, EventSystem.getInstance().getEventManagerInstance())
							.caption("{FF8A05}" + localizedStringSet.get(player, "Event.Member.Memberlist")) 
		                    .message("{FF0000}" + localizedStringSet.get(player, "Event.Member.NoMembers")) 
		                    .buttonOk(localizedStringSet.get(player, "Dialog.Okay")) 
		                    .buttonCancel(localizedStringSet.get(player, "Dialog.Back")) 
		                    .onClickOk((handler) -> EventBase.settingsDialog(eventData))
		                    .onClickCancel((handler) -> EventBase.settingsDialog(eventData))
		                    .build() 
		                    .show();
            		}
	            })
	            .build());
	}
	//TODO: wenn spieler eventData joined oder leaved und Owner / Member den Dialog offen haben -> neu öffnen da update der Userzahl usw. bzw wenn Spiel gestartet is und man als owner alleine ist, das Spiel stoppen
}
