package bq3;

import bq3.Background.BackgroundEntry;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;


public class Login extends JFrame {

    //双缓存(保证图片文字不会闪烁）
    private Image offscreenimage=null;
    private final BackgroundEntry bg = new BackgroundEntry();

    /**
     * 用来存储玩家选择的国家
     */
    public static HashMap<String, String> PLAY_COUNTRY_MAP = new HashMap<String, String>();

    public void login(){
        this.setUndecorated(true);
        this.setVisible(true);
        this.setSize((int)Constant.getWidths(),(int)Constant.getHeights());
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //点击开始游戏
                //打开上次游戏（还没做，等全做好了再加）
                if(e.getButton()==1&
                        e.getX()<=200&
                        e.getY()>=220&
                        e.getY()<=270){
                    if(Constant.getByx()==0){
                        new LoginFrame();
                    }
                    else {
                        JOptionPane.showMessageDialog(null,"不能重复打开");
                    }
                }
                //设置（还没写）
                if (e.getX()<=200&
                        e.getY()>=370&
                        e.getY()<=420){
                    if(Constant.getByx()==0){
                        Constant.setByx(1);
                        //repaint();
                        new Map().map();
                    }
                    else {
                        JOptionPane.showMessageDialog(null,"不能重复打开");
                    }
                }
                //退出游戏
                if (e.getX()<=100&
                        e.getY()>=450&
                        e.getY()<=520&
                        Constant.isMultyxz()) {
                    System.exit(0);
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                Constant.setMultyxz(true);
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
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
        gImage.drawString("兵棋",0,120);
        if(Constant.getByx()==0){
            gImage.drawString("开始游戏",0,270);
        }
        else {
            gImage.drawString("游戏进行中",0,270);
        }
        gImage.drawString("设置",0,420);
        gImage.drawString("退出",0,520);
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
