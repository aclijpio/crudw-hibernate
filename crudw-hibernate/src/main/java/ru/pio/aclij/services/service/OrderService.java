package ru.pio.aclij.services.service;

import org.hibernate.SessionFactory;
import ru.pio.aclij.GeoCoder;
import ru.pio.aclij.exceptions.FailedResolveAddressException;
import ru.pio.aclij.models.*;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

public class OrderService extends ModelService<Order> {
    private final AvailableDriverService ads = new AvailableDriverService(this.sessionFactory);
    public OrderService(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
    User user;
    public Order createOrder(Client client){
        List<String> addresses;
        try {
            addresses = GeoCoder.getAddress(client.getStartLocation(), client.getEndLocation());
        } catch (IOException e){
            throw new FailedResolveAddressException("Failed to resolve address", e);
        }
        return new Order(Timestamp.from(Instant.now()), addresses.get(0), addresses.get(1), "Statuses.IN_PROGRESS", client.getUser(),ads.getNearestDriver(client));
    }
}
