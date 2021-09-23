package com.example.mappe1s344183s303045;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.text.AlteredCharSequence;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.muddzdev.styleabletoastlibrary.StyleableToast;

import java.util.ArrayList;
import java.util.Arrays;

public class Start extends AppCompatActivity implements View.OnClickListener, MyDialog.DialogClickListener{
    ArrayList<String> arrayList = new ArrayList<>();
    int o = 1; //Int for å begrense antall spørsmål som blir vist, som valgt i preferanser
    int f = 0; //Int for telling av antall feil svar
    int r = 0; //Int for telling av antall riktige svar

    //Yes og No er for popup ved avbrutt spill
    @Override
    public void onYesClick() {
        finish();
    }
    @Override
    public void onNoClick() {
        return;
    }

    @Override
    public void visDialog(View v) {
        DialogFragment dialog = new MyDialog();
        dialog.show(getSupportFragmentManager(),"Avslutt");
    }

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
        int x = (int) (Math.random() * 15 - 0);
        tv.setText(getResources().getStringArray(R.array.regnestykker)[x]);

        for (int o = 0; o < 15; o++) { //Legger array fra xml inn i arraylist
            arrayList.add(getResources().getStringArray(R.array.regnestykker)[o]);
        }
    }

/* For eventuell styling av Toast
    public void showToast(View v){ // Skreddersydd Toast
        StyleableToast.makeText(this,"Hello world!",R.style.exampleToast).show();
    }
 */

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

        }
        if (v.getId() == R.id.slettknapp) { //Slettknappen skal slette ett og ett tall

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
            svarKnapp();
        }
    }


    public void svarKnapp() { // Sammenligner tekst på skjerm med spørsmål-array og henter svar fra svar-array
        TextView sporsmal = findViewById(R.id.spørsmål);
        String navn = sporsmal.getText().toString();
        TextView et = findViewById(R.id.svartekst);
        String resultat = et.getText().toString();

        TextView feil = findViewById(R.id.feiltall);
        TextView riktig = findViewById(R.id.riktigtall);


        for (int i = 0; i < 15; i++) {
            if (getResources().getStringArray(R.array.regnestykker)[i].equals(navn)) {
                String svar = (getResources().getStringArray(R.array.svar)[i]);
                System.out.println("Svaret er: " + svar);

                if (svar.equals(resultat)) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Riktig!", Toast.LENGTH_SHORT);
                    toast.show();
                    toast.setGravity(Gravity.CENTER_HORIZONTAL,0,0);
                    r++;
                        riktig.setText(Integer.toString(r));

                } else {
                    Toast toast = Toast.makeText(getApplicationContext(), "Ikke riktig denne gangen!", Toast.LENGTH_SHORT);
                    toast.show();
                    toast.setGravity(Gravity.CENTER_HORIZONTAL,0,0);
                    f++;
                    feil.setText(Integer.toString(f));

                    /* For eventuell styling av Toast
                    StyleableToast toast = StyleableToast.makeText(getApplicationContext(), "Detta blei feil...", R.style.exampleToast);
                    toast.show();
                    toast.setGravity(Gravity.CENTER_HORIZONTAL);
                     */
                }

                String s = getSharedPreferences("PREFERENCE",MODE_PRIVATE).getString("Hovedtekst","");
                int x = 0;
                switch (s) {
                    case "5":
                        x = 5;
                        break;
                    case "10":
                        x = 10;
                        break;
                    case "15":
                        x = 15;
                        break;
                    default:
                        x = 5;
                }
                if (o < x) {
                    String slette = getResources().getStringArray(R.array.regnestykker)[i]; //Sletter første spørsmålet som blir stilt
                    arrayList.remove(slette);
                    System.out.println(arrayList);
                    int y = (int) (Math.random() * arrayList.size() - 0); //Lager tilfeldig tall mellom 0 og lengde på array av gjenværende regnestykker
                    sporsmal.setText(arrayList.get(y)); //Setter teksten til tilfeldig regnestykke
                    et.setText(""); //Setter svarteksten blankt
                    o++;

                } else {
                    Toast.makeText(getApplicationContext(), "Spillet er ferdig.", Toast.LENGTH_SHORT).show();
                    sporsmal.setText("");
                    et.setText("");
                    lagreFeil();
                    lagreRiktig();
                }
            }
        }
    }

    /*
    Denne funksjonen henter totalt antall feil fra før dette spillet,
    legger til feil som oppstod under dette spillet og lagrer totalen
     */
    public void lagreFeil() {
        String lagretfeil = getSharedPreferences("PREFERENCE", MODE_PRIVATE).getString("Fel", "");
        if (lagretfeil.equals("")){
            System.out.println("Ingen feil er lagret fra før");
        }else {
            System.out.println("Stringen er: " + lagretfeil);
            int antallfeil = Integer.parseInt(lagretfeil);
            f = antallfeil + f;
        }

        getSharedPreferences("PREFERENCE", MODE_PRIVATE)
                .edit()
                .putString("Fel", Integer.toString(f))
                .apply();
        System.out.println("Lagret feil");

    }

    /*
    Denne funksjonen henter totalt antall riktige fra før dette spillet,
    legger til riktige som oppstod under dette spillet og lagrer totalen
     */
    public void lagreRiktig() {
        String lagretriktig = getSharedPreferences("PREFERENCE", MODE_PRIVATE).getString("Riktig", "");
        if (lagretriktig.equals("")){
            System.out.println("Ingen riktige svar er lagret fra før");
        }else {
            System.out.println("Stringen er: " + lagretriktig);
            int antallriktig = Integer.parseInt(lagretriktig);
            r = antallriktig + r;
        }
        getSharedPreferences("PREFERENCE", MODE_PRIVATE)
                .edit()
                .putString("Riktig", Integer.toString(r))
                .apply();
        System.out.println("Lagret riktige");
    }
}