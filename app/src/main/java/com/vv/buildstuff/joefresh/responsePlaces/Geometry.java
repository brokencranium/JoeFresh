package com.vv.buildstuff.joefresh.responsePlaces;


import com.vv.buildstuff.joefresh.util.LatLong;

/**
 * Created by vvennava on 10/11/14.
 */
public class Geometry {
    private LatLong location;

    public Geometry() {
    }

    public Geometry(LatLong location) {
        this.location = location;
    }

    public LatLong getLocation() {
        return location;
    }

    public void setLocation(LatLong location) {
        this.location = location;
    }
}
