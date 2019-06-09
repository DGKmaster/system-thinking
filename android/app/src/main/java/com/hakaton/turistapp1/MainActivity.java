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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinnerC = findViewById(R.id.spinnerCitys);

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
        Intent intent = new Intent(this, RouteCreateActivity.class);
        cityName = "Санкт-Петербург";
        intent.putExtra("cityName", cityName);
        startActivity(intent);


    }
}
