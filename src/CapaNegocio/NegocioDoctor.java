/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaNegocio;

import CapaConexion.Conexion;
import CapaDatos.Doctor;
import java.util.ArrayList;

/**
 *
 * @author Byron
 */
public class NegocioDoctor {

    private Conexion cnn;

    public NegocioDoctor() {
        this.cnn = new Conexion();
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
    
    public void ingresarDoctor(Doctor doc)//Metodo para ingresar los datos a la tabla
            
    {
        this.configurarConexion();
        this.cnn.setEsSelect(false);
                
        cnn.setSentenciaSQL("insert into " + cnn.getNombreTabla() +
                " values('"+
                doc.getRutDoctor()+ "','"+
                doc.getNombreDoctor() + "','" + 
                doc.getEspecialidad()+ "','" +
                doc.getEmail() + "','" +
                doc.getCelular()+"','"+
                doc.getSexo() + "')");
        
        this.cnn.Conectar();
        this.cnn.cerrarConexion();
        System.out.println(this.cnn.getSentenciaSQL());
    }
    
    public void eliminarDoctor(String RutDoctor)
    {
        this.configurarConexion();
        cnn.setEsSelect(false);

        cnn.setSentenciaSQL("Delete from " + 
                            cnn.getNombreTabla() +
                            " where rut='" + 
                            RutDoctor+ "'");        
        cnn.Conectar();                       
        cnn.cerrarConexion(); 
    }
    
    public void modificarDoctor(Doctor doc)
    {
        this.configurarConexion();
        cnn.setEsSelect(false);

        cnn.setSentenciaSQL("Update " + cnn.getNombreTabla() +
                " set nombre='" +doc.getNombreDoctor()+ "',"  +
                
                "especialidad='" + doc.getEspecialidad()+ "'," +
                
                "sexo=" + doc.getSexo() + "," +
                "celular=" + doc.getCelular()+ 
                " where rut='" +  doc.getRutDoctor() + "'");        
        cnn.Conectar();                       
        cnn.cerrarConexion();
    }
    
    public ArrayList getDoctores()
    {
        ArrayList<Doctor> lista = new ArrayList();
        Doctor d = new Doctor();
        this.configurarConexion();
        cnn.setEsSelect(true);
        cnn.setSentenciaSQL("select * from doctor");
        cnn.Conectar();
        try
        {
            while(cnn.getRst().next())
            {
                d.setNombreDoctor(this.cnn.getRst().getString("nombreDoctor"));
                lista.add(d);
                     
            }
        }catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        
        
        return lista;
    }
    
}
