package com.vv.buildstuff.joefresh.responsePlaces;

import java.util.ArrayList;

/**
 * Created by vvennava on 10/11/14.
 */
public class ResponsePlacesNearbySearch {
    private String status;
    private ArrayList<String> html_attributions;
    private ArrayList<Results> results;
    private String next_page_token;

    public ResponsePlacesNearbySearch() {
    }

    public ResponsePlacesNearbySearch(String status, ArrayList<Results> results, ArrayList<String> html_attributions, String next_page_token) {
        this.status = status;
        this.results = results;
        this.html_attributions = html_attributions;
        this.next_page_token = next_page_token;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<Results> getResults() {
        return results;
    }

    public void setResults(ArrayList<Results> results) {
        this.results = results;
    }

    public ArrayList<String> getHtml_attributions() {
        return html_attributions;
    }

    public void setHtml_attributions(ArrayList<String> html_attributions) {
        this.html_attributions = html_attributions;
    }

    public String getNext_page_token() {
        return next_page_token;
    }

    public void setNext_page_token(String next_page_token) {
        this.next_page_token = next_page_token;
    }
}
