package com.example.hangrybirdz.userSessions;

import java.util.Dictionary;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;

public class Stats implements IStats {

    private final IUserController _userController;
    private final IUser _user;
    private int _worstScore;
    private int _highScore;
    private int _totalGamesPlayed;
    private int _totalShotsTaken;
    private double _averageScore;

    public Stats(IUserController userController, IUser user) {
        this._userController = userController;
        this._user = user;
    }

    @Override
    public void getStats() {
        if (_user.isExistingUser()) {
            List<Integer> stats = _userController.readStats(_user.getUsername());
            _worstScore = stats.get(0);
            _highScore = stats.get(0);
            _totalGamesPlayed = 0;
            _totalShotsTaken = 0;
            int currentScore;
            for (int i = 0; i <= stats.size() - 1; i++) {
                currentScore = stats.get(i);
                if (currentScore < _highScore) {
                    _highScore = currentScore;
                } else if (currentScore > _worstScore) {
                    _worstScore = currentScore;
                }
                _totalGamesPlayed++;
                _totalShotsTaken = _totalShotsTaken + currentScore;
            }
            _averageScore = (double) _totalShotsTaken / _totalGamesPlayed;
            System.out.println("Username: " + _user.getUsername());
            System.out.println("Your current stats are: ");
            System.out.println("Total games played : " + _totalGamesPlayed);
            System.out.println("Total shots taken: " + _totalShotsTaken);
            System.out.println("Average Score: " + (double)Math.round(_averageScore * 10d)/ 10d);
            System.out.println("High Score : " + _highScore);
            System.out.println("Low Score: " + _worstScore);
        } else {
            System.out.println("Please play your first game so you can see your stats");
        }
    }

    @Override
    public HashMap getStatsAsHashMap() {
        if (_user.isExistingUser()) {
            List<Integer> stats = _userController.readStats(_user.getUsername());
            _worstScore = stats.get(0);
            _highScore = stats.get(0);
            _totalGamesPlayed = 0;
            _totalShotsTaken = 0;
            int currentScore;
            for (int i = 0; i <= stats.size() - 1; i++) {
                currentScore = stats.get(i);
                if (currentScore < _highScore) {
                    _highScore = currentScore;
                } else if (currentScore > _worstScore) {
                    _worstScore = currentScore;
                }
                _totalGamesPlayed++;
                _totalShotsTaken = _totalShotsTaken + currentScore;
            }
            _averageScore = (double) _totalShotsTaken / _totalGamesPlayed;

            HashMap returnHash = new HashMap();
            returnHash.put("worstScore", _worstScore);
            returnHash.put("highScore", _highScore);
            returnHash.put("totalGamesPlayed", _totalGamesPlayed);
            returnHash.put("totalShotsTaken", _totalShotsTaken);
            returnHash.put("averageScore", (double)Math.round(_averageScore * 10d)/ 10d);
            return returnHash;

        } else {
            return null;
        }
    }
}
