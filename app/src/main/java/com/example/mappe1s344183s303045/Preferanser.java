package com.example.mappe1s344183s303045;


import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;

import java.util.Locale;

public class Preferanser extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.preferanser);
    }

    public void settland(String landskode) {
        Resources res = getResources();
        DisplayMetrics displaymet = res.getDisplayMetrics();
        Configuration config = res.getConfiguration();
        config.setLocale(new Locale(landskode));
        res.updateConfiguration(config,displaymet);
    }

    public void tysk(View v) {
        settland("de");
        recreate();
    }

    public void norsk(View v) {
        settland("no");
        recreate();
    }
}
