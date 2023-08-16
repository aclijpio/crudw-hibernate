package ru.pio.aclij.services;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.pio.aclij.models.Driver;
import ru.pio.aclij.models.Vehicle;

public class VehicleRegistration {

    Session session;
    Transaction tx = null;
    public VehicleRegistration(Session session) {
        this.session = session;
    }

    private void commitNewVehicle(Vehicle newVehicle){
        this.tx = this.session.beginTransaction();
        session.merge(newVehicle);
        this.tx.commit();
    }
    private void updateDriver(Driver driver, Vehicle newVehicle){
        this.tx = this.session.beginTransaction();
        driver.setVehicle(newVehicle);
        session.merge(driver);
        tx.commit();
    }
    public void deleteOldVehicle(Vehicle oldVehicle){
        this.tx = session.beginTransaction();
        session.remove(oldVehicle);
        tx.commit();
    }
    public void transactionRollbackIf(){
        if(tx != null && tx.isActive())
            tx.rollback();
    }
}
