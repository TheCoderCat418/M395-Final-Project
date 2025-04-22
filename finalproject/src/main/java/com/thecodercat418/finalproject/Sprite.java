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
    Posititon velo = new Posititon();
    double friction = 0.02;

    public Sprite(int x, int y, int layer, int xsize, int ysize, CanvasManager cm) {
        pos.x = x;
        pos.y = y;
        pos.z = layer;

        size.x = xsize;
        size.y = ysize;

        canvasManager = cm;
    }

    void moveLoop() {
        //System.out.println(velo.x + " " + velo.y);
        if (velo.x == 0 && velo.y == 0) {
            return;
        }
        move(velo);
        if (Math.abs(velo.x) <= 0.01 || checkCollisions(velo)) {
            velo.x = 0;
        } else {
            velo.x -= velo.x * friction;
        }
        if (Math.abs(velo.y) <= 0.01 || checkCollisions(velo)) {
            velo.y = 0;
        } else {
            velo.y -= velo.y * friction;
        }

    }

    void moveActive(Direction d) {
        switch (d) {
            case UP:
                velo.y = -speed;
                break;
            case DOWN:
                velo.y = speed;
                break;
            case LEFT:
                velo.x = -speed;
                break;
            case RIGHT:
                velo.x = speed;
                break;
            default:
                break;
        }

    }

    void move(Posititon direction) {
        pos.y += direction.y;
        pos.x += direction.x;

    }

    boolean checkCollisions(Posititon direction) { // if direction to move to offends a certain motion,
                                                   // deny it
        double tx = direction.x * friction + this.pos.x;
        double ty = direction.y * friction + this.pos.y;
        boolean col = false;
        for (Sprite sa : canvasManager.sprites) {
            // Collisions
            // Compute Collision

            if (!sa.equals(this) && sa.pos.z == this.pos.z) {
                System.out.println((tx < sa.pos.x + sa.size.x) + " " + (tx + this.size.x >
                sa.pos.x) + " " + (ty < sa.pos.y + sa.size.y) + " " + (ty + this.size.y >
                sa.pos.y) + " : ");
                if (tx < sa.pos.x + sa.size.x &&
                        tx + this.size.x > sa.pos.x &&
                        ty < sa.pos.y + sa.size.y &&
                        ty + this.size.y > sa.pos.y) {
                    col = true;
                }
            }

        }
        return col;
    }

    enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }

}
