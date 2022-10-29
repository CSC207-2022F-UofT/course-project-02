package bq3.Arm;

import bq3.Armnew;
import bq3.Map;

public class Tank extends Armnew {
    public Tank(Map map, int x, int y) {
        super(map, x, y, 30, 100, 1, 40, 60);
    }
    @Override
    public String toString() {
        return "Tank";
    }
}
