package com.example.hangrybirdz;

public class HitOrMiss implements IHitOrMiss{


    @Override
    public boolean IsAHit(ITarget target, ILandingPosition landingPosition) {
        return (target.getxCoordinate() == landingPosition.getxCoordinate() &&
                target.getyCoordinate() == landingPosition.getyCoordinate());

    }

}
