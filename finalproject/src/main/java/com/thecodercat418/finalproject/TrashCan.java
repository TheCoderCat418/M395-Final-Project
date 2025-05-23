package com.thecodercat418.finalproject;

public class TrashCan extends Interactable {

    public TrashCan(int x, int y, int layer, int xsize, int ysize, CanvasManager cm) {
        super(x, y, layer, xsize, ysize, cm);
    }

    @Override
    public void interacted(Sprite interactedSprite) {
        if (interactedSprite instanceof Player) {
            if (((Player) interactedSprite).held != null) {
                ((Player) interactedSprite).held = null;
                System.out.println("Removed");
            }
        }
    }

}
