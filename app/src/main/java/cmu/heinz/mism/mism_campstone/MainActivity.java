package cmu.heinz.mism.mism_campstone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button button = (Button) findViewById(R.id.button);
        Log.d("MONGO", "onCreate");
        // button.performClick();
    }

    /** Called when the user taps the Send button */
    public void turnToMap(View view) {
        Log.d("MONGO", "turnToMap");
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
    }
}
