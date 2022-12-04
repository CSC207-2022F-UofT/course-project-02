package bq3.Entity.ConstructionType;

import bq3.Presenter.Map;

public class MilitaryCamp4p1 extends MilitaryCamp{
    public MilitaryCamp4p1(Map map, int x, int y){
        super(map, x, y);
        setImg("./img/Military-camp.png");
        setBelongPlayer(1);
    }
}
