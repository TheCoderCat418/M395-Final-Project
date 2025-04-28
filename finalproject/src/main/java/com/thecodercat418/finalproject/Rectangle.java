package com.thecodercat418.finalproject;

import javafx.scene.paint.Color;

public class Rectangle extends Sprite{
    public Rectangle(int x, int y, int layer, int xsize, int ysize, CanvasManager cm) {
        super(x, y, layer, xsize, ysize, cm);
        color = new Color(0, 0, 0, 1);
        this.canCollide = true;
        //TODO Auto-generated constructor stub
    }

    @Override
    public void OnScreenUpdate() {
        // TODO Auto-generated method stub
        
    }


}
