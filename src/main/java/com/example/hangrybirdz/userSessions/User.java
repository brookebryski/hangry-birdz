package com.example.hangrybirdz.userSessions;

public class User implements IUser {
    private userController _userController;

    public User(userController userController) {
        _userController = userController;
    }

    public void initialize(String username){
        _userController.read(username);
    }
}
