package com.marouaneLasmak.implementation;

import com.marouaneLasmak.interfaces.HDMI;

public class VGAtoHDMIAdapter implements HDMI {
    private VGA vgaDisplay;

    public VGAtoHDMIAdapter(VGA vgaDisplay) {
        this.vgaDisplay = vgaDisplay;
    }

    @Override
    public void display(String message) {
        vgaDisplay.show(message);
    }
}
