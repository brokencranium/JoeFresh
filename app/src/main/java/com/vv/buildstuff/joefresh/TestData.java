package com.vv.buildstuff.joefresh;

import com.vv.buildstuff.joefresh.bea.BeaRequest;
import com.vv.buildstuff.joefresh.bea.BeaResponse;
import com.vv.buildstuff.joefresh.requestPlaces.RequestPlacesNearbySearch;
import com.vv.buildstuff.joefresh.responsePlaces.Results;

import java.util.ArrayList;

/**
 * Created by vvennava on 1/7/15.
 */
public class TestData {


    public void testRequestPlacesNearBySearch() {
        RequestPlacesNearbySearch nearbySearch = new RequestPlacesNearbySearch();
        nearbySearch.setUrlString();

        ArrayList<Results> results = nearbySearch.getPlacesResponse();
        for (Results result : results) {
            final double lat = result.getGeometry().getLocation().getLat();
            final double lng = result.getGeometry().getLocation().getLng();
            System.out.println("Latitude: " + lat + " Longitude" + lng + result.getName());
//                final LatLng latLng1 = new LatLng(lat, lng);

        }
    }


        public String getName(){
                    return null;
            }




    public static void main(String[] args) {

        TestData testData = new TestData();
//        testJSON.testBounds();
//        testJSON.testDistance();
//        testJSON.testDuration();
//        testJSON.testSteps();
//        testJSON.testLegs();
//
//        RequestDirections requestDirections =≈se();

//        testJSON.testOrigDestFormatting();
//        System.out.println("This is a test");
//        testData.getDirectionsResponse();
//          testData.testRequestPlacesNearBySearch();
//        testJSON.getDirectionsForTesting();
//        testJSON.getAdURL();

//
//        String name = "First Middle Last";
//        String condense = name.replaceAll("\\s", "+");
//
//        System.out.println("condense" + condense);
//        Map<String, List<TestData>>  listMap = new HashMap<>();
//
//        List<TestData> duplicateValues = new ArrayList();
//
//        listMap.put("Line1",duplicateValues );
//
//        duplicateValues.add(testData);
//        duplicateValues.add(testData);
//
//        listMap.put("Line1",duplicateValues);
//
//        listMap.put("Line2",duplicateValues);
//
//
//        List duplicateValuesTemp = new ArrayList();
//
////        listMap.put("Line2",duplicateValuesTemp);
//
//
//        System.out.println("Success");
//
//        String output = duplicateValues.get(1).getName();
//        System.out.println("Success");


        BeaRequest beaRequest = new BeaRequest();
        BeaResponse beaResult = beaRequest.getBeaResponse();

        System.out.println("Success");

    }

}
