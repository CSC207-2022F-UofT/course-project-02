package bq3.Usecase;

import bq3.Entity.Constant;

public class GetLoction {
    int id;
    int locx;
    int locy;
    String weather;
    String terrain;
    public GetLoction(int id) {
        this.id = id;
        this.locx = Constant.getCell(id).getLocationx();
        this.locy = Constant.getCell(id).getLocationy();
        if(Constant.getCell(id).getWeather().getId()==0){
            weather = "sunny";
        }
        if(Constant.getCell(id).getWeather().getId()==1){
            weather = "rain";
        }
        if(Constant.getCell(id).getWeather().getId()==2){
            weather = "snow";
        }
        terrain = Constant.getCell(id).getTerrain();
    }


    public int getLocx() {
        return locx;
    }

    public void setLocx(int locx) {
        this.locx = locx;
    }

    public int getLocy() {
        return locy;
    }

    public void setLocy(int locy) {
        this.locy = locy;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getTerrain() {
        return terrain;
    }

    public void setTerrain(String terrain) {
        this.terrain = terrain;
    }

}
