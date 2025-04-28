package com.thecodercat418.finalproject;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;

public class Player extends Sprite {

    boolean moveRight = false;
    boolean moveLeft = false;
    boolean moveUp = false;
    boolean moveDown = false;

    public Player(Scene s, CanvasManager cm) {
        super(0, 0, 1, 20, 20, cm);

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
        moveLoop();

    }
}
