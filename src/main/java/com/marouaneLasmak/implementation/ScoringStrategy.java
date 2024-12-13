package com.marouaneLasmak.implementation;

import com.marouaneLasmak.interfaces.Strategy;

public class ScoringStrategy implements Strategy {
    private double score;

    @Override
    public void operationStrategy(Transaction transaction) {
        if(transaction.getType().equals(TransactionType.Vente)) {
            score += transaction.getAmount();
        } else if(transaction.getType().equals(TransactionType.Achat)) {
            score -= transaction.getAmount();
        }
        System.out.println("new amount is: " + score);
    }
}
