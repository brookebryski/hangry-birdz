package com.example.hangrybirdz.userSessions;

import com.example.hangrybirdz.gameplay.interfaces.IGameFlowControl;

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
        System.out.println("Hello, please enter a username");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        while (input.equals("")) {
            System.out.println("You must enter a username to play");
            input = scanner.nextLine();
        }
        _user.initialize(input);
        while(_sessionInProgress) {
            _stats.getStats();
            int score =  _gameFlowControl.run();
            _user.save(score);

            if(_continuePlaying.keepPlaying()) {
                continue;
            } else {
                _sessionInProgress = false;
            }
        }
        _stats.getStats();
        System.out.println("Thank you for playing");
    }
}
