package com.thecodercat418.finalproject;

import java.util.ArrayList;

public class FoodTranslator extends Interactable {

    public ArrayList<Food> holdingFood = new ArrayList<>();

    public FoodTranslator(int x, int y, int layer, int xsize, int ysize, CanvasManager cm) {
        super(x, y, layer, xsize, ysize, cm);
        //TODO Auto-generated constructor stub
    }
    
    Recipe r;
    int timeBeforeDispence = 0;
    //SkillCheck sk;

    @Override
    public void interacted(Sprite interactedSprite) {
        if(!(interactedSprite instanceof Player)){
            return;
        }
        if(((Player) (interactedSprite)).held == null){
            return; //TODO REMOVE FOOD
        }
        for(Food f : r.inputs){
            if(f.name.equals(((Player) (interactedSprite)).held.name)){
                for(Food foodAlready : holdingFood){
                    if(foodAlready.name.equals(((Player) (interactedSprite)).held.name)){
                        return; //TODO ARELADY HAS FOOD
                    }
                }
                holdingFood.add(((Player) (interactedSprite)).held);
                ((Player) (interactedSprite)).held = null;
            }
        }
    }
    
}
