package com.marouaneLasmak.implementation;

import com.marouaneLasmak.interfaces.Strategy;

import java.util.ArrayList;
import java.util.List;

public class HistoryStrategy implements Strategy {
    List<Transaction> transactions = new ArrayList<>();

    @Override
    public void operationStrategy(Transaction transaction) {
        transactions.add(transaction);
        System.out.println("Transaction added to history" + transaction);
    }
}
