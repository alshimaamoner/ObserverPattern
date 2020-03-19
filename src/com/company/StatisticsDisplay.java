package com.company;

import java.util.Observable;
import java.util.Observer;

public class StatisticsDisplay implements Observer,DisplayElement {
    private float maxTemp=0.0f;
    private float minTemp=200;
    private float tempSum=0.0f;
    private int numReadings;
    Observable observable;
    public StatisticsDisplay(Observable observable){
        this.observable=observable;
        observable.addObserver(this);
    }
    @Override
    public void display() {
        System.out.println("Avg temp :"+tempSum/numReadings+" max temp :" +maxTemp+ "min Temp :"+minTemp);
    }



    @Override
    public void update(Observable o, Object arg) {
         if(o instanceof WeatherData){
             WeatherData weatherData= (WeatherData) o;
             tempSum+=weatherData.getTemperature();
              numReadings++;
             if(weatherData.getTemperature()>maxTemp)
                 maxTemp=weatherData.getTemperature();
             else if(weatherData.getTemperature()<minTemp)
                 minTemp=weatherData.getTemperature();
             display();
         }
    }
}
