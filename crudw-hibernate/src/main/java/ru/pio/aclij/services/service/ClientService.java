package ru.pio.aclij.services.service;

import org.hibernate.Session;

public class ClientService extends ModelService{
    public ClientService(Session session) {
        super(session);
    }
}
