package com.example.hangrybirdz.userSessions;

import java.util.List;

public interface IUserController {
    void create(String username, int score);
    boolean readUser(String username);
    List<Integer> readStats(String username);
}
