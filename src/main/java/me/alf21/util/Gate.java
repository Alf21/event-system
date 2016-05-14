package me.alf21.util;

import net.gtaun.shoebill.data.AngledLocation;
import net.gtaun.shoebill.data.Location;
import net.gtaun.shoebill.object.Destroyable;
import net.gtaun.shoebill.object.DynamicSampObject;

import java.util.ArrayList;

/**
 * Created by Spikes on 16.02.2015 in project virtuality-roleplay
 * Copyright (c) 2015 Julian Suhl. All rights reserved.
 */
public interface Gate extends Destroyable {

	//GateIDs: 989, 988, 980, 976, 971, 969
	
    ArrayList<Gate> gates = new ArrayList<>();
    ArrayList<GateGroup> groups = new ArrayList<>();

    static Gate create(DynamicSampObject object, float x, float y, float z, float speed, float rx, float ry, float rz, boolean playSound) {
        Gate gate = new GateImpl(object, x, y, z, speed, rx, ry, rz, playSound);
        gates.add(gate);
        return gate;
    }

    static GateGroup createGroup(Gate... gates) {
        GateGroup group = new GateGroup(gates);
        groups.add(group);
        return group;
    }

    static boolean isInGroup(Gate gate) {
        for (GateGroup group : groups) {
            if (group.contains(gate)) return true;
        }
        return false;
    }

    static GateGroup getGroup(Gate gate) {
        for (GateGroup group : groups) {
            if (group.contains(gate)) return group;
        }
        return null;
    }

    static Gate getNearstGate(AngledLocation location, int maxDistance) {
        float lastDistance = maxDistance + 1;
        Gate gate = null;
        for (Gate g : Gate.get()) {
            float distance = g.getLocation().distance(location);
            if (distance <= maxDistance && distance <= lastDistance) {
                lastDistance = distance;
                gate = g;
            }
        }
        return gate;
    }

    static ArrayList<Gate> get() {
        return gates;
    }

    static Gate get(int id) {
        return gates.get(id);
    }

    static ArrayList<GateGroup> getGroup() {
        return groups;
    }

    static GateGroup getGroup(int id) {
        return groups.get(id);
    }

    static void destroyAll() {
        gates.stream().forEach(Gate::destroy);
    }

    void move();

    Location getLocation();

}
