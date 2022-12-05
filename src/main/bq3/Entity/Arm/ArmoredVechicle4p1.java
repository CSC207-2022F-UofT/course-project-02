package bq3.Entity.Arm;

import bq3.Presenter.Map;

public class ArmoredVechicle4p1 extends ArmoredVehicle {
    public ArmoredVechicle4p1(Map map, int x, int y) {
        super(map, x, y);
        setImg("./img/armored-vh.png");
        setBelongPlayer(1);
    }
}
