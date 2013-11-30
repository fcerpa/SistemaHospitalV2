/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaConexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Felipe
 */
public class Conexion {
    //////////////////////////////////////////////////
    //Atributos del API JDBC//////////////////////////
    //////////////////////////////////////////////////

    private Connection dbConexion; //Conectar
    private Statement dbSatement; //Enviar los Datos
    private ResultSet dbResulSet; //Retornar los resultados
    //////////////////////////////////////////////////
    //ATRIBUTOS para la conexion//////////////////////
    //////////////////////////////////////////////////
    private String nombreBaseDatos;

    public Conexion(String nombreBaseDatos, String nombreTabla, String user, String password, String sentenciaSQL, boolean esSelect, String driver, String url) {
        this.nombreBaseDatos = nombreBaseDatos;
        this.nombreTabla = nombreTabla;
        this.user = user;
        this.password = password;
        this.sentenciaSQL = sentenciaSQL;
        this.esSelect = esSelect;
        this.driver = driver;
        this.url = url;
    }

    public Conexion() {
        this.nombreBaseDatos = "";
        this.nombreTabla = "";
        this.user = "";
        this.password = "";
        this.sentenciaSQL = "";
        this.esSelect = false;
        this.driver = "";
        this.url = "";

    }
    private String nombreTabla;
    private String user;
    private String password;
    private String sentenciaSQL;
    private boolean esSelect;
    private String driver;
    private String url;

    /**
     * @return the dbConexion
     */
    public Connection getDbConexion() {
        return dbConexion;
    }

    /**
     * @param dbConexion the dbConexion to set
     */
    public void setDbConexion(Connection dbConexion) {
        this.dbConexion = dbConexion;
    }

    /**
     * @return the dbSatement
     */
    public Statement getDbSatement() {
        return dbSatement;
    }

    /**
     * @param dbSatement the dbSatement to set
     */
    public void setDbSatement(Statement dbSatement) {
        this.dbSatement = dbSatement;
    }

    /**
     * @return the dbResulSet
     */
    public ResultSet getDbResulSet() {
        return dbResulSet;
    }

    /**
     * @param dbResulSet the dbResulSet to set
     */
    public void setDbResulSet(ResultSet dbResulSet) {
        this.dbResulSet = dbResulSet;
    }

    /**
     * @return the nombreBaseDatos
     */
    public String getNombreBaseDatos() {
        return nombreBaseDatos;
    }

    /**
     * @param nombreBaseDatos the nombreBaseDatos to set
     */
    public void setNombreBaseDatos(String nombreBaseDatos) {
        this.nombreBaseDatos = nombreBaseDatos;
    }

    /**
     * @return the nombreTabla
     */
    public String getNombreTabla() {
        return nombreTabla;
    }

    /**
     * @param nombreTabla the nombreTabla to set
     */
    public void setNombreTabla(String nombreTabla) {
        this.nombreTabla = nombreTabla;
    }

    /**
     * @return the user
     */
    public String getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the sentenciaSQL
     */
    public String getSentenciaSQL() {
        return sentenciaSQL;
    }

    /**
     * @param sentenciaSQL the sentenciaSQL to set
     */
    public void setSentenciaSQL(String sentenciaSQL) {
        this.sentenciaSQL = sentenciaSQL;
    }

    /**
     * @return the esSelect
     */
    public boolean isEsSelect() {
        return esSelect;
    }

    /**
     * @param esSelect the esSelect to set
     */
    public void setEsSelect(boolean esSelect) {
        this.esSelect = esSelect;
    }

    /**
     * @return the driver
     */
    public String getDriver() {
        return driver;
    }

    /**
     * @param driver the driver to set
     */
    public void setDriver(String driver) {
        this.driver = driver;
    }

    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }

    ///////////////////////////////////
    //Metodo para cerrar la conexion///
    ///////////////////////////////////
    public void cerrarConexion() {
        // HACER CLICK DERECHO  SURROUND STATEMENT --------this.getDbConexion().close();
        try {

            this.getDbConexion().close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    //////////////////////////////////////////////////////
    ///////////Metodo principal para realizar/////////////
    //////la conexion y ejecutar las sentencias SQL///////
    //////////////////////////////////////////////////////

    public void conectar() {
        //cargar driver de conexion   // CLICK DERECHO STATTEMENT---- Class.forName(this.getDriver());
        try {

            Class.forName(this.getDriver());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }

        //Crear una nueva conexion // _CLick derecho Sattement   
        //this.setDbConexion(DriverManager.getConnection(this.getUrl(), this.getUser(), this.getPassword()));
        try {

            this.setDbConexion(DriverManager.getConnection(this.getUrl(), this.getUser(), this.getPassword()));

            //Crear el objeto para ejecutar sentencias SQL
            this.setDbSatement(this.getDbConexion().createStatement());
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
        //Verificar si se ejecuta una Query o un UPDATE
        if (this.isEsSelect() == true) {
            //Ejecutar una QUERY
            //CLICK DERECHO STATTEMENT this.setDbResulSet(this.getDbSatement().executeQuery(this.getSentenciaSQL()));
            try {
                this.setDbResulSet(this.getDbSatement().executeQuery(this.getSentenciaSQL()));
            } catch (SQLException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }


        } else {
            //Ejecutar un UPDATE
            // CLICK DERECHO STATTEMENT this.getDbSatement().executeUpdate(this.getSentenciaSQL());
            try {

                this.getDbSatement().executeUpdate(this.getSentenciaSQL());
            } catch (SQLException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        

    }
}
