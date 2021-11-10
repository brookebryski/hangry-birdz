package com.example.hangrybirdz;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class VelocityRangeValidatorTest {

    @Test
    public void given1GetBackTrue(){
        // Given: I am a user
        IVelocityRangeValidator validator = new VelocityRangeValidator();
        // When: I enter the int 1
        boolean result = validator.isInRange(1);
        // Then: Get back true
        assertTrue(result);
    }

    @Test
    public void given20GetBackTrue(){
        // Given: I am a user
        IVelocityRangeValidator validator = new VelocityRangeValidator();
        // When: I enter the int 20
        boolean result = validator.isInRange(20);
        // Then: Get back true
        assertTrue(result);
    }

    @Test
    public void given21GetBackFalse(){
        // Given: I am a user
        IVelocityRangeValidator validator = new VelocityRangeValidator();
        // When: I enter the int 21
        boolean result = validator.isInRange(21);
        // Then: Get back true
        assertFalse(result);
    }

    @Test
    public void given0GetBackFalse(){
        // Given: I am a user
        IVelocityRangeValidator validator = new VelocityRangeValidator();
        // When: I enter the int 0
        boolean result = validator.isInRange(0);
        // Then: Get back true
        assertFalse(result);
    }
}
