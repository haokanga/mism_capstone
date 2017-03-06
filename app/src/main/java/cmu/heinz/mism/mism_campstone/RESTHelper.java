package cmu.heinz.mism.mism_campstone;

import android.util.Log;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

/**
 * mLab Data REST APIs
 * http://docs.mlab.com/data-api/#create-collection
 * API key is needed
 */
public final class RESTHelper {

    private static final String BASE_URL = "https://api.mlab.com/api/1/";
    private static final String COLLECTION_URL = BASE_URL + "databases/journey_db/collections/locations2?apiKey=";
    private static final String API_KEY = "SCE012pulvNzU94GjxiyeKRy0GsTK1-w";
    private static final int TIMEOUT = 3000;
    private static final int RESPONSE_LIMIT = 10000;

    /**
     * Util class should not be initialized.
     */
    private RESTHelper() {
    }

    /**
     * Return all locations and deserialize them into a List of
     * {@link Location}.
     * <p>
     * TODO: consider using Network Operations on a Separate Thread
     * https://developer.android.com/training/basics/network-ops/connecting.html#intro
     *
     * @return locations in MongoDB
     */
    public static List<Location> getLocations() {
        InputStream stream = null;
        HttpsURLConnection connection = null;
        String result = null;
        try {
            URL url = new URL(COLLECTION_URL + API_KEY);
            connection = (HttpsURLConnection) url.openConnection();
            connection.setReadTimeout(TIMEOUT);
            connection.setConnectTimeout(TIMEOUT);
            connection.setRequestMethod("GET");
            connection.setDoInput(true);
            connection.connect();
            int responseCode = connection.getResponseCode();
            if (responseCode != HttpsURLConnection.HTTP_OK) {
                throw new IOException("HTTP error code: " + responseCode);
            }
            // Retrieve the response body as an InputStream.
            stream = connection.getInputStream();
            if (stream != null) {
                result = readStream(stream, RESPONSE_LIMIT);
            }
        } catch (IOException e) {
            Log.e("Capstone", e.getMessage());
            StackTraceElement[] trace = e.getStackTrace();
            for (StackTraceElement traceElement : trace) {
                Log.e("Capstone", "\tat " + traceElement);
            }
        } finally {
            // Close Stream and disconnect HTTPS connection.
            if (stream != null) {
                try {
                    stream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                connection.disconnect();
            }
        }
        return new ArrayList<>(
                Arrays.asList(new Gson().fromJson(result, Location[].class)));
    }

    /**
     * Converts the contents of an InputStream to a String.
     */
    private static String readStream(InputStream stream, int maxLength) throws IOException {
        String result = null;
        // Read InputStream using the UTF-8 charset.
        InputStreamReader reader = new InputStreamReader(stream, "UTF-8");
        // Create temporary buffer to hold Stream data with specified max length.
        char[] buffer = new char[maxLength];
        // Populate temporary buffer with Stream data.
        int numChars = 0;
        int readSize = 0;
        while (numChars < maxLength && readSize != -1) {
            numChars += readSize;
            readSize = reader.read(buffer, numChars, buffer.length - numChars);
        }
        if (numChars != -1) {
            // The stream was not empty.
            // Create String that is actual length of response body if actual length was less than
            // max length.
            numChars = Math.min(numChars, maxLength);
            result = new String(buffer, 0, numChars);
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        for (Location location : RESTHelper.getLocations()) {
            System.out.println(location.toString());
        }
    }
}
