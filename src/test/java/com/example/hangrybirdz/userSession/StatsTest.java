package com.example.hangrybirdz.userSession;

import com.example.hangrybirdz.userSessions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class StatsTest {

    private IUserController userController;
    private IUser user;
    private IStats stats;
    private List<Integer> testList;

    @BeforeEach
    public void setUp() {
        userController = mock(UserController.class);
        user = mock(User.class);
        stats = new Stats(userController,user);
        testList = new ArrayList<Integer>();
        testList.add(1);
        testList.add(2);
        testList.add(3);
        testList.add(4);
    }


    @Test
    public void GivenNewUserDoNotCallReadStats() {
//        Given - I am a new user
        when(user.isExistingUser()).thenReturn(false);
//        When - I need to see stats
        stats.getStats();
//        Then - Do not Call Stats.ReadStats
        verify(userController, never()).readStats(anyString());
    }

    @Test
    public void GivenExistingUserCallReadStatsOnce() {
//        Given - I am a new user
        when(user.isExistingUser()).thenReturn(true);
        when(user.getUsername()).thenReturn("bob");
        when(userController.readStats(anyString())).thenReturn(testList);
//        When - I need to see stats
        stats.getStats();
//        Then - Do not Call Stats.ReadStats
        verify(userController, times(1)).readStats(anyString());
    }

    @Test
    public void GivenTestList() {
//        Given - I am a new user
        when(user.isExistingUser()).thenReturn(true);
        when(user.getUsername()).thenReturn("bob");
        when(userController.readStats(anyString())).thenReturn(testList);
//        When - I need to see stats
        stats.getStats();
//        Then - Do not Call Stats.ReadStats
        verify(userController, times(1)).readStats(anyString());
    }




}
