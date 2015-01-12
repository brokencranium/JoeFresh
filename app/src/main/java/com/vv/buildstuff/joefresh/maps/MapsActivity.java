package com.vv.buildstuff.joefresh.maps;

import android.content.Context;
import android.content.res.Configuration;
import android.location.Criteria;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.GroundOverlay;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.vv.buildstuff.joefresh.R;
import com.vv.buildstuff.joefresh.list.Model;
import com.vv.buildstuff.joefresh.list.RetailStoresAdapter;
import com.vv.buildstuff.joefresh.requestPlaces.RequestPlacesNearbySearch;
import com.vv.buildstuff.joefresh.responsePlaces.Results;
import com.vv.buildstuff.joefresh.util.LatLongLoc;
import com.vv.buildstuff.joefresh.util.Miscellaneous;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapsActivity extends ActionBarActivity implements RetailStoresAdapter.OnItemClickListener, GoogleMap.OnMarkerDragListener {

    private GoogleMap mMap; // Might be null if Google Play services APK is not available.
    private DrawerLayout mDrawerLayout;
    private RecyclerView mDrawerList;
    private ArrayList<Model> mRetailStores = null;
    private ActionBarDrawerToggle mDrawerToggle;

    private RetailStoresAdapter mstoresAdapter;
    private ArrayList<Model> retailStoresToggled;
    private LinearLayoutManager mlistLayoutManager;
    private double lat;
    private double lng;
    private Map<String,List<Marker>> storeMarkerRef;
    private CameraPosition cameraPosition;
    private Marker referenceMarker;
    private GroundOverlay displayRadius;
    private Circle mCircle;
    private Marker mDisplayRadiusMarker;

    /*
            Over-ride methods
    */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer);
        setUpMapIfNeeded();
        setupLeftDrawer(savedInstanceState);
    }

    /**
     * @param savedInstanceState
     */
    private void setupLeftDrawer(Bundle savedInstanceState) {
//        mRetailStores = getResources().getStringArray(R.array.stores_array);
        final String[] storeList = getResources().getStringArray(R.array.stores_array);
        Model model = null;
        storeMarkerRef = new HashMap<String,List<Marker>>();


        if (mRetailStores == null) ;
        {
            mRetailStores = new ArrayList<Model>();
            for (int i = 0; i < storeList.length; ++i) {
                if (null != storeList[i])
                    model = new Model(storeList[i]);
                    mRetailStores.add(model);
                    storeMarkerRef.put(model.getName(),new ArrayList<Marker>());
            }
        }

        setDrawerLayout();
        setDrawerList();

// enable ActionBar app icon to behave as action to toggle nav drawer
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

// ActionBarDrawerToggle ties together the the proper interactions
// between the sliding drawer and the action bar app icon
        toggleDrawer();

        if (savedInstanceState == null) {
            selectItem(0);
        }
    }

    private void setDrawerLayout() {

        if (mDrawerLayout == null) {
            mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
            // set a custom shadow that overlays the main content when the drawer opens
            mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);
        }
    }

    /**
     *
     */
    private void setDrawerList() {
        if (mDrawerList == null) {
// Get handler to the recycler view
            mDrawerList = (RecyclerView) findViewById(R.id.left_drawer);
// improve performance by indicating the list if fixed size.
            mDrawerList.setHasFixedSize(true);

//  instantiate a layout manager
            mlistLayoutManager = new LinearLayoutManager(this);
//Set layout manager
            mDrawerList.setLayoutManager(mlistLayoutManager);
// set up the drawer's list view with items and click listener
            mstoresAdapter = new RetailStoresAdapter(mRetailStores, this);
            mDrawerList.setAdapter(mstoresAdapter);
// set item animator to DefaultAnimator
            //           mDrawerList.setItemAnimator(new DefaultItemAnimator());

//

        }
    }

    /**
     *
     */
    private void toggleDrawer() {
        mDrawerToggle = new ActionBarDrawerToggle(
                this,                  /* host Activity */
                mDrawerLayout,         /* DrawerLayout object */
                R.drawable.ic_drawer,  /* nav drawer image to replace 'Up' caret */
                R.string.drawer_open,  /* "open drawer" description for accessibility */
                R.string.drawer_close  /* "close drawer" description for accessibility */
        ) {
            public void onDrawerClosed(View view) {
                getSupportActionBar().setTitle("Stores Analysis");
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }

            public void onDrawerOpened(View drawerView) {
                getSupportActionBar().setTitle("Select Stores");
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }
        };
        mDrawerLayout.setDrawerListener(mDrawerToggle);
    }

    /**
     *
     */
    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }


    /**
     * Sets up the map if it is possible to do so (i.e., the Google Play services APK is correctly
     * installed) and the map has not already been instantiated.. This will ensure that we only ever
     * call {@link #setUpMap()} once when {@link #mMap} is not null.
     * <p/>
     * If it isn't installed {@link SupportMapFragment} (and
     * {@link com.google.android.gms.maps.MapView MapView}) will show a prompt for the user to
     * install/update the Google Play services APK on their device.
     * <p/>
     * A user can return to this FragmentActivity after following the prompt and correctly
     * installing/updating/enabling the Google Play services. Since the FragmentActivity may not
     * have been completely destroyed during this process (it is likely that it would only be
     * stopped or paused), {@link #onCreate(Bundle)} may not be called again so we should call this
     * method in {@link #onResume()} to guarantee that it will be called.
     */
    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.map))
                    .getMap();


            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                setUpMap();
            }
        }
    }

    /**
     * This is where we can add markers or lines, add listeners or move the camera. In this case, we
     * just add a marker near Africa.
     * <p/>
     * This should only be called once and when we are sure that {@link #mMap} is not null.
     */
    private void setUpMap() {
        mMap.setMyLocationEnabled(true);
//
        mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
        mMap.setBuildingsEnabled(true);

        setUpInitialPosition();
        if ( lat == 0 || lng == 0 ) {
            lat = Double.parseDouble(Miscellaneous.DEFAULT_LATITUDE.getText());
            lng = Double.parseDouble(Miscellaneous.DEFAULT_LONGITUDE.getText());
        }

        LatLng latLng = new LatLng(lat,lng);
        referenceMarker = mMap.addMarker(new MarkerOptions().position(latLng).title("Point of reference").draggable(true));
        mMap.setOnMarkerDragListener(this);
//        mMap.addMarker(new MarkerOptions()
//                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN))
//                        .position(latLng)
//                        .alpha(0.7f));

        if(mCircle == null || mDisplayRadiusMarker == null){
            drawMarkerWithCircle(latLng);
        }else{
            updateMarkerWithCircle(latLng);
        }

//        GroundOverlayOptions newarkMap = new GroundOverlayOptions()
//                .image(BitmapDescriptorFactory.)
//                .transparency(0.2f)
////                .image(BitmapDescriptorFactory.fromResource(R.drawable.newark_nj_1922))
//                .position(latLng,Float.parseFloat(Miscellaneous.RADIUS.toString()), Float.parseFloat(Miscellaneous.RADIUS.toString()) );

        cameraPosition = CameraPosition.builder()
                .target(latLng)
                .zoom(10.0f)
//                .bearing(90)
                .tilt(30)
                .build();
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));


//        setStoreLocations(lat, lng, Miscellaneous.NAME.toString());
    }


    private void updateMarkerWithCircle(LatLng position) {
        mCircle.setCenter(position);
        mDisplayRadiusMarker.setPosition(position);
    }

    private void drawMarkerWithCircle(LatLng latLng) {

        int strokeColor = 0x1fff0000; //red outline
       int shadeColor = 0x09ff0000; //opaque red fill


        CircleOptions circleOptions = new CircleOptions().center(latLng).radius(Double.parseDouble(Miscellaneous.RADIUS.toString())).fillColor(shadeColor).strokeColor(strokeColor).strokeWidth(1);
        mCircle = mMap.addCircle(circleOptions);
        mDisplayRadiusMarker = mMap.addMarker(new MarkerOptions().position(latLng));
    }
    private void setUpInitialPosition() {
        final String context = Context.LOCATION_SERVICE;
        final String TEST_PROVIDER = "TEST_PROVIDER";
        final LocationManager locationManager = (LocationManager) getSystemService(context);
        String provider;

        if (locationManager.getProvider(TEST_PROVIDER) != null &&
                locationManager.isProviderEnabled(TEST_PROVIDER)) {
            provider = TEST_PROVIDER;
        } else {
            Criteria criteria = new Criteria();
            criteria.setAccuracy(Criteria.ACCURACY_FINE);
            criteria.setAltitudeRequired(false);
            criteria.setBearingRequired(false);
            criteria.setCostAllowed(true);
            criteria.setPowerRequirement(Criteria.POWER_HIGH);
            provider = locationManager.getBestProvider(criteria, true);
        }


        if (locationManager.getLastKnownLocation(provider) != null) {
            lat = locationManager.getLastKnownLocation(provider).getLatitude();
            lng = locationManager.getLastKnownLocation(provider).getLongitude();
            String out = "Lat & long " + locationManager.getLastKnownLocation(provider).getLatitude() + " " + locationManager.getLastKnownLocation(provider).getLatitude();
            Toast.makeText(getApplicationContext(),
                    out,
                    Toast.LENGTH_LONG).show();
        }


    }

    private void setStoreLocations(double lat, double lng, String name) {
        LatLongLoc storeGeoMarker = new LatLongLoc(lat, lng, name);
        AsyncNearBySearch asyncSearch = new AsyncNearBySearch();
        asyncSearch.execute(storeGeoMarker);
    }

    /**
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation_drawer, menu);
        return true;
    }

    /**
     * @param menu
     * @return
     */
    /* Called whenever we call invalidateOptionsMenu() */
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        // If the nav drawer is open, hide action items related to the content view
        boolean drawerOpen = mDrawerLayout.isDrawerOpen(mDrawerList);
        return super.onPrepareOptionsMenu(menu);
    }

    /**
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // The action bar home/up action should open or close the drawer.
        // ActionBarDrawerToggle will take care of this.
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);


    }

    /**
     * @param view
     * @param position
     */
    @Override
    public void onClick(View view, int position) {
        final String storeName = mstoresAdapter.getDataSet().get(position).getName();
        selectItem(position);

        if (!mstoresAdapter.getDataSet().get(position).isSelected()) {

            setStoreLocations(lat, lng, storeName);

        } else {
//            Destroy all the icons related to the selection
            List<Marker> markers = new ArrayList<>();
            markers = storeMarkerRef.get(storeName);
            if (markers == null ){
                return;
            }
            for(Marker marker:markers){
                marker.remove();
            }
            markers.clear();
            storeMarkerRef.put(storeName,markers);
        }
    }

    /**
     * @param position
     */
    private void selectItem(int position) {
        // update the main content
        mDrawerLayout.closeDrawer(mDrawerList);

//        ArrayList<Model> changedItems = new ArrayList<Model>();
//       making an assumption that the changed item is Joe Fresh


    }

    /**
     * @param savedInstanceState
     */
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    /**
     * @param newConfig
     */
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggls
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public void onMarkerDragStart(Marker marker) {
        Log.d("VV Drag Start", marker.getTitle());

    }

    @Override
    public void onMarkerDrag(Marker marker) {
        updateMarkerWithCircle(marker.getPosition());
        Log.d("VV Drag Start", marker.getTitle());
    }

    @Override
    public void onMarkerDragEnd(Marker marker) {
        Log.d("VV Drag Start", marker.getTitle());
        lat = marker.getPosition().latitude;
        lng = marker.getPosition().longitude;
//        for(String key:storeMarkerRef.keySet()){
//            storeMarkerRef.put(key,null);
//        }
        for(Model store:mRetailStores){
            if (store.isSelected()){
                setStoreLocations(lat, lng, store.getName());
            }
        }


    }


    /**
     * Local class for searching stores based on the geolocation
     */
    private class AsyncNearBySearch extends AsyncTask<LatLongLoc, String, ArrayList<Results>> {

        @Override
        protected ArrayList<Results> doInBackground(LatLongLoc... latLongLocs) {
            RequestPlacesNearbySearch search = new RequestPlacesNearbySearch();
            LatLongLoc store = latLongLocs[0];

            search.setName(store.getLoc());
            StringBuilder latLongText = new StringBuilder();
            latLongText.append(store.getLat()).append(",").append(store.getLng());
            search.setLatLongText(latLongText.toString());
            search.setUrlString();
            Log.d("VV URL String", search.getUrlString());
            return search.getPlacesResponse();
        }

        @Override
        protected void onPostExecute(ArrayList<Results> results) {
            BitmapDescriptor drawable = null;

            if (results.size() == 0)
               return;

            final  String storeName = results.get(0).getName();

            if (storeName == null)
                    return;

            if (storeMarkerRef.get(storeName).size() == 0)
                 storeMarkerRef.put(storeName,new ArrayList<Marker>());

                String storeDrawableName = storeName.toLowerCase().replaceAll("\\s", "_");
                drawable = BitmapDescriptorFactory.fromResource(getResources().getIdentifier(storeDrawableName, "drawable", getPackageName()));
                if (null == drawable) {
                    drawable = BitmapDescriptorFactory.fromResource(R.drawable.default_store);
                }


            for (Results result : results) {
// Creating the resource name in the drawable directory and get the resource ID


                Marker marker = mMap.addMarker(new MarkerOptions()
                        .icon(drawable)
                        .position(new LatLng(result.getGeometry().getLocation().getLat(), result.getGeometry().getLocation().getLng()))
                        .alpha(0.7f));
//                Check if the List Marker is not null
                storeMarkerRef.get(storeName).add(marker);
            }
//  Add all the makers to the HashMap
//           storeMarkerRef.put(storeName, listMarker);
            referenceMarker.showInfoWindow();
            super.onPostExecute(results);
        }
    }

}
