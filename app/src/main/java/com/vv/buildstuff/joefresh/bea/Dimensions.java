package com.vv.buildstuff.joefresh.bea;

import com.google.gson.annotations.SerializedName;

/**
 * Created by vvennava on 1/25/15.
 */
public class Dimensions {
    @SerializedName("Ordinal")
    private int ordinal;

    @SerializedName("Name")
    private String name;

    @SerializedName("IsValue")
    private short isValue;


    public Dimensions() {
    }

    public Dimensions(int ordinal, String name, short isValue) {
        this.ordinal = ordinal;
        this.name = name;
        this.isValue = isValue;
    }

    public int getOrdinal() {
        return ordinal;
    }

    public void setOrdinal(int ordinal) {
        this.ordinal = ordinal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public short getIsValue() {
        return isValue;
    }

    public void setIsValue(short isValue) {
        this.isValue = isValue;
    }
}
