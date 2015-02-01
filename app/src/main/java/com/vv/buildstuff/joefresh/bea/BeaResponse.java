package com.vv.buildstuff.joefresh.bea;

import com.google.gson.annotations.SerializedName;

/**
 * Created by vvennava on 1/24/15.
 */
public class BeaResponse {

    @SerializedName("BEAAPI")
    private BEAAPI beaapi;



    public BeaResponse() {
    }

    public BeaResponse(BEAAPI beaapi) {
        this.beaapi = beaapi;
    }

    public BEAAPI getBeaapi() {
        return beaapi;
    }

    public void setBeaapi(BEAAPI beaapi) {
        this.beaapi = beaapi;
    }
}
