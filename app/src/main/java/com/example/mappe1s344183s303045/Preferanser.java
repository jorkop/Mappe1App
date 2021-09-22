package com.example.mappe1s344183s303045;


import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;

import java.util.Locale;

public class Preferanser extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.preferanser);

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
    }

    public void tysk(View v) {
        settland("de");
        recreate();
    }

    public void norsk(View v) {
        settland("no");
        recreate();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.spm5) {
            getSharedPreferences("PREFERENCE", MODE_PRIVATE)
                    .edit()
                    .putString("Hovedtekst", "5")
                    .apply();

        } else if (v.getId() == R.id.spm10) {
            getSharedPreferences("PREFERENCE", MODE_PRIVATE)
                    .edit()
                    .putString("Hovedtekst", "10")
                    .apply();

        } else if (v.getId() == R.id.spm15) {
            getSharedPreferences("PREFERENCE", MODE_PRIVATE)
                    .edit()
                    .putString("Hovedtekst", "15")
                    .apply();
        }
    }
}
