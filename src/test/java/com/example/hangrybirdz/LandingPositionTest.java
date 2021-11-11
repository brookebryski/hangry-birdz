package com.example.hangrybirdz;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class LandingPositionTest {

    private IAngleConverter angleConverter;
    private IXLandingPosition xLandingPosition;
    private IYLandingPosition yLandingPosition;
    private LandingPosition landingPosition;

    @BeforeEach
    public void startup() {
        this.angleConverter = mock(AngleConverter.class);
        this.xLandingPosition = mock(XLandingPosition.class);
        this.yLandingPosition = mock(YLandingPosition.class);
        this.landingPosition = new LandingPosition(angleConverter,xLandingPosition,yLandingPosition);
    }

    @Test
    public void GivenAngle1Velocity1CallAngleConverterOnce() {
        landingPosition.set(1,1);
        verify(angleConverter, times(1)).Convert(1);

    }

    @Test
    public void GivenAngle1point571inRadiansAndVelocity1CallFindXPositionOnce() {
        when(angleConverter.Convert(90)).thenReturn(1.571);
        landingPosition.set(90,1);
        verify(xLandingPosition, times(1)).Find(1.571,1);
    }

    @Test
    public void GivenAngle1point571inRadiansAndVelocity1CallFindYPositionOnce() {
        when(angleConverter.Convert(90)).thenReturn(1.571);
        landingPosition.set(90,1);
        verify(yLandingPosition, times(1)).Find(1.571,1);
    }
}
