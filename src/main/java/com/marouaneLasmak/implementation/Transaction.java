package com.marouaneLasmak.implementation;

import java.time.LocalDateTime;

public class Transaction {
    private String id;
    private LocalDateTime date;
    private double amount;
    private TransactionType type;

    public Transaction(Builder builder) {
        this.id = builder.id;
        this.date = builder.date;
        this.amount = builder.amount;
        this.type = builder.type;
    }

    public class Builder {
        private String id;
        private LocalDateTime date;
        private double amount;
        private TransactionType type;

        public Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Builder setDate(LocalDateTime date) {
            this.date = date;
            return this;
        }

        public Builder setAmount(double amount) {
            this.amount = amount;
            return this;
        }

        public Builder setType(TransactionType type) {
            this.type = type;
            return this;
        }

        public Transaction build() {
            return new Transaction(this);
        }
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id='" + id + '\'' +
                ", date=" + date +
                ", amount=" + amount +
                ", type=" + type +
                '}';
    }

}
