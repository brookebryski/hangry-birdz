package com.example.hangrybirdz.gameplay;

import com.example.hangrybirdz.gameplay.*;
import com.example.hangrybirdz.gameplay.interfaces.*;
import com.example.hangrybirdz.gameplay.levels.ILevel;
import com.example.hangrybirdz.gameplay.levels.Level;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class GameFlowControlTests {

    private ITarget target;
    private IShotFlowControl2 shotFlowControl2;
    private IMortar mortar;
    private IBomb bomb;
    private IGameFlowControl gameFlowControl;
    private IHitOrMiss hitOrMissShot;
    private IHitOrMiss hitOrMissMortar;
    private IHitOrMiss hitOrMissBomb;
    private ILevel level;

    @BeforeEach
    public void start() {
        level = mock(Level.class);
        target = mock(Target.class);
        shotFlowControl2 = mock(ShotFlowControl2.class);
        mortar = mock(Mortar.class);
        bomb = mock(Bomb.class);
        hitOrMissShot = mock(HitOrMissShot.class);
        hitOrMissMortar = mock(HitOrMissMortar.class);
        hitOrMissBomb = mock(HitOrMissBomb.class);
        gameFlowControl = new GameFlowControl(level,target, shotFlowControl2, mortar, bomb, hitOrMissShot, hitOrMissMortar,hitOrMissBomb);
    }


    @Test
    public void GivenGameStartsCallSetOnce() {
        // Given I am a user

        // When the game begins
        when(shotFlowControl2.run(hitOrMissShot)).thenReturn(true);
        gameFlowControl.run();
        // Then the game calls target.set() once
        verify(target, times(1)).Set();
    }

    @Test
    public void GivenTargetCallRunOnce() {
        // Given I am a user

        // When we get the target
        when(shotFlowControl2.run(hitOrMissShot)).thenReturn(true);
        gameFlowControl.run();
        // Then the game calls run() once
        verify(target, times(1)).Set();
    }

    @Test
    public void GivenHitCallRunOnce() {
        // Given I am a user

        // When hit the first shot
        when(shotFlowControl2.run(hitOrMissShot)).thenReturn(true);
        gameFlowControl.run();
        // Then the game calls run() Once
        verify(shotFlowControl2, times(1)).run(hitOrMissShot);
    }

//    @Test
//    public void Given4thShotHasBeenTakenIncreaseMortarByOne() {
//        // Given: I am a user
//        // When:  I have taken the 4th shot
//        when(shotFlowControl2.run(hitOrMissShot)).thenReturn(false, false, false, false, true);
//        // Then: Increase the mortar by 1
//        gameFlowControl.run();
//        verify(mortar, times(1)).increment(1);
//    }

    @Test
    public void GivenIUseAMortarDecreaseMortarByOne() {
//      Given: I have a mortar and I get asked if I want use mortar
        when(shotFlowControl2.run(hitOrMissShot)).thenReturn(false, false, false, false, false, false, true);
        when(mortar.getCount()).thenReturn(0,0,0,1,0,0);
//      When: I say yes
        String input = "yes";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        gameFlowControl.run();
        verify(mortar, times(1)).decrement(1);
//      Then:  Decrease the mortar by 1
    }

    @Test
    void startGameWithSevenShots() {
        // given: I am a user
        when(shotFlowControl2.run(hitOrMissShot)).thenReturn(false, false, false, false, false, false, false, true);
        int expectedMaxShots = 7;

        // when: I start a level
        gameFlowControl.run();


        // then: I have max 7 shots
        verify(shotFlowControl2, times(7)).run(hitOrMissShot);
    }

//      Given: I am going to shoot a mortar
//      When: I take a shot
//      Then: ShotFlowControl.TakeShot(mortar=True) called once
}








