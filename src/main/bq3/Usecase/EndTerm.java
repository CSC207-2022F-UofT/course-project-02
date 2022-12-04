package bq3.Usecase;

import bq3.Entity.Constant;

import java.util.Random;


public class EndTerm {

    private Random random = new Random();


    public EndTerm(int player) {
        if(player==1){
            Constant.setPnum(2);
            Constant.getPlayer2().setMove(2);
            for (int i = 0; i < Constant.getPlayer1().getArmlist().length; i++) {
                Constant.getPlayer1().getArm(i).setMovement(Constant.getPlayer1().getArm(i).getMovementTotal());
            }
        }
        else if(player==2) {
            Constant.setPnum(1);
            Constant.getPlayer1().changeCost(50);
            Constant.getPlayer2().changeCost(50);
            Constant.getPlayer1().setMove(2);
            for (int i = 0; i < Constant.getPlayer2().getArmlist().length; i++) {
                Constant.getPlayer2().getArm(i).setMovement(Constant.getPlayer2().getArm(i).getMovementTotal());
            }
            //改天气(最好不要全改？）
            //Change the weather
            for (int i = 0; i < Constant.cellnum; i++) {
                Constant.getCell(i).setWeather(Constant.getWeatherList()[random.nextInt(2)]);
            }
        }
    }
}
