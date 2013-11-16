/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaDatos;

/**
 *
 * @author Byron
 */
public class Paciente {
    String RutPaciente;
    String NombrePaciente;
    String Edad;
    String Sexo;
    String Hora;

    public Paciente(String RutPaciente, String NombrePaciente, String Edad, String Sexo, String Hora) {
        this.RutPaciente = RutPaciente;
        this.NombrePaciente = NombrePaciente;
        this.Edad = Edad;
        this.Sexo = Sexo;
        this.Hora = Hora;
    }
    public Paciente(){
    RutPaciente="";
    NombrePaciente="";
    Edad="";
    Sexo="";
    Hora="";
    }
    

    public String getRutPaciente() {
        return RutPaciente;
    }

    public void setRutPaciente(String RutPaciente) {
        this.RutPaciente = RutPaciente;
    }

    public String getNombrePaciente() {
        return NombrePaciente;
    }

    public void setNombrePaciente(String NombrePaciente) {
        this.NombrePaciente = NombrePaciente;
    }

    public String getEdad() {
        return Edad;
    }

    public void setEdad(String Edad) {
        this.Edad = Edad;
    }

    public String getSexo() {
        return Sexo;
    }

    public void setSexo(String Sexo) {
        this.Sexo = Sexo;
    }

    public String getHora() {
        return Hora;
    }

    public void setHora(String Hora) {
        this.Hora = Hora;
    }
  
       
}
