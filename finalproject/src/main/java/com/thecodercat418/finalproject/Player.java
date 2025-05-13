package com.thecodercat418.finalproject;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;

public class Player extends Sprite {

    public Food held;

    boolean moveRight = false;
    boolean moveLeft = false;
    boolean moveUp = false;
    boolean moveDown = false;

    public Player(Scene s, CanvasManager cm) {
        super(0, 0, 1, 100, 100, cm);
        InputManager.addToPressed((key) -> {
            if (key.getCode().compareTo(KeyCode.LEFT) == 0) {
                moveLeft = true;
            }
            if (key.getCode().compareTo(KeyCode.RIGHT) == 0) {
                moveRight = true;
            }
            if (key.getCode().compareTo(KeyCode.UP) == 0) {
                moveUp = true;
            }
            if (key.getCode().compareTo(KeyCode.DOWN) == 0) {
                moveDown = true;
            }
            if (key.getCode().compareTo(KeyCode.P) == 0) {
                
                
                if(Main.scoreBox.color.equals(new Color(0, 0, 0, 0.25))){
                    Main.scoreBox.color = new Color(0, 0, 1, 0.25);
                    Main.paused = true;
                    
                }else{
                    Main.scoreBox.color = new Color(0, 0, 0, 0.25);
                    Main.paused = false;
                    if(Main.time <= 0){
                        Main.time = 1;
                    }
                }
            }
            if (key.getCode().compareTo(KeyCode.E) == 0) {
                // Search for colliding E accessable objects
                findAndTriggerInteraction();
            }
        });

        InputManager.addToReleased((key) -> {

            if (key.getCode().compareTo(KeyCode.LEFT) == 0) {
                moveLeft = false;
            }
            if (key.getCode().compareTo(KeyCode.RIGHT) == 0) {
                moveRight = false;
            }
            if (key.getCode().compareTo(KeyCode.UP) == 0) {
                moveUp = false;
            }
            if (key.getCode().compareTo(KeyCode.DOWN) == 0) {
                moveDown = false;
            }
        });
    }
    public Player(int x, int y, int xsize, int ysize, int layer, CanvasManager cm){
        super(0, 0, 1, 100, 100, cm);
    }
    public void findAndTriggerInteraction() {
        for (Sprite s : colSprites) {
            if (s instanceof Interactable) {
                ((Interactable) s).interacted(this);
                return;
            }
        }
    }

    @Override
    public void OnScreenUpdate() {
        if (moveDown) {
            moveActive(Direction.DOWN);
        }
        if (moveUp) {
            moveActive(Direction.UP);
        }
        if (moveLeft) {
            moveActive(Direction.LEFT);
        }
        if (moveRight) {
            moveActive(Direction.RIGHT);
        }
        if(Main.time >0){
        moveLoop();
        }

    }
}
