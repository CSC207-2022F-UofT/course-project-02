package bq3.Usecase;

import bq3.Entity.Armnew;
import bq3.Entity.Constant;

public class Dead {
    //private Armnew arm;

    public Dead(Armnew arm) {
        //this.arm = arm;
        for (int i = 0; i < Constant.getPointnum(); i++) {
            if(Constant.getCell(i).getArm()==arm){
                Constant.getCell(i).setArm(null);
                break;
            }
        }
        if(arm.getBelongPlayer()==1){
            for (int i = 0; i < Constant.getPlayer1().getArmlist().length; i++) {
                Constant.getPlayer1().deadArm(i);
            }
        }
        if(arm.getBelongPlayer()==2){
            for (int i = 0; i < Constant.getPlayer2().getArmlist().length; i++) {
                Constant.getPlayer2().deadArm(i);
            }
        }
    }
}
