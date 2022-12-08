package main.Entity.Arm;

import main.Presenter.Map;

public class Tank4p1 extends Tank {
    public Tank4p1(Map map, int x, int y) {
        super(map, x, y);
        setImg("./img/tank-1.png");
        setBelongPlayer(1);
    }
}
