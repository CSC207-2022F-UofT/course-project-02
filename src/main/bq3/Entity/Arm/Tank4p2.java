package bq3.Entity.Arm;

import bq3.Presenter.Map;

public class Tank4p2 extends Tank {
    public Tank4p2(Map map, int x, int y) {
        super(map, x, y);
        setImg("./img/tank4p2.png");
        setBelongPlayer(2);
    }
}
