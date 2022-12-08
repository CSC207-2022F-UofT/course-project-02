package main.Entity.cell;

import main.Entity.Constant;

import javax.swing.*;
import java.awt.*;

public class Celldetail extends JFrame {
    private Image offscreenimage=null;

    public void detail() {
        this.setVisible(true);
        this.setSize(500,400);
        this.setLocationRelativeTo(null);
    }

    @Override
    public void paint(Graphics g) {
        if (offscreenimage == null) {
            offscreenimage = this.createImage((int) Constant.getWidths(), (int) Constant.getHeights());
        }
        Graphics gImage = offscreenimage.getGraphics();
        String a = Constant.getNowcell().getWeather().getWeather();
        gImage.setFont(new Font(Constant.getTitle(),Font.BOLD,50));
        gImage.drawString("Current Weather： "+a,0,100);
        gImage.drawString("Current Terrain： "+Constant.getNowcell().getTerrain(),0,200);
        gImage.drawString("ID"+Constant.getNowcell().getId(),0,300);

        g.drawImage(offscreenimage,0,0,null);
    }
}
