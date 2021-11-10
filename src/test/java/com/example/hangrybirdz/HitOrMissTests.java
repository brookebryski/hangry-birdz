package com.example.hangrybirdz;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HitOrMissTests {

    @Test
    public void GivenShotX1Y1TargetX1Y1GetTrue() {
        // Given: I am a user
        IHitOrMiss hom = new HitOrMiss();
        // When: I enter X 1 Y 1 and the target is X 1 Y 1
        boolean hit = hom.IsAHit("1,1",1,1);
        //Then: I get back true
        assertTrue(hit);
    }

    @Test
    public void GivenShotX2Y2TargetX1Y1GetFalse() {
        // Given: I am a user
        IHitOrMiss hom = new HitOrMiss();
        // When: I enter X 2 Y 2 and the target is X 1 Y 1
        boolean hit = hom.IsAHit("1,1",2,2);
        //Then: I get back true
        assertFalse(hit);
    }

    @Test
    public void GivenShotX1Y2TargetX1Y1GetFalse() {
        // Given: I am a user
        IHitOrMiss hom = new HitOrMiss();
        // When: I enter X 1 Y 2 and the target is X 1 Y 1
        boolean hit = hom.IsAHit("1,1",1,2);
        //Then: I get back true
        assertFalse(hit);
    }

    @Test
    public void GivenShotX2Y1TargetX1Y1GetFalse() {
        // Given: I am a user
        IHitOrMiss hom = new HitOrMiss();
        // When: I enter X 2 Y 1 and the target is X 1 Y 1
        boolean hit = hom.IsAHit("1,1",2,1);
        //Then: I get back true
        assertFalse(hit);
    }
}
