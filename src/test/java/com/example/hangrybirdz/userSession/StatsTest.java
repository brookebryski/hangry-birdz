package com.example.hangrybirdz.userSession;

import com.example.hangrybirdz.userSessions.*;
import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
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
    public void GivenTestListTotalGamesPlayedEqualsFour() {
//        Given - I am an existing user
        when(user.isExistingUser()).thenReturn(true);
        when(user.getUsername()).thenReturn("bob");
        when(userController.readStats(anyString())).thenReturn(testList);
//        When - I have played four games with scores of 1,2,3, and 4
        HashMap returnHashMap =  stats.getStatsAsHashMap();
//        Then - totalGamesPlayed should equal 4
        Integer result = (Integer) returnHashMap.get("totalGamesPlayed");
        assertTrue(result==4);
    }

    @Test
    public void GivenTestListWorstScoreEqualsFour() {
//        Given - I am an existing user
        when(user.isExistingUser()).thenReturn(true);
        when(user.getUsername()).thenReturn("bob");
        when(userController.readStats(anyString())).thenReturn(testList);
//        When - I have played four games with scores of 1,2,3, and 4
        HashMap returnHashMap =  stats.getStatsAsHashMap();
//        Then - Worst Score should equal 4
        Integer result = (Integer) returnHashMap.get("worstScore");
        assertTrue(result==4);
    }

    @Test
    public void GivenTestListHighScoreEqualsOne() {
//        Given - I am an existing user
        when(user.isExistingUser()).thenReturn(true);
        when(user.getUsername()).thenReturn("bob");
        when(userController.readStats(anyString())).thenReturn(testList);
//        When - I have played four games with scores of 1,2,3, and 4
        HashMap returnHashMap =  stats.getStatsAsHashMap();
//        Then - High Score should equal 1
        Integer result = (Integer) returnHashMap.get("highScore");
        assertTrue(result==1);
    }

    @Test
    public void GivenTestListTotalShotsTakenEquals10() {
//        Given - I am an existing user
        when(user.isExistingUser()).thenReturn(true);
        when(user.getUsername()).thenReturn("bob");
        when(userController.readStats(anyString())).thenReturn(testList);
//        When - I have played four games with scores of 1,2,3, and 4
        HashMap returnHashMap =  stats.getStatsAsHashMap();
//        Then - High Score should equal 1
        Integer result = (Integer) returnHashMap.get("totalShotsTaken");
        assertTrue(result==10);
    }

    @Test
    public void GivenTestListAverageScoreEqualsTwoPointFive() {
//        Given - I am an existing user
        when(user.isExistingUser()).thenReturn(true);
        when(user.getUsername()).thenReturn("bob");
        when(userController.readStats(anyString())).thenReturn(testList);
//        When - I have played four games with scores of 1,2,3, and 4
        HashMap returnHashMap =  stats.getStatsAsHashMap();
//        Then - High Score should equal 1
        double result = (double) returnHashMap.get("averageScore");
        assertTrue(result==2.5);
    }


}
