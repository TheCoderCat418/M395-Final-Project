package com.thecodercat418.finalproject;

import javafx.scene.text.Font;

public class Text extends Sprite{
    public Text(int x, int y, int layer, int xsize, int ysize, CanvasManager cm) {
        super(x, y, layer, xsize, ysize, cm);
        //TODO Auto-generated constructor stub
    }

    String text = "";
    Font f = Font.getDefault();
}
