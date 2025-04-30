package com.thecodercat418.finalproject;

import java.util.ArrayList;

import javafx.scene.paint.Color;

public abstract class Sprite {

    boolean affectedyColl = false;
    boolean affectedxColl = false;

    Posititon pos = new Posititon();
    Posititon size = new Posititon();
    Color color = new Color(1, 0, 0, 1);

    CanvasManager canvasManager;

    boolean canCollide = true; // Will apply correction to collided objects
    boolean canQuery = true; // Will run OnCollideEnter and OnCollideExit

    public void OnScreenUpdate() {
    };

    public void OnCollideEnter(Sprite spriteEntered) {
    };

    public void OnCollideExit(Sprite spriteEntered) {
    };

    int speed = 10;
    Posititon velo = new Posititon();
    double friction = 0.1;

    public Sprite(int x, int y, int layer, int xsize, int ysize, CanvasManager cm) {
        pos.x = x;
        pos.y = y;
        pos.z = layer;

        size.x = xsize;
        size.y = ysize;

        canvasManager = cm;
    }

    void moveLoop() {
        System.out.println(pos.x + " " + pos.y);
        if (velo.x == 0 && velo.y == 0) {
            return;
        }

        if (Math.abs(velo.x) <= 0.0001) {
            velo.x = 0;
        } else {
            velo.x -= velo.x * friction;
        }
        if (Math.abs(velo.y) <= 0.0001) {
            velo.y = 0;
        } else {
            velo.y -= velo.y * friction;
        }
        checkCollisions(velo);
        move(velo);

    }

    void moveActive(Direction d) { //add slow start
        switch (d) {
            case UP:
                velo.y = -speed;
                break;
            case DOWN:
                velo.y = speed;
                break;
            case LEFT:
                velo.x = -speed;
                break;
            case RIGHT:
                velo.x = speed;
                break;
            default:
                break;
        }

    }

    void move(Posititon direction) {
        pos.y += direction.y;
        pos.x += direction.x;

    }

    ArrayList<Sprite> colSprites = new ArrayList<>();
    

    void checkCollisions(Posititon direction) { // if direction to move to offends a certain motion,
                                                // deny it
        // double tx = direction.x - direction.x * friction + this.pos.x;
        // double ty = drection.y - direction.y * friction + this.pos.y;
        double x = direction.x + this.pos.x;
        double y = direction.y + this.pos.y;
        affectedxColl = false;
        affectedyColl = false;
        ArrayList<Sprite> newColSprites = new ArrayList<>();
        for (Sprite sa : canvasManager.sprites) { // TODO: INDEPENDANT PARTY TO HANDLE COLLISIONS
            // Collisions
            // Compute Collision

            if (!sa.equals(this) && sa.pos.z == this.pos.z) {

                boolean offending = false;
                if (x < sa.pos.x + sa.size.x &&
                        x + this.size.x > sa.pos.x && y < sa.pos.y + sa.size.y &&
                        y + this.size.y > sa.pos.y) {
                    offending = true;

                }
                if (offending) {
                    
                    // Determine the side of the collision
                    double overlapLeft = (x + this.size.x) - sa.pos.x; 
                    double overlapRight = (sa.pos.x + sa.size.x) - x; 
                    double overlapTop = (y + this.size.y) - sa.pos.y; 
                    double overlapBottom = (sa.pos.y + sa.size.y) - y; 

                    double minOverlap = Math.min(Math.min(overlapLeft, overlapRight),
                            Math.min(overlapTop, overlapBottom));

                    if (sa.canCollide) {
                        if (minOverlap == overlapLeft && !affectedxColl) {
                            // direction.x = ;//+ overlapLeft*friction; // Colliding from the right
                            // this.pos.x +=
                            direction.x = -overlapLeft + direction.x;
                            affectedxColl = true;
                        } else if (minOverlap == overlapRight && !affectedxColl) {
                            // direction.x = overlapRight;// - overlapRight*friction; // Colliding from the
                            // left
                            // this.pos.x +=
                            direction.x = overlapRight + direction.x;
                            affectedxColl = true;
                        } else if (minOverlap == overlapTop && !affectedyColl) {
                            // direction.y = ;//+ overlapTop*friction; // Colliding from below
                            // this.pos.y +=
                            direction.y = -overlapTop + direction.y;
                            affectedyColl = true;
                        } else if (minOverlap == overlapBottom && !affectedyColl) {
                            // direction.y = overlapBottom;// - overlapBottom*friction; // Colliding from
                            // above
                            // this.pos.y +=
                            direction.y = overlapBottom + direction.y;
                            affectedyColl = true;
                        }
                    }
                    newColSprites.add(sa);

                    // You can also return the side of the collision if needed
                    System.out.println("Collision detected on side: " + (minOverlap == overlapLeft ? "RIGHT"
                            : minOverlap == overlapRight ? "LEFT" : minOverlap == overlapTop ? "DOWN" : "UP"));

                }
                // colSprites -> Sprites currently colliding since last check
                // newColSprites -> scan of sprites to be updated to colSprites

                // sa current sprite checking
                
                

            }

        }
        for(int i = newColSprites.size()-1; i>=0;i--){
            boolean foundInOldScan = false;
            for(int j = colSprites.size()-1;j>=0;j--){
                if(colSprites.get(j).equals(newColSprites.get(i))){
                    foundInOldScan = true;
                }
            }
            if(!foundInOldScan){
                colSprites.add(newColSprites.get(i));
                OnCollideEnter(newColSprites.get(i));
            }
        }

        for(int i = colSprites.size()-1; i>=0;i--){
            boolean foundInNewScan = false;
            for(int j = newColSprites.size()-1;j>=0;j--){
                if(colSprites.get(i).equals(newColSprites.get(j))){
                    foundInNewScan = true;
                }
            }
            if(!foundInNewScan){
                OnCollideExit(colSprites.remove(i));
            }
        }




        
        
        // return direction;
    }

    enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }

}
