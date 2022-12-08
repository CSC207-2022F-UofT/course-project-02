package main.Entity.Arm;

import main.Presenter.Map;

public class Tank4p2 extends Tank {
    public Tank4p2(Map map, int x, int y) {
        super(map, x, y);
        setImg("./img/tank-1.png");
        setBelongPlayer(2);
    }
}
