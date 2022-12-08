package main.Background;

import main.Entity.Gameobject;

import java.awt.*;


public class BackgroundEntry extends Gameobject {


    public BackgroundEntry() {
        super();
    }

    @Override
    public void paintSelf(Graphics g) {
        //Img for front page
        Image p1 = Toolkit.getDefaultToolkit().getImage("img/map1.png");
        //g.drawImage(p1,-200,0,(int) Constant.getWidths(),(int)Constant.getHeights(),null);
        g.drawImage(p1,-500,0,1920*7/5,942*7/5,null);
    }

    @Override
    public Rectangle getRec() {
        return null;
    }
}