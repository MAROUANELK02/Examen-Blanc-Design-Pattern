package com.marouaneLasmak.implementation;

import com.marouaneLasmak.aop.Cachable;
import com.marouaneLasmak.aop.Log;
import com.marouaneLasmak.interfaces.Observable;
import com.marouaneLasmak.interfaces.Observer;
import com.marouaneLasmak.interfaces.Strategy;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Agent implements Observer, Observable {
    private String id;
    private String name;
    private LocalDateTime dateTime;
    private List<Transaction> transactions = new ArrayList<>();
    private List<Observer> observers = new ArrayList<>();
    private Strategy strategy;
    private double balance;

    public Agent() {
    }

    public Agent(String name, Strategy strategy) {
        this.name = name;
        this.strategy = strategy;
        id = UUID.randomUUID().toString();
        dateTime = LocalDateTime.now();
    }

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
        strategy.operationStrategy(transaction);
    }

    @Cachable
    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
        notifyObservers(transaction);
    }

    public void showTransactions() {
        transactions.forEach(System.out::println);
    }

    @Cachable
    @Log
    public Transaction maxTransactionAmount() {
        return transactions.stream()
                .max((t1, t2) -> (int) (t1.getAmount() - t2.getAmount()))
                .orElse(null);
    }

    @Override
    public String toString() {
        return "Agent{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", dateTime=" + dateTime +
                ", transactions=" + transactions +
                ", balance=" + balance +
                '}';
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

    public Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
