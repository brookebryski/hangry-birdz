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
        IGameFlowControl gameFlowControl = new GameFlowControl(target, shotFlowControl2);
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
        IGameFlowControl gameFlowControl = new GameFlowControl(target, shotFlowControl2);
        // When hit the first shot
        when(shotFlowControl2.run()).thenReturn(true);
        gameFlowControl.run();
        // Then the game calls run() Once
        verify(shotFlowControl2, times(1)).run();
    }
}
