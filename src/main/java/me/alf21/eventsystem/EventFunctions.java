/**
 * @author Alf21 on 18.12.2015 in project event-system.
 * Copyright (c) 2015 Alf21. All rights reserved.
 */

package me.alf21.eventsystem;

import java.lang.annotation.Annotation;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.stream.Collectors;

import me.alf21.util.LocationSlot;
import net.gtaun.shoebill.data.AngledLocation;
import net.gtaun.shoebill.data.Location;
import net.gtaun.shoebill.object.Player;
import net.gtaun.wl.lang.LocalizedStringSet;

public class EventFunctions {
	
	/**
	 * sort a player array / list compared to playernames
	 * @param playerList the list / array of players
	 */
	public static void sortPlayerlist(ArrayList<Player> playerList) {
		Collections.sort(playerList, (o1, o2) -> o1.getName().compareTo(o2.getName()));
	}
	
	/**
	 * sort a event array / list: 1. EventDescription, 2. EventName
	 * @param eventDataList the list / array of events
	 */
	public static void sortEventList(EventData[] eventDataList) {
		Arrays.sort(eventDataList, (o1, o2) -> {
		    String x1 = EventFunctions.getDescriptionForEvent(((EventData) o1).getClz()).name();
		    String x2 = EventFunctions.getDescriptionForEvent(((EventData) o2).getClz()).name();
		    int sComp = x1.compareTo(x2);

		    if (sComp != 0) {
		       return sComp;
		    } else {
		       x1 = o1.getName();
		       x2 = o2.getName();
		       return x1.compareTo(x2);
		    }
		});
	}
	
	/**
	 * transform a int into a String with timeformat
	 * @param seconds the seconds which need to calculated into a timeformat
	 * @return String
	 */
	public static String timeToString(int seconds) {
	//	return new SimpleDateFormat("HH:mm:ss").format(new Date((long)(seconds*1000)));
		String string = new SimpleDateFormat("mm:ss").format(new Date((long)(seconds*1000)));
		string = String.valueOf(seconds/60/60) + ":" + string;
		return string;
	}
	
	/**
	 * transform a player array into a readable string with their names
	 * @param players the array / list of players
	 * @return String
	 */
	public static String arrayToString(ArrayList<Player> players) {
		String string = "";
		if(!players.isEmpty()) {
			if(players.size() == 1) string = players.get(0).getName();
			else {
				int i = 1;
				for(Player player : players) {
					if(i != 1) {
						if(i == players.size()) string += " & ";
						else string += ", ";
					}
					string += player.getName();
					i++;
				}
			}
		}
		return string;
	}

	/**
	 * transform a string array into a readable string
	 * @param strings the array / list of strings
	 * @return String
	 */
	public static String arrayToString(String[] strings) {
		String string = "";
		if(strings.length > 0) {
			if(strings.length == 1) string = strings[0];
			else {
				int i = 1;
				for(String string2 : strings) {
					if(i != 1) {
						if(i == strings.length) string += " & ";
						else string += ", ";
					}
					string += string2;
					i++;
				}
			}
		}
		return string;
	}
	
	/**
	 * check if player is in the radius of the target or target is in the radius of player
	 * @param player the player
	 * @param target the other player
	 * @param range the radius which need to be checked, whether both players are inside
	 * @return boolean
	 */
	public static boolean isInRadius(Player player, Player target, float range) {
		return player != null && target != null && range > 0 && target.getLocation().distance(player.getLocation()) <= range;
	}

	/**
	 * get all players of an event including the owner
	 * @param eventData the event
	 * @return ArrayList of Player
	 */
	public static ArrayList<Player> getAllPlayers(EventData eventData) {
		if(eventData != null) {
			ArrayList<Player> allPlayers = eventData.getPlayerList().stream().collect(Collectors.toCollection(ArrayList::new));
			allPlayers.add(eventData.getOwner());
			return allPlayers;
		} return new ArrayList<>();
	}
	
	/**
	 * get the event textdraw class from the event by the text of the textdraw
	 * @param eventData the event
	 * @param string the text of the textdraw
	 * @return EventTextdraw
	 */
	public static EventTextdraw getEventTextdraw(EventData eventData, String string) {
		for(EventTextdraw eventTextdraw : eventData.getEventTextdraws()) {
			if(eventTextdraw.getTextdraw().getText().equals(string))
				return eventTextdraw;
		}
		return null;
	}
	
	/**
	 * Created by marvin on 10.01.15 in project roleplay.
	 * Copyright (c) 2015 Marvin Haschker. All rights reserved.
	 * get nearest players of a location depends on a maximal distance between players and location
	 * @param location the main / origin location
	 * @param maxDistance the maximal distance / range
	 * @return ArrayList of Player
	 */
    public static ArrayList<Player> getNearbyPlayers(Location location, float maxDistance) {
        ArrayList<Player> players = new ArrayList<>();
        for (Player player : Player.getHumans()) {
            float distance = player.getLocation().distance(location);
            if (distance <= maxDistance) {
                players.add(player);
            }
        }
        return players;
    }
    
    /**
     * get nearest player of a location depends on a maximal distance between players and location
     * @param location the main / origin location
     * @return Player the nearest player
     */
    public static Player getNearestPlayer(Location location) {
    	float min = -1;
    	Player nearestPlayer = null;
        for (Player player : Player.getHumans()) {
            float distance = location.distance(player.getLocation());
            if (distance < min || min == -1) {
                nearestPlayer = player;
                min = distance;
            }
        }
        return nearestPlayer;
    }
    
    /**
     * get nearest player of a location depends on a maximal distance between players and location
     * @param location the main / origin location
     * @param maxDistance the maximal distance / range
     * @return Player the nearest player
     */
    public static Player getNearestPlayer(Location location, float maxDistance) {
    	float min = -1;
    	Player nearestPlayer = null;
        for (Player player : Player.getHumans()) {
            float distance = location.distance(player.getLocation());
            if (distance <= maxDistance && distance < min || distance <= maxDistance && min == -1) {
                nearestPlayer = player;
                min = distance;
            }
        }
        return nearestPlayer;
    }
    
    /**
     * get nearest player with free slots of a location depends on a maximal distance between players and location
     * @param location the main / origin location
     * @param maxDistance the maximal distance / range
     * @return Player the nearest player
     */
    public static Player getNearestAvailablePlayer(AngledLocation location, float maxDistance) {
    	float min = -1;
    	Player nearestPlayer = null;
        for (Player player : Player.getHumans()) {
        	AngledLocation slotLocation = LocationSlot.getNearestSlotLocation(location, player.getLocation(), EventNPCFunctions.maxDistance, true);
        	if(slotLocation != null) {
	            float distance = location.distance(player.getLocation());
	            if (distance <= maxDistance && distance < min || distance <= maxDistance && min == -1) {
	                nearestPlayer = player;
	                min = distance;
	            }
        	}
        }
        return nearestPlayer;
    }
    
    /**
     * get nearest player of a location depends on a maximal distance between players and location and the given players
     * @param location the main / origin location
     * @param maxDistance the maximal distance / range
     * @param players the array of players
     * @return Player the nearest player
     */
    public static Player getNearestPlayer(Location location, float maxDistance, ArrayList<Player> players) {
    	float min = -1;
    	Player nearestPlayer = null;
        for (Player player : players) {
            float distance = location.distance(player.getLocation());
            if (distance <= maxDistance && distance < min || distance <= maxDistance && min == -1) {
                nearestPlayer = player;
                min = distance;
            }
        }
        return nearestPlayer;
    }
    
    /**
     * get nearest player with free slots of a location depends on a maximal distance between players and location and the given players
     * @param location the main / origin location
     * @param maxDistance the maximal distance / range
     * @param players the array of players
     * @return Player the nearest player
     */
    public static Player getNearestAvailablePlayer(AngledLocation location, float maxDistance, ArrayList<Player> players) {
    	float min = -1;
    	Player nearestPlayer = null;
        for (Player player : players) {
        	AngledLocation slotLocation = LocationSlot.getNearestSlotLocation(location, player.getLocation(), EventNPCFunctions.maxDistance, true);
        	if(slotLocation != null) {
	            float distance = location.distance(player.getLocation());
	            if (distance <= maxDistance && distance < min || distance <= maxDistance && min == -1) {
	                nearestPlayer = player;
	                min = distance;
	            }
        	}
        }
        return nearestPlayer;
    }
    
    /**
     * get the event description with multi language support - include the name in language file like 'Event.Class.[NAME].Description'
     * @param player the player to get the language of
     * @param eventTypeName the name of the eventtype to find the description in language files
     * @return String the translated Description
     */
    public static String getDescription(Player player, String eventTypeName) {
    	LocalizedStringSet localizedStringSet = EventSystem.getInstance().getLocalizedStringSet();
    	String description = localizedStringSet.get(player, "Dialog.Empty");
    	String key = "Event.Class." + eventTypeName + ".Description";
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
    	String key = "Event.Class." + eventTypeName + ".Name";
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
    public static EventDescription getDescriptionForEvent(Class<?> clz) {
        if (clz == null || clz.getAnnotations().length == 0 || !(clz.getAnnotations()[0] instanceof EventDescription))
            return new EventDescription() {
	            @Override
	            public boolean equals(Object obj) {
		            return false;
	            }

	            @Override
	            public int hashCode() {
		            return 0;
	            }

	            @Override
	            public String toString() {
		            return null;
	            }

	            @Override
	            public Class<? extends Annotation> annotationType() {
		            return null;
	            }

	            @Override
	            public String name() {
		            return "unknown";
	            }

	            @Override
	            public int playerValueMin() {
		            return -1;
	            }

	            @Override
	            public int playerValueMax() {
		            return 2;
	            }

	            @Override
	            public String credits() {
		            return "unknown";
	            }
            };
        return (EventDescription) clz.getAnnotations()[0];
    }

    /**
     * Liefert das EventMapDescription-Objekt f&uuml;r die jeweilige Map
     * @param clz Eventklasse
     * @return Beschreibung
     */
    public static EventMapDescription getDescriptionForMap(Class<?> clz) {
        if (clz.getAnnotations().length == 0 || !(clz.getAnnotations()[0] instanceof EventMapDescription))
            return null;
        return (EventMapDescription) clz.getAnnotations()[0];
    }
}
