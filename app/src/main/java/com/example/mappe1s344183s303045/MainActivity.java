package com.example.mappe1s344183s303045;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.muddzdev.styleabletoastlibrary.StyleableToast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    int l = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String landkode = getSharedPreferences("PREFERENCE", MODE_PRIVATE).getString("Landkode", "");
        settland(landkode);
        System.out.println("Språk satt " + landkode);

        setContentView(R.layout.activity_main);

        Button forsteknapp = (Button) findViewById(R.id.startknapp);
        forsteknapp.setOnClickListener(this::onClick);
        Button andreknapp = (Button) findViewById(R.id.preferanseknapp);
        andreknapp.setOnClickListener(this::onClick);
        Button tredjeknapp = (Button) findViewById(R.id.statistikkknapp);
        tredjeknapp.setOnClickListener(this::onClick);
        //Lager clicklisteners slik at trykkene registreres


    }

    public void onClick(View v) {
        if (v.getId() == R.id.startknapp) {
            Intent intent = new Intent(this, Start.class);
            startActivity(intent);
        }
        else if (v.getId() == R.id.preferanseknapp) {
            Intent intent = new Intent(this, Preferanser.class);
            startActivity(intent);
        }
        else if (v.getId() == R.id.statistikkknapp) {
            Intent intent = new Intent(this, Statistikk.class);
            startActivity(intent);
        }
        else {
            Toast.makeText(getApplicationContext(), "Du ble ikke sendt til en side", Toast.LENGTH_SHORT).show();
            //Toast er kun for enkel feilsøking
        }


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
        String landkode = getSharedPreferences("PREFERENCE", MODE_PRIVATE).getString("Landkode", "");
        settland(landkode);
        System.out.println("Språk satt " + landkode);


    }



}
