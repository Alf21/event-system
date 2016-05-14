/**
 * @author Alf21 on 21.01.2016 in project event-system.
 * Copyright (c) 2015 Alf21. All rights reserved.
 */

package me.alf21.events.mission.util;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface MissionDescription {
    String name() default "unknown";
    
    int playerValueMin() default 2;

    int playerValueMax() default -1;
    
    String credits() default "unknown";
}