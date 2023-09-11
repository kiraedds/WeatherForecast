package org.example;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;

public class ForecastRequest {
    public ForecastRequest(String cityName){
        this.cityName=cityName;
    }
    private String cityName = "london";
    private String appid = "ce16651c5a258c780d710a2bcf3c8969";
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public ForecastData request(){
        ForecastData response = new ForecastData();
        try {
            HttpRequest getRequest = HttpRequest.newBuilder()
                    .uri(new URI("http://api.openweathermap.org/data/2.5/forecast?q="+cityName+"&APPID="+appid+"&units=metric&cnt=7"))
                    .GET()
                    .build();
            System.out.println(getRequest);
            HttpClient httpClient = HttpClient.newHttpClient();
            HttpResponse<String> getResponse = httpClient.send(getRequest, HttpResponse.BodyHandlers.ofString());
            System.out.println(getResponse.body());
            Gson gson = new Gson();
            response = gson.fromJson(getResponse.body(),ForecastData.class);
            /*for(int i=0;i<7;i++) {
                System.out.println(response.list[i].weather[0].description);
            }*/

        } catch (URISyntaxException | InterruptedException | IOException e) {
            e.printStackTrace();
        }
        return response;
    }
}
