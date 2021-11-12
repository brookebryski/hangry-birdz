package com.example.hangrybirdz;

public class HitOrMissShot implements IHitOrMiss{


    @Override
    public boolean IsAHit(ITarget target, ILandingPosition landingPosition) {
        return (target.getxCoordinate() == landingPosition.getxCoordinate() &&
                target.getyCoordinate() == landingPosition.getyCoordinate());
    }
}
