package com.example.mesureglycemie.controller;

import com.example.mesureglycemie.model.Patient;

public class Controller {
    private static Patient patient;

    public Controller()
    {
        super();
    }


    private static Controller instance = null;

    public static final Controller getInstance() {
        if (Controller.instance == null) {
            Controller.instance = new Controller();
        }
        return Controller.instance;
    }



    //Flèche "Update" Controller --> Model
    public void createPatient(int age, float valeurMesuree, boolean isFasting){
        patient = new Patient(age, valeurMesuree, isFasting);
    }



    //Flèche "Notify" Model --> Controller
    public String getReponse() {
        return patient.getResponse();
    }
}


