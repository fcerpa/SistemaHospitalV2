/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaNegocio;

import CapaConexion.Conexion;
import CapaDatos.Datos;
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
    
 public void configurarConexion()
    {
        cnn.setDriver("com.mysql.jdbc.Driver");
        cnn.setUrl("jdbc:mysql://localhost:3309/clinica");
        cnn.setNombreBaseDatos("clinica");
        cnn.setNombreTabla("doctor");
        cnn.setUser("root");
        cnn.setPassword("123");
    }
    
    public void ingresarDoctor(Datos doc)//Metodo para ingresar los datos a la tabla
            
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
                doc.getSexoDoctor()+  "');");
        
        this.cnn.conectar();
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
        cnn.conectar();                       
        cnn.cerrarConexion(); 
    }
    
    public void modificarDoctor(Datos doc)
    {
        this.configurarConexion();
        cnn.setEsSelect(false);

        cnn.setSentenciaSQL("Update " + cnn.getNombreTabla() +
                " set nombre='" +doc.getNombreDoctor()+ "',"  +
                
                "especialidad='" + doc.getEspecialidad()+ "'," +
                
                "sexo=" + doc.getSexoDoctor()+ "," +
                "celular=" + doc.getCelular()+ 
                " where rut='" +  doc.getRutDoctor() + "'");        
        cnn.conectar();                       
        cnn.cerrarConexion();
    }
   
    public ArrayList getDoctores()
    {
        ArrayList<Datos> lista = new ArrayList();
        Datos d = new Datos();
        this.configurarConexion();
        cnn.setEsSelect(true);
        cnn.setSentenciaSQL("select * from doctor");
        cnn.conectar();
        try
        {
            while(cnn.getDbResulSet().next())
            {
                d.setNombreDoctor(this.cnn.getDbResulSet().getString("nombreDoctor"));
                lista.add(d);
                     
            }
        }catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        
        
        return lista;
    }
    
}
