/**
 * @author Alf21 on 18.12.2015 in project event-system.
 * Copyright (c) 2015 Alf21. All rights reserved.
 */

package me.alf21.events;

import net.gtaun.shoebill.data.Color;
import net.gtaun.shoebill.object.Player;
import me.alf21.eventsystem.Event;
import me.alf21.eventsystem.EventData;
import me.alf21.eventsystem.EventDescription;
import me.alf21.eventsystem.EventSystem;
import me.alf21.eventsystem.PlayerData;

@EventDescription(name = "Race", playerValueMin = 2, credits = "Alf21")
public class Race extends Event {
	
	public static PlayerData playerLifecycle;
	
	public Race() {
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
		player.sendMessage(Color.YELLOW, "You was disqualified because of dieing during the race!");
		for(Player member : eventData.getDataPlayerArray()) {
			member.sendMessage(Color.YELLOW, "[RACE] " + Color.WHITE.toEmbeddingString() + player.getName() + " was disqualified because of dieing during the race!");
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
	
}
