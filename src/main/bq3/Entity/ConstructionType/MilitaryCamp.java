package bq3.Entity.ConstructionType;
import bq3.Presenter.Map;
import bq3.Entity.Construction;
import bq3.Entity.Arm.Tank;
import bq3.Entity.Arm.Infantry;
import bq3.Entity.Arm.ArmoredVehicle;

public class MilitaryCamp extends Construction {


    public MilitaryCamp(Map map, int x, int y){
        super(map, x, y, "Military Camp", 50, 0.0, 0, 0, 0);
    }

    public Infantry produceInfantry(Map map, int x, int y){
        return new Infantry(map, x, y);

    }

    public ArmoredVehicle produceAMV(Map map, int x, int y){
        return new ArmoredVehicle(map, x, y);
    }

    public Tank produceTank(Map map, int x, int y){
        return new Tank(map, x, y);
    }

}
