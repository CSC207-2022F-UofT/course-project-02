package main.Background;

import main.Entity.Constant;

import java.awt.*;

public class Armpic {
    public void paintbg(Graphics g){
        // Img for Army
        Image p1 = Toolkit.getDefaultToolkit().getImage("img/5.png");
        g.drawImage(p1,Constant.getCell(Constant.getI()).getLocationx()+5, Constant.getCell(Constant.getI()).getLocationy()-30,20,20,null);

    }
}
