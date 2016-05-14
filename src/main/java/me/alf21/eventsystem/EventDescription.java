/**
 * @author Alf21 on 18.12.2015 in project event-system.
 * Copyright (c) 2015 Alf21. All rights reserved.
 */

package me.alf21.eventsystem;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface EventDescription {
    String name() default "unknown";
    
    int playerValueMin() default 2;

    int playerValueMax() default -1;
    
    String credits() default "unknown";
}
