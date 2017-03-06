package cmu.heinz.mism.mism_campstone;

import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Class used for interaction with DB (currently mongodb) add places/tours get
 * places/tours by distance
 */

public class DBHelper {

    private MongoClient client;
    private MongoDatabase db;
    private MongoCollection<Document> collection;

    DBHelper(String db_uri, String db_name, String collection_name) {
        MongoClientURI uri = new MongoClientURI(db_uri);
        client = new MongoClient(uri);
        db = client.getDatabase(db_name);
        collection = db.getCollection(collection_name);
    }

    public List<String> getPositions(double latitude, double longitude, int dis) {
        BasicDBObject match = new BasicDBObject("$match",
                new BasicDBObject("Latitude",
                        new BasicDBObject("$gte", latitude - dis).append("$lte", latitude + dis))
                        .append("Longitude",
                                new BasicDBObject("$gte", longitude - dis).append("$lte", longitude + dis)));
        ArrayList<BasicDBObject> tasks = new ArrayList<>();
        tasks.add(match);
        AggregateIterable<Document> docs = collection.aggregate(tasks);
        List<String> list = new ArrayList<>();
        for (Document doc : docs) {
            list.add(doc.toJson());
            System.out.println(doc.toJson());
        }
        return list;
    }

    public static void main(String[] args) throws IOException {
        DBHelper dbHelper = new DBHelper(
                "mongodb://team2legendary:mlableg17@ds119020.mlab.com:19020/journey_db",
                "journey_db",
                "locations");
        Gson gson = new Gson();
        try (MongoCursor<Document> cursor = dbHelper.collection.find().iterator()) {
            while (cursor.hasNext()) {
                System.out.println(cursor.next().toJson());
                Location location = gson.fromJson(cursor.next().toJson(), Location.class);
                System.out.println(location.toString());
            }
        }
    }
}
