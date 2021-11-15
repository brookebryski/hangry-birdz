package com.example.hangrybirdz.gameplay;

import com.example.hangrybirdz.gameplay.*;
import com.example.hangrybirdz.gameplay.interfaces.IVelocityGetter;
import com.example.hangrybirdz.gameplay.interfaces.IVelocityHandler;
import com.example.hangrybirdz.gameplay.interfaces.IVelocityIntegerValidator;
import com.example.hangrybirdz.gameplay.interfaces.IVelocityRangeValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class VelocityHandlerTest {


    private IVelocityGetter velocityGetter;
    private IVelocityIntegerValidator velocityIntegerValidator;
    private IVelocityRangeValidator velocityRangeValidator;
    private IVelocityHandler velocityHandler;




    @BeforeEach
    public void startup() {
        this.velocityGetter = mock(VelocityGetter.class);
        this.velocityIntegerValidator = mock(VelocityIntegerValidator.class);
        this.velocityRangeValidator = mock(VelocityRangeValidator.class);

        this.velocityHandler = new VelocityHandler(velocityGetter, velocityIntegerValidator, velocityRangeValidator);
    }


    @Test
    public void givenAngleCallGetInputOnce(){
        when(velocityGetter.getInput()).thenReturn("1");
        when(velocityIntegerValidator.isInteger("1")).thenReturn(true);
        when(velocityRangeValidator.isInRange(1)).thenReturn(true);
        velocityHandler.getVelocity();
        verify(velocityGetter,times(1)).getInput();
    }

    @Test
    public void givenOneCallisIntegerOnce(){
        when(velocityGetter.getInput()).thenReturn("1");
        when(velocityIntegerValidator.isInteger("1")).thenReturn(true);
        when(velocityRangeValidator.isInRange(1)).thenReturn(true);
        velocityHandler.getVelocity();
        verify(velocityIntegerValidator,times(1)).isInteger("1");
    }

    @Test
    public void givenOneCallIsInRangeOnce(){
        when(velocityGetter.getInput()).thenReturn("1");
        when(velocityIntegerValidator.isInteger("1")).thenReturn(true);
        when(velocityRangeValidator.isInRange(1)).thenReturn(true);
        velocityHandler.getVelocity();
        verify(velocityRangeValidator,times(1)).isInRange(1);
    }

//    @Test
//    public void givenBobTimeout() {
//        when(velocityGetter.getInput()).thenReturn("Bob");
//        when(velocityIntegerValidator.isInteger("Bob")).thenReturn(false);
////        VelocityHandler.getVelocity();
////        Instant start = Instant.now();
////        Instant end = Instant.now();
////        Duration timeout = Duration.between(start, end);
////        timeout.plusSeconds(2);
////        Timeout()
////        assertTimeoutPreemptively(timeout, () -> VelocityHandler.getVelocity() );
//////        verify(VelocityIntegerValidator,times(1)).isInteger("bob");
//        verify(velocityHandler, timeout(1000)).getVelocity();
//    }
}
