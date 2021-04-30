package modelo;

import controlador.Controlador;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Modelo {
    private String nombre, raza, color;
    private int ne, prom=0, edad;
    private String lt="", total="";
    private int codF=-1, codC=99, buscar;
    ArrayList<CaninoToString>listaCanino = new ArrayList<CaninoToString>();
    ArrayList<FelinoToString>listaFelino = new ArrayList<FelinoToString>();
    Controlador controlador = new Controlador();


    public Modelo(String nombre, String raza, String color, int edad, String lt) {
        this.nombre = nombre;
        this.raza = raza;
        this.color = color;
        this.edad = edad;
        this.lt = lt;
    }
    public Modelo(String nombre, String raza, String color, int edad, int ne) {
        this.nombre = nombre;
        this.raza = raza;
        this.color = color;
        this.edad = edad;
        this.ne = ne;
    }

    public Modelo() {
        
    }
    
    public ArrayList getListaFelino() {
        return listaFelino;
    }

    public void setListaFelino(ArrayList listaFelino) {
        this.listaFelino = listaFelino;
    }
    
    public ArrayList getListaCanino() {
        return listaCanino;
    }

    public void setListaCanino(ArrayList listaCanino) {
        this.listaCanino = listaCanino;
    }

    public String getNombre() {
        return nombre;
    }

    public String getLt() {
        return lt;
    }

    public void setLt(String lt) {
        this.lt = lt;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    public int getNe() {
        return ne;
    }

    public void setNe(int ne) {
        this.ne = ne;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public int getCodF() {
        return codF;
    }

    public void setCodF(int codF) {
        this.codF = codF;
    }

    public int getCodC() {
        return codC;
    }

    public void setCodC(int codC) {
        this.codC = codC;
    }

    public int getBuscar() {
        return buscar;
    }

    public void setBuscar(int buscar) {
        this.buscar = buscar;
    }

    public int getProm() {
        return prom;
    }

    public void setProm(int prom) {
        this.prom = prom;
    }
    
    
    
    public void CalcularPromedio(){
        
            prom = 0;
            for(int i = 0;i<listaCanino.size();i++){
            prom = prom + Integer.parseInt(listaCanino.get(i).ConsultarEdad());
            }
        
        
            for(int i = 0;i<listaFelino.size();i++){
            prom = prom + Integer.parseInt(listaFelino.get(i).ConsultarEdad());
        
            }
        if(listaCanino.size()+listaFelino.size()<=0){
            JOptionPane.showMessageDialog(null, "Revise bien su registro");
        }
        prom=prom/(listaCanino.size()+listaFelino.size());
    }
    
    public void ActualizarTotal(){
        total="";
        int i=0, j=0;
        while(j<listaCanino.size()){
            
            total = total+listaCanino.get(j).toString()+"\n";
            j++;
        }
                
                
                   
                    
        while(i<listaFelino.size()){
            
            total = total+listaFelino.get(i).toString()+"\n";
            i++;
        } 
                
            
    }
    
    public void LlenarArrays(String j1, String j2, String j3, int j4){
        
        
        if(getLt()=="" && getNe()==0){
                JOptionPane.showMessageDialog(null, "Seleccione un tipo de mascota");
            }
            else{
                if(getLt()==""){
                    codC=codC+1;
                    listaCanino.add(new CaninoToString(codC, j1, j2, j3, j4, String.valueOf(getNe())));
                    int i=0;
                    while(i<listaCanino.size()-1){
                        i++;
                    }
                    total = total+listaCanino.get(i).toString()+"\n";
                    
                    
                }
                else{
                    codF=codF+1;
                    listaFelino.add(new FelinoToString(codF, j1, j2, j3, j4, getLt()));
                    int i=0;
                    while(i<listaFelino.size()-1){
                        i++;
                    }
                    total = total+listaFelino.get(i).toString()+"\n";  
                }
            }
        
            
        controlador.setListaCanino(listaCanino);
        controlador.setListaFelino(listaFelino);
    }

    public void EstablecerTipo(Boolean t1, Boolean t2){
        if(t1==true && t2==true ){
               JOptionPane.showMessageDialog(null, "Error : Seleccione uno");

            }
            else{
                if(t1==true){
                   setLt(JOptionPane.showInputDialog(null, "¿El Gato Esta Libre De Toxoplasmosis? SI/NO"));  
                    if(!(("si".equalsIgnoreCase(getLt())) ||("no".equalsIgnoreCase(getLt())))){
                         
                        JOptionPane.showMessageDialog(null, "Error : Escriba si o no");
                        setLt("");
                    }
                    else{
                        if(("si".equalsIgnoreCase(getLt())) ||("no".equalsIgnoreCase(getLt()))){
                            setLt("Toxoplasmosis: "+getLt());
                            setNe(0);
                        }
            
                    }
                }else{
                    if(t2==true){
                         setNe(Integer.parseInt(JOptionPane.showInputDialog(null,"Escriba Del 0 Al 10 El Nivel De Entrenamiento Del Perro "))); 
                        if (getNe() < 0 || getNe() > 10) {
                             JOptionPane.showMessageDialog(null, "Número Invalido");
                             setNe(0);
                         
                        }
                        else{
                            
                            setLt("");
                        }
                    }
                } 
        }
    }
    public void BuscarEnArray(int codBus){

        if(codBus>=100 && codBus<=200){
            
            for(int i=0;i<listaCanino.size();i++){
                if(String.valueOf(codBus).equalsIgnoreCase(listaCanino.get(i).ConsultarCod())){
                    setBuscar(i);
                }
            }
        }
        else{
            
            if(codBus>=0 && codBus<=99){
                for(int i=0;i<listaFelino.size();i++){
                    if(String.valueOf(codBus).equalsIgnoreCase(listaFelino.get(i).ConsultarCod())){
                        setBuscar(i);
                    }
                }   
            }
            else{
                JOptionPane.showMessageDialog(null, "");
            }
        }
    }
    public void Borrar(int codBus){
        if(codBus>=100 && codBus<=200){
            
            for(int i=0;i<listaCanino.size();i++){
                if(String.valueOf(codBus).equalsIgnoreCase(listaCanino.get(i).ConsultarCod())){
                    setBuscar(i);
                    listaCanino.remove(getBuscar());
                }
            }
        }
        else{
            
            if(codBus>=0 && codBus<=99){
                for(int i=0;i<listaFelino.size();i++){
                    if(String.valueOf(codBus).equalsIgnoreCase(listaFelino.get(i).ConsultarCod())){
                        setBuscar(i);
                        listaFelino.remove(getBuscar());
                    }
                }   
            }
        }
        ActualizarTotal();
        
    }
   

}
