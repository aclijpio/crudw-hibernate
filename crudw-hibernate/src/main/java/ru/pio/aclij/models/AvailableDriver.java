package ru.pio.aclij.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ru.pio.aclij.GeoPoint;
@Getter
@Table(name = "available_drivers")
@NoArgsConstructor
@Entity
public class AvailableDriver implements Model{
    @Id
    private int id;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "driver_id", referencedColumnName = "id")
    Driver driver;
    @Column(name = "latitude")
    int latitude;
    @Column(name = "longitude")
    int longitude;
    @Column(name = "city")
    String city;

    public AvailableDriver(Driver driver, int latitude, int longitude) {
        this.id = driver.getId();
        this.driver = driver;
        this.latitude = latitude;
        this.longitude = longitude;
        this.city = driver.getCity();
    }

    public GeoPoint getGeoPoint(){
        return new GeoPoint(latitude, longitude);
    }

}