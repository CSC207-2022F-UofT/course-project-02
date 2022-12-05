package bq3.Presenter;

import bq3.Background.BackgroundEntry;
import bq3.Entity.Constant;
import bq3.listener.LoginListener;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;


public class Login extends JFrame {

    //双缓存(保证图片文字不会闪烁）
    //Ensure not falsh screen
    private Image offscreenimage=null;
    private final BackgroundEntry bg = new BackgroundEntry();

    /**
     * 用来存储玩家选择的国家
     * To store the chosen country
     */
    public static HashMap<String, String> PLAY_COUNTRY_MAP = new HashMap<String, String>();

    public void login(){
        this.setUndecorated(true);
        this.setVisible(true);
        this.setSize((int) Constant.getWidths(),(int)Constant.getHeights());
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        new LoginListener().listener(this);
        new Login.PaintThead().start();
    }

    @Override
    public void paint(Graphics g){
        //界面上的东西都可以改动
        if(offscreenimage==null){
            offscreenimage=this.createImage(2500,1700);
        }
        Graphics gImage = offscreenimage.getGraphics();
        bg.paintSelf(gImage);
        gImage.setColor(Color.YELLOW);
        gImage.setFont(new Font(Constant.getTitle(),Font.BOLD,50));
        gImage.drawString("No Man's Land",0,120);
        if(Constant.getByx()==0){
            gImage.drawString("Start",0,270);
        }
        else {
            gImage.drawString("gaming",0,270);
        }
        gImage.drawString("Settings",0,420);
        gImage.drawString("Exit",0,520);
        g.drawImage(offscreenimage,0,0,null);
    }




    class PaintThead extends Thread{
        @Override
        public void run() {
            while (true){
                repaint();
                try {
                    Thread.sleep(25);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public static void main(String[] args) {
        new Login().login();
    }
}
