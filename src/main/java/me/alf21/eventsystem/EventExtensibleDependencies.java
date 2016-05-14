/**
 * @author Alf21 on 18.12.2015 in project event-system.
 * Copyright (c) 2015 Alf21. All rights reserved.
 */
package me.alf21.eventsystem;

import java.util.Arrays;
import java.util.List;

import me.alf21.events.Catching;
import me.alf21.events.MissionBase;
import me.alf21.events.TTT.TTT;
import me.alf21.events.missions.Survive;
import me.alf21.maps.Alcatraz;
import me.alf21.maps.CS_Dust2;
import me.alf21.maps.DE_Dust2;
import me.alf21.maps.Island;
import me.alf21.maps.Island2;
import me.alf21.maps.Jail;
import me.alf21.maps.KACCMilitaryFuels;
import me.alf21.maps.RACE_WRC_Rallycross;
import me.alf21.maps.RadioStationSF;
import me.alf21.maps.Rogue_Nations;
import me.alf21.maps.SantaMariaBeach;

/**
 * @author Alf21
 * all dependencies are located here. You can easily add a dependency to load it dynamically.
 */
public class EventExtensibleDependencies {

    /**
     * return all available type of events
     * @return List of Classes of Events loaded by EventBase
     */
    public static List<Class<?>> getAvailableEventTypes() {
        return Arrays.asList(new Class[]{
                Catching.class,
                TTT.class,
                MissionBase.class
        });
    }

    /**
     * return all available mission classes
     * @return Array of Classes of EventMissions loaded by MissionBase
     */
	public static List<Class<?>> getAvailableMissions() {
		return Arrays.asList(new Class<?>[]{
			Survive.class	
		});
	}
	
	/**
     * return all available mission classes as normal available maps for each events if not modified in event types
     * @return Array of Classes of EventMaps loaded by EventMapBase
     */
	public static List<Class<?>> getAvailableMaps() {
		return Arrays.asList(new Class<?>[]{
				DE_Dust2.class,
				Rogue_Nations.class,
				Island.class,
				Alcatraz.class,
				KACCMilitaryFuels.class,
				RadioStationSF.class,
				SantaMariaBeach.class,
				CS_Dust2.class,
				Island2.class,
				Jail.class,
				RACE_WRC_Rallycross.class
			});
	}
}
