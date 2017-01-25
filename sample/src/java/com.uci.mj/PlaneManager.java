package com.uci.mj;

/**
 * Created by junm5 on 12/20/16.
 */

import java.util.PriorityQueue;

/**
 * This is for test
 * <p>
 * other considerations:
 * Q1:
 * Q2
 */
public class PlaneManager {

    private PriorityQueue<Aircraft> priorityQueue;

    public PlaneManager() {
        this.priorityQueue = new PriorityQueue();
    }

    public void addAirCraft(Aircraft aircraft) {

    }

    public void removeAirCraft() {

    }
}

enum Type {
    PassagerBigger(1),
    PassagerSmaller(2),
    CargoBigger(3),
    CargoSmaller(4);
    Integer value;

    Type(Integer value) {
        this.value = value;
    }
}

class MyAirCraft implements Comparable<MyAirCraft> {
    Aircraft aircraft;
    Type type;

    public MyAirCraft(Aircraft aircraft) {
        this.aircraft = aircraft;
        if (aircraft.isBigger && aircraft.isPassager) {
            type = Type.PassagerBigger;
        } else if (aircraft.isPassager) {
            type = Type.PassagerSmaller;
        } else if (aircraft.isBigger) {
            type = Type.CargoBigger;
        } else {
            type = Type.CargoSmaller;
        }
    }

    public int compareTo(MyAirCraft o) {
        return type.value - o.type.value;
    }
}

class Aircraft {
    long id;
    boolean isBigger;
    boolean isPassager;

    public Aircraft(long id, boolean isBigger, boolean isPassager) {
        this.id = id;
        this.isBigger = isBigger;
        this.isPassager = isPassager;
    }
}
