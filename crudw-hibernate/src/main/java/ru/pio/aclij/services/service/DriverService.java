package ru.pio.aclij.services.service;

import jakarta.persistence.criteria.CriteriaQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.pio.aclij.GeoPoint;
import ru.pio.aclij.models.AvailableDriver;
import ru.pio.aclij.models.Driver;
import ru.pio.aclij.models.Vehicle;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DriverService extends ModelService<Driver> {
    public DriverService(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public void updateDriverVehicle(Driver driver, Vehicle newVehicle){
        Session session = super.openSession();
        driver.setVehicle(newVehicle);
        session.merge(driver);
    }
}
