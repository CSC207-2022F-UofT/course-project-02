package bq3.Background;

import bq3.Gameobject;
import bq3.Map;

import java.awt.*;

public class BackgroundMap extends Gameobject {


    public BackgroundMap(Map map) {
        super(map);
    }

    @Override
    public void paintSelf(Graphics g) {
        Image p1 = Toolkit.getDefaultToolkit().getImage("img/map1.png");
        //g.drawImage(p1,-200,0,(int) Constant.getWidths(),(int)Constant.getHeights(),null);
        g.drawImage(p1,-500,0,1920*7/5,942*7/5,null);
    }

    @Override
    public Rectangle getRec() {
        return null;
    }
}
