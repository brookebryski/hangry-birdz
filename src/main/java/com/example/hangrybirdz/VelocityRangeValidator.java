package com.example.hangrybirdz;

public class VelocityRangeValidator implements IVelocityRangeValidator{

    @Override
    public boolean isInRange(int velocity) {
        return velocity >= 1 && velocity <= 20;
    }
}
