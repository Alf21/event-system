/**
 * @author Alf21 on 18.12.2015 in project event-system.
 * Copyright (c) 2015 Alf21. All rights reserved.
 */

package me.alf21.events;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.stream.Collectors;


import me.alf21.eventsystem.Event;
import me.alf21.eventsystem.EventData;
import me.alf21.eventsystem.EventDescription;
import me.alf21.eventsystem.EventBase;
import me.alf21.eventsystem.EventFunctions;
import me.alf21.eventsystem.EventState;
import me.alf21.eventsystem.EventSystem;
import me.alf21.eventsystem.EventTextdraw;
import me.alf21.eventsystem.PlayerData;
import me.alf21.util.GameTextTD;
import net.gtaun.shoebill.Shoebill;
import net.gtaun.shoebill.common.dialog.InputDialog;
import net.gtaun.shoebill.common.dialog.ListDialog;
import net.gtaun.shoebill.common.dialog.ListDialogItem;
import net.gtaun.shoebill.common.dialog.MsgboxDialog;
import net.gtaun.shoebill.constant.BulletHitType;
import net.gtaun.shoebill.constant.PlayerKey;
import net.gtaun.shoebill.constant.PlayerState;
import net.gtaun.shoebill.data.Color;
import net.gtaun.shoebill.data.Location;
import net.gtaun.shoebill.data.Velocity;
import net.gtaun.shoebill.event.player.PlayerTakeDamageEvent;
import net.gtaun.shoebill.event.player.PlayerWeaponShotEvent;
import net.gtaun.shoebill.object.Player;
import net.gtaun.shoebill.object.PlayerKeyState;
import net.gtaun.shoebill.object.Timer;
import net.gtaun.wl.lang.LocalizedStringSet;

@EventDescription(name = "Catching", playerValueMin = 2, credits = "Alf21\n\tTester: Robert")
public class Catching extends Event {
	public static PlayerData playerLifecycle;
    private static LocalizedStringSet localizedStringSet = EventSystem.getInstance().getLocalizedStringSet();

	public Catching() {
		super();
	}
	
	/*
	 * (non-Javadoc)
	 * @see me.alf21.eventsystem.Event#startEvent(me.alf21.eventsystem.EventData)
	 */
	@Override
	public void start(EventData eventData) {
		eventData.setDataPlayerArray(eventData.getPlayerList());
		eventData.getDataPlayerArray().add(eventData.getOwner());
		eventData.getDataPlayerArray().clear();
		for(Player all : EventFunctions.getAllPlayers(eventData)) {
			all.sendMessage(Color.YELLOW, localizedStringSet.format(all, "Event.Class.Catching.Start.Started", eventData.getOwner().getName(), EventFunctions.getDescriptionForEvent(eventData.getClz()).name()));
		}
		if(eventData.getDataInt() < 0) eventData.setDataInt(10);
		if(eventData.getMultiplicator() < 0) eventData.setMultiplicator(1);

		if(!eventData.getDataPlayerArray2().isEmpty())
			initCatcher(eventData);
		initEvent(eventData);
	}
	
	/*
	 * (non-Javadoc)
	 * @see me.alf21.eventsystem.Event#finishEvent(me.alf21.eventsystem.EventData)
	 */
	@Override
	public void finish(EventData eventData) {
		destroyAllEventTextdraws(eventData);
		if(eventData.getScoreTimer() != null) {
			if(eventData.getScoreTimer().isRunning()) 
				eventData.getScoreTimer().stop();
			eventData.getScoreTimer().destroy();
			eventData.setScoreTimer(null);
		}
		for(Player all : EventFunctions.getAllPlayers(eventData)) {
			Shoebill.get().runOnSampThread(() -> {
				if(all != null && all.isOnline()) {
					PlayerData playerPlayerData = EventSystem.getInstance().getPlayerLifecycleHolder().getObject(all, PlayerData.class);
					playerPlayerData.setGameTextTD(new GameTextTD(all, localizedStringSet.get(all, "Event.Finish.Gametext"), 7000, true, 1000));
				}
			});
		}
		
		eventData.setDataPlayerArray(new ArrayList<>());
		eventData.setDataPlayerArray2(new ArrayList<>());
	}
	
	/*
	 * (non-Javadoc)
	 * @see me.alf21.eventsystem.Event#destroyEvent(me.alf21.eventsystem.EventData)
	 */
	@Override
	public void destroy(EventData eventData) {
		if(eventData.getScoreTimer() != null) {
			if(eventData.getScoreTimer().isRunning()) 
				eventData.getScoreTimer().stop();
			eventData.getScoreTimer().destroy();
			eventData.setScoreTimer(null);
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see me.alf21.eventsystem.Event#onPlayerExit(net.gtaun.shoebill.object.Player, me.alf21.eventsystem.EventData)
	 */
	@Override
	public void onPlayerExit(Player player, EventData eventData) {
		playerLifecycle = EventSystem.getInstance().getPlayerLifecycleHolder().getObject(player, PlayerData.class);
		if(eventData != null && eventData.getState() == EventState.RUNNING) { //TODO: break during preparation
			if(!eventData.getEventTextdraws().isEmpty()) {
				for(EventTextdraw eventTextdraw : eventData.getEventTextdraws()) {
					eventTextdraw.hide(player);
				}
				if(!eventData.getDataPlayerArray().isEmpty() && eventData.getDataPlayerArray().contains(player)) {
					EventTextdraw eventTextdraw = EventFunctions.getEventTextdraw(eventData, player.getName());
					if(eventTextdraw != null) {
						eventTextdraw.hideForAll();
						eventData.getEventTextdraws().remove(eventTextdraw);
						eventTextdraw.destroy();
						reInitEventTextdraws(eventData);
					}
				}
			}
			if(eventData.getDataPlayerArray2().contains(player)){
				//TODO: pause the event
				if(eventData.getDataPlayerArray2().size() > 1) {
					EventFunctions.getAllPlayers(eventData).stream().filter(all -> all != player).forEach(all -> all.sendMessage(Color.RED, localizedStringSet.format(all, "Event.Class.Catching.Leave.Message", player.getName())));
				}
				else {
					EventFunctions.getAllPlayers(eventData).stream().filter(all -> all != player).forEach(all -> all.sendMessage(Color.RED, localizedStringSet.format(all, "Event.Class.Catching.Leave.Finish", player.getName())));
					EventBase.finishEvent(eventData);
				}
			}
			else {
				if(!eventData.getDataPlayerArray2().isEmpty()) {
					Color color = new Color(0,0,0,0);
					for(Player hunter : eventData.getDataPlayerArray2()) {
						hunter.markerForPlayer(player, color);
					}
				}
				eventData.getDataPlayerArray().remove(player);
				if( eventData.getDataPlayerArray() == null || eventData.getDataPlayerArray().isEmpty()) {
					EventBase.finishEvent(eventData);
				}
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * @see me.alf21.eventsystem.Event#settingsDialog(net.gtaun.shoebill.object.Player, net.gtaun.shoebill.common.dialog.ListDialog)
	 */
	@Override
	public void settingsDialog(Player player, ListDialog settingsDialog) {
		playerLifecycle = EventSystem.getInstance().getPlayerLifecycleHolder().getObject(player, PlayerData.class);
		EventData eventData = playerLifecycle.getCurrentEvent();
		if(eventData != null) {
			if(eventData.getState() == EventState.START) {
				settingsDialog.getItems().add(ListDialogItem.create()
			            .itemText(eventData.getDataPlayerArray2().isEmpty()?"{FF0000}[" + localizedStringSet.get(player, "Dialog.Todo") + "]{FFFFFF} " + localizedStringSet.get(player, "Event.Class.Catching.Catcher.Choose"):"{00FF00}[" + localizedStringSet.get(player, "Dialog.Done") + "]{FFFFFF} " + localizedStringSet.get(player, "Event.Class.Catching.Catcher.Choose") + " (" + eventData.getDataPlayerArray2().size() + ")")
			            .onSelect((listDialogItem, o) -> {
			            	chooseCatcher(eventData);
			            })
			            .build());
				
				settingsDialog.getItems().add(ListDialogItem.create()
			            .itemText(eventData.getDataInt()<0?"{FF0000}[" + localizedStringSet.get(player, "Dialog.Todo") + "]{FFFFFF} " + localizedStringSet.get(player, "Event.Class.Catching.Countdown.Set"):"{00FF00}[" + localizedStringSet.get(player, "Dialog.Done") + "]{FFFFFF} " + localizedStringSet.get(player, "Event.Class.Catching.Countdown.Set") + " (" + eventData.getDataInt() + ")")
			            .onSelect((listDialogItem, o) -> {
		            		InputDialog.create(player, EventSystem.getInstance().getEventManagerInstance())
			            		.caption("{FF8A05}" + localizedStringSet.get(player, "Event.Class.Catching.Countdown.Setting"))
			            		.message(localizedStringSet.get(player, "Event.Class.Catching.Countdown.Input.Message"))
			            		.buttonCancel(localizedStringSet.get(player, "Dialog.Back"))
			            		.buttonOk(localizedStringSet.get(player, "Dialog.Enter"))
			            		.onClickOk((dialog, s) -> {
			            			try {
			            				int input = Integer.parseInt(s);
			            				if(input >= 0) {
					            			eventData.setDataInt(input);
					            			EventBase.settingsDialog(eventData);
			            				}
			            				else {
			            					MsgboxDialog.create(player, EventSystem.getInstance().getEventManagerInstance())
												.caption("{FF8A05}" + localizedStringSet.get(player, "Dialog.Error.Error")) 
												.message("{FF0000}" + localizedStringSet.get(player, "Dialog.Error.PositiveNumbers")) 
												.buttonCancel(localizedStringSet.get(player, "Dialog.Cancel")) 
												.buttonOk(localizedStringSet.get(player, "Dialog.Okay")) 
												.onClickOk((handler) -> dialog.show())
												.onClickCancel((handler) -> dialog.show())
												.build() 
												.show();
			            				}
			            			} catch(Exception e) {
										MsgboxDialog.create(player, EventSystem.getInstance().getEventManagerInstance())
											.caption("{FF8A05}" + localizedStringSet.get(player, "Dialog.Error.Error")) 
											.message("{FF0000}" + localizedStringSet.get(player, "Dialog.Error.Numbers")) 
											.buttonCancel(localizedStringSet.get(player, "Dialog.Cancel")) 
											.buttonOk(localizedStringSet.get(player, "Dialog.Okay")) 
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
			
			settingsDialog.getItems().add(ListDialogItem.create()
		            .itemText(eventData.getMultiplicator()<0?"{FF0000}[" + localizedStringSet.get(player, "Dialog.Todo") + "]{FFFFFF} " + localizedStringSet.get(player, "Event.Class.Catching.Damage.Multiplicator.Name"):"{00FF00}[" + localizedStringSet.get(player, "Dialog.Done") + "]{FFFFFF} " + localizedStringSet.get(player, "Event.Class.Catching.Damage.Multiplicator.Name") + " (x" + eventData.getMultiplicator() + ")")
		            .onSelect((listDialogItem, o) -> {
	            		InputDialog.create(player, EventSystem.getInstance().getEventManagerInstance())
		            		.caption("{FF8A05}" + localizedStringSet.get(player, "Event.Class.Catching.Damage.Multiplicator.Setting"))
		            		.message(localizedStringSet.get(player, "Dialog.Input.Numbers"))
		            		.buttonCancel(localizedStringSet.get(player, "Dialog.Back"))
		            		.buttonOk(localizedStringSet.get(player, "Dialog.Enter"))
		            		.onClickOk((dialog, s) -> {
		            			try {
		            				float input = Float.parseFloat(s);
		            				if(input >= 0) {
				            			eventData.setMultiplicator(input);
				            			EventBase.settingsDialog(eventData);
		            				}
		            				else {
		            					MsgboxDialog.create(eventData.getOwner(), EventSystem.getInstance().getEventManagerInstance())
											.caption("{FF8A05}" + localizedStringSet.get(player, "Dialog.Error.Error")) 
											.message("{FF0000}" + localizedStringSet.get(player, "Dialog.Error.PositiveNumbers")) 
											.buttonCancel(localizedStringSet.get(player, "Dialog.Cancel")) 
											.buttonOk(localizedStringSet.get(player, "Dialog.Okay")) 
											.onClickOk((handler) -> {
							            		try {
							            			EventBase.settingsDialog(eventData);
												} catch (Exception e) {
													System.out.println(e);
													e.printStackTrace();
												}
											})
											.onClickCancel((handler) -> dialog.show())
											.build() 
											.show();
		            				}
		            			} catch(Exception e) {
									MsgboxDialog.create(player, EventSystem.getInstance().getEventManagerInstance())
										.caption("{FF8A05}" + localizedStringSet.get(player, "Dialog.Error.Error")) 
										.message("{FF0000}" + localizedStringSet.get(player, "Dialog.Error.Numbers")) 
										.buttonCancel(localizedStringSet.get(player, "Dialog.Cancel")) 
										.buttonOk(localizedStringSet.get(player, "Dialog.Okay")) 
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
			
			settingsDialog.getItems().add(ListDialogItem.create()
		            .itemText(eventData.isDataBoolean()?"{00FF00}[" + localizedStringSet.get(player, "Dialog.Activated") + "]{FFFFFF} " + localizedStringSet.get(player, "Event.Class.Catching.Catcher.Faster"):"{FF0000}[" + localizedStringSet.get(player, "Dialog.Deactivated") + "]{FFFFFF} " + localizedStringSet.get(player, "Event.Class.Catching.Catcher.Faster"))
		            .onSelect((listDialogItem, o) -> {
		            	eventData.setDataBoolean(!eventData.isDataBoolean());
		            	EventBase.settingsDialog(eventData);
		            })
		            .build());
			
			settingsDialog.getItems().add(ListDialogItem.create()
		            .itemText(eventData.isDataBoolean2()?"{00FF00}[" + localizedStringSet.get(player, "Dialog.Activated") + "]{FFFFFF} " + localizedStringSet.get(player, "Event.Class.Catching.Catcher.Freeze"):"{FF0000}[" + localizedStringSet.get(player, "Dialog.Deactivated") + "]{FFFFFF} " + localizedStringSet.get(player, "Event.Class.Catching.Catcher.Freeze"))
		            .onSelect((listDialogItem, o) -> {
		            	eventData.setDataBoolean2(!eventData.isDataBoolean2());
		            	EventBase.settingsDialog(eventData);
		            })
		            .build());
		}
	}
	
	/**
	 * dialog of choosing a catcher
	 * @param eventData the event
	 */
	private static void chooseCatcher(EventData eventData) {
		Player player = eventData.getOwner();
		ListDialog hunterDialog = ListDialog.create(player, EventSystem.getInstance().getEventManagerInstance())
		        .caption("{FF8A05}" + localizedStringSet.get(player, "Event.Class.Catching.Catcher.Choose"))
		        .buttonOk(localizedStringSet.get(player, "Dialog.Choose"))
		        .buttonCancel(localizedStringSet.get(player, "Dialog.Back")) 
		        .onClickCancel((handler) -> EventBase.settingsDialog(eventData))
		        .build();

		ArrayList<Player> allEventMembers = eventData.getPlayerList().stream().collect(Collectors.toCollection(ArrayList::new));
		allEventMembers.add(player);
		EventFunctions.sortPlayerlist(allEventMembers);
		for (Player pl : allEventMembers) {
			hunterDialog.getItems().add(ListDialogItem.create()
			            .itemText(pl.getName().equals("")?"{FF0000}" + localizedStringSet.get(player, "Dialog.Error.Error"):(eventData.getDataPlayerArray2().contains(pl)?("{00FF00}"+pl.getName()):("{FF0000}"+pl.getName())))
			            .onSelect((listDialogItem2, o2) -> {
		                	String playerString = listDialogItem2.getItemText().split("\\}")[1];
		                	Player target = Player.get(playerString);
		                	if(target != null) {
			                	if(eventData.getDataPlayerArray2().contains(target))
			                		unsetCatcher(eventData, target);
			                	else setCatcher(eventData, target);
		                	}
		            		chooseCatcher(eventData);
			            })
			            .build());
    	}
		hunterDialog.show();
	}

	/*
	 * (non-Javadoc)
	 * @see me.alf21.eventsystem.Event#checkEvent(net.gtaun.shoebill.object.Player)
	 */
	@Override
	public void check(Player player) {
		playerLifecycle = EventSystem.getInstance().getPlayerLifecycleHolder().getObject(player, PlayerData.class);
		EventData eventData = playerLifecycle.getCurrentEvent();
		if(eventData != null) {
			if(eventData.getState() == EventState.RUNNING) {
				if(!eventData.getDataPlayerArray2().isEmpty() && eventData.getDataPlayerArray2().contains(player)) {
					if(eventData.isDataBoolean() && player.getUpdateCount() % 2 == 0) {
						PlayerKeyState keyState = player.getKeyState();
					/*	if(player.getState() == PlayerState.DRIVER) {
							if(keyState.isKeyPressed(PlayerKey.SPRINT) && !keyState.isKeyPressed(PlayerKey.HANDBRAKE)) {
								Catching.setVehicleForwardVelocity(player, 0.25f);
							}
						}
						else */if(player.getState() == PlayerState.ONFOOT){
							if(keyState.isKeyPressed(PlayerKey.SPRINT) && !keyState.isKeyPressed(PlayerKey.JUMP)) {
								Catching.setPlayerForwardVelocity(player, 0.25f, 0.01f);
							}
						}
					}
				}

				//Vehicle Damage Multiplicator System
				if(player.getState() == PlayerState.DRIVER) {
					float 	oldVehicleHealth = playerLifecycle.getVehicleHealth(),
							newVehicleHealth = player.getVehicle().getHealth();
					if(oldVehicleHealth == -1) 
						playerLifecycle.setVehicleHealth(newVehicleHealth);
					float diff = oldVehicleHealth - newVehicleHealth;
					if(diff > 0) {
						float multiplicator = eventData.getMultiplicator();
						if(eventData.getDataPlayerArray2().contains(player)) multiplicator /= 2;
						diff *= multiplicator;
						if(oldVehicleHealth-diff < 250 && oldVehicleHealth >= 250) {
							diff = 0;
							oldVehicleHealth = 249;
						}
						player.getVehicle().setHealth(oldVehicleHealth-diff);
						playerLifecycle.setVehicleHealth(oldVehicleHealth-diff);
					}
				}
				else if(playerLifecycle.getVehicleHealth() > -1) {
					playerLifecycle.setVehicleHealth(-1);
				}
				
				if(player.getUpdateCount() % 5 == 0) { 
					updateBoxColors(player, eventData);
				}
			}
		}
	}
	
	/**
	 * set the speed for a player
	 * @param player the target
	 * @param velocity the speed
	 * @param z the z coordinate
	 */
	public static void setPlayerForwardVelocity(Player player, float velocity, float z) {
		if(player.getVelocity().getX() != 0 && player.getVelocity().getY() != 0 && player.getVelocity().getZ() != 0) {
			playerLifecycle = EventSystem.getInstance().getPlayerLifecycleHolder().getObject(player, PlayerData.class);
			float angle = player.getAngle();
			double speedX, speedY;
			speedX = Math.sin(Math.toRadians(-angle));
			speedY = Math.cos(Math.toRadians(-angle));
			float vz = player.getVelocity().getZ() + z;
			if (vz > 0.04 || vz < -0.04)
				z -= 0.020;
			Velocity newVelocity = new Velocity(velocity*(float)speedX, velocity*(float)speedY, z);
			player.setVelocity(newVelocity);
		}
	}
	
	/**
	 * set the speed of a vehicle
	 * @param player the target
	 * @param velocity the speed
	 */
	public static void setVehicleForwardVelocity(Player player, float velocity) {
		playerLifecycle = EventSystem.getInstance().getPlayerLifecycleHolder().getObject(player, PlayerData.class);
		float 	speedX = player.getVehicle().getVelocity().getX()-playerLifecycle.getVehicleVelocity().getX(),
				speedY = player.getVehicle().getVelocity().getY()-playerLifecycle.getVehicleVelocity().getY(),
				speedZ = player.getVehicle().getVelocity().getZ()-playerLifecycle.getVehicleVelocity().getZ();
		velocity+=1;
		if (speedZ > 0.04 || speedZ < -0.04)
			speedZ -= 0.020;
		playerLifecycle.setVehicleVelocity(new Velocity(velocity* speedX - speedX, velocity* speedY - speedY, speedZ-player.getVehicle().getVelocity().getZ()));
		Velocity newVelocity = new Velocity(velocity* speedX, velocity* speedY, speedZ);
		player.getVehicle().setVelocity(newVelocity);
	}
	
	/**
	 * catch a player
	 * @param player the player / runner
	 * @param hunters the hunter
	 */
	public void catchPlayer(Player player, ArrayList<Player> hunters) {
		playerLifecycle = EventSystem.getInstance().getPlayerLifecycleHolder().getObject(player, PlayerData.class);
		EventData eventData = playerLifecycle.getCurrentEvent();
		if(eventData != null) {
			if(eventData.getDataPlayerArray().contains(player)) {
				if(hunters != null && !hunters.isEmpty()) {
					player.sendGameText(2000, 3, localizedStringSet.get(player, "Event.Class.Catching.Caught"));
					Iterator<Player> i = hunters.iterator();
					while(i.hasNext()) {
						Player hunter = i.next();
						if(hunter.isControllable()) {
							hunter.sendGameText(2000, 3, localizedStringSet.get(hunter, "Event.Class.Catching.Catched.Catched"));
							hunter.sendMessage(Color.YELLOW, localizedStringSet.format(hunter, "Event.Class.Catching.Catched.Player", player.getName()));
							player.sendMessage(Color.YELLOW, localizedStringSet.format(player, "Event.Class.Catching.Catched.Target", hunter.getName()));
							eventData.getPlayerList().stream().filter(member -> member != player && member != hunter).forEach(member -> member.sendMessage(Color.YELLOW, localizedStringSet.format(member, "Event.Class.Catching.Catched.Message", player.getName(), hunter.getName())));
							
							Shoebill.get().runOnSampThread(() -> {
								Color color = getBoxColor(player, hunter, eventData);
								EventTextdraw eventTextdraw = EventFunctions.getEventTextdraw(eventData, player.getName());
								if(eventTextdraw != null) {
									eventTextdraw.setColor(color);
									for(Player all : EventFunctions.getAllPlayers(eventData)) {
										eventTextdraw.hide(all);
										eventTextdraw.show(all);
									}
								}
							});
							
							i.remove();
							if(eventData.getDataPlayerArray() == null || eventData.getDataPlayerArray().isEmpty())
								EventBase.finishEvent(eventData);
						}
					}
				}
			}
		}
	}
	
	/**
	 * set a catcher
	 * @param eventData the event
	 * @param target the target who need to be setted as catcher
	 */
	private static void setCatcher(EventData eventData, Player target) {
		eventData.getDataPlayerArray2().add(target);
	}
	
	/**
	 * unset a catcher
	 * @param eventData the event
	 * @param target the target who need to not be setted as catcher
	 */
	private static void unsetCatcher(EventData eventData, Player target) {
		eventData.getDataPlayerArray2().remove(target);
	}
	
	/**
	 * initialize the catcher
	 * @param eventData the event
	 */
	private void initCatcher(EventData eventData) {
		if(!eventData.getDataPlayerArray2().isEmpty()) {
			Color color = new Color(0,0,0,0);
			for(Player target : eventData.getDataPlayerArray2()) {
				target.sendMessage(Color.YELLOW, localizedStringSet.get(target, "Event.Class.Catching.Catcher.New"));
				eventData.getDataPlayerArray().stream().filter(member -> member != target).forEach(member -> {
					if (!eventData.getDataPlayerArray2().contains(member)) {
						target.markerForPlayer(member, Color.RED);
						member.markerForPlayer(target, color);
					} else target.markerForPlayer(member, Color.GREEN);
				});
				if(target != eventData.getOwner()) {
					if(!eventData.getDataPlayerArray2().contains(eventData.getOwner())) {
						target.markerForPlayer(eventData.getOwner(), Color.RED);
						eventData.getOwner().markerForPlayer(target, color);
					}
					else target.markerForPlayer(eventData.getOwner(), Color.GREEN);
				}
			}

			for(Player player : EventFunctions.getAllPlayers(eventData)) {
				player.sendMessage(Color.YELLOW, localizedStringSet.format(player, "Event.Class.Catching.Catcher.Message", EventFunctions.arrayToString(eventData.getDataPlayerArray2())));
				player.setColor(color);
			}
		}
	}
	
	/**
	 * initialize the event
	 * @param eventData the event
	 */
	private void initEvent(EventData eventData) {
		if(!eventData.getDataPlayerArray2().isEmpty()) {
			eventData.setTime(0);
			Timer scoreTimer = Timer.create(1000, (factualInterval) -> {
				for(Player runner : eventData.getDataPlayerArray()) {
					PlayerData runnerLifecycle = EventSystem.getInstance().getPlayerLifecycleHolder().getObject(runner, PlayerData.class);
					runnerLifecycle.setEventScore(runnerLifecycle.getEventScore()+1);
				}
			});
			eventData.setScoreTimer(scoreTimer);
			
			int counter = eventData.getDataInt();
			for(Player hunter : eventData.getDataPlayerArray2()) {
				hunter.toggleControllable(false);
			}
			for(Player player : eventData.getPlayerList()){
				player.sendGameText(1000, 3, counter==0?"- " + localizedStringSet.get(player, "Event.Start.Start").toUpperCase() + " -":"- " + counter + " -");
			}
			eventData.getOwner().sendGameText(1000, 3, counter==0?"- " + localizedStringSet.get(eventData.getOwner(), "Event.Start.Start").toUpperCase() + " -":"- " + counter + " -");
			counter--;
			if(counter >= 0) {
				eventData.setCount(counter);
				Timer timer = Timer.create(1000, counter+1, (factualInterval) -> {
					if(eventData.getGameTimer() != null) 
						eventData.getGameTimer().stop();
					int count = eventData.getCount();
					for (Player player : eventData.getPlayerList()){
						player.sendGameText(1000, 3, count==0?"- " + localizedStringSet.get(player, "Event.Start.Start").toUpperCase() + " -":"- " + count + " -");
					}
					eventData.getOwner().sendGameText(1000, 3, count==0?"- " + localizedStringSet.get(eventData.getOwner(), "Event.Start.Start").toUpperCase() + " -":"- " + count + " -");
					if(count == 0) {
						for(Player hunter : eventData.getDataPlayerArray2()) {
							hunter.toggleControllable(true);
						}
						eventData.getScoreTimer().start();
						if(eventData.getGameTimer() != null) 
							eventData.getGameTimer().start();
					}
					eventData.setCount(count-1);
				});
				eventData.setCountdownTimer(timer);
				timer.start();
			}
			else {
				for(Player hunter : eventData.getDataPlayerArray2()) {
					hunter.toggleControllable(true);
				}
				eventData.getScoreTimer().start();
			}
			for(Player runner : eventData.getDataPlayerArray()) {
				playerLifecycle = EventSystem.getInstance().getPlayerLifecycleHolder().getObject(runner, PlayerData.class);
				EventTextdraw eventTextdraw = new EventTextdraw(runner.getName(), eventData.getEventTextdraws().size(), "runner", playerLifecycle.getEventScore());
				Color color = getBoxColor(runner, getNearestHunter(runner, eventData), eventData);
				eventTextdraw.setColor(color);
				EventFunctions.getAllPlayers(eventData).forEach(eventTextdraw::show);
				eventData.getEventTextdraws().add(eventTextdraw);
			}
		}
	}
	
	/**
	 * update the boxcolors from the event textdraws
	 * @param eventData the event
	 */
	private static void updateBoxColors(Player player, EventData eventData) {
		if(!eventData.getEventTextdraws().isEmpty()) {
			Shoebill.get().runOnSampThread(() -> {
				for(Player runner : eventData.getDataPlayerArray()) {
					Color color = getBoxColor(runner, getNearestHunter(runner, eventData), eventData);
					EventTextdraw eventTextdraw = EventFunctions.getEventTextdraw(eventData, runner.getName());
					if (eventTextdraw != null) {
						eventTextdraw.setColor(color);
						for(Player all : EventFunctions.getAllPlayers(eventData)) {
							eventTextdraw.hide(all);
							eventTextdraw.show(all);
						}
					}
				}
			});
		}
	}
	
	/**
	 * reinitialize the textdraws and its position of an event
	 * @param eventData the event
	 */
	private static void reInitEventTextdraws(EventData eventData) {
		int i = 0;
		for(EventTextdraw eventTextdraw : eventData.getEventTextdraws()) {
			eventTextdraw.move(i);
			try { //TODO vllt erst am ende fuer alle
				((Event) eventData.getClz().newInstance()).updateTextdraws(eventData);
			} catch (Exception e) {
				System.out.println(e);
				e.printStackTrace();
			}
			i++;
		}
	}
	
	/**
	 * destroys all textdraws of an event
	 * @param eventData the event
	 */
	private static void destroyAllEventTextdraws(EventData eventData) {
		for(EventTextdraw eventTextdraw : eventData.getEventTextdraws()) {
			eventTextdraw.hideForAll();
			eventTextdraw.destroy();
		}
		eventData.getEventTextdraws().clear();
	}
	
	/**
	 * get the nearest hunter of a runner
	 * @param runner the runner
	 * @param eventData the event
	 * @return Player
	 */
	private static Player getNearestHunter(Player runner, EventData eventData) {
		Player nearestHunter = null;
		float min = -1;
		float range;
		Location location = runner.getLocation();
		for(Player hunter : eventData.getDataPlayerArray2()) {
			range = hunter.getLocation().distance(location);
			if(min == -1 || range < min) {
				min = range;
				nearestHunter = hunter;
			}
		}
		return nearestHunter;
	}
	
	/**
	 * get defined color of the box depends on the near of both players
	 * @param runner the runner
	 * @param hunter the hunter
	 * @return Color
	 */
	private static Color getBoxColor(Player runner, Player hunter, EventData eventData) {
		Color color;
		if(eventData.getDataPlayerArray().contains(runner)) {
			if(EventFunctions.isInRadius(runner, hunter, 10)) {
				color = new Color(218, 5, 5, 102); //red
			}
			else if(EventFunctions.isInRadius(runner, hunter, 20)) {
				color = new Color(218, 172, 5, 102); //orange
			}
			else {
				color = new Color(5, 218, 9, 102); //green
			}
		}
		else {
			color = new Color(2, 2, 2, 102); //gray
		}
		return color;
	}

	/*
	 * (non-Javadoc)
	 * @see me.alf21.eventsystem.Event#isAbleToStart(me.alf21.eventsystem.EventData)
	 */
	@Override
	public boolean isAbleToStart(EventData eventData) {
		return !(eventData.getDataPlayerArray2().isEmpty()
				|| isCatchableArrayEmpty(eventData));
	}

	/*
	 * (non-Javadoc)
	 * @see me.alf21.eventsystem.Event#onStartFailed(me.alf21.eventsystem.EventData)
	 */
	@Override
	public void onStartFailed(EventData eventData) {
		if(eventData.getDataPlayerArray2().isEmpty())
			eventData.getOwner().sendMessage(Color.YELLOW, localizedStringSet.get(eventData.getOwner(), "Event.Class.Catching.Error.NoHunters"));
		else if(isCatchableArrayEmpty(eventData)) 
			eventData.getOwner().sendMessage(Color.YELLOW, localizedStringSet.get(eventData.getOwner(), "Event.Class.Catching.Error.NoRunners"));
	}

	/*
	 * (non-Javadoc)
	 * @see me.alf21.eventsystem.Event#addToDialog(net.gtaun.shoebill.object.Player, net.gtaun.shoebill.common.dialog.ListDialog)
	 */
	@Override
	public void addToDialog(Player player, ListDialog dialog) {
		playerLifecycle = EventSystem.getInstance().getPlayerLifecycleHolder().getObject(player, PlayerData.class);
		EventData eventData = playerLifecycle.getCurrentEvent();
		if(eventData != null) {
			if(eventData.getState() == EventState.RUNNING) { 
				dialog.getItems().add(ListDialogItem.create()
			            .itemText(localizedStringSet.get(player, "Event.Class.Catching.Catchinglist.Catchinglist"))
			            .onSelect((listDialogItem, o) -> {
		            		ListDialog catchDialog = ListDialog.create(player, EventSystem.getInstance().getEventManagerInstance())
							        .caption("{FF8A05}" + localizedStringSet.format(player, "Event.Class.Catching.Catcher.CatchedByHunters", EventFunctions.arrayToString(eventData.getDataPlayerArray2())))
							        .buttonOk(localizedStringSet.get(player, "Dialog.Okay"))
							        .buttonCancel(localizedStringSet.get(player, "Dialog.Back")) 
							        .onClickCancel((handler) -> EventBase.eventDialog(player))
							        .build();
		            	
		            		ArrayList<Player> eventDataPlayerArray = eventData.getDataPlayerArray();
		            		EventFunctions.sortPlayerlist(eventDataPlayerArray);
		            		if(!eventDataPlayerArray.isEmpty()) {
			            		for (Player pl : eventDataPlayerArray) {
			            			catchDialog.getItems().add(ListDialogItem.create()
									            .itemText(((pl.getName().equals("")) ? ("") : (pl.getName())))
									            .onSelect((listDialogItem2, o2) -> {
											    	EventBase.eventDialog(player);
									            })
									            .build());
			                	}
			            		catchDialog.show();
		            		}
		            		else {
		            			MsgboxDialog.create(player, EventSystem.getInstance().getEventManagerInstance())
								.caption("{FF8A05}" + localizedStringSet.get(player, "Event.Class.Catching.Finish.Finished")) 
			                    .message("{FF0000}" + localizedStringSet.format(player, "Event.Class.Catching.Finish.Message", EventFunctions.arrayToString(eventData.getDataPlayerArray2()))) 
			                    .buttonOk(localizedStringSet.get(player, "Dialog.Okay")) 
			                    .buttonCancel(localizedStringSet.get(player, "Dialog.Back")) 
			                    .onClickOk((handler) -> EventBase.eventDialog(player))
			                    .onClickCancel((handler) -> EventBase.eventDialog(player))
			                    .build() 
			                    .show();
		            		}
			            })
				        .build());
			}
		}
	}
	
	/**
	 * checks if a player is able to catch
	 * @param player who needs to be checked
	 * @param eventData current event
	 * @return boolean
	 */
	public boolean isCatching(Player player, EventData eventData) {
		for(Player pl : eventData.getDataPlayerArray()) {
			if(pl == player)
				return true;
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * @see me.alf21.eventsystem.Event#getAbilityToStart(me.alf21.eventsystem.EventData)
	 */
	@Override
	public int getAbilityToStart(EventData eventData) {
		int state;
		if(eventData.getDataPlayerArray2().isEmpty()
		|| isCatchableArrayEmpty(eventData)) 
			return 0;
		else state = 1;
		if(eventData.getDataInt() == -1) state = -1;
		return state;
	}

	/*
	 * (non-Javadoc)
	 * @see me.alf21.eventsystem.Event#onPlayerDeath(net.gtaun.shoebill.object.Player)
	 */
	@Override
	public void onPlayerDeath(Player player) {
		playerLifecycle = EventSystem.getInstance().getPlayerLifecycleHolder().getObject(player, PlayerData.class);
		EventData eventData = playerLifecycle.getCurrentEvent();
		if(eventData != null && eventData.getState() == EventState.RUNNING) {
			if(isCatching(player, eventData)) {
				catchPlayer(player, eventData.getDataPlayerArray2());
			}
		}
	}
	
	/**
	 * checks if there are catchable players
	 * @param eventData the event
	 * @return boolean
	 */
	private static boolean isCatchableArrayEmpty(EventData eventData) {
		return eventData.getPlayerList().size()+1-eventData.getDataPlayerArray2().size()<=0;
	}
	
	/*
	 * (non-Javadoc)
	 * @see me.alf21.eventsystem.Event#onPlayerWeaponShot(net.gtaun.shoebill.event.player.PlayerWeaponShotEvent)
	 */
	@Override
	public void onPlayerWeaponShot(PlayerWeaponShotEvent e) {
		Player player = e.getPlayer();
		playerLifecycle = EventSystem.getInstance().getPlayerLifecycleHolder().getObject(player, PlayerData.class);
		EventData eventData = playerLifecycle.getCurrentEvent();
		if(eventData != null) {
			if(eventData.getState() == EventState.RUNNING) {
				if(eventData.isDataBoolean2()) {
					if(e.getHitType() == BulletHitType.PLAYER) {
						if(!eventData.getDataPlayerArray2().contains(player) && eventData.getDataPlayerArray().contains(player)) {
							final Player hittedPlayer = e.getHitPlayer();
							if(eventData.getDataPlayerArray2().contains(hittedPlayer) && hittedPlayer.isControllable()) { //TODO togglable teamdamage
								hittedPlayer.toggleControllable(false);
								Timer timer = Timer.create(1000, 1, (factualInterval) -> { //TODO: einstellbare freezedauer
									if(hittedPlayer.isOnline())
										hittedPlayer.toggleControllable(true);
									eventData.getTimerReferences().clear();
								});
								timer.start();
								eventData.getTimerReferences().add(timer);
							}
						}
					}
				}
			}
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see me.alf21.eventsystem.Event#onPlayerTakeDamage(net.gtaun.shoebill.event.player.PlayerTakeDamageEvent)
	 */
	@Override
	public void onPlayerTakeDamage(PlayerTakeDamageEvent e) {
		Player player = e.getPlayer();
		playerLifecycle = EventSystem.getInstance().getPlayerLifecycleHolder().getObject(player, PlayerData.class);
		EventData eventData = playerLifecycle.getCurrentEvent();
		if(eventData != null && eventData.getState() == EventState.RUNNING) {
			if(!eventData.getDataPlayerArray2().isEmpty() && !eventData.getDataPlayerArray2().contains(player)
			&& !eventData.getDataPlayerArray().isEmpty() && eventData.getDataPlayerArray().contains(player)) {
				if(EventFunctions.isInRadius(player, e.getIssuer(), 1.5f)) {
					ArrayList<Player> arrayList = new ArrayList<>();
					arrayList.add(e.getIssuer());
					catchPlayer(player, arrayList);
				}
			}
			else if(!eventData.getDataPlayerArray2().isEmpty() && eventData.getDataPlayerArray2().contains(player) //No hunter damage and TODO no teamdamage
				 || !eventData.getDataPlayerArray().isEmpty() && eventData.getDataPlayerArray().contains(player) && eventData.getDataPlayerArray().contains(e.getIssuer())){
				player.setHealth(player.getHealth()+e.getAmount());
			}
		}
	}
	
	//TODO: vllt nicht ueber EventResult sondern addToFinalResults(MsgBoxDialog msgbox) und dann text zu adden
	/*
	 * (non-Javadoc)
	 * @see me.alf21.eventsystem.Event#getWinner(me.alf21.eventsystem.EventData)
	 */
	@Override
	public String[] getWinner(EventData eventData) {
		String[] winners;
		if(eventData.getDataPlayerArray().isEmpty()) {
			winners = new String[eventData.getDataPlayerArray2().size()];
			int i = 0;
			for(Player hunters : eventData.getDataPlayerArray2()) {
				winners[i] = hunters.getName();
				i++;
			}
		}
		else {
			int i = 0;
			winners = new String[EventFunctions.getAllPlayers(eventData).size()];
			for(Player player : EventFunctions.getAllPlayers(eventData)) {
				if(!eventData.getDataPlayerArray2().contains(player)){
					winners[i] = player.getName();
					i++;
				}
			}
		}
		return winners;
	}
}
