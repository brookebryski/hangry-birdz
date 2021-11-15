package com.example.hangrybirdz.gameplay;

import com.example.hangrybirdz.gameplay.interfaces.IAngleConverter;
import com.example.hangrybirdz.gameplay.interfaces.ILandingPosition;
import com.example.hangrybirdz.gameplay.interfaces.IXLandingPosition;
import com.example.hangrybirdz.gameplay.interfaces.IYLandingPosition;

public class LandingPosition implements ILandingPosition {

    private IAngleConverter angleConverter;
    private IXLandingPosition xLandingPositionCalc;
    private IYLandingPosition yLandingPositionCalc;
    private int xCoordinate;
    private int yCoordinate;

    public int getxCoordinate() {
        return xCoordinate;
    }

    public int getyCoordinate() {
        return yCoordinate;
    }

    public LandingPosition(IAngleConverter angleConverter, IXLandingPosition xLandingPositionCalc, IYLandingPosition yLandingPositionCalc ) {
        this.angleConverter = angleConverter;
        this.xLandingPositionCalc = xLandingPositionCalc;
        this.yLandingPositionCalc = yLandingPositionCalc;
        this.xCoordinate = 0;
        this.yCoordinate = 0;
    }

    @Override
    public void set(int angle, int velocity) {
        double angleInRadians = angleConverter.Convert(angle);
        xCoordinate = xLandingPositionCalc.Find(angleInRadians, velocity);
        yCoordinate = yLandingPositionCalc.Find(angleInRadians,velocity);
    }
}
