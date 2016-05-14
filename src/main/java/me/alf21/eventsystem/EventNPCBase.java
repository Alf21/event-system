/**
 * @author Alf21 on 18.12.2015 in project event-system.
 * Copyright (c) 2015 Alf21. All rights reserved.
 */
package me.alf21.eventsystem;

import java.util.ArrayList;

import net.gtaun.shoebill.Shoebill;
import net.gtaun.shoebill.fcnpc.FCNPC;
import net.gtaun.shoebill.fcnpc.Wrapper;
import net.gtaun.shoebill.fcnpc.event.FCNPCCreateEvent;
import net.gtaun.shoebill.fcnpc.event.FCNPCDeathEvent;
import net.gtaun.shoebill.fcnpc.event.FCNPCRespawnEvent;
import net.gtaun.shoebill.fcnpc.event.FCNPCTakeDamageEvent;
import net.gtaun.shoebill.object.Timer;
import net.gtaun.util.event.EventManager;

/**
 * @author Alf21
 */
public class EventNPCBase {
	private static ArrayList<EventNPCData> npcDatas;
	private static boolean initialized = false;
	private static Timer timer;
	final static private int updateRate = 50;
	
	public EventNPCBase() {
		
	}
	
	/**
	 * initialize the EventNPCBase
	 */
	public static void initialize() {
		if(!initialized) {
			npcDatas = new ArrayList<>();
			timer = Timer.create(updateRate, (factualInterval) -> {
				update();
			});
			timer.start();
		}
		
		Wrapper.getInstance().setUpdateRate(updateRate);
		System.out.println(
			Wrapper.getInstance().initZMap("scriptfiles/FCNPC/ZMap.hmap")
				? ""
				: "[FCNPC] ZMap initialization failed - File not found;\n[FCNPC] Please include ZMap.hmap into scriptfiles/FCNPC!"
		);
		
		EventManager eventManager = EventSystem.getInstance().getEventManagerInstance();
		eventManager.registerHandler(FCNPCTakeDamageEvent.class, (e) -> {
			System.out.println("Damager: " + e.getDamager().getName());
			FCNPC npc = e.getNpc();
			FCNPC issuer = FCNPC.get(e.getDamager().getName());
			EventNPCData npcData = EventNPCFunctions.getEventNPCData(npc);
			if(issuer != null) {
				if (npcData != null) {
					npcData.setIssuer(issuer);
				}
			}
			else if(e.getDamager() != null) {
				if (npcData != null) {
					npcData.setIssuer(null); //TODO vllt dann den damager auch issuer setzen
				}
			}
		});
		
		eventManager.registerHandler(FCNPCDeathEvent.class, (e) -> {
			FCNPC npc = e.getNpc();
			EventNPCData npcData = EventNPCFunctions.getEventNPCData(npc);
			//TODO für alle anderen diese Slots auch reseten, da der gestorbene FCNPC vllt einen Slot einnahm

			if (npcData != null && npcData.isSpawnable()) {
				if (!npcData.getSpawntimer().isRunning())
					npcData.getSpawntimer().start();
			}
		});
		
		eventManager.registerHandler(FCNPCRespawnEvent.class, (e) -> {

		});
		
		eventManager.registerHandler(FCNPCCreateEvent.class, (e) -> {

		});
	}
	
	/**
	 * uninitialize the EventNPCBase
	 */
	public static void uninitialize() {
		Shoebill.get().runOnSampThread(() -> {
			timer.stop();
			timer.destroy();
			timer = null;
			destroy();
			initialized = false;
		});
	}

	/**
	 * create a FCNPC
	 * @param eventData the event
	 * @param name the name
	 * @param clz the NPC class
	 * @return EventNPCData the eventNPCData
	 */
	public static EventNPCData create(EventData eventData, String name, Class<?> clz) {
		FCNPC npc = FCNPC.create(name);
		EventNPCData npcData = new EventNPCData(eventData, npc, clz);
		npcDatas.add(npcData);
		EventNPCFunctions.spawn(npc);
		try {
			((EventNPC) npcData.getClz().newInstance()).create(npcData);
		} catch (InstantiationException | IllegalAccessException e) {
			System.out.println(e);
			e.printStackTrace();
		}
		return npcData;
	}
	
	/**
	 * destroy all NPCs
	 */
	public static void destroy() {
		npcDatas.forEach(EventNPCBase::destroy);
		npcDatas.clear();
	}
	
	/**
	 * destroy a NPC
	 * @param npcData the NPC
	 */
	public static void destroy(EventNPCData npcData) {
		npcData.getFCNPC().destroy();
		try {
			((EventNPC) npcData.getClz().newInstance()).destroy(npcData);
		} catch (InstantiationException | IllegalAccessException e) {
			System.out.println(e);
			e.printStackTrace();
		}
		npcData.destroy();
	}
	
	/**
	 * update all NPCs
	 */
	public static void update() {
		npcDatas.forEach(EventNPCBase::update);
	}
	
	/**
	 * update a NPC
	 * @param npcData the NPC
	 */
	public static void update(EventNPCData npcData) {
		npcData.increaseUpdateCount();
		try {
			((EventNPC) npcData.getClz().newInstance()).update(npcData);
		} catch (InstantiationException | IllegalAccessException e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}
	
	/**
	 * onEventStartEvent
	 * @param eventData the event
	 */
	public static void start(EventData eventData) {
		for(EventNPCData eventNPCData : EventNPCFunctions.getEventNPCDatas(eventData)) {
			eventNPCData.setSpawnable(true);
			EventNPCFunctions.spawn(eventNPCData.getFCNPC());
		}
	}
	
	/**
	 * onEventFinishEvent
	 * @param eventData the event
	 */
	public static void finish(EventData eventData) {
		for(EventNPCData eventNPCData : EventNPCFunctions.getEventNPCDatas(eventData)) {
			eventNPCData.setSpawnable(false);
			eventNPCData.getFCNPC().kill();
		}
	}
	
	
	/**
	 * @return the npcDatas
	 */
	public static ArrayList<EventNPCData> getNPCDatas() {
		return npcDatas;
	}
}
