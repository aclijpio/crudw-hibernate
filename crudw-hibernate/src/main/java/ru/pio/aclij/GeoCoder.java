package ru.pio.aclij;

import com.google.code.geocoder.Geocoder;
import com.google.code.geocoder.model.*;

import java.io.IOException;
import java.io.PipedOutputStream;
import java.util.ArrayList;
import java.util.List;

public class GeoCoder {

    public static List<String> getAddress(GeoPoint ... points ) throws IOException {
        Geocoder geocoder = new Geocoder();
        List<String> addresses = new ArrayList<>();
        for (GeoPoint point :
                points) {
            LatLng location = new LatLng(
                    String.valueOf(point.latitude),
                    String.valueOf(point.longitude));

            GeocoderRequest request = new GeocoderRequest();
            request.setLocation(location);
            GeocodeResponse response = geocoder.geocode(request);

            if (response.getStatus() == GeocoderStatus.OK && !response.getResults().isEmpty()) {
                GeocoderResult result = response.getResults().get(0);
                addresses.add(result.getFormattedAddress());
            }

        }
        return  addresses;
    }

}
