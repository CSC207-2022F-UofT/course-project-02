package main.Entity.Arm;

import main.Presenter.Map;

public class TigerTank4p1 extends TigerTank{
    public TigerTank4p1(Map map, int x, int y) {
        super(map, x, y);
        setImg("./img/tank-1.png");
        setBelongPlayer(1);
    }
}
