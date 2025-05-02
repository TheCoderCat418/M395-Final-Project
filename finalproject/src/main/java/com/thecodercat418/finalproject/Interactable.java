package com.thecodercat418.finalproject;

import javafx.scene.paint.Color;

public class Interactable extends Sprite {

    InteractionRunner runner;

    public Interactable(int x, int y, int layer, int xsize, int ysize, CanvasManager cm, InteractionRunner ir) {
        super(x, y, layer, xsize, ysize, cm);
        runner = ir;
        canCollide = false;
        color = new Color(0, 1, 0, 0.25);
    }

    public void interact(Sprite interactedSprite) {
        runner.interact(this, interactedSprite);
    }

    public interface InteractionRunner {
        void interact(Interactable i, Sprite interactedSprite);
    }

}
