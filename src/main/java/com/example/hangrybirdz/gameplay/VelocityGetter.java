package com.example.hangrybirdz.gameplay;

import com.example.hangrybirdz.gameplay.interfaces.IVelocityGetter;

import java.util.Scanner;

public class VelocityGetter implements IVelocityGetter {
    @Override
    public String getInput() {
        System.out.println("Please enter a velocity between 1 and 20");
        Scanner myScanner = new Scanner(System.in);

        return myScanner.nextLine();

    }
}
