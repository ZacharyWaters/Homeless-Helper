package com.gitgud.homelesshelper.controllers;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.gitgud.homelesshelper.R;
import com.gitgud.homelesshelper.model.Shelter;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import java.util.List;


/**
 *
 */
public class DefaultMapActivity extends AppCompatActivity implements OnMapReadyCallback {
    private GoogleMap mGoogleMap;
    private final List<Shelter> list = Shelter.getShelterList();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_defaultmap);

        if(googleServicesAvailable()){
            initMap();
        }


        Button mReturnButton = findViewById(R.id.mapbackbutton);
        mReturnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
    private void initMap() {
        MapFragment mapFragment;
        mapFragment = (MapFragment)getFragmentManager().findFragmentById(R.id.mapFragment);
        mapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(GoogleMap googleMap){
        mGoogleMap = googleMap;
        goToLocationZoom(33.774536,-84.3975653, 13);


        for(Shelter obj : list){
            String name = obj.getName();
            double lat = Double.parseDouble(obj.getLatitude());
            double lng = Double.parseDouble(obj.getLongitude());

            MarkerOptions options = new MarkerOptions();
            options.title(name);
            options.position(new LatLng(lat,lng));
            options.snippet("Capacity: " +obj.getCapacity()
                    +"  |  "+ "Restrictions: " +obj.getRestriction());
            mGoogleMap.addMarker(options);

        }
    }


//    private void goToLocation(double lat, double lng) {
//        LatLng ll = new LatLng(lat,lng);
//        CameraUpdate update = CameraUpdateFactory.newLatLng(ll);
//        mGoogleMap.moveCamera(update);
//    }

    private void goToLocationZoom(double lat, double lng, float zoom) {
        LatLng ll = new LatLng(lat,lng);
        CameraUpdate update = CameraUpdateFactory.newLatLngZoom(ll,zoom);
        mGoogleMap.moveCamera(update);
    }

    /**
     * @return boolean
     */
    public boolean googleServicesAvailable() {
        GoogleApiAvailability api = GoogleApiAvailability.getInstance();
        int isAvailable = api.isGooglePlayServicesAvailable(this);
        if(isAvailable== ConnectionResult.SUCCESS){
            return true;
        }else if (api.isUserResolvableError(isAvailable)){
            Dialog dialog = api.getErrorDialog(this, isAvailable, 0);
            dialog.show();
        } else {
            Toast.makeText(this,"Can't connect to play services",Toast.LENGTH_LONG).show();
        }
        return false;

    }
}
