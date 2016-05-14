/**
 * @author Alf21 on 21.01.2016 in project event-system.
 * Copyright (c) 2015 Alf21. All rights reserved.
 */
package me.alf21.events.mission.util;

import me.alf21.eventsystem.EventData;
import net.gtaun.shoebill.common.dialog.ListDialog;
import net.gtaun.shoebill.object.Player;

/**
 * @author Alf21
 *
 */
public abstract class Mission {

	public Mission() { }
	
	/**
	 * create the event (INITIALIZE)
	 * @param eventData the event
	 */
	public void create(EventData eventData) {
		
	}

	/**
	 * destroy the event
	 * @param eventData the event
	 */
	public void destroy(EventData eventData) {
		
	}
	
	/**
	 * start the mission
	 * @param eventData the event
	 */
	public void start(EventData eventData) {
		
	}
	
	/**
	 * finish the event
	 * @param eventData the event
	 */
	public void finish(EventData eventData) {
		//eventData.setState(EventState.START);
	}
	
	/**
	 * onPlayerExitEvent
	 * @param player the player
	 * @param eventData the event
	 */
	public void onPlayerExit(Player player, EventData eventData) {
		
	}
	
	/**
	 * adds some dialoges to the settingsdialog of the event
	 * @param player the player
	 * @param settingsDialog the settingsdialog of main dialog
	 */
	public void settingsDialog(Player player, ListDialog settingsDialog) {
		
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
}
