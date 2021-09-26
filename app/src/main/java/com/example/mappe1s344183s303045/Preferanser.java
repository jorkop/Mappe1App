package com.example.mappe1s344183s303045;


import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Locale;

public class Preferanser extends AppCompatActivity implements View.OnClickListener {
    String landkode = "no";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.preferanser);

        //Bruker clicklistener for å kunne sette default til 5 ved bruk av switch
        Button knapp1 = (Button) findViewById(R.id.spm5);
        knapp1.setOnClickListener(this);
        Button knapp2 = (Button) findViewById(R.id.spm10);
        knapp2.setOnClickListener(this);
        Button knapp3 = (Button) findViewById(R.id.spm15);
        knapp3.setOnClickListener(this);


    }

    public void settland(String landskode) {
        Resources res = getResources();
        DisplayMetrics displaymet = res.getDisplayMetrics();
        Configuration config = res.getConfiguration();
        config.setLocale(new Locale(landskode));
        res.updateConfiguration(config, displaymet);

        //Lagrer til sharedPreferences
        getSharedPreferences("PREFERENCE",MODE_PRIVATE)
                .edit()
                .putString("Landkode",landskode)
                .apply();
    }

    public void tysk(View v) {
        landkode  = "de";
        settland(landkode);
        recreate();
    }

    public void norsk(View v) {
        landkode  = "no";
        settland(landkode);
        recreate();
    }




    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.spm5) {
            getSharedPreferences("PREFERENCE", MODE_PRIVATE)
                    .edit()
                    .putString("Hovedtekst", "5")
                    .apply();
            Toast toast = Toast.makeText(getApplicationContext(), R.string.satt5, Toast.LENGTH_SHORT);
            toast.show();
            toast.setGravity(Gravity.CENTER_HORIZONTAL,0,0);

        } else if (v.getId() == R.id.spm10) {
            getSharedPreferences("PREFERENCE", MODE_PRIVATE)
                    .edit()
                    .putString("Hovedtekst", "10")
                    .apply();
            Toast toast = Toast.makeText(getApplicationContext(), R.string.satt10, Toast.LENGTH_SHORT);
            toast.show();
            toast.setGravity(Gravity.CENTER_HORIZONTAL,0,0);

        } else if (v.getId() == R.id.spm15) {
            getSharedPreferences("PREFERENCE", MODE_PRIVATE)
                    .edit()
                    .putString("Hovedtekst", "15")
                    .apply();
            Toast toast = Toast.makeText(getApplicationContext(), R.string.satt15, Toast.LENGTH_SHORT);
            toast.show();
            toast.setGravity(Gravity.CENTER_HORIZONTAL,0,0);
        }
    }

    public void tilMenyen(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivityForResult(intent, 555);
        finish();
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivityForResult(intent, 555);
        finish();
    }
}
