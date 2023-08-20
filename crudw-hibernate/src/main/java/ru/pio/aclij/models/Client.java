package ru.pio.aclij.models;

import lombok.Data;
import lombok.Getter;
import ru.pio.aclij.GeoPoint;
@Getter
public class Client implements Model{
    private final User user;
    private final GeoPoint startLocation;
    private final GeoPoint endLocation;
    String city;

    public Client(User user, GeoPoint startLocation, GeoPoint endLocation,  String city) {
        this.user = user;
        this.startLocation = startLocation;
        this.endLocation = endLocation;
        this.city = city;
    }
}
