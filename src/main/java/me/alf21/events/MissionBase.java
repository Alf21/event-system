/**
 * @author Alf21 on 21.01.2016 in project event-system.
 * Copyright (c) 2015 Alf21. All rights reserved.
 */
package me.alf21.events;

import net.gtaun.shoebill.common.dialog.ListDialog;
import net.gtaun.shoebill.common.dialog.ListDialogItem;
import net.gtaun.shoebill.common.dialog.MsgboxDialog;
import net.gtaun.shoebill.object.Player;
import net.gtaun.wl.lang.LocalizedStringSet;
import me.alf21.events.mission.util.Mission;
import me.alf21.events.mission.util.MissionDescription;
import me.alf21.events.mission.util.MissionFunctions;
import me.alf21.eventsystem.Event;
import me.alf21.eventsystem.EventBase;
import me.alf21.eventsystem.EventData;
import me.alf21.eventsystem.EventDescription;
import me.alf21.eventsystem.EventExtensibleDependencies;
import me.alf21.eventsystem.EventFunctions;
import me.alf21.eventsystem.EventSystem;
import me.alf21.eventsystem.PlayerData;

/**
 * @author Alf21
 */
@EventDescription(name = "Missions", playerValueMin = 1, credits = "Alf21") //TODO 1 player available !
public class MissionBase extends Event {
	
	public static PlayerData playerLifecycle;
    private static LocalizedStringSet localizedStringSet = EventSystem.getInstance().getLocalizedStringSet();

	public MissionBase() {
		super();
	}
	
	/* (non-Javadoc)
	 * @see me.alf21.eventsystem.Event#addToDialog(net.gtaun.shoebill.object.Player, net.gtaun.shoebill.common.dialog.ListDialog)
	 */
	@Override
	public void addToDialog(Player player, ListDialog dialog) {
		EventData eventData = EventBase.getEvent(player);
		
		try {
			if (eventData != null && eventData.getMission() != null) {
				((Mission) eventData.getMission().newInstance()).addToDialog(player, dialog);
			}
		} catch (InstantiationException | IllegalAccessException e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}
	
	/**
	 * load a mission
	 * @param eventData the event
	 * @param clz the class of mission
	 */
	private static void loadMission(EventData eventData, Class<?> clz) {
		try {
			unloadMission(eventData);
			eventData.setMission(clz);
			((Mission) clz.newInstance()).create(eventData);
			MissionDescription missionDescription = MissionFunctions.getDescriptionForMission(clz);
			if (missionDescription != null) {
				for (Player player : EventFunctions.getAllPlayers(eventData)) {
					player.sendMessage(localizedStringSet.format(player, "Event.Class.Missions.Create.CreatedMessage", MissionFunctions.getName(player, missionDescription.name())));
				}
			}
		} catch (InstantiationException | IllegalAccessException e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}
	
	/**
	 * unload a mission
	 * @param eventData the event
	 */
	private static void unloadMission(EventData eventData) {
		try {
			if(eventData.getMission() != null) {
				Class<?> oldMission = eventData.getMission();
				((Mission) oldMission.newInstance()).destroy(eventData);
				eventData.setMission(null);
				MissionDescription missionDescription = MissionFunctions.getDescriptionForMission(oldMission);
				if (missionDescription != null) {
					for (Player player : EventFunctions.getAllPlayers(eventData)) {
						player.sendMessage(localizedStringSet.format(player, "Event.Class.Missions.Destroy.DestroyedMessage", MissionFunctions.getName(player, missionDescription.name())));
					}
				}
			}
		} catch (InstantiationException | IllegalAccessException e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}
	
	/* (non-Javadoc)
	 * @see me.alf21.eventsystem.Event#destroy(me.alf21.eventsystem.EventData)
	 */
	@Override
	public void destroy(EventData eventData) {
		if(eventData.getMission() != null) {
			unloadMission(eventData);
		}
	}
	
	/* (non-Javadoc)
	 * @see me.alf21.eventsystem.Event#settingsDialog(net.gtaun.shoebill.object.Player, net.gtaun.shoebill.common.dialog.ListDialog)
	 */
	@Override
	public void settingsDialog(Player player, ListDialog settingsDialog) {
		EventData eventData = EventBase.getEvent(player);

		if (eventData != null && !EventExtensibleDependencies.getAvailableMissions().isEmpty() && (eventData.getMission() != null && EventExtensibleDependencies.getAvailableMissions().size() - 1 > 0 || eventData.getMission() == null)) {
			settingsDialog.getItems().add(ListDialogItem.create()
					.itemText(eventData.getMission() == null ? "{FF0000}[" + localizedStringSet.get(player, "Dialog.Todo") + "]{FFFFFF} " + localizedStringSet.get(player, "Event.Class.Missions.Choose.ChooseMission") : "{00FF00}[" + localizedStringSet.get(player, "Dialog.Done") + "]{FFFFFF} " + localizedStringSet.get(player, "Event.Class.Missions.Choose.ChooseMission") + " (" + eventData.getMission().getName() + ")")
					.onSelect((listDialogItem, o) -> {
						//TODO multi column to see whetehr event is singleplayer or multiplayer or min player amount
						ListDialog availableMissions = ListDialog.create(player, EventSystem.getInstance().getEventManagerInstance())
								.caption("{FF8A05}" + localizedStringSet.get(player, "Event.Class.Missions.Choose.Caption"))
								.buttonOk(localizedStringSet.get(player, "Dialog.Choose"))
								.buttonCancel(localizedStringSet.get(player, "Dialog.Back"))
								.onClickCancel((handler) -> EventBase.settingsDialog(eventData))
								.build();
						for (Class<?> clz : EventExtensibleDependencies.getAvailableMissions()) {
							if (eventData.getMission() != null && eventData.getMission() == clz)
								continue;
							try {
								MissionDescription missionDescription = MissionFunctions.getDescriptionForMission(clz);
								assert missionDescription != null;
								String name = MissionFunctions.getName(player, missionDescription.name());
								availableMissions.getItems().add(ListDialogItem.create()
										.itemText(name)
										.onSelect((listDialogItem2, o2) -> {
											MissionDescription description = MissionFunctions.getDescriptionForMission(getMissionClass(player, listDialogItem2.getItemText()));
											assert description != null;
											String message = "{FFFF00}" + localizedStringSet.get(player, "Description") + ":{FFFFFF}\n" + MissionFunctions.getDescription(player, description.name());
											if (description.playerValueMin() != -1)
												message += "\n{FFFF00}" + localizedStringSet.get(player, "MinPlayers") + ": {FFFFFF}" + description.playerValueMin();
											if (description.playerValueMax() != -1)
												message += "\n{FFFF00}" + localizedStringSet.get(player, "MaxPlayers") + ": {FFFFFF}" + description.playerValueMax();
											message += "\n{FFFF00}" + localizedStringSet.get(player, "Credits") + ": {FFFFFF}" + description.credits() +
													"\n\n{FF0000}" + localizedStringSet.get(player, "Event.Class.Missions.Create.Question");

											MsgboxDialog.create(player, EventSystem.getInstance().getEventManagerInstance())
													.caption("{FF8A05}" + localizedStringSet.get(player, "Event.Class.Missions.Choose.Caption"))
													.message(message)
													.buttonCancel(localizedStringSet.get(player, "Dialog.Cancel"))
													.buttonOk(localizedStringSet.get(player, "Dialog.Okay"))
													.onClickOk((handler) -> {
														loadMission(eventData, clz);
														EventBase.settingsDialog(eventData);
													})
													.onClickCancel((handler) -> availableMissions.show())
													.build()
													.show();
										})
										.build());
							} catch (Exception e) {
								System.out.println(e);
								e.printStackTrace();
							}
						}
						availableMissions.show();
					})
					.build());
		}

		try {
			if (eventData != null && eventData.getMission() != null) {
				((Mission) eventData.getMission().newInstance()).settingsDialog(player, settingsDialog);
			}
		} catch (InstantiationException | IllegalAccessException e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}
	
	/* (non-Javadoc)
	 * @see me.alf21.eventsystem.Event#isAbleToStart(me.alf21.eventsystem.EventData)
	 */
	@Override
	public boolean isAbleToStart(EventData eventData) {
		if(eventData.getMission() == null) 
			return false;
		else {
			MissionDescription missionDescription = MissionFunctions.getDescriptionForMission(eventData.getMission());
			if (missionDescription != null && (missionDescription.playerValueMin() > eventData.getPlayerList().size() + 1 && missionDescription.playerValueMin() != -1
					|| missionDescription.playerValueMax() < eventData.getPlayerList().size() + 1 && missionDescription.playerValueMax() != -1))
				return false;
		}
		try {
			if(eventData.getMission() != null) {
				return ((Mission) eventData.getMission().newInstance()).isAbleToStart(eventData);
			}
		} catch (InstantiationException | IllegalAccessException e) {
			System.out.println(e);
			e.printStackTrace();
		}
		return true;
	}
	
	/* (non-Javadoc)
	 * @see me.alf21.eventsystem.Event#getAbilityToStart(me.alf21.eventsystem.EventData)
	 */
	@Override
	public int getAbilityToStart(EventData eventData) {
		int i = 1;
		if(eventData.getMission() == null) 
			return 0;
		try {
			int i2 = ((Mission) eventData.getMission().newInstance()).getAbilityToStart(eventData);
			if(i2 == 0)
				return 0;
			else if(i2 == -1) 
				i = -1;
			MissionDescription missionDescription = MissionFunctions.getDescriptionForMission(eventData.getMission());
			if (missionDescription != null && (missionDescription.playerValueMin() > eventData.getPlayerList().size() + 1 && missionDescription.playerValueMin() != -1
					|| missionDescription.playerValueMax() < eventData.getPlayerList().size() + 1 && missionDescription.playerValueMax() != -1))
				return 0;
		} catch (InstantiationException | IllegalAccessException e) {
			System.out.println(e);
			e.printStackTrace();
		}
		return i;
	}
	
	/* (non-Javadoc)
	 * @see me.alf21.eventsystem.Event#onStartFailed(me.alf21.eventsystem.EventData)
	 */
	@Override
	public void onStartFailed(EventData eventData) {
		Player player = eventData.getOwner();
		if(eventData.getMission() == null) {
			MsgboxDialog.create(player, EventSystem.getInstance().getEventManagerInstance())
				.caption("{FF8A05}" + localizedStringSet.get(player, "Event.Class.Missions.Start.Failed.NoMission.Caption")) 
		        .message("{FF0000}" + localizedStringSet.get(player, "Event.Class.Missions.Start.Failed.NoMission.Message")) 
		        .buttonCancel(localizedStringSet.get(player, "Dialog.Cancel")) 
		        .buttonOk(localizedStringSet.get(player, "Dialog.Okay")) 
		        .onClickOk((handler) -> EventBase.eventDialog(player))
		        .onClickCancel((handler) -> EventBase.eventDialog(player))
		        .build() 
		        .show();
		}
		else {
			MissionDescription missionDescription = MissionFunctions.getDescriptionForMission(eventData.getMission());
			if (missionDescription != null) {
				if(missionDescription.playerValueMin() > eventData.getPlayerList().size()+1 && missionDescription.playerValueMin() != -1) {
					MsgboxDialog.create(player, EventSystem.getInstance().getEventManagerInstance())
						.caption("{FF8A05}" + localizedStringSet.get(player, "Event.Member.Memberlist"))
			            .message("{FF0000}" + localizedStringSet.get(player, "Event.Member.NotEnoughMembers"))
			            .buttonCancel(localizedStringSet.get(player, "Dialog.Cancel"))
			            .buttonOk(localizedStringSet.get(player, "Dialog.Okay"))
			            .onClickOk((handler) -> EventBase.eventDialog(player))
			            .onClickCancel((handler) -> EventBase.eventDialog(player))
			            .build()
			            .show();
				}
				else if(missionDescription.playerValueMax() < eventData.getPlayerList().size()+1 && missionDescription.playerValueMax() != -1) {
					MsgboxDialog.create(player, EventSystem.getInstance().getEventManagerInstance())
						.caption("{FF8A05}" + localizedStringSet.get(player, "Event.Member.Memberlist"))
			            .message("{FF0000}" + localizedStringSet.get(player, "Event.Member.TooManyMembers"))
			            .buttonCancel(localizedStringSet.get(player, "Dialog.Cancel"))
			            .buttonOk(localizedStringSet.get(player, "Dialog.Okay"))
			            .onClickOk((handler) -> EventBase.eventDialog(player))
			            .onClickCancel((handler) -> EventBase.eventDialog(player))
			            .build()
			            .show();
				}
			}

			try {
				if(eventData.getMission() != null) {
					((Mission) eventData.getMission().newInstance()).onStartFailed(eventData);
				}
			} catch (InstantiationException | IllegalAccessException e) {
				System.out.println(e);
				e.printStackTrace();
			}
		}
	}
	
	/* (non-Javadoc)
	 * @see me.alf21.eventsystem.Event#start(me.alf21.eventsystem.EventData)
	 */
	@Override
	public void start(EventData eventData) {
		try {
			if(eventData.getMission() != null) {
				((Mission) eventData.getMission().newInstance()).start(eventData);
			}
		} catch (InstantiationException | IllegalAccessException e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}
	
	/* (non-Javadoc)
	 * @see me.alf21.eventsystem.Event#finish(me.alf21.eventsystem.EventData)
	 */
	@Override
	public void finish(EventData eventData) {
		try {
			if(eventData.getMission() != null) {
				((Mission) eventData.getMission().newInstance()).finish(eventData);
			}
		} catch (InstantiationException | IllegalAccessException e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}
	
	/* (non-Javadoc)
	 * @see me.alf21.eventsystem.Event#onPlayerExit(net.gtaun.shoebill.object.Player, me.alf21.eventsystem.EventData)
	 */
	@Override
	public void onPlayerExit(Player player, EventData eventData) {
		try {
			if(eventData.getMission() != null) {
				((Mission) eventData.getMission().newInstance()).onPlayerExit(player, eventData);
			}
		} catch (InstantiationException | IllegalAccessException e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}
	
	/**
	 * get the mission class from description
	 * @param player the player to get language file of
	 * @param string the description
	 * @return Class
	 */
	private static Class<?> getMissionClass(Player player, String string) {
		for(Class<?> eventClz : EventExtensibleDependencies.getAvailableMissions()) {
			MissionDescription missionDescription = MissionFunctions.getDescriptionForMission(eventClz);
			if (missionDescription != null) {
				String name = MissionFunctions.getName(player, missionDescription.name());
				if (name.equals(string))
					return eventClz;
			}
		}
		return null;
	}
}
