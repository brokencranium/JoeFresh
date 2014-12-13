package com.vv.buildstuff.joefresh.responsePlaces;

/**
 * Created by vvennava on 10/11/14.
 */
public class AltIDs {
    private String place_id;
    private String scope;

    public AltIDs() {
    }

    public AltIDs(String place_id, String scope) {
        this.place_id = place_id;
        this.scope = scope;
    }

    public String getPlace_id() {
        return place_id;
    }

    public void setPlace_id(String place_id) {
        this.place_id = place_id;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }
}
