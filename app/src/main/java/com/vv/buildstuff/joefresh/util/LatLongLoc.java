package com.vv.buildstuff.joefresh.util;

/**
 * Created by vvennava on 10/4/14.
 */
public class LatLongLoc {
    private double lat;
    private double lng;
    private String loc;

    public LatLongLoc() {
    }

    public LatLongLoc(double lat, double lng, String loc) {
        this.lat = lat;
        this.lng = lng;
        this.loc = loc;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
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

