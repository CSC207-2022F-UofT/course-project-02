package main.Entity.Arm;


import main.Entity.Armnew;
import main.Presenter.Map;

public class ArmoredVehicle extends Armnew {

    public ArmoredVehicle(Map map, int x, int y) {
        super(map, x, y, 20, 70, 4, 20, 50);
    }

    public String toString() {
        return "Armored Vechicle";
    }


}
