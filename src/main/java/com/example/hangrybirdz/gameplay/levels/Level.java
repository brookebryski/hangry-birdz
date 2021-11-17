package com.example.hangrybirdz.gameplay.levels;

import com.example.hangrybirdz.gameplay.Target;
import com.example.hangrybirdz.gameplay.interfaces.IMortar;
import com.example.hangrybirdz.gameplay.interfaces.ITarget;

public class Level implements ILevel {
    private int shotCounter = 7;
    private ITarget target;
    private IMortar mortar;

    public Level(ITarget target, IMortar mortar) {
        this.target = target;
        this.mortar = mortar;
    }

    public int getShotCounter() {
        return shotCounter;
    }

    public void start() {

    }

    public int getMortarCount() {
        return this.mortar.getCount();
    }

    public int decrementShotCounter() {
        return this.shotCounter--;
    }


}
