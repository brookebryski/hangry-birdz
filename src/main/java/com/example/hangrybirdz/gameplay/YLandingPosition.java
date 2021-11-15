package com.example.hangrybirdz.gameplay;

import com.example.hangrybirdz.gameplay.interfaces.IYLandingPosition;

public class YLandingPosition implements IYLandingPosition {
    public int Find(double angleInRadians, int velocity) {
        double sin = Math.sin(angleInRadians);
        int yCoordinate = (int) Math.round(sin * velocity);

        if (yCoordinate <1){
            return 1;
        } else return yCoordinate;
    }
}
