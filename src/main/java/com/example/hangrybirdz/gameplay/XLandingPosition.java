package com.example.hangrybirdz.gameplay;


import com.example.hangrybirdz.gameplay.interfaces.IXLandingPosition;

public class XLandingPosition implements IXLandingPosition {

    @Override
    public int Find(double angleInRadians, int velocity) {
        double cosine = Math.cos(angleInRadians);
        int xCoordinate = (int) Math.round(cosine * velocity);

        if (xCoordinate <1){
            return 1;
        } else return xCoordinate;
    }
}
