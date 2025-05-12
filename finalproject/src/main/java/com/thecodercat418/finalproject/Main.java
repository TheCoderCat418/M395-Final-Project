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
import javafx.scene.text.Font;
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
        // cm.addToCanvas(new Rectangle(750, 750, 1, 100, 100, cm));
        Rectangle r = new Rectangle(250, 400, 1, 500, 100, cm);
        r.color = new Color(0, 0, 0, 0.25);
        cm.addToCanvas(r);
        FoodGiver t = new FoodGiver(250, 25, 1, 100, 100,
                new Food("cheese", new Image("l-intro-1620681256-3131218452.jpg")), cm);
        cm.addToCanvas(t);
        FoodGiver taa = new FoodGiver(400, 25, 1, 100, 100,
                new Food("bun", new Image("buttery-brioche-buns-thumb-1335430868.jpg")), cm);
        cm.addToCanvas(taa);
        FoodGiver taaa = new FoodGiver(550, 25, 1, 100, 100,
                new Food("cooked_patty", new Image("Hamburger_patty-1857719050.jpg")), cm);
        cm.addToCanvas(taaa);
        FoodGiver lettus = new FoodGiver(550, 150, 1, 100, 100,
                new Food("lettus", new Image("34f74b4c.png")), cm);
        cm.addToCanvas(lettus);
        FoodGiver tomato = new FoodGiver(400, 150, 1, 100, 100,
                new Food("tomato", new Image("g07a4d20.png")), cm);
        cm.addToCanvas(tomato);
        FoodGiver bowl = new FoodGiver(250, 150, 1, 100, 100,
                new Food("bowl", new Image("0ms54k1p.png")), cm);
        cm.addToCanvas(bowl);
        TrashCan ta = new TrashCan(750, 750, 1, 250, 250, cm);
        cm.addToCanvas(ta);
        FoodTranslator ft = new FoodTranslator(250, 750, 1, 250, 250,
                new Recipe(new ArrayList<Food>(Set.of(new Food("tomato", new Image("g07a4d20.png")))),
                        new Food("s_tomato", new Image("uax5lp8z.png"))),
                cm);
        cm.addToCanvas(ft);
        FoodTranslator ftaa = new FoodTranslator(0, 750, 1, 250, 250,
                new Recipe(
                        new ArrayList<Food>(Set.of(new Food("cheese", new Image("l-intro-1620681256-3131218452.jpg")),
                                new Food("bun", new Image("buttery-brioche-buns-thumb-1335430868.jpg")),
                                new Food("cooked_patty", new Image("Hamburger_patty-1857719050.jpg")))),
                        new Food("Cheeseburger", new Image("033_FR11785-199531506.jpg"))),
                cm);
        cm.addToCanvas(ftaa);
        FoodTranslator ftaaa = new FoodTranslator(500, 750, 1, 250, 250,
                new Recipe(
                        new ArrayList<Food>(Set.of(new Food("s_tomato", new Image("uax5lp8z.png")),
                        new Food("lettus", new Image("34f74b4c.png")),
                                new Food("bowl", new Image("0ms54k1p.png")))),
                        new Food("salad", new Image("xft0lnra.png"))),
                cm);
        ftaaa.children.add(new Text(525,850, 1, "Make a salad", new Font(30),null,cm));
        ftaaa.children.add(new Text(525,875, 1, "LETTUS+BOWL+SLICED_TOMATO=SALAD", new Font(10),null,cm));
        cm.addToCanvas(ftaaa);
        Delivier fta = new Delivier(850, 15, 1, 150, 150,
                new Food("Cheeseburger", new Image("033_FR11785-199531506.jpg")), cm);
        Delivier ftab = new Delivier(850, 200, 1, 150, 150,
                new Food("salad", new Image("xft0lnra.png")), cm);
        cm.addToCanvas(fta);
        cm.addToCanvas(ftab);
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