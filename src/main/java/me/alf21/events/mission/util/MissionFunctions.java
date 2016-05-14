/**
 * @author Alf21 on 21.01.2016 in project event-system.
 * Copyright (c) 2015 Alf21. All rights reserved.
 */
package me.alf21.events.mission.util;

import me.alf21.eventsystem.EventSystem;
import net.gtaun.shoebill.object.Player;
import net.gtaun.wl.lang.LocalizedStringSet;

/**
 * @author Alf21
 *
 */
public class MissionFunctions {

	public MissionFunctions() { }
    
    /**
     * get the event description with multi language support - include the name in language file like 'Event.Class.Missions.[NAME].Description'
     * @param player the player to get the language of
     * @param eventTypeName the name of the eventtype to find the description in language files
     * @return String the translated description
     */
    public static String getDescription(Player player, String eventTypeName) {
    	LocalizedStringSet localizedStringSet = EventSystem.getInstance().getLocalizedStringSet();
    	String description = localizedStringSet.get(player, "Dialog.Empty");
    	String key = "Event.Class.Missions.Class." + eventTypeName + ".Description";
    	String localizedString = localizedStringSet.get(player, key);
    	if(!localizedString.equals("#" + key + "#"))
    		description = localizedString;
    	return description;
    }
    
    /**
     * get the event name with multi language support - include the name in language file like 'Event.Class.Missions.[NAME].Name'
     * @param player the player to get the language of
     * @param eventTypeName the name of the eventtype to find the name in language files
     * @return String the translated name
     */
	public static String getName(Player player, String eventTypeName) {
		LocalizedStringSet localizedStringSet = EventSystem.getInstance().getLocalizedStringSet();
    	String name = eventTypeName;
    	String key = "Event.Class.Missions.Class." + eventTypeName + ".Name";
    	String localizedString = localizedStringSet.get(player, key);
    	if(!localizedString.equals("#" + key + "#"))
    		name = localizedString;
    	return name;
	}
    
    /**
     * Liefert das EventDescription-Objekt f&uuml;r das jeweilige Event
     * @param clz Eventklasse
     * @return Beschreibung
     */
    public static MissionDescription getDescriptionForMission(Class<?> clz) {
        if (clz.getAnnotations().length == 0 || !(clz.getAnnotations()[0] instanceof MissionDescription))
            return null;
        return (MissionDescription) clz.getAnnotations()[0];
    }
}
