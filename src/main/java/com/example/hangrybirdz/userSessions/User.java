package com.example.hangrybirdz.userSessions;

public class User implements IUser {
    private userController _userController;
    private boolean _existingUser;
    private String _username;

    public User(userController userController) {
        _userController = userController;
    }


    public void initialize(String username){
        this._username = username;
        if(_userController.read(username)) {
            _existingUser = true;
        } else {
            _existingUser = false;
        }
    }
//Comment to test feature branch
    public void print() {
        System.out.println("print statement here");
    }


    public void save(int score){
        _userController.create(_username, score);
        _existingUser = true;
    }

    public boolean isExistingUser() {
        return _existingUser;
    }

    public String getUsername() {
        return _username;
    }
}
