package com.example.hangrybirdz.gameplay;

import com.example.hangrybirdz.gameplay.interfaces.IHitOrMiss;
import com.example.hangrybirdz.gameplay.interfaces.ILandingPosition;
import com.example.hangrybirdz.gameplay.interfaces.ITarget;

public class HitOrMissMortar implements IHitOrMiss {
    @Override
    public boolean IsAHit(ITarget target, ITarget target2, ILandingPosition landingPosition) {
        return onPoint(target,target2, landingPosition) ||
                oneBelowTarget(target,target2, landingPosition) ||
                oneLeftOfTarget(target,target2, landingPosition) ||
                oneAboveTarget(target, target2, landingPosition) ||
                oneRightOfTarget(target, target2, landingPosition);
    }
    private boolean onPoint(ITarget target, ITarget target2, ILandingPosition landingPosition) {
        if (target.getxCoordinate() == landingPosition.getxCoordinate() && target.getyCoordinate() == landingPosition.getyCoordinate()) {
            target.setTargetTracker(true);
            return (target.getxCoordinate() == landingPosition.getxCoordinate() && target.getyCoordinate() == landingPosition.getyCoordinate());
        } else if (target2.getxCoordinate() == landingPosition.getxCoordinate() && target2.getyCoordinate() == landingPosition.getyCoordinate()) {
            target2.setTargetTracker(true);
            return (target2.getxCoordinate() == landingPosition.getxCoordinate() && target2.getyCoordinate() == landingPosition.getyCoordinate());
        }
        return false;
    }

    private boolean oneBelowTarget(ITarget target, ITarget target2, ILandingPosition landingPosition) {
        if (target.getxCoordinate() == landingPosition.getxCoordinate() && target.getyCoordinate() + 1 == landingPosition.getyCoordinate()) {
            target.setTargetTracker(true);
            return (target.getxCoordinate() == landingPosition.getxCoordinate() && target.getyCoordinate() + 1 == landingPosition.getyCoordinate());
        } else if (target2.getxCoordinate() == landingPosition.getxCoordinate() && target2.getyCoordinate() + 1 == landingPosition.getyCoordinate()) {
            target2.setTargetTracker(true);
            return (target2.getxCoordinate() == landingPosition.getxCoordinate() && target2.getyCoordinate() + 1 == landingPosition.getyCoordinate());
        }
        return false;
    }

    private boolean oneLeftOfTarget(ITarget target, ITarget target2, ILandingPosition landingPosition) {
        if (target.getxCoordinate() -1 == landingPosition.getxCoordinate()  && target.getyCoordinate() == landingPosition.getyCoordinate()) {
            target.setTargetTracker(true);
            return target.getxCoordinate() -1 == landingPosition.getxCoordinate()  && target.getyCoordinate() == landingPosition.getyCoordinate();
        } else if (target2.getxCoordinate() -1 == landingPosition.getxCoordinate()  && target2.getyCoordinate() == landingPosition.getyCoordinate()) {
            target2.setTargetTracker(true);
            return target2.getxCoordinate() -1 == landingPosition.getxCoordinate()  && target2.getyCoordinate() == landingPosition.getyCoordinate();
        }

        return false;
    }
    private boolean oneAboveTarget(ITarget target, ITarget target2, ILandingPosition landingPosition) {
        if (target.getxCoordinate() == landingPosition.getxCoordinate() && target.getyCoordinate() - 1 == landingPosition.getyCoordinate()) {
            target.setTargetTracker(true);
           return (target.getxCoordinate() == landingPosition.getxCoordinate() && target.getyCoordinate() - 1 == landingPosition.getyCoordinate());
        } else if (target2.getxCoordinate() == landingPosition.getxCoordinate() && target2.getyCoordinate() - 1 == landingPosition.getyCoordinate()) {
            target2.setTargetTracker(true);
            return (target2.getxCoordinate() == landingPosition.getxCoordinate() && target2.getyCoordinate() - 1 == landingPosition.getyCoordinate());
        }
        return false;
    }

    private boolean oneRightOfTarget(ITarget target, ITarget target2, ILandingPosition landingPosition) {
        if (target.getxCoordinate() + 1 == landingPosition.getxCoordinate() && target.getyCoordinate()  == landingPosition.getyCoordinate()) {
            target.setTargetTracker(true);
            return target.getxCoordinate() + 1 == landingPosition.getxCoordinate() && target.getyCoordinate()  == landingPosition.getyCoordinate();
        } else if (target2.getxCoordinate() + 1 == landingPosition.getxCoordinate() && target2.getyCoordinate()  == landingPosition.getyCoordinate()){
            target2.setTargetTracker(true);
            return target2.getxCoordinate() + 1 == landingPosition.getxCoordinate() && target2.getyCoordinate()  == landingPosition.getyCoordinate();
        }
        return false;
    }
}
