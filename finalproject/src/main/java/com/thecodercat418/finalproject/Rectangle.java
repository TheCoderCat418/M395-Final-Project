package com.thecodercat418.finalproject;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class Rectangle extends Sprite {
    public Rectangle(int x, int y, int layer, int xsize, int ysize, CanvasManager cm) {
        super(x, y, layer, xsize, ysize, cm);
        this.canCollide = true;
    }

    public Rectangle(int x, int y, int layer, int xsize, int ysize, Color c, CanvasManager cm) {
        super(x, y, layer, xsize, ysize, cm);
        this.color = c;
        this.canCollide = true;
    }

    public Rectangle(int x, int y, int layer, int xsize, int ysize, Image i, CanvasManager cm) {
        super(x, y, layer, xsize, ysize, cm);
        this.image = i;
        this.canCollide = true;
    }
}
