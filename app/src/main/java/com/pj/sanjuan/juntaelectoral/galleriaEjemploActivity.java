package com.pj.sanjuan.juntaelectoral;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class galleriaEjemploActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_galleria_ejemplo);
        setTitle("Galeria Ejemplo");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
