package bq3.ConstructionType;
import bq3.Map;

public class MilitaryCamp4p2 extends MilitaryCamp{

    public MilitaryCamp4p2(Map map, int x, int y){
        super(map, x, y);
        setImg("./img/Military-camp.png");
        setBelongPlayer(2);
    }
}