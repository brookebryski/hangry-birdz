package com.example.hangrybirdz;

public class GameFlowControl implements IGameFlowControl {

    private ITarget _target;
    private IShotFlowControl2 _shotFlowControl2;

    public GameFlowControl(ITarget target, IShotFlowControl2 shotFlowControl2) {
       this._target = target;
        this._shotFlowControl2 = shotFlowControl2;
    }


    public void run() {
    _target.Set();
    if (!_shotFlowControl2.run()) {
        _shotFlowControl2.run();
        }
    }

}
