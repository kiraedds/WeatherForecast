package org.example;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
//import com.google.gson;
//import com.google.gson.GsonBuilder;
import com.google.gson.*;
public class Request {
    private String cityName = "london";
    private String appid = "ce16651c5a258c780d710a2bcf3c8969";
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public void request(){

        try {
            HttpRequest getRequest = HttpRequest.newBuilder()
                    .uri(new URI("http://api.openweathermap.org/data/2.5/weather?q="+cityName+"&APPID="+appid))
                    //.header("APPID","ce16651c5a258c780d710a2bcf3c8969")
                    //.headers("q",cityName,"APPID","ce16651c5a258c780d710a2bcf3c8969")
                    .GET()
                    .build();
            System.out.println(getRequest);
            HttpClient httpClient = HttpClient.newHttpClient();
            HttpResponse<String> getResponse = httpClient.send(getRequest, HttpResponse.BodyHandlers.ofString());
            System.out.println(getResponse.body());
            Gson gson = new Gson();
            WeatherData response = gson.fromJson(getResponse.body(),WeatherData.class);
            System.out.println(response.coord.lat);
            System.out.println(response.wind.speed);
            System.out.println(response.weather[0].description);

        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
