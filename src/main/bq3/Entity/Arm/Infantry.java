package bq3.Entity.Arm;

import bq3.Entity.Armnew;
import bq3.Presenter.Map;

public class Infantry extends Armnew {
    public Infantry(Map map, int x, int y) {
        super(map, x, y, 10, 50, 1, 10, 30);
    }

    public String toString() {
        return "Infantry";
    }
}
