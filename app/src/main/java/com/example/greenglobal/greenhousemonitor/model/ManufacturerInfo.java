package com.example.greenglobal.greenhousemonitor.model;

import org.parceler.Parcel;

@Parcel
public class ManufacturerInfo {
    public String manufacturer;
    public String hardwareRevision;
    public String firmwareRevision;

    @Override
    public String toString() {
        return "ManufacturerInfo{" +
                "manufacturer='" + manufacturer + '\'' +
                ", hardwareRevision='" + hardwareRevision + '\'' +
                ", firmwareRevision='" + firmwareRevision + '\'' +
                '}';
    }
}
