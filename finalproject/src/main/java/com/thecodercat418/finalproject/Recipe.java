package com.thecodercat418.finalproject;

import java.util.ArrayList;

public class Recipe {
    public ArrayList<Food> inputs = new ArrayList<>();
    public Food output;

    public Recipe(ArrayList<Food> inputs, Food output) {
        this.inputs = inputs;
        this.output = output;
    }

}
