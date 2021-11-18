package com.example.hangrybirdz.gameplay;

import com.example.hangrybirdz.gameplay.interfaces.*;

public class ShotFlowControl2 implements IShotFlowControl2 {

    private IAngleHandler _angleHandler;
    private IVelocityHandler _velocityHandler;
    private ILandingPosition landingPosition;
    private ITarget target;
    private ITarget target2;

    public ShotFlowControl2(IAngleHandler angleHandler, IVelocityHandler velocityHandler, ILandingPosition landingPosition, ITarget target, ITarget target2) {
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
        System.out.println("Target 1 is at X " + target.getxCoordinate() + " , Y " + target.getyCoordinate());
        System.out.println("Target 2 is at X " + target2.getxCoordinate() + " , Y " + target2.getyCoordinate());
        System.out.println("You landed at X " + landingPosition.getxCoordinate() + " , Y " + landingPosition.getyCoordinate());
        return hitOrMissType.IsAHit(target, target2, landingPosition);
    }
}
