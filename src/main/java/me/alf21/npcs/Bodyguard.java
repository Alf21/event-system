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
import me.alf21.eventsystem.EventNPC;
import me.alf21.eventsystem.EventNPCData;
import me.alf21.eventsystem.EventNPCFunctions;

/**
 * @author Alf21
 *
 */
public class Bodyguard extends EventNPC {

	public Bodyguard() { }
	
	
	//TODO onPlayerDisconnect: if(player == target) npc.destroy();
	/* (non-Javadoc)
	 * @see me.alf21.eventsystem.EventNPC#create()
	 */
	@Override
	public void create(EventNPCData npcData) {
		
	}
	
	/* (non-Javadoc)
	 * @see me.alf21.eventsystem.EventNPC#update(me.alf21.eventsystem.EventNPCData)
	 */
	@Override
	public void update(EventNPCData npcData) {
		FCNPC npc = npcData.getFCNPC();
		Player target = npcData.getTarget();
		if(!npc.isDead() && npc.isSpawned()) {
			if(target != null) {
				FCNPC enemy = EventNPCFunctions.getNearestAvailableFCNPC(target.getLocation(), 20, getEnemies(npcData));
				//TODO wenn Target angegriffen wird
				if(enemy != null) {
					EventNPCFunctions.punchTarget(npc, enemy, MoveType.RUN);
				}
				else if(npcData.getIssuer() != null && npcData.getIssuer().getLocation().distance(npc.getLocation()) <= 20) {
					if(npcData.getIssuer() == target) {
						npcData.setIssuer(null);
						update(npcData);
					}
					else EventNPCFunctions.punchTarget(npc, npcData.getIssuer(), MoveType.RUN);
				}
				else {
					EventNPCFunctions.stopAttack(npc);
					EventNPCFunctions.followTarget(npc, target, MoveType.SPRINT, 4f);
					//TODO falls sie mitlaufen (onReachedSlot): MoveType des Spielers nehmen
					//TODO bevorzugt die hinteren Slots nehmen
				}
			}
		}
	}

	/* (non-Javadoc)
	 * @see me.alf21.eventsystem.EventNPC#getEnemies(me.alf21.eventsystem.EventNPCData)
	 */
	@Override
	public ArrayList<Class<?>> getEnemies(EventNPCData npcData) {
		ArrayList<Class<?>> arrayList = new ArrayList<>();
		arrayList.add(Zombie.class);
		return arrayList;
	}
	
	/* (non-Javadoc)
	 * @see me.alf21.eventsystem.EventNPC#getNeutrals(me.alf21.eventsystem.EventNPCData)
	 */
	@Override
	public ArrayList<Class<?>> getNeutrals(EventNPCData npcData) {
		ArrayList<Class<?>> arrayList = new ArrayList<>();
		arrayList.add(Player.class);
		return arrayList;
	}
	
	/* (non-Javadoc)
	 * @see me.alf21.eventsystem.EventNPC#getSkinModel()
	 */
	@Override
	public SkinModel getSkinModel() {
		return SkinModel.ARMY;
	}
}
