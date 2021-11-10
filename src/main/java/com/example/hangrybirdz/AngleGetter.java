package com.example.hangrybirdz;

import java.util.Scanner;

public class AngleGetter implements IAngleGetter {

    public String GetAngle () {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
