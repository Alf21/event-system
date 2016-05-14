/**
 * @author Alf21 on 18.12.2015 in project event-system.
 * Copyright (c) 2015 Alf21. All rights reserved.
 */

package me.alf21.eventsystem;

import net.gtaun.shoebill.data.Location;
import net.gtaun.shoebill.data.WeaponData;
import net.gtaun.shoebill.object.DynamicSampObject;

/**
 * @author Alf21
 */
@EventMapDescription(name = "Main Map Loader", description = "loads the event maps", credits = "Alf21", size = EventMapSize.UNKNOWN)
public abstract class EventMap {

	public EventMap() {}
	
	/**
	 * create the map
	 * @param worldId the id of the virtual world
	 * @param interiorId the id of the interior
	 * @param streamDistance the streamDistance of objects
	 * @param drawDistance the drawDistance of objects
	 * @param eventData the event
	 * @param weaponData the weapondata for spawned weapons
	 * @return DynamicSampObject[]
	 */
	public DynamicSampObject[] create(int worldId, int interiorId, float streamDistance, float drawDistance, EventData eventData, WeaponData weaponData) {
		return new DynamicSampObject[0];
	}
	
	/**
	 * get spawn location for players
	 * @return Location
	 */
	public Location getLocation() {
		return new Location();
	}
	
	/**
	 * get spawn locations for drop weapons
	 * @return Location[]
	 */
	public Location[] getWeaponLocations() {
		return new Location[0];
	}
	
	/**
	 * destroy add-ons for map, e.g. destroy created me.alf21.objects.Gate
	 * IMPORTANT: Do not destroy the location, the weaponDatas, the Objects or the class !
	 */
	public void destroy() {
		
	}
}
