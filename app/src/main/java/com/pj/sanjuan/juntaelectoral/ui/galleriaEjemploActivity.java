package com.pj.sanjuan.juntaelectoral.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.pj.sanjuan.juntaelectoral.R;
import com.pj.sanjuan.juntaelectoral.io.JuntaElectoralAPI;
import com.pj.sanjuan.juntaelectoral.models.Departamento;
import com.pj.sanjuan.juntaelectoral.models.Persona;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class galleriaEjemploActivity extends AppCompatActivity {
    private final String baseURL = "http://200.0.236.210/AresAPI/";
    TextView tvNombre;
    TextView tvDNI;
    List<Departamento> listaPersonas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_galleria_ejemplo);
        setTitle("Galeria Ejemplo");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        Retrofit retrofit  = new Retrofit.Builder().baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
//
//        tvNombre = (TextView) findViewById(R.id.tvPersonaNombre);
//        tvNombre.setText("asd");

        JuntaElectoralAPI service = retrofit.create(JuntaElectoralAPI.class);

        Call<List<Departamento>> lista = service.getDepartamento();

        lista.enqueue(new Callback<List<Departamento>>() {
            @Override
            public void onResponse(Call<List<Departamento>> call, Response<List<Departamento>> response) {
                if(response.isSuccessful()) {
                    listaPersonas = response.body();
                    tvNombre = (TextView) findViewById(R.id.tvPersonaNombre);
                    tvNombre.setText(response.body().toString());
                }
                else{

                }
            }

            @Override
            public void onFailure(Call<List<Departamento>> call, Throwable t) {

                tvNombre = (TextView) findViewById(R.id.tvPersonaNombre);
                tvNombre.setText("Error");
            }
        });

    }

}
