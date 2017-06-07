package com.example.greenglobal.greenhousemonitor.model;

import android.bluetooth.BluetoothDevice;

import com.example.greenglobal.greenhousemonitor.R;

import org.parceler.Parcel;

@Parcel
public class BluetoothDeviceWrapper {

    BluetoothDevice device;

    int signalStrength;

    boolean isInOtapMode;

    public BluetoothDevice getDevice() {
        return device;
    }

    public void setDevice(BluetoothDevice device) {
        this.device = device;
    }

    public int getSignalStrength() {
        /*
        NOT IMPLEMENTED
        if (signalStrength > -50.0) {
            return R.drawable.ic_signal_strength_5;
        } else if (signalStrength > -60.0) {
            return R.drawable.ic_signal_strength_4;
        } else if (signalStrength > -70.0) {
            return R.drawable.ic_signal_strength_3;
        } else if (signalStrength > -80.0) {
            return R.drawable.ic_signal_strength_2;
        } else {
            return R.drawable.ic_signal_strength_1;
        }
        */
        return -1;
    }

    public void setSignalStrength(int signalStrength) {
        this.signalStrength = signalStrength;
    }

    public boolean isInOtapMode() {
        return isInOtapMode;
    }

    public void setInOtapMode(boolean inOtapMode) {
        isInOtapMode = inOtapMode;
    }

    @Override
    public String toString() {
        return "BluetoothDeviceWrapper{" +
                "device=" + device +
                ", signalStrength=" + signalStrength +
                ", isInOtapMode=" + isInOtapMode +
                '}';
    }
}

