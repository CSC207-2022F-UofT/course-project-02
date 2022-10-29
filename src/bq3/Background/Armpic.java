package bq3.Background;

import bq3.Constant;

import java.awt.*;

public class Armpic {
    public void paintbg(Graphics g){
        //兵种图片
        Image p1 = Toolkit.getDefaultToolkit().getImage("img/5.png");
        g.drawImage(p1,Constant.getCell(Constant.getI()).getLocationx()+5, Constant.getCell(Constant.getI()).getLocationy()-30,20,20,null);

    }
}
