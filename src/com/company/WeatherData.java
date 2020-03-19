package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class WeatherData extends Observable {
    //private ArrayList observers;
    private float temperature;
    private float humidity;
    private float pressure;
    public WeatherData(){
        //  observers=new ArrayList();
    }
    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }

    public void measurementChange(){

       setChanged();
       notifyObservers();
    }
    public void setMeasurements(float temperature,float humidity,float pressure){
       this.temperature=temperature;
       this.humidity=humidity;
       this.pressure=pressure;
       measurementChange();

    }
}
