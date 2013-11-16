/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaDatos;

/**
 *
 * @author Byron
 */
public class Doctor {
   
    private String NombreDoctor;
    private String Especialidad;
    private String Celular;
    private String Sexo;
    private String RutDoctor;
    private String Email;

    public Doctor(String NombreDoctor, String Especialidad, String Celular, String Sexo,
            String RutDoctor, String Email) {
        this.NombreDoctor = NombreDoctor;
        this.Especialidad = Especialidad;
        this.Celular = Celular;
        this.Sexo = Sexo;
        this.RutDoctor = RutDoctor;
        this.Email = Email;
    }

    public Doctor() {
        NombreDoctor = "";
        Especialidad = "";

        Celular = "";
        Sexo = "";
        RutDoctor = "";
        Email = "";



    }

    public String getNombreDoctor() {
        return NombreDoctor;
    }

    public void setNombreDoctor(String NombreDoctor) {
        this.NombreDoctor = NombreDoctor;
    }

    public String getEspecialidad() {
        return Especialidad;
    }

    public void setEspecialidad(String Especialidad) {
        this.Especialidad = Especialidad;
    }

    public String getCelular() {
        return Celular;
    }

    public void setCelular(String Celular) {
        this.Celular = Celular;
    }

    public String getSexo() {
        return Sexo;
    }

    public void setSexo(String Sexo) {
        this.Sexo = Sexo;
    }

    public String getRutDoctor() {
        return RutDoctor;
    }

    public void setRutDoctor(String RutDoctor) {
        this.RutDoctor = RutDoctor;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }
}
