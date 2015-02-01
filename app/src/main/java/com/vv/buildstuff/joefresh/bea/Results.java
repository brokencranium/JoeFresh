package com.vv.buildstuff.joefresh.bea;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by vvennava on 1/25/15.
 */
public class Results {
    @SerializedName("Statistic")
    private String statistic;

    @SerializedName("UnitOfMeasure")
    private String unitOfMeasure;

    @SerializedName("PublicTable")
    private String publicTable;

    @SerializedName("UTCProductionTime")
    private String time;

    @SerializedName("NoteRef")
    private String noteRef;


    @SerializedName("Dimensions")
    private ArrayList<Dimensions> dimension;

    @SerializedName("Data")
    private ArrayList<Data> data;

    @SerializedName("Notes")
    private ArrayList<Notes> notes;

    public Results() {
    }

    public Results(String statistic, String unitOfMeasure, String publicTable,
                   String time, String noteRef, ArrayList<Dimensions> dimension,
                   ArrayList<Data> data, ArrayList<Notes> notes) {
        this.statistic = statistic;
        this.unitOfMeasure = unitOfMeasure;
        this.publicTable = publicTable;
        this.time = time;
        this.noteRef = noteRef;
        this.dimension = dimension;
        this.data = data;
        this.notes = notes;
    }

    public String getStatistic() {
        return statistic;
    }

    public void setStatistic(String statistic) {
        this.statistic = statistic;
    }

    public String getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public void setUnitOfMeasure(String unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }

    public String getPublicTable() {
        return publicTable;
    }

    public void setPublicTable(String publicTable) {
        this.publicTable = publicTable;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getNoteRef() {
        return noteRef;
    }

    public void setNoteRef(String noteRef) {
        this.noteRef = noteRef;
    }

    public ArrayList<Dimensions> getDimension() {
        return dimension;
    }

    public void setDimension(ArrayList<Dimensions> dimension) {
        this.dimension = dimension;
    }

    public ArrayList<Data> getData() {
        return data;
    }

    public void setData(ArrayList<Data> data) {
        this.data = data;
    }

    public ArrayList<Notes> getNotes() {
        return notes;
    }

    public void setNotes(ArrayList<Notes> notes) {
        this.notes = notes;
    }
}
