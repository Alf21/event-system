/**
 * @author Alf21 on 21.01.2016 in project event-system.
 * Copyright (c) 2015 Alf21. All rights reserved.
 */

package me.alf21.util;

import java.util.ArrayList;

import me.alf21.eventsystem.EventData;
import me.alf21.eventsystem.EventSystem;
import net.gtaun.shoebill.constant.WeaponSlot;
import net.gtaun.shoebill.data.Color;
import net.gtaun.shoebill.data.Location;
import net.gtaun.shoebill.data.WeaponData;
import net.gtaun.shoebill.object.Destroyable;
import net.gtaun.shoebill.object.DynamicSampObject;
import net.gtaun.shoebill.object.Label;
import net.gtaun.shoebill.object.Player;
import net.gtaun.wl.lang.LocalizedStringSet;

public class TTTDeadBody implements Destroyable {
	
	private DynamicSampObject[] objects;
	private Location location;
	private String name;
	private boolean confirmed;
	private Label deadBodyLabel;
	private ArrayList<WeaponData> weaponDatas;
	private boolean dialogOpened;
    private static LocalizedStringSet localizedStringSet = EventSystem.getInstance().getLocalizedStringSet();
	
	public TTTDeadBody(EventData eventData, Player player) {
		dialogOpened = false;
		float	x = player.getLocation().getX(),
				y = player.getLocation().getY(),
				z = player.getLocation().getZ()-0.9f;
		objects = new DynamicSampObject[]{
			DynamicSampObject.create(2907, x, y, z, 0, 0, 274, eventData.getId()+1, 0, 200, 150), //torso
			DynamicSampObject.create(2905, x+0.85376f, y+0.161621f, z-0.01857662f, 0, 26, 278, eventData.getId()+1, 0, 200, 150), //leg
			DynamicSampObject.create(2905, x+0.739746f, y-0.158935f, z+0.006423f, 356.68469238281f, 145.93511962891f, 263.75891113281f, eventData.getId()+1, 0, 200, 150), //leg
			DynamicSampObject.create(2906, x-0.081787f, y+0.239991f, z-0.03601265f, 359.30590820313f, 273.93939208984f, 298.02392578125f, eventData.getId()+1, 0, 200, 150), //arm
			DynamicSampObject.create(2906, x-0.024414f, y-0.30957f, z-0.03601265f, 359.01071166992f, 339.99688720703f, 242.68936157227f, eventData.getId()+1, 0, 200, 150) //arm
		};
		location = player.getLocation();
		location.setInteriorId(0);
		location.setWorldId(eventData.getId()+1);
		name = player.getName();
		confirmed = false;
		deadBodyLabel = Label.create(localizedStringSet.get(player, "Event.Object.DeadBody.Label"), Color.WHITE, location, 200, true);
		
		weaponDatas = new ArrayList<>();
		for(WeaponSlot weaponSlot : WeaponSlot.values()) {
			weaponDatas.add(player.getWeaponData(weaponSlot.getSlotId()));
		}
	}
	
	public Location getLocation() {
		return location;
	}
	public String getName() {
		return name;
	}
	public DynamicSampObject[] getObjects() {
		return objects;
	}
	
	public void setConfirmed(boolean confirmed) {
		this.confirmed = confirmed;
	}
	public boolean isConfirmed() {
		return confirmed;
	}
	public ArrayList<WeaponData> getWeaponDatas() {
		return weaponDatas;
	}
	public boolean isDialogOpened() {
		return dialogOpened;
	}
	public void setDialogOpened(boolean dialogOpened) {
		this.dialogOpened = dialogOpened;
	}
	
	public Label getLabel() {
		return deadBodyLabel;
	}
	
	public boolean isEmpty() {
		return weaponDatas.isEmpty() && confirmed;
	}

	/* (non-Javadoc)
	 * @see net.gtaun.shoebill.object.Destroyable#isDestroyed()
	 */
	@Override
	public boolean isDestroyed() {
		return !(deadBodyLabel != null || objects != null);
	}
	
	/*
	 * (non-Javadoc)
	 * @see net.gtaun.shoebill.object.Destroyable#destroy()
	 */
	@Override
	public void destroy() {
		for(DynamicSampObject dynamicSampObject : objects) {
			dynamicSampObject.destroy();
		}
		if(deadBodyLabel != null && !deadBodyLabel.isDestroyed()) 
			deadBodyLabel.destroy();
		objects = null;
		location = null;
		name = null;
		confirmed = false;
		deadBodyLabel = null;
		weaponDatas = null;
	}
}
