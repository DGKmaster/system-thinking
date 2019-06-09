package com.hakaton.turistapp1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.hakaton.turistapp1.utilNet.NetworkUtil;

import org.json.JSONException;
import org.json.JSONObject;

public class RoutesActivity extends AppCompatActivity {
    TextView textViewTitle;
    TextView textViewPointN;
    TextView textViewTime;
    TextView textViewDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_routes);
        textViewTitle=findViewById(R.id.textViewTitle);
        textViewPointN=findViewById(R.id.textViewPointsN);
        textViewDescription=findViewById(R.id.textViewDescription);
        textViewTime=findViewById(R.id.textViewTime);

        JSONObject jsonObject = NetworkUtil.getJSONFromNetwork(30, 1000, "active", 55.666, 30.771, "raiting");
        try {
            String title = jsonObject.getString("title");
            int placesNumber = jsonObject.getInt("placesNumber");
            String description = jsonObject.getString("description");
            int time = jsonObject.getInt("time");
            double rating = jsonObject.getDouble("rating");

            textViewTime.setText(Integer.toString(time));
            textViewPointN.setText(Integer.toString(placesNumber));
            textViewTitle.setText(title);
            textViewDescription.setText(description);


        } catch (JSONException e) {
            e.printStackTrace();
        }




    }
}
