package com.pj.sanjuan.juntaelectoral.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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
    private RecyclerView.LayoutManager rvLayoutDepartamento;
    private RecyclerView rvDepartamento;
    private rvAdapterDepartamento adaptadorDepartamento;
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

        JuntaElectoralAPI service = retrofit.create(JuntaElectoralAPI.class);

        final Call<List<Departamento>> lista = service.getDepartamento();
        lista.enqueue(new Callback<List<Departamento>>() {
            @Override
            public void onResponse(Call<List<Departamento>> call, Response<List<Departamento>> response) {
                if(response.isSuccessful()) {
                    listaPersonas = response.body();
                    rvDepartamento=(RecyclerView)findViewById(R.id.rvDepartamentos);

                    // use this setting to improve performance if you know that changes
                    // in content do not change the layout size of the RecyclerView
                    rvDepartamento.setHasFixedSize(true);

                    // use a linear layout manager
                    rvDepartamento.setLayoutManager(new LinearLayoutManager(galleriaEjemploActivity.this));

                    // specify an adapter with the list to show
                    adaptadorDepartamento=new rvAdapterDepartamento(listaPersonas);
                    rvDepartamento.setAdapter(adaptadorDepartamento);
                }
                else{

                }
            }

            @Override
            public void onFailure(Call<List<Departamento>> call, Throwable t) {

            }
        });

    }



}
