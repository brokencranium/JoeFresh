package com.vv.buildstuff.joefresh.list;

import com.google.android.gms.maps.model.Marker;

/**
 * Created by vvennava on 12/27/14.
 */
public class Model {

    private String name;
    private boolean selected;
    private Marker marker;

    public Marker getMarker() {
        return marker;
    }

    public void setMarker(Marker marker) {
        this.marker = marker;
    }

    public Model(String name) {
        this.name = name;
        selected = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public void setToggle() {
        this.selected = ( this.selected == true ) ? false : true;
    }
}
