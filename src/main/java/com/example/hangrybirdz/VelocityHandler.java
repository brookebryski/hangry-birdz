package com.example.hangrybirdz;

public class VelocityHandler implements IVelocityHandler{

    private IVelocityGetter _velocityGetter;
    private IVelocityIntegerValidator _velocityIntegerValidator;
    private IVelocityRangeValidator _velocityRangeValidator;
    private int _velocity;


    public VelocityHandler(IVelocityGetter angleGetter,
                           IVelocityIntegerValidator angleIntegerValidator,
                           IVelocityRangeValidator angleRangeValidator) {
        this._velocityGetter = angleGetter;
        this._velocityIntegerValidator = angleIntegerValidator;
        this._velocityRangeValidator = angleRangeValidator;
    }

    @Override
    public int getVelocity() {
        String input = _velocityGetter.getInput();
        while (!isValid(input)) {
            System.out.println("Please make sure to enter a valid number, i.e. an integer between 1 and 90");
            input = _velocityGetter.getInput();
        }
        return _velocity;
    }

    private boolean isValid(String input) {
        if (_velocityIntegerValidator.isInteger(input)) {
            _velocity = Integer.parseInt(input);
            if (_velocityRangeValidator.isInRange(_velocity)) {
                System.out.println("range validator is true");
                return true;
            } return false;
        } return false;
    }
}
