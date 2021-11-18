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
    private boolean onPoint(ITarget target, ILandingPosition landingPosition){
        return (target.getxCoordinate() == landingPosition.getxCoordinate() &&
                target.getyCoordinate() == landingPosition.getyCoordinate());
    }

    private boolean oneBelowTarget(ITarget target, ILandingPosition landingPosition) {
        return (target.getxCoordinate() == landingPosition.getxCoordinate() &&
                target.getyCoordinate() + 1 == landingPosition.getyCoordinate());
    }

    private boolean oneLeftOfTarget(ITarget target, ILandingPosition landingPosition) {
        return (target.getxCoordinate() -1 == landingPosition.getxCoordinate()  &&
                target.getyCoordinate() == landingPosition.getyCoordinate());
    }
    private boolean oneAboveTarget(ITarget target, ILandingPosition landingPosition) {
        return (target.getxCoordinate() == landingPosition.getxCoordinate() &&
                target.getyCoordinate() - 1 == landingPosition.getyCoordinate());
    }

    private boolean oneRightOfTarget(ITarget target, ILandingPosition landingPosition) {
        return (target.getxCoordinate() + 1 == landingPosition.getxCoordinate() &&
                target.getyCoordinate()  == landingPosition.getyCoordinate());
    }
}
