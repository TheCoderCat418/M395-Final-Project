package com.thecodercat418.finalproject;

import java.util.ArrayList;

public class Plate {
    // **NOT USED**

    ArrayList<Food> foodOnPlate = new ArrayList<>();

    public boolean isPlateHolding(Food f){
        if(foodOnPlate.contains(f)){
            return true;
        }
        return false;
    }
}
