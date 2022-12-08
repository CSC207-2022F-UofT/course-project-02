package main.Entity.Arm;

import main.Entity.Armnew;
import main.Presenter.Map;

public class Tank extends Armnew {
    public Tank(Map map, int x, int y) {
        super(map, x, y, 30, 100, 1, 40, 60);
    }
    @Override
    public String toString() {
        return "Tank";
    }
}
