package main.Entity.Arm;

import main.Entity.Armnew;
import main.Presenter.Map;

public class Infantry extends Armnew {
    public Infantry(Map map, int x, int y) {
        super(map, x, y, 10, 50, 1, 10, 30);
    }

    public String toString() {
        return "Infantry";
    }
}
