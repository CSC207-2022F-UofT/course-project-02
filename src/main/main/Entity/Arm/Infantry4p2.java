package main.Entity.Arm;

import main.Presenter.Map;

public class Infantry4p2 extends Infantry {
    public Infantry4p2(Map map, int x, int y) {
        super(map, x, y);
        setImg("./img/infantry-1.png");
        setBelongPlayer(2);
    }
}
