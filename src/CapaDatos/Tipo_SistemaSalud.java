/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaDatos;

/**
 *
 * @author Byron
 */
public class Tipo_SistemaSalud {
    int Tipo_SistemaSalud;
    String Nom_SistemaSalud;
   
    public Tipo_SistemaSalud(int Tipo_SistemaSalud, String Nom_SistemaSalud) {
        this.Tipo_SistemaSalud = Tipo_SistemaSalud;
        this.Nom_SistemaSalud = Nom_SistemaSalud;
    }
    
    public Tipo_SistemaSalud()
    {
    Tipo_SistemaSalud=0;
    Nom_SistemaSalud="";
    
    }
    public int getTipo_SistemaSalud() {
        return Tipo_SistemaSalud;
    }

    public void setTipo_SistemaSalud(int Tipo_SistemaSalud) {
        this.Tipo_SistemaSalud = Tipo_SistemaSalud;
    }

    public String getNom_SistemaSalud() {
        return Nom_SistemaSalud;
    }

    public void setNom_SistemaSalud(String Nom_SistemaSalud) {
        this.Nom_SistemaSalud = Nom_SistemaSalud;
    }

    
    
}
