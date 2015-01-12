package com.vv.buildstuff.joefresh.responsePlaces;


import com.vv.buildstuff.joefresh.util.LatLongLoc;

/**
 * Created by vvennava on 10/11/14.
 */
public class Geometry {
    private LatLongLoc location;

    public Geometry() {
    }

    public Geometry(LatLongLoc location) {
        this.location = location;
    }

    public LatLongLoc getLocation() {
        return location;
    }

    public void setLocation(LatLongLoc location) {
        this.location = location;
    }
}
