package com.marouaneLasmak.implementation;

import com.marouaneLasmak.interfaces.HDMI;

public class HDMIImpl implements HDMI {
    @Override
    public void display(String message) {
        System.out.println("HDMI Display: \n" + message);
    }
}
