package com.thecodercat418.finalproject;

import java.util.ArrayList;

public class Layer {
    int layernum;
    ArrayList<Sprite> sprites = new ArrayList<>();

    public Layer(int num) {
        layernum = num;
    }
}
