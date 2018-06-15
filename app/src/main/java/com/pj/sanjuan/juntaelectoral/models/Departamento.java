package com.pj.sanjuan.juntaelectoral.models;
/**
 * Created by JuanManuel on 14/6/2018.
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Departamento {

    @SerializedName("ID")
    @Expose
    private Integer iD;
    @SerializedName("Nombre")
    @Expose
    private String nombre;
    @SerializedName("Zona")
    @Expose
    private Integer zona;

    public Integer getID() {
        return iD;
    }

    public void setID(Integer iD) {
        this.iD = iD;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getZona() {
        return zona;
    }

    public void setZona(Integer zona) {
        this.zona = zona;
    }

}