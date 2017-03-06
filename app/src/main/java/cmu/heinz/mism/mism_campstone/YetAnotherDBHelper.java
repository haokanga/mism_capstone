package cmu.heinz.mism.mism_campstone;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.io.IOException;

/**
 * MongoDB processing
 * http://mongodb.github.io/mongo-java-driver/3.4/driver/getting-started/quick-start/
 */

public class YetAnotherDBHelper {

    private MongoClient client;
    private MongoDatabase db;
    private MongoCollection<Document> collection;

    YetAnotherDBHelper(String db_uri, String db_name, String collection_name) {
        MongoClientURI uri = new MongoClientURI(db_uri);
        client = new MongoClient(uri);
        db = client.getDatabase(db_name);
        collection = db.getCollection(collection_name);
    }

    public static void main(String[] args) throws IOException {
        YetAnotherDBHelper dbHelper = new YetAnotherDBHelper("mongodb://team2legendary:mlableg17@ds119020.mlab.com:19020/journey_db",
                "journey_db", "locations");
        System.out.println(dbHelper.collection.count());
    }
}
