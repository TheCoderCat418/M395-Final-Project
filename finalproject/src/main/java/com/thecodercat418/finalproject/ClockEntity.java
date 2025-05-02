package com.thecodercat418.finalproject;

public class ClockEntity {
    private int clkdivide = 1;
    private int clkcount = 0;
    private ClockCallback cc;
    private boolean running = true;

    public ClockEntity(int clkdivide, ClockCallback cc) {
        this.cc = cc;
        this.clkdivide = clkdivide;
    }

    public void clockCycle(long now) {
        clkcount++;
        if (clkdivide <= clkcount) {
            clkcount = 0;
            cc.onClockPassed();
        }
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public void setClockDivide(int divide) {
        this.clkdivide = divide;
    }

    public int getClockDivide() {
        return clkdivide;
    }

    public interface ClockCallback {
        void onClockPassed();
    }
}
