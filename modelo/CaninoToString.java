/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javax.swing.JOptionPane;

/**
 *
 * @author javi1
 */
public class CaninoToString{
    Modelo m = new Modelo();

    int CodC=m.getCodC(), CodF=m.getCodF();
    int edad=m.getEdad();
    
    public CaninoToString(int cod, String nombre, String raza, String color, int edad, String ne) {
        
        
        m.setNombre(nombre);
        m.setRaza(raza);
        m.setColor(color);
        m.setEdad(edad);
        m.setNe(Integer.parseInt(ne));
        m.setCodC(cod);
    }

    public int getCodC() {
        return CodC;
    }

    public void setCodC(int CodC) {
        this.CodC = CodC;
    }

    public int getCodF() {
        return CodF;
    }

    public void setCodF(int CodF) {
        this.CodF = CodF;
    }
    
    public String ConsultarEdad(){
        return ""+m.getEdad();
    }
    
    public String ConsultarCod(){
        return ""+m.getCodC();
    }

    @Override
    public String toString() {
        return "Codigo: "+m.getCodC()+"  Tipo: Canino"+"  Nombre: "+m.getNombre()+"  Raza: "+m.getRaza()+"  Color: "+m.getColor()+"  Edad: "+m.getEdad()+"  Nivel de entrenamiento: "+m.getNe();
    }
    
}
