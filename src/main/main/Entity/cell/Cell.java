package main.Entity.cell;

import main.Entity.Constant;
import main.Entity.terrain.*;
import main.Entity.Weather.Weather;
import main.Entity.Armnew;

import java.util.Random;

public class Cell {

    private static int numcells=0;
    private int id;
    private int locationx;
    private int locationy;
    //特殊点
    //Special point
    private boolean sp = false;

    private final Random random =new Random();

    private Weather weather;
    private final Terrain terrain;

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
        this.terrain = generateWeather(locationx, locationy);
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

    /**
     * Generate fixed terrain
     * @param locationx X coordinate
     * @param locationy Y coordinate
     * @return terrain
     */
    public Terrain generateWeather(int locationx, int locationy) {
        Terrain terrain;
        if (locationx >= 100 && locationx < 550 && locationy >= 250 && locationy < 750) {
            terrain = new Plain("Plain", "Plain");
            if (locationx == 100 && locationy == 550) {
                terrain = new Swamp("Swamp", "Swamp");
            }
        } else if (locationx >= 550 && locationx < 1000 && locationy >= 100 && locationy <= 850) {
            terrain = new Mountain("Mountain", "Mountain");
            if (locationx == 550 && locationy == 400) {
                terrain = new Plain("Plain", "Plain");
            }
            if (locationx == 850 && locationy == 700) {
                terrain = new Plain("Plain", "Plain");
            }
        } else if (locationx >= 1000 && locationx <= 1150 && locationy >= 100 && locationy < 850) {
            terrain = new Plain("Plain", "Plain");
            if (locationx == 1000 && locationy == 100) {
                terrain = new River("River", "River");
            }
        } else {
            terrain = new Desert("Desert", "Desert");
        }
        return terrain;
    }
}
