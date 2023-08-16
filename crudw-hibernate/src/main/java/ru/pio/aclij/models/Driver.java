package ru.pio.aclij.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "drivers")
public class Driver implements Model {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "license_number")
    private String licenseNumber;
    @Column(name = "experience_years")
    private int experienceYears;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "vehicle_id", referencedColumnName = "id")
    @Setter @Getter private Vehicle vehicle;

    public Driver(String name, String licenseNumber, int experienceYears, Vehicle vehicle) {
        this.name = name;
        this.licenseNumber = licenseNumber;
        this.experienceYears = experienceYears;
        this.vehicle = vehicle;
    }

    public Driver() {

    }
}

