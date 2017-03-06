package cmu.heinz.mism.mism_campstone;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.Type;

/**
 * Location.
 *
 * Although constructor and setters offered, the recommended usage is to use
 * GSON to deserialize {@code reference.json} directly to a list of Answer
 * objects. {@link Gson#fromJson(JsonReader, Type)}
 * {@link Data} is used which set @ToString, @EqualsAndHashCode, @Getter on all
 * fields, and @Setter on all non-final fields, and @RequiredArgsConstructor.
 */

@AllArgsConstructor(suppressConstructorProperties=true)
public class Location {
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
