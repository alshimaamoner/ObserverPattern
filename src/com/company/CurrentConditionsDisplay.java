package com.company;

import java.util.Observable;
import java.util.Observer;

public class CurrentConditionsDisplay implements Observer,DisplayElement{
    private  float temperature;
    private float humidity;
   Observable observable;
    public CurrentConditionsDisplay(Observable observable){
        this.observable=observable;
        observable.addObserver(this);


    }
    @Override
    public void display() {
        System.out.println("Current Conditions : "+temperature+
                "F degrees and "+humidity+"% humidity");
    }


    @Override
    public void update(Observable o, Object arg) {
     if(o instanceof WeatherData){
       WeatherData weatherData= (WeatherData) o;
       this.temperature=weatherData.getTemperature();
       this.humidity=weatherData.getHumidity();
       display();
     }
    }
}
