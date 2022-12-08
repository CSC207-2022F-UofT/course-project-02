package main.Entity.ConstructionType;
import main.Presenter.Map;

public class Battery4p2 extends Battery{
    public Battery4p2(Map map, int x, int y){
        super(map, x, y);
        setImg("./img/Battery.jpeg");
        setBelongPlayer(2);
    }
}
