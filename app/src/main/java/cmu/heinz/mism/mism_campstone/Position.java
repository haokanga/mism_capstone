package cmu.heinz.mism.mism_campstone;

import com.google.android.gms.maps.model.LatLng;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Position.
 */

@AllArgsConstructor()
public class Position {
    //LatLng cmuCampus = new LatLng(40.4435, -79.9435);
    //Options().position(cmuCampus).title("Marker in CMU").snippet("Your location"));
    @Getter
    @Setter
    public final double latitude;
    @Getter
    @Setter
    public final double longitude;
    @Getter
    @Setter
    private final String title;
    @Getter
    @Setter
    private final String snippet;
}
