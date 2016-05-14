/**
 * @author Alf21 on 18.12.2015 in project event-system.
 * Copyright (c) 2015 Alf21. All rights reserved.
 */

package me.alf21.eventsystem;

import java.util.ArrayList;
import java.util.HashMap;

import me.alf21.util.GameTextTD;
import me.alf21.util.RangeLabel;
import net.gtaun.shoebill.common.player.PlayerLifecycleObject;
import net.gtaun.shoebill.data.Color;
import net.gtaun.shoebill.data.Velocity;
import net.gtaun.shoebill.data.WeaponData;
import net.gtaun.shoebill.object.Player;
import net.gtaun.util.event.EventManager;

public class PlayerData extends PlayerLifecycleObject {
	private Player player;
	private EventData currentEvent = null;
	private Velocity velocity = new Velocity(0,0,0);
	private Velocity vehicleVelocity = new Velocity(0,0,0);
	private float vehicleHealth;
	private int eventPoints;
	private int eventScore;
	private ArrayList<WeaponData> playerWeapons;
	private Color color;
	private long lastUpdate;
	private PlayerState playerState;
	private boolean aFK;
	private float damage;
	private float health;
	private float armour;
	private HashMap<String, Boolean> traitorShop;
	private int count;
	private ArrayList<RangeLabel> rangeLabels;
	private GameTextTD gameTextTD;
	
	public PlayerData(EventManager manager, Player p) { 
		super(manager, p);
        player = p;
        vehicleHealth = -1;
        eventPoints = 0;
        eventScore = 0;
        playerWeapons = new ArrayList<>();
        color = new Color(0,0,0,0);
        lastUpdate = 0;
        damage = 0;
        aFK = false;
        health = 100f;
        armour = 0f;
        traitorShop = new HashMap<>();
        rangeLabels = new ArrayList<>();
	}
	
	public EventData getCurrentEvent() {
		return currentEvent;
	}
	public void setCurrentEvent(EventData currentEvent) {
		this.currentEvent = currentEvent;
	}
	
	public Velocity getVelocity() {
		return velocity;
	}
	public void setVelocity(Velocity velocity) {
		this.velocity = velocity;
	}
	
	public Velocity getVehicleVelocity() {
		return vehicleVelocity;
	}
	public void setVehicleVelocity(Velocity vehicleVelocity) {
		this.vehicleVelocity = vehicleVelocity;
	}
	
	public float getVehicleHealth() {
		return vehicleHealth;
	}
	public void setVehicleHealth(float vehicleHealth) {
		this.vehicleHealth = vehicleHealth;
	}
	
	public int getEventPoints() {
		return eventPoints;
	}
	public void setEventPoints(int eventPoints) {
		this.eventPoints = eventPoints;
	}
	
	public int getEventScore() {
		return eventScore;
	}
	public void setEventScore(int eventScore) {
		this.eventScore = eventScore;
	}
	
	public ArrayList<WeaponData> getPlayerWeapons() {
		return playerWeapons;
	}
	
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	
	public long getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(long lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	
	/**
	 * @return the playerState
	 */
	public PlayerState getPlayerState() {
		return playerState;
	}
	/**
	 * @param playerState the playerState to set
	 */
	public void setPlayerState(PlayerState playerState) {
		this.playerState = playerState;
	}
	
	/**
	 * @return boolean the aFK
	 */
	public boolean isAFK() {
		return aFK;
	}
	/**
	 * @param aFK the aFK to set
	 */
	public void setAFK(boolean aFK) {
		this.aFK = aFK;
	}
	/**
	 * @return the damage
	 */
	public float getDamage() {
		return damage;
	}
	/**
	 * @param damage the damage to set
	 */
	public void setDamage(float damage) {
		this.damage = damage;
	}
	
	/**
	 * @return the armour
	 */
	public float getArmour() {
		return armour;
	}
	/**
	 * @param armour the armour to set
	 */
	public void setArmour(float armour) {
		this.armour = armour;
	}
	/**
	 * @return the health
	 */
	public float getHealth() {
		return health;
	}
	/**
	 * @param health the health to set
	 */
	public void setHealth(float health) {
		this.health = health;
	}
	
	/**
	 * @return the traitorShop
	 */
	public HashMap<String, Boolean> getTraitorShop() {
		return traitorShop;
	}
	
	/**
	 * @return the count
	 */
	public int getCount() {
		return count;
	}
	/**
	 * increase count
	 */
	public void increaseCount() {
		count++;
	}
	/**
	 * reset count
	 */
	public void resetCount() {
		count = 0;
	}
	/**
	 * @param count the count to set
	 */
	public void setCount(int count) {
		this.count = count;
	}
	
	/**
	 * @return the rangeLabels
	 */
	public ArrayList<RangeLabel> getRangeLabels() {
		return rangeLabels;
	}
	
	/**
	 * @param gameTextTD the gameTextTD to set
	 */
	public void setGameTextTD(GameTextTD gameTextTD) {
		if(this.gameTextTD != null && !this.gameTextTD.isDestroyed())
			this.gameTextTD.destroy();
		this.gameTextTD = gameTextTD;
	}
	
	/**
	 * @return the gameTextTD
	 */
	public GameTextTD getGameTextTD() {
		return gameTextTD;
	}
	
	/* (non-Javadoc)
	 * @see net.gtaun.shoebill.common.player.PlayerLifecycleObject#getPlayer()
	 */
	@Override
	public Player getPlayer() {
		return player;
	}

	@Override 
	protected void onInit() { 
		
	} 

	@Override 
	protected void onDestroy() { 
		
	}
}