package bq3.Entity.Arm;

import bq3.Presenter.Map;

public class TigerTank4p1 extends TigerTank{
    public TigerTank4p1(Map map, int x, int y) {
        super(map, x, y);
        setImg("./img/tank-1.png");
        setBelongPlayer(1);
    }
}
