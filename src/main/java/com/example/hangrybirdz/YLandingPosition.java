package com.example.hangrybirdz;

public class YLandingPosition implements IYLandingPosition{
    public int Find(double angleInRadians, int velocity) {
        double sin = Math.sin(angleInRadians);
        int yCoordinate = (int) Math.round(sin * velocity);

        if (yCoordinate <1){
            return 1;
        } else return yCoordinate;
    }
}
