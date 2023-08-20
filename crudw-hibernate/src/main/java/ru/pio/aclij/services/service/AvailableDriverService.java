package ru.pio.aclij.services.service;

import jakarta.persistence.criteria.CriteriaQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.pio.aclij.GeoPoint;
import ru.pio.aclij.models.AvailableDriver;
import ru.pio.aclij.models.Client;
import ru.pio.aclij.models.Driver;

import java.util.List;

public class AvailableDriverService extends ModelService<AvailableDriver>{
    public AvailableDriverService(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
    public List<AvailableDriver> getAvailableDriverWithCity(String city){
        return super.findAllFromColumn(AvailableDriver.class, "city", city);
    }
    public List<AvailableDriver> getAvailableAllDrivers(){
        return super.findAll(AvailableDriver.class);
    }
    private static double haversineDistance(GeoPoint point1, GeoPoint point2) {
        double earthRadius = 6371; // Earth's radius in kilometers
        double dLat = Math.toRadians(point2.latitude - point1.latitude);
        double dLon = Math.toRadians(point2.longitude - point1.longitude);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                Math.cos(Math.toRadians(point1.latitude)) * Math.cos(Math.toRadians(point2.latitude)) *
                        Math.sin(dLon / 2) * Math.sin(dLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return earthRadius * c;
    }
    public Driver getNearestDriver(Client client) {
        double minDistance = Double.MAX_VALUE;
        Driver nearestDriver = null;
        GeoPoint targetPoint = client.getStartLocation();
        List<AvailableDriver> availableDrivers = getAvailableDriverWithCity(client.getCity());
        for (AvailableDriver ad : availableDrivers) {
            double distance = haversineDistance(targetPoint, ad.getGeoPoint());
            if (distance < minDistance) {
                minDistance = distance;
                nearestDriver = ad.getDriver();
            }
        }
        return nearestDriver;
    }
}
