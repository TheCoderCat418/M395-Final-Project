package com.thecodercat418.finalproject;

import javafx.scene.paint.Color;

public class SkillCheck extends Player { // SkillCheck Builder and displayer

    Posititon startTopLeft = new Posititon();

    public SkillCheck(CanvasManager cm) {
        super(0, 0, 0, 0, 10, cm);
        UIPane b1 = new UIPane(0, 0, 0, 0, 0, cm);
        UIPane b2 = new UIPane(0, 0, 0, 0, 0, cm);
        UIPane good = new UIPane(0, 0, 0, 0, 0, cm);
        UIPane bad = new UIPane(0, 0, 0, 0, 0, cm);

        startTopLeft.x = 250;
        startTopLeft.y = 500d;

        b1.speed = 0;
        b1.pos.x = startTopLeft.x;
        b1.pos.y = startTopLeft.y;
        b1.size.y = 100;
        b1.size.x = 50;
        b1.canCollide = true;

        b2.speed = 0;
        b2.pos.x = startTopLeft.x + 250;
        b2.pos.y = startTopLeft.y;
        b2.size.y = 100;
        b2.size.x = 50;
        b2.canCollide = true;

        size.y = 100;
        pos.x = startTopLeft.x + 100;
        pos.y = startTopLeft.y;
        speed = 2;
        moveLeft = true;
        color = new Color(0, 1, 0, 1);

        cm.addToCanvas(b1);
        cm.addToCanvas(b2);
        
        cm.addToCanvas(good);
        cm.addToCanvas(bad);

    }

    @Override
    public void OnCollideEnter(Sprite s) {
        if (moveLeft) {
            moveLeft = false;
            moveRight = true;
        } else {
            moveLeft = true;
            moveRight = false;
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
