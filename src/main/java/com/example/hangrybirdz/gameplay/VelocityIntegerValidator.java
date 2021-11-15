package com.example.hangrybirdz.gameplay;

import com.example.hangrybirdz.gameplay.interfaces.IVelocityIntegerValidator;

public class VelocityIntegerValidator implements IVelocityIntegerValidator {
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
