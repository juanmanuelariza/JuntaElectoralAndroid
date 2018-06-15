package com.pj.sanjuan.juntaelectoral.io;

import com.pj.sanjuan.juntaelectoral.models.Persona;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by JuanManuel on 14/6/2018.
 */

public interface JuntaElectoralAPI {
    @GET("api/Personas")
    Call<List<Persona>> getPersonas();
}
