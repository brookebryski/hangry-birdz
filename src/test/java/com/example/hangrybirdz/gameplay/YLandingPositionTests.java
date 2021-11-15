package com.example.hangrybirdz.gameplay;

import com.example.hangrybirdz.gameplay.interfaces.IYLandingPosition;
import com.example.hangrybirdz.gameplay.YLandingPosition;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class YLandingPositionTests {

    @Test
    public void GivenAngle1Velocity1GetBack1() {
        // Given: I am a user
        IYLandingPosition ylp = new YLandingPosition();
        // When: I enter angle 1 velocity 1
        int input = ylp.Find(.017453, 1);
        //Then: I get back 1
        assertEquals(1, input);
    }
    // Ask about this
    // change expected to 0??
    @Test
    public void GivenAngle1Velocity20GetBack1() {
        // Given: I am a user
        IYLandingPosition ylp = new YLandingPosition();
        // When: I enter angle 1 velocity 20
        int input = ylp.Find(.017453, 20);
        //Then: I get back 1
        assertEquals(1, input);
    }
    // Ask about this
    // change expected to 0??

    @Test
    public void GivenAngle90Velocity1GetBack1() {
        // Given: I am a user
        IYLandingPosition ylp = new YLandingPosition();
        // When: I enter angle 90 velocity 1
        int input = ylp.Find(1.5707, 1);
        //Then: I get back 1
        assertEquals(1, input);
    }

    @Test
    public void GivenAngle90Velocity20GetBack20() {
        // Given: I am a user
        IYLandingPosition ylp = new YLandingPosition();
        // When: I enter angle 90 velocity 20
        int input = ylp.Find(1.5707, 20);
        //Then: I get back 20
        assertEquals(20, input);
    }
}
