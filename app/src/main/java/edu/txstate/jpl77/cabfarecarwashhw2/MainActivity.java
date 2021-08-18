package edu.txstate.jpl77.cabfarecarwashhw2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button carWash = findViewById(R.id.carWashMainScreenBtn);
        carWash.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, carWash.class));
            }
        });

        Button cabFare = findViewById(R.id.cabFareMainScreenBtn);
        cabFare.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, cabFare.class));
            }
        });
    }
}