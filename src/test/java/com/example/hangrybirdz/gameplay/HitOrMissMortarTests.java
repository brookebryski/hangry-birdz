package com.example.hangrybirdz.gameplay;

import com.example.hangrybirdz.gameplay.*;
import com.example.hangrybirdz.gameplay.interfaces.IHitOrMiss;
import com.example.hangrybirdz.gameplay.interfaces.ILandingPosition;
import com.example.hangrybirdz.gameplay.interfaces.ITarget;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class HitOrMissMortarTests {
    private ITarget target;
    private ITarget target2;
    private ILandingPosition landingPosition;
    private IHitOrMiss hitOrMiss;

    @BeforeEach
    public void startup() {
        target = mock(Target.class);
        target2 = mock(Target.class);
        landingPosition = mock(LandingPosition.class);
        hitOrMiss = new HitOrMissMortar();
    }

    @Test
    public void GivenShotX5Y5TargetX5Y5GetTrue() {
        // Given: The target is at X-5, Y-5
        // When: Mortar lands at X-5,Y-5
        when(target.getxCoordinate()).thenReturn(5);
        when(target.getyCoordinate()).thenReturn(5);
        when(landingPosition.getxCoordinate()).thenReturn(5);
        when(landingPosition.getyCoordinate()).thenReturn(5);
        boolean hit = hitOrMiss.IsAHit(target,target2,landingPosition);
        //Then: I get back true
        assertTrue(hit);
    }
    @Test
    public void GivenShotX5Y5TargetX5Y4GetTrue() {
        // Given: The target is at X-5, Y-5
        // When: Mortar lands at X-5,Y-4
        when(target.getxCoordinate()).thenReturn(5);
        when(target.getyCoordinate()).thenReturn(4);
        when(landingPosition.getxCoordinate()).thenReturn(5);
        when(landingPosition.getyCoordinate()).thenReturn(5);
        boolean hit = hitOrMiss.IsAHit(target,target2,landingPosition);
        //Then: I get back true
        assertTrue(hit);
    }

    @Test
    public void GivenShotX5Y5TargetX6Y5GetTrue() {
        // Given: The target is at X-6, Y-5
        // When: Mortar remains at X-5,Y-5
        when(target.getxCoordinate()).thenReturn(6);
        when(target.getyCoordinate()).thenReturn(5);
        when(landingPosition.getxCoordinate()).thenReturn(5);
        when(landingPosition.getyCoordinate()).thenReturn(5);
        boolean hit = hitOrMiss.IsAHit(target,target2,landingPosition);
        //Then: I get back true
        assertTrue(hit);
    }

    @Test
    public void GivenShotX5Y5TargetX5Y6GetTrue() {
        // Given: The target is at X-5, Y-6
        // When: Mortar remains at X-5,Y-5
        when(target.getxCoordinate()).thenReturn(5);
        when(target.getyCoordinate()).thenReturn(6);
        when(landingPosition.getxCoordinate()).thenReturn(5);
        when(landingPosition.getyCoordinate()).thenReturn(5);
        boolean hit = hitOrMiss.IsAHit(target,target2,landingPosition);
        //Then: I get back true
        assertTrue(hit);
    }

    @Test
    public void GivenShotX5Y5TargetX4Y5GetTrue() {
        // Given: The target is at X-4, Y-5
        // When: Mortar remains at X-5,Y-5
        when(target.getxCoordinate()).thenReturn(4);
        when(target.getyCoordinate()).thenReturn(5);
        when(landingPosition.getxCoordinate()).thenReturn(5);
        when(landingPosition.getyCoordinate()).thenReturn(5);
        boolean hit = hitOrMiss.IsAHit(target,target2,landingPosition);
        //Then: I get back true
        assertTrue(hit);
    }

    @Test
    public void GivenShotX5Y5TargetX6Y4GetTrue() {
        // Given: The target is at X-6, Y-4
        // When: Mortar remains at X-5,Y-5
        when(target.getxCoordinate()).thenReturn(6);
        when(target.getyCoordinate()).thenReturn(4);
        when(landingPosition.getxCoordinate()).thenReturn(5);
        when(landingPosition.getyCoordinate()).thenReturn(5);
        boolean hit = hitOrMiss.IsAHit(target,target2,landingPosition);
        //Then: I get back false
        assertFalse(hit);
    }

    @Test
    public void GivenShotX5Y5TargetX6Y6GetTrue() {
        // Given: The target is at X-6, Y-6
        // When: Mortar remains at X-5,Y-5
        when(target.getxCoordinate()).thenReturn(6);
        when(target.getyCoordinate()).thenReturn(6);
        when(landingPosition.getxCoordinate()).thenReturn(5);
        when(landingPosition.getyCoordinate()).thenReturn(5);
        boolean hit = hitOrMiss.IsAHit(target,target2,landingPosition);
        //Then: I get back false
        assertFalse(hit);
    }

    @Test
    public void GivenShotX5Y5TargetX4Y6GetTrue() {
        // Given: The target is at X-4, Y-6
        // When: Mortar remains at X-5,Y-5
        when(target.getxCoordinate()).thenReturn(4);
        when(target.getyCoordinate()).thenReturn(6);
        when(landingPosition.getxCoordinate()).thenReturn(5);
        when(landingPosition.getyCoordinate()).thenReturn(5);
        boolean hit = hitOrMiss.IsAHit(target,target2,landingPosition);
        //Then: I get back false
        assertFalse(hit);
    }

    @Test
    public void GivenShotX5Y5TargetX4Y4GetTrue() {
        // Given: The target is at X-4, Y-4
        // When: Mortar remains at X-5,Y-5
        when(target.getxCoordinate()).thenReturn(4);
        when(target.getyCoordinate()).thenReturn(4);
        when(landingPosition.getxCoordinate()).thenReturn(5);
        when(landingPosition.getyCoordinate()).thenReturn(5);
        boolean hit = hitOrMiss.IsAHit(target,target2,landingPosition);
        //Then: I get back false
        assertFalse(hit);
    }
}
