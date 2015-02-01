package com.vv.buildstuff.joefresh.bea;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by vvennava on 1/25/15.
 */
public class Request {
@SerializedName("RequestParam")
private ArrayList<RequestParam> requestParam;

    public Request() {
    }

    public Request(ArrayList<RequestParam> requestParam) {
        this.requestParam = requestParam;
    }


    public ArrayList<RequestParam> getRequestParam() {
        return requestParam;
    }

    public void setRequestParam(ArrayList<RequestParam> requestParam) {
        this.requestParam = requestParam;
    }
}
