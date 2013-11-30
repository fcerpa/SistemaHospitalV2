/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaNegocio;

import CapaDatos.Datos;
import CapaConexion.Conexion;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Byron
 */
public class NegocioPaciente {
    private Conexion cnn;
    
    
    
    public NegocioPaciente()
    {
        this.cnn=new Conexion();
    }
       
 private void configurarConexion()
    {
        cnn.setDriver("com.mysql.jdbc.Driver");
        cnn.setUrl("jdbc:mysql://localhost:3309/clinica");
        cnn.setNombreBaseDatos("clinica");
        cnn.setNombreTabla("paciente");
        cnn.setUser("root");
        cnn.setPassword("123");
    }
    
    public void ingresoPaciente(Datos Pac) {
        this.configurarConexion();
        this.cnn.setEsSelect(false);

        cnn.setSentenciaSQL("insert into " + cnn.getNombreTabla()
                + " values('" + Pac.getRutPaciente() + "','"
                              + Pac.getNombrePaciente()+ "','" 
                              + Pac.getEdadPaciente() + "','" 
                              + Pac.getSexoPaciente() + "','"
                              + Pac.getHoraPaciente() +"','"
                              + Pac.getTipoAtencion() +"','"
                              + Pac.getFechaAtencion()+"','"
                              + Pac.getTipoSistemaSalud()+"','"
                              + Pac.getNombreSistemaSalud()+"','"
                              + Pac.getNombreEspecialidad()+"','"
                              + Pac.getTipoCirugia()+"');");

        //insert into Paciente values('1213','byron','20','mascuulino','13:00');


        this.cnn.conectar();
        this.cnn.cerrarConexion();
        System.out.println(this.cnn.getSentenciaSQL());
    }
    
    
    public Datos buscarDatos(Integer RutPaciente) {
        Datos Paciente = new Datos();
        this.configurarConexion();

        cnn.setEsSelect(true);
        cnn.setSentenciaSQL("select * from "
                + cnn.getNombreTabla()
                + " where RutPaciente=" + RutPaciente);
        cnn.conectar();
        try {
            if (cnn.getDbResulSet().next()) {
                Paciente.setRutPaciente(cnn.getDbResulSet().getInt("RutPaciente"));
                Paciente.setNombrePaciente(cnn.getDbResulSet().getString("NombrePaciente"));
                Paciente.setHoraPaciente(cnn.getDbResulSet().getString("Hora"));
               Paciente.setEdadPaciente(cnn.getDbResulSet().getString("Edad"));
              Paciente.setSexoPaciente(cnn.getDbResulSet().getString("sexo"));
              Paciente.setTipoAtencion(cnn.getDbResulSet().getString("TipoAtencion"));
              Paciente.setFechaAtencion(cnn.getDbResulSet().getString("FechaAtencion"));
              Paciente.setTipoSistemaSalud(cnn.getDbResulSet().getString("TipoSistemaSalud"));
              Paciente.setNombreSistemaSalud(cnn.getDbResulSet().getString("NombreSistemaSalud"));
              Paciente.setNombreEspecialidad(cnn.getDbResulSet().getString("NombreEspecialidad"));
              Paciente.setTipoCirugia(cnn.getDbResulSet().getString("TipoCirugia"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CapaNegocio.NegocioPaciente.class.getName()).log(Level.SEVERE, null, ex);
        }
        cnn.cerrarConexion();
        return Paciente;
    }
}
