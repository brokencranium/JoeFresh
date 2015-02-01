package com.vv.buildstuff.joefresh.bea;

import com.google.gson.annotations.SerializedName;

/**
 * Created by vvennava on 1/25/15.
 */
public class BEAAPI {
@SerializedName("Request")
    private Request request;

@SerializedName("Results")
    private Results results;
    public BEAAPI() {
    }

    public BEAAPI(Request request, Results results) {
        this.request = request;
        this.results = results;
    }

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public Results getResults() {
        return results;
    }

    public void setResults(Results results) {
        this.results = results;
    }
}
