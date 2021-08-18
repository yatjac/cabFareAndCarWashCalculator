package edu.txstate.jpl77.cabfarecarwashhw2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class cabFare extends AppCompatActivity {

    int intNumOfMiles;
    Double dblCostPerMile;
    Double dblTotalCost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cab_fare);

        final EditText numOfMiles = findViewById(R.id.distanceMilesTxt);
        Button calculate = findViewById(R.id.cabFareTotalButton);
        final Spinner cabs = findViewById(R.id.spinnerCabFare);
        final TextView results = findViewById(R.id.cabFareResultsTxtView);
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strNumOfMiles = numOfMiles.getText().toString();
                try {
                    intNumOfMiles = Integer.parseInt(strNumOfMiles);
                }
                catch(Exception ex){
                    Toast.makeText(cabFare.this, "The input is not valid!", Toast.LENGTH_LONG).show();
                    return;
                }

                //calculation
                dblTotalCost = (dblCostPerMile + intNumOfMiles) + 2.50;

                //display
                String strCab = cabs.getSelectedItem().toString();
                DecimalFormat f = new DecimalFormat("$###,###.##");
                results.setText("The cost is: " + f.format(dblTotalCost) + " and your selected cab is " + strCab + ".");
            }
        });
    }
}