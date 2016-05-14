/**
 * @author Alf21 on 18.12.2015 in project event-system.
 * Copyright (c) 2015 Alf21. All rights reserved.
 */
package me.alf21.eventsystem;

import net.gtaun.shoebill.data.Location;
import net.gtaun.shoebill.fcnpc.FCNPC;
import net.gtaun.shoebill.object.Destroyable;
import net.gtaun.shoebill.object.Player;
import net.gtaun.shoebill.object.Timer;

/**
 * @author Alf21
 */
public class EventNPCData implements Destroyable {
	private EventData eventData;
	private Class<?> clz;
	private FCNPC fcnpc;
	private long updateCount;
	private Player target;
	private FCNPC issuer;
	private boolean spawnable;
	private Timer spawntimer;
	private int respawnDelay;
	private Location lastLocation;
	
	public EventNPCData(EventData eventData, FCNPC fcnpc, Class<?> clz) {
		this.eventData = eventData;
		this.fcnpc = fcnpc;
		this.clz = clz;
		updateCount = 0;
		respawnDelay = 2000;
		spawntimer = initSpawnTimer(respawnDelay);
		lastLocation = new Location();
	}
	
	/**
	 * @return the eventData
	 */
	public EventData getEventData() {
		return eventData;
	}
	
	/**
	 * @return the clz
	 */
	public Class<?> getClz() {
		return clz;
	}
	
	/**
	 * @return the npc
	 */
	public FCNPC getFCNPC() {
		return fcnpc;
	}
	
	/**
	 * @return the updateCount
	 */
	public long getUpdateCount() {
		return updateCount;
	}
	public void increaseUpdateCount() {
		updateCount++;
	}
	
	/**
	 * @param target the target to set
	 */
	public void setTarget(Player target) {
		this.target = target;
	}
	/**
	 * @return the target
	 */
	public Player getTarget() {
		return target;
	}
	
	/**
	 * @return the issuer
	 */
	public FCNPC getIssuer() {
		return issuer;
	}
	/**
	 * @param issuer the issuer to set
	 */
	public void setIssuer(FCNPC issuer) {
		this.issuer = issuer;
	}
	
	/**
	 * @return the spawnable
	 */
	public boolean isSpawnable() {
		return spawnable;
	}
	/**
	 * @param spawnable the spawnable to set
	 */
	public void setSpawnable(boolean spawnable) {
		this.spawnable = spawnable;
	}

	public Timer initSpawnTimer(int respawnDelay) {
		return Timer.create(respawnDelay, 1, (factualInterval) -> EventNPCFunctions.spawn(fcnpc));
	}
	
	/**
	 * @return the spawntimer
	 */
	public Timer getSpawntimer() {
		return spawntimer;
	}
	
	/**
	 * @return the respawnDelay
	 */
	public int getRespawnDelay() {
		return respawnDelay;
	}
	/**
	 * @param respawnDelay the respawnDelay to set
	 */
	public void setRespawnDelay(int respawnDelay) {
		this.respawnDelay = respawnDelay;
		if(spawntimer != null) {
			if(spawntimer.isRunning()) spawntimer.stop();
			spawntimer.destroy();
		}
		spawntimer = initSpawnTimer(respawnDelay);
	}
	
	/**
	 * @return the lastLocation
	 */
	public Location getLastLocation() {
		return lastLocation;
	}
	/**
	 * @param lastLocation the lastLocation to set
	 */
	public void setLastLocation(Location lastLocation) {
		this.lastLocation = lastLocation;
	}
	
	/* (non-Javadoc)
	 * @see net.gtaun.shoebill.object.Destroyable#isDestroyed()
	 */
	@Override
	public boolean isDestroyed() {
		return spawntimer == null && fcnpc.isDestroyed() && clz == null;
	}

	/* (non-Javadoc)
	 * @see net.gtaun.shoebill.object.Destroyable#destroy()
	 */
	@Override
	public void destroy() {
		if(spawntimer != null) {
			if(spawntimer.isRunning()) spawntimer.stop();
			spawntimer.destroy();
			spawntimer = null;
		}
		if(fcnpc != null) fcnpc.destroy();
		clz = null;
	}
}
