package com.example.hangrybirdz.gameplay.levels;

import com.example.hangrybirdz.gameplay.interfaces.ITarget;

public interface ILevel {
    int getShotCounter();

    void start();

    int getMortarCount();

    int decrementShotCounter();
}
