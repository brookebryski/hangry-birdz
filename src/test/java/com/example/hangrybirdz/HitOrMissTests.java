package com.example.hangrybirdz;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class HitOrMissTests {

    private ITarget target;
    private ILandingPosition landingPosition;
    private IHitOrMiss hitOrMiss;

    @BeforeEach
    public void startup() {
        target = mock(Target.class);
        landingPosition = mock(LandingPosition.class);
        hitOrMiss = new HitOrMiss();
        when(target.getxCoordinate()).thenReturn(1);
        when(target.getyCoordinate()).thenReturn(1);
    }

    @Test
    public void GivenShotX1Y1TargetX1Y1GetTrue() {
        // Given: I am a user

        // When: I enter X 1 Y 1 and the target is X 1 Y 1
        when(landingPosition.getxCoordinate()).thenReturn(1);
        when(landingPosition.getyCoordinate()).thenReturn(1);
        boolean hit = hitOrMiss.IsAHit(target,landingPosition);
        //Then: I get back true
        assertTrue(hit);
    }

    @Test
    public void GivenShotX2Y2TargetX1Y1GetFalse() {
        // Given: I am a user

        // When: I enter X 2 Y 2 and the target is X 1 Y 1
        when(landingPosition.getxCoordinate()).thenReturn(2);
        when(landingPosition.getyCoordinate()).thenReturn(2);
        boolean hit = hitOrMiss.IsAHit(target,landingPosition);
        //Then: I get back true
        assertFalse(hit);
    }

    @Test
    public void GivenShotX1Y2TargetX1Y1GetFalse() {
        // Given: I am a user

        // When: I enter X 1 Y 2 and the target is X 1 Y 1
        when(landingPosition.getxCoordinate()).thenReturn(1);
        when(landingPosition.getyCoordinate()).thenReturn(2);
        boolean hit = hitOrMiss.IsAHit(target,landingPosition);
        //Then: I get back true
        assertFalse(hit);
    }

    @Test
    public void GivenShotX2Y1TargetX1Y1GetFalse() {
        // Given: I am a user

        // When: I enter X 2 Y 1 and the target is X 1 Y 1
        when(landingPosition.getxCoordinate()).thenReturn(2);
        when(landingPosition.getyCoordinate()).thenReturn(1);
        boolean hit = hitOrMiss.IsAHit(target,landingPosition);
        //Then: I get back true
        assertFalse(hit);
    }
}
