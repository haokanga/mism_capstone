package cmu.heinz.mism.mism_campstone;

import java.util.ArrayList;
import java.util.List;

/**
 * Tour class -- model for a tour
 */

public class Tour {
    private String description;
    private String category;
    private List<Place> tour;

    Tour(String des, String cat) {
        description = des;
        category = cat;
        tour = new ArrayList<>();
    }

    public void addPlace(Place place) {
        tour.add(place);
    }

    public void deletePlace(int idx) {
        tour.remove(idx);
    }

    public int getNumOfPlaces() {
        return tour.size();
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public List<Place> getTour() {
        return tour;
    }
}
