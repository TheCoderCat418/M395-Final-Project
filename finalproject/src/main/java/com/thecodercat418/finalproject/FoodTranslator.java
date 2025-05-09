package com.thecodercat418.finalproject;

import java.util.ArrayList;

public class FoodTranslator extends Interactable {

    public ArrayList<Food> holdingFood = new ArrayList<>();

    public FoodTranslator(int x, int y, int layer, int xsize, int ysize, Recipe r, CanvasManager cm) {
        super(x, y, layer, xsize, ysize, cm);
        this.r = r;
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
            if(!holdingFood.isEmpty()){
            ((Player) (interactedSprite)).held = holdingFood.removeLast();
            System.out.println("remove from ft");
            }
            return;
        }
        for(Food f : r.inputs){
            if(f.name.equals(((Player) (interactedSprite)).held.name)){
                for(Food foodAlready : holdingFood){
                    if(foodAlready.name.equals(((Player) (interactedSprite)).held.name)){
                        System.out.println("already has");
                        return; //TODO ARELADY HAS FOOD
                    }
                }
                System.out.println("added to ft");
                holdingFood.add(((Player) (interactedSprite)).held);
                ((Player) (interactedSprite)).held = null;
                return;
            }
        }
    }
    
}
