package me.alf21.util;

import me.alf21.eventsystem.EventData;
import net.gtaun.shoebill.data.Location;
import net.gtaun.shoebill.data.WeaponData;
import net.gtaun.shoebill.object.Destroyable;
import net.gtaun.shoebill.object.DynamicSampObject;

public class DropWeapon implements Destroyable {
	
	private WeaponData weaponData;
	private Location location;
	private DynamicSampObject object;

	public DropWeapon(Location location, WeaponData weaponData, EventData eventData) {
		this.location = location;
		location.setInteriorId(0);
		location.setWorldId(eventData.getId()+1);
		this.weaponData = weaponData;
		create(eventData.getId()+1, 0, 200, 150);
	}

	/**
	 * by PeteShag ({@link}http://forum.sa-mp.com/showthread.php?t=217076)
	 * collection of weapon objects sorted by weapon style
	 */
	private int[] gunObjectIds = new int[]{
		1575, 331, 333, 334, 335, 336, 337, 338, 339, 341, 321, 322, 323, 324, 325, 326, 342, 343, 344, -1, -1, -1,
		346, 347, 348, 349, 350, 351, 352, 353, 355, 356, 372, 357, 358, 359, 360, 361, 362, 363, 364, 365, 366, 367,
		368, 369, 1575
	};
	
	/**
	 * by PeteShag ({@link}http://forum.sa-mp.com/showthread.php?t=217076)
	 * check and get weapon objects from id
	 * @param weaponId the id of the weaponmodel
	 * @return int the objectId
	 */
	private int getGunObjectID(int weaponId) {
		if (weaponId < 0 || weaponId > 64) {
		    return 1575;
		}
		return gunObjectIds[weaponId];
	}
	
	/**
	 * create a dropped gun
	 * @param worldId the id of the virtual world
	 * @param interiorId the id of the interior
	 * @param streamDistance the streamDistance
	 * @param drawDistance the drawDistance
	 */
	public void create(int worldId, int interiorId, float streamDistance, float drawDistance) {
		int 	weapon = weaponData.getModel().getId(),
				ammo = weaponData.getAmmo();
		if(weapon != 0 && ammo != 0) {
            object = DynamicSampObject.create(getGunObjectID(weapon), location.getX(), location.getY(), location.getZ()-1, 80, 0, 0, worldId, interiorId, streamDistance, drawDistance);
	    }
	}
	
	public Location getLocation() {
		return location;
	}
	public DynamicSampObject getObject() {
		return object;
	}
	public WeaponData getWeaponData() {
		return weaponData;
	}
	
	/*
	 * (non-Javadoc)
	 * @see net.gtaun.shoebill.object.Destroyable#destroy()
	 */
	@Override
	public void destroy() {
		weaponData = null;
		location = null;
		if(object != null) object.destroy();
		object = null;
	}

	/* (non-Javadoc)
	 * @see net.gtaun.shoebill.object.Destroyable#isDestroyed()
	 */
	@Override
	public boolean isDestroyed() {
		return object == null;
	}
}
