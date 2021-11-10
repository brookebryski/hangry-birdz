package com.example.hangrybirdz;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AngleIntegerValidatorTests {

    @Test
    public void Given1GetBackTrue() {
        // Given: I am a user
        IAngleIntegerValidator aiv = new AngleIntegerValidator();
        // When: I enter "1"
        boolean input = aiv.IsInteger("1");
        //Then: I get back true
        assertTrue(input);
    }

    @Test
    public void Given90GetBackTrue() {
        // Given: I am a user
        IAngleIntegerValidator aiv = new AngleIntegerValidator();
        // When: I enter "90"
        boolean input = aiv.IsInteger("90");
        //Then: I get back true
        assertTrue(input);
    }

    @Test
    public void GivenFrankGetBackFalse() {
        // Given: I am a user
        IAngleIntegerValidator aiv = new AngleIntegerValidator();
        // When: I enter "Frank"
        boolean input = aiv.IsInteger("Frank");
        //Then: I get back false
        assertFalse(input);
    }

    @Test
    public void GivenSpecialCharGetBackFalse() {
        // Given: I am a user
        IAngleIntegerValidator aiv = new AngleIntegerValidator();
        // When: I enter "@"
        boolean input = aiv.IsInteger("@");
        //Then: I get back false
        assertFalse(input);
    }
    @Test
    public void GivenNoInputGetBackFalse() {
        // Given: I am a user
        IAngleIntegerValidator aiv = new AngleIntegerValidator();
        // When: I enter null
        boolean input = aiv.IsInteger(null);
        //Then: I get back false
        assertFalse(input);
    }
// empty string or null passed in here?

}
