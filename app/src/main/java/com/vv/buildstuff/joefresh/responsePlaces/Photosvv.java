package com.vv.buildstuff.joefresh.responsePlaces;

import java.util.ArrayList;

/**
 * Created by vvennava on 10/11/14.
 */
public class Photosvv {
    private ArrayList<String> html_attributions;
    private String height;
    private String width;
    private String photo_reference;


    public Photosvv() {
    }

    public Photosvv(ArrayList<String> html_attributions, String height, String width, String photo_reference) {
        this.html_attributions = html_attributions;
        this.height = height;
        this.width = width;
        this.photo_reference = photo_reference;
    }


    public ArrayList<String> getHtml_attributions() {
        return html_attributions;
    }

    public void setHtml_attributions(ArrayList<String> html_attributions) {
        this.html_attributions = html_attributions;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getPhoto_reference() {
        return photo_reference;
    }

    public void setPhoto_reference(String photo_reference) {
        this.photo_reference = photo_reference;
    }
}
