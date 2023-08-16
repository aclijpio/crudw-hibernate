package ru.pio.aclij.services;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.pio.aclij.models.Client;
import ru.pio.aclij.models.Driver;
import ru.pio.aclij.models.Order;
import ru.pio.aclij.models.Vehicle;
import ru.pio.aclij.services.service.DriverService;
import ru.pio.aclij.services.service.OrderService;

public class ModelServiceFactory{
    private final static Configuration configuration = new Configuration()
            .addAnnotatedClass(Order.class)
            .addAnnotatedClass(Client.class)
            .addAnnotatedClass(Driver.class)
            .addAnnotatedClass(Vehicle.class);
    private final static SessionFactory sessionFactory = configuration.buildSessionFactory();

    public OrderService getOrderSession() {
        return new OrderService(sessionFactory.openSession());
    }
    public DriverService getDriverSession(){
        return new DriverService(sessionFactory.openSession());
    }

    public final void close() {
        sessionFactory.close();
    }
}
