package com.example.hangrybirdz;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class ShotFlowControl2Tests {

    private IAngleHandler angleHandler;
    private IVelocityHandler velocityHandler;
    private IShotFlowControl2 flow;
    private ILandingPosition landingPosition;
    private IHitOrMiss hitOrMiss;
    private ITarget target;

    @BeforeEach
    public void Startup() {
        angleHandler = mock(AngleHandler.class);
        velocityHandler = mock(VelocityHandler.class);
        landingPosition = mock(LandingPosition.class);
        hitOrMiss = mock(HitOrMiss.class);
        target = mock(Target.class);
        flow = new ShotFlowControl2(angleHandler,velocityHandler, landingPosition, hitOrMiss, target);
    }

    @Test
    public void GivenStartOfGameGetAngle() {
        flow.run();
        verify(angleHandler, times(1)).getAngle();
    }

    @Test
    public void GivenAngleGetVelocity() {
        flow.run();
        verify(velocityHandler, times(1)).getVelocity();
    }

    @Test
    public void GivenAngleAndVelocityCalculateLandingOnce() {
        when(angleHandler.getAngle()).thenReturn(1);
        when(velocityHandler.getVelocity()).thenReturn(1);
        flow.run();
        verify(landingPosition,times(1)).set(1,1);
    }

    @Test
    public void GivenLandingRunHitOrMissOnce() {
        when(angleHandler.getAngle()).thenReturn(1);
        when(velocityHandler.getVelocity()).thenReturn(1);
        flow.run();
        verify(hitOrMiss,times(1)).IsAHit(target,landingPosition);

    }

}
