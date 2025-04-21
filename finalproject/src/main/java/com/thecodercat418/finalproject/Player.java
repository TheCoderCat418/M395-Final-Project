package com.thecodercat418.finalproject;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;

public class Player extends Sprite {

    boolean moveRight = false;
    boolean moveLeft = false;
    boolean moveUp = false;
    boolean moveDown = false;

    

    public Player(Scene s, CanvasManager cm) {
        super(0, 0, 1, 500, 500, cm);

        s.setOnKeyPressed((key) -> {
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
        });
        s.setOnKeyReleased((key) -> {
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

        @Override
    public void OnScreenUpdate() {
        if (moveDown && !checkCollisions(Direction.DOWN)) {
            move(Direction.DOWN);
        }
        if (moveUp && !checkCollisions(Direction.UP)) {
            move(Direction.UP);
        }
        if (moveLeft && !checkCollisions(Direction.LEFT)) {
            move(Direction.LEFT);
        }
        if (moveRight && !checkCollisions(Direction.RIGHT)) {
            move(Direction.RIGHT);
        }
        

    }
    }

    

