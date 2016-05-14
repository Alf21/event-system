package me.alf21.util;

import me.alf21.eventsystem.EventFunctions;
import net.gtaun.shoebill.Shoebill;
import net.gtaun.shoebill.data.Location;
import net.gtaun.shoebill.data.Vector3D;
import net.gtaun.shoebill.object.DynamicSampObject;
import net.gtaun.shoebill.object.Player;
import net.gtaun.shoebill.object.Timer;

import java.util.ArrayList;

/**
 * Created by Spikes on 16.02.2015 in project virtuality-roleplay
 * Copyright (c) 2015 Julian Suhl. All rights reserved.
 */
public class GateImpl implements Gate {
    private DynamicSampObject object;
    private Vector3D closed;
    private int worldId;
    private int interiorId;
    private Vector3D closedRotation;
    private Vector3D open;
    private Vector3D openRotation;
    private float speed = 0f;
    private boolean playSound;
    private Timer stopSound;
    private boolean isClosed = true;

    public GateImpl(DynamicSampObject object, float x, float y, float z, float speed, float rx, float ry, float rz, boolean playSound) {
        this.speed = speed;
        this.playSound = playSound;
        this.closed = object.getLocation();
        worldId = object.getLocation().getWorldId();
        interiorId = object.getLocation().getInteriorId();
        this.closedRotation = object.getRotation();
        this.open = new Vector3D(x, y, z);
        this.openRotation = new Vector3D(rx, ry, rz);
        this.object = object;
    }

    public GateImpl() {}

    @Override
    public void move() {
    	Shoebill.get().runOnSampThread(() -> {
	        if (isClosed) {
	            object.moveObject(open, speed, openRotation);
	            isClosed = false;
	        } else {
	            object.moveObject(closed, speed, closedRotation);
	            isClosed = true;
	        }
	        if (playSound) {
	            ArrayList<Player> nearbyPlayers = EventFunctions.getNearbyPlayers(getLocation(), 15);
	            for (Player player : nearbyPlayers) {
	                player.playSound(1153, closed);
	            }
	            stopSound = Timer.create(100, (i) -> stopSound(nearbyPlayers));
	            stopSound.start();
	        }
    	});
    }

    @Override
    public Location getLocation() {
    	Location location = new Location(closed);
    	location.setWorldId(worldId);
    	location.setInteriorId(interiorId);
        return location;
    }

    @Override
    public void destroy() {
        if (isDestroyed()) return;
        object.destroy();
    }

    @Override
    public boolean isDestroyed() {
        return object.isDestroyed();
    }

    private void stopSound(ArrayList<Player> nearbyPlayers) {
        if (!object.isMoving()) {
            for (Player player : nearbyPlayers) {
                player.playSound(1154);
            }
            if (stopSound != null) {
                stopSound.stop();
                stopSound.destroy();
                stopSound = null;
            }
        }
    }
}
