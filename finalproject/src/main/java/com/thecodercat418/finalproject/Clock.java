package com.thecodercat418.finalproject;

import java.util.ArrayList;

import javafx.animation.AnimationTimer;

public class Clock {

    private static ArrayList<ClockEntity> entries = new ArrayList<>();
    private static boolean clockStarted = false;

    public static void addToCycle(ClockEntity ce) {
        if (!clockStarted) {
            clockStart();
            clockStarted = true;
        }
        if (entries.contains(ce)) {
            return;
        }
        entries.add(ce);
    }

    public static void removeFromCycle(ClockEntity ce) {
        if (entries.contains(ce)) {
            entries.remove(ce);
        }
    }

    private static void clockStart() {
        new AnimationTimer() {
            @Override
            public void handle(long now) {
                clockRun(now);
            }
        }.start();
    }

    private static void clockRun(long now) {
        for (ClockEntity ce : entries) {
            ce.clockCycle(now);
        }
    }
}
