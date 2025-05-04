package com.thecodercat418.finalproject.Food;

import com.thecodercat418.finalproject.CanvasManager;
import com.thecodercat418.finalproject.Interactable;
import com.thecodercat418.finalproject.Player;
import com.thecodercat418.finalproject.Sprite;

public class FoodGiver extends Interactable {
    public FoodGiver(int x, int y, int layer, int xsize, int ysize, CanvasManager cm) {
        super(x, y, layer, xsize, ysize, cm);
        // TODO Auto-generated constructor stub
    }

    Food toGive = new Food(); //TODO
    int amt;
    int amtOfTimeForRefresh;

    @Override
    public void interacted(Sprite interactedSprite) {
        if (interactedSprite instanceof Player) {
            if (((Player) interactedSprite).held == null) {
                ((Player) interactedSprite).held = toGive;
                amt--;
                System.out.println("tool");
            }
        }
        // throw new UnsupportedOperationException("Unimplemented method 'interacted'");
    }
}
