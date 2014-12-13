package com.vv.buildstuff.joefresh.requestPlaces;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import static com.vv.buildstuff.joefresh.util.UtilityMethods.readJSONInputStream;


/**
 * Created by vvennava on 10/11/14.
 */
public class RequestPlacesRadarSearch {
    private String urlString;
    private HttpsURLConnection urlConnection;
    private URL url;

    private final String key = "IzaSyDSeKfurM8gqRX0M4Z8zh0MhOxiqE01Tdo";
    private String location;
    private String radius;

    private String keyword;
    private String minprice;
    private String maxprice;
    private String name;
    private String opennow;
    private String types;
    private String zagaselected;


    public RequestPlacesRadarSearch() {
        this.urlString = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=" +
                "-33.8670522,151.1957362&radius=5000&types=food|cafe&name=starbucks&key=AIzaSyDSeKfurM8gqRX0M4Z8zh0MhOxiqE01Tdo";
    }

    public void getPlacesResponse() {
        try {
            url = new URL(urlString);
            urlConnection = (HttpsURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            Reader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            InputStream inputStream = new BufferedInputStream(urlConnection.getInputStream());
//         readXMLInputStream(inputStream);
            readJSONInputStream(inputStream);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getRadius() {
        return radius;
    }

    public void setRadius(String radius) {
        this.radius = radius;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getMinprice() {
        return minprice;
    }

    public void setMinprice(String minprice) {
        this.minprice = minprice;
    }

    public String getMaxprice() {
        return maxprice;
    }

    public void setMaxprice(String maxprice) {
        this.maxprice = maxprice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOpennow() {
        return opennow;
    }

    public void setOpennow(String opennow) {
        this.opennow = opennow;
    }

    public String getTypes() {
        return types;
    }

    public void setTypes(String types) {
        this.types = types;
    }

    public String getZagaselected() {
        return zagaselected;
    }

    public void setZagaselected(String zagaselected) {
        this.zagaselected = zagaselected;
    }
}
