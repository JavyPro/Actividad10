package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JCheckBox;
import modelo.*;
import vista.Vista;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Controlador implements ActionListener{
    private Vista vista;
    private Modelo modelo;
    private CaninoToString canino;
    private FelinoToString felino;
    ArrayList<CaninoToString>listaCanino = new ArrayList<CaninoToString>();
    ArrayList<FelinoToString>listaFelino = new ArrayList<FelinoToString>();
    public Controlador(Vista vista, Modelo modelo) {
        this.vista = vista;
        this.modelo = modelo;
        this.vista.jButton1.addActionListener(this);
        this.vista.jButton2.addActionListener(this);
        this.vista.jButton3.addActionListener(this);
        this.vista.jButton4.addActionListener(this);
        this.vista.jButton5.addActionListener(this);
    } 
    
    

    public Controlador(ArrayList listaCanino, ArrayList listaFelino) {
       this.listaCanino = listaCanino;
       this.listaFelino = listaFelino;
    }

    public Controlador() {
        
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
    
    
    
    public void iniciar(){
            vista.pack();
            vista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            vista.setLocationRelativeTo(null);
            vista.setVisible(true);
    }
    
        
    
    public void actionPerformed(ActionEvent e){
        
        if (vista.jButton1 == e.getSource()) {
            
            modelo.setListaCanino(listaCanino);
            modelo.setListaFelino(listaFelino);
            modelo.LlenarArrays(vista.jTextField1.getText(), vista.jTextField2.getText(), vista.jTextField3.getText(), Integer.parseInt(vista.jTextField4.getText()));
            vista.jTextArea1.setText(modelo.getTotal());
            vista.jTextField1.setText(""); vista.jTextField2.setText(""); vista.jTextField3.setText(""); vista.jTextField4.setText("");
            modelo.CalcularPromedio();
            vista.jTextArea2.setText("Promedio:\n"+String.valueOf(modelo.getProm())+"\n\n"+"Numero de caninos:\n"+listaCanino.size()+"\n\n"+"Numero de felinos:\n"+listaFelino.size());
            modelo.setLt("");
            modelo.setNe(0);
            
            
        }
        if (vista.jButton2 == e.getSource()) {
            modelo.EstablecerTipo(vista.jCheckBox1.isSelected(), vista.jCheckBox2.isSelected());
        }
        if (vista.jButton3 == e.getSource()) {
            modelo.BuscarEnArray(Integer.parseInt(vista.jTextField5.getText()));
            if(Integer.parseInt(vista.jTextField5.getText())>=100 && Integer.parseInt(vista.jTextField5.getText())<=200){
                vista.jTextArea1.setText(String.valueOf(listaCanino.get(modelo.getBuscar()).toString()));
        }
        else{
            
            if(Integer.parseInt(vista.jTextField5.getText())>=0 && Integer.parseInt(vista.jTextField5.getText())<=99){
                vista.jTextArea1.setText(String.valueOf(listaFelino.get(modelo.getBuscar()).toString()));
            }
        }
        }
        if (vista.jButton4 == e.getSource()) {
           modelo.Borrar(Integer.parseInt(vista.jTextField5.getText()));
           vista.jTextArea1.setText(modelo.getTotal());
           
        }
        if (vista.jButton5 == e.getSource()) {
           System.exit(0);
           
        }

    }
    
}

    
    
