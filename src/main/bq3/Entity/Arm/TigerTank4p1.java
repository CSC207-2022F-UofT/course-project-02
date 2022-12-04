package bq3.Entity.Arm;

import bq3.Presenter.Map;

public class TigerTank4p1 extends TigerTank{
    public TigerTank4p1(Map map, int x, int y) {
        super(map, x, y);
        setImg("./img/tigertank4p1.png");
        setBelongPlayer(1);
    }
}
