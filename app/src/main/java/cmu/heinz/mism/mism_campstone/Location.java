package cmu.heinz.mism.mism_campstone;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import lombok.Data;

import java.lang.reflect.Type;

/**
 * Location.
 * <p>
 * Although constructor and setters offered, the recommended usage is to use
 * GSON to deserialize {@code reference.json} directly to a list of Answer
 * objects. {@link Gson#fromJson(JsonReader, Type)}
 * {@link Data} is used which set @ToString, @EqualsAndHashCode, @Getter on all
 * fields, and @Setter on all non-final fields, and @RequiredArgsConstructor.
 */

@Data
public class Location {
    private String category;
    private String name;
    private double latitude;
    private double longitude;
    private int year;
    private String artistArchitect;
    private String streetAddress;
    private int zipCode;
    private String image;
}
