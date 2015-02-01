package com.vv.buildstuff.joefresh.bea;

import com.google.gson.Gson;
import com.vv.buildstuff.joefresh.util.Miscellaneous;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by vvennava on 1/24/15.
 */
public class BeaRequest {

    private HttpURLConnection urlConnection;
    private URL url;

    private String methodName;
    private String dataSetName;
    private String keyCode;
    private String geoFips;
    private String year;
    private String format;


    public BeaRequest() {
//        this.urlString = "http://www.bea.gov/api/data?" +
//                         "&UserID=A35BA6D3-5AF1-43B1-969E-ADD74A11A174" +
//                         "&method=GetData" +
//                         "&datasetname=RegionalData" +
//                         "&KeyCode=PCPI_CI" +
//                         "&GeoFIPS=STATE" +
//                         "&Year=2013" +
//                         "&ResultFormat=JSON&";
         }


    public BeaRequest(String methodName, String dataSetName, String keyCode,
                      String geoFips, String year, String format) {
        this.methodName = methodName;
        this.dataSetName = dataSetName;
        this.keyCode = keyCode;
        this.geoFips = geoFips;
        this.year = year;
        this.format = format;
    }

    public String buildUrlString(){
        StringBuilder sb = new StringBuilder();
        if(methodName == null){
            methodName = Miscellaneous.BEA_METHOD_NAME.toString();
        }
        if(dataSetName == null){
           dataSetName = Miscellaneous.BEA_DATASET_REGIONAL.toString();
        }

        if(keyCode == null){
           keyCode = Miscellaneous.BEA_KEY_CODE_PCPI_CI.toString();
        }

        if(geoFips == null){
            geoFips = Miscellaneous.BEA_GEOFIPS_COUNTY.toString();
        }

        if(year == null){
           year = Miscellaneous.BEA_DEFAULT_YEAR.toString();
        }

        if(format == null){
            format = Miscellaneous.BEA_DATA_FORMAT.toString();
        }


        sb.append(Miscellaneous.BEA_URL.toString())
          .append("&UserID=")
          .append(Miscellaneous.BEA_KEY.toString())
          .append("&method=")
          .append(methodName)
          .append("&datasetname=")
          .append(dataSetName)
          .append("&KeyCode=")
          .append(keyCode)
          .append("&GeoFIPS=")
          .append(geoFips)
          .append("&Year=")
          .append(year)
          .append("&ResultFormat=")
          .append(format)
          .append("&");
        return  sb.toString();
    }

    private BeaResponse readInputStream(Reader reader) {
        Gson gson = new Gson();
        return gson.fromJson(reader, BeaResponse.class);
    }
    public BeaResponse getBeaResponse() {
        BeaResponse search = null;
        Reader reader = null;
        HttpURLConnection urlConnection = null;
        URL url = null;
        try {
            final String urlString = buildUrlString();
            System.out.println(urlString);
            url = new URL(urlString);
            urlConnection = (HttpURLConnection) url.openConnection();
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
        return search;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getDataSetName() {
        return dataSetName;
    }

    public void setDataSetName(String dataSetName) {
        this.dataSetName = dataSetName;
    }

    public String getKeyCode() {
        return keyCode;
    }

    public void setKeyCode(String keyCode) {
        this.keyCode = keyCode;
    }

    public String getGeoFips() {
        return geoFips;
    }

    public void setGeoFips(String geoFips) {
        this.geoFips = geoFips;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }
}
