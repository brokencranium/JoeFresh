package com.vv.buildstuff.joefresh.bea;

import com.google.gson.annotations.SerializedName;

/**
 * Created by vvennava on 1/24/15.
 */
public class Notes {
    @SerializedName("NoteRef")
    private String noteRef;

    @SerializedName("NoteText")
    private String noteText;

    public String getNoteRef() {
        return noteRef;
    }

    public void setNoteRef(String noteRef) {
        this.noteRef = noteRef;
    }

    public String getNoteText() {
        return noteText;
    }

    public void setNoteText(String noteText) {
        this.noteText = noteText;
    }
}
