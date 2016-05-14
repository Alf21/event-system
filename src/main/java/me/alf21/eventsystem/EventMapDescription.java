/**
 * @author Alf21 on 18.12.2015 in project event-system.
 * Copyright (c) 2015 Alf21. All rights reserved.
 */

package me.alf21.eventsystem;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface EventMapDescription {
    String description() default "empty";

    String name() default "unknown";
    
    String credits() default "unknown";
    
    EventMapSize size() default EventMapSize.UNKNOWN;
}
