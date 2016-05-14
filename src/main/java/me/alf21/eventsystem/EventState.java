/**
 * @author Alf21 on 18.12.2015 in project event-system.
 * Copyright (c) 2015 Alf21. All rights reserved.
 */

package me.alf21.eventsystem;

import net.gtaun.shoebill.object.Player;

public enum EventState {
	PAUSE("EventState.Pause"),
	RUNNING("EventState.Running"),
	START("EventState.Start"),
	WAITING("EventState.Waiting"),
	READY("EventState.Ready"),
	QUIT("EventState.Quit"),
	PREPARE("EventState.Prepare"); //currently unused

    private String displayName;

    EventState(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName(Player player) {
    	return EventSystem.getInstance().getLocalizedStringSet().get(player, displayName);
    }
}
