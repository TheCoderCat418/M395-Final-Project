package com.thecodercat418.finalproject;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class Rectangle extends Sprite {
    public Rectangle(int x, int y, int layer, int xsize, int ysize, CanvasManager cm) {
        super(x, y, layer, xsize, ysize, cm);
        //this.color = new Color(0, 0, 0, 0);
        this.canCollide = true;
        // TODO Auto-generated constructor stub
    }
    public Rectangle(int x, int y, int layer, int xsize, int ysize, Color c,CanvasManager cm) {
        super(x, y, layer, xsize, ysize, cm);
        this.color = c;
        this.canCollide = true;
        // TODO Auto-generated constructor stub
    }
    public Rectangle(int x, int y, int layer, int xsize, int ysize, Image i, CanvasManager cm) {
        super(x, y, layer, xsize, ysize, cm);
        this.image = i;
        this.canCollide = true;
        // TODO Auto-generated constructor stub
    }

    @Override
    public void OnScreenUpdate() {
        // TODO Auto-generated method stub

    }

}
