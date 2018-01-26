package agh.cs.airly;

public class Location {

    private String longtitude;
    private String latitude;

    public Location (String longtitude, String latitude) {
        this.longtitude = longtitude;
        this.latitude = latitude;
    }


    public String getLongtitude() { return longtitude; }
    public String getLatitude() { return latitude; }

}
