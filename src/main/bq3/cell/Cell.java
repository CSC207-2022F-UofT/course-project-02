package bq3.cell;

import bq3.Constant;
import bq3.Weather.Weather;
import bq3.Armnew;
import bq3.terrain.*;

import java.util.ArrayList;
import java.util.List;
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
    private final Terrain terrain;

    private Armnew arm = null;
    private boolean p1CanProduce=false;
    private boolean p2CanProduce=false;


    public Cell(int locationx, int locationy) {
        Terrain terrain1 = null;
        numcells++;
        id=numcells;
        this.locationx = locationx;
        this.locationy = locationy;
        if(Constant.getWeatherList()!=null){
            this.weather = Constant.getWeatherList()[random.nextInt(3)];
        }
        if (locationx >= 100 && locationx < 550 && locationy >= 250 && locationy < 750) {
            terrain1 = new Plain("Plain", "Plain");
            if (locationx == 100 && locationy == 550) {
                terrain1 = new Swamp("Swamp", "Swamp");
            }
        } else if (locationx >= 550 && locationx < 1000 && locationy >= 100 && locationy <= 850) {
            terrain1 = new Mountain("Mountain", "Mountain");
            if (locationx == 550 && locationy == 400) {
                terrain1 = new Plain("Plain", "Plain");
            }
            if (locationx == 850 && locationy == 700) {
                terrain1 = new Plain("Plain", "Plain");
            }
        } else if (locationx >= 1000 && locationx <= 1150 && locationy >= 100 && locationy < 850) {
            terrain1 = new Plain("Plain", "Plain");
            if (locationx == 1000 && locationy == 100) {
                terrain1 = new River("River", "River");
            }
        } else {
            terrain1 = new Desert("Desert", "Desert");
        }
        this.terrain = terrain1;
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
    public String getTerrain() {
        return terrain.getName();
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
