package com.example.mappe1s344183s303045;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class Statistikk extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.statistikk);

        Button knapp1 = (Button) findViewById(R.id.slettstat);
        knapp1.setOnClickListener(this);

        String r = getSharedPreferences("PREFERENCE", MODE_PRIVATE).getString("Riktig", "");
        String f = getSharedPreferences("PREFERENCE", MODE_PRIVATE).getString("Fel", "");

        TextView riktig = findViewById(R.id.riktigtotal);
        if (r.equals("")) {
            riktig.setText("0"); //Hvis ingen verdier er lagret, vises det tom streng. Viser heller tallet 0.
        } else {
            riktig.setText(r);
        }

        TextView feil = findViewById(R.id.feiltotal);
        if (f.equals("")) {
            feil.setText("0");
        } else {
            feil.setText(f);
        }
    }

    //Setter statistikk for riktig og feil til en tom Streng, sletting av statistikk
    @Override
    public void onClick(View v) {
        getSharedPreferences("PREFERENCE", MODE_PRIVATE)
                .edit()
                .putString("Riktig", "")
                .apply();

        getSharedPreferences("PREFERENCE", MODE_PRIVATE)
                .edit()
                .putString("Fel", "")
                .apply();
        recreate(); //Refresher skjermbildet slik at statistikken blir fjernet med en gang
    }

    public void settland(String landskode) {
        Resources res = getResources();
        DisplayMetrics displaymet = res.getDisplayMetrics();
        Configuration config = res.getConfiguration();
        config.setLocale(new Locale(landskode));
        res.updateConfiguration(config, displaymet);
    }

    protected void onPause() {
        super.onPause();
        String landkode = getSharedPreferences("PREFERENCE",MODE_PRIVATE).getString("Landkode","");
        settland(landkode);
    }

    public void tilMeny(View v) {
        finish();
    }
}