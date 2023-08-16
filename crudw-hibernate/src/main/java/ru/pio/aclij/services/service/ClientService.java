package ru.pio.aclij.services.service;

import org.hibernate.Session;
import ru.pio.aclij.models.Client;
import ru.pio.aclij.models.Order;

public class ClientService extends ModelService<Client>{
    public ClientService(Session session) {
        super(session);
    }

    public void createOrder(){

    }
    public void closeOrder(){
        // If...:
        // Order stand around 5 min
    }


}
