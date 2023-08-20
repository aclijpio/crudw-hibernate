package ru.pio.aclij;

import lombok.Getter;
import lombok.Setter;

public class GeoPoint {
    public double latitude;
    public double longitude;

    public GeoPoint(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
