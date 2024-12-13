package com.marouaneLasmak.interfaces;

import com.marouaneLasmak.implementation.Transaction;

public interface Observer {
    void update(String name, Transaction transaction);
}
