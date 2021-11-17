package com.example.hangrybirdz.userSession;

import com.example.hangrybirdz.userSessions.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class StatsTest {

    @Test
    public void GivenNewUserDoNotCallReadStats() {
//        Given - I am a new user
        IUserController userController = mock(UserController.class);
        IUser user = mock(User.class);
        IStats stats = new Stats(userController,user);
        when(user.isExistingUser()).thenReturn(false);
//        When - I need to see stats
        stats.getStats();
//        Then - Do not Call Stats.ReadStats
        verify(userController, never()).readStats(anyString());
    }

    @Test
    public void GivenExistingUserCallReadStatsOnce() {
//        Given - I am a new user
        IUserController userController = mock(UserController.class);
        IUser user = mock(User.class);
        IStats stats = new Stats(userController,user);
        when(user.isExistingUser()).thenReturn(true);
        when(user.getUsername()).thenReturn("bob");
        List<Integer> testList = new ArrayList<Integer>();
        testList.add(1);

        when(userController.readStats(anyString())).thenReturn(testList);
//        When - I need to see stats
        stats.getStats();
//        Then - Do not Call Stats.ReadStats
        verify(userController, times(1)).readStats(anyString());
    }
}
