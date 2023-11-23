package com.example.mesureglycemie.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.service.controls.Control;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import com.example.mesureglycemie.controller.Controller;

import com.example.mesureglycemie.R;
import com.example.mesureglycemie.model.Patient;

public class MainActivity extends AppCompatActivity
{
    private TextView tvage , tvresultat;
    private SeekBar sbage ;
    private RadioButton rboui ;
    private RadioButton rbnon ;

    private EditText etvaleur;

    private Button btnConsulter ;

    Controller c = new Controller ();

    private void init()
    {
        etvaleur = (EditText) findViewById(R.id.etvaleur);
        sbage = (SeekBar) findViewById(R.id.sbage);
        tvage = (TextView)findViewById(R.id.tvage);
        rboui = (RadioButton) findViewById(R.id.rboui);
        rbnon = (RadioButton) findViewById(R.id.rbnon);
        btnConsulter=(Button) findViewById(R.id.btConsulter);
        tvresultat = (TextView) findViewById(R.id.tvresultat);
    }



    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        sbage.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.i("Information", "onProgressChanged " + progress);
                tvage.setText("Votre âge : " + progress);
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });


        btnConsulter.setOnClickListener(new View.OnClickListener() {
         @Override
        public void onClick(View v)
         {
                Log.i("Information", "button cliqué");
                int age;
                float valeurMesuree;
                boolean verifAge = false, verifValeur = false;
                if(sbage.getProgress()!=0)
                    verifAge = true;
                else
                    Toast.makeText(MainActivity.this, "Veuillez saisir votre age !",
                            Toast.LENGTH_SHORT).show();
                if(!etvaleur.getText().toString().isEmpty())
                    verifValeur = true;
                else
                    Toast.makeText(MainActivity.this, "Veuillez saisir votre valeur mesurée !",
                            Toast.LENGTH_LONG).show();
                if(verifAge && verifValeur)
                {
                    age = sbage.getProgress();
                    valeurMesuree = Float.valueOf(etvaleur.getText().toString());
                    //Flèche "User action" Vue --> Controller
                    c.createPatient(age, valeurMesuree, rboui.isChecked());
                    tvresultat.setText(c.getReponse());
                }
            }
        });


    }
}

