package bq3.Arm;

import bq3.Armnew;
import bq3.Map;

public class TigerTank extends Armnew {
    public TigerTank(Map map, int x, int y) {
        super(map, x, y, 30, 120, 1, 45, 60);
    }
    @Override
    public String toString() {
        return "Tiger Tank";
    }
}
