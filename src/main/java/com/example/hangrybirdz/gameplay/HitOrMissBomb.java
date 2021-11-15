package com.example.hangrybirdz.gameplay;

import com.example.hangrybirdz.gameplay.interfaces.IHitOrMiss;
import com.example.hangrybirdz.gameplay.interfaces.ILandingPosition;
import com.example.hangrybirdz.gameplay.interfaces.ITarget;

public class HitOrMissBomb implements IHitOrMiss {


    @Override
    public boolean IsAHit(ITarget target, ILandingPosition landingPosition) {
        return true;
    }
}
