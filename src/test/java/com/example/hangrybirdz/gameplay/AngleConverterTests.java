package com.example.hangrybirdz.gameplay;

import com.example.hangrybirdz.gameplay.AngleConverter;
import com.example.hangrybirdz.gameplay.interfaces.IAngleConverter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class AngleConverterTests {
    @Test
    public void given1InDegreesGetBack017Radians(){
        //Given: I am a user
        IAngleConverter act = new AngleConverter();
        //When: I enter  the angle 1
        double radians = act.Convert(1);
        //Then: The angle in radians 0.017
        assertEquals(0.017,radians);
    }

    @Test
    public void given90InDegreesGetBack1507Radians(){
        //Given: I am a user
        IAngleConverter act = new AngleConverter();
        //When: I enter  the angle 90
        double radians = act.Convert(90);
        //Then: The angle in radians 1.571
        assertEquals(1.571,radians);
    }

}
