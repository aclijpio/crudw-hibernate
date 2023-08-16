package ru.pio.aclij.services.service;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.pio.aclij.models.Driver;
import ru.pio.aclij.models.Vehicle;

public class DriverService extends ModelService {

    public DriverService(Session session) {
        super(session);
    }
    public void changeVehicleRegistration(Driver driver, Vehicle newVehicle){
        Vehicle oldVehicle = driver.getVehicle();
        try{
            this.session.merge(newVehicle);
            driver.setVehicle(newVehicle);;
        } finally {
            this.session.remove(oldVehicle);
            this.session.merge(driver);
        }
    }
    private void commitNewVehicle(Vehicle newVehicle){
        Transaction tx = this.session.beginTransaction();
        session.merge(newVehicle);
        tx.commit();
    }
    private void updateDriver(Driver driver, Vehicle newVehicle){
        Transaction tx = this.session.beginTransaction();

    }



}
