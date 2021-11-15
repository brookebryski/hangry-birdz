package com.example.hangrybirdz.gameplay;

import com.example.hangrybirdz.gameplay.AngleRangeValidator;
import com.example.hangrybirdz.gameplay.interfaces.IAngleRangeValidator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AngleRangeValidatorTests {

    @Test
    public void Given1GetBackTrue() {
        // Given: I am a user
        IAngleRangeValidator arv = new AngleRangeValidator();
        // When: I enter 1
        boolean input = arv.isInRange(1);
        //Then: I get back true
        assertTrue(input);
    }

    @Test
    public void Given90GetBackTrue() {
        // Given: I am a user
        IAngleRangeValidator arv = new AngleRangeValidator();
        // When: I enter 90
        boolean input = arv.isInRange(90);
        //Then: I get back true
        assertTrue(input);
    }

    @Test
    public void Given45GetBackTrue() {
        // Given: I am a user
        IAngleRangeValidator arv = new AngleRangeValidator();
        // When: I enter 45
        boolean input = arv.isInRange(45);
        //Then: I get back true
        assertTrue(input);
    }

    @Test
    public void Given0GetBackFalse() {
        // Given: I am a user
        IAngleRangeValidator arv = new AngleRangeValidator();
        // When: I enter 0
        boolean input = arv.isInRange(0);
        //Then: I get back false
        assertFalse(input);
    }

    @Test
    public void Given91GetBackFalse() {
        // Given: I am a user
        IAngleRangeValidator arv = new AngleRangeValidator();
        // When: I enter 91
        boolean input = arv.isInRange(91);
        //Then: I get back false
        assertFalse(input);
    }
}
