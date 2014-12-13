package com.vv.buildstuff.joefresh.responsePlaces;

import java.util.ArrayList;

/**
 * Created by vvennava on 10/11/14.
 */
public class Results {
    private Geometry geometry;
    private String icon;
    private String id;
    private String name;
    private OpeningHours opening_hours;
    private String place_id;
    private short price_level;
    private float rating;
    private String reference;
    private String scope;
    private ArrayList<String> types;
    private String vicinity;
    private ArrayList<Photosvv> photos;
    private ArrayList<AltIDs> alt_ids;
    private String formatted_address;


    public Results() {
    }

    public Results(String icon, String place_id, Geometry geometry,
                   String name, OpeningHours opening_hours, ArrayList<Photosvv> photos,
                   String scope, ArrayList<AltIDs> alt_ids, short price_level,
                   float rating, ArrayList<String> types, String vicinity, String formatted_address) {
        this.icon = icon;
        this.place_id = place_id;
        this.geometry = geometry;
        this.name = name;
        this.opening_hours = opening_hours;
        this.photos = photos;
        this.scope = scope;
        this.alt_ids = alt_ids;
        this.price_level = price_level;
        this.rating = rating;
        this.types = types;
        this.vicinity = vicinity;
        this.formatted_address = formatted_address;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getPlace_id() {
        return place_id;
    }

    public void setPlace_id(String place_id) {
        this.place_id = place_id;
    }

    public Geometry getGeometry() {
        return geometry;
    }

    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public OpeningHours getOpening_hours() {
        return opening_hours;
    }

    public void setOpening_hours(OpeningHours opening_hours) {
        this.opening_hours = opening_hours;
    }

    public ArrayList<Photosvv> getPhotos() {
        return photos;
    }

    public void setPhotos(ArrayList<Photosvv> photos) {
        this.photos = photos;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public ArrayList<AltIDs> getAlt_ids() {
        return alt_ids;
    }

    public void setAlt_ids(ArrayList<AltIDs> alt_ids) {
        this.alt_ids = alt_ids;
    }

    public short getPrice_level() {
        return price_level;
    }

    public void setPrice_level(short price_level) {
        this.price_level = price_level;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public ArrayList<String> getTypes() {
        return types;
    }

    public void setTypes(ArrayList<String> types) {
        this.types = types;
    }

    public String getVicinity() {
        return vicinity;
    }

    public void setVicinity(String vicinity) {
        this.vicinity = vicinity;
    }

    public String getFormatted_address() {
        return formatted_address;
    }

    public void setFormatted_address(String formatted_address) {
        this.formatted_address = formatted_address;
    }
}
