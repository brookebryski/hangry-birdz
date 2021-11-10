package com.example.hangrybirdz;

public class YLandingPosition implements IYLandingPosition{
    public double Find(double angleInRadians, double velocity) {
       double value = Math.sin(angleInRadians);
       return Math.round(value * velocity);
    }
}
