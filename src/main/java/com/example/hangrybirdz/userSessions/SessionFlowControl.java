package com.example.hangrybirdz.userSessions;

import com.example.hangrybirdz.gameplay.interfaces.IGameFlowControl;

import java.util.HashMap;
import java.util.Scanner;

public class SessionFlowControl implements ISessionFlowControl{
    private IUser _user;
    private IStats _stats;
    private IGameFlowControl _gameFlowControl;
    private IContinuePlaying _continuePlaying;
    private boolean _sessionInProgress;

    public SessionFlowControl(IUser user, IStats stats, IGameFlowControl gameFlowControl, IContinuePlaying _continuePlaying) {
       this._user = user;
       this._stats = stats;
       this._gameFlowControl = gameFlowControl;
       this._continuePlaying = _continuePlaying;
       this._sessionInProgress = true;
    }

    @Override
    public void run() {
        _user.initialize(getCurrentUser());
        while(_sessionInProgress) {
            printStats();
            int score =  _gameFlowControl.run();
            _user.save(score);
            if(_continuePlaying.keepPlaying()) {
                continue;
            } else {
                _sessionInProgress = false;
            }
        }
        printStats();
        System.out.println("Thank you for playing");
    }

    private String getCurrentUser() {
        System.out.println("Hello, please enter a username");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        while (input.equals("")) {
            System.out.println("You must enter a username to play");
            input = scanner.nextLine();
        }
        return input;
    }

    private void printStats() {
        if (_user.isExistingUser()) {
            HashMap stats = _stats.getStatsAsHashMap();
            System.out.println("Username: " + _user.getUsername());
            System.out.println("Your current stats are: ");
            System.out.println("Total games played : " + stats.get("totalGamesPlayed"));
            System.out.println("Total shots taken: " + stats.get("totalShotsTaken"));
            System.out.println("Average Score: " + stats.get("averageScore"));
            System.out.println("High Score : " + stats.get("highScore"));
            System.out.println("Low Score: " + stats.get("worstScore"));
        } else System.out.println("You must play a game first");
    }
}
