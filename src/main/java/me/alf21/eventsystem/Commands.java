/**
 * @author Alf21 on 18.12.2015 in project event-system.
 * Copyright (c) 2015 Alf21. All rights reserved.
 */

package me.alf21.eventsystem;

import java.io.IOException;

import me.alf21.events.Catching;
import me.alf21.npcs.Bodyguard;
import me.alf21.npcs.Exploder;
import me.alf21.npcs.Zombie;
import me.alf21.util.GameTextTD;
import me.alf21.util.TTTDeadBody;
import net.gtaun.shoebill.common.command.Command;
import net.gtaun.shoebill.common.command.CommandHelp;
import net.gtaun.shoebill.constant.WeaponModel;
import net.gtaun.shoebill.data.AngledLocation;
import net.gtaun.shoebill.data.Color;
import net.gtaun.shoebill.data.Location;
import net.gtaun.shoebill.object.Player;
import net.gtaun.shoebill.object.Vehicle;

public class Commands
{
	public Commands(){}
	
	@Command
	@CommandHelp("Show help message")
	public boolean eventhelp(Player player)
	{
		player.sendMessage(Color.YELLOW, "/events");
		return true;
	}
	
	@Command
	@CommandHelp("Manage events")
	public boolean events(Player player) throws IOException{
		EventBase.eventDialog(player);
		return true;
	}
	
	@Command
	@CommandHelp("Unfreeze player")
	public boolean eventsunfreeze(Player player) throws IOException{
		player.toggleControllable(true);
		return true;
	}
	
	@Command
	@CommandHelp("Set players velocity [multiplier] [z]")
	public boolean veloc(Player player, float velocity, float z) {
		Catching.setPlayerForwardVelocity(player, velocity, z);
		return true;
	}
	
	@Command
	@CommandHelp("/eventsweapon [Player] [Weapon] [Ammo]")
	public boolean eventsweapon(Player player, String string, int weapon, int ammo) {
		Player target = Player.get(string);
		if(target != null) {
			target.giveWeapon(WeaponModel.get(weapon), ammo);
		}
		else {
			player.sendMessage(Color.YELLOW, string + " is no available player!");
		}
		return true;
	}
	
	@Command
	@CommandHelp("/eventsgoto")
	public boolean eventsgoto(Player player) {
		PlayerData playerPlayerData;
		playerPlayerData = EventSystem.getInstance().getPlayerLifecycleHolder().getObject(player, PlayerData.class);
		EventData eventData = playerPlayerData.getCurrentEvent();
		if(eventData != null) {
			if(eventData.getMap() != null && eventData.getMap().getLocation() != null) {
				player.setLocation(eventData.getMap().getLocation());
				player.setWorld(eventData.getId()+1);
				player.setInterior(0);
			}
		}
		return true;
	}
	
	@Command
	@CommandHelp("/eventsback")
	public boolean eventsback(Player player) {
		player.setWorld(0);
		return true;
	}
	
	@Command
	@CommandHelp("/eventstp [x] [y] [z]")
	public boolean eventstp(Player player, float x, float y, float z) {
		player.setLocation(new Location(x, y, z));
		return true;
	}
	
	@Command
	@CommandHelp("/eventsgp")
	public boolean eventsgp(Player player) {
		System.out.println(player.getLocation().getX() + "f, " + player.getLocation().getY() + "f, " + player.getLocation().getZ() + "f");
		return true;
	}
	
	@Command
	@CommandHelp("/eventsveh [modelid] [color1] [color2]")
	public boolean eventsveh(Player player, int modelId, int color1, int color2) {
		if(modelId < 400 || modelId > 611) player.sendMessage(Color.RED, "Die ID muss zwischen 400 und 611 liegen!");
		else {
			AngledLocation location = player.getLocation();
			Vehicle.create(modelId,location.getX()+1,location.getY()+1,location.getZ(),player.getLocation().getInteriorId(),player.getLocation().getWorldId(),location.getAngle(),color1,color2,-1);
		}
		return true;
	}
	
	@Command
	@CommandHelp("/eventsweather [id]")
	public boolean eventsweather(Player player, int weather) {
		for(Player pl : Player.getHumans()) {
			pl.setWeather(weather);
		}
		return true;
	}
	
	@Command
	@CommandHelp("/eventsdb")
	public boolean eventsdb(Player player) {
		PlayerData playerData = EventSystem.getInstance().getPlayerLifecycleHolder().getObject(player, PlayerData.class);
    	EventData eventData = playerData.getCurrentEvent();
    	if(eventData != null) {
    		new TTTDeadBody(eventData, player);
    	}
		return true;
	}
	
	@Command
	@CommandHelp("/eventsz [playername] [npcname]")
	public boolean eventsz(Player player, String playername, String npcname) {
		if(Player.get(playername) != null) {
			PlayerData playerPlayerData = EventSystem.getInstance().getPlayerLifecycleHolder().getObject(Player.get(playername), PlayerData.class);
			EventData eventData = playerPlayerData.getCurrentEvent();
			if(eventData != null) {
				EventNPCData eventNPCData = EventNPCBase.create(eventData, npcname, Zombie.class);
				eventNPCData.setSpawnable(true);
			}
		}
		return true;
	}
	
	@Command
	@CommandHelp("/eventsbg [playername] [npcname]")
	public boolean eventsbg(Player player, String playername, String npcname) {
		if(Player.get(playername) != null) {
			PlayerData playerPlayerData = EventSystem.getInstance().getPlayerLifecycleHolder().getObject(Player.get(playername), PlayerData.class);
			EventData eventData = playerPlayerData.getCurrentEvent();
			if(eventData != null) {
				EventNPCData eventNPCData = EventNPCBase.create(eventData, npcname, Bodyguard.class);
				eventNPCData.setTarget(player);
				eventNPCData.setSpawnable(true);
			}
		}
		return true;
	}
	
	@Command
	@CommandHelp("/eventsex [playername] [npcname]")
	public boolean eventsex(Player player, String playername, String npcname) {
		if(Player.get(playername) != null) {
			PlayerData playerPlayerData = EventSystem.getInstance().getPlayerLifecycleHolder().getObject(Player.get(playername), PlayerData.class);
			EventData eventData = playerPlayerData.getCurrentEvent();
			if(eventData != null) {
				EventNPCData eventNPCData = EventNPCBase.create(eventData, npcname, Exploder.class);
				eventNPCData.setSpawnable(true);
			}
		}
		return true;
	}
	
	@Command
	@CommandHelp("/gttd")
	public boolean gttd(Player player) {
		PlayerData playerPlayerData = EventSystem.getInstance().getPlayerLifecycleHolder().getObject(player, PlayerData.class);
		GameTextTD gameTextTD = new GameTextTD(player, "Static Textdraw");
		playerPlayerData.setGameTextTD(gameTextTD);
		gameTextTD.show();
		return true;
	}
	
	@Command
	@CommandHelp("/gttd [milliseconds]")
	public boolean gttd(Player player, int milliseconds) {
		PlayerData playerPlayerData = EventSystem.getInstance().getPlayerLifecycleHolder().getObject(player, PlayerData.class);
		GameTextTD gameTextTD = new GameTextTD(player, "Animated Textdraw", milliseconds, true);
		playerPlayerData.setGameTextTD(gameTextTD);
		gameTextTD.show();
		return true;
	}
	
	@Command
	@CommandHelp("/gttdt [milliseconds]")
	public boolean gttdt(Player player, int milliseconds) {
		PlayerData playerPlayerData = EventSystem.getInstance().getPlayerLifecycleHolder().getObject(player, PlayerData.class);
		GameTextTD gameTextTD = new GameTextTD(player, "Animated Textdraw with Transitions", milliseconds, true, true);
		playerPlayerData.setGameTextTD(gameTextTD);
		gameTextTD.show();
		return true;
	}
	
	@Command
	@CommandHelp("/gttdt [milliseconds] [transitionMilliseconds]")
	public boolean gttdt(Player player, int milliseconds, int transitionMilliseconds) {
		PlayerData playerPlayerData = EventSystem.getInstance().getPlayerLifecycleHolder().getObject(player, PlayerData.class);
		GameTextTD gameTextTD = new GameTextTD(player, "Animated Textdraw with Transitions", milliseconds, true, transitionMilliseconds);
		playerPlayerData.setGameTextTD(gameTextTD);
		gameTextTD.show();
		return true;
	}
	
	@Command
	@CommandHelp("/gttdhfalse")
	public boolean gttdhfalse(Player player) {
		PlayerData playerPlayerData = EventSystem.getInstance().getPlayerLifecycleHolder().getObject(player, PlayerData.class);
		if(playerPlayerData.getGameTextTD() != null)
			playerPlayerData.getGameTextTD().hide(false);
		return true;
	}
	
	@Command
	@CommandHelp("/gttdhtrue")
	public boolean gttdhtrue(Player player) {
		PlayerData playerPlayerData = EventSystem.getInstance().getPlayerLifecycleHolder().getObject(player, PlayerData.class);
		if(playerPlayerData.getGameTextTD() != null)
			playerPlayerData.getGameTextTD().hide(true);
		return true;
	}
	
	@Command
	@CommandHelp("/gttds")
	public boolean gttds(Player player) {
		PlayerData playerPlayerData = EventSystem.getInstance().getPlayerLifecycleHolder().getObject(player, PlayerData.class);
		if(playerPlayerData.getGameTextTD() != null)
			playerPlayerData.getGameTextTD().show();
		return true;
	}
	
	@Command
	@CommandHelp("/gttdh")
	public boolean gttdh(Player player) {
		player.sendMessage("/gttd - create, /gttdhfalse - hide, /gttdhtrue - hide, /gttds - show");
		player.sendMessage("/gttdh - help, /gttdstop - stop /gttdresume - resume, /gttdt - transitions");
		return true;
	}
	
	@Command
	@CommandHelp("/gttdstop")
	public boolean gttdstop(Player player) {
		PlayerData playerPlayerData = EventSystem.getInstance().getPlayerLifecycleHolder().getObject(player, PlayerData.class);
		if(playerPlayerData.getGameTextTD() != null && playerPlayerData.getGameTextTD().getTimer() != null)
			playerPlayerData.getGameTextTD().getTimer().stop();
		return true;
	}
	
	@Command
	@CommandHelp("/gttdresume")
	public boolean gttdresume(Player player) {
		PlayerData playerPlayerData = EventSystem.getInstance().getPlayerLifecycleHolder().getObject(player, PlayerData.class);
		if(playerPlayerData.getGameTextTD() != null && playerPlayerData.getGameTextTD().getTimer() != null)
			playerPlayerData.getGameTextTD().getTimer().start();
		return true;
	}
	
	@Command
	@CommandHelp("/chatme")
	public boolean chatme(Player player, String msg) {
		EventSystem.getInstance().getChat().sendMessage(player, msg);
		return true;
	}
}
