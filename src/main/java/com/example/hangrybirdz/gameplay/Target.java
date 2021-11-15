package com.example.hangrybirdz.gameplay;

import com.example.hangrybirdz.gameplay.interfaces.ITarget;

public class Target implements ITarget {

    private int xCoordinate;
    private int yCoordinate;

    public int getxCoordinate() {
        return xCoordinate;
    }

    public int getyCoordinate() {
        return yCoordinate;
    }

    @Override
    public void Set() {
        int min = 1;
        int max = 10;

        xCoordinate = (int)Math.floor(Math.random()*(max-min+1)+min);
        yCoordinate = (int)Math.floor(Math.random()*(max-min+1)+min);



    }


}
