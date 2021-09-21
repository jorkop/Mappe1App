package com.example.mappe1s344183s303045;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class Start extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.startspill);

        // Disse er for å kunne registrere når man trykker på knappene
        Button knapp1 = (Button) findViewById(R.id.knapp1);
        knapp1.setOnClickListener(this);
        Button knapp2 = (Button) findViewById(R.id.knapp2);
        knapp2.setOnClickListener(this);
        Button knapp3 = (Button) findViewById(R.id.knapp3);
        knapp3.setOnClickListener(this);
        Button knapp4 = (Button) findViewById(R.id.knapp4);
        knapp4.setOnClickListener(this);
        Button knapp5 = (Button) findViewById(R.id.knapp5);
        knapp5.setOnClickListener(this);
        Button knapp6 = (Button) findViewById(R.id.knapp6);
        knapp6.setOnClickListener(this);
        Button knapp7 = (Button) findViewById(R.id.knapp7);
        knapp7.setOnClickListener(this);
        Button knapp8 = (Button) findViewById(R.id.knapp8);
        knapp8.setOnClickListener(this);
        Button knapp9 = (Button) findViewById(R.id.knapp9);
        knapp9.setOnClickListener(this);
        Button knapp0 = (Button) findViewById(R.id.knapp0);
        knapp0.setOnClickListener(this);
        ImageButton knapp10 = (ImageButton) findViewById(R.id.slettknapp);
        knapp10.setOnClickListener(this);
        Button knapp11 = (Button) findViewById(R.id.svarknapp);
        knapp11.setOnClickListener(this);


        TextView tv = findViewById(R.id.spørsmål);
        int x = (int) (Math.random() * 14 - 0);
        tv.setText(getResources().getStringArray(R.array.regnestykker)[x]);
    }

    //Funksjonen onClick legger inn tall i inputfeltet fra knappene og sletter hvis slettknappen trykkes
    @Override
    public void onClick(View v) {
        TextView et = findViewById(R.id.svartekst); //Henter tall som allerede er skrevet inn
        String resultat = et.getText().toString(); //Gjør om tallene som ble hentet til en String
        int lengde = resultat.length();

        if (lengde < 6) { // Ingenting vil bli gjort dersom det er mer enn 6 tall skrevet inn
            if (v.getId() == R.id.knapp1) {
                resultat += "1";
            } else if (v.getId() == R.id.knapp2) {
                resultat += "2";
            } else if (v.getId() == R.id.knapp3) {
                resultat += "3";
            } else if (v.getId() == R.id.knapp4) {
                resultat += "4";
            } else if (v.getId() == R.id.knapp5) {
                resultat += "5";
            } else if (v.getId() == R.id.knapp6) {
                resultat += "6";
            } else if (v.getId() == R.id.knapp7) {
                resultat += "7";
            } else if (v.getId() == R.id.knapp8) {
                resultat += "8";
            } else if (v.getId() == R.id.knapp9) {
                resultat += "9";
            } else if (v.getId() == R.id.knapp0) {
                resultat += "0";
            }

        }  if (v.getId() == R.id.slettknapp) { //Slettknappen skal slette ett og ett tall

            // Bruker lengden til resultat strengen til å slette ett og ett siffer bakfra
            try {
                StringBuilder sb = new StringBuilder(resultat);
                resultat = sb.deleteCharAt(lengde - 1).toString();
            } catch (Exception e) {
                System.out.println("This does not work: " + e);
            }
        }

        try { //Sjekker om teksten kan settes i EditText, og setter inn i feltet
            et.setText(resultat);
        } catch (Exception e) {
            System.out.println("Could not set text " + e);
        }




        if (v.getId() == R.id.svarknapp) {
            String navn = getText(R.id.spørsmål).toString();
            for (int i = 0; i < 15; i++) {

            }
        }
    }
}
