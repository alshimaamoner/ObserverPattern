package com.company;

import java.util.Observable;
import java.util.Observer;

public class ForecastDisplay implements Observer,DisplayElement {
    private  float currentPressure=29.92f;
    private float lastPressure;
    Observable observable;
    public ForecastDisplay(Observable observable){
        this.observable=observable;
        observable.addObserver(this);
    }
    @Override
    public void display() {
         if(lastPressure<currentPressure){
             System.out.println("Improving weather on the way!");

         }else if(lastPressure==currentPressure){
             System.out.println("The same");


         }else{
             System.out.println("cool!");

         }
    }

    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof WeatherData){
            WeatherData weatherData= (WeatherData) o;
            lastPressure=currentPressure;
            currentPressure=weatherData.getPressure();
            display();

        }

    }
}
