package com.proyectofinal.adopcioncolitas.Clases;

import java.io.Serializable;

public class Mascota implements Serializable {
    private int idMascota;
    private String nombre;
    private String especie;
    private String ciudad;
    private String detalle;
    private int imagenId;

    public Mascota() {
        this.idMascota = idMascota;
        this.nombre = nombre;
        this.especie = especie;
        this.ciudad = ciudad;
        this.detalle = detalle;
        this.imagenId = imagenId;
    }

    public int getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(int idMascota) {
        this.idMascota = idMascota;
    }

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

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public int getImagenId() {
        return imagenId;
    }

    public void setImagenId(int imagenId) {
        this.imagenId = imagenId;
    }
}
