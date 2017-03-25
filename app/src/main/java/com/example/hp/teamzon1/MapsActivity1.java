package com.example.hp.teamzon1;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import java.lang.Object;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

public class MapsActivity1 extends FragmentActivity implements OnMapReadyCallback {
    private static MapsActivity1 instan;
    String latlong;
    String[] separated;

    double latitude,longitude;
    private GoogleMap mMap;
    private static Context mapcontext;

    public static Context getmapContext() {
        return mapcontext;}
    public static MapsActivity1 instance() {
        return instan;
    }
    //public static Context mapcontext() {
      //  return instan.getApplicationContext();
    //}
    public void onStart() {
        super.onStart();
        instan = this;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps1);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        latlong = new String();
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(latitude, longitude);
        mMap.addMarker(new MarkerOptions().position(sydney).title("GPS Marker"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }
    public void updatemap(final String smsMessage) {



        mMap.clear();
        latlong=smsMessage;
        separated = latlong.split(":");
        latitude=Double.parseDouble(separated[0]);
        latitude = (latitude/100-(latitude%100)/100) + (latitude % 100)/60;
        String lati = Double.toString(latitude);
        Log.v("TEXT",lati);

        longitude=Double.parseDouble(separated[1]);
        longitude = (longitude/100-(longitude%100)/100) + (longitude % 100)/60;
        String loni = Double.toString(longitude);
        Log.v("TEXT",loni);
        LatLng GPS = new LatLng(latitude, longitude);
        mMap.addMarker(new MarkerOptions().position(GPS).title("GPS Marker").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(latitude,longitude),10));


    }
}
