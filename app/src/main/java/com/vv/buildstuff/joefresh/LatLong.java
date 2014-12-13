package com.vv.buildstuff.joefresh;

/**
 * Created by vvennava on 10/4/14.
 */
public class LatLong {
    private double lat;
    private double lng;

    public LatLong() {
    }

    public LatLong(double lat, double lng) {
        this.lat = lat;
        this.lng = lng;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    @Override
    public String toString() {
        return "{lat='" + lat +
                ", lng='" + lng + "}";

    }
}

