package com.example.hangrybirdz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.verification.Timeout;


import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.mockito.Mockito.*;

public class AngleHandlerTest {


    private IAngleGetter angleGetter;
    private IAngleIntegerValidator angleIntegerValidator;
    private IAngleRangeValidator angleRangeValidator;

    private IAngleHandler angleHandler;




    @BeforeEach
    public void startup() {
        this.angleGetter = mock(AngleGetter.class);
        this.angleIntegerValidator = mock(AngleIntegerValidator.class);
        this.angleRangeValidator = mock(AngleRangeValidator.class);

        this.angleHandler = new AngleHandler(angleGetter, angleIntegerValidator, angleRangeValidator);
    }


    @Test
    public void givenRoundBeginsCallGetInputOnce(){
        when(angleGetter.getInput()).thenReturn("1");
        when(angleIntegerValidator.IsInteger("1")).thenReturn(true);
        when(angleRangeValidator.isInRange(1)).thenReturn(true);
        angleHandler.getAngle();
        verify(angleGetter,times(1)).getInput();
    }

    @Test
    public void givenOneCallIsIntegerOnce(){
        when(angleGetter.getInput()).thenReturn("1");
        when(angleIntegerValidator.IsInteger("1")).thenReturn(true);
        when(angleRangeValidator.isInRange(1)).thenReturn(true);
        angleHandler.getAngle();
        verify(angleIntegerValidator,times(1)).IsInteger("1");
    }

    @Test
    public void givenOneCallIsInRangeOnce(){
        when(angleGetter.getInput()).thenReturn("1");
        when(angleIntegerValidator.IsInteger("1")).thenReturn(true);
        when(angleRangeValidator.isInRange(1)).thenReturn(true);
        angleHandler.getAngle();
        verify(angleRangeValidator,times(1)).isInRange(1);
    }

    @Test
    public void givenBobTimeout() {
        when(angleGetter.getInput()).thenReturn("Bob");
        when(angleIntegerValidator.IsInteger("Bob")).thenReturn(false);
//        angleHandler.getAngle();
//        Instant start = Instant.now();
//        Instant end = Instant.now();
//        Duration timeout = Duration.between(start, end);
//        timeout.plusSeconds(2);
//        Timeout()
//        assertTimeoutPreemptively(timeout, () -> angleHandler.getAngle() );
////        verify(angleIntegerValidator,times(1)).IsInteger("bob");
        verify(angleHandler, timeout(1000)).getAngle();
    }
}
