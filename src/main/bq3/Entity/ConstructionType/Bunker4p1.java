package bq3.Entity.ConstructionType;

import bq3.Presenter.Map;

public class Bunker4p1 extends Bunker {
    public Bunker4p1(Map map, int x, int y){
        super(map, x, y);
        setImg("./img/Bunker.png");
        setBelongPlayer(1);
    }
}