package ru.pio.aclij.models;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "orders")
public class Order implements Model {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "order_date")
    private Timestamp orderDate;
    @Column(name = "start_location")
    private String startLocation;
    @Column(name = "end_location")
    private String endLocation;
    @Column(name = "status")
    private String status;
    @OneToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private User user;
    @OneToOne
    @JoinColumn(name = "driver_id", referencedColumnName = "id")
    private Driver driver;

    public Order(Timestamp orderDate, String startLocation, String endLocation, String status, User user, Driver driver) {
        this.orderDate = orderDate;
        this.startLocation = startLocation;
        this.endLocation = endLocation;
        this.status = status;
        this.user = user;
        this.driver = driver;
    }

    public Order() {

    }
}
