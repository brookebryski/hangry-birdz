package com.example.hangrybirdz.userSessions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserController implements IUserController {
    public void create(String username, int score) {
        try {
            FileWriter csvWriter = new FileWriter("storage.csv", true);
            csvWriter.append("\n");
            csvWriter.append(username);
            csvWriter.append(",");
            csvWriter.append(String.valueOf(score));
            csvWriter.flush();
            csvWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean readUser(String username) {
        String line = "";
        String splitBy = ",";
        try {
            BufferedReader br = new BufferedReader(new FileReader("storage.csv"));
            while ((line = br.readLine()) != null)
            {
                String[] gamerRecord = line.split(splitBy);
                if (gamerRecord[0].equals(username)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Integer> readStats(String username) {
        List<Integer> stats = new ArrayList<Integer>();
        String line = "";
        String splitBy = ",";
        try {
            BufferedReader br = new BufferedReader(new FileReader("storage.csv"));
            while ((line = br.readLine()) != null)
            {
                String[] gamerRecord = line.split(splitBy);
                if (gamerRecord[0].equals(username)) {
                    stats.add(Integer.valueOf(gamerRecord[1]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stats;
    }

}
