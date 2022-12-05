package bq3.Test;

import bq3.Entity.Arm.*;
import bq3.Entity.Armnew;

import bq3.Usecase.Dead;
import bq3.Usecase.fight;

import bq3.Presenter.Map;

import static org.junit.Assert.*;

import org.junit.Test;

public class TesterForFight {


    @Test
    public void testfight1() {
        Map map = new Map();
        Armnew arm1 = new Tank4p1(map, 0, 0); // test for 2 tanks fight
        Armnew arm2 = new Tank4p2(map, 0, 0);
        for (int i = 0; i < 5; i++) {
            fight sample = new fight(arm1, arm2);
            assertEquals(80-20*i, arm1.getHp());
            assertEquals(80-20*i, arm2.getHp());
        }
        Armnew arm3 = new Infantry4p1(map, 0, 0); //test for infantry fight with armored_vehicle
        Armnew arm4 = new ArmoredVechicle4p2(map, 0, 0);
        fight sample2 = new fight(arm3, arm4);
        assertEquals(10, arm3.getHp());
        assertEquals(60, arm4.getHp());
        fight sample3 = new fight(arm3, arm4);
        assertEquals(0, arm3.getHp());
        assertEquals(50, arm4.getHp());

    }
}