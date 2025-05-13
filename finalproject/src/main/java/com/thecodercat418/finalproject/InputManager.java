package com.thecodercat418.finalproject;

import java.util.ArrayList;

import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;

public class InputManager {
    private static ArrayList<OnAction> pressed = new ArrayList<>();
    private static ArrayList<OnAction> released = new ArrayList<>();
    private static ArrayList<OnAction> typed = new ArrayList<>();
    private static Scene s = null;
    private static boolean clockStarted = false;

    public static void addToPressed(OnAction ce) {
        if (!clockStarted) {
            return;
        }
        if (pressed.contains(ce)) {
            return;
        }
        pressed.add(ce);
    }

    public static void addToReleased(OnAction ce) {
        if (!clockStarted) {
            return;
        }
        if (released.contains(ce)) {
            return;
        }
        released.add(ce);
    }

    public static void addToTyped(OnAction ce) {
        if (!clockStarted) {
            return;
        }
        if (typed.contains(ce)) {
            return;
        }
        typed.add(ce);
    }

    public static void removeFromTyped(OnAction ce) {
        if (typed.contains(ce)) {
            typed.remove(ce);
        }
    }

    public static void removeFromPressed(OnAction ce) {
        if (pressed.contains(ce)) {
            pressed.remove(ce);
        }
    }

    public static void removeFromReleased(OnAction ce) {
        if (released.contains(ce)) {
            released.remove(ce);
        }
    }

    public static void removeFromAll(OnAction ce) {
        removeFromPressed(ce);
        removeFromReleased(ce);
        removeFromTyped(ce);
    }

    public static void clockStart(Scene sa) {
        s = sa;
        s.setOnKeyPressed((key) -> {
            keyPress(key, 0);
        });
        s.setOnKeyReleased((key) -> {
            keyPress(key, 1);
        });
        s.setOnKeyTyped((key) -> {
            keyPress(key, 2);
        });
        clockStarted = true;
    }

    private static void keyPress(KeyEvent ke, int i) {// 0 = Pressed, 1 = Released, 2 = Typed
        switch (i) {
            case 0:
                for (OnAction oa : pressed) {
                    oa.action(ke);
                }
                break;
            case 1:
                for (OnAction oa : released) {
                    oa.action(ke);
                }
                break;
            case 2:
                for (OnAction oa : typed) {
                    oa.action(ke);
                }
                break;
        }
    }

    public interface OnAction {
        void action(KeyEvent ke);

    }
}
