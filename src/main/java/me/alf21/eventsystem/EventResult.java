/**
 * @author Alf21 on 18.12.2015 in project event-system.
 * Copyright (c) 2015 Alf21. All rights reserved.
 */

package me.alf21.eventsystem;

import javax.security.auth.Destroyable;

public class EventResult implements Destroyable {
	private String[] winner;
	private int time;
	private String[] players;
	
	public EventResult(String[] winner, int time, String[] players) {
		this.winner = winner;
		this.time = time;
		this.players = players;
	}
	
	public void setPlayers(String[] players) {
		this.players = players;
	}
	public String[] getPlayers() {
		return players;
	}
	
	public void setTime(int time) {
		this.time = time;
	}
	public int getTime() {
		return time;
	}
	
	public void setWinner(String[] winner) {
		this.winner = winner;
	}
	public String[] getWinner() {
		return winner;
	}
	
	
	
	public void destroy() {
		
	}
}
