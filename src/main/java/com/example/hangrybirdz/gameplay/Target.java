package com.example.hangrybirdz.gameplay;

import com.example.hangrybirdz.gameplay.interfaces.ITarget;

public class Target implements ITarget {

    private int xCoordinate;
    private int yCoordinate;
    private boolean wasTargetHit = false;

    public int getxCoordinate() {
        return xCoordinate;
    }

    public int getyCoordinate() {
        return yCoordinate;
    }

    public boolean getTargetTracker() {
        return wasTargetHit;
    }

    public void setTargetTracker(boolean wasTargetHit) {
        this.wasTargetHit = wasTargetHit;
    }

    @Override
    public void Set() {
        int min = 1;
        int max = 10;

        xCoordinate = (int)Math.floor(Math.random()*(max-min+1)+min);
        yCoordinate = (int)Math.floor(Math.random()*(max-min+1)+min);

    }



}
