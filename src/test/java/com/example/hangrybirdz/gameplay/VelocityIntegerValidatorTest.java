package com.example.hangrybirdz.gameplay;

import com.example.hangrybirdz.gameplay.interfaces.IVelocityIntegerValidator;
import com.example.hangrybirdz.gameplay.VelocityIntegerValidator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class VelocityIntegerValidatorTest {

    @Test
    public void given1GetBackTrue(){
        // Given: I am a user
        IVelocityIntegerValidator validator = new VelocityIntegerValidator();
        // When: I enter "1"
        boolean result = validator.isInteger("1");
        // Then: Get back true
        assertTrue(result);
    }

    @Test
    public void given20GetBackTrue(){
        // Given: I am a user
        IVelocityIntegerValidator validator = new VelocityIntegerValidator();
        // When: I enter "20"
        boolean result = validator.isInteger("20");
        // Then: Get back true
        assertTrue(result);
    }

    @Test
    public void givenFrankGetBackFalse(){
        // Given: I am a user
        IVelocityIntegerValidator validator = new VelocityIntegerValidator();
        // When: I enter "20"
        boolean result = validator.isInteger("frank");
        // Then: Get back false
        assertFalse(result);
    }

    @Test
    public void givenAtSymbolGetBackFalse(){
        // Given: I am a user
        IVelocityIntegerValidator validator = new VelocityIntegerValidator();
        // When: I enter "@"
        boolean result = validator.isInteger("@");
        // Then: Get back false
        assertFalse(result);
    }

    @Test
    public void givenEmptyStringGetBackFalse(){
        // Given: I am a user
        IVelocityIntegerValidator validator = new VelocityIntegerValidator();
        // When: I enter "@"
        boolean result = validator.isInteger("");
        // Then: Get back false
        assertFalse(result);
    }
}
