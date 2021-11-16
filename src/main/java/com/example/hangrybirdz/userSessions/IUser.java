package com.example.hangrybirdz.userSessions;

public interface IUser {
    void initialize(String username);
    boolean isExistingUser();
    String getUsername();
    void save(int score);
}
