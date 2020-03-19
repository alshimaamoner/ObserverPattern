package com.company;

import java.util.Observer;

public interface Subject {
    public void registerObserver(com.company.Observer o);
    public void removeObserver(com.company.Observer o);
    public void notifyObservers();


}
