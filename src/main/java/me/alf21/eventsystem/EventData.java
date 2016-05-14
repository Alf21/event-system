/**
 * @author Alf21 on 18.12.2015 in project event-system.
 * Copyright (c) 2015 Alf21. All rights reserved.
 */

package me.alf21.eventsystem;

import java.util.ArrayList;

import me.alf21.events.mission.util.Mission;
import me.alf21.util.TTTDeadBody;
import net.gtaun.shoebill.constant.TextDrawAlign;
import net.gtaun.shoebill.constant.TextDrawFont;
import net.gtaun.shoebill.data.Color;
import net.gtaun.shoebill.data.Location;
import net.gtaun.shoebill.object.Player;
import net.gtaun.shoebill.object.Textdraw;
import net.gtaun.shoebill.object.Timer;
import net.gtaun.shoebill.object.Zone;
import net.gtaun.shoebill.object.Destroyable;

public class EventData implements Destroyable {
	private int id;
	private String name;
	private Player owner;
	private Class<?> clz;
	private ArrayList<Player> playerList;
	private ArrayList<Player> spectators;
	private ArrayList<Player> dataPlayerArray2;
	private ArrayList<Player> dataPlayerArray;
	private EventState state;
	private int dataInt;
	private int count;
	private Location location;
	private boolean joinable;
	private boolean teleportable;
	private boolean dataBoolean;
	private boolean dataBoolean2;
	private ArrayList<Player> waitingForPlayers;
	private float multiplicator;
	private Timer timer;
	private int time;
	private EventResult eventResult;
	private ArrayList<EventTextdraw> eventTextdraws;
	private ArrayList<TTTDeadBody> deadBodies;
	private Timer countdownTimer;
	private EventMapBase map;
	private ArrayList<Timer> timerReferences;
	private Timer gameTimer;
	private Textdraw gameTimerTextdraw;
	private int gameTime;
	private boolean teamDamageEnabled;
	private Timer scoreTimer;
	private Timer globalTimer;
	private Zone zone;
	private Class<?> mission;
	
	public EventData(int id, String name, Player owner, Class<?> clz) {
		this.id = id;
		this.name = name;
		this.owner = owner;
		this.clz = clz;
		reset();
	}
	
	public void reset() {
		if(mission != null) {
			try {
				((Mission) mission.newInstance()).destroy(this);
			} catch (InstantiationException | IllegalAccessException e) {
				System.out.println(e);
				e.printStackTrace();
			}
			mission = null;
		}
		if(deadBodies != null && !deadBodies.isEmpty()) {
			deadBodies.forEach(TTTDeadBody::destroy);
		}
		deadBodies = new ArrayList<>();
		if(map != null) {
			map.destroy();
			map = null;
		}
		dataPlayerArray2 = new ArrayList<>();
		dataPlayerArray = new ArrayList<>();
		state = EventState.START;
		dataInt = -1;
		count = 0;
		location = null;
		joinable = true;
		teleportable = false;
		dataBoolean = false;
		dataBoolean2 = false;
		waitingForPlayers = new ArrayList<>();
		multiplicator = -1;
		time = 0;
		if(eventResult != null) {
			eventResult.destroy();
			eventResult = null;
		}
		if(eventTextdraws != null && !eventTextdraws.isEmpty()) {
			for(EventTextdraw eventTextdraw : eventTextdraws) {
				eventTextdraw.hideForAll();
				eventTextdraw.destroy();
			}
		}
		eventTextdraws = new ArrayList<>();
		spectators = new ArrayList<>();
		if(gameTimerTextdraw != null) {
			gameTimerTextdraw.hideForAll();
			gameTimerTextdraw.destroy();
			gameTimerTextdraw = null;
		}
		gameTimerTextdraw = Textdraw.create(320, 9);
		gameTimerTextdraw.setAlignment(TextDrawAlign.CENTER);
		gameTimerTextdraw.setBackgroundColor(Color.BLACK);
		gameTimerTextdraw.setFont(TextDrawFont.get(2));
		gameTimerTextdraw.setLetterSize(0.33f, 1);
		gameTimerTextdraw.setColor(Color.WHITE);
		gameTimerTextdraw.setOutlineSize(0);
		gameTimerTextdraw.setProportional(true);
		gameTimerTextdraw.setUseBox(true);
		gameTimerTextdraw.setBoxColor(Color.BLACK);
		gameTimerTextdraw.setTextSize(0, 51);
		gameTimerTextdraw.setSelectable(false);
		
		gameTime = -1;
		teamDamageEnabled = true;
		
		if(timer != null) {
			if(timer.isRunning()) timer.stop();
			timer.destroy();
		}
		timer = Timer.create(1000, (factualInterval) -> increaseTime());
		if(gameTimer != null) {
			if(gameTimer.isRunning()) gameTimer.stop();
			gameTimer.destroy();
			gameTimer = null;
		}
		if(scoreTimer != null) {
			if(scoreTimer.isRunning()) scoreTimer.stop();
			scoreTimer.destroy();
			scoreTimer = null;
		}
		if(timerReferences != null && !timerReferences.isEmpty()) {
			for(Timer timers : timerReferences) {
				if(timers.isRunning()) timers.stop();
				timers.destroy();
			}
			timerReferences.clear();
		}
		timerReferences = new ArrayList<>();
		if(countdownTimer != null) {
			if(countdownTimer.isRunning()) countdownTimer.stop();
			countdownTimer.destroy();
			countdownTimer = null;
		}
		if(globalTimer != null) {
			if(globalTimer.isRunning()) globalTimer.stop();
			globalTimer.destroy();
			globalTimer = null;
		}
		if(zone != null) {
			zone.hideForAll();
			zone.destroy();
			zone = null;
		}
		playerList = new ArrayList<>();
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Player getOwner() {
		return owner;
	}
	public void setOwner(Player owner) {
		this.owner = owner;
	}
	
	public Class<?> getClz() {
		return clz;
	}
	public void setClz(Class<?> clz) {
		this.clz = clz;
	}
	
	public ArrayList<Player> getPlayerList() {
		return playerList;
	}
	public void setPlayerList(ArrayList<Player> playerList) {
		this.playerList = playerList;
	}
	
	public EventState getState() {
		return state;
	}
	public void setState(EventState state) {
		this.state = state;
	}
	/**
	 * @return the dataPlayerArray2
	 */
	public ArrayList<Player> getDataPlayerArray2() {
		return dataPlayerArray2;
	}
	/**
	 * @param dataPlayerArray2 the dataPlayerArray2 to set
	 */
	public void setDataPlayerArray2(ArrayList<Player> dataPlayerArray2) {
		this.dataPlayerArray2 = dataPlayerArray2;
	}

	/**
	 * @return the dataPlayerArray
	 */
	public ArrayList<Player> getDataPlayerArray() {
		return dataPlayerArray;
	}
	/**
	 * @param dataPlayerArray the dataPlayerArray to set
	 */
	public void setDataPlayerArray(ArrayList<Player> dataPlayerArray) {
		this.dataPlayerArray = dataPlayerArray;
	}
	
	public int getDataInt() {
		return dataInt;
	}
	public void setDataInt(int dataInt) {
		this.dataInt = dataInt;
	}
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	
	public boolean isJoinable() {
		return joinable;
	}
	public void setJoinable(boolean joinable) {
		this.joinable = joinable;
	}
	
	public boolean isTeleportable() {
		return teleportable;
	}
	public void setTeleportable(boolean teleportable) {
		this.teleportable = teleportable;
	}
	
	/**
	 * @return the waitingForPlayers
	 */
	public ArrayList<Player> getWaitingForPlayers() {
		return waitingForPlayers;
	}
	/**
	 * @param waitingForPlayers the waitingForPlayers to set
	 */
	public void setWaitingForPlayers(ArrayList<Player> waitingForPlayers) {
		this.waitingForPlayers = waitingForPlayers;
	}

	public boolean isDataBoolean() {
		return dataBoolean;
	}
	public void setDataBoolean(boolean dataBoolean) {
		this.dataBoolean = dataBoolean;
	}
	public boolean isDataBoolean2() {
		return dataBoolean2;
	}
	public void setDataBoolean2(boolean dataBoolean2) {
		this.dataBoolean2 = dataBoolean2;
	}
	
	public float getMultiplicator() {
		return multiplicator;
	}
	public void setMultiplicator(float multiplicator) {
		this.multiplicator = multiplicator;
	}
	
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public void resetTimer() {
		time = 0;
		if(timer != null) {
			if(timer.isRunning()) timer.stop();
			timer.destroy();
		}
		timer = Timer.create(1000, (factualInterval) -> increaseTime());
	}
	public void setTimer(Timer timer) {
		this.timer = timer;
	}
	public void stopTimer() {
		if(timer != null && timer.isRunning()) 
			timer.stop();
	}
	public void increaseTime() {
		time++;
	}
	public void startTimer() {
		if(!timer.isRunning()) timer.start();
	}
	
	public EventResult getEventResult() {
		return eventResult;
	}
	public void setEventResult(EventResult eventResult) {
		this.eventResult = eventResult;
	}
	
	/**
	 * @return the eventTextdraws
	 */
	public ArrayList<EventTextdraw> getEventTextdraws() {
		return eventTextdraws;
	}
	/**
	 * @param eventTextdraws the eventTextdraws to set
	 */
	public void setEventTextdraws(ArrayList<EventTextdraw> eventTextdraws) {
		this.eventTextdraws = eventTextdraws;
	}

	/**
	 * @return the spectators
	 */
	public ArrayList<Player> getSpectators() {
		return spectators;
	}
	/**
	 * @param spectators the spectators to set
	 */
	public void setSpectators(ArrayList<Player> spectators) {
		this.spectators = spectators;
	}
	/**
	 * @return the deadBodies
	 */
	public ArrayList<TTTDeadBody> getDeadBodies() {
		return deadBodies;
	}
	/**
	 * @param deadBodies the deadBodies to set
	 */
	public void setDeadBodies(ArrayList<TTTDeadBody> deadBodies) {
		this.deadBodies = deadBodies;
	}
	
	public void setCountdownTimer(Timer countdownTimer) {
		this.countdownTimer = countdownTimer;
	}
	public Timer getCountdownTimer() {
		return countdownTimer;
	}
	
	public EventMapBase getMap() {
		return map;
	}
	public void setMap(EventMapBase map) {
		this.map = map;
	}
	
	public ArrayList<Timer> getTimerReferences() {
		return timerReferences;
	}
	public void setTimerReferences(ArrayList<Timer> timerReferences) {
		this.timerReferences = timerReferences;
	}
	
	public Timer getGameTimer() {
		return gameTimer;
	}
	public void setGameTimer(Timer gameTimer) {
		this.gameTimer = gameTimer;
	}
	
	public Timer getScoreTimer() {
		return scoreTimer;
	}
	public void setScoreTimer(Timer scoreTimer) {
		this.scoreTimer = scoreTimer;
	}
	
	public int getGameTime() {
		return gameTime;
	}
	public void setGameTime(int gameTime) {
		this.gameTime = gameTime;
	}
	
	public Textdraw getGameTimerTextdraw() {
		return gameTimerTextdraw;
	}
	public void setGameTimerTextdraw(Textdraw gameTimerTextdraw) {
		this.gameTimerTextdraw = gameTimerTextdraw;
	}
	
	public boolean isTeamDamageEnabled() { //TODO
		return teamDamageEnabled;
	}
	public void setTeamDamageEnabled(boolean teamDamageEnabled) {
		this.teamDamageEnabled = teamDamageEnabled;
	}
	
	public Timer getGlobalTimer() {
		return globalTimer;
	}
	public void setGlobalTimer(Timer globalTimer) {
		this.globalTimer = globalTimer;
	}
	
	/**
	 * @return the zone
	 */
	public Zone getZone() {
		return zone;
	}
	/**
	 * @param zone the zone to set
	 */
	public void setZone(Zone zone) {
		this.zone = zone;
	}
	
	/**
	 * @return the mission
	 */
	public Class<?> getMission() {
		return mission;
	}
	/**
	 * @param mission the mission to set
	 */
	public void setMission(Class<?> mission) {
		this.mission = mission;
	}
	
	
	
	/*
	 * (non-Javadoc)
	 * @see net.gtaun.shoebill.object.Destroyable#destroy()
	 */
	@Override
	public void destroy() {
		if(mission != null) {
			try {
				((Mission) mission.newInstance()).destroy(this);
			} catch (InstantiationException | IllegalAccessException e) {
				System.out.println(e);
				e.printStackTrace();
			}
			mission = null;
		}
		if(deadBodies != null && !deadBodies.isEmpty()) {
			for(TTTDeadBody deadBody : deadBodies) {
				deadBody.destroy();
			}
		}
		deadBodies = null;
		if(map != null) {
			map.destroy();
			map = null;
		}
		if(timer != null) {
			if(timer.isRunning()) timer.stop();
			timer.destroy();
			timer = null;
		}
		if(eventResult != null) 
			eventResult.destroy();
		state = null;
		location = null;
		waitingForPlayers = null;
		if(eventResult != null) {
			eventResult.destroy();
			eventResult = null;
		}
		if(eventTextdraws != null && !eventTextdraws.isEmpty()) {
			for(EventTextdraw eventTextdraw : eventTextdraws) {
				eventTextdraw.hideForAll();
				eventTextdraw.destroy();
			}
		}
		eventTextdraws = null;
		if(gameTimerTextdraw != null) {
			gameTimerTextdraw.hideForAll();
			gameTimerTextdraw.destroy();
			gameTimerTextdraw = null;
		}
		name = null;
		clz = null;
		playerList = null;
		spectators = null;
		dataPlayerArray2 = null;
		dataPlayerArray = null;
		owner = null;
		dataInt = count = time = gameTime = 0;
		multiplicator = 0;
		joinable = false;
		teleportable = false;
		dataBoolean = false;
		dataBoolean2 = false;
		if(countdownTimer != null) {
			if(countdownTimer.isRunning()) countdownTimer.stop();
			countdownTimer.destroy();
			countdownTimer = null;
		}
		if(gameTimer != null) {
			if(gameTimer.isRunning()) gameTimer.stop();
			gameTimer.destroy();
			gameTimer = null;
		}
		if(scoreTimer != null) {
			if(scoreTimer.isRunning()) scoreTimer.stop();
			scoreTimer.destroy();
			scoreTimer = null;
		}
		if(globalTimer != null) {
			if(globalTimer.isRunning()) globalTimer.stop();
			globalTimer.destroy();
			globalTimer = null;
		}
		if(zone != null) {
			zone.hideForAll();
			zone.destroy();
			zone = null;
		}
	}
	
	/* (non-Javadoc)
	 * @see net.gtaun.shoebill.object.Destroyable#isDestroyed()
	 */
	@Override
	public boolean isDestroyed() {
		return !(clz != null || !playerList.isEmpty());
	}
}
