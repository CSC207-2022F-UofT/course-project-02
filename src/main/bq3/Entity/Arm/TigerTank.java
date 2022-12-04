package bq3.Entity.Arm;

import bq3.Entity.Armnew;
import bq3.Presenter.Map;

public class TigerTank extends Armnew {
    public TigerTank(Map map, int x, int y) {
        super(map, x, y, 30, 120, 1, 45, 60);
    }
    @Override
    public String toString() {
        return "Tiger Tank";
    }
}
