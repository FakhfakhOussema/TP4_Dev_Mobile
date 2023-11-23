package com.example.mesureglycemie.model;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mesureglycemie.R;
import com.example.mesureglycemie.view.MainActivity;

public class Patient
{
    private int contenuAge;
    private float niveauGlycemie;
    private boolean isFasting;
    private String message ;

    //Flèche "Update" Controller --> Model
    public Patient(int age, float niveauGlycemie, boolean isFasting)
    {
        this.contenuAge= age;
        this.isFasting=isFasting;
        this.niveauGlycemie=niveauGlycemie;
        calculer();
    }

    public String getResponse()
    {
        return message;
    }

    public int getAge() {return contenuAge;}

    public float getValeurMesuree() {return niveauGlycemie;}

    public boolean isFasting() {return isFasting;}


    private void calculer()
    {
            if (isFasting)
            {
                if (contenuAge >= 13) {
                    if (niveauGlycemie < 5.0)
                        message = "Le niveau de glycémie est bas avant le repas ";
                    else if (niveauGlycemie >= 5.0 && niveauGlycemie <= 7.2)
                        message = "Le niveau de glycémie est nomal avant le repas ";
                    else
                        message = "Le niveau de glycémie est élevé avant le repas";
                } else if (contenuAge >= 6 && contenuAge <= 12)
                    if (niveauGlycemie < 5.0)
                        message = "Le niveau de glycémie est bas avant le repas";
                    else if (niveauGlycemie >= 5.0 && niveauGlycemie <= 10.0)
                        message = "Le niveau de glycémie est normal avant le repas";
                        else
                        message = "Le niveau de glycémie est élevé avant le repas";
                else if (niveauGlycemie < 5.5)
                    message = "Le niveau de glycémie est bas avant le repas";
                else if (niveauGlycemie >= 5.0 && niveauGlycemie <= 10.0)
                    message = "Le niveau de glycémie est normal avant le repas";
                else
                    message = "Le niveau de glycémie est élevé avant le repas";
            }
            else
            if(niveauGlycemie<10.5)
                message="Le niveau de glycémie est normal apres le repas";
            else
                message="Le niveau de glycémie est élevé apres le repas";
        }



}

