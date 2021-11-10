package com.example.hangrybirdz;

public class AngleRangeValidator implements IAngleRangeValidator {
    public boolean isInRange(int angle) {
        if (angle >= 1 && angle <= 90) {
            return true;
        }
        return false;
    }
    }


