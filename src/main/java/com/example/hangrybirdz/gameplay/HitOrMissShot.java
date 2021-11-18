package com.example.hangrybirdz.gameplay;

import com.example.hangrybirdz.gameplay.interfaces.IHitOrMiss;
import com.example.hangrybirdz.gameplay.interfaces.ILandingPosition;
import com.example.hangrybirdz.gameplay.interfaces.ITarget;

public class HitOrMissShot implements IHitOrMiss {


    @Override
    public boolean IsAHit(ITarget target, ITarget target2, ILandingPosition landingPosition) {
        if ((target.getxCoordinate() == landingPosition.getxCoordinate() &&
                target.getyCoordinate() == landingPosition.getyCoordinate())) {

            target.setTargetTracker(true);
            return true;

        }
        if ((target2.getxCoordinate() == landingPosition.getxCoordinate() && target2.getyCoordinate() == landingPosition.getyCoordinate())) {

                target2.setTargetTracker(true);
                return true;
        }
        return false;
    }
}
