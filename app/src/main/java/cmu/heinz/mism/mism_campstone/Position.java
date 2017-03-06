package cmu.heinz.mism.mism_campstone;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Position.
 */

@AllArgsConstructor(suppressConstructorProperties=true)
public class Position {
    //LatLng cmuCampus = new LatLng(40.4435, -79.9435);
    //Options().position(cmuCampus).title("Marker in CMU").snippet("Your location"));
    @Getter
    @Setter
    public double latitude;
    @Getter
    @Setter
    public double longitude;
    @Getter
    @Setter
    private String title;
    @Getter
    @Setter
    private String snippet;
}
