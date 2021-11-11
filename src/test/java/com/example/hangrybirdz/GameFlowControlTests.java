package com.example.hangrybirdz;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class GameFlowControlTests {

    @Test
    public void GivenGameStartsCallSetOnce() {
        // Given I am a user
    ITarget target = mock(Target.class);
    IShotFlowControl2 shotFlowControl2 = mock(ShotFlowControl2.class);
    IGameFlowControl gameFlowControl = new GameFlowControl(target, shotFlowControl2);
        // When the game begins
    gameFlowControl.run();
        // Then the game calls target.set() once
    verify(target, times(1)).Set();
    }

    @Test
    public void GivenTargetCallRunOnce() {
        // Given I am a user
        ITarget target = mock(Target.class);
        IShotFlowControl2 shotFlowControl2 = mock(ShotFlowControl2.class);
        IGameFlowControl gameFlowControl = new GameFlowControl(target, shotFlowControl2);
        // When we get the target
        gameFlowControl.run();
        // Then the game calls run() once
        verify(target, times(1)).Set();
    }
    @Test
    public void GivenMissCallRunTwice() {
        // Given I am a user
        ITarget target = mock(Target.class);
        IShotFlowControl2 shotFlowControl2 = mock(ShotFlowControl2.class);
        IGameFlowControl gameFlowControl = new GameFlowControl(target, shotFlowControl2);
        // When we miss the first shot
        when(shotFlowControl2.run()).thenReturn(false);
        gameFlowControl.run();
        // Then the game calls run() a second time
        verify(shotFlowControl2, times(2)).run();
    }
}
