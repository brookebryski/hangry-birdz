package com.example.hangrybirdz;

import java.util.Scanner;

public class AngleGetter implements IAngleGetter {

    private IAngleGetter angleGetter;
    private IHitOrMiss hitOrMiss;

    public AngleGetter(IAngleGetter angleGetter) {
        this.angleGetter = angleGetter;
    }


    public String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
