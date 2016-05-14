/**
 * @author Alf21 on 21.01.2015 in project event-system.
 * Copyright (c) 2015 Alf21. All rights reserved.
 */
package me.alf21.events.missions;

import net.gtaun.shoebill.Shoebill;
import net.gtaun.shoebill.object.Player;
import me.alf21.events.mission.util.Mission;
import me.alf21.events.mission.util.MissionDescription;
import me.alf21.eventsystem.EventData;
import me.alf21.eventsystem.EventFunctions;
import me.alf21.eventsystem.EventNPCBase;
import me.alf21.eventsystem.EventNPCData;
import me.alf21.eventsystem.EventNPCFunctions;
import me.alf21.eventsystem.PlayerData;
import me.alf21.npcs.Bodyguard;

/**
 * @author Alf21
 */
@MissionDescription(name = "Survive", credits = "Alf21", playerValueMin = 1, playerValueMax = 4)
public class Survive extends Mission {
	
	public static PlayerData playerLifecycle;
	
	public Survive() {}
	
	/*
	 * (non-Javadoc)
	 * @see me.alf21.events.mission.util.Mission#create(me.alf21.eventsystem.EventData)
	 */
	@Override
	public void create(EventData eventData) {
		
	}
	
	/*
	 * (non-Javadoc)
	 * @see me.alf21.events.mission.util.Mission#destroy(me.alf21.eventsystem.EventData)
	 */
	@Override
	public void destroy(EventData eventData) {
		for(EventNPCData npcData : EventNPCFunctions.getEventNPCDatas(eventData)) {
			npcData.getFCNPC().destroy();
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see me.alf21.events.mission.util.Mission#start(me.alf21.eventsystem.EventData)
	 */
	@Override
	public void start(EventData eventData) {
		Shoebill.get().runOnSampThread(() -> {
			for(Player player : EventFunctions.getAllPlayers(eventData)) {
				for(int x = 1; x <= 4; x++) {
					EventNPCData eventNPCData = EventNPCBase.create(eventData, "bg"+player.getName()+x, Bodyguard.class);
					eventNPCData.setTarget(player);
					eventNPCData.setSpawnable(true);
				}
			}
		});
	}
	
	/*
	 * (non-Javadoc)
	 * @see me.alf21.events.mission.util.Mission#onPlayerExit(net.gtaun.shoebill.object.Player, me.alf21.eventsystem.EventData)
	 */
	@Override
	public void onPlayerExit(Player player, EventData eventData) {
		EventNPCFunctions.getEventNPCDatas(eventData).stream().filter(npcData -> npcData.getTarget() == player).forEach(npcData -> npcData.getFCNPC().destroy());
	}
	
	/*
	 * (non-Javadoc)
	 * @see me.alf21.events.mission.util.Mission#finish(me.alf21.eventsystem.EventData)
	 */
	@Override
	public void finish(EventData eventData) {
		for(EventNPCData npcData : EventNPCFunctions.getEventNPCDatas(eventData)) {
			npcData.getFCNPC().destroy();
		}
	}
}
