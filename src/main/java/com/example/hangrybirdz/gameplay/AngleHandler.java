package com.example.hangrybirdz.gameplay;

import com.example.hangrybirdz.gameplay.interfaces.IAngleGetter;
import com.example.hangrybirdz.gameplay.interfaces.IAngleHandler;
import com.example.hangrybirdz.gameplay.interfaces.IAngleIntegerValidator;
import com.example.hangrybirdz.gameplay.interfaces.IAngleRangeValidator;

public class AngleHandler implements IAngleHandler {

    private IAngleGetter _angleGetter;
    private IAngleIntegerValidator _angleIntegerValidator;
    private IAngleRangeValidator _angleRangeValidator;
    private int _angle;


    public AngleHandler(IAngleGetter angleGetter,
                        IAngleIntegerValidator angleIntegerValidator,
                        IAngleRangeValidator angleRangeValidator) {
        this._angleGetter = angleGetter;
        this._angleIntegerValidator = angleIntegerValidator;
        this._angleRangeValidator = angleRangeValidator;
    }

    @Override
    public int getAngle() {
        String input = _angleGetter.getInput();
        while (!isValid(input)) {
            System.out.println("Please make sure to enter a valid number, i.e. an integer between 1 and 90");
            input = _angleGetter.getInput();
        }
        return _angle;
    }

    private boolean isValid(String input) {
        if (_angleIntegerValidator.IsInteger(input)) {
            _angle = Integer.parseInt(input);
            if (_angleRangeValidator.isInRange(_angle)) {
                return true;
            } return false;
        } return false;
    }
}
