package bq3.listener;

import bq3.Entity.Armnew;
import bq3.Entity.Constant;
import bq3.Entity.Arm.*;
import bq3.Presenter.Map;
import bq3.Entity.cell.Celldetail;
import bq3.Usecase.fight;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Objects;
import java.util.Random;

public class MapListener {

    private String s;

    private Random random = new Random();

    public void listener(Map map) {
        map.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //左键生成兵种以及在已经有兵的cell移动兵种（进攻模块还没做）
                if(e.getButton()==1){
                    //这几行是测试保存数据功能后面用csv代替
                    map.txt=map.getTxt(1);
                    map.txt2=map.getTxt(2);
                    map.setTxt(String.valueOf(map.txt+1)+"\n"+String.valueOf(map.txt2));
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
                        if(!map.swicth){
                            map.swicth = true;
                            map.isempty = 0;
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
                                    Constant.getCell(i).setWeather(Constant.getWeatherList()[random.nextInt(2)]);
                                }
                            }
                            map.swicth=false;
                        }
                    }
                    else {
                        map.swicth=false;
                    }
                    //判断是否点击了cell所在的位置
                    for (int i = 0; i < Constant.getPointnum(); i++) {
                        if(Constant.getMouse_X()>=Constant.getCell(i).getLocationx()&
                                Constant.getMouse_Y()>=Constant.getCell(i).getLocationy()&
                                Constant.getMouse_X()<=Constant.getCell(i).getLocationx()+30&
                                Constant.getMouse_Y()<=Constant.getCell(i).getLocationy()+30){
                            //点击的cell存在自己的arm（还没分敌友）
                            if(map.isempty == 1){
                                //不能选择自己（这里要改一下点自己的反馈)
                                if(map.icell==i){
                                    JOptionPane.showMessageDialog(null,"Choose other cell");
                                }
                                //判断是否不是附近的（不是距离为1的点）（这里要改一下点其他cell的反馈）
                                else if((Math.abs(Constant.getCell(map.icell).getLocationx()
                                        -Constant.getCell(i).getLocationx())+
                                        Math.abs(Constant.getCell(map.icell).getLocationy()
                                                -Constant.getCell(i).getLocationy())!=150)){
                                    JOptionPane.showMessageDialog(null,"Choose other cell");
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
                                        JOptionPane.showMessageDialog(null,"You cannot hit arms on your side");
                                    }
                                    //不是直接进攻（这里最好要有一个展示进攻的过程，死亡暂时还没做完）(这里还差挺多的）
                                    else {
                                        map.isempty = 0;
                                        if(Constant.getAllplayers()[Constant.getPnum()-1].getMove()>0&
                                                Constant.getCell(map.icell).getArm().getMovement()>0){
                                            //当前玩家move-1
                                            Constant.getAllplayers()[Constant.getPnum()-1].changeMove(1);
                                            //当前军队move-1
                                            Constant.getCell(map.icell).getArm().changeMovement(1);
                                            JOptionPane.showMessageDialog(null,"attack");
                                            new fight(Constant.getCell(i).getArm(),Constant.getCell(map.icell).getArm());
                                        }
                                        else if(Constant.getAllplayers()[Constant.getPnum()-1].getMove() <= 0){
                                            JOptionPane.showMessageDialog(null,"Not enough steps for current player");
                                        }
                                        else if(Constant.getCell(map.icell).getArm().getMovement() <= 0) {
                                            JOptionPane.showMessageDialog(null,"Not enough steps for current unit");
                                        }

                                    }
                                }
                                //如果满足所有移动条件那么移动arm到下一个cell（移动条件还不全）
                                else {
                                    map.isempty=0;
                                    if(Constant.getAllplayers()[Constant.getPnum()-1].getMove()>0&
                                            Constant.getCell(map.icell).getArm().getMovement()>0){
                                        //当前玩家move-1
                                        Constant.getAllplayers()[Constant.getPnum()-1].changeMove(1);
                                        //当前军队move-1
                                        Constant.getCell(map.icell).getArm().changeMovement(1);
                                        Constant.getCell(i).setArm(Constant.getCell(map.icell).getArm());
                                        Constant.getCell(i).getArm().setX(Constant.getCell(i).getLocationx());
                                        Constant.getCell(i).getArm().setY(Constant.getCell(i).getLocationy());
                                        Constant.getCell(map.icell).setArm(null);
                                        break;
                                    }
                                    else if(Constant.getAllplayers()[Constant.getPnum()-1].getMove() <= 0){
                                        JOptionPane.showMessageDialog(null,"Not enough step for current user");
                                    }
                                    else if(Constant.getCell(map.icell).getArm().getMovement() <= 0) {
                                        JOptionPane.showMessageDialog(null,"Not enough step for current unit");
                                    }
                                }
                            }
                            //点击自己的arm，保存此次的点的位置，后面发起进攻时要用
                            else if(Constant.getCell(i).getArm()!=null){
                                if(Constant.getCell(i).getArm().getBelongPlayer()==Constant.getPnum()){
                                    map.isempty=1;
                                    map.icell=i;
                                }
                                else {
                                    JOptionPane.showMessageDialog(null,"This is not your unit");
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
                                    JOptionPane.showMessageDialog(null,"Here is empty");
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
                                            JOptionPane.showMessageDialog(null,"Need more money");
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
                                            JOptionPane.showMessageDialog(null,"Need more money");
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
    }
}
