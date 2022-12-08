package main.Entity.ConstructionType;

import main.Entity.Construction;
import main.Presenter.Map;

public class Battery extends Construction {

    public Battery(Map map, int x, int y){
        super(map, x, y, "Battery", 40, 60.0, 25, 25, 0.15);
    }
}
