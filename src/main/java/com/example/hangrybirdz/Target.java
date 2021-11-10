package com.example.hangrybirdz;
import java.lang.Math.*;
public class Target implements ITarget {

    @Override
    public String Generate() {
        int min = 1;
        int max = 10;

        int xTargetValue = (int)Math.floor(Math.random()*(max-min+1)+min);
        int yTargetValue = (int)Math.floor(Math.random()*(max-min+1)+min);

        return ((xTargetValue) + "," + (yTargetValue));

    }
}
