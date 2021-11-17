package com.example.hangrybirdz.gameplay;

import com.example.hangrybirdz.gameplay.interfaces.*;

import java.util.Scanner;

public class GameFlowControl implements IGameFlowControl {

    private ITarget _target;
    private IShotFlowControl2 _shotFlowControl2;
    private IMortar _mortar;
    private IBomb _bomb;
    private int shotCounter;
    private IHitOrMiss _hitOrMissShot;
    private IHitOrMiss _hitOrMissMortar;
    private IHitOrMiss _hitOrMissBomb;
    private boolean isGameRunning;
    private boolean isAHit;


    public GameFlowControl(ITarget target, IShotFlowControl2 shotFlowControl2, IMortar mortar, IBomb bomb, IHitOrMiss hitOrMissShot, IHitOrMiss hitOrMissMortar, IHitOrMiss hitOrMissBomb) {
        this._target = target;
        this._shotFlowControl2 = shotFlowControl2;
        this._mortar = mortar;
        this._bomb = bomb;
        this._hitOrMissShot = hitOrMissShot;
        this._hitOrMissMortar = hitOrMissMortar;
        this._hitOrMissBomb = hitOrMissBomb;
    }

    public int run() {
        shotCounter = 1;
        isGameRunning = true;
        isAHit = false;
        _target.Set();
        System.out.println("The target is at X " + _target.getxCoordinate() + " ,Y " + _target.getyCoordinate());
        while (isGameRunning) {
            if (ShotISAHit()) {
                isGameRunning = false;
            } else {
                System.out.println("You missed, try again");
                shotCounter++;
                AddToInventory();
            }
        }
        System.out.println("You won the game with " + shotCounter + " shots.");
        return shotCounter;
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
