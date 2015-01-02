package com.vv.buildstuff.joefresh.util;

/**
 * Created by vvennava on 10/11/14.
 */
public enum Miscellaneous {

    NEARBY_SEARCH_URL("https://maps.googleapis.com/maps/api/place/nearbysearch/json?location="),
    KEY("AIzaSyDSeKfurM8gqRX0M4Z8zh0MhOxiqE01Tdo"),
    TYPES("food|cafe"),
    DEFAULT_LOCATION("47.673401,-122.342598"),
    DEFAULT_LATITUDE("47.673401"),
    DEFAULT_LONGITUDE("-122.342598"),
    RADIUS("20000"),
    NAME("Joe Fresh"),
    DEFAULT_DESTINATION("47.6063683,-122.3322218");


    private final String value;

    Miscellaneous(String value) {
        this.value = value;
    }

    public String getText() {
        return value;
    }

    /* (non-Javadoc)
         * @see java.lang.Enum#toString()
         */
    @Override
    public String toString() {
        return value;
    }

}
