package com.vv.buildstuff.joefresh.util;

/**
 * Created by vvennava on 10/11/14.
 */
public enum Miscellaneous {

    BEA_KEY("A35BA6D3-5AF1-43B1-969E-ADD74A11A174"),
    BEA_URL("http://www.bea.gov/api/data?"),
    BEA_METHOD_NAME("GetData"),
    BEA_DATASET_REGIONAL("RegionalData"),
    BEA_KEY_CODE_PCPI_CI("PCPI_CI"),
    BEA_GEOFIPS_COUNTY("COUNTY"),
    BEA_DEFAULT_YEAR("2013"),
    BEA_DATA_FORMAT("JSON"),

    KEY("AIzaSyDSeKfurM8gqRX0M4Z8zh0MhOxiqE01Tdo"),
    NEARBY_SEARCH_URL("https://maps.googleapis.com/maps/api/place/nearbysearch/json?location="),
    TYPES("food|cafe"),
    DEFAULT_LOCATION("40.754116,-73.980921"),
    DEFAULT_LATITUDE("40.754116"),
    DEFAULT_LONGITUDE("-73.980921"),
    RADIUS("20000"),
    NAME("Joe+Fresh"),
    DEFAULT_DESTINATION("40.754116,-73.980921");


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
