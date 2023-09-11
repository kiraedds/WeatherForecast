package org.example;

import java.util.ArrayList;
import java.util.List;

public class ForecastData {

    Data[] list;
    City city;
    public class Data{
        Weather[] weather;
        Main main;
        String dt_txt;

    }
    public class City{
        String name;
        String country;
    }
    public class Weather{
        int id;
        String main;
        String description;
        String icon;
    }
    public class Main{
        float temp;
        float feels_like;
        int pressure;
        int humidity;
    }
}
