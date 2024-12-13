package com.marouaneLasmak.implementation;

import com.marouaneLasmak.interfaces.Observable;
import com.marouaneLasmak.interfaces.Observer;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Agent implements Observer, Observable {
    private String id;
    private String name;
    private LocalDateTime dateTime;
    private List<Transaction> transactions = new ArrayList<>();
    private List<Observer> observers = new ArrayList<>();

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(Transaction transaction) {
        observers.forEach(observer -> observer.update(this.name, transaction));
    }

    @Override
    public void update(String name, Transaction transaction) {
        System.out.println("Agent " + name + " sending notification to " + this.name);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
