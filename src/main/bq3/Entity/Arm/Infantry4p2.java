package bq3.Entity.Arm;

import bq3.Presenter.Map;

public class Infantry4p2 extends Infantry {
    public Infantry4p2(Map map, int x, int y) {
        super(map, x, y);
        setImg("./img/infantry4p2.png");
        setBelongPlayer(2);
    }
}
