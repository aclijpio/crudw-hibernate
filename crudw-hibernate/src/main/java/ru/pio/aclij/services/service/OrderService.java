package ru.pio.aclij.services.service;

import org.hibernate.Session;
import ru.pio.aclij.models.Client;
import ru.pio.aclij.services.service.ModelService;

public class OrderService extends ModelService {

    public OrderService(Session session) {
        super(session);
    }

    DriverService driverService;
    Client client;

}
