package com.example.hangrybirdz;

public class ShotFlowControl2 implements IShotFlowControl2 {

    private IAngleHandler _angleHandler;
    private IVelocityHandler _velocityHandler;
    private ILandingPosition landingPosition;

    private IHitOrMiss hitOrMiss;
    private ITarget target;

    public ShotFlowControl2(IAngleHandler angleHandler, IVelocityHandler velocityHandler, ILandingPosition landingPosition, IHitOrMiss hitOrMiss, ITarget target) {
        this._angleHandler = angleHandler;
        this._velocityHandler = velocityHandler;
        this.landingPosition = landingPosition;
        this.hitOrMiss = hitOrMiss;
        this.target = target;
    }

    @Override
    public boolean run() {
        int angle = _angleHandler.getAngle();
        int velocity = _velocityHandler.getVelocity();
        landingPosition.set(angle,velocity);
        return hitOrMiss.IsAHit(target,landingPosition);
    }
}
