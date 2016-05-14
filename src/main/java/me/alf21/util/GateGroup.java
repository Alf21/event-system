package me.alf21.util;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Spikes on 16.02.2015 in project virtuality-roleplay
 * Copyright (c) 2015 Julian Suhl. All rights reserved.
 */
public class GateGroup extends GateImpl {

    private ArrayList<Gate> gates = new ArrayList<>();

    public GateGroup(Gate... gates) {
        Collections.addAll(this.gates, gates);
    }

    @Override
    public void move() {
        gates.stream().forEach(Gate::move);
    }

    @Override
    public void destroy() {
        if (isDestroyed()) return;
        gates.stream().forEach(Gate::destroy);
    }

    @Override
    public boolean isDestroyed() {
        return gates.get(0).isDestroyed();
    }

    public boolean contains(Gate gate) {
        return gates.contains(gate);
    }
}
