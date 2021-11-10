package com.example.hangrybirdz;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class ShotFlowControlTests {

    private IAngleGetter angleGetter;
    private IAngleIntegerValidator angleIntValid;
    private IShotFlowControl flow;
    private IAngleRangeValidator angleRangeValidator;
    private IVelocityGetter velocityGetter;
    private IVelocityIntegerValidator velocityIntegerValidator;
    private IVelocityRangeValidator velocityRangeValidator;
    private IAngleConverter angleConverter;
    private IXLandingPosition xLandingPosition;
    private IYLandingPosition yLandingPosition;
    private IHitOrMiss hitOrMiss;
    private String targetCoordinates;

    @BeforeEach
    public void setUp(){
        this.angleGetter = mock(AngleGetter.class);
        this.angleIntValid = mock(AngleIntegerValidator.class);
        this.angleRangeValidator = mock(AngleRangeValidator.class);
        this.velocityGetter = mock(VelocityGetter.class);
        this.velocityIntegerValidator = mock(VelocityIntegerValidator.class);
        this.velocityRangeValidator = mock(VelocityRangeValidator.class);
        this.angleConverter = mock(AngleConverter.class);
        this.xLandingPosition = mock(XLandingPosition.class);
        this.yLandingPosition = mock(YLandingPosition.class);
        this.hitOrMiss = mock(HitOrMiss.class);
        this.targetCoordinates = "1,1";
        this.flow = new ShotFlowControl(angleGetter,angleIntValid,angleRangeValidator, velocityGetter, velocityIntegerValidator,
                velocityRangeValidator, angleConverter, xLandingPosition,yLandingPosition, hitOrMiss, targetCoordinates);
    }


    @Test
    public void whenRoundStartsCallAngleGetterOnce(){
        //Given: I am a user
        //When: round starts
        when(angleGetter.GetAngle()).thenReturn("1");
        when(velocityGetter.GetVelocity()).thenReturn("1");
        flow.run();
        //Then: call AngleGetter.GetAngle() once
        verify(angleGetter, times(1)).GetAngle();

    }

    @Test
    public void givenAngleStringCallAngleIntegerValidatorOnce(){
        //Given: I am a user
        //When: user enters an angle of "1"
        when(angleGetter.GetAngle()).thenReturn("1");
        when(velocityGetter.GetVelocity()).thenReturn("1");
        flow.run();
        //Then: call AngleIntegerValidator.IsInteger() once
        verify(angleIntValid, times(1)).IsInteger("1");
    }

    @Test
    public void givenAngleIntegerCallAngleRangeValidatorOnce(){
        //Given: I am a user
        //When:  user enters an angle of "1"
        when(angleGetter.GetAngle()).thenReturn("1");
        when(velocityGetter.GetVelocity()).thenReturn("1");
        when(angleIntValid.IsInteger("1")).thenReturn(true);
        flow.run();
        //Then: call AngleRangeValidator.IsInRange() once
        verify(angleRangeValidator, times(1)).isInRange(1);
    }

    @Test
    public void givenAngleOfOneCallGetVelocityOnce(){
        //Given: I have an angle of "1"
        //When: We need velocity
        when(angleGetter.GetAngle()).thenReturn("1");
        when(velocityGetter.GetVelocity()).thenReturn("1");
        flow.run();
        //Then: Call VelocityGetter.GetVelocity() once
        verify(velocityGetter, times(1)).GetVelocity();
    }

    @Test
    public void givenVelocityCallVelocityIntegerValidatorOnce(){
        //Given: I am a user
        //When:When: user enters an angle of "1"
        when(angleGetter.GetAngle()).thenReturn("1");
        when(velocityGetter.GetVelocity()).thenReturn("1");
        flow.run();
        //Then: call VelocityIntegerValidator.IsInteger() once
        verify(velocityIntegerValidator, times(1)).isInteger("1");
    }

    @Test
    public void givenVelocityOneCallVelocityRangeValidatorOnce(){
        //Given: I am a user
        //When: When: user enters an angle of "1"
        when(angleGetter.GetAngle()).thenReturn("1");
        when(velocityGetter.GetVelocity()).thenReturn("1");
        flow.run();
        //Then: call VelocityRangeValidator.IsInRange() once
        verify(velocityRangeValidator, times(1)).isInRange(1);
    }

    @Test
    public void givenAngleOneVelocityOneCallAngleConverterOnce(){
        //Given: I have an angle of 1 and velocity of 1
        //When:  I need to know radians
        when(angleGetter.GetAngle()).thenReturn("1");
        when(velocityGetter.GetVelocity()).thenReturn("1");
        flow.run();
        //Then: call AngleConverter.convert() once
        verify(angleConverter, times(1)).Convert(1);
    }

    @Test
    public void givenRadiansVelocityOneComputerXCoord(){
        //Given: I have the raidans (~1.05707) and the velocity of 1
        //When: I compute X value
        when(angleGetter.GetAngle()).thenReturn("1");
        when(velocityGetter.GetVelocity()).thenReturn("1");
        when(angleConverter.Convert(1)).thenReturn(1.0571);
        flow.run();
        //Then: call XLandingPosition.find() once
        verify(xLandingPosition, times(1)).Find(1.0571,1);
    }

    @Test
    public void givenRadiansVelocityOneComputerYCoord(){
        //Given: I have the raidans (~1.05707) and the velocity of 1
        //When: I compute Y value
        when(angleGetter.GetAngle()).thenReturn("1");
        when(velocityGetter.GetVelocity()).thenReturn("1");
        when(angleConverter.Convert(1)).thenReturn(1.0571);
        flow.run();
        //Then: call YLandingPosition.find() once
        verify(xLandingPosition, times(1)).Find(1.0571,1);
    }

    @Test
    public void givenXYHitOrMiss(){
        //Given: I have the raidans (~1.05707) and the velocity of 1
        //When:I need to know if the shot hit or missed
        when(angleGetter.GetAngle()).thenReturn("1");
        when(velocityGetter.GetVelocity()).thenReturn("1");
        when(angleConverter.Convert(1)).thenReturn(1.0571);
        flow.run();
        //Then:call HitOrMiss.IsAHit() once
        verify(hitOrMiss, times(1)).IsAHit("1,1", 1,1);
    }

}
