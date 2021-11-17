package com.example.hangrybirdz.userSessions;

import java.util.Scanner;

public class ContinuePlaying implements IContinuePlaying {
    @Override
    public boolean keepPlaying() {
        System.out.println("Would you like to continue playing?");
        Scanner scan2 = new Scanner(System.in);
        String input2 = scan2.nextLine();
        if (input2.equals("yes")) {
            return true;
        } else return false;
    }
}
