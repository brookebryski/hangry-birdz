package com.example.hangrybirdz;

public class ShotFlowControl implements IShotFlowControl {

    private IAngleGetter _angleGetter;
    private IAngleIntegerValidator _angleIntegerValidator;
    private IAngleRangeValidator _angleRangeValidator;
    private IVelocityGetter _velocityGetter;
    private IVelocityIntegerValidator _velocityIntegerValidator;
    private IVelocityRangeValidator _velocityRangeValidator;
    private IAngleConverter _angleConverter;
    private IXLandingPosition _xLandingPosition;
    private IYLandingPosition _yLandingPosition;
    private IHitOrMiss _hitOrMiss;
    private String _targetCoordinates;

    public ShotFlowControl(IAngleGetter _angleGetter, IAngleIntegerValidator _angleIntegerValidator, IAngleRangeValidator angleRangeValidator,
                           IVelocityGetter velocityGetter, IVelocityIntegerValidator velocityIntegerValidator, IVelocityRangeValidator velocityRangeValidator,
                           IAngleConverter angleConverter, IXLandingPosition xLandingPosition, IYLandingPosition yLandingPosition, IHitOrMiss hitOrMiss, String targetCoordinates) {
        this._angleGetter = _angleGetter;
        this._angleIntegerValidator = _angleIntegerValidator;
        this._angleRangeValidator = angleRangeValidator;
        this._velocityGetter = velocityGetter;
        this._velocityIntegerValidator = velocityIntegerValidator;
        this._velocityRangeValidator = velocityRangeValidator;
        this._angleConverter = angleConverter;
        this._xLandingPosition = xLandingPosition;
        this._yLandingPosition = yLandingPosition;
        this._hitOrMiss = hitOrMiss;
        this._targetCoordinates = targetCoordinates;
    }




    public boolean run(){
        String angle = _angleGetter.getInput();
        _angleIntegerValidator.IsInteger(angle);
        int aInput = Integer.parseInt(angle);
        _angleRangeValidator.isInRange(aInput);
        String velocity = _velocityGetter.getInput();
        _velocityIntegerValidator.isInteger(velocity);
        int vInput = Integer.parseInt(velocity);
        _velocityRangeValidator.isInRange(vInput);
        double rInput = _angleConverter.Convert(aInput);
        _xLandingPosition.Find(rInput,vInput);
        _yLandingPosition.Find(rInput,vInput);
//        _hitOrMiss.IsAHit(_targetCoordinates, aInput, vInput);
        return false;
    }
}
