package com.thecodercat418.finalproject;

import javafx.scene.paint.Color;

public abstract class Interactable extends Sprite {

    

    public Interactable(int x, int y, int layer, int xsize, int ysize, CanvasManager cm) {
        super(x, y, layer, xsize, ysize, cm);

        canCollide = false;
        color = new Color(0, 1, 0, 0.25);
    }

    public abstract void interacted(Sprite interactedSprite);


}
