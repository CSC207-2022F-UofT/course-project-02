package bq3;

import bq3.Background.BackgroundEntry;
import bq3.nation.Germany;
import bq3.nation.Japan;
import bq3.nation.UK;
import bq3.nation.US;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Objects;


public class Login extends JFrame {

    //双缓存(保证图片文字不会闪烁）
    private Image offscreenimage=null;
    private final BackgroundEntry bg = new BackgroundEntry();


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
                        String[] nation ={ "Germany", "United Kindom", "United States","Imperial Japan" };
                        String s1 = (String) JOptionPane.showInputDialog(null,"choose nation:\n",
                                "Player1", JOptionPane.PLAIN_MESSAGE, null, nation, 4);
                        if(Objects.equals(s1, "Germany")){
                            Constant.getPlayer1().setNation(new Germany());
                        }
                        if(Objects.equals(s1, "United Kindom")){
                            Constant.getPlayer1().setNation(new UK());
                        }
                        if(Objects.equals(s1, "United States")){
                            Constant.getPlayer1().setNation(new US());
                        }
                        if(Objects.equals(s1, "Imperial Japan")){
                            Constant.getPlayer1().setNation(new Japan());
                        }
                        boolean fail = true;
                        for (int i = 0; i < 4; i++) {
                            if(Objects.equals(s1, nation[i])){
                                nation[i] = nation[i]+" is selected by Player1";
                                String s2 = (String) JOptionPane.showInputDialog(null,"choose nation:\n",
                                        "Player2", JOptionPane.PLAIN_MESSAGE, null, nation, 4);


                                if(Objects.equals(s2, "Germany")){
                                    Constant.getPlayer2().setNation(new Germany());
                                }
                                if(Objects.equals(s2, "United Kindom")){
                                    Constant.getPlayer2().setNation(new UK());
                                }
                                if(Objects.equals(s2, "United States")){
                                    Constant.getPlayer2().setNation(new US());
                                }
                                if(Objects.equals(s2, "Imperial Japan")){
                                    Constant.getPlayer2().setNation(new Japan());
                                }

                                for (int j = 0; j < 4; j++) {
                                    if(Objects.equals(s2, nation[j])&j!=i){
                                        fail = false;
                                        Constant.setByx(1);
                                        //把cell全加在地图上，可以做多个地图，所有cell在constant里面改
                                        Constant.addallcells();
                                        //生成初始可以生成兵种的位置
                                        Constant.setCanProduce();
                                        new Map().map();
                                    }
                                }
                            }
                        }
                        if(fail){
                            JOptionPane.showMessageDialog(null, "Please reselect!", "!!",JOptionPane.PLAIN_MESSAGE);
                        }
                    }
                    else {
                        JOptionPane.showMessageDialog(null,"Can't open repeatly");
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
                        JOptionPane.showMessageDialog(null,"Can't open repeatly");
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
        gImage.drawString("Wargame",0,120);
        if(Constant.getByx()==0){
            gImage.drawString("Start",0,270);
        }
        else {
            gImage.drawString("Game already in progress",0,270);
        }
        gImage.drawString("Option",0,420);
        gImage.drawString("Quit",0,520);
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
