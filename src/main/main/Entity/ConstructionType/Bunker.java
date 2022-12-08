package main.Entity.ConstructionType;

import main.Entity.Construction;
import main.Presenter.Map;

public class Bunker extends Construction {

    public Bunker(Map map, int x, int y){
        super(map, x, y, "Bunker", 30, 40.0, 8, 25, 0.1);
    }
}
