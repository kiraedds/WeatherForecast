package org.example;

public class WeatherData {
    Coordinates coord;
    Wind wind;
    Weather[] weather;
    public static class Coordinates {
        float lon;
        float lat;
    }

    public static class Weather {
        int id;
        String main;
        String description;
        String icon;
    }
    public static class Wind {
        float speed;
        float deg;
        float gust;
    }
}
