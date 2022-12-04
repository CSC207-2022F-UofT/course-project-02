package bq3.Test;

import bq3.Entity.Arm.Tank;
import bq3.Entity.Arm.Tank4p1;
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
        Armnew arm1 = new Tank4p1(map, 0, 0);
        Armnew arm2 = new Tank4p1(map, 0, 0);
        for (int i = 0; i < 10; i++) {
            fight sample = new fight(arm1, arm2);
            switch(i) {
                case 1:
                    assertEquals(80, arm2.getHp());
                    assertEquals(80, arm1.getHp());
                    break;
                case 2:
                    assertEquals(70, arm2.getHp());
                    assertEquals(70, arm1.getHp());
                    break;
                case 3:
                    assertEquals(60, arm2.getHp());
                    assertEquals(60, arm1.getHp());
                case 4:
                    assertEquals(50, arm2.getHp());
                    assertEquals(50, arm1.getHp());
                    break;
                case 5:
                    assertEquals(40, arm2.getHp());
                    assertEquals(40, arm1.getHp());
                    break;
                case 6:
                    assertEquals(30, arm2.getHp());
                    assertEquals(30, arm1.getHp());
                    break;
                case 7:
                    assertEquals(20, arm2.getHp());
                    assertEquals(20, arm1.getHp());
                    break;
                case 8:
                    assertEquals(10, arm2.getHp());
                    assertEquals(10, arm1.getHp());
                    break;
                case 9:
                    assertEquals(5, arm2.getHp());
                    assertEquals(5, arm1.getHp());
                    break;
                default:
                    // code block
            }
        }
    }
}
