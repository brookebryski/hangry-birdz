package com.example.hangrybirdz;

public class ShotFlowControl2 implements IShotFlowControl2 {

    private IAngleHandler _angleHandler;
    private IVelocityHandler _velocityHandler;
    private ILandingPosition landingPosition;
    private ITarget target;

    public ShotFlowControl2(IAngleHandler angleHandler, IVelocityHandler velocityHandler, ILandingPosition landingPosition, ITarget target) {
        this._angleHandler = angleHandler;
        this._velocityHandler = velocityHandler;
        this.landingPosition = landingPosition;
        this.target = target;
    }

    @Override
    public boolean run(IHitOrMiss hitOrMissType) {
        int angle = _angleHandler.getAngle();
        int velocity = _velocityHandler.getVelocity();
        landingPosition.set(angle,velocity);
        System.out.println("Target is at X " + target.getxCoordinate() + " , Y " + target.getyCoordinate());
        System.out.println("You landed at X " + landingPosition.getxCoordinate() + " , Y " + landingPosition.getyCoordinate());
        return hitOrMissType.IsAHit(target,landingPosition);
    }
}
