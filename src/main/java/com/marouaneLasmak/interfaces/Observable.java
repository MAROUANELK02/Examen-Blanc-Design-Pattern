package com.marouaneLasmak.interfaces;

import com.marouaneLasmak.implementation.Transaction;

public interface Observable {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(Transaction transaction);
}
