package edu.txstate.jpl77.cabfarecarwashhw2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class carWash extends AppCompatActivity {
    Double dblNumberOfWashes;
    Double dblTotalCost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_wash);

        final EditText numberOfWashes = findViewById(R.id.carWashNumberWashes);
        RadioButton exteriorWash = findViewById(R.id.exteriorOnlyRadio);
        RadioButton exteriorInteriorWash = findViewById(R.id.exteriorWithVaccuumRadio);
        //final EditText numOfWashes = findViewById(R.id.carWashNumberWashes);
        Button Calculate = findViewById(R.id.carWashCalculateBtn);
        TextView results = findViewById(R.id.cabFareResultsTxtView);

        Calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strNumWashes = numberOfWashes.getText().toString();
                try {
                    //Integer intNumWashes = Integer.parseInt(strNumWashes);
                    dblNumberOfWashes = Double.parseDouble(strNumWashes);
                } catch (Exception ex) {
                    Toast.makeText(carWash.this, "Please select a type of wash.", Toast.LENGTH_LONG).show();
                    return;
                }

                //calculation
                if (exteriorInteriorWash.isChecked()) {
                    if (dblNumberOfWashes >= 10) {
                        dblTotalCost = 15 * dblNumberOfWashes;
                    } else {
                        dblTotalCost = 17.25 * dblNumberOfWashes;
                    }
                } else {
                    dblTotalCost = dblNumberOfWashes * 10.5;
                }
                //output

                DecimalFormat finalCost = new DecimalFormat("$###,###.##");
                results.setText(finalCost.format(dblTotalCost) + " for " + strNumWashes + " washes.");
                // results.setText("The cost is: " + f.format(dblTotalCost) + " for " + strNumWashes + " washes.");
            }
        });
}}