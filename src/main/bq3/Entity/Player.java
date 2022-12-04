package bq3.Entity;

import bq3.Entity.Armnew;
import bq3.Entity.nation.Nation;

public class Player {
    private Nation nation = null;
    private Armnew[] armlist = {};
    private int cost = 50;

    private int move = 2;
    public Player() {

    }


    public Nation getNation() {
        return nation;
    }

    public void setNation(Nation nation) {
        this.nation = nation;
    }

    public Armnew getArm(int i) {
        return armlist[i];
    }
    public Armnew[] getArmlist() {
        return armlist;
    }

    public void addArm(Armnew arm) {
        Armnew[] newlist = new Armnew[armlist.length+1];
        System.arraycopy(armlist, 0, newlist, 0, armlist.length);
        newlist[armlist.length] = arm;
        this.armlist = newlist;
    }

    public void deadArm(int i){

    }

    public int getCost() {
        return cost;
    }

    public void changeCost(int change) {
        this.cost += change;
    }

    public void changeMove(int move) {
        this.move -= move;
    }

    public int getMove() {
        return move;
    }

    public void setMove(int move) {
        this.move = move;
    }
}
