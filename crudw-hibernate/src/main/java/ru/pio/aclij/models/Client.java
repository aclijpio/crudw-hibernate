package ru.pio.aclij.models;

import jakarta.persistence.*;

@Entity
@Table(name = "clients")
public class Client implements Model{
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "address")
    private String address;



}
