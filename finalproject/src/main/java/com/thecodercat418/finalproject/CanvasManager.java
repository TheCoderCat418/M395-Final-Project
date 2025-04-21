package com.thecodercat418.finalproject;

import java.util.ArrayList;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class CanvasManager {
    public Canvas canvas;
    public GraphicsContext gc;

    public ArrayList<ArrayList<Sprite>> layers = new ArrayList<>(); // 10 Layers

    public ArrayList<Sprite> sprites = new ArrayList<>();

    public CanvasManager(Canvas canvas) {
        for (int i = 0; i < 10; i++) {
            layers.add(new ArrayList<Sprite>());
        }
        this.canvas = canvas;
        gc = canvas.getGraphicsContext2D();
        Clock.addToCycle(new ClockEntity(1, () -> {
            updateFrame();
        }));
    }

    public void updateFrame() {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

        for (ArrayList<Sprite> a : layers) {
            a.clear();
        }

        for (Sprite s : sprites) {
            s.OnScreenUpdate();
        }

        for (Sprite s : sprites) {
            layers.get(s.pos.z).add(s);
        }
        for (ArrayList<Sprite> a : layers) {

        for (Sprite s : a) {
            gc.setFill(s.color);
            gc.fillRect(s.pos.x, s.pos.y, s.size.x, s.size.y);
        }
    }

    }

    public void addToCanvas(Sprite sprite) {
        sprites.add(sprite);
        // TODO: add protection
    }
}
