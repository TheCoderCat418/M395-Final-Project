package com.thecodercat418.finalproject.Food;

import com.thecodercat418.finalproject.CanvasManager;
import com.thecodercat418.finalproject.Interactable;
import com.thecodercat418.finalproject.Sprite;

public class FoodTranslator extends Interactable {

    public FoodTranslator(int x, int y, int layer, int xsize, int ysize, CanvasManager cm) {
        super(x, y, layer, xsize, ysize, cm);
        //TODO Auto-generated constructor stub
    }
    
    Recipe r;
    int timeBeforeDispence = 0;
    //Skill Checks

    @Override
    public void interacted(Sprite interactedSprite) {
        // TODO Auto-generated method stub
        //Have
        
        //throw new UnsupportedOperationException("Unimplemented method 'interacted'");
    }
    
}
