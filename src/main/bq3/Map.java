package bq3;

import bq3.Background.BackgroundMap;
import bq3.Weather.Weather;
import bq3.Arm.*;
import bq3.cell.Celldetail;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Objects;
import java.util.Random;

public class Map extends JFrame {
    private Image offscreenimage=null;
    private final BackgroundMap bg = new BackgroundMap(this);
    private int txt;
    private int txt2;
    int jtmove = 0;
    private int isempty=0;
    private int icell=-1;
    private String s;
    private boolean swicth=false;
    private Random random = new Random();


    public void map(){

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
        //关闭窗口使上级窗口可以重新开始游戏
        this.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                Constant.setByx(0);
            }
        });
        //鼠标触发事件
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //左键生成兵种以及在已经有兵的cell移动兵种（进攻模块还没做）
                if(e.getButton()==1){
                    //这几行是测试保存数据功能后面用csv代替
                    txt=getTxt(1);
                    txt2=getTxt(2);
                    setTxt(String.valueOf(txt+1)+"\n"+String.valueOf(txt2));
                    //设置鼠标位置方便后面调用（如果后面调用删了这里就改掉）
                    Constant.setMouse_X(e.getX());
                    Constant.setMouse_Y(e.getY());
                    //离开游戏返回主菜单
                    if(e.getX()>1400&e.getY()<50){
                        Constant.setByx(0);
                        ((JFrame) e.getSource()).dispose();
                    }
                    //切换player的按键
                    if(e.getX()>1350&e.getY()>700){
                        if(!swicth){
                            swicth = true;
                            isempty = 0;
                        }
                        else {
                            //player1结束换player2，player2结束换player1
                            //重置玩家的可移动次数
                            //重置军队的可移动次数
                            if(Constant.getPnum()==1){
                                Constant.setPnum(2);
                                Constant.getPlayer2().setMove(2);
                                for (int i = 0; i < Constant.getPlayer1().getArmlist().length; i++) {
                                    Constant.getPlayer1().getArm(i).setMovement(Constant.getPlayer1().getArm(i).getMovementTotal());
                                }
                            }
                            else if(Constant.getPnum()==2){
                                Constant.setPnum(1);
                                Constant.getPlayer1().changeCost(50);
                                Constant.getPlayer2().changeCost(50);
                                Constant.getPlayer1().setMove(2);
                                for (int i = 0; i < Constant.getPlayer2().getArmlist().length; i++) {
                                    Constant.getPlayer2().getArm(i).setMovement(Constant.getPlayer2().getArm(i).getMovementTotal());
                                }
                                //改天气(最好不要全改？）
                                for (int i = 0; i < Constant.cellnum; i++) {
                                    Constant.getCell(i).setWeather(Constant.getWeatherList()[random.nextInt(0,2)]);
                                }
                            }
                            swicth=false;
                        }
                    }
                    else {
                        swicth=false;
                    }
                    //判断是否点击了cell所在的位置
                    for (int i = 0; i < Constant.getPointnum(); i++) {
                        if(Constant.getMouse_X()>=Constant.getCell(i).getLocationx()&
                                Constant.getMouse_Y()>=Constant.getCell(i).getLocationy()&
                                Constant.getMouse_X()<=Constant.getCell(i).getLocationx()+30&
                                Constant.getMouse_Y()<=Constant.getCell(i).getLocationy()+30){
                            //点击的cell存在自己的arm（还没分敌友）
                            if(isempty == 1){
                                //不能选择自己（这里要改一下点自己的反馈)
                                if(icell==i){
                                    JOptionPane.showMessageDialog(null,"Choose other cells");
                                }
                                //判断是否不是附近的（不是距离为1的点）（这里要改一下点其他cell的反馈）
                                else if((Math.abs(Constant.getCell(icell).getLocationx()
                                        -Constant.getCell(i).getLocationx())+
                                        Math.abs(Constant.getCell(icell).getLocationy()
                                                -Constant.getCell(i).getLocationy())!=150)){
                                    JOptionPane.showMessageDialog(null,"Choose other cells");
                                }
                                //这里要判断是否为友军，然后进攻
                                else if(Constant.getCell(i).getArm()!=null){
                                    boolean isEnermy=true;
                                    if(Constant.getPnum()==1){
                                        if(Constant.getCell(i).getArm().getBelongPlayer()==1){
                                            isEnermy = false;
                                        }
                                    }
                                    if(Constant.getPnum()==2){
                                        if(Constant.getCell(i).getArm().getBelongPlayer()==2){
                                            isEnermy = false;
                                        }
                                    }
                                    //是友军不能进攻
                                    if (!isEnermy){
                                        JOptionPane.showMessageDialog(null,"Friendly fire is not allowed");
                                    }
                                    //不是直接进攻（这里最好要有一个展示进攻的过程，死亡暂时还没做完）(这里还差挺多的）
                                    else {
                                        isempty = 0;
                                        if(Constant.getAllplayers()[Constant.getPnum()-1].getMove()>0&
                                                Constant.getCell(icell).getArm().getMovement()>0){
                                            //当前玩家move-1
                                            Constant.getAllplayers()[Constant.getPnum()-1].changeMove(1);
                                            //当前军队move-1
                                            Constant.getCell(icell).getArm().changeMovement(1);
                                            JOptionPane.showMessageDialog(null,"Attack");
                                            new fight(Constant.getCell(i).getArm(),Constant.getCell(icell).getArm());
                                        }
                                        else if(Constant.getAllplayers()[Constant.getPnum()-1].getMove() <= 0){
                                            JOptionPane.showMessageDialog(null,"The available move of the current player are not enough");
                                        }
                                        else if(Constant.getCell(icell).getArm().getMovement() <= 0) {
                                            JOptionPane.showMessageDialog(null,"The available move of the current army are not enough");
                                        }

                                    }
                                }
                                //如果满足所有移动条件那么移动arm到下一个cell（移动条件还不全）
                                else {
                                    isempty=0;
                                    if(Constant.getAllplayers()[Constant.getPnum()-1].getMove()>0&
                                    Constant.getCell(icell).getArm().getMovement()>0){
                                        //当前玩家move-1
                                        Constant.getAllplayers()[Constant.getPnum()-1].changeMove(1);
                                        //当前军队move-1
                                        Constant.getCell(icell).getArm().changeMovement(1);
                                        Constant.getCell(i).setArm(Constant.getCell(icell).getArm());
                                        Constant.getCell(i).getArm().setX(Constant.getCell(i).getLocationx());
                                        Constant.getCell(i).getArm().setY(Constant.getCell(i).getLocationy());
                                        Constant.getCell(icell).setArm(null);
                                        break;
                                    }
                                    else if(Constant.getAllplayers()[Constant.getPnum()-1].getMove() <= 0){
                                        JOptionPane.showMessageDialog(null,"The available move of the current player are not enough");
                                    }
                                    else if(Constant.getCell(icell).getArm().getMovement() <= 0) {
                                        JOptionPane.showMessageDialog(null,"The available move of the current army are not enough");
                                    }
                                }
                            }
                            //点击自己的arm，保存此次的点的位置，后面发起进攻时要用
                            else if(Constant.getCell(i).getArm()!=null){
                                if(Constant.getCell(i).getArm().getBelongPlayer()==Constant.getPnum()){
                                    isempty=1;
                                    icell=i;
                                }
                                else {
                                    JOptionPane.showMessageDialog(null,"Uh Oh! This is enemy army!");
                                }
                            }
                            else {

                                if(Constant.getCell(i).isP1CanProduce()&Constant.getPnum()==1){
                                    //每个国家的选框还没做好统一用这4个
                                    Object[] arm ={ "Infantry", "Armored Vechicle", "Tank","Tiger Tank"};
                                    s = (String) JOptionPane.showInputDialog(null,"choose arm:\n",
                                            "produce", JOptionPane.PLAIN_MESSAGE, new ImageIcon(""), arm, 4);
                                }
                                else if(Constant.getCell(i).isP2CanProduce()&Constant.getPnum()==2){
                                    //每个国家的选框还没做好统一用这4个
                                    Object[] arm ={ "Infantry", "Armored Vechicle", "Tank","Tiger Tank"};
                                    s = (String) JOptionPane.showInputDialog(null,"choose arm:\n",
                                            "produce", JOptionPane.PLAIN_MESSAGE, new ImageIcon(""), arm, 4);
                                }
                                else {
                                    JOptionPane.showMessageDialog(null,"There's nothing for you here...");
                                }
                                //双方对应生成选中的兵种
                                Armnew a = null;
                                if(Constant.getPnum()==1){
                                    if(Objects.equals(s, "Infantry")){
                                        a = new Infantry4p1(Constant.getMap(),Constant.getCell(i).getLocationx(),
                                                Constant.getCell(i).getLocationy());
                                    }
                                    if(Objects.equals(s, "Armored Vechicle")){
                                        a = new ArmoredVechicle4p1(Constant.getMap(),Constant.getCell(i).getLocationx(),
                                                Constant.getCell(i).getLocationy());
                                    }
                                    if(Objects.equals(s, "Tank")){
                                        a = new Tank4p1(Constant.getMap(),Constant.getCell(i).getLocationx(),
                                                Constant.getCell(i).getLocationy());
                                    }
                                    if(Objects.equals(s, "Tiger Tank")){
                                        a = new TigerTank4p1(Constant.getMap(),Constant.getCell(i).getLocationx(),
                                                Constant.getCell(i).getLocationy());
                                    }
                                    //成功加入兵种后扣cost，把该兵种加入对应的player和cell中
                                    if(a!=null){
                                        if(Constant.getPlayer1().getCost()-a.getCost()>=0){
                                            Constant.getPlayer1().changeCost(-a.getCost());
                                            Constant.getCell(i).setArm(a);
                                            Constant.getPlayer1().addArm(a);
                                            s = null;
                                        }
                                        //没钱不能买兵（这里要加个什么效果来展示）
                                        else {
                                            JOptionPane.showMessageDialog(null,"NO MONEY,NO ARMY!");
                                        }
                                    }
                                }
                                //下面是player2的同player1
                                else if (Constant.getPnum()==2) {
                                    if(Objects.equals(s, "Infantry")){
                                        a = new Infantry4p2(Constant.getMap(),Constant.getCell(i).getLocationx(),
                                                Constant.getCell(i).getLocationy());
                                    }
                                    if(Objects.equals(s, "Armored Vechicle")){
                                        a = new ArmoredVechicle4p2(Constant.getMap(),Constant.getCell(i).getLocationx(),
                                                Constant.getCell(i).getLocationy());
                                    }
                                    if(Objects.equals(s, "Tank")){
                                        a = new Tank4p2(Constant.getMap(),Constant.getCell(i).getLocationx(),
                                                Constant.getCell(i).getLocationy());
                                    }
                                    if(Objects.equals(s, "Tiger Tank")){
                                        a = new TigerTank4p2(Constant.getMap(),Constant.getCell(i).getLocationx(),
                                                Constant.getCell(i).getLocationy());
                                    }
                                    if(a!=null){
                                        if(Constant.getPlayer2().getCost()-a.getCost()>=0){
                                            Constant.getPlayer2().changeCost(-a.getCost());
                                            Constant.getCell(i).setArm(a);
                                            Constant.getPlayer2().addArm(a);
                                            s = null;
                                        }
                                        else {
                                            JOptionPane.showMessageDialog(null,"NO MONEY,NO ARMY!");
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                //右键查看该点的详细信息(在celldetail中）
                if(e.getButton()==3){
                    Constant.setMouse_X(e.getX());
                    Constant.setMouse_Y(e.getY());
                    for (int i = 0; i < Constant.getPointnum(); i++) {
                        if(Constant.getMouse_X()>=Constant.getCell(i).getLocationx()&
                                Constant.getMouse_Y()>=Constant.getCell(i).getLocationy()&
                                Constant.getMouse_X()<=Constant.getCell(i).getLocationx()+30&
                                Constant.getMouse_Y()<=Constant.getCell(i).getLocationy()+30){
                            //保存当前点确保下级能找到他的信息
                            Constant.setNowcell(i);
                            //呼叫下级点
                            new Celldetail().detail();
                        }
                    }
                }
            }
        });
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
        gImage.drawString("Totol click"+txt+"times",100,200);
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
            gImage.drawString("Confirm",1350,750);
        }
        else {
            gImage.drawString("End of round",1350,750);
        }
        //测试用
        gImage.drawString("Player"+Constant.getPnum()+"round",700,70);
        gImage.drawString("Player1 cost: " + Constant.getPlayer1().getCost(),700,120);
        gImage.drawString("Player2 cost: " + Constant.getPlayer2().getCost(),700,170);
        gImage.drawString("Surplus avaliable move for current player： "+Constant.getAllplayers()[Constant.getPnum()-1].getMove(),700,220);

        //画一个箭头表示可移动到的位置（有更好的可以替换，现在箭头位置好像有bug但不影响）
        gImage.setColor(Color.yellow);
        if(isempty==1){
            jtmove++;
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

//            if(Constant.getCell(i).isWt()){
//                if(Constant.getCell(i).getWeather().getId()==0){
//                    gImage.drawString("sunny",Constant.getCell(i).getLocationx(), Constant.getCell(i).getLocationy());
//                }
//                if(Constant.getCell(i).getWeather().getId()==1){
//                    gImage.drawString("rain",Constant.getCell(i).getLocationx(), Constant.getCell(i).getLocationy());
//                }
//                if(Constant.getCell(i).getWeather().getId()==2){
//                    gImage.drawString("snow",Constant.getCell(i).getLocationx(), Constant.getCell(i).getLocationy());
//                }
//                if(Constant.getCell(i).getTerrain()==0){
//                    gImage.drawString("plain",Constant.getCell(i).getLocationx(), Constant.getCell(i).getLocationy()-10);
//                }
//                if(Constant.getCell(i).getTerrain()==1){
//                    gImage.drawString("mountain",Constant.getCell(i).getLocationx(), Constant.getCell(i).getLocationy()-10);
//                }
//                if(Constant.getCell(i).getTerrain()==2){
//                    gImage.drawString("river",Constant.getCell(i).getLocationx(), Constant.getCell(i).getLocationy()-10);
//                }
//                if(Constant.getCell(i).getTerrain()==3){
//                    gImage.drawString("swamp",Constant.getCell(i).getLocationx(), Constant.getCell(i).getLocationy()-10);
//                }
//                if(Constant.getCell(i).getTerrain()==4){
//                    gImage.drawString("desert",Constant.getCell(i).getLocationx(), Constant.getCell(i).getLocationy()-10);
//                }
//            }

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