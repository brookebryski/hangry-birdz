package com.example.hangrybirdz;

public class HitOrMissMortar implements IHitOrMiss {
    @Override
    public boolean IsAHit(ITarget target, ILandingPosition landingPosition) {
        return onPoint(target, landingPosition) ||
                oneBelowTarget(target, landingPosition) ||
                oneLeftOfTarget(target, landingPosition) ||
                oneAboveTarget(target, landingPosition) ||
                oneRightOfTarget(target, landingPosition);
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
