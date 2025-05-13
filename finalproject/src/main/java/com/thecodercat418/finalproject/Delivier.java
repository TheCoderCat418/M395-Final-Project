package com.thecodercat418.finalproject;

public class Delivier extends Interactable {

    public Delivier(int x, int y, int layer, int xsize, int ysize, Food needed, CanvasManager cm) {
        super(x, y, layer, xsize, ysize, cm);
        this.needed = needed;
    }

    Food needed;

    @Override
    public void interacted(Sprite interactedSprite) {
        if (!(interactedSprite instanceof Player)) {
            return;
        }
        if (((Player) (interactedSprite)).held != null) {
            if (((Player) (interactedSprite)).held.name.equals(needed.name)) {
                ((Player) (interactedSprite)).held = null;
                Main.score++;
            }
            return;
        }

    }

}
