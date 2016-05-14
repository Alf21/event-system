/**
 * @author Alf21 on 18.12.2015 in project event-system.
 * Copyright (c) 2015 Alf21. All rights reserved.
 */

package me.alf21.eventsystem;

import java.util.List;

import net.gtaun.shoebill.common.dialog.ListDialog;
import net.gtaun.shoebill.event.player.PlayerKeyStateChangeEvent;
import net.gtaun.shoebill.event.player.PlayerTakeDamageEvent;
import net.gtaun.shoebill.event.player.PlayerWeaponShotEvent;
import net.gtaun.shoebill.object.Player;

public abstract class Event {
	
	public Event() {}
	
	/**
	 * start the event
	 * @param eventData the event
	 */
	public void start(EventData eventData) {
		//eventData.setState(EventState.RUNNING);
	}
	
	/**
	 * finish the event
	 * @param eventData the event
	 */
	public void finish(EventData eventData) {
		//eventData.setState(EventState.START);
	}
	
	/**
	 * destroy the event
	 * @param eventData the event
	 */
	public void destroy(EventData eventData) {
		//eventData.destroy();
	}
	
	/**
	 * adds some dialoges to the settingsdialog of the event
	 * @param player the player
	 * @param settingsDialog the settingsdialog of main dialog
	 */
	public void settingsDialog(Player player, ListDialog settingsDialog) {
		
	}
	
	/**
	 * onPlayerUpdate every time checks the event
	 * @param player the player
	 */
	public void check(Player player) {
		
	}
	
	/**
	 * checks whether a event is able to start
	 * @param eventData the event
	 * @return boolean
	 */
	public boolean isAbleToStart(EventData eventData) {
		return true;
	}
	
	/**
	 * does something if event start failed
	 * @param eventData the event
	 */
	public void onStartFailed(EventData eventData) {
		
	}
	
	/**
	 * onPlayerDeath event
	 * @param player the player
	 */
	public void onPlayerDeath(Player player) {
		
	}
	
	/**
	 * onPlayerSpawn event
	 * @param player the player
	 */
	public void onPlayerSpawn(Player player) {
		
	}
	
	/**
	 * onFinishGameTimer
	 * @param eventData the event
	 * @return boolean
	 */
	public boolean onFinishGameTimer(EventData eventData) {
		return true;
	}
	
	/**
	 * add dialoges to the main event dialog
	 * @param player the player
	 * @param dialog the main dialog
	 */
	public void addToDialog(Player player, ListDialog dialog) {
		
	}
	
	/**
	 * returns the Integer for the color of styling start dialogitem of main dialog
	 * @param eventData the event
	 * @return int
	 */
	public int getAbilityToStart(EventData eventData) {
		return 1;
	}
	
	/**
	 * onPlayerWeaponShot()
	 * @param e the PlayerWeaponShotEvent
	 */
	public void onPlayerWeaponShot(PlayerWeaponShotEvent e) {
		
	}
	
	/**
	 * onPlayerTakeDamage()
	 * @param e the PlayerTakeDamageEvent
	 */
	public void onPlayerTakeDamage(PlayerTakeDamageEvent e) {
		
	}
	
	/**
	 * onPlayerKeyStateChange()
	 * @param e the PlayerKeyStateChangeEvent
	 */
	public void onPlayerKeyStateChange(PlayerKeyStateChangeEvent e) {
		
	}
	
	/**
	 * returns the string of winners
	 * @param eventData the event
	 * @return String[]
	 */
	public String[] getWinner(EventData eventData) {
		return new String[0];
	}
	
	/**
	 * return all available maps for an event loaded by EventMapBase
	 * @return List of Classes of all available maps
	 */
	public List<Class<?>> getAvailableMaps() {
		return EventExtensibleDependencies.getAvailableMaps();
	}
	
	/**
	 * set whether event depends on maps
	 * @return boolean
	 */
	public boolean dependsOnMaps() {
		return false;
	}
	
	/**
	 * set whether maps are available but do not need to be setted on start
	 * @return boolean
	 */
	public boolean isAvailableMaps() {
		return true;
	}
	
	/**
	 * set whether the game timer is enabled
	 * @return boolean
	 */
	public boolean isGameTimerEnabled() {
		return true;
	}
	
	/**
	 * update the event textdraws
	 * @param eventData the event
	 */
	public void updateTextdraws(EventData eventData) {
		if(eventData.getEventTextdraws() != null && !eventData.getEventTextdraws().isEmpty()) {
			for(EventTextdraw eventTextdraw : eventData.getEventTextdraws()) {
				EventFunctions.getAllPlayers(eventData).forEach(eventTextdraw::show);
			}
		}
	}
	
	/**
	 * onPlayerJoinEvent
	 * @param player the player
	 * @param eventData the event
	 */
	public void onPlayerJoin(Player player, EventData eventData) {
		
	}
	
	/**
	 * onPlayerAFK Event
	 * @param player the player
	 * @param eventData the event
	 */
	public void onPlayerAFK(Player player, EventData eventData) {
		//eventData.getOwner().sendMessage(player.getName() + " is AFK! You can eject him with /events -> remove Player");
		player.setHealth(player.getHealth()-2);
	}
	
	/**
	 * onGlobalTimerEvent
	 * @param eventData the event
	 */
	public void onGlobalTimer(EventData eventData) {
		
	}
	
	/**
	 * onPlayerExitEvent
	 * @param player the player
	 * @param eventData the event
	 */
	public void onPlayerExit(Player player, EventData eventData) {
		
	}
}
