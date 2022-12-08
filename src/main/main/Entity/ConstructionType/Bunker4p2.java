package main.Entity.ConstructionType;
import main.Presenter.Map;

public class Bunker4p2 extends Bunker{
    public Bunker4p2(Map map, int x, int y){
        super(map, x, y);
        setImg("./img/Bunker.png");
        setBelongPlayer(2);
    }
}
