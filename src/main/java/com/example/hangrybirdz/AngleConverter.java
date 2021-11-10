package com.example.hangrybirdz;

public class AngleConverter implements IAngleConverter{
    public double Convert(int angle) {
        double rads = angle * (Math.PI / 180);
        return (double)Math.round(rads * 1000d)/ 1000d;
    }
}
