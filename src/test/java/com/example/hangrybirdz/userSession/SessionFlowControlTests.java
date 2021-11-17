package com.example.hangrybirdz.userSession;

import com.example.hangrybirdz.gameplay.GameFlowControl;
import com.example.hangrybirdz.gameplay.interfaces.IGameFlowControl;
import com.example.hangrybirdz.userSessions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.mockito.Mockito.*;

public class SessionFlowControlTests {

    private IUser user;
    private IStats stats;
    private ISessionFlowControl sessionFlowControl;
    private IGameFlowControl gameFlowControl;
    private IContinuePlaying continuePlaying;
    private String input;
    private ByteArrayInputStream in;

    @BeforeEach
    public void setup() {
        user = mock(User.class);
        stats = mock(Stats.class);
        gameFlowControl = mock(GameFlowControl.class);
        continuePlaying = mock(ContinuePlaying.class);
        sessionFlowControl = new SessionFlowControl(user, stats, gameFlowControl, continuePlaying);
        input = "dustin";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        when(continuePlaying.keepPlaying()).thenReturn(false);


    }

    @Test
    public void GivenGameStartsCallSetOnce() {
        // Given I am a user
        // When I enter a name
        // Then I call user.initialize() once
        sessionFlowControl.run();
        verify(user, times(1)).initialize("dustin");
    }

    @Test
    public void GivenGameStartsCallGetStatsAtLeaseOnce() {
        // Given I am a user
        // When I start a game
        // Then I call stats.getStats() once
        sessionFlowControl.run();
        verify(stats, atLeast(1)).getStats();
    }

    @Test
    public void GivenGameStartsCallGameFlowControlRunOnce() {
        // Given I am a user
        // When I start a game
        // Then I call gameFlowControl.run() once
        sessionFlowControl.run();
        verify(gameFlowControl, times(1)).run();
    }

    @Test
    public void GivenGameEndsCallSaveOnce() {
        // Given I am a user
        // When I finish a game
        // Then I call user.save() once
        when(gameFlowControl.run()).thenReturn(5);
        sessionFlowControl.run();
        verify(user, times(1)).save(5);
    }

    @Test
    public void GivenUserEndsSessionGameFlowControlRunsOnce() {
        // Given I am a user
        // When I stop playing the same
        // Then sessionInProgress is false
        when(gameFlowControl.run()).thenReturn(5);
        sessionFlowControl.run();
        verify(gameFlowControl, times(1)).run();
    }

    @Test
    public void GivenGameEndsAfterOneRoundGetStatsCalledTwice() {
        // Given I am a user
        // When I stop playing after one round
        // Then I call stats.getStats() a second time.
        sessionFlowControl.run();
        verify(stats, times(2)).getStats();
    }
}