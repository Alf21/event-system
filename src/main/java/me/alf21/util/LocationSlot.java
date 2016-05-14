/**
 * 
 */
package me.alf21.util;

import me.alf21.eventsystem.EventFunctions;
import me.alf21.eventsystem.EventNPCFunctions;
import net.gtaun.shoebill.data.AngledLocation;
import net.gtaun.shoebill.data.Location;
import net.gtaun.shoebill.fcnpc.FCNPC;
import net.gtaun.shoebill.object.Player;

/**
 * @author Alf21
 *
 */
public enum LocationSlot {
//	FRONT,
//	RIGHT,
//	LEFT,
//	BACK,
	FRONTRIGHT,
	FRONTLEFT,
	BACKLEFT,
	BACKRIGHT;

	/**
	 * get the location of a slot around of a player (8 Slots available)<br>
	 * --------------------------------------------<br>
	 * |      x      | (FRONT)                    |<br>
	 * |    x   x    | (FRONTLEFT and FRONTRIGHT) |<br>
	 * |  x   O   x  | (LEFT and RIGHT)           |<br>
	 * |    x   x    | (BACKLEFT and BACKRIGHT)   |<br>
	 * |      x      | (BACK)                     |<br>
	 * --------------------------------------------<br>
	 * | Legend:                                  |<br>
	 * | [O] = Target                             |<br>
	 * | [x] = available Slot                     |<br>
	 * --------------------------------------------
	 * @param location the location
	 * @param slot the slot
	 * @param range the range around of the location (distance between location and slotLocation)
	 * @return AngledLocation the slotLocation
	 */
	public static AngledLocation getSlotLocation(AngledLocation location, LocationSlot slot, float range) {
		int angle = 0;
		AngledLocation angledLocation = new AngledLocation(location);
		switch(slot) {
/*			case FRONT:
				location.setY(location.getY()+range);
				break;
			case RIGHT:
				location.setX(location.getX()+range);
				break;
			case LEFT:
				location.setX(location.getX()-range);
				break;
			case BACK:
				location.setY(location.getY()-range);
				break;
*/			case FRONTRIGHT:
				angle = 45;
				break;
			case FRONTLEFT:
				angle = 135;
				break;
			case BACKLEFT:
				angle = 225;
				break;
			case BACKRIGHT:
				angle = 315;
				break;
		}
		// attention, if changing calculations, check whether ANGLE is zero !
		angledLocation.setX(angledLocation.getX()+(float) (range * Math.cos(Math.toRadians(angle))));
		angledLocation.setY(angledLocation.getY()+(float) (range * Math.sin(Math.toRadians(angle))));
		return angledLocation;
	}
	
	/**
	 * get the nearest locationSlot
	 * @param location the startlocation
	 * @param targetLocation the finishlocation
	 * @param range the range between finishlocation and player
	 * @param checkAvailable check if locationSlot is used or available
	 * @return AngledLocation
	 */
	public static AngledLocation getNearestSlotLocation(AngledLocation location, AngledLocation targetLocation, float range, boolean checkAvailable) {
		//TODO wenn slot 4 voll ist -> 3 oder 1 checken; sonst 2 <- sonst warten oder wenn anderes Ziel: suchen (wenn Slots nicht durch Bodyguards besetzt, sonst diese angreifen)
		//TODO wenn slot 3 voll ist -> 4 oder 2 checken; sonst 1 <- ~
		//TODO wenn slot 2 voll ist -> 3 oder 1 checken; sonst 4 <- ~
		//TODO wenn slot 1 voll ist -> 4 oder 2 checken; sonst 3 <- ~
		float distance = -1;
		boolean init = false;
		AngledLocation nearest = null;
		for(LocationSlot locationSlot : LocationSlot.values()) {
			AngledLocation slotLocation = getSlotLocation(targetLocation, locationSlot, range);
			if(isLocationSlotAvailable(location, slotLocation, targetLocation)) {
				if(!init) {
					init = true;
					nearest = slotLocation;
					distance = slotLocation.distance(location);
				}
				else {
					float dist = slotLocation.distance(location);
					if(dist < distance) {
						nearest = slotLocation;
						distance = dist;
					}
				}
			}
		}
		return nearest;
	}
	
	/**
	 * check if a LocationSlot is available
	 * @param currentLocation the current location of an object
	 * @param slotLocation the location of the LocationSlot
	 * @param targetLocation the location of the target
	 * @return boolean
	 */
	public static boolean isLocationSlotAvailable(AngledLocation currentLocation, Location slotLocation, Location targetLocation) {
		Object target = EventFunctions.getNearestPlayer(targetLocation);
		if(target == null) 
			target = EventNPCFunctions.getNearestFCNPC(targetLocation);
		if(target != null) {
			if(!EventFunctions.getNearbyPlayers(slotLocation, 2f).isEmpty()) {
				if(target instanceof Player) {
					if(EventFunctions.getNearestPlayer(slotLocation) != target)
						return false;
				}
				else return false;
			}
			if(!EventNPCFunctions.getNearbyFCNPCs(slotLocation, 2f).isEmpty()) {
				if(target instanceof FCNPC) {
					if(EventNPCFunctions.getNearestFCNPC(slotLocation) != target) {
						if(EventNPCFunctions.getNearestFCNPC(slotLocation) != EventNPCFunctions.getNearestFCNPC(currentLocation)) {
							return false;
						}
					}
				}
				else if(EventNPCFunctions.getNearestFCNPC(slotLocation) != EventNPCFunctions.getNearestFCNPC(currentLocation)) {
					return false;
				}
			}
		}
		return true;
	}
}
