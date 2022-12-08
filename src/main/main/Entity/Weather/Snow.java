package main.Entity.Weather;

import main.Entity.Armnew;

public class Snow extends Weather{
    public Snow() {
        super(2);
    }


    @Override
    public void effectOnMovement(Armnew arm) {
        arm.changeMovement(1);
    }
}
