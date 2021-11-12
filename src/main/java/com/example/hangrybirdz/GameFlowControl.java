package com.example.hangrybirdz;

import java.util.Scanner;

public class GameFlowControl implements IGameFlowControl {

    private ITarget _target;
    private IShotFlowControl2 _shotFlowControl2;
    private IMortar _mortar;
    private IBomb _bomb;
    private int shotCounter = 1;
    private IHitOrMiss _hitOrMissShot;
    private IHitOrMiss _hitOrMissMortar;
    private IHitOrMiss _hitOrMissBomb;
    private boolean isGameRunning = true;
    private boolean isAHit = false;


    public GameFlowControl(ITarget target, IShotFlowControl2 shotFlowControl2, IMortar mortar, IBomb bomb, IHitOrMiss hitOrMissShot, IHitOrMiss hitOrMissMortar, IHitOrMiss hitOrMissBomb) {
        this._target = target;
        this._shotFlowControl2 = shotFlowControl2;
        this._mortar = mortar;
        this._bomb = bomb;
        this._hitOrMissShot = hitOrMissShot;
        this._hitOrMissMortar = hitOrMissMortar;
        this._hitOrMissBomb = hitOrMissBomb;
    }

    public void run() {
        _target.Set();
        System.out.println("The target is at X " + _target.getxCoordinate() + " ,Y " + _target.getyCoordinate());
        while (isGameRunning) {
            if (_mortar.getCount() > 0) {
                System.out.println("Would you like to use a mortar?");
                Scanner scanner = new Scanner(System.in);
                String input = scanner.nextLine();
                if (input.equals("yes")) {
                    _mortar.decrement(1);
                    isAHit = _shotFlowControl2.run(_hitOrMissMortar);
                } else {
                    isAHit = _shotFlowControl2.run(_hitOrMissShot);
                }
            } else {
            isAHit = _shotFlowControl2.run(_hitOrMissShot);}

            if (shotCounter == 4) {
                _mortar.increment(1);
            }
            System.out.println(isAHit);
            shotCounter++;
            if(isAHit) {
                System.out.println("You should have won");
               isGameRunning = false;
            } else {
                System.out.println("You missed, try again");
            }
        }
        System.out.println("You won the game with " + shotCounter + " shots.");
    }

}
