package bq3.Weather;

import bq3.Armnew;

public class Sunny extends Weather{
    public Sunny() {
        super(0);
    }


    @Override
    public void effectOnMovement(Armnew arm) {
        arm.changeMovement(-1);
    }
}
