package bq3.Weather;

import bq3.Armnew;

public class Snow extends Weather{
    public Snow() {
        super(2);
    }


    @Override
    public void effectOnMovement(Armnew arm) {
        arm.changeMovement(1);
    }
}
