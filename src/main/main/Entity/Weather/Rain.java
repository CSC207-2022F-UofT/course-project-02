package main.Entity.Weather;

import main.Entity.Armnew;

public class Rain extends Weather{

    public Rain() {
        super(1);
    }

    @Override
    public void effectOnMovement(Armnew arm) {
        arm.changeMovement(1);
    }
}
