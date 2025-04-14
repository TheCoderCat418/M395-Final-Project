package com.thecodercat418.finalproject;

import java.io.IOException;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventType;
//import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Main extends Application{
    int x = 0;
    int y = 0;
 int move = 1;
    @Override
    public void start(Stage stage) throws IOException {
        Canvas canvas = new Canvas(1000, 1000);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        Group g =  new Group(canvas);
        Scene s = new Scene(g,1000,1000);
        s.setOnKeyPressed((key) -> {
            if(key.getCode().compareTo(KeyCode.LEFT) == 0){
                x-=move;
            }
            if(key.getCode().compareTo(KeyCode.RIGHT) == 0){
                x+=move;
            }
            if(key.getCode().compareTo(KeyCode.UP) == 0){
                y-=move;
            }
            if(key.getCode().compareTo(KeyCode.DOWN) == 0){
                y+=move;
            }
        });
        new AnimationTimer() {
            @Override
            public void handle(long now){
                draw(gc);
            }
        }.start();;
        draw(gc);
        stage.setTitle("AnimationTimer Demo");
        stage.setScene(s);
        stage.show();
        
    }

    
    private void draw(GraphicsContext gc) {
        // Clear the canvas
        gc.clearRect(0, 0, 1000, 1000);

        // Draw a rectangle
        gc.setFill(Color.BLUE);
        gc.fillRect(x, y, 200, 150);
    }
    public static void main(String[] args) {
        System.out.println("Hello world!");
        launch(args);
    }
}