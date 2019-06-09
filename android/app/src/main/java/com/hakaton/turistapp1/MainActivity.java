package com.hakaton.turistapp1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import com.hakaton.turistapp1.utilNet.NetworkUtil;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    private String cityName = null;
    Spinner spinnerC;
    public TextView textViewTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinnerC = findViewById(R.id.spinnerCitys);
        textViewTest = findViewById(R.id.textViewTest);
    }

    public void goToPlaces(View view) {
        Intent intent = new Intent(this, PlacesActivity.class);
        cityName = "Санкт-Петербург";
        intent.putExtra("cityName", cityName);
        startActivity(intent);
    }

    public void goToRoutes(View view) {
        Intent intent = new Intent(this, PlacesActivity.class);
        cityName = "Санкт-Петербург";
        intent.putExtra("cityName", cityName);
        startActivity(intent);

    }

    public void goToRouteCreate(View view) {
        // Intent intent = new Intent(this, RoutesActivity.class);
        // JSONObject data = NetworkUtil.DownloadJSONObj.execute().get();
        JSONObject jsonObject = NetworkUtil.getJSONFromNetwork(1, 1);
        try {
            String temp = jsonObject.getString("string1");

            // int itmp=jsonObject.getInt("number5");
            textViewTest.setText(temp);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
