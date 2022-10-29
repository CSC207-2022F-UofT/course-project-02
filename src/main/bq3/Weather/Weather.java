package bq3.Weather;

import bq3.Armnew;

public abstract class Weather {
    private int id;
    private final String[] weatherList = {"sunny","rain","snow"};
    private String weather;

    public Weather(int id) {
        this.id = id;
        this.weather = weatherList[id];
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }
    public abstract void effectOnMovement(Armnew arm);
}
