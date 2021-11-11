package com.example.hangrybirdz;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class GameFlowControlTests {

    @Test
    public void GivenGameStartsCallSetOnce() {
        // Given I am a user
    ITarget target = mock(Target.class);
    IShotFlowControl2 shotFlowControl2 = mock(ShotFlowControl2.class);
        IMortar mortar = mock(Mortar.class);

        IGameFlowControl gameFlowControl = new GameFlowControl(target, shotFlowControl2, mortar);
        // When the game begins
        when(shotFlowControl2.run()).thenReturn(true);
        gameFlowControl.run();
        // Then the game calls target.set() once
    verify(target, times(1)).Set();
    }

    @Test
    public void GivenTargetCallRunOnce() {
        // Given I am a user
        ITarget target = mock(Target.class);
        IShotFlowControl2 shotFlowControl2 = mock(ShotFlowControl2.class);
        IMortar mortar = mock(Mortar.class);

        IGameFlowControl gameFlowControl = new GameFlowControl(target, shotFlowControl2, mortar);
        // When we get the target
        when(shotFlowControl2.run()).thenReturn(true);
        gameFlowControl.run();
        // Then the game calls run() once
        verify(target, times(1)).Set();
    }
    @Test
    public void GivenHitCallRunOnce() {
        // Given I am a user
        ITarget target = mock(Target.class);
        IShotFlowControl2 shotFlowControl2 = mock(ShotFlowControl2.class);
        IMortar mortar = mock(Mortar.class);

        IGameFlowControl gameFlowControl = new GameFlowControl(target, shotFlowControl2, mortar);
        // When hit the first shot
        when(shotFlowControl2.run()).thenReturn(true);
        gameFlowControl.run();
        // Then the game calls run() Once
        verify(shotFlowControl2, times(1)).run();
    }
    @Test
    public void Given4thShotHasBeenTakenIncreaseMortarByOne() {
        // Given: I am a user
        ITarget target = mock(Target.class);
        IMortar mortar = mock(Mortar.class);
        IShotFlowControl2 shotFlowControl2 = mock(ShotFlowControl2.class);
        IGameFlowControl gameFlowControl = new GameFlowControl(target, shotFlowControl2, mortar);
        // When:  I have taken the 4th shot
        when(shotFlowControl2.run()).thenReturn(false,false, false, false, true);
        // Then: Increase the mortar by 1
        gameFlowControl.run();
        verify(mortar, times(1)).increment(1);
    }

//    @Test public void Given(){
//        // Given: I get asked if I want use mortar
//        // When: I say yes
//        // Then: ShotFlowControl.TakeShot(mortar=True) called once
////    }

//    @Test
//    public void GivenMortarIsUsedDecrementMortarCountByOne(){
//        // Given: I am asked if I want to use Mortar
//        ITarget target = mock(Target.class);
//        IMortar mortar = mock(Mortar.class);
//        IShotFlowControl2 shotFlowControl2 = mock(ShotFlowControl2.class);
//        IGameFlowControl gameFlowControl = new GameFlowControl(target, shotFlowControl2, mortar);
//        // When:  I say yes
//        when(shotFlowControl2.run()).thenReturn(false,false, false, false, true);
//        // Then: Decrement the mortar by 1
//        gameFlowControl.run();
//        verify(mortar, times(1)).decrement(1);
//    }

}

