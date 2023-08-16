package ru.pio.aclij.models;

import jakarta.persistence.*;

@Entity
@Table(name = "vehicles")
public class Vehicle implements Model{

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "brand")
    private String brand;
    @Column(name = "model")
    private String model;
    @Column(name = "license_plate")
    private String licensePlate;

    public Vehicle(String brand, String model, String licensePlate) {
        this.brand = brand;
        this.model = model;
        this.licensePlate = licensePlate;
    }
    public Vehicle() {

    }
}
