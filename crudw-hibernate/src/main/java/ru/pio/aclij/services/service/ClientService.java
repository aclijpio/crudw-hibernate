package ru.pio.aclij.services.service;

import org.hibernate.SessionFactory;
import ru.pio.aclij.GeoPoint;
import ru.pio.aclij.models.Client;
import ru.pio.aclij.models.User;
import ru.pio.aclij.models.Order;

public class ClientService extends ModelService<User>{
    public ClientService(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public Order getOrder(Client client){
        OrderService service = new OrderService(this.sessionFactory);
        return service.createOrder(client);
    }
    public void closeOrder(){
        // If...:
        // Order stand around 5 min
    }
}
