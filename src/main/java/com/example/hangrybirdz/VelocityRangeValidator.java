package com.example.hangrybirdz;

public class VelocityRangeValidator implements IVelocityRangeValidator{

    @Override
    public boolean isInRange(int velocity) {
        if(velocity >= 1 && velocity <= 20){
            return true;
        } else {
            return false;
        }
    }
}
