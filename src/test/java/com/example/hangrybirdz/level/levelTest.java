package com.example.hangrybirdz.level;

import com.example.hangrybirdz.gameplay.GameFlowControl;
import com.example.hangrybirdz.gameplay.Mortar;
import com.example.hangrybirdz.gameplay.Target;
import com.example.hangrybirdz.gameplay.interfaces.IGameFlowControl;
import com.example.hangrybirdz.gameplay.interfaces.IMortar;
import com.example.hangrybirdz.gameplay.interfaces.ITarget;
import com.example.hangrybirdz.gameplay.levels.ILevel;
import com.example.hangrybirdz.gameplay.levels.Level;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

public class levelTest {

    private ILevel level1;
    private ITarget targetMock;
    private IMortar mortarMock;
//    private IGameFlowControl gameFlowControlMock;

    @BeforeEach
    void setup() {
//        this.gameFlowControlMock = mock(GameFlowControl.class);
        this.targetMock = mock(Target.class);
        this.mortarMock = mock(Mortar.class);
        this.level1 = new Level(targetMock, mortarMock);
    }

    @Test
    void startLevelOneWithSevenShots() {
        // given: I am a user
        int expectedShotCount = 7;

        // when: I start level one
        level1.start();
        int actualShotCount = level1.getShotCounter();

        // then: I have 7 shots left
        assertEquals(expectedShotCount, actualShotCount);
    }

    @Test
    void startLevelMortarEqualsZero() {
        // given: I am a user
        int expectedMortarCount = 0;

        // when: I start level one
        level1.start();
        int actualMortarCount = level1.getMortarCount();

        // then: I have 0 mortars
        assertEquals(expectedMortarCount, actualMortarCount);
    }

    @Test
    void givenTakenFirstShotShotCounterEqualsSix() {
        // given: I am a user
        int expectedShotCount = 6;

        // when: I take my first shot
        level1.decrementShotCounter();
        int actualShotCount = level1.getShotCounter();

        // then: Shot counter equals 6
        assertEquals(expectedShotCount, actualShotCount);

    }
}
