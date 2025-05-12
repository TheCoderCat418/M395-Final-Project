package com.thecodercat418.finalproject;

import java.util.ArrayList;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class CanvasManager {
    public Canvas canvas;
    public GraphicsContext gc;

    public ArrayList<ArrayList<Sprite>> layers = new ArrayList<>(); // 10 Layers

    public ArrayList<Sprite> sprites = new ArrayList<>();

    public Image trash = new Image("trash-can-recycle-bin-icon-free-png-3578756803.png");

    public CanvasManager(Canvas canvas) {
        for (int i = 0; i < 20; i++) {
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
                drawSprite(s);
                findAndLoadChildren(s);
            }
        }

    } 

    private void drawSprite(Sprite s){
        if(s instanceof Player){
            if(((Player) (s)).held != null && ((Player) (s)).held.image != null){
                gc.drawImage(((Player) (s)).held.image, s.pos.x, s.pos.y, s.size.x, s.size.y);
            }else{
                gc.drawImage(new Image("illustration-of-no-image-available-icon-template-for-no-image-or-picture-coming-soon-free-vector-1969102132.jpg", 0.0, 0.0, true, true), s.pos.x, s.pos.y, s.size.x, s.size.y);
            
            }
        }else if(s instanceof FoodGiver){
            gc.drawImage(((FoodGiver) (s)).toGive.image, s.pos.x, s.pos.y, s.size.x, s.size.y);
            
        }else if(s instanceof FoodTranslator){
            int yoff = 0;
            for(Food f : ((FoodTranslator)(s)).holdingFood){
                gc.drawImage(f.image, s.pos.x, s.pos.y+yoff, s.size.x, s.size.y/((FoodTranslator)(s)).r.inputs.size());
                yoff += s.size.y/((FoodTranslator)(s)).r.inputs.size();
            }
        }else if(s instanceof TrashCan){
           gc.drawImage(trash, s.pos.x, s.pos.y, s.size.x, s.size.y);
        }else if(s instanceof Delivier){
            gc.drawImage(((Delivier) (s)).needed.image, s.pos.x, s.pos.y, s.size.x, s.size.y);
        }else{
            gc.setFill(s.color);
            gc.fillRect(s.pos.x, s.pos.y, s.size.x, s.size.y);
        }
        gc.strokeRect(s.pos.x, s.pos.y, s.size.x, s.size.y);
    }

    private void findAndLoadChildren(Sprite s){
        for (Sprite sa : s.children) {
            drawSprite(sa);
            findAndLoadChildren(sa);
        }
    }

    public void addToCanvas(Sprite sprite) {
        sprites.add(sprite);
        // TODO: add protection
    }
}
