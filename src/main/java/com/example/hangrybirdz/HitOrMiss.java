package com.example.hangrybirdz;

public class HitOrMiss implements IHitOrMiss{
    @Override
    public boolean IsAHit(String target, int xLandingPos, int yLandingPos) {
        String[] targetCoordinates = target.split(",");
        int targetXCoordinate = Integer.parseInt(targetCoordinates[0]);
        int targetYCoordinate = Integer.parseInt(targetCoordinates[1]);

        return (targetXCoordinate == xLandingPos &&
                targetYCoordinate == yLandingPos);
    }
}
