package main.Entity.Weather;

import main.Entity.Armnew;

public class Sunny extends Weather{
    public Sunny() {
        super(0);
    }


    @Override
    public void effectOnMovement(Armnew arm) {
        arm.changeMovement(-1);
    }
}
