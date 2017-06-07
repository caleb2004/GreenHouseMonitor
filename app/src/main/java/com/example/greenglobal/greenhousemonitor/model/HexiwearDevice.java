package com.example.greenglobal.greenhousemonitor.model;

import com.wolkabout.wolk.Device;

import java.io.Serializable;


public class HexiwearDevice extends Device implements Serializable {

    private String deviceName;
    private String deviceAddress;
    private String wolkName;

    public HexiwearDevice() {}

    public HexiwearDevice(String deviceName, String deviceSerial, String deviceAddress, String devicePassword, String wolkName) {
        this.deviceName = deviceName;
        this.serialId = deviceSerial;
        this.deviceAddress = deviceAddress;
        this.wolkName = wolkName;
        this.password = devicePassword;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public String getDeviceSerial() {
        return serialId;
    }

    public String getDeviceAddress() {
        return deviceAddress;
    }

    public String getWolkName() {
        return wolkName;
    }

    public String getDevicePassword() {
        return password;
    }

    @Override
    public String toString() {
        return "HexiwearDevice{" +
                "deviceName='" + deviceName + '\'' +
                ", deviceSerial='" + serialId + '\'' +
                ", deviceAddress='" + deviceAddress + '\'' +
                ", devicePassword='" + password + '\'' +
                ", wolkName='" + wolkName + '\'' +
                '}';
    }
}
