package bq3;

import bq3.Arm.Tank;
import bq3.Arm.Tank4p1;
import bq3.Arm.Tank4p2;

import java.util.Random;

public class Test {
    public static void main(String[] args) {
        Random random = new Random();
        int a = 0;
        for (int i = 0; i < 100; i++) {
            a+=random.nextInt(0,3);
        }
        System.out.println(a/3);
    }
}
