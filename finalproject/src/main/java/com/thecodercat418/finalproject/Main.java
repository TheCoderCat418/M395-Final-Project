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
        // Cross-Class Communication
        public static int time = 240;
        public static boolean paused = false;
        public static int score = 0;
        public static Rectangle scoreBox = null;

        @Override
        public void start(Stage stage) throws IOException {
                // Canvas Setup
                Canvas canvas = new Canvas(1000, 1000);
                Group g = new Group(canvas);
                Scene s = new Scene(g, 1000, 1000);

                // Start Clocks
                InputManager.clockStart(s);
                CanvasManager cm = new CanvasManager(canvas);

                // Add Walls
                cm.addToCanvas(new Rectangle(-100, 0, 1, 100, 1000, cm));
                cm.addToCanvas(new Rectangle(1000, 0, 1, 100, 1000, cm));
                cm.addToCanvas(new Rectangle(0, -100, 1, 1000, 100, cm));
                cm.addToCanvas(new Rectangle(0, 1000, 1, 1000, 100, cm));

                // Add Player
                cm.addToCanvas(new Player(s, cm));

                // Score Box & Function Controlling
                scoreBox = new Rectangle(250, 400, 1, 500, 100, cm);
                scoreBox.color = new Color(0, 0, 0, 0.25);
                cm.addToCanvas(scoreBox);

                Text ts = new Text(300, 450, 1, "SCORE: 000000000000000", new Font(15), null, cm);
                Text tss = new Text(500, 450, 1, "TIME LEFT: " + time, new Font(15), null, cm);
                cm.addToCanvas(ts);
                cm.addToCanvas(tss);

                Clock.addToCycle(new ClockEntity(60, () -> { // Assuming 60 fps
                        if (!paused && time > 0) {
                                time--;
                                scoreBox.color = new Color(0, 0, 0, 0.25);
                                if (time == 0) {
                                        scoreBox.color = new Color(1, 0, 0, 0.25);
                                }
                        } else if (!paused) {
                                scoreBox.color = new Color(1, 0, 0, 0.25);
                        }
                        tss.text = "TIME LEFT: " + time;

                }));
                Clock.addToCycle(new ClockEntity(1, () -> { // Assuming 60 fps
                        ts.text = "SCORE: " + score;
                }));

                // Food Givers
                cm.addToCanvas(new FoodGiver(250, 25, 1, 100, 100,
                                new Food("cheese", new Image("l-intro-1620681256-3131218452.jpg")), cm));
                cm.addToCanvas(new FoodGiver(400, 25, 1, 100, 100,
                                new Food("bun", new Image("buttery-brioche-buns-thumb-1335430868.jpg")), cm));
                cm.addToCanvas(new FoodGiver(550, 25, 1, 100, 100,
                                new Food("cooked_patty", new Image("Hamburger_patty-1857719050.jpg")), cm));
                cm.addToCanvas(new FoodGiver(550, 150, 1, 100, 100,
                                new Food("lettus", new Image("34f74b4c.png")), cm));
                cm.addToCanvas(new FoodGiver(400, 150, 1, 100, 100,
                                new Food("tomato", new Image("g07a4d20.png")), cm));
                cm.addToCanvas(new FoodGiver(250, 150, 1, 100, 100,
                                new Food("bowl", new Image("0ms54k1p.png")), cm));
                cm.addToCanvas(new TrashCan(750, 750, 1, 250, 250, cm));

                // Food Machines
                FoodTranslator slicer = new FoodTranslator(250, 750, 1, 250, 250,
                                new Recipe(new ArrayList<Food>(Set.of(new Food("tomato", new Image("g07a4d20.png")))),
                                                new Food("s_tomato", new Image("uax5lp8z.png"))),
                                cm);
                slicer.children.add(new Text(350, 850, 1, "Slicer", new Font(30), null, cm));
                slicer.children.add(new Text(300, 875, 1, "TOMATO=>SLICED_TOMATO", new Font(10), null, cm));
                cm.addToCanvas(slicer);
                FoodTranslator burger = new FoodTranslator(0, 750, 1, 250, 250,
                                new Recipe(
                                                new ArrayList<Food>(Set.of(
                                                                new Food("cheese", new Image(
                                                                                "l-intro-1620681256-3131218452.jpg")),
                                                                new Food("bun", new Image(
                                                                                "buttery-brioche-buns-thumb-1335430868.jpg")),
                                                                new Food("cooked_patty", new Image(
                                                                                "Hamburger_patty-1857719050.jpg")))),
                                                new Food("Cheeseburger", new Image("033_FR11785-199531506.jpg"))),
                                cm);
                burger.children.add(new Text(50, 850, 1, "Burger Stacker", new Font(30), null, cm));
                burger.children.add(new Text(25, 875, 1, "CHEESE+BUN+PATTY=>CHEESEBURGER", new Font(10), null, cm));
                cm.addToCanvas(burger);
                FoodTranslator salad = new FoodTranslator(500, 750, 1, 250, 250,
                                new Recipe(
                                                new ArrayList<Food>(Set.of(
                                                                new Food("s_tomato", new Image("uax5lp8z.png")),
                                                                new Food("lettus", new Image("34f74b4c.png")),
                                                                new Food("bowl", new Image("0ms54k1p.png")))),
                                                new Food("salad", new Image("xft0lnra.png"))),
                                cm);
                salad.children.add(new Text(525, 850, 1, "Make a salad", new Font(30), null, cm));
                salad.children.add(new Text(525, 875, 1, "LETTUS+BOWL+SLICED_TOMATO=>SALAD", new Font(10), null, cm));
                cm.addToCanvas(salad);

                // Goals
                cm.addToCanvas(new Delivier(850, 15, 1, 150, 150,
                                new Food("Cheeseburger", new Image("033_FR11785-199531506.jpg")), cm));
                cm.addToCanvas(new Delivier(850, 250, 1, 150, 150,
                                new Food("salad", new Image("xft0lnra.png")), cm));

                // Stage
                stage.setTitle("Cooking Calamity | JAVAPC");
                stage.setScene(s);
                stage.show();

        }

        public static void main(String[] args) {
                System.out.println("Hallo Welt!");
                launch(args);
        }
}