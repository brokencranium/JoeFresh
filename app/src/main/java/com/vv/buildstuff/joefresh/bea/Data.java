package com.vv.buildstuff.joefresh.bea;

import com.google.gson.annotations.SerializedName;

/**
 * Created by vvennava on 1/25/15.
 */
public class Data {
    @SerializedName("GeoFips")
    private String geoFips;

    @SerializedName("GeoName")
    private String geoName;

    @SerializedName("Code")
    private String code;

    @SerializedName("TimePeriod")
    private String timePeriod;

    @SerializedName("CL_UNIT")
    private String clUnit;

    @SerializedName("UNIT_MULTI")
    private short unitMulti;

    @SerializedName("DataValue")
    private String dataValue;

    @SerializedName("NoteRef")
    private String noteRef;

    public Data() {
    }

    public Data(String geoFips, String geoName, String code, String timePeriod, String clUnit,
                 short unitMulti, String dataValue, String noteRef) {
        this.geoFips = geoFips;
        this.geoName = geoName;
        this.code = code;
        this.timePeriod = timePeriod;
        this.clUnit = clUnit;
        this.unitMulti = unitMulti;
        this.dataValue = dataValue;
        this.noteRef = noteRef;
    }

    public String getGeoFips() {
        return geoFips;
    }

    public void setGeoFips(String geoFips) {
        this.geoFips = geoFips;
    }

    public String getGeoName() {
        return geoName;
    }

    public void setGeoName(String geoName) {
        this.geoName = geoName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTimePeriod() {
        return timePeriod;
    }

    public void setTimePeriod(String timePeriod) {
        this.timePeriod = timePeriod;
    }

    public String getClUnit() {
        return clUnit;
    }

    public void setClUnit(String clUnit) {
        this.clUnit = clUnit;
    }

    public short getUnitMulti() {
        return unitMulti;
    }

    public void setUnitMulti(short unitMulti) {
        this.unitMulti = unitMulti;
    }

    public String getDataValue() {
        return dataValue;
    }

    public void setDataValue(String dataValue) {
        this.dataValue = dataValue;
    }

    public String getNoteRef() {
        return noteRef;
    }

    public void setNoteRef(String noteRef) {
        this.noteRef = noteRef;
    }
}
