package com.thecodercat418.finalproject.Food;

import com.thecodercat418.finalproject.CanvasManager;
import com.thecodercat418.finalproject.Interactable;
import com.thecodercat418.finalproject.Player;
import com.thecodercat418.finalproject.Sprite;

public class TrashCan extends Interactable {

    public TrashCan(int x, int y, int layer, int xsize, int ysize, CanvasManager cm) {
        super(x, y, layer, xsize, ysize, cm);
        // TODO Auto-generated constructor stub
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
