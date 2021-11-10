package com.example.hangrybirdz;

import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class XLandingPositionTest {



    @Test
    public void givenAngle1AndVelocity1GetBack1() {
//      Given: I have an angle of .017453 Radians and a velocity of 1
//      When: I calculate the X position
        IXLandingPosition xLanding = new XLandingPosition();
        int result = xLanding.Find(.017453, 1);
//      Then: Get back 1
        assertEquals(1, result);
        assertEquals(1, result);
    }

    @Test
    public void givenAngle1AndVelocity20GetBack20() {
//      Given: I have an angle of .017453 Radians and a velocity of 20
//      When: I calculate the X position
        IXLandingPosition xLanding = new XLandingPosition();
        int result = xLanding.Find(.017453, 20);
//      Then: Get back 20
        assertEquals(20, result);
    }

    @Test
    public void givenAngle90andVelocity1GetBack1() {
//      Given: I have an angle of 1.5707 Radians and a velocity of 1
//      When: I calculate the X position
        IXLandingPosition xLanding = new XLandingPosition();
        int result = xLanding.Find(1.5707, 1);
//      Then: Get back 1
        assertEquals(1, result);
    }

    @Test
    public void givenAngle90andVelocity20GetBack1() {
//      Given: I have an angle of 1.5707 Radians and a velocity of 1
//      When: I calculate the X position
        IXLandingPosition xLanding = new XLandingPosition();
        int result = xLanding.Find(1.5707, 20);
//      Then: Get back 1
        assertEquals(1, result);
    }


}
