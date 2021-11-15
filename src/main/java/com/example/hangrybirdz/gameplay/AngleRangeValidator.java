package com.example.hangrybirdz.gameplay;

import com.example.hangrybirdz.gameplay.interfaces.IAngleRangeValidator;

public class AngleRangeValidator implements IAngleRangeValidator {
    public boolean isInRange(int angle) {
        if (angle >= 1 && angle <= 90) {
            return true;
        }
        return false;
    }
    }


