/**
 * @author Alf21 on 18.12.2015 in project event-system.
 * Copyright (c) 2015 Alf21. All rights reserved.
 * http://forum.sa-mp.de/index.php?page=VCard&userID=34293
 * 							or
 * search for Alf21 in http://sa-mp.de || Breadfish
 **/

package me.alf21.eventsystem;

import java.io.File;

import me.alf21.util.chat.Chat;
import net.gtaun.shoebill.common.player.PlayerLifecycleHolder;
import net.gtaun.shoebill.object.Player;
import net.gtaun.shoebill.resource.Plugin;
import net.gtaun.shoebill.service.Service;
import net.gtaun.util.event.EventManager;
import net.gtaun.util.event.EventManagerNode;
import net.gtaun.wl.lang.Language;
import net.gtaun.wl.lang.LanguageService;
import net.gtaun.wl.lang.LocalizedStringSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EventSystem extends Plugin {

	public static final Logger LOGGER = LoggerFactory.getLogger(EventSystem.class);
	private static EventSystem instance;
	private PlayerManager playerManager;
	private PlayerLifecycleHolder playerLifecycleHolder;
    private EventManagerNode eventManagerNode;
    private LanguageService languageService;
    private LocalizedStringSet localizedStringSet;
    private Chat chat;
    
	public static EventSystem getInstance() {
		if (instance == null)
			instance = new EventSystem();
		return instance;
	}
	
	@Override
	protected void onDisable() throws Throwable {
		playerLifecycleHolder.destroy();
        eventManagerNode.destroy();
		playerManager.uninitialize();
		playerManager.destroy();
		playerManager = null;
		languageService = null;
		//TODO: uninit EventMapBase
		//TODO: uninit EventBase
		EventNPCBase.uninitialize();
		chat.destroy();
		System.out.println("uninitialized");
	}

	@Override
	protected void onEnable() throws Throwable {
		instance = this;
		EventManager eventManager = getEventManager();
        eventManagerNode = eventManager.createChildNode();
        playerLifecycleHolder = new PlayerLifecycleHolder(eventManager);
        playerLifecycleHolder.registerClass(PlayerData.class);
		playerManager = new PlayerManager();
    	languageService = Service.get(LanguageService.class);
    	localizedStringSet = languageService.createStringSet(new File(getDataDir(), "lang"));
		//TODO: init EventMapBase
		//TODO: init EventBase
    	EventNPCBase.initialize();
    	chat = new Chat();
		System.out.println("[EVENT] initialized");
	}

    public Logger getLoggerInstance() {
        return LOGGER;
    }

    public EventManager getEventManagerInstance() {
        return eventManagerNode;
    }
    
    public PlayerLifecycleHolder getPlayerLifecycleHolder() {
        return playerLifecycleHolder;
    }

    public PlayerManager getPlayerManager() {
        return playerManager;
    }

    public void setPlayerLanguage(Player player, String abbr) {
        languageService.setPlayerLanguage(player, Language.get(abbr));
    }

    public LocalizedStringSet getLocalizedStringSet() {
        return localizedStringSet;
    }
    
    /**
	 * @return the languageService
	 */
	public LanguageService getLanguageService() {
		return languageService;
	}
	
	/**
	 * @return the chat
	 */
	public Chat getChat() {
		return chat;
	}
    
//External functions
	/**
	 * show player the event dialog
	 * @param player the player
	 */
	public void showEventDialog(Player player) {
		EventBase.eventDialog(player);
	}
}
