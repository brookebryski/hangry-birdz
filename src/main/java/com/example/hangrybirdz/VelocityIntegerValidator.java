package com.example.hangrybirdz;

public class VelocityIntegerValidator implements IVelocityIntegerValidator{
    @Override
    public boolean isInteger(String velocity) {
        try {
            Integer.parseInt(velocity);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
