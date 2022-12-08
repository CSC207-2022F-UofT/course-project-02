package main.Entity;

import main.Presenter.Map;

import java.awt.*;

public abstract class Armnew extends Gameobject {
    int cost = 0;
    int hp = 0;
    int hpTotal = 0;
    int movement = 0;
    int movementTotal = 0;
    int defense = 0;
    int attack = 0;
    int belongPlayer = 0;

    public Armnew(Map map, int x, int y, int cost, int hp, int movement, int defense, int attack) {
        super(map, x, y);
        setHeight(30);
        setWidth(30);
        this.cost = cost;
        this.hp = hp;
        this.hpTotal = hp;
        this.movement = movement;
        this.movementTotal = movement;
        this.defense = defense;
        this.attack = attack;
    }

    @Override
    public void paintSelf(Graphics g) {
        g.drawImage(img,x,y,width,height,null);
    }

    @Override
    public Rectangle getRec() {
        return new Rectangle(x,y,width,height);
    }


    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getHpTotal() {
        return hpTotal;
    }

    public void setHpTotal(int hpTotal) {
        this.hpTotal = hpTotal;
    }

    public int getMovement() {
        return movement;
    }

    public void changeMovement(int movement) {
        this.movement -= movement;
    }

    public void setMovement(int movement) {
        this.movement = movement;
    }

    public int getMovementTotal() {
        return movementTotal;
    }

    public void setMovementTotal(int movementTotal) {
        this.movementTotal = movementTotal;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getBelongPlayer() {
        return belongPlayer;
    }

    public void setBelongPlayer(int belongPlayer) {
        this.belongPlayer = belongPlayer;
    }

}
