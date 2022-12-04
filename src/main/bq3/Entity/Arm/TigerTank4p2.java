package bq3.Entity.Arm;

import bq3.Presenter.Map;

public class TigerTank4p2 extends TigerTank{
    public TigerTank4p2(Map map, int x, int y) {
        super(map, x, y);
        setImg("./img/tigertank4p2.png");
        setBelongPlayer(2);
    }
}
