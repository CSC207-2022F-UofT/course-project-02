package bq3.Arm;

import bq3.Armnew;
import bq3.Map;

public class Infantry extends Armnew {
    public Infantry(Map map, int x, int y) {
        super(map, x, y, 10, 50, 1, 10, 30);
    }

    public String toString() {
        return "Infantry";
    }


}
