package com.example.okhttpexam;

public class Weather {
    private String country = "";
    private String weather = "";
    private String temp = "";

    public Weather(String country, String weather, String temp) {
        this.country = country;
        this.weather = weather;
        this.temp = temp;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "country='" + country + '\'' +
                ", weather='" + weather + '\'' +
                ", temp='" + temp + '\'' +
                '}';
    }
}
