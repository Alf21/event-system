/**
 * @author Alf21 on 18.12.2015 in project event-system.
 * Copyright (c) 2015 Alf21. All rights reserved.
 */

package me.alf21.eventsystem;

import java.io.IOException;

import net.gtaun.shoebill.common.command.CommandGroup;
import net.gtaun.shoebill.common.command.CommandParameter;
import net.gtaun.shoebill.common.command.PlayerCommandManager;
import net.gtaun.shoebill.data.Velocity;
import net.gtaun.shoebill.event.player.PlayerConnectEvent;
import net.gtaun.shoebill.event.player.PlayerDeathEvent;
import net.gtaun.shoebill.event.player.PlayerDisconnectEvent;
import net.gtaun.shoebill.event.player.PlayerKeyStateChangeEvent;
import net.gtaun.shoebill.event.player.PlayerSpawnEvent;
import net.gtaun.shoebill.event.player.PlayerTakeDamageEvent;
import net.gtaun.shoebill.event.player.PlayerUpdateEvent;
import net.gtaun.shoebill.event.player.PlayerWeaponShotEvent;
import net.gtaun.shoebill.object.Player;
import net.gtaun.util.event.EventManager;
import net.gtaun.util.event.HandlerPriority;

public class PlayerManager
{	
	public EventManager eventManager;
	public PlayerCommandManager commandManager;
	public PlayerData playerLifecycle;

	public PlayerManager() throws IOException
	{	
		eventManager = EventSystem.getInstance().getEventManagerInstance();
		
		commandManager = new PlayerCommandManager(eventManager);
		commandManager.registerCommands(new Commands());
        
		commandManager.installCommandHandler(HandlerPriority.NORMAL);
		
		CommandGroup playerCommands = new CommandGroup(); 
		playerCommands.registerCommands(new Commands()); 
		commandManager.registerChildGroup(playerCommands, "player");
		
		commandManager.setUsageMessageSupplier((player, prefix, command) -> { 
			String message;
            if(command.getHelpMessage() == null)
            {
            	message = prefix + command;
	            for (CommandParameter param : command.getParameters()) {
	                message += " [" + param + "]"; 
	            }
            }
            else {
            	message = command.getHelpMessage();
            }
            return message; 
		}); 
		
	//--

		eventManager.registerHandler(PlayerUpdateEvent.class, (e) -> {
			playerLifecycle = EventSystem.getInstance().getPlayerLifecycleHolder().getObject(e.getPlayer(), PlayerData.class);
			playerLifecycle.setPlayerState(PlayerState.UPDATING);
			playerLifecycle.setLastUpdate(System.currentTimeMillis());
			if(!e.getPlayer().isNpc())
				EventBase.checkEvent(e.getPlayer());
		});

		eventManager.registerHandler(PlayerWeaponShotEvent.class, EventBase::onPlayerWeaponShot);

		eventManager.registerHandler(PlayerTakeDamageEvent.class, EventBase::onPlayerTakeDamage);

		eventManager.registerHandler(PlayerConnectEvent.class, (e) -> {
			playerLifecycle = EventSystem.getInstance().getPlayerLifecycleHolder().getObject(e.getPlayer(), PlayerData.class);
			playerLifecycle.setPlayerState(PlayerState.CONNECTED);
		});
		
		eventManager.registerHandler(PlayerDisconnectEvent.class, (e) -> {
			playerLifecycle = EventSystem.getInstance().getPlayerLifecycleHolder().getObject(e.getPlayer(), PlayerData.class);
			playerLifecycle.setPlayerState(PlayerState.NONE);
			EventBase.leaveEvent(e.getPlayer());
		});

		eventManager.registerHandler(PlayerDeathEvent.class, (e) -> {
			e.getPlayer().clearAnimations(0);
			e.getPlayer().setHealth(1.0f);
			EventBase.onPlayerDeath(e.getPlayer());
		});

		eventManager.registerHandler(PlayerKeyStateChangeEvent.class, EventBase::onPlayerKeyStateChange);
		
		eventManager.registerHandler(PlayerSpawnEvent.class, (e) -> {
			e.getPlayer().setHealth(100);
			EventBase.onPlayerSpawn(e.getPlayer());
		});
      /*
		eventManager.registerHandler(PlayerChangeLanguageEvent.class, e -> {
		//	EventSystem.getInstance().setPlayerLanguage(e.getPlayer(), e.getLanguage().getAbbr());
        });
      */
	}
	
	/**
	 * segelfliegen calculation with velocity
	 * @param player the player
	 * @param velocity the velocity
	 * @param z the z coord
	 */
	static void segelfliegen(Player player, float velocity, float z) {
		float angle = player.getAngle();
		double speedX, speedY;
		speedX = Math.sin(Math.toRadians(-angle));
		speedY = Math.cos(Math.toRadians(-angle));
		player.setVelocity(new Velocity(velocity*(float)speedX, velocity*(float)speedY, z));
	}


	public void uninitialize() {
		
	}


	public void destroy() {
		
	}
}