package com.vv.buildstuff.joefresh.requestPlaces;

import com.google.gson.Gson;
import com.vv.buildstuff.joefresh.responsePlaces.ResponsePlacesNearbySearch;
import com.vv.buildstuff.joefresh.responsePlaces.Results;
import com.vv.buildstuff.joefresh.util.Miscellaneous;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by vvennava on 10/11/14.
 */
public class RequestPlacesNearbySearch {
    private String urlString;

    private String latLongText;
    private String radius;

    private String keyword;
    private String language;
    private String minprice;
    private String maxprice;
    private String name;
    private String opennow;
    private String rankby;
    private String types;
    private String pagetoken;
    private String zagatseleted;


    public RequestPlacesNearbySearch() {
    }

    public ArrayList<Results> getPlacesResponse() {
        ResponsePlacesNearbySearch search = null;
        Reader reader = null;
        HttpsURLConnection urlConnection = null;
        URL url = null;
        try {
            url = new URL(urlString);
            urlConnection = (HttpsURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

            search = readInputStream(reader);
        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {

                reader.close();
                urlConnection.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return search.getResults();
    }


    private ResponsePlacesNearbySearch readInputStream(Reader reader) {
        Gson gson = new Gson();
        return gson.fromJson(reader, ResponsePlacesNearbySearch.class);
    }


    public String getUrlString() {
        return urlString;
    }

    public void setUrlString() {
        this.urlString = urlBuilder();
    }

    private String urlBuilder() {
        if (this.latLongText == null) {
            this.latLongText = Miscellaneous.DEFAULT_LOCATION.getText();
        }

        if (this.radius == null) {
            this.radius = Miscellaneous.RADIUS.getText();
        }

        if (this.types == null) {
            this.types = Miscellaneous.TYPES.getText();
        }

        if (this.name == null) {
            this.name = Miscellaneous.NAME.getText();
        }


        StringBuilder urlBuilder = new StringBuilder();
        final String urlValue = urlBuilder.append(Miscellaneous.NEARBY_SEARCH_URL)
                .append(latLongText)
                .append("&radius=")
                .append(radius)
//                .append("&types=")
//                .append(types)
                .append("&name=")
                .append(name)
                .append("&key=")
                .append(Miscellaneous.KEY).toString();
        System.out.println(urlValue);
        return urlValue;
    }

    public String getLatLongText() {
        return latLongText;
    }

    public void setLatLongText(String latLongText) {
        this.latLongText = latLongText;
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

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
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
        this.name = name.replaceAll("\\s", "+");
    }

    public String getOpennow() {
        return opennow;
    }

    public void setOpennow(String opennow) {
        this.opennow = opennow;
    }

    public String getRankby() {
        return rankby;
    }

    public void setRankby(String rankby) {
        this.rankby = rankby;
    }

    public String getTypes() {
        return types;
    }

    public void setTypes(String types) {
        this.types = types;
    }

    public String getPagetoken() {
        return pagetoken;
    }

    public void setPagetoken(String pagetoken) {
        this.pagetoken = pagetoken;
    }

    public String getZagatseleted() {
        return zagatseleted;
    }

    public void setZagatseleted(String zagatseleted) {
        this.zagatseleted = zagatseleted;
    }
}
