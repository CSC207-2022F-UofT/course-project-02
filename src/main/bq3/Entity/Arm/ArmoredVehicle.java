package bq3.Entity.Arm;


import bq3.Entity.Armnew;
import bq3.Presenter.Map;

public class ArmoredVehicle extends Armnew {

    public ArmoredVehicle(Map map, int x, int y) {
        super(map, x, y, 20, 70, 4, 20, 50);
    }

    public String toString() {
        return "Armored Vechicle";
    }


}
