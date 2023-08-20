package ru.pio.aclij;

import ru.pio.aclij.models.Driver;
import ru.pio.aclij.models.Vehicle;
import ru.pio.aclij.services.service.DriverService;
import ru.pio.aclij.services.ModelServiceFactory;

public class App
{
    public static void main( String[] args )
    {
        ModelServiceFactory factory = new ModelServiceFactory();
        Vehicle vehicle = new Vehicle(
                "Mazda",
                "A5",
                "HDA41D");
        Driver driver = new Driver(
                "Host",
                "hd231as",
                5,
                vehicle,
                "Kazan",
                false
        );
        Vehicle newVehicle = new Vehicle(
                "Noam",
                "C1",
                "MAD15G"
        );
        DriverService driverService = factory.getDriverSession();
        try{
            driverService.begin();

            driverService.changeVehicleRegistration(driver, newVehicle);

            driverService.commit();
        } finally {
            driverService.close();
        }


    }
}
