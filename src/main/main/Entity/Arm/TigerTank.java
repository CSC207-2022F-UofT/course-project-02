package main.Entity.Arm;

import main.Entity.Armnew;
import main.Presenter.Map;

public class TigerTank extends Armnew {
    public TigerTank(Map map, int x, int y) {
        super(map, x, y, 30, 120, 1, 45, 60);
    }
    @Override
    public String toString() {
        return "Tiger Tank";
    }
}
