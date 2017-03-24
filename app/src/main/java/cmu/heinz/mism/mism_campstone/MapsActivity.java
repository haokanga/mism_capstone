package cmu.heinz.mism.mism_campstone;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;

import com.akexorcist.googledirection.DirectionCallback;
import com.akexorcist.googledirection.GoogleDirection;
import com.akexorcist.googledirection.model.Direction;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    protected GoogleMap googleMap;
    private static final int ZOOM_RATIO = 14;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.googleMap = googleMap;
        LatLng cmuCampus = new LatLng(40.4435, -79.9435);
        this.googleMap.moveCamera(CameraUpdateFactory.newLatLng(cmuCampus));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(cmuCampus, ZOOM_RATIO));
        new RESTHelper().getLocations(this);
        // Google Place API server key instead of Google Map API key
        String serverKey = "AIzaSyB4ZPNRl8wM8bAKX9UfPRvqhePEd-Zv9o0";
        LatLng origin = new LatLng(40.442778, -79.950556);
        LatLng destination = new LatLng(40.443983, -79.948728);
        GoogleDirection.withServerKey(serverKey)
                .from(origin)
                .to(destination)
                .execute(new DirectionCallback() {
                    @Override
                    public void onDirectionSuccess(Direction direction, String rawBody) {
                        Log.v("[direction]", direction.getStatus());
                        Log.v("[rawBody]", rawBody);
                    }

                    @Override
                    public void onDirectionFailure(Throwable t) {
                        t.printStackTrace();
                    }
                });
    }
}
