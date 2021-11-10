package com.example.hangrybirdz;

import java.util.Scanner;

public class VelocityGetter implements IVelocityGetter {
    @Override
    public String getInput() {
        Scanner myScanner = new Scanner(System.in);

        return myScanner.nextLine();

    }
}
