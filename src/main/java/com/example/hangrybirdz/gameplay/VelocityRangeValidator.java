package com.example.hangrybirdz.gameplay;

import com.example.hangrybirdz.gameplay.interfaces.IVelocityRangeValidator;

public class VelocityRangeValidator implements IVelocityRangeValidator {

    @Override
    public boolean isInRange(int velocity) {
        return velocity >= 1 && velocity <= 20;
    }
}
