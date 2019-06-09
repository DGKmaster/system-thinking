package com.hakaton.turistapp1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class RouteCreateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_route_create);
    }

    public void goToRoutesAct(View view) {
        Intent intent = new Intent(this, RoutesActivity.class);

        startActivity(intent);
    }
}
