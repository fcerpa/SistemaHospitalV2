/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaConexion;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Byron
 */
public class Conexion {
    private String nombreBaseDatos;
    private String nombreTabla;
    private String sentenciaSQL;
    private String driver;
    private String url;
    private String user;
    private String password;
    private boolean esSelect;
    
    private Connection cnn;
    private Statement stm;
    private ResultSet rst;
    
      public Conexion(String nombreBaseDatos, String nombreTabla, String sentenciaSQL,
            String driver, String url, String user, String password, boolean esSelect) {
        this.nombreBaseDatos = nombreBaseDatos;
        this.nombreTabla = nombreTabla;
        this.sentenciaSQL = sentenciaSQL;
        this.driver = driver;
        this.url = url;
        this.user = user;
        this.password = password;
        this.esSelect = esSelect;

    }
      
      public Conexion(){
      nombreBaseDatos="";
      nombreTabla="";
      sentenciaSQL="";
      driver="";
      url="";
      user="";
      password="";
      esSelect=false;
      
      }

    public String getNombreBaseDatos() {
        return nombreBaseDatos;
    }

    public void setNombreBaseDatos(String nombreBaseDatos) {
        this.nombreBaseDatos = nombreBaseDatos;
    }

    public String getNombreTabla() {
        return nombreTabla;
    }

    public void setNombreTabla(String nombreTabla) {
        this.nombreTabla = nombreTabla;
    }

    public String getSentenciaSQL() {
        return sentenciaSQL;
    }

    public void setSentenciaSQL(String sentenciaSQL) {
        this.sentenciaSQL = sentenciaSQL;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEsSelect() {
        return esSelect;
    }

    public void setEsSelect(boolean esSelect) {
        this.esSelect = esSelect;
    }

    public Connection getCnn() {
        return cnn;
    }

    public void setCnn(Connection cnn) {
        this.cnn = cnn;
    }

    public Statement getStm() {
        return stm;
    }

    public void setStm(Statement stm) {
        this.stm = stm;
    }

    public ResultSet getRst() {
        return rst;
    }

    public void setRst(ResultSet rst) {
        this.rst = rst;
    }

    // metodo principal de la conexion 

    
    public void Conectar (){
        try {
             Class.forName(this.getDriver());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
        try {
            //Crear la conexión
            this.setCnn(DriverManager.getConnection(this.getUrl(), 
                            this.getUser(), this.getPassword()));
            //Crear objeto para ejecutar sentencias SQL
            this.setStm(this.getCnn().createStatement());            
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
        
        //Verificar si ejecutar una QUERY o un UPDATE
        if(this.isEsSelect() == true)
        {
            try {
                //Ejecutar una QUERY
                this.setRst(this.getStm().executeQuery(this.getSentenciaSQL()));
            } catch (SQLException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else
        {
            try {
                //Ejecutar un UPDATE
                this.getStm().executeUpdate(this.getSentenciaSQL());
            } catch (SQLException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }                       
    }
          public void cerrarConexion()
    {
        try {
            this.cnn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
