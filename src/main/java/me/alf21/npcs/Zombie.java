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
import me.alf21.eventsystem.EventData;
import me.alf21.eventsystem.EventFunctions;
import me.alf21.eventsystem.EventNPC;
import me.alf21.eventsystem.EventNPCData;
import me.alf21.eventsystem.EventNPCFunctions;

/**
 * @author Alf21
 *
 */
public class Zombie extends EventNPC {

	public Zombie() { }
	
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
		EventData eventData = npcData.getEventData();
		FCNPC npc = npcData.getFCNPC();
		FCNPC issuer = npcData.getIssuer();
		if(!npc.isDead() && npc.isSpawned()) {
			if(issuer == null) {
				Player player = EventFunctions.getNearestAvailablePlayer(npc.getLocation(), 20, EventFunctions.getAllPlayers(eventData));
				FCNPC enemy = EventNPCFunctions.getNearestAvailableFCNPC(npc.getLocation(), 20, getEnemies(npcData));
				if(player != null && enemy != null) {
					if(npc.getLocation().distance(player.getLocation()) <= npc.getLocation().distance(enemy.getLocation())) {
						EventNPCFunctions.punchTarget(npc, player, MoveType.RUN);
					}
					else {
						EventNPCFunctions.punchTarget(npc, enemy, MoveType.RUN);
					}
				}
				else {
					if(player != null) {
					//	if(npcData.getUpdateCount() % 5 == 0) {
						EventNPCFunctions.punchTarget(npc, player, MoveType.RUN);
					//	}
					}
					else if(enemy != null) {
						EventNPCFunctions.punchTarget(npc, enemy, MoveType.RUN);
					}
					else {
						npc.stop();
						EventNPCFunctions.stopAttack(npc);
					}
				}
			}
			else {
				if(issuer.getLocation().distance(npc.getLocation()) <= 20) {
					EventNPCFunctions.punchTarget(npc, issuer, MoveType.RUN);
				}
				else {
					npcData.setIssuer(null);
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
		arrayList.add(Exploder.class);
		return arrayList;
	}
	
	/* (non-Javadoc)
	 * @see me.alf21.eventsystem.EventNPC#getSkinModel()
	 */
	@Override
	public SkinModel getSkinModel() {
		return SkinModel.MAFBOSS;
	}
}
