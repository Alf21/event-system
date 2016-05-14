/**
 * @author Alf21 on 18.12.2015 in project event-system.
 * Copyright (c) 2015 Alf21. All rights reserved.
 */

package me.alf21.eventsystem;

import java.util.ArrayList;

import me.alf21.util.DropWeapon;
import net.gtaun.shoebill.data.Location;
import net.gtaun.shoebill.data.WeaponData;
import net.gtaun.shoebill.object.DynamicSampObject;

public class EventMapBase {
	private DynamicSampObject[] dynamicSampObjects;
	private Location location;
	private Location[] weaponSpawnLocations;
	private ArrayList<DropWeapon> dropWeapons;
	private float minX, minY, minZ, maxX, maxY, maxZ;
	private Class<?> clz;

	public EventMapBase(Class<?> clz) {
		dynamicSampObjects = new DynamicSampObject[0];
		location = new Location();
		dropWeapons = new ArrayList<>();
		this.clz = clz;
	}
	
	/**
	 * destroy the EventMap
	 */
	public void destroy() {
		try {
			((EventMap) clz.newInstance()).destroy();
		} catch (InstantiationException | IllegalAccessException e) {
			System.out.println(e);
			e.printStackTrace();
		}
		if(dynamicSampObjects != null && dynamicSampObjects.length > 0) {
			for(DynamicSampObject dynamicSampObject : dynamicSampObjects) {
				dynamicSampObject.destroy();
			}
		}
		dynamicSampObjects = null;
		location = null;
		if(dropWeapons != null && dropWeapons.size() > 0) {
			for(DropWeapon dropWeapon : dropWeapons) {
				dropWeapon.destroy();
			}
		}
		dropWeapons = null;
		weaponSpawnLocations = null;
		clz = null;
	}
	
	/**
	 * get spawn location for players
	 * @return Location
	 */
	public Location getLocation() {
		return location;
	}
	
	/**
	 * get objects of the map
	 * @return DynamicSampObject[]
	 */
	public DynamicSampObject[] getDynamicSampObjects() {
		return dynamicSampObjects;
	}
	
	/**
	 * get the dropWeapon arrayList on the map
	 * @return ArrayList of DropWeapon
	 */
	public ArrayList<DropWeapon> getDropWeapons() {
		return dropWeapons;
	}
	
	/**
	 * create a EventMap
	 * @param worldId the id of the virtual world
	 * @param interiorId the id of the interior
	 * @param streamDistance the streamDistance
	 * @param drawDistance the drawDistance
	 * @param eventData the event
	 * @param weaponData the data of weapon set
	 */
	public void create(int worldId, int interiorId, float streamDistance, float drawDistance, EventData eventData, WeaponData weaponData) {
		try {
			dynamicSampObjects = ((EventMap) clz.newInstance()).create(worldId, interiorId, streamDistance, drawDistance, eventData, weaponData);
			location = ((EventMap) clz.newInstance()).getLocation();
			location.setWorldId(worldId);
			location.setInteriorId(interiorId);
			weaponSpawnLocations = ((EventMap) clz.newInstance()).getWeaponLocations();
		} catch (InstantiationException | IllegalAccessException e) {
			System.out.println(e);
			e.printStackTrace();
		}
		dropWeapons = new ArrayList<>();
		for(Location weaponSpawnLocation : weaponSpawnLocations) {
			dropWeapons.add(new DropWeapon(weaponSpawnLocation, weaponData, eventData));
		}
		
		boolean inited = false;
		for(DynamicSampObject dynamicSampObject : dynamicSampObjects) {
			if(!inited) {
				inited = true;
				minX = maxX = dynamicSampObject.getLocation().getX();
				minY = maxY = dynamicSampObject.getLocation().getY();
				minZ = maxZ = dynamicSampObject.getLocation().getZ();
			}
			float 	x = dynamicSampObject.getLocation().getX(),
					y = dynamicSampObject.getLocation().getY(),
					z = dynamicSampObject.getLocation().getZ();
			if(minX > x) minX = x;
			else if(maxX < x) maxX = x;
			if(minY > y) minY = y;
			else if(maxY < y) maxY = y;
			if(minZ > z) minZ = z;
			else if(maxZ < z) maxZ = z;
		}
	}
	
	/**
	 * get max X Coord position of the map
	 * @return float
	 */
	public float getMaxX() {
		return maxX;
	}
	
	/**
	 * get max Y Coord position of the map
	 * @return float
	 */
	public float getMaxY() {
		return maxY;
	}
	
	/**
	 * get max Z Coord position of the map
	 * @return float
	 */
	public float getMaxZ() {
		return maxZ;
	}
	
	/**
	 * get min X Coord position of the map
	 * @return float
	 */
	public float getMinX() {
		return minX;
	}
	
	/**
	 * get min Y Coord position of the map
	 * @return float
	 */
	public float getMinY() {
		return minY;
	}
	
	/**
	 * get min Z Coord position of the map
	 * @return float
	 */
	public float getMinZ() {
		return minZ;
	}
	
	/**
	 * @return the clz
	 */
	public Class<?> getClz() {
		return clz;
	}
}
