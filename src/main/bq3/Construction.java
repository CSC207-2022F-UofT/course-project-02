package bq3;
import bq3.Gameobject;
import bq3.Map;

import java.awt.*;

public class Construction extends Gameobject {
    private String name;
    private int cost;
    private double HP;
    private int atk_to_arm;
    private int atk_to_inf;
    private double defense;

    private int belong;

    public Construction(Map map, int x, int y, String name, int cost,
                        double HP, int atk_to_armor, int atk_to_infantry, double defense){
        super(map, x-20, y-20);
        setHeight(20);
        setWidth(20);
        this.name = name;
        this.cost = cost;
        this.atk_to_arm = atk_to_armor;
        this.atk_to_inf = atk_to_infantry;
        this.defense = defense;
        this.HP = HP;
    }

    @Override
    public void paintSelf(Graphics g){
        g.drawImage(img,x,y,width,height,null);
    }

    @Override
    public Rectangle getRec() {
        return new Rectangle(x,y,width,height);
    }


    public String getName(){
        return this.name;
    }

    public int getCost() {
        return this.cost;
    }

    public int getAtk_to_arm(){return this.atk_to_arm;}

    public int getAtk_to_inf(){
        return  this.atk_to_inf;
    }

    public double getDefense() {
        return this.defense;
    }

    public double getHP(){return this.HP;}

    public void setHP(double HP){
        this.HP = HP;
    }

    public void setBelongPlayer(int belong){
        this.belong = belong;
    }

}
