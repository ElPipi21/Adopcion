package com.proyectofinal.adopcioncolitas.Clases;

import java.io.Serializable;

public class Mascota implements Serializable {
    private String nombre;
    private String especie;
    private String ciudad;
    private int imagenId;
    private String detalle;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int getImagenId() {
        return imagenId;
    }

    public void setImagenId(int imagenId) {
        this.imagenId = imagenId;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public Mascota(String nombre, String especie, String ciudad, int imagenId, String detalle) {
        this.nombre = nombre;
        this.especie = especie;
        this.ciudad = ciudad;
        this.imagenId = imagenId;
        this.detalle = detalle;



    }
}
