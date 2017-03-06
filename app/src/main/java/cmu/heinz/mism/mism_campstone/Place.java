package cmu.heinz.mism.mism_campstone;

/**
 * Place class -- model for single location
 */

public class Place {
    private String projectId;
    private double longitude;
    private double latitude;
    private String description;
    private byte[] image;

    Place(String id, double lon, double lat, String des, byte[] img) {
        projectId = id;
        longitude = lon;
        latitude = lat;
        description = des;
        image = img;
    }

    public String getProjectId() {
        return projectId;
    }
    public String getDescription() {
        return description;
    }
    public double getLongitude() {
        return longitude;
    }
    public double getLatitude() {
        return latitude;
    }
    public byte[] getImage() {
        return image;
    }
}
