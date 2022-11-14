package bq3.ConstructionType;

import bq3.Construction;
import bq3.Map;
import bq3.Arm.Fighters;
import bq3.Arm.Bombers;

public class Airport extends Construction {

    public Airport(Map map, int x, int y){
        super(map, x, y, "Airport", 30, 0.0, 0, 0, 0.0);
    }

    public Fighters produceFighters(Map map, int x, int y){
        return new Fighters(map, x, y);
    }

    public Bombers produceBombers(Map map, int x, int y){
        return new Bombers(map, x, y);
    }
}
