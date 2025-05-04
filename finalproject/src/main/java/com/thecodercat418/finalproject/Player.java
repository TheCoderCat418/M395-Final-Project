package com.thecodercat418.finalproject;

import com.thecodercat418.finalproject.Food.Food;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;

public class Player extends Sprite {

    public Food held;

    boolean moveRight = false;
    boolean moveLeft = false;
    boolean moveUp = false;
    boolean moveDown = false;

    public Player(Scene s, CanvasManager cm) {
        super(0, 0, 1, 100, 100, cm);

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
            if (key.getCode().compareTo(KeyCode.E) == 0) {
                // Search for colliding E accessable objects
                findAndTriggerInteraction();
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
        moveLoop();

    }
}
