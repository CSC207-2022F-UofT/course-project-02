package main.Entity.ConstructionType;
import main.Presenter.Map;

public class Airport4p1 extends Airport{
    public Airport4p1(Map map, int x, int y){
        super(map, x, y);
        setImg("./img/Airport.png");
        setBelongPlayer(1);
    }
}
