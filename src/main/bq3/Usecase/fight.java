package bq3.Usecase;


import bq3.Entity.Armnew;
import bq3.Usecase.Dead;

public class fight {
    private Armnew arm1;
    private Armnew arm2;

    public fight(Armnew arm1, Armnew arm2) {
        this.arm1 = arm1;
        this.arm2 = arm2;
        battle();
    }

    public void battle(){
        //arm2
        if(arm2.getHp()+ arm2.getDefense()-arm1.getAttack()<=0){
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
        if(arm1.getHp()+ arm1.getDefense()-arm2.getAttack()<=0){
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
    }
    //test fight
    public static void main(String[] args) {
//        Armnew a = new Infantry4p1(null,0,0);
//        Armnew b = new Infantry4p2(null,0,0);
//        a.setHp(1);
//        System.out.println(b.hp);
//        fight f1 = new fight(a,b);
//        System.out.println(a.hp);
//        System.out.println(b.hp);
    }
}
