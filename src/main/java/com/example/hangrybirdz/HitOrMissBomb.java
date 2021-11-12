package com.example.hangrybirdz;

public class HitOrMissBomb implements IHitOrMiss {


    @Override
    public boolean IsAHit(ITarget target, ILandingPosition landingPosition) {
        return true;
    }
}
