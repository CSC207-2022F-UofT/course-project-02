package main.Test;

import main.Entity.Arm.*;
import main.Entity.Armnew;

import main.Entity.Constant;
import main.Usecase.fight;

import main.Presenter.Map;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestForDead {
    @Test
    public void testdead1() {
        Map map = new Map();
        Constant.addallcells();
        Armnew arm1 = new Infantry4p1(map,Constant.getCell(10).getLocationx(),
                Constant.getCell(10).getLocationy());
        Constant.getCell(10).setArm(arm1);
        arm1.setHp(1);
        Armnew arm2 = new Infantry4p1(map,0,0);
        fight f1 = new fight(arm1,arm2);
        assertNull(Constant.getCell(10).getArm());

        Armnew arm3 = new ArmoredVechicle4p2(map,Constant.getCell(5).getLocationx(),
                Constant.getCell(5).getLocationy());
        Constant.getCell(5).setArm(arm3);
        arm3.setHp(2);
        Armnew arm4 = new Tank4p1(map,Constant.getCell(6).getLocationx(),
                Constant.getCell(6).getLocationy());
        fight f2 = new fight(arm3,arm4);
        assertNull(Constant.getCell(5).getArm());

        Armnew arm5 = new ArmoredVechicle4p2(map,Constant.getCell(20).getLocationx(),
                Constant.getCell(20).getLocationy());
        Constant.getCell(20).setArm(arm5);
        Armnew arm6 = new Tank4p1(map,Constant.getCell(21).getLocationx(),
                Constant.getCell(21).getLocationy());
        fight f3 = new fight(arm5,arm6);
        int a = 0;
        if(Constant.getCell(20).getArm()==null){
            a = 1;
        }
        assertEquals(0,a);
    }

}
