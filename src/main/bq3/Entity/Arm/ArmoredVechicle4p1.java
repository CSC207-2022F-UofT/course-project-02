package bq3.Entity.Arm;

import bq3.Presenter.Map;

public class ArmoredVechicle4p1 extends ArmoredVehicle {
    public ArmoredVechicle4p1(Map map, int x, int y) {
        super(map, x, y);
        setImg("./img/av4p1.png");
        setBelongPlayer(1);
    }
}
