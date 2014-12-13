package com.vv.buildstuff.joefresh.responsePlaces;

/**
 * Created by vvennava on 10/11/14.
 */
public class OpeningHours {
    private Boolean open_now;

    public OpeningHours(Boolean open_now) {
        this.open_now = open_now;
    }

    public OpeningHours() {
    }


    public Boolean getOpen_now() {
        return open_now;
    }

    public void setOpen_now(Boolean open_now) {
        this.open_now = open_now;
    }

}
