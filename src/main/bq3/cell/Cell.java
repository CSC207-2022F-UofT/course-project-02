package bq3.cell;

import bq3.Constant;
import bq3.Weather.Weather;
import bq3.Armnew;

import java.util.Random;

public class Cell {
    private static int numcells=0;
    private int id;
    private int locationx;
    private int locationy;
    //特殊点
    private boolean sp = false;

    private final Random random =new Random();

    private Weather weather;
    private final int terrain;

    private Armnew arm = null;
    private boolean p1CanProduce=false;
    private boolean p2CanProduce=false;


    public Cell(int locationx, int locationy) {
        numcells++;
        id=numcells;
        this.locationx = locationx;
        this.locationy = locationy;
        if(Constant.getWeatherList()!=null){
            this.weather = Constant.getWeatherList()[random.nextInt(3)];
        }
        this.terrain = random.nextInt(5);
    }



    public int getId() {
        return id;
    }

    public int getLocationx() {
        return locationx;
    }

    public void setLocationx(int locationx) {
        this.locationx = locationx;
    }

    public int getLocationy() {
        return locationy;
    }

    public void setLocationy(int locationy) {
        this.locationy = locationy;
    }

    public boolean isSp() {
        return sp;
    }

    public void setSp(boolean sp) {
        this.sp = sp;
    }
    public int getTerrain() {
        return terrain;
    }

    public Weather getWeather() {
        return weather;
    }

    public void setWeather(Weather weather) {
        this.weather = weather;
    }

    public Armnew getArm() {
        return arm;
    }

    public void setArm(Armnew arm) {
        this.arm = arm;
    }

    public boolean isP1CanProduce() {
        return p1CanProduce;
    }

    public void setP1CanProduce(boolean p1CanProduce) {
        this.p1CanProduce = p1CanProduce;
    }

    public boolean isP2CanProduce() {
        return p2CanProduce;
    }

    public void setP2CanProduce(boolean p2CanProduce) {
        this.p2CanProduce = p2CanProduce;
    }
}
