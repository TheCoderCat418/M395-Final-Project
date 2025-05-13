package com.thecodercat418.finalproject;

public class FoodGiver extends Interactable {
    public FoodGiver(int x, int y, int layer, int xsize, int ysize, Food f, CanvasManager cm) {
        super(x, y, layer, xsize, ysize, cm);
        toGive = f;
    }

    Food toGive;

    @Override
    public void interacted(Sprite interactedSprite) {
        if (interactedSprite instanceof Player) {
            if (((Player) interactedSprite).held == null) {
                ((Player) interactedSprite).held = toGive;
                System.out.println(toGive.name);
            }
        }
    }
}

