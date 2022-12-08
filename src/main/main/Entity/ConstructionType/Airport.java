package main.Entity.ConstructionType;

import main.Entity.Construction;
import main.Presenter.Map;
import main.Entity.Arm.Fighters;
import main.Entity.Arm.Bombers;

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
