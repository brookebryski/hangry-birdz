package com.example.hangrybirdz.gameplay;

import com.example.hangrybirdz.gameplay.interfaces.*;
import com.example.hangrybirdz.gameplay.levels.ILevel;
import com.example.hangrybirdz.gameplay.levels.Level;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameFlowControl implements IGameFlowControl {

    private ITarget _target;
    private ITarget _target2;
    private IShotFlowControl2 _shotFlowControl2;
    private IMortar _mortar;
    private IBomb _bomb;
    private ILevel _level;
    private int shotCounter = 0;
    private int levelShotCounter = 0;
    private IHitOrMiss _hitOrMissShot;
    private IHitOrMiss _hitOrMissMortar;
    private IHitOrMiss _hitOrMissBomb;
    private boolean isGameRunning = true;
    private boolean isAHit = false;
    private int levelCounter = 1;


    public GameFlowControl(ILevel level, ITarget target, ITarget target2, IShotFlowControl2 shotFlowControl2, IMortar mortar, IBomb bomb, IHitOrMiss hitOrMissShot, IHitOrMiss hitOrMissMortar, IHitOrMiss hitOrMissBomb) {
        this._target = target;
        this._target2 = target2;
        this._shotFlowControl2 = shotFlowControl2;
        this._mortar = mortar;
        this._bomb = bomb;
        this._hitOrMissShot = hitOrMissShot;
        this._hitOrMissMortar = hitOrMissMortar;
        this._hitOrMissBomb = hitOrMissBomb;
        this._level = level;
    }


    public void run() {

        ArrayList<ITarget> targets = new ArrayList<>();
        int hiddenLevelCounter = 1;

        _target.Set();
        targets.add(_target);

        if(levelCounter == 1){
            System.out.println("You are on level 1");
            System.out.println("-------------------------------");
            System.out.println("Your target is at X " + _target.getxCoordinate() + " ,Y " + _target.getyCoordinate());
        }
        while (isGameRunning) {
            if (ShotISAHit() && targets.stream().allMatch(target -> target.getTargetTracker() == true)) {
                if(levelCounter == 2){
                    isGameRunning = false;
                }
                levelCounter++;
//                System.out.println("Would you like to play the next level");
 //               isGameRunning = false;
            } else if(levelShotCounter == 6) {
                System.out.println("You have fired all your shots, you lose");
                isGameRunning = false;
            } else {
                shotCounter++;
                levelShotCounter++;
                System.out.println("You missed, try again. You have " + (7 - levelShotCounter) + " shots remaining");
//                AddToInventory();
            }
            if (levelCounter == 2 && hiddenLevelCounter == 1) {
                hiddenLevelCounter++;
                _target.Set();
                _target2.Set();
                targets.add(_target2);

                levelShotCounter = 0;
                _mortar.increment(1);
                System.out.println("You are on level 2");
                System.out.println("Your new targets are located at X " + _target.getxCoordinate() + " ,Y " + _target.getyCoordinate() + " and X " + _target2.getxCoordinate() + " ,Y " + _target2.getyCoordinate());
                //isGameRunning = false;
           }
        }

    }

    private boolean useMortar() {
        if (_mortar.getCount() > 0) {
            System.out.println("Would you like to use a mortar?");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            if (input.equals("yes")) {
                _mortar.decrement(1);
                return true;
            } else return false;
        } else return false;
    }

    private boolean useBomb() {
        if (_bomb.getCount() > 0) {
            System.out.println("Would you like to use a bomb?");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            if (input.equals("yes")) {
                _bomb.decrement(1);
                return true;
            } else return false;
        } else return false;
    }

    private boolean ShotISAHit() {
        if (useMortar()) {
            isAHit = _shotFlowControl2.run(_hitOrMissMortar);
        }
        else if (useBomb()) {
            isAHit = _shotFlowControl2.run(_hitOrMissBomb);
        }
        else
            isAHit = _shotFlowControl2.run(_hitOrMissShot);
        return isAHit;
    }

    private void AddToInventory() {
        if (shotCounter == 4) {
            _mortar.increment(1);
        }
        if (shotCounter == 10) {
            _bomb.increment(1);
        }
    }

}
