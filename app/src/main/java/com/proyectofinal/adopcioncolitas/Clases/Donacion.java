package com.proyectofinal.adopcioncolitas.Clases;

public class Donacion {

    private int idDonacion;
    private String nombrePerDon;
    private String apellidoPerDon;
    private String correoPerDon;
    private String telefonoPerDon;
    private String direccionPerDon;
    private int montoPerDon;

    public Donacion(int idDonacion, String nombrePerDon, String apellidoPerDon, String correoPerDon, String telefonoPerDon, String direccionPerDon, int montoPerDon) {
        this.idDonacion = idDonacion;
        this.nombrePerDon = nombrePerDon;
        this.apellidoPerDon = apellidoPerDon;
        this.correoPerDon = correoPerDon;
        this.telefonoPerDon = telefonoPerDon;
        this.direccionPerDon = direccionPerDon;
        this.montoPerDon = montoPerDon;
    }

    public int getIdDonacion() {
        return idDonacion;
    }

    public void setIdDonacion(int idDonacion) {
        this.idDonacion = idDonacion;
    }

    public String getNombrePerDon() {
        return nombrePerDon;
    }

    public void setNombrePerDon(String nombrePerDon) {
        this.nombrePerDon = nombrePerDon;
    }

    public String getApellidoPerDon() {
        return apellidoPerDon;
    }

    public void setApellidoPerDon(String apellidoPerDon) {
        this.apellidoPerDon = apellidoPerDon;
    }

    public String getCorreoPerDon() {
        return correoPerDon;
    }

    public void setCorreoPerDon(String correoPerDon) {
        this.correoPerDon = correoPerDon;
    }

    public String getTelefonoPerDon() {
        return telefonoPerDon;
    }

    public void setTelefonoPerDon(String telefonoPerDon) {
        this.telefonoPerDon = telefonoPerDon;
    }

    public String getDireccionPerDon() {
        return direccionPerDon;
    }

    public void setDireccionPerDon(String direccionPerDon) {
        this.direccionPerDon = direccionPerDon;
    }

    public int getMontoPerDon() {
        return montoPerDon;
    }

    public void setMontoPerDon(int montoPerDon) {
        this.montoPerDon = montoPerDon;
    }
}
