package com.pj.sanjuan.juntaelectoral.models;

/**
 * Created by JuanManuel on 14/6/2018.
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Persona {

    @SerializedName("ID")
    @Expose
    private Integer iD;
    @SerializedName("Nombre")
    @Expose
    private String nombre;
    @SerializedName("Apellido")
    @Expose
    private String apellido;
    @SerializedName("DNI")
    @Expose
    private Integer dNI;

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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getDNI() {
        return dNI;
    }

    public void setDNI(Integer dNI) {
        this.dNI = dNI;
    }

}

