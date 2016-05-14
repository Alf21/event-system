/**
 * @author Alf21 on 21.01.2016 in project event-system.
 * Copyright (c) 2015 Alf21. All rights reserved.
 */
package me.alf21.npcs;

import java.util.ArrayList;

import net.gtaun.shoebill.constant.SkinModel;
import net.gtaun.shoebill.fcnpc.FCNPC;
import net.gtaun.shoebill.fcnpc.constant.MoveType;
import net.gtaun.shoebill.object.Player;
import net.gtaun.shoebill.object.World;
import me.alf21.eventsystem.EventData;
import me.alf21.eventsystem.EventFunctions;
import me.alf21.eventsystem.EventNPC;
import me.alf21.eventsystem.EventNPCData;
import me.alf21.eventsystem.EventNPCFunctions;

/**
 * @author Alf21
 *
 */
public class Exploder extends EventNPC {

	public Exploder() { }
	
	/* (non-Javadoc)
	 * @see me.alf21.eventsystem.EventNPC#create()
	 */
	@Override
	public void create(EventNPCData npcData) {
		npcData.setRespawnDelay(5000);
	}
	
	/* (non-Javadoc)
	 * @see me.alf21.eventsystem.EventNPC#update(me.alf21.eventsystem.EventNPCData)
	 */
	@Override
	public void update(EventNPCData npcData) {
		EventData eventData = npcData.getEventData();
		FCNPC npc = npcData.getFCNPC();
		FCNPC issuer = npcData.getIssuer();
		if(!npc.isDead() && npc.isSpawned()) {
			npcData.setLastLocation(npc.getLocation());
			if(issuer == null) {
				Player player = EventFunctions.getNearestPlayer(npc.getLocation(), 20, EventFunctions.getAllPlayers(eventData));
				FCNPC enemy = EventNPCFunctions.getNearestFCNPC(npc.getLocation(), 20, getEnemies(npcData));
				if(player != null && enemy != null) {
					if(npc.getLocation().distance(player.getLocation()) <= npc.getLocation().distance(enemy.getLocation())) {
						explode(npc, player);
					}
					else {
						explode(npc, enemy);
					}
				}
				else {
					if(player != null) {
						explode(npc, player);
					}
					else if(enemy != null) {
						explode(npc, enemy);
					}
					else {
						npc.stop();
						EventNPCFunctions.stopAttack(npc);
					}
				}
			}
			else {
				if(issuer.getLocation().distance(npc.getLocation()) <= 20) {
					explode(npc, issuer);
				}
				else {
					npcData.setIssuer(null);
				}
			}
		}
	}
	
	/**
	 * explode npc on targets range
	 * @param npc the FCNPC
	 * @param target the target
	 */
	public void explode(FCNPC npc, FCNPC target) {
		if(npc.getLocation().distance(target.getLocation()) > 2)
			EventNPCFunctions.followTarget(npc, target, MoveType.SPRINT);
		else {
			World.get().createExplosion(npc.getLocation(), 12, 1);
			for(FCNPC o : EventNPCFunctions.getNearbyFCNPCs(npc.getLocation(), 4)) {
				float distance = npc.getLocation().distance(o.getLocation());
				if(distance <= 2) {
					o.setHealth(o.getHealth()-40);
				}
				else if(distance <= 3) {
					o.setHealth(o.getHealth()-30);
				}
				else {
					o.setHealth(o.getHealth()-20);
				}
			}
			npc.kill();
		}
	}
	
	/**
	 * explode npc on targets range
	 * @param npc the FCNPC
	 * @param target the target
	 */
	public void explode(FCNPC npc, Player target) {
		if(npc.getLocation().distance(target.getLocation()) > 2)
			EventNPCFunctions.followTarget(npc, target, MoveType.SPRINT);
		else {
			World.get().createExplosion(npc.getLocation(), 12, 1);
			for(FCNPC o : EventNPCFunctions.getNearbyFCNPCs(npc.getLocation(), 4)) {
				float distance = npc.getLocation().distance(o.getLocation());
				if(distance <= 2) {
					o.setHealth(o.getHealth()-40);
				}
				else if(distance <= 3) {
					o.setHealth(o.getHealth()-30);
				}
				else {
					o.setHealth(o.getHealth()-20);
				}
			}
			npc.kill();
		}
	}
	
	/* (non-Javadoc)
	 * @see me.alf21.eventsystem.EventNPC#getEnemies(me.alf21.eventsystem.EventNPCData)
	 */
	@Override
	public ArrayList<Class<?>> getEnemies(EventNPCData npcData) {
		ArrayList<Class<?>> arrayList = new ArrayList<>();
		arrayList.add(Player.class);
		arrayList.add(Bodyguard.class);
		return arrayList;
	}
	
	/* (non-Javadoc)
	 * @see me.alf21.eventsystem.EventNPC#getAllies(me.alf21.eventsystem.EventNPCData)
	 */
	@Override
	public ArrayList<Class<?>> getAllies(EventNPCData npcData) {
		ArrayList<Class<?>> arrayList = new ArrayList<>();
		arrayList.add(Zombie.class);
		return arrayList;
	}
	
	/* (non-Javadoc)
	 * @see me.alf21.eventsystem.EventNPC#getSkinModel()
	 */
	@Override
	public SkinModel getSkinModel() {
		return SkinModel.SWAT;
	}
	
	/* (non-Javadoc)
	 * @see me.alf21.eventsystem.EventNPC#getMaxLife()
	 */
	@Override
	public float getMaxLife() {
		return 20;
	}
	
	/* (non-Javadoc)
	 * @see me.alf21.eventsystem.EventNPC#onDeath(me.alf21.eventsystem.EventNPCData)
	 */
	@Override
	public void onDeath(EventNPCData npcData) {
		World.get().createExplosion(npcData.getLastLocation(), 12, 1);
	}
}
