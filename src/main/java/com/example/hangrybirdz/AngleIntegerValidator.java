package com.example.hangrybirdz;

public class AngleIntegerValidator implements IAngleIntegerValidator {
    public boolean IsInteger(String angle) {
        try {
            Integer.parseInt(angle);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

