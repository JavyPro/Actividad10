package main;

import controlador.Controlador;
import modelo.Modelo;
import vista.Vista;

public class Main {
    public static void main(String[] args) {
        Modelo mod = new Modelo();
        Vista vis = new Vista();
        Controlador con = new Controlador(vis, mod);
        con.iniciar();
    }
}
