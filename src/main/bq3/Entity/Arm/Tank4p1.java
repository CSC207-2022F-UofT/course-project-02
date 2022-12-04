package bq3.Entity.Arm;

import bq3.Presenter.Map;

public class Tank4p1 extends Tank {
    public Tank4p1(Map map, int x, int y) {
        super(map, x, y);
        setImg("./img/tank4p1.png");
        setBelongPlayer(1);
    }
}
