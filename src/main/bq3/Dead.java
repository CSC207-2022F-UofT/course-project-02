package bq3;

public class Dead {
    private Armnew arm;

    public Dead(Armnew arm) {
        this.arm = arm;
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
    }
}
