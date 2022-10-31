package bq3.Weather;

import bq3.Arm.Tank;
import bq3.Armnew;

public class Rain extends Weather{

    public Rain() {
        super(1);
    }

    @Override
    public void effectOnMovement(Armnew arm) {
        arm.changeMovement(1);
    }
}
