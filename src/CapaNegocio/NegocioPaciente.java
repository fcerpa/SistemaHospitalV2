/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaNegocio;

import CapaDatos.Paciente;
import CapaConexion.Conexion;
import CapaDatos.Tipo_SistemaSalud;

/**
 *
 * @author Byron
 */
public class NegocioPaciente {
    private Conexion cnn;
    Paciente pa=new Paciente();
    Tipo_SistemaSalud ts=new Tipo_SistemaSalud();
    public NegocioPaciente()
    {
        this.cnn=new Conexion();
    }
       
 private void configurarConexion()
    {
        cnn.setDriver("com.mysql.jdbc.Driver");
        cnn.setUrl("jdbc:mysql://localhost:3309/clinica");
        cnn.setNombreBaseDatos("clinica");
        cnn.setNombreTabla("doctor");
        cnn.setUser("root");
        cnn.setPassword("123");
    }
    
    public void ingresoPaciente(){
    this.configurarConexion();
    this.cnn.setEsSelect(false);
    
             
        cnn.setSentenciaSQL("insert into " + cnn.getNombreTabla() +
                " values('"+
                pa.getRutPaciente()+ "','"+
                pa.getNombrePaciente() + "','" + 
                pa.getEdad()+ "','" +
                pa.getSexo() + "','" +
                pa.getHora()+"','"+
                ts.getNom_SistemaSalud()+ "')");
    }
}
