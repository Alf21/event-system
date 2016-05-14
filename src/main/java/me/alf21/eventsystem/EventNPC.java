/**
 * @author Alf21 on 18.12.2015 in project event-system.
 * Copyright (c) 2015 Alf21. All rights reserved.
 */
package me.alf21.eventsystem;

import java.util.ArrayList;

import net.gtaun.shoebill.constant.SkinModel;

/**
 * @author Alf21
 *
 */
public abstract class EventNPC {

	public EventNPC() { }
	
	public void create(EventNPCData npcData) {
		
	}
	
	public void destroy(EventNPCData npcData) {
		
	}
	
	public void update(EventNPCData npcData) {
		
	}
	
	public void onDeath(EventNPCData npcData) {
		
	}
	
	public ArrayList<Class<?>> getEnemies(EventNPCData npcData) {
		return null;
	}
	
	public ArrayList<Class<?>> getNeutrals(EventNPCData npcData) {
		return null;
	}
	
	public ArrayList<Class<?>> getAllies(EventNPCData npcData) {
		return null;
	}
	
	public SkinModel getSkinModel() {
		return SkinModel.CJ;
	}
	
	public float getMaxLife() {
		return 100;
	}
}
