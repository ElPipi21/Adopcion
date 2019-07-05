package com.proyectofinal.adopcioncolitas.Clases;

public class Formulario {
    private int idFormulario;
    private String nombrePerForm;
    private String apellidoPerForm;
    private String correoPerForm;
    private String telefonoPerForm;
    private String direccionPerForm;

    public Formulario(int idFormulario, String nombrePerForm, String apellidoPerForm, String correoPerForm, String telefonoPerForm, String direccionPerForm) {
        this.idFormulario = idFormulario;
        this.nombrePerForm = nombrePerForm;
        this.apellidoPerForm = apellidoPerForm;
        this.correoPerForm = correoPerForm;
        this.telefonoPerForm = telefonoPerForm;
        this.direccionPerForm = direccionPerForm;
    }

    public int getIdFormulario() {
        return idFormulario;
    }

    public void setIdFormulario(int idFormulario) {
        this.idFormulario = idFormulario;
    }

    public String getNombrePerForm() {
        return nombrePerForm;
    }

    public void setNombrePerForm(String nombrePerForm) {
        this.nombrePerForm = nombrePerForm;
    }

    public String getApellidoPerForm() {
        return apellidoPerForm;
    }

    public void setApellidoPerForm(String apellidoPerForm) {
        this.apellidoPerForm = apellidoPerForm;
    }

    public String getCorreoPerForm() {
        return correoPerForm;
    }

    public void setCorreoPerForm(String correoPerForm) {
        this.correoPerForm = correoPerForm;
    }

    public String getTelefonoPerForm() {
        return telefonoPerForm;
    }

    public void setTelefonoPerForm(String telefonoPerForm) {
        this.telefonoPerForm = telefonoPerForm;
    }

    public String getDireccionPerForm() {
        return direccionPerForm;
    }

    public void setDireccionPerForm(String direccionPerForm) {
        this.direccionPerForm = direccionPerForm;
    }
}
