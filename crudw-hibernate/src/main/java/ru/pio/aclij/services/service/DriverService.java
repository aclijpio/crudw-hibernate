package ru.pio.aclij.services.service;

import org.hibernate.Session;
import ru.pio.aclij.models.Driver;
import ru.pio.aclij.models.Vehicle;

public class DriverService extends ModelService<Driver> {

    public DriverService(Session session) {
        super(session);
    }
    public void updateDriverVehicle(Driver driver, Vehicle newVehicle){
        driver.setVehicle(newVehicle);
        session.merge(driver);
    }
}
