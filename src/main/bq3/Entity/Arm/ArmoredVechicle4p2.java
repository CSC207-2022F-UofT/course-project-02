package bq3.Entity.Arm;

import bq3.Presenter.Map;

public class ArmoredVechicle4p2 extends ArmoredVehicle {
    public ArmoredVechicle4p2(Map map, int x, int y) {
        super(map, x, y);
        setImg("./img/av4p2.png");
        setBelongPlayer(2);
    }
}
