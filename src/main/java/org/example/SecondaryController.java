package org.example;

import java.io.IOException;
import java.security.Key;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class SecondaryController {

    public Label temperatureLabel;
    public Label temperatureLabel1;
    public Label temperatureLabel2;
    public Label temperatureLabel3;
    public Label temperatureLabel4;
    public Label temperatureLabel5;

    public Label humidityLabel;
    public Label humidityLabel1;
    public Label humidityLabel2;
    public Label humidityLabel3;
    public Label humidityLabel4;
    public Label humidityLabel5;

    public Label hourLabel;
    public Label hourLabel1;
    public Label hourLabel2;
    public Label hourLabel3;
    public Label hourLabel4;
    public Label hourLabel5;

    public ImageView image;
    public ImageView image1;
    public ImageView image2;
    public ImageView image3;
    public ImageView image4;
    public ImageView image5;

    public Label feelsLikeLabel;
    public Label feelsLikeLabel1;
    public Label feelsLikeLabel2;
    public Label feelsLikeLabel3;
    public Label feelsLikeLabel4;
    public Label feelsLikeLabel5;

    public Label pressureLabel;
    public Label pressureLabel1;
    public Label pressureLabel2;
    public Label pressureLabel3;
    public Label pressureLabel4;
    public Label pressureLabel5;
    
    public TextField searchTextField;
    public Label cityNameLabel;
    public Label countryLabel;
    public Label currentTimeLabel;

    public Label descriptionLabel;
    public Label descriptionLabel1;
    public Label descriptionLabel2;
    public Label descriptionLabel3;
    public Label descriptionLabel4;
    public Label descriptionLabel5;



    @FXML
    private Label secondaryLabel;
    @FXML
    private Button searchButton;
    @FXML
    private void searchTextFieldMouseClicked(){
        searchTextField.setText("");
    }
    @FXML
    private void searchTextFieldKeyPressed(KeyEvent key) throws IOException {
        if(key.getCode() == KeyCode.ENTER && !searchTextField.getText().isEmpty()){
            searchForWeather();
        }
    }
    @FXML
    private void searchForWeather() throws IOException {
        String cityName = searchTextField.getText();

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
        java.util.Date now = new java.util.Date();
        currentTimeLabel.setText(String.valueOf(now));

        ForecastRequest request = new ForecastRequest(cityName);
        ForecastData response = request.request();
        //secondaryLabel.setText(response.list[0].weather[0].description);



        countryLabel.setText(response.city.country);
        cityNameLabel.setText(response.city.name);

        hourLabel.setText(response.list[0].dt_txt.substring(11,16));
        hourLabel1.setText(response.list[1].dt_txt.substring(11,16));
        hourLabel2.setText(response.list[2].dt_txt.substring(11,16));
        hourLabel3.setText(response.list[3].dt_txt.substring(11,16));
        hourLabel4.setText(response.list[4].dt_txt.substring(11,16));
        hourLabel5.setText(response.list[5].dt_txt.substring(11,16));

        temperatureLabel.setText(String.valueOf(response.list[0].main.temp)+"°C");
        temperatureLabel1.setText(String.valueOf(response.list[1].main.temp)+"°C");
        temperatureLabel2.setText(String.valueOf(response.list[2].main.temp)+"°C");
        temperatureLabel3.setText(String.valueOf(response.list[3].main.temp)+"°C");
        temperatureLabel4.setText(String.valueOf(response.list[4].main.temp)+"°C");
        temperatureLabel5.setText(String.valueOf(response.list[5].main.temp)+"°C");

        feelsLikeLabel.setText(String.valueOf(response.list[0].main.feels_like)+"°C");
        feelsLikeLabel1.setText(String.valueOf(response.list[1].main.feels_like)+"°C");
        feelsLikeLabel2.setText(String.valueOf(response.list[2].main.feels_like)+"°C");
        feelsLikeLabel3.setText(String.valueOf(response.list[3].main.feels_like)+"°C");
        feelsLikeLabel4.setText(String.valueOf(response.list[4].main.feels_like)+"°C");
        feelsLikeLabel5.setText(String.valueOf(response.list[5].main.feels_like)+"°C");

        humidityLabel.setText(String.valueOf(response.list[0].main.humidity)+"%");
        humidityLabel1.setText(String.valueOf(response.list[1].main.humidity)+"%");
        humidityLabel2.setText(String.valueOf(response.list[2].main.humidity)+"%");
        humidityLabel3.setText(String.valueOf(response.list[3].main.humidity)+"%");
        humidityLabel4.setText(String.valueOf(response.list[4].main.humidity)+"%");
        humidityLabel5.setText(String.valueOf(response.list[5].main.humidity)+"%");

        pressureLabel.setText(String.valueOf(response.list[0].main.pressure)+"Pa");
        pressureLabel1.setText(String.valueOf(response.list[1].main.pressure)+"Pa");
        pressureLabel2.setText(String.valueOf(response.list[2].main.pressure)+"Pa");
        pressureLabel3.setText(String.valueOf(response.list[3].main.pressure)+"Pa");
        pressureLabel4.setText(String.valueOf(response.list[4].main.pressure)+"Pa");
        pressureLabel5.setText(String.valueOf(response.list[5].main.pressure)+"Pa");

        String url ="https://openweathermap.org/img/wn/";
        image.setImage(new Image(url+response.list[0].weather[0].icon+".png"));
        image1.setImage(new Image(url+response.list[1].weather[0].icon+".png"));
        image2.setImage(new Image(url+response.list[2].weather[0].icon+".png"));
        image3.setImage(new Image(url+response.list[3].weather[0].icon+".png"));
        image4.setImage(new Image(url+response.list[4].weather[0].icon+".png"));
        image5.setImage(new Image(url+response.list[5].weather[0].icon+".png"));


        descriptionLabel.setText(response.list[0].weather[0].description);
        descriptionLabel1.setText(response.list[1].weather[0].description);
        descriptionLabel2.setText(response.list[2].weather[0].description);
        descriptionLabel3.setText(response.list[3].weather[0].description);
        descriptionLabel4.setText(response.list[4].weather[0].description);
        descriptionLabel5.setText(response.list[5].weather[0].description);


    }
}