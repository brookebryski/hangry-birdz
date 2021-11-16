package com.example.hangrybirdz.userSessions;

import com.example.hangrybirdz.gameplay.interfaces.IGameFlowControl;

import java.util.Scanner;

public class SessionFlowControl implements ISessionFlowControl{
    private IUser _user;
    private IStats _stats;
    private IGameFlowControl _gameFlowControl;
    private boolean _sessionInProgress;

    public SessionFlowControl(IUser user, IStats stats, IGameFlowControl gameFlowControl) {
       this._user = user;
       this._stats = stats;
       this._gameFlowControl = gameFlowControl;
       this._sessionInProgress = true;
    }

    @Override
    public void run() {
        System.out.println("Hello, please enter a username");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        _user.initialize(input);
        while(_sessionInProgress) {
            _stats.getStats(_user);
            int score =  _gameFlowControl.run();
            _user.save(score);
            System.out.println("Would you like to continue playing?");
            Scanner scan2 = new Scanner(System.in);
           String input2 = scan2.nextLine();
            if(input2 == "no") {
                _sessionInProgress = false;
            }
        }
        _stats.getStats(_user);
        System.out.println("Thank you for playing");
    }
}
