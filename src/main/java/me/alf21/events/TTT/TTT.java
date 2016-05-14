/**
 * @author Alf21 on 18.12.2015 in project event-system.
 * Copyright (c) 2015 Alf21. All rights reserved.
 */

package me.alf21.events.TTT;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import net.gtaun.shoebill.common.dialog.InputDialog;
import net.gtaun.shoebill.common.dialog.ListDialog;
import net.gtaun.shoebill.common.dialog.ListDialogItem;
import net.gtaun.shoebill.common.dialog.MsgboxDialog;
import net.gtaun.shoebill.constant.PlayerKey;
import net.gtaun.shoebill.constant.SpectateMode;
import net.gtaun.shoebill.constant.TextDrawAlign;
import net.gtaun.shoebill.constant.TextDrawFont;
import net.gtaun.shoebill.constant.WeaponModel;
import net.gtaun.shoebill.data.Color;
import net.gtaun.shoebill.data.Location;
import net.gtaun.shoebill.data.WeaponData;
import net.gtaun.shoebill.event.player.PlayerKeyStateChangeEvent;
import net.gtaun.shoebill.event.player.PlayerTakeDamageEvent;
import net.gtaun.shoebill.object.Player;
import net.gtaun.shoebill.object.Textdraw;
import net.gtaun.shoebill.object.Timer;
import net.gtaun.shoebill.object.Zone;
import net.gtaun.wl.lang.LocalizedStringSet;
import me.alf21.eventsystem.Event;
import me.alf21.eventsystem.EventBase;
import me.alf21.eventsystem.EventData;
import me.alf21.eventsystem.EventDescription;
import me.alf21.eventsystem.EventFunctions;
import me.alf21.eventsystem.EventMapBase;
import me.alf21.eventsystem.EventState;
import me.alf21.eventsystem.EventSystem;
import me.alf21.eventsystem.EventTextdraw;
import me.alf21.eventsystem.PlayerData;
import me.alf21.util.GameTextTD;
import me.alf21.util.RangeLabel;
import me.alf21.util.TTTDeadBody;

@EventDescription(name = "TTT", playerValueMin = 2, credits = "Programmer and idea: Alf21\n\tGameplayinformations: B4zing4 and Hende")
public class TTT extends Event {
	
	public static PlayerData playerLifecycle;
    private static LocalizedStringSet localizedStringSet = EventSystem.getInstance().getLocalizedStringSet();
	private static Textdraw tDTraitor;
	private static Textdraw tDInnocent;
	private static Textdraw countdownTextdraw;
	private static Zone mapTextdraw;
	
	public TTT() {
		super();
	}
	
	/*
	 * (non-Javadoc)
	 * @see me.alf21.eventsystem.Event#onPlayerDeath(net.gtaun.shoebill.object.Player)
	 */
	@Override
	public void onPlayerDeath(Player player) {
		playerLifecycle = EventSystem.getInstance().getPlayerLifecycleHolder().getObject(player, PlayerData.class);
		EventData eventData = playerLifecycle.getCurrentEvent();
		if(eventData.getState() == EventState.RUNNING) {
			player.sendMessage(Color.YELLOW, "[" + localizedStringSet.get(player, "Event.Class.TTT.Abbr") + "] " + Color.WHITE.toEmbeddingString() + localizedStringSet.get(player, "Event.Class.TTT.Death.Disqualified"));
			if(eventData.getDataPlayerArray().contains(player)) {
				eventData.getDataPlayerArray().remove(player);
				tDInnocent.hide(player);
			}
			else if(eventData.getDataPlayerArray2().contains(player)){
				eventData.getDataPlayerArray2().remove(player);
				tDTraitor.hide(player);
			}
			
			TTTDeadBody deadBody = new TTTDeadBody(eventData, player);
			eventData.getDeadBodies().add(deadBody);
			
			eventData.getSpectators().add(player);
			checkFinish(eventData);
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see me.alf21.eventsystem.Event#onPlayerSpawn(net.gtaun.shoebill.object.Player)
	 */
	@Override
	public void onPlayerSpawn(Player player) {
		playerLifecycle = EventSystem.getInstance().getPlayerLifecycleHolder().getObject(player, PlayerData.class);
		EventData eventData = playerLifecycle.getCurrentEvent();
		if(!checkFinish(eventData)) {
			player.toggleControllable(false);
			player.toggleSpectating(true);
			player.spectate(player, SpectateMode.NORMAL);
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see me.alf21.eventsystem.Event#dependsOnMaps()
	 */
	@Override
	public boolean dependsOnMaps() {
		return true;
	}
	
	/*
	 * (non-Javadoc)
	 * @see me.alf21.eventsystem.Event#updateTextdraws(me.alf21.eventsystem.EventData)
	 */
	@Override
	public void updateTextdraws(EventData eventData) {
		if(eventData != null) {
			for(Player all : EventFunctions.getAllPlayers(eventData)) {
				EventTextdraw eventTextdraw = EventFunctions.getEventTextdraw(eventData, all.getName());
				if(eventTextdraw != null) {
					TTTDeadBody deadBody = getDeadBody(all.getName(), eventData);
					if(eventData.getDataPlayerArray().contains(all)) eventTextdraw.setColor(new Color(5, 218, 9, 102)); //green
					else if(eventData.getDataPlayerArray2().contains(all)) eventTextdraw.setColor(new Color(218, 5, 5, 102)); //red
					else {
						if(deadBody != null && deadBody.isConfirmed()) eventTextdraw.setColor(new Color(2, 2, 2, 102)); //gray + confirmed
						else eventTextdraw.setColor(new Color(218, 172, 5, 102)); //orange + unconfirmed
					}
					for(Player traitor : eventData.getDataPlayerArray2()) {
						eventTextdraw.hide(traitor);
						eventTextdraw.show(traitor);
					}
					if(!eventData.isDataBoolean2()) {
						eventTextdraw.setColor(new Color(5, 218, 9, 102)); //green
						if(deadBody != null && deadBody.isConfirmed()) eventTextdraw.setColor(new Color(2, 2, 2, 102)); //gray + confirmed
					}
					else {
						if(eventData.getDataPlayerArray().contains(all)) eventTextdraw.setColor(new Color(5, 218, 9, 102)); //green
						else if(eventData.getDataPlayerArray2().contains(all)) eventTextdraw.setColor(new Color(218, 5, 5, 102)); //red
						else {
							if(deadBody != null && deadBody.isConfirmed()) eventTextdraw.setColor(new Color(2, 2, 2, 102)); //gray + confirmed
							else {
								if(eventTextdraw.getType().equals("traitor")) eventTextdraw.setColor(new Color(218, 5, 5, 102)); //red
								else eventTextdraw.setColor(new Color(5, 218, 9, 102)); //green
							}
						}
					}
					EventFunctions.getAllPlayers(eventData).stream().filter(player -> !eventData.getDataPlayerArray2().contains(player)).forEach(player -> {
						eventTextdraw.hide(player);
						eventTextdraw.show(player);
					});
				}
			}
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see me.alf21.eventsystem.Event#start(me.alf21.eventsystem.EventData)
	 */
	@Override
	public void start(EventData eventData) {
		eventData.setDataPlayerArray(new ArrayList<>());
		eventData.setDataPlayerArray2(new ArrayList<>());
		prepare(eventData);
		startCountdown(eventData, 30);
		Timer timer = Timer.create(32000, 1, (factualInterval) -> {
			for(Player player : EventFunctions.getAllPlayers(eventData)) {
				eventData.getDataPlayerArray().add(player);
			}
			for(int i = 0; i < eventData.getDataInt(); i++) {
				Random random = new Random();
				int rand = random.nextInt(eventData.getDataPlayerArray().size()-1);
				setTraitor(eventData.getDataPlayerArray().get(rand));
			}
			eventData.getDataPlayerArray().forEach(TTT::setInnocent);
			eventData.setState(EventState.RUNNING);
			startTraitorCountdown(eventData);
		});
		timer.start();
		eventData.setGameTimer(timer);
	}
	
	/**
	 * start traitor countdown (ca. 5 mins) while traitors need to be detected
	 * @param eventData the event
	 */
	private static void startTraitorCountdown(EventData eventData) {
		try {
			((Event) eventData.getClz().newInstance()).updateTextdraws(eventData);
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
		for(Player player : EventFunctions.getAllPlayers(eventData)) {
			countdownTextdraw.show(player);
		}
		startCountdown(eventData, 5*60);
		Timer timer = Timer.create(5*1000*60+2000, 1, (factualInterval) -> {
			if(eventData.isDataBoolean()) startInnocentCountdown(eventData);
			else EventBase.finishEvent(eventData);
		});
		timer.start();
		eventData.setGameTimer(timer);
	}
	
	/**
	 * start innocent countdown (ca. 2mins) while innocents need to kill the traitors
	 * @param eventData the event
	 */
	private static void startInnocentCountdown(EventData eventData) {
		eventData.setDataBoolean2(true);
		for(Player traitor : eventData.getDataPlayerArray2()) {
			EventTextdraw eventTextdraw = EventFunctions.getEventTextdraw(eventData, traitor.getName());
			traitor.sendGameText(2000, 3, "~r~GEFUNDEN");
			if (eventTextdraw != null) {
				eventTextdraw.setColor(new Color(218, 5, 5, 102)); //red
				for(Player all : EventFunctions.getAllPlayers(eventData)) {
					eventTextdraw.hide(all);
					eventTextdraw.show(all);
				}
			}
		}
		for(Player innocent : eventData.getDataPlayerArray()) {
			EventTextdraw eventTextdraw = EventFunctions.getEventTextdraw(eventData, innocent.getName());
			innocent.sendGameText(2000, 3, "~g~Traitors gefunden");
			if (eventTextdraw != null) {
				eventTextdraw.setColor(new Color(5, 218, 9, 102)); //green
				for(Player all : EventFunctions.getAllPlayers(eventData)) {
					eventTextdraw.hide(all);
					eventTextdraw.show(all);
				}
			}
		}
		for(Player spectator : eventData.getSpectators()) {
			EventTextdraw eventTextdraw = EventFunctions.getEventTextdraw(eventData, spectator.getName());
			if (eventTextdraw != null) {
				eventTextdraw.setColor(new Color(2, 2, 2, 102)); //gray
				for(Player all : EventFunctions.getAllPlayers(eventData)) {
					eventTextdraw.hide(all);
					eventTextdraw.show(all);
				}
			}
		}
		startCountdown(eventData, 2*60);
		Timer timer = Timer.create(2*1000*60+2000, 1, (factualInterval) -> {
			//innocents was not able to kill all traitors
			EventBase.finishEvent(eventData);
		});
		timer.start();
		eventData.setGameTimer(timer);
	}
	
	/**
	 * start countdown textdraw
	 * @param eventData the event
	 * @param seconds the time in seconds
	 */
	private static void startCountdown(EventData eventData, int seconds) {
		eventData.resetTimer();
		final int seconds2 = seconds + 1;
		Timer timer = Timer.create(1000, seconds2+1, (factualInterval) -> {
			countdownTextdraw.setText(new SimpleDateFormat("mm:ss").format(new Date((long)((seconds2-1-eventData.getTime())*1000))));
			for(Player player : EventFunctions.getAllPlayers(eventData)) {
				countdownTextdraw.hide(player);
				countdownTextdraw.show(player);
			}
			eventData.setTime(eventData.getTime()+1);
		});
		timer.start();
		eventData.setTimer(timer);
	}
	
	/**
	 * prepare the event
	 * @param eventData the event
	 */
	public static void prepare(EventData eventData) {
		eventData.setState(EventState.PREPARE);
		
		tDTraitor = Textdraw.create(376, 410);
		tDTraitor.setText("Traitor");
		tDTraitor.setAlignment(TextDrawAlign.CENTER);
		tDTraitor.setBackgroundColor(Color.RED);
		tDTraitor.setFont(TextDrawFont.get(2));
		tDTraitor.setLetterSize(0.9f, 3.2f);
		tDTraitor.setColor(Color.BLACK);
		tDTraitor.setOutlineSize(1);
		tDTraitor.setProportional(true);
		tDTraitor.setUseBox(true);
		tDTraitor.setBoxColor(Color.BLACK);
		tDTraitor.setTextSize(18, -209);
		tDTraitor.setSelectable(false);
		
		tDInnocent = Textdraw.create(376, 410);
		tDInnocent.setText("Innocent");
		tDInnocent.setAlignment(TextDrawAlign.CENTER);
		tDInnocent.setBackgroundColor(Color.GREEN);
		tDInnocent.setFont(TextDrawFont.get(2));
		tDInnocent.setLetterSize(0.9f, 3.2f);
		tDInnocent.setColor(Color.BLACK);
		tDInnocent.setOutlineSize(1);
		tDInnocent.setProportional(true);
		tDInnocent.setUseBox(true);
		tDInnocent.setBoxColor(Color.BLACK);
		tDInnocent.setTextSize(18, -209);
		tDInnocent.setSelectable(false);
		
		countdownTextdraw = Textdraw.create(320, 9);
		countdownTextdraw.setAlignment(TextDrawAlign.CENTER);
		countdownTextdraw.setBackgroundColor(Color.BLACK);
		countdownTextdraw.setFont(TextDrawFont.get(2));
		countdownTextdraw.setLetterSize(0.33f, 1);
		countdownTextdraw.setColor(Color.WHITE);
		countdownTextdraw.setOutlineSize(0);
		countdownTextdraw.setProportional(true);
		countdownTextdraw.setUseBox(true);
		countdownTextdraw.setBoxColor(Color.BLACK);
		countdownTextdraw.setTextSize(0, 51);
		countdownTextdraw.setSelectable(false);
		
		EventMapBase eventMapBase = eventData.getMap();
		mapTextdraw = Zone.create(eventMapBase.getMinX()-500, eventMapBase.getMinY()-500, eventMapBase.getMaxX()+500, eventMapBase.getMaxY()+500);
		
		Color color = new Color(0,0,0,0);
		for(Player player : EventFunctions.getAllPlayers(eventData)) {
			PlayerData playerData = EventSystem.getInstance().getPlayerLifecycleHolder().getObject(player, PlayerData.class);
			player.setColor(color);
			player.giveWeapon(WeaponModel.DEAGLE, 14); //TODO if not online -> Packetloss
			mapTextdraw.show(player, Color.BLACK);
			for(Player all : EventFunctions.getAllPlayers(eventData)) {
				all.markerForPlayer(player, color);
			}
			playerData.setCount(30);
		}
		createTextdraws(eventData);
	}
	
	/**
	 * set a player as a traitor
	 * @param player the target
	 */
	private static void setTraitor(Player player) {
		playerLifecycle = EventSystem.getInstance().getPlayerLifecycleHolder().getObject(player, PlayerData.class);
		EventData eventData = playerLifecycle.getCurrentEvent();
		if(!eventData.getDataPlayerArray2().contains(player)) {
			if(eventData.getDataPlayerArray().contains(player))
				eventData.getDataPlayerArray().remove(player);
			eventData.getDataPlayerArray2().add(player);

			eventData.getEventTextdraws().stream().filter(eventTextdraw -> eventTextdraw.getTextdraw().getText().equals(player.getName())).forEach(eventTextdraw -> eventTextdraw.setType("traitor"));
			
			tDTraitor.show(player);
			playerLifecycle.setEventPoints(3);
		}
	}
	
	/**
	 * set a player as a innocent
	 * @param player the target
	 */
	private static void setInnocent(Player player) {
		playerLifecycle = EventSystem.getInstance().getPlayerLifecycleHolder().getObject(player, PlayerData.class);
		EventData eventData = playerLifecycle.getCurrentEvent();
		eventData.getEventTextdraws().stream().filter(eventTextdraw -> eventTextdraw.getTextdraw().getText().equals(player.getName())).forEach(eventTextdraw -> eventTextdraw.setType("innocent"));
		tDInnocent.show(player);
	}
	
	/*
	 * (non-Javadoc)
	 * @see me.alf21.eventsystem.Event#settingsDialog(net.gtaun.shoebill.object.Player, net.gtaun.shoebill.common.dialog.ListDialog)
	 */
	@Override
	public void settingsDialog(Player player, ListDialog settingsDialog) {
		playerLifecycle = EventSystem.getInstance().getPlayerLifecycleHolder().getObject(player, PlayerData.class);
		EventData eventData = playerLifecycle.getCurrentEvent();
		
		int requiredPlayerAmount = EventFunctions.getDescriptionForEvent(this.getClass()).playerValueMin();
		if(eventData != null) {
			if(eventData.getState() == EventState.START) {
				settingsDialog.getItems().add(ListDialogItem.create()
			            .itemText(eventData.getDataInt()<0?"{FF0000}[" + localizedStringSet.get(player, "Dialog.Todo") + "]{FFFFFF} " + localizedStringSet.get(player, "Event.Class.TTT.Traitor.Amount"):"{00FF00}[" + localizedStringSet.get(player, "Dialog.Done") + "]{FFFFFF} " + localizedStringSet.get(player, "Event.Class.TTT.Traitor.Amount") + " ("+eventData.getDataInt()+")")
			            .onSelect((listDialogItem, o) -> {
		            		if(EventFunctions.getAllPlayers(eventData).size() > requiredPlayerAmount-1) {
			            		InputDialog.create(player, EventSystem.getInstance().getEventManagerInstance())
				            		.caption("{FF8A05}" + localizedStringSet.get(player, "Event.Class.TTT.Traitor.Setting"))
				            		.message(localizedStringSet.get(player, "Dialog.Input.Numbers") + ": (max. " + eventData.getPlayerList().size() + ")")
				            		.buttonOk(localizedStringSet.get(player, "Dialog.Next"))
				            		.buttonCancel(localizedStringSet.get(player, "Dialog.Back"))
				            		.onClickOk((dialog, s) -> {
				            			try {
				            				int input = Integer.parseInt(s);
				            				if(input > 0) {
				            					if(input <= eventData.getPlayerList().size()) {
				            						eventData.setDataInt(input);
				            						EventBase.settingsDialog(eventData);
				            					}
				            					else {
					            					MsgboxDialog.create(player, EventSystem.getInstance().getEventManagerInstance())
														.caption("{FF8A05}" + localizedStringSet.get(player, "Dialog.Error.Error")) 
														.message("{FF0000}" + localizedStringSet.format(player, "Dialog.Error.MaximumNumbers", eventData.getPlayerList().size())) 
														.buttonOk(localizedStringSet.get(player, "Dialog.Okay")) 
														.buttonCancel(localizedStringSet.get(player, "Dialog.Back")) 
														.onClickOk((handler) -> dialog.show())
														.onClickCancel((handler) -> dialog.show())
														.build() 
														.show();
				            					}
				            				}
				            				else {
				            					MsgboxDialog.create(player, EventSystem.getInstance().getEventManagerInstance())
													.caption("{FF8A05}" + localizedStringSet.get(player, "Dialog.Error.Error")) 
													.message("{FF0000}" + localizedStringSet.format(player, "Dialog.Error.MinimumNumbers", 1)) 
													.buttonOk(localizedStringSet.get(player, "Dialog.Okay")) 
													.buttonCancel(localizedStringSet.get(player, "Dialog.Back")) 
													.onClickOk((handler) -> dialog.show())
													.onClickCancel((handler) -> dialog.show())
													.build() 
													.show();
				            				}
				            			} catch(Exception e) {
				            				MsgboxDialog.create(player, EventSystem.getInstance().getEventManagerInstance())
												.caption("{FF8A05}" + localizedStringSet.get(player, "Dialog.Error.Error")) 
												.message("{FF0000}" + localizedStringSet.get(player, "Dialog.Error.Numbers")) 
												.buttonCancel(localizedStringSet.get(player, "Dialog.Back")) 
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
		            		}
		            		else {
		            			MsgboxDialog.create(player, EventSystem.getInstance().getEventManagerInstance())
									.caption("{FF8A05}" + localizedStringSet.get(player, "Dialog.Error.Error")) 
									.message("{FF0000}" + localizedStringSet.format(player, "Event.Error.MorePlayers", requiredPlayerAmount)) 
									.buttonCancel(localizedStringSet.get(player, "Dialog.Back")) 
									.buttonOk(localizedStringSet.get(player, "Dialog.Okay")) 
									.onClickOk((handler) -> EventBase.settingsDialog(eventData))
									.onClickCancel((handler) -> EventBase.settingsDialog(eventData))
									.build() 
									.show();
		            		}
			            })
			            .build());
			}
			if(!eventData.isDataBoolean2()) {
				settingsDialog.getItems().add(ListDialogItem.create()
			            .itemText(eventData.isDataBoolean()?"{00FF00}[" + localizedStringSet.get(player, "Dialog.Activated") + "]{FFFFFF} " + localizedStringSet.get(player, "Event.Class.TTT.Countdown.Innocent.Name"):"{FF0000}[" + localizedStringSet.get(player, "Dialog.Deactivated") + "]{FFFFFF} " + localizedStringSet.get(player, "Event.Class.TTT.Countdown.Innocent.Name"))
			            .onSelect((listDialogItem, o) -> {
			            	eventData.setDataBoolean(!eventData.isDataBoolean());
							EventBase.settingsDialog(eventData);
			            })
			            .build());
			}
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see me.alf21.eventsystem.Event#isAbleToStart(me.alf21.eventsystem.EventData)
	 */
	@Override
	public boolean isAbleToStart(EventData eventData) {
		return !(eventData.getDataInt() <= 0 || eventData.getDataInt() > eventData.getPlayerList().size()) && eventData.getPlayerList().size() >= EventFunctions.getDescriptionForEvent(this.getClass()).playerValueMin() - 1;
	}
	
	/*
	 * (non-Javadoc)
	 * @see me.alf21.eventsystem.Event#getAbilityToStart(me.alf21.eventsystem.EventData)
	 */
	@Override
	public int getAbilityToStart(EventData eventData) {
		int i = 1;
		if(eventData.getDataInt() <= 0 || eventData.getDataInt() > eventData.getPlayerList().size()) {
			return 0;
		}
		if(eventData.getPlayerList().size() < EventFunctions.getDescriptionForEvent(this.getClass()).playerValueMin()-1) {
			return 0;
		}
		return i;
	}
	
	@Override
	public void onStartFailed(EventData eventData) {
		if(eventData.getDataInt() <= 0 || eventData.getDataInt() > eventData.getPlayerList().size()) {
			eventData.getOwner().sendMessage(Color.RED, localizedStringSet.get(eventData.getOwner(), "Event.Class.TTT.Error.NoTraitors"));
		}
		if(eventData.getPlayerList().size() < EventFunctions.getDescriptionForEvent(this.getClass()).playerValueMin()-1) {
			eventData.getOwner().sendMessage(Color.RED, localizedStringSet.format(eventData.getOwner(), "Event.Error.MorePlayers", EventFunctions.getDescriptionForEvent(this.getClass()).playerValueMin()));
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see me.alf21.eventsystem.Event#onPlayerTakeDamage(net.gtaun.shoebill.event.player.PlayerTakeDamageEvent)
	 */
	@Override
	public void onPlayerTakeDamage(PlayerTakeDamageEvent e) {
	/*	Player player = e.getPlayer();
		playerLifecycle = EventSystem.getInstance().getPlayerLifecycleHolder().getObject(player, PlayerData.class);
		EventData eventData = playerLifecycle.getCurrentEvent();
		if(eventData != null) {
			if(eventData.getState() == EventState.PREPARE) {
				player.setHealth(player.getHealth()+Math.abs(e.getAmount()));
			}
			else if(eventData.getState() == EventState.RUNNING) {
				if(e.getBodyPart() == 9) {
					e.getPlayer().setHealth(0);
				}
				else {
					player.setHealth(player.getHealth()-Math.abs(e.getAmount()));
				}
				if(e.getIssuer() != null && player.getHealth() == 0) {
					PlayerData issuerLifecycle = EventSystem.getInstance().getPlayerLifecycleHolder().getObject(e.getIssuer(), PlayerData.class);
					issuerLifecycle.setEventPoints(issuerLifecycle.getEventPoints()+1);
					e.getIssuer().sendGameText(2000, 3, "+1");
				}
			}
		}*/
	}
	
	/*
	 * (non-Javadoc)
	 * @see me.alf21.eventsystem.Event#onPlayerExit(net.gtaun.shoebill.object.Player, me.alf21.eventsystem.EventData)
	 */
	@Override
	public void onPlayerExit(Player player, EventData eventData) {
		playerLifecycle = EventSystem.getInstance().getPlayerLifecycleHolder().getObject(player, PlayerData.class);
		if(eventData.getState() == EventState.RUNNING) {
			String string;
			if(eventData.getDataPlayerArray2().contains(player)) {
				string = localizedStringSet.format(player, "Event.Class.TTT.Leave.WasTraitor", player.getName());
				eventData.getDataPlayerArray2().remove(player);
				tDTraitor.hide(player);
			}
			else if(eventData.getDataPlayerArray().contains(player)) {
				string = localizedStringSet.format(player, "Event.Class.TTT.Leave.WasInnocent", player.getName());
				eventData.getDataPlayerArray().remove(player);
				tDInnocent.hide(player);
			}
			else {
				string = localizedStringSet.format(player, "Event.Class.TTT.Leave.WasSpectator", player.getName());
				eventData.getSpectators().remove(player);
			}
			for(EventTextdraw eventTextdraw : eventData.getEventTextdraws()) {
				eventTextdraw.hide(player);
			}
			mapTextdraw.hide(player);
			countdownTextdraw.hide(player);
			destroyGPS(player);
			for(Player all : EventFunctions.getAllPlayers(eventData)) {
				all.sendMessage(string);
			}
			checkFinish(eventData);
		}
	}
	
	/**
	 * checks if a event is finished
	 * @param eventData the event
	 */
	private static boolean checkFinish(EventData eventData) {
		if(eventData.getDataPlayerArray().isEmpty() || eventData.getDataPlayerArray2().isEmpty()) {
			EventBase.finishEvent(eventData);
			return true;
		}
		return false;
	}
	
	/*
	 * (non-Javadoc)
	 * @see me.alf21.eventsystem.Event#finish(me.alf21.eventsystem.EventData)
	 */
	@Override
	public void finish(EventData eventData) {
		destroyTextdraws(eventData);
		removeDeadBodies(eventData);
		for(Player spectator : eventData.getSpectators()) {
			spectator.toggleControllable(true);
			spectator.toggleSpectating(false);
		}
		eventData.getDataPlayerArray2().forEach(this::destroyGPS);
		String textString;
		for(Player all : EventFunctions.getAllPlayers(eventData)) {
			if(!eventData.getDataPlayerArray().isEmpty()) textString = "~g~" + localizedStringSet.get(all, "Event.Class.TTT.Innocents") + " ~w~WINS";
			else textString = "~r~" + localizedStringSet.get(all, "Event.Class.TTT.Traitors") + " ~w~WINS"; //TODO translate WINS
			PlayerData playerPlayerData = EventSystem.getInstance().getPlayerLifecycleHolder().getObject(all, PlayerData.class);
			playerPlayerData.setGameTextTD(new GameTextTD(all, textString, 7000, true, 1000));
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see me.alf21.eventsystem.Event#destroy(me.alf21.eventsystem.EventData)
	 */
	@Override
	public void destroy(EventData eventData) {
		destroyTextdraws(eventData);
		removeDeadBodies(eventData);
		for(Player spectator : eventData.getSpectators()) {
			spectator.toggleControllable(true);
			spectator.toggleSpectating(false);
		}
		eventData.getDataPlayerArray2().forEach(this::destroyGPS);
	}
	
	/**
	 * create all event textdraws
	 * @param eventData the event
	 */
	private static void createTextdraws(EventData eventData) {
		int i = 0;
		for(Player player : EventFunctions.getAllPlayers(eventData)) {
			PlayerData playerLifecycle = EventSystem.getInstance().getPlayerLifecycleHolder().getObject(player, PlayerData.class);
			EventTextdraw eventTextdraw = new EventTextdraw(player.getName(), i, "", playerLifecycle.getEventScore());
			eventData.getEventTextdraws().add(eventTextdraw);
			EventFunctions.getAllPlayers(eventData).forEach(eventTextdraw::show);
			i++;
		}
	}
	
	/**
	 * destroy all event textdraws
	 * @param eventData the event
	 */
	private static void destroyTextdraws(EventData eventData) {
		for(Player traitor : eventData.getDataPlayerArray2()) {
			tDTraitor.hide(traitor);
		}
		for(Player innocent : eventData.getDataPlayerArray()) {
			tDInnocent.hide(innocent);
		}
		for(EventTextdraw eventTextdraw : eventData.getEventTextdraws()) {
			eventTextdraw.hideForAll();
			eventTextdraw.destroy();
		}
		eventData.getEventTextdraws().clear();
		if(mapTextdraw != null) mapTextdraw.hideForAll();
		if(countdownTextdraw != null) countdownTextdraw.hideForAll();
	}
	
	/**
	 * removes all dead bodies as dynamic objects from the map
	 * @param eventData the event
	 */
	private static void removeDeadBodies(EventData eventData) {
		eventData.getDeadBodies().forEach(TTTDeadBody::destroy);
		eventData.getDeadBodies().clear();
	}
	
	/*
	 * (non-Javadoc)
	 * @see me.alf21.eventsystem.Event#check(net.gtaun.shoebill.object.Player)
	 */
	@Override
	public void check(Player player) {
		
	}
	
	/*
	 * (non-Javadoc)
	 * @see me.alf21.eventsystem.Event#onPlayerKeyStateChange(net.gtaun.shoebill.event.player.PlayerKeyStateChangeEvent)
	 */
	@Override
	public void onPlayerKeyStateChange(PlayerKeyStateChangeEvent e) {
		Player player = e.getPlayer();
		playerLifecycle = EventSystem.getInstance().getPlayerLifecycleHolder().getObject(player, PlayerData.class);
		EventData eventData = playerLifecycle.getCurrentEvent();
		if(eventData.getState() == EventState.RUNNING) {
			if(player.getKeyState().isKeyPressed(PlayerKey.CTRL_BACK)) {
				if(!eventData.getDeadBodies().isEmpty()) {
					TTTDeadBody deadBody = getDeadBodyInRange(player.getLocation(), eventData, 1.5f);
					if(deadBody != null) {
						if(!deadBody.isConfirmed()) {
							if(!deadBody.isDialogOpened()) {
								deadBodyDialog(player, deadBody, eventData);
							}
							else {
								MsgboxDialog.create(player, EventSystem.getInstance().getEventManagerInstance())
								.caption("{FF8A05}" + localizedStringSet.get(player, "Dialog.NotAvailable")) 
								.message("{FF0000}" + localizedStringSet.get(player, "Event.Class.TTT.DeathBody.IsOpened")) 
								.buttonOk(localizedStringSet.get(player, "Dialog.Okay")) 
								.buttonCancel(localizedStringSet.get(player, "Dialog.Close")) 
								.build() 
								.show();
							}
						}
					}
				}
			}
			else {
				if(eventData.getDataPlayerArray2().contains(player)) {
					if(player.getKeyState().isKeyPressed(PlayerKey.NO)) {
						TTTShop.show(player);
					}
				}
			}
		}
	}
	
	/**
	 * the dead body dialog on click [y]
	 * @param player the player
	 * @param deadBody the body of the player
	 * @param eventData the event
	 */
	private void deadBodyDialog(Player player, TTTDeadBody deadBody, EventData eventData) {
		deadBody.setDialogOpened(true);
		ListDialog deadBodyDialog = ListDialog.create(player, EventSystem.getInstance().getEventManagerInstance())
		        .caption("{FF8A05}" + localizedStringSet.get(player, "Event.Class.TTT.DeathBody.Open"))
		        .buttonOk(localizedStringSet.get(player, "Dialog.Okay"))
		        .buttonCancel(localizedStringSet.get(player, "Dialog.Back")) 
		        .onClickCancel((handler) -> deadBody.setDialogOpened(false))
		        .build();

		if(!deadBody.isConfirmed()) {
			deadBodyDialog.getItems().add(ListDialogItem.create()
		            .itemText(localizedStringSet.get(player, "Event.Class.TTT.DeathBody.Confirm"))
		            .onSelect((listDialogItem, o) -> {
	            		confirmDeadBody(player, deadBody, eventData);
	            		if(deadBody.isEmpty())
	            			deadBody.getLabel().destroy();
	            		else deadBodyDialog(player, deadBody, eventData);
		            })
		            .build());
		}
		if(deadBody.getWeaponDatas().size() > 0) {
			deadBodyDialog.getItems().add(ListDialogItem.create()
		            .itemText(localizedStringSet.get(player, "Event.Class.TTT.DeathBody.TakeWeapons"))
		            .onSelect((listDialogItem, o) -> {
	                	ListDialog weaponDataDialog = ListDialog.create(player, EventSystem.getInstance().getEventManagerInstance())
	            		        .caption("{FF8A05}" + localizedStringSet.get(player, "Event.Class.TTT.DeathBody.TakeWeapons"))
	            		        .buttonOk(localizedStringSet.get(player, "Dialog.Okay"))
	            		        .buttonCancel(localizedStringSet.get(player, "Dialog.Back")) 
	            		        .onClickCancel((handler) -> deadBodyDialog(player, deadBody, eventData))
	            		        .build();

	        			
	        			for (WeaponData weaponData : deadBody.getWeaponDatas()) {
		                	weaponDataDialog.getItems().add(ListDialogItem.create()
		                			.itemText(weaponData.getModel().getName() + " - " + weaponData.getAmmo())
		                			.onSelect((listDialogItem2, o2) -> {
		                				player.giveWeapon(weaponData);
		                				deadBody.getWeaponDatas().remove(weaponData);
		                				if(deadBody.isEmpty())
		                					deadBody.getLabel().destroy();
		                				else deadBodyDialog(player, deadBody, eventData);
		                			})
		                			.build());
	        			}
		                weaponDataDialog.show();
		            })
		            .build());
    	}
		deadBodyDialog.show();
	}
	
	/**
	 * confirm a deadBody
	 * @param confirmer the confirmer
	 * @param deadBody the dead body
	 */
	private static void confirmDeadBody(Player confirmer, TTTDeadBody deadBody, EventData eventData) {
		deadBody.setConfirmed(true);
		for(Player player : EventFunctions.getAllPlayers(eventData)) {
			player.sendGameText(3000, 3, localizedStringSet.format(player, "Event.Class.TTT.DeathBody.Found", deadBody.getName(), confirmer));
		}
	}
	
	/**
	 * get the nearest dead body in range of the location
	 * @param location the location
	 * @param eventData the event
	 * @param range the max range
	 * @return TTTDeadBody
	 */
	private static TTTDeadBody getDeadBodyInRange(Location location, EventData eventData, float range) {
		TTTDeadBody deadBody = null;
		float min = -1;
		for(TTTDeadBody deadBody2 : eventData.getDeadBodies()) {
			float newRange = deadBody2.getLocation().distance(location);
			if(newRange <= range && (min == -1 || min > newRange)) {
				min = newRange;
				deadBody = deadBody2;
			}
		}
		return deadBody;
	}
	
	/**
	 * get dead body with name of the dead player
	 * @param name the name of dead player
	 * @param eventData the event
	 * @return TTTDeadBody
	 */
	private static TTTDeadBody getDeadBody(String name, EventData eventData) {
		for(TTTDeadBody deadBody : eventData.getDeadBodies()) {
			if(deadBody.getName().equals(name))
				return deadBody;
		}
		return null;
	}
	
	/*
	 * (non-Javadoc)
	 * @see me.alf21.eventsystem.Event#getWinner(me.alf21.eventsystem.EventData)
	 */
	@Override
	public String[] getWinner(EventData eventData) {
		String[] winners;
		if(!eventData.getDataPlayerArray2().isEmpty()) {
			winners = new String[eventData.getDataPlayerArray2().size()];
			int i = 0;
			for(Player player : eventData.getDataPlayerArray2()) {
				winners[i] = player.getName();
				i++;
			}
		}
		else {
			winners = new String[eventData.getDataPlayerArray().size()];
			int i = 0;
			for(Player player : eventData.getDataPlayerArray()) {
				winners[i] = player.getName();
				i++;
			}
		}
		return winners;
	}
	
	/*
	 * (non-Javadoc)
	 * @see me.alf21.eventsystem.Event#isGameTimerEnabled()
	 */
	@Override
	public boolean isGameTimerEnabled() {
		return false;
	}
	
	/* (non-Javadoc)
	 * @see me.alf21.eventsystem.Event#onGlobalTimer(me.alf21.eventsystem.EventData)
	 */
	@Override
	public void onGlobalTimer(EventData eventData) {
		if(eventData.getState() == EventState.RUNNING) {
			for(Player traitor : eventData.getDataPlayerArray2()) {
				PlayerData playerData = EventSystem.getInstance().getPlayerLifecycleHolder().getObject(traitor, PlayerData.class);
				if(playerData.getTraitorShop().getOrDefault("GPS", false)) {
					if(playerData.getCount() >= 30) {
						playerData.resetCount();
						destroyGPS(traitor);
						createGPS(traitor, eventData);
					}
					else playerData.increaseCount();
				}
			}
		}
	}
	
	/**
	 * create the GPS location of players for a player
	 * @param player the player
	 * @param eventData the event
	 */
	private void createGPS(Player player, EventData eventData) {
		if(eventData.getMap() != null) {
			EventMapBase map = eventData.getMap();
			float distance = new Location(map.getMaxX(), map.getMaxY(), map.getMaxZ()).distance(new Location(map.getMinX(), map.getMinY(), map.getMinZ()));
			PlayerData playerData = EventSystem.getInstance().getPlayerLifecycleHolder().getObject(player, PlayerData.class);
			eventData.getDataPlayerArray().stream().filter(runner -> runner != player).forEach(runner -> {
				RangeLabel rangeLabel = new RangeLabel(runner.getName(), runner.getLocation());
				rangeLabel.create(player, player.getLocation(), Color.GREEN, distance, false);
				playerData.getRangeLabels().add(rangeLabel);
			});
			eventData.getDataPlayerArray2().stream().filter(traitor -> traitor != player).forEach(traitor -> {
				RangeLabel rangeLabel = new RangeLabel(traitor.getName(), traitor.getLocation());
				rangeLabel.create(player, player.getLocation(), Color.RED, distance, false);
				playerData.getRangeLabels().add(rangeLabel);
			});
		}
	}
	
	/**
	 * destroy the GPS for a player
	 * @param player the player
	 */
	private void destroyGPS(Player player) {
		PlayerData playerData = EventSystem.getInstance().getPlayerLifecycleHolder().getObject(player, PlayerData.class);
		playerData.getRangeLabels().forEach(RangeLabel::destroy);
		playerData.getRangeLabels().clear();
	}
}
