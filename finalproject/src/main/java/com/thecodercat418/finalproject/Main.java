package com.thecodercat418.finalproject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {
    int x = 0;
    int y = 0;
    int move = 1;

    @Override
    public void start(Stage stage) throws IOException {
        Canvas canvas = new Canvas(1000, 1000);
        Group g = new Group(canvas);
        Scene s = new Scene(g, 1000, 1000);
        InputManager.clockStart(s);
        CanvasManager cm = new CanvasManager(canvas);
        cm.addToCanvas(new Player(s, cm));
        cm.addToCanvas(new Rectangle(750, 750, 1, 100, 100, cm));
        Rectangle r = new Rectangle(250, 0, 1, 250, 250, cm);
        // r.canCollide = false;
        r.color = new Color(1, 0, 0, 0.25);
        cm.addToCanvas(r);
        FoodGiver t = new FoodGiver(255, 0, 1, 240, 275, new Food("cheese", new Image("l-intro-1620681256-3131218452.jpg")), cm);
        cm.addToCanvas(t);
        FoodGiver taa = new FoodGiver(600, 0, 1, 100, 100, new Food("bun", new Image("buttery-brioche-buns-thumb-1335430868.jpg")), cm);
        cm.addToCanvas(taa);
        FoodGiver taaa = new FoodGiver(255, 500, 1, 100, 100, new Food("cooked_patty", new Image("Hamburger_patty-1857719050.jpg")), cm);
        cm.addToCanvas(taaa);
        TrashCan ta = new TrashCan(755, 0, 1, 240, 275, cm);
        cm.addToCanvas(ta);
        FoodTranslator ft = new FoodTranslator(0, 750, 1, 250, 250, new Recipe(new ArrayList<Food>(Set.of(new Food("cheese", new Image("l-intro-1620681256-3131218452.jpg")), new Food("bun", new Image("buttery-brioche-buns-thumb-1335430868.jpg")), new Food("cooked_patty", new Image("Hamburger_patty-1857719050.jpg")))), new Food("Cheeseburger", new Image("033_FR11785-199531506.jpg"))),cm);
        cm.addToCanvas(ft);
        Delivier fta = new Delivier(500, 750, 1, 250, 250, new Food("Cheeseburger", new Image("033_FR11785-199531506.jpg")),cm);
        cm.addToCanvas(fta);
        stage.setTitle("AnimationTimer Demo");
        stage.setScene(s);
        stage.show();





        // SkillCheck sk = new SkillCheck(cm);
        // cm.addToCanvas(sk);

    }

    public static void main(String[] args) {
        System.out.println("Hello world!");
        launch(args);
    }
}