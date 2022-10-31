package bq3.Arm;


import bq3.Armnew;
import bq3.Map;

public class ArmoredVehicle extends Armnew {

    public ArmoredVehicle(Map map, int x, int y) {
        super(map, x, y, 20, 70, 4, 20, 50);
    }

    public String toString() {
        return "Armored Vechicle";
    }


}
