/**
 * @author Alf21 on 18.12.2015 in project event-system.
 * Copyright (c) 2015 Alf21. All rights reserved.
 */
package me.alf21.eventsystem;

import java.util.ArrayList;
import java.util.stream.Collectors;

import me.alf21.util.LocationSlot;
import net.gtaun.shoebill.data.AngledLocation;
import net.gtaun.shoebill.data.Location;
import net.gtaun.shoebill.fcnpc.FCNPC;
import net.gtaun.shoebill.fcnpc.constant.MoveType;
import net.gtaun.shoebill.object.Player;

/**
 * @author Alf21
 *
 */
public class EventNPCFunctions {
	
	final static float fightDistance = 0.5f;
	final static float maxDistance = 1.5f;

	public EventNPCFunctions() {

	}
	
	/**
	 * get the NPC Datas of a player
	 * @param eventData the event
	 * @return ArrayList of EventNPCData
	 */
	public static ArrayList<EventNPCData> getEventNPCDatas(EventData eventData) {
		return EventNPCBase.getNPCDatas().stream().filter(npcData -> npcData.getEventData() == eventData).collect(Collectors.toCollection(ArrayList::new));
	}
	
	/**
	 * get eventNPCData from FCNPC
	 * @param npc the FCNPC
	 * @return EventNPCData the eventNPCData
	 */
	public static EventNPCData getEventNPCData(FCNPC npc) {
		for(EventNPCData eventNPCData : EventNPCBase.getNPCDatas()) {
			if(eventNPCData.getFCNPC() == npc)
				return eventNPCData;
		}
		return null;
	}
	
	/**
	 * onSpawnEvent
	 * @param npc the FCNPC
	 */
	public static void spawn(FCNPC npc) {
		EventNPCData npcData = getEventNPCData(npc);
		try {
			assert npcData != null;
			npc.setHealth(((EventNPC) npcData.getClz().newInstance()).getMaxLife());
		} catch (InstantiationException | IllegalAccessException e1) {
			System.out.println(e1);
			e1.printStackTrace();
		}
		Location location = npcData.getEventData().getLocation();
		if(npcData.getEventData().getMap() != null) location = npcData.getEventData().getMap().getLocation();
		if(location == null) location = npcData.getEventData().getOwner().getLocation();
		if(npc.isDead()) 
			npc.respawn();
		if(!npc.isSpawned())
			try {
				npc.spawn(((EventNPC) npcData.getClz().newInstance()).getSkinModel(), location);
			} catch (InstantiationException | IllegalAccessException e) {
				System.out.println(e);
				e.printStackTrace();
			}
		else npc.setLocation(new AngledLocation(location, npc.getAngle()));
		
		npc.setWorld(npcData.getEventData().getId()+1);
		npc.setInterior(0);
	}

	/**
	 * get nearest FCNPCs of a location depends on a maximal distance between FCNPCs and location
	 * @param location the main / origin location
	 * @param maxDistance the maximal distance / range
	 * @return ArrayList of FCNPC
	 */
    public static ArrayList<FCNPC> getNearbyFCNPCs(Location location, float maxDistance) {
        ArrayList<FCNPC> fcnpcs = new ArrayList<>();
        for (FCNPC fcnpc : FCNPC.get()) {
            float distance = fcnpc.getLocation().distance(location);
            if (distance <= maxDistance && !fcnpc.isDead()) {
                fcnpcs.add(fcnpc);
            }
        }
        return fcnpcs;
    }
    
    /**
     * get nearest FCNPC of a location depends on a maximal distance between FCNPCs and location
     * @param location the main / origin location
     * @return FCNPC the nearest FCNPC
     */
    public static FCNPC getNearestFCNPC(Location location) {
    	float min = -1;
    	FCNPC nearestFCNPC = null;
        for (FCNPC fcnpc : FCNPC.get()) {
        	if(!fcnpc.isDead()) {
	            float distance = location.distance(fcnpc.getLocation());
	            if (distance < min || min == -1) {
	                nearestFCNPC = fcnpc;
	                min = distance;
	            }
        	}
        }
        return nearestFCNPC;
    }
    
    /**
     * get nearest FCNPC of a location depends on a maximal distance between FCNPCs and location
     * @param location the main / origin location
     * @param maxDistance the maximal distance / range
     * @return FCNPC the nearest FCNPC
     */
    public static FCNPC getNearestFCNPC(Location location, float maxDistance) {
    	float min = -1;
    	FCNPC nearestFCNPC = null;
        for (FCNPC fcnpc : FCNPC.get()) {
        	if(!fcnpc.isDead()) {
	            float distance = location.distance(fcnpc.getLocation());
	            if (distance <= maxDistance && distance < min || distance <= maxDistance && min == -1) {
	                nearestFCNPC = fcnpc;
	                min = distance;
	            }
        	}
        }
        return nearestFCNPC;
    }
    
    /**
     * get nearest FCNPC with free slots of a location depends on a maximal distance between FCNPCs and location
     * @param location the main / origin location
     * @param maxDistance the maximal distance / range
     * @return FCNPC the nearest FCNPC
     */
    public static FCNPC getNearestAvailableFCNPC(AngledLocation location, float maxDistance) {
    	float min = -1;
    	FCNPC nearestFCNPC = null;
        for (FCNPC fcnpc : FCNPC.get()) {
            AngledLocation slotLocation = LocationSlot.getNearestSlotLocation(location, fcnpc.getLocation(), EventNPCFunctions.maxDistance, true);
        	if(slotLocation != null && !fcnpc.isDead()) {
	            float distance = location.distance(fcnpc.getLocation());
	            if (distance <= maxDistance && distance < min || distance <= maxDistance && min == -1) {
	                nearestFCNPC = fcnpc;
	                min = distance;
	            }
        	}
        }
        return nearestFCNPC;
    }
    
    /**
     * get nearest FCNPC of a location depends on a maximal distance between FCNPCs and location
     * @param location the main / origin location
     * @param maxDistance the maximal distance / range
     * @param targets an ArrayList of Classes
     * @return FCNPC the nearest FCNPC
     */
    public static FCNPC getNearestFCNPC(Location location, float maxDistance, ArrayList<Class<?>> targets) {
    	float min = -1;
    	FCNPC nearestFCNPC = null;
        for (FCNPC fcnpc : FCNPC.get()) {
        	if(!fcnpc.isDead()) {
	            if(targets.contains(getEventNPCData(fcnpc).getClz())) {
	            	float distance = location.distance(fcnpc.getLocation());
		            if (distance <= maxDistance && distance < min || distance <= maxDistance && min == -1) {
		                nearestFCNPC = fcnpc;
		                min = distance;
		            }
	        	}
        	}
        }
        return nearestFCNPC;
    }
    
    /**
     * get nearest FCNPC with free slots of a location depends on a maximal distance between FCNPCs and location
     * @param location the main / origin location
     * @param maxDistance the maximal distance / range
     * @param targets an ArrayList of Classes
     * @return FCNPC the nearest FCNPC
     */
    public static FCNPC getNearestAvailableFCNPC(AngledLocation location, float maxDistance, ArrayList<Class<?>> targets) {
    	float min = -1;
    	FCNPC nearestFCNPC = null;
        for (FCNPC fcnpc : FCNPC.get()) {
            AngledLocation slotLocation = LocationSlot.getNearestSlotLocation(location, fcnpc.getLocation(), EventNPCFunctions.maxDistance, true);
        	if(slotLocation != null && !fcnpc.isDead()) {
	            if(targets.contains(getEventNPCData(fcnpc).getClz())) {
	            	float distance = location.distance(fcnpc.getLocation());
		            if (distance <= maxDistance && distance < min || distance <= maxDistance && min == -1) {
		                nearestFCNPC = fcnpc;
		                min = distance;
		            }
	        	}
        	}
        }
        return nearestFCNPC;
    }
    
// NPC Functions
    /**
     * FCNPC follows a player
     * @param npc the FCNPC
     * @param target the target player
     * @param moveType the MoveType
     * @return boolean
     */
    public static boolean followTarget(FCNPC npc, Player target, MoveType moveType) {
    	//if(npc.getLocation().distance(target.getLocation()) > 1.5f) {
    	AngledLocation location = LocationSlot.getNearestSlotLocation(npc.getLocation(), target.getLocation(), fightDistance, true);
    	if(location == null) 
    		return false;
    	if(npc.getLocation().distance(location) > maxDistance) {
			npc.goTo(location, moveType, 0, false);
	    }
    	else {
    		if(npc.isMoving())
    			npc.stop();
    	}
		return true;
    }
    
    /**
     * FCNPC follows a player
     * @param npc the FCNPC
     * @param target the target player
     * @param moveType the MoveType
     * @param range the range between new location and player
     * @return boolean
     */
    public static boolean followTarget(FCNPC npc, Player target, MoveType moveType, float range) {
    	//if(npc.getLocation().distance(target.getLocation()) > range) {
    	AngledLocation location = LocationSlot.getNearestSlotLocation(npc.getLocation(), target.getLocation(), range, true);
    	if(location == null) 
    		return false;
    	if(npc.getLocation().distance(location) > maxDistance) {
			npc.goTo(location, moveType, 0, false);
	    }
    	else {
    		if(npc.isMoving())
    			npc.stop();
    	}
		return true;
    }
    
    /**
     * FCNPC follows a FCNPC
     * @param npc the FCNPC
     * @param target the target FCNPC
     * @param moveType the MoveType
     * @return boolean
     */
    public static boolean followTarget(FCNPC npc, FCNPC target, MoveType moveType) {
		//if(npc.getLocation().distance(target.getLocation()) > 1.5f) {
    	AngledLocation location = LocationSlot.getNearestSlotLocation(npc.getLocation(), target.getLocation(), fightDistance, true);
    	if(location == null) 
    		return false;
    	if(npc.getLocation().distance(location) > maxDistance) {
			npc.goTo(location, moveType, 0, false);
	    }
    	else {
    		if(npc.isMoving())
    			npc.stop();
    	}
		return true;
    }
    
    /**
     * stop FCNPC attack
     * @param npc the FCNPC
     */
    public static void stopAttack(FCNPC npc) {
		npc.stopAttack();
		if(npc.isAiming()) {
			npc.stopAim();
		}
    }
    
    /**
     * FCNPC punch a player
     * @param npc the FCNPC
     * @param target the target player
     * @param moveType the MoveType
     */
    public static void punchTarget(FCNPC npc, Player target, MoveType moveType) {
    	if(npc.getLocation().distance(target.getLocation()) > maxDistance) {
    		stopAttack(npc);
		    /*
			if(!followTarget(npc, target, moveType)) {
				// target = changeTarget(npc, target);
			}
			*/
		} else {
			if(!npc.isAiming()) {
	    		if(npc.isMoving())
	    			npc.stop();
				npc.aimAt(target.getLocation(), false);
				npc.meleeAttack(100);
			}
			else npc.aimAt(target.getLocation(), false);
		}
    }
    
    /**
     * FCNPC punch a FCNPC
     * @param npc the FCNPC
     * @param target the target FCNPC
     * @param moveType the MoveType
     */
    public static void punchTarget(FCNPC npc, FCNPC target, MoveType moveType) {
    	if(npc.getLocation().distance(target.getLocation()) > maxDistance) {
    		stopAttack(npc);
		    /*
			if(!followTarget(npc, target, moveType)) {
			//	target = changeTarget(npc, target);
			}
			*/
		} else {
			if(!npc.isAiming()) {
	    		if(npc.isMoving())
	    			npc.stop();
				npc.aimAt(target.getLocation(), false);
				npc.meleeAttack(100);
			}
			else npc.aimAt(target.getLocation(), false);
		}
    }
    
    public static boolean isAbleToGetPunched(Player player) {
    	return true;
    }
    
    public static boolean isAbleToGetPunched(FCNPC npc) {
    	return true;
    }
}
