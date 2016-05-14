/**
 * @author Alf21 on 18.12.2015 in project event-system.
 * Copyright (c) 2015 Alf21. All rights reserved.
 */
package me.alf21.eventsystem;

/**
 * @author Alf21
 *
 */
public enum EventMapSize {
	UNKNOWN("unknown"),
	SMALL("small"),
	MEDIUM("medium"),
	LARGE("large"),
	XLARGE("extra large"),
	XXLARGE("extra extra large");
	
	private String displayName;

	EventMapSize(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
