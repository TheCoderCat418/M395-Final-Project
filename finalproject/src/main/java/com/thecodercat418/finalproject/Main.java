package com.thecodercat418.finalproject;

import java.io.IOException;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.stage.Stage;

public class Main extends Application{
    int x = 0;
    int y = 0;
 int move = 1;
    @Override
    public void start(Stage stage) throws IOException {
        Canvas canvas = new Canvas(1000, 1000);
        Group g =  new Group(canvas);
        Scene s = new Scene(g,1000,1000);
        CanvasManager cm = new CanvasManager(canvas);
        cm.addToCanvas( new Player(s, cm));
        cm.addToCanvas( new com.thecodercat418.finalproject.Rectangle(750, 750, 1, 100, 100, cm));
        
        
        
        stage.setTitle("AnimationTimer Demo");
        stage.setScene(s);
        stage.show();
        
    }

    
    
    public static void main(String[] args) {
        System.out.println("Hello world!");
        launch(args);
    }
}