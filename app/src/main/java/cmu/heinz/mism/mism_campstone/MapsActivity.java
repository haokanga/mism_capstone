package cmu.heinz.mism.mism_campstone;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.LinkedList;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap googleMap;
    private static final int ZOOM_RATIO = 16;

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
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.googleMap = googleMap;
        LinkedList<Location> locations = new LinkedList<>();
        LatLng cmuCampus = new LatLng(40.4435, -79.9435);
        // locations.add(new Location(40.4435, -79.9435, "Marker in CMU","Your location"));
        // locations.add(new Location(40.443967,-79.949318,
        //        "Carnegie Museum of Natural History","Natural History Museum"));
        // locations.add(new Location(40.4442526,-79.953239, "Cathedral of Learning","College"));
        for(Location location : locations){
            LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());

            Marker marker = this.googleMap.addMarker(new MarkerOptions()
                    .position(latLng)
                    .title(location.getName())
                    .snippet(location.getAddress()));
            marker.showInfoWindow();
        }
        this.googleMap.moveCamera(CameraUpdateFactory.newLatLng(cmuCampus));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(cmuCampus, ZOOM_RATIO));
    }
}
