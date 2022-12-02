package bq3;


import bq3.Arm.Infantry;
import bq3.Arm.Infantry4p1;
import bq3.Arm.Infantry4p2;

public class fight {
    private Armnew arm1;
    private Armnew arm2;

    private final int minRatio = 5;

    public fight(Armnew arm1, Armnew arm2) {
        this.arm1 = arm1;
        this.arm2 = arm2;
        battle();
    }

    /*    public void battle(){
            //arm2
            if(winCondition(arm1,arm2)){
                arm2.setHp(0);
                new Dead(arm2);
            }
            else {
                if (arm2.getDefense()-arm1.getAttack()>=arm1.getAttack()/5){
                    arm2.setHp(arm2.getHp()-arm1.getAttack()/5);//保底伤害为攻击者的1/5
                }
                else {
                    arm2.setHp(arm2.getHp()+ arm2.getDefense()-arm1.getAttack());
                }
            }
            //arm1
            if(!winCondition(arm1,arm2)){
                arm1.setHp(0);
                new Dead(arm1);
            }
            else {
                if (arm1.getDefense()-arm2.getAttack()>=arm2.getAttack()/5){
                    arm1.setHp(arm1.getHp()-arm2.getAttack()/5);//保底伤害为攻击者的1/5
                }
                else {
                    arm1.setHp(arm1.getHp()+ arm1.getDefense()-arm2.getAttack());
                }
            }
        }*/
    public void battle() {// arm1 and arm2 will battle for each other
        //arm2 is defence
        battleRound(arm1, arm2);
        //arm1 is defence
        battleRound(arm2, arm1);
    }

    public boolean winCondition(Armnew defense, Armnew attack) {
        return defense.getHp() + defense.getDefense() - attack.getAttack() <= 0;
    }

    public int minAttackValue(Armnew defense, Armnew attack) {
        // the min attack value is the 1/5 of attacker's basic value
        return (defense.getDefense() - attack.getAttack() >= attack.getAttack() / minRatio) ?
                -defense.getDefense() + attack.getAttack() : attack.getAttack() / minRatio;
    }

    public void battleRound(Armnew defense, Armnew attack) {
        // if attacker wins, defender will be set as dead;
        if (winCondition(defense, attack)) {
            defense.setHp(0);
            new Dead(defense);
        } else { //if it does not win, reset the hp.
            defense.setHp(defense.getHp() - minAttackValue(defense, attack));
        }
    }

    //test fight
    public static void main(String[] args) {
        Armnew a = new Infantry4p1(null, 0, 0);
        Armnew b = new Infantry4p2(null, 0, 0);
        a.setHp(1);
        System.out.println(b.hp);
        fight f1 = new fight(a, b);
        System.out.println(a.hp);
        System.out.println(b.hp);
    }
}
