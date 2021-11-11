package com.example.hangrybirdz;

public class GameFlowControl implements IGameFlowControl {

    private ITarget _target;
    private IShotFlowControl2 _shotFlowControl2;
    private IMortar _mortar;
    private int shotCounter = 1;

    public GameFlowControl(ITarget target, IShotFlowControl2 shotFlowControl2, IMortar mortar) {
       this._target = target;
       this._shotFlowControl2 = shotFlowControl2;
       this._mortar = mortar;

    }

    public void run() {
    _target.Set();
    System.out.println("The target is at X " + _target.getxCoordinate() + " ,Y " + _target.getyCoordinate());
    while(!_shotFlowControl2.run()) {
        System.out.println("You missed, try again");
        if(shotCounter == 4){
            _mortar.increment(1);
        }
        shotCounter++;
        }
    System.out.println("You won the game with " + shotCounter + " shots.");
    }

}
