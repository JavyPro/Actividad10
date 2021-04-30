/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author javi1
 */
public class FelinoToString {
    Modelo m = new Modelo();
    

    int edad=m.getEdad();
    
    public FelinoToString(int cod, String nombre, String raza, String color, int edad, String lt) {
        
        m.setNombre(nombre);
        m.setRaza(raza);
        m.setColor(color);
        m.setEdad(edad);
        m.setLt(lt);
        m.setCodF(cod);
    }
    
    public String ConsultarEdad(){
        return ""+m.getEdad();
    }
    public String ConsultarCod(){
        return ""+m.getCodF();
    }

    @Override
    public String toString() {
        return "Codigo: "+m.getCodF()+"  Tipo: Felino"+"  Nombre:"+m.getNombre()+"  Raza"+m.getRaza()+"  Color"+m.getColor()+"  Edad"+m.getEdad()+"  "+m.getLt();
    }
    
}
