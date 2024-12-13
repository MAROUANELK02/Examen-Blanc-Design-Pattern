package com.marouaneLasmak.interfaces;

import com.marouaneLasmak.implementation.Transaction;

public interface Strategy {
    void operationStrategy(Transaction transaction);
}
