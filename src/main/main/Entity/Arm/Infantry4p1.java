package main.Entity.Arm;

import main.Presenter.Map;

public class Infantry4p1 extends Infantry {

    public Infantry4p1(Map map, int x, int y) {
        super(map, x, y);
        setImg("./img/infantry-1.png");
        setBelongPlayer(1);
    }


}
