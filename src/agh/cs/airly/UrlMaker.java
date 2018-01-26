package agh.cs.airly;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class UrlMaker {

    private static final String basicURL = "https://airapi.airly.eu/v1/";


    public URL createURL (HashMap<Options, String> hashMap, Location location, Sensor sensor)
            throws MalformedURLException
    {

        StringBuilder finalURL = new StringBuilder(basicURL);
        if (hashMap.containsKey(Options.sensorID)) {
            finalURL.append("sensor/measurements?sensorId=" + sensor.getSensorID() );
        }
        else if (hashMap.containsKey(Options.longitude) && hashMap.containsKey(Options.latitude)) {
            finalURL.append("mapPoint/measurements?latitude=" + location.getLatitude());
            finalURL.append("&longitude=" + location.getLongtitude());
        }

        //  System.out.println(finalURL.toString());
        return new URL( finalURL.toString() );

    }

}
