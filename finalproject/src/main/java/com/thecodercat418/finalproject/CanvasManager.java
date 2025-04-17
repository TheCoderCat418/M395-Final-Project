package com.thecodercat418.finalproject;

import java.util.ArrayList;

import javafx.scene.canvas.Canvas;

public class CanvasManager {
    private Canvas canvas;
    private Player player; //player(s)??

    private ArrayList<OnScreenObject> osos = new ArrayList<>();

    public CanvasManager(Canvas canvas){
        this.canvas = canvas;
        Clock.addToCycle(new ClockEntity(1, () -> {
            updateFrame();
        }));
    }

    private void updateFrame(){
        System.out.println("Hello from canvasManager");
    }

    public void addToCanvas(OnScreenObject oso){
        
    }
}
