/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaDatos;

/**
 *
 * @author Byron
 */
public class Datos {
    private Integer RutPaciente;
    private String NombrePaciente;
    private String EdadPaciente;
    private String SexoPaciente;
    private String HoraPaciente;
    private String TipoAtencion;
    private String FechaAtencion;
    private String TipoSistemaSalud;
    private String nombreSistemaSalud;
    private String NombreEspecialidad;
    private String TipoCirugia;
//////////////////////////////////////////////
    //Doctor//
    private String  NombreDoctor;
    private String  Especialidad;
    private String  Celular;
    private String  SexoDoctor;
    private Integer RutDoctor;
    private String  Email;

    public Datos(Integer RutPaciente, String NombrePaciente, String EdadPaciente, 
            String SexoPaciente, String HoraPaciente, String TipoAtencion, String FechaAtencion, 
            String TipoSistemaSalud, String nombreSistemaSalud, String NombreEspecialidad, String TipoCirugia, 
            String NombreDoctor, String Especialidad, String Celular, String SexoDoctor, Integer RutDoctor, String Email) {
        this.RutPaciente = RutPaciente;
        this.NombrePaciente = NombrePaciente;
        this.EdadPaciente = EdadPaciente;
        this.SexoPaciente = SexoPaciente;
        this.HoraPaciente = HoraPaciente;
        this.TipoAtencion = TipoAtencion;
        this.FechaAtencion = FechaAtencion;
        this.TipoSistemaSalud = TipoSistemaSalud;
        this.nombreSistemaSalud = nombreSistemaSalud;
        this.NombreEspecialidad = NombreEspecialidad;
        this.TipoCirugia = TipoCirugia;
        this.NombreDoctor = NombreDoctor;
        this.Especialidad = Especialidad;
        this.Celular = Celular;
        this.SexoDoctor = SexoDoctor;
        this.RutDoctor = RutDoctor;
        this.Email = Email;
    }
    public Datos(){
     RutPaciente=0;
     NombrePaciente="";
     EdadPaciente="";
     SexoPaciente="";
     HoraPaciente="";
     TipoAtencion="";
     FechaAtencion="";
     TipoSistemaSalud="";
     nombreSistemaSalud="";
     NombreEspecialidad="";
     TipoCirugia="";
     /////////////////////////
     
      NombreDoctor="";
      Especialidad="";
      Celular="";
      SexoDoctor="";
      RutDoctor=0;
      Email="";
    
    }

    public Integer getRutPaciente() {
        return RutPaciente;
    }

    public void setRutPaciente(Integer RutPaciente) {
        this.RutPaciente = RutPaciente;
    }

    public String getNombrePaciente() {
        return NombrePaciente;
    }

    public void setNombrePaciente(String NombrePaciente) {
        this.NombrePaciente = NombrePaciente;
    }

    public String getEdadPaciente() {
        return EdadPaciente;
    }

    public void setEdadPaciente(String EdadPaciente) {
        this.EdadPaciente = EdadPaciente;
    }

    public String getSexoPaciente() {
        return SexoPaciente;
    }

    public void setSexoPaciente(String SexoPaciente) {
        this.SexoPaciente = SexoPaciente;
    }

    public String getHoraPaciente() {
        return HoraPaciente;
    }

    public void setHoraPaciente(String HoraPaciente) {
        this.HoraPaciente = HoraPaciente;
    }

    public String getTipoAtencion() {
        return TipoAtencion;
    }

    public void setTipoAtencion(String TipoAtencion) {
        this.TipoAtencion = TipoAtencion;
    }

    public String getFechaAtencion() {
        return FechaAtencion;
    }

    public void setFechaAtencion(String FechaAtencion) {
        this.FechaAtencion = FechaAtencion;
    }

    public String getTipoSistemaSalud() {
        return TipoSistemaSalud;
    }

    public void setTipoSistemaSalud(String TipoSistemaSalud) {
        this.TipoSistemaSalud = TipoSistemaSalud;
    }

    public String getNombreSistemaSalud() {
        return nombreSistemaSalud;
    }

    public void setNombreSistemaSalud(String nombreSistemaSalud) {
        this.nombreSistemaSalud = nombreSistemaSalud;
    }

    public String getNombreEspecialidad() {
        return NombreEspecialidad;
    }

    public void setNombreEspecialidad(String NombreEspecialidad) {
        this.NombreEspecialidad = NombreEspecialidad;
    }

    public String getTipoCirugia() {
        return TipoCirugia;
    }

    public void setTipoCirugia(String TipoCirugia) {
        this.TipoCirugia = TipoCirugia;
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

    public String getSexoDoctor() {
        return SexoDoctor;
    }

    public void setSexoDoctor(String SexoDoctor) {
        this.SexoDoctor = SexoDoctor;
    }

    public Integer getRutDoctor() {
        return RutDoctor;
    }

    public void setRutDoctor(Integer RutDoctor) {
        this.RutDoctor = RutDoctor;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }
    




}
