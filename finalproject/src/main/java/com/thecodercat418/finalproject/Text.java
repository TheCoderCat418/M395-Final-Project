package com.thecodercat418.finalproject;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class Text extends Sprite{
    public Text(int x, int y, int layer, String t, Font f, Color c, CanvasManager cm) {
        super(x, y, layer, 0, 0, cm);
        this.text = t;
        if(f != null){
            this.f = f;
        }
        if(c != null){
            this.c = c;
        }
        //TODO Auto-generated constructor stub
    }

    String text = "";
    Font f = Font.getDefault();
    Color c = new Color(0, 0, 0, 1);
}
