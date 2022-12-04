package bq3;

import bq3.Background.BackgroundMap;
import bq3.Weather.Weather;
import bq3.Arm.*;
import bq3.cell.Celldetail;
import bq3.listener.MapListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Objects;
import java.util.Random;

public class Map extends JFrame {
    private Image offscreenimage=null;
    private final BackgroundMap bg = new BackgroundMap(this);
    public int txt;
    public int txt2;
    int jtmove = 0;
    public int isempty=0;
    public int icell=-1;
    public boolean swicth=false;



    public void map(){
        System.out.println(1);
        //加入当前地图
        Constant.setMap(this);
        //屏幕上分的标题栏不显示(加上后有小概率打不开游戏）
        //this.setUndecorated(true);
        //把窗口可视化
        this.setVisible(true);
        //设置全屏大小
        this.setSize((int)Constant.getWidths(),(int)Constant.getHeights());
        //居中放置（应该没什么用，毕竟全屏）
        this.setLocationRelativeTo(null);
        //不能改变屏幕大小
        this.setResizable(false);
        System.out.println(2);
        //关闭窗口使上级窗口可以重新开始游戏
        this.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                Constant.setByx(0);
            }
        });
        //鼠标触发事件
        new MapListener().listener(this);
        //启用下面的线程没25毫秒画一次
        new PaintThead().start();
    }
    @Override
    public void paint(Graphics g) {
        //双缓存防止图片文字闪烁
        if(offscreenimage==null){
            offscreenimage=this.createImage((int)Constant.getWidths(),(int)Constant.getHeights());
        }
        Graphics gImage = offscreenimage.getGraphics();
        super.paint(gImage);
        //背景图片
        bg.paintSelf(gImage);
        //设置文字格式
        gImage.setFont(new Font(Constant.getTitle(),Font.PLAIN,50));
        //保存的计数器（用于保存数据现有两行可以加但是比较繁琐后面可以进行修改）
        txt=getTxt(1);
        gImage.drawString("Total hits"+txt+"times",100,200);
        //双方国家
        gImage.drawString("Player1: "+Constant.getPlayer1().getNation().getNation(),100,70);
        gImage.drawString("Player2: "+Constant.getPlayer2().getNation().getNation(),1000,70);
        //关闭游戏回到Login
        gImage.drawLine(1400,0,1400,50);
        gImage.drawLine(1800,50,1400,50);
        //在右下角的切换player
        gImage.drawLine(1350,700,1350,1000);
        gImage.drawLine(1350,700,1800,700);
        if(swicth){
            gImage.drawString("Yes",1350,750);
        }
        else {
            gImage.drawString("End Turn",1350,750);
        }
        //测试用
        gImage.drawString("Player"+Constant.getPnum()+"'s round",700,70);
        gImage.drawString("Player1 cost: " + Constant.getPlayer1().getCost(),700,120);
        gImage.drawString("Player2 cost: " + Constant.getPlayer2().getCost(),700,170);
        gImage.drawString("Moves available for current player： "+Constant.getAllplayers()[Constant.getPnum()-1].getMove(),700,220);

        //画一个箭头表示可移动到的位置（有更好的可以替换，现在箭头位置好像有bug但不影响）
        gImage.setColor(Color.yellow);
        if(isempty==1){
            jtmove = 10;
            for (int i = 0; i < Constant.getPointnum(); i++) {
                if (Constant.getCell(icell).getLocationx()-Constant.getCell(i).getLocationx()==150&
                        Constant.getCell(icell).getLocationy()-Constant.getCell(i).getLocationy()==0) {
                    if (jtmove <= 70 & Constant.getCell(i).getArm() == null) {
                        int[] a = {Constant.getCell(icell).getLocationx() - jtmove,
                                Constant.getCell(icell).getLocationx() - 30 - jtmove,
                                Constant.getCell(icell).getLocationx() - 30 - jtmove,
                                Constant.getCell(icell).getLocationx() - 50 - jtmove,
                                Constant.getCell(icell).getLocationx() - 30 - jtmove,
                                Constant.getCell(icell).getLocationx() - 30 - jtmove,
                                Constant.getCell(icell).getLocationx() - jtmove};
                        int[] b = {Constant.getCell(icell).getLocationy() + 10, Constant.getCell(icell).getLocationy() + 10,
                                Constant.getCell(icell).getLocationy(), Constant.getCell(icell).getLocationy() + 15,
                                Constant.getCell(icell).getLocationy() + 30, Constant.getCell(icell).getLocationy() + 20,
                                Constant.getCell(icell).getLocationy() + 20};
                        gImage.fillPolygon(a, b, 7);
                    }
                    if (jtmove <= 70 & Constant.getCell(i).getArm() != null) {
                        if(Constant.getCell(i).getArm().belongPlayer!=Constant.getPnum()){
                            int[] a = {Constant.getCell(icell).getLocationx() - jtmove,
                                    Constant.getCell(icell).getLocationx() - 30 - jtmove,
                                    Constant.getCell(icell).getLocationx() - 30 - jtmove,
                                    Constant.getCell(icell).getLocationx() - 50 - jtmove,
                                    Constant.getCell(icell).getLocationx() - 30 - jtmove,
                                    Constant.getCell(icell).getLocationx() - 30 - jtmove,
                                    Constant.getCell(icell).getLocationx() - jtmove};
                            int[] b = {Constant.getCell(icell).getLocationy() + 10, Constant.getCell(icell).getLocationy() + 10,
                                    Constant.getCell(icell).getLocationy(), Constant.getCell(icell).getLocationy() + 15,
                                    Constant.getCell(icell).getLocationy() + 30, Constant.getCell(icell).getLocationy() + 20,
                                    Constant.getCell(icell).getLocationy() + 20};
                            gImage.fillPolygon(a, b, 7);
                        }
                    }
                }
                if (Constant.getCell(icell).getLocationx()-Constant.getCell(i).getLocationx()==-150&
                        Constant.getCell(icell).getLocationy()-Constant.getCell(i).getLocationy()==0) {
                    if(jtmove<=70& Constant.getCell(i).getArm()==null){
                        int[] a = {Constant.getCell(icell).getLocationx() + 30 + jtmove,
                                Constant.getCell(icell).getLocationx() + 60 + jtmove,
                                Constant.getCell(icell).getLocationx() + 60 + jtmove,
                                Constant.getCell(icell).getLocationx() + 80 + jtmove,
                                Constant.getCell(icell).getLocationx() + 60 + jtmove,
                                Constant.getCell(icell).getLocationx() + 60 + jtmove,
                                Constant.getCell(icell).getLocationx() + 30 + jtmove};
                        int[] b = {Constant.getCell(icell).getLocationy() + 10, Constant.getCell(icell).getLocationy() + 10,
                                Constant.getCell(icell).getLocationy(), Constant.getCell(icell).getLocationy() + 15,
                                Constant.getCell(icell).getLocationy() + 30, Constant.getCell(icell).getLocationy() + 20,
                                Constant.getCell(icell).getLocationy() + 20};
                        gImage.fillPolygon(a, b, 7);
                    }
                    if(jtmove<=70& Constant.getCell(i).getArm()!=null){
                        if(Constant.getCell(i).getArm().belongPlayer!=Constant.getPnum()){
                            int[] a = {Constant.getCell(icell).getLocationx() + 30 + jtmove,
                                    Constant.getCell(icell).getLocationx() + 60 + jtmove,
                                    Constant.getCell(icell).getLocationx() + 60 + jtmove,
                                    Constant.getCell(icell).getLocationx() + 80 + jtmove,
                                    Constant.getCell(icell).getLocationx() + 60 + jtmove,
                                    Constant.getCell(icell).getLocationx() + 60 + jtmove,
                                    Constant.getCell(icell).getLocationx() + 30 + jtmove};
                            int[] b = {Constant.getCell(icell).getLocationy() + 10, Constant.getCell(icell).getLocationy() + 10,
                                    Constant.getCell(icell).getLocationy(), Constant.getCell(icell).getLocationy() + 15,
                                    Constant.getCell(icell).getLocationy() + 30, Constant.getCell(icell).getLocationy() + 20,
                                    Constant.getCell(icell).getLocationy() + 20};
                            gImage.fillPolygon(a, b, 7);
                        }
                    }
                }
                if (Constant.getCell(icell).getLocationx()-Constant.getCell(i).getLocationx()==0&
                        Constant.getCell(icell).getLocationy()-Constant.getCell(i).getLocationy()==150){
                    if(jtmove<=70&Constant.getCell(i).getArm()==null) {
                        int[] a = {Constant.getCell(icell).getLocationy() - jtmove,
                                Constant.getCell(icell).getLocationy() - 30 - jtmove,
                                Constant.getCell(icell).getLocationy() - 30 - jtmove,
                                Constant.getCell(icell).getLocationy() - 50 - jtmove,
                                Constant.getCell(icell).getLocationy() - 30 - jtmove,
                                Constant.getCell(icell).getLocationy() - 30 - jtmove,
                                Constant.getCell(icell).getLocationy() - jtmove};
                        int[] b = {Constant.getCell(icell).getLocationx() + 10, Constant.getCell(icell).getLocationx() + 10,
                                Constant.getCell(icell).getLocationx(), Constant.getCell(icell).getLocationx() + 15,
                                Constant.getCell(icell).getLocationx() + 30, Constant.getCell(icell).getLocationx() + 20,
                                Constant.getCell(icell).getLocationx() + 20};
                        gImage.fillPolygon(b, a, 7);
                    }
                    if(jtmove<=70& Constant.getCell(i).getArm()!=null) {
                        if(Constant.getCell(i).getArm().belongPlayer!=Constant.getPnum()){
                            int[] a = {Constant.getCell(icell).getLocationy() - jtmove,
                                    Constant.getCell(icell).getLocationy() - 30 - jtmove,
                                    Constant.getCell(icell).getLocationy() - 30 - jtmove,
                                    Constant.getCell(icell).getLocationy() - 50 - jtmove,
                                    Constant.getCell(icell).getLocationy() - 30 - jtmove,
                                    Constant.getCell(icell).getLocationy() - 30 - jtmove,
                                    Constant.getCell(icell).getLocationy() - jtmove};
                            int[] b = {Constant.getCell(icell).getLocationx() + 10, Constant.getCell(icell).getLocationx() + 10,
                                    Constant.getCell(icell).getLocationx(), Constant.getCell(icell).getLocationx() + 15,
                                    Constant.getCell(icell).getLocationx() + 30, Constant.getCell(icell).getLocationx() + 20,
                                    Constant.getCell(icell).getLocationx() + 20};
                            gImage.fillPolygon(b, a, 7);
                        }
                    }
                }
                if (Constant.getCell(icell).getLocationx()-Constant.getCell(i).getLocationx()==0&
                        Constant.getCell(icell).getLocationy()-Constant.getCell(i).getLocationy()==-150){

                    if(jtmove<=70&Constant.getCell(i).getArm()==null) {
                        int[] a = {Constant.getCell(icell).getLocationy() + 30 + jtmove,
                                Constant.getCell(icell).getLocationy() + 60 + jtmove,
                                Constant.getCell(icell).getLocationy() + 60 + jtmove,
                                Constant.getCell(icell).getLocationy() + 80 + jtmove,
                                Constant.getCell(icell).getLocationy() + 60 + jtmove,
                                Constant.getCell(icell).getLocationy() + 60 + jtmove,
                                Constant.getCell(icell).getLocationy() + 30 + jtmove};
                        int[] b = {Constant.getCell(icell).getLocationx() + 10, Constant.getCell(icell).getLocationx() + 10,
                                Constant.getCell(icell).getLocationx(), Constant.getCell(icell).getLocationx() + 15,
                                Constant.getCell(icell).getLocationx() + 30, Constant.getCell(icell).getLocationx() + 20,
                                Constant.getCell(icell).getLocationx() + 20};
                        gImage.fillPolygon(b, a, 7);
                    }
                    if(jtmove<=70&Constant.getCell(i).getArm()!=null) {
                        if(Constant.getCell(i).getArm().belongPlayer!=Constant.getPnum()){
                            int[] a = {Constant.getCell(icell).getLocationy() + 30 + jtmove,
                                    Constant.getCell(icell).getLocationy() + 60 + jtmove,
                                    Constant.getCell(icell).getLocationy() + 60 + jtmove,
                                    Constant.getCell(icell).getLocationy() + 80 + jtmove,
                                    Constant.getCell(icell).getLocationy() + 60 + jtmove,
                                    Constant.getCell(icell).getLocationy() + 60 + jtmove,
                                    Constant.getCell(icell).getLocationy() + 30 + jtmove};
                            int[] b = {Constant.getCell(icell).getLocationx() + 10, Constant.getCell(icell).getLocationx() + 10,
                                    Constant.getCell(icell).getLocationx(), Constant.getCell(icell).getLocationx() + 15,
                                    Constant.getCell(icell).getLocationx() + 30, Constant.getCell(icell).getLocationx() + 20,
                                    Constant.getCell(icell).getLocationx() + 20};
                            gImage.fillPolygon(b, a, 7);
                        }
                    }
                }
                if(jtmove==120){
                    jtmove=0;
                }
            }
        }



        for (int i = 0; i < Constant.getPointnum(); i++) {
            //设置一下字体格式可能没用到
            gImage.setFont(new Font(Constant.getTitle(),Font.BOLD,50));
            //一个比较透明的颜色
            Color color= new Color(1.0F, 0.75F, 0.0F, 0.45F);
            gImage.setColor(color);
            //画出所有点（specialpoint可以改颜色）
            gImage.fillOval(Constant.getCell(i).getLocationx(), Constant.getCell(i).getLocationy(), 30, 30);
            //player1可生产兵的cell为红
            if(Constant.getCell(i).isP1CanProduce()){
                gImage.setColor(Color.red);
                gImage.drawOval(Constant.getCell(i).getLocationx(), Constant.getCell(i).getLocationy(), 30, 30);
                gImage.setColor(color);
            }
            //player2可生产兵的cell为蓝
            if(Constant.getCell(i).isP2CanProduce()){
                gImage.setColor(Color.blue);
                gImage.drawOval(Constant.getCell(i).getLocationx(), Constant.getCell(i).getLocationy(), 30, 30);
                gImage.setColor(color);
            }
            if(Constant.getCell(i).getArm()!=null){
                //在点上分加入血条（有点难看建议换个表达方式）
                gImage.setColor(Color.black);
                gImage.fillRect(Constant.getCell(i).getLocationx()-10,Constant.getCell(i).getLocationy()-15,
                        50,5);
                gImage.setColor(Color.red);
                gImage.fillRect(Constant.getCell(i).getLocationx()-10,Constant.getCell(i).getLocationy()-15,
                        50*Constant.getCell(i).getArm().getHp()/Constant.getCell(i).getArm().getHpTotal(),5);
                //在点上加入兵种图片
                Constant.getCell(i).getArm().paintSelf(gImage);
                gImage.setColor(color);
            }

            //map上添加关于天气的图片或文字(但是太小的话看不太清所以暂时不做放在这）
            gImage.setFont(new Font(null, 0, 10));
            gImage.setColor(Color.WHITE);
            if(Constant.getCell(i).getWeather().getId()==0){
                gImage.drawString("sunny",Constant.getCell(i).getLocationx(), Constant.getCell(i).getLocationy());
            }
            if(Constant.getCell(i).getWeather().getId()==1){
                gImage.drawString("rain",Constant.getCell(i).getLocationx(), Constant.getCell(i).getLocationy());
            }
            if(Constant.getCell(i).getWeather().getId()==2){
                gImage.drawString("snow",Constant.getCell(i).getLocationx(), Constant.getCell(i).getLocationy());
            }
            if(Constant.getCell(i).getTerrain().equals("Plain")){
                gImage.drawString("plain",Constant.getCell(i).getLocationx(), Constant.getCell(i).getLocationy()-10);
            }
            if(Constant.getCell(i).getTerrain().equals("Mountain")){
                gImage.drawString("mountain",Constant.getCell(i).getLocationx(), Constant.getCell(i).getLocationy()-10);
            }
            if(Constant.getCell(i).getTerrain().equals("River")){
                gImage.drawString("river",Constant.getCell(i).getLocationx(), Constant.getCell(i).getLocationy()-10);
            }
            if(Constant.getCell(i).getTerrain().equals("Swamp")){
                gImage.drawString("swamp",Constant.getCell(i).getLocationx(), Constant.getCell(i).getLocationy()-10);
            }
            if(Constant.getCell(i).getTerrain().equals("Desert")){
                gImage.drawString("desert",Constant.getCell(i).getLocationx(), Constant.getCell(i).getLocationy()-10);
            }
        }
        //把所有东西加在原有画布上，双缓存的一部分
        g.drawImage(offscreenimage,0,0,null);
    }
    //每25ms刷新一次
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


    //后面是调用txt里的数据和改txt里的数据（这里都可以改csv）
    File f = new File("jl.txt");

    public int getTxt(int num){
        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader(f));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        int i = 0;
        try {
            for (int j = 0; j < num; j++) {
                i = Integer.parseInt(in.readLine());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            in.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return i;
    }


    public void setTxt(String str){
        FileWriter fw = null;
        try {
            fw = new FileWriter(f);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            fw.write(str);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}