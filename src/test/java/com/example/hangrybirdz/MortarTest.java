package com.example.hangrybirdz;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MortarTest {
    @Test
    public void GivenIncrementOfOneMortarSetToOne(){
        //Given: I have no mortars
        IMortar mortar = new Mortar();
        //When: increment(1) is called
        mortar.increment(1);
        //Then: Set the count to 1
        assertTrue(mortar.getCount() == 1);
    }

    @Test
    public void GivenIncrementOfSixMortarsSetToSix(){
        //Given: I have no mortars
        IMortar mortar = new Mortar();
        //When: increment(6) is called
        mortar.increment(6);
        //Then: Set the count to 6
        assertTrue(mortar.getCount() == 6);
    }

    @Test
    public void GivenFiveMortarsDecrementOfOneMortarsSetToFour(){
        //Given: I have 5 mortars
        IMortar mortar = new Mortar();
        mortar.increment(5);
        //When: decrement(1) is called
        mortar.decrement(1);
        //Then: Set the count to 4
        assertTrue(mortar.getCount() == 4);
    }



}
