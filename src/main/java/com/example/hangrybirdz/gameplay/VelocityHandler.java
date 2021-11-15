package com.example.hangrybirdz.gameplay;

import com.example.hangrybirdz.gameplay.interfaces.IVelocityGetter;
import com.example.hangrybirdz.gameplay.interfaces.IVelocityHandler;
import com.example.hangrybirdz.gameplay.interfaces.IVelocityIntegerValidator;
import com.example.hangrybirdz.gameplay.interfaces.IVelocityRangeValidator;

public class VelocityHandler implements IVelocityHandler {

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
            System.out.println("Please make sure to enter a valid number, i.e. an integer between 1 and 20");
            input = _velocityGetter.getInput();
        }
        return _velocity;
    }

    private boolean isValid(String input) {
        if (_velocityIntegerValidator.isInteger(input)) {
            _velocity = Integer.parseInt(input);
            if (_velocityRangeValidator.isInRange(_velocity)) {
                return true;
            } return false;
        } return false;
    }
}
