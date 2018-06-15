package com.pj.sanjuan.juntaelectoral.io;

import com.pj.sanjuan.juntaelectoral.models.Departamento;
import com.pj.sanjuan.juntaelectoral.models.Persona;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by JuanManuel on 14/6/2018.
 */

public interface JuntaElectoralAPI {
    @GET("api/CentroDeSalud/Map")
    Call<List<Persona>> getPersonas();

    @GET("api/Departamento")
    Call<List<Departamento>> getDepartamento();

}
