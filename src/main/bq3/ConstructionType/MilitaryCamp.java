package bq3.ConstructionType;
import bq3.Map;
import bq3.Construction;
import bq3.Arm.Tank;
import bq3.Arm.Infantry;
import bq3.Arm.ArmoredVehicle;

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
