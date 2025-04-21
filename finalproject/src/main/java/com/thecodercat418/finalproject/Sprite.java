package com.thecodercat418.finalproject;

import java.util.ArrayList;

import javafx.scene.paint.Color;

public abstract class Sprite {

    Posititon pos = new Posititon();
    Posititon size = new Posititon();
    Color color = new Color(1, 0, 0, 1);

    CanvasManager canvasManager;

    boolean hardended = false;

    public abstract void OnScreenUpdate();

    int speed = 10;

    public Sprite(int x, int y, int layer, int xsize, int ysize, CanvasManager cm) {
        pos.x = x;
        pos.y = y;
        pos.z = layer;

        size.x = xsize;
        size.y = ysize;

        canvasManager = cm;
    }

    void move(Direction d) {
        switch (d) {
            case UP:
                pos.y -= speed;
                break;
            case DOWN:
                pos.y += speed;
                break;
            case LEFT:
                pos.x -= speed;
                break;
            case RIGHT:
                pos.x += speed;
                break;
            default:
                break;
        }
    }

    boolean checkCollisions(Direction toMoveIn) {
        int tspeedx = 0;
        int tspeedy = 0;

        switch (toMoveIn) {
            case UP:
                tspeedy = speed;
                break;
            case DOWN:
                tspeedy = -speed;
                break;
            case RIGHT:
                tspeedx = speed;
                break;
            case LEFT:
                tspeedx = -speed;
                break;

            default:
                break;
        }

        boolean safeToMove = true;
        for (Sprite sa : canvasManager.sprites) {
            // Collisions
            // Compute Collision

            // for (Sprite sa : a) {
            if (!sa.equals(this) && sa.pos.z == this.pos.z) {

                if (this.pos.x + this.size.x + tspeedx <= sa.pos.x) {
                    continue;
                } else {
                    System.out.println("d");
                }
            } else {
                continue;
            }
            safeToMove = false;

        }
        return !safeToMove;
    }

    enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }

}
