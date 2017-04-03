/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Vista.GeneralView;
import Vista.MeseroView;
import java.io.File;
import Controlador.Controlador;

/**
 *
 * @author dacuentas
 */
public class Restaurant91 {
    public static GeneralView generalView;
    public static MeseroView meseroView;
    public static Controlador controlador;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        meseroView = new MeseroView();
        generalView = new GeneralView();
        generalView.setMeseroView(meseroView);
        controlador = new Controlador();
        
        if (new File("archivos/productos.txt").exists() && new File("archivos/platos.txt").exists()){                  
            generalView.setVisible(true);       
            controlador.setMeseroViewToGeneralView(meseroView,generalView);
            controlador.setGeneralViewToMeseroView(meseroView,generalView);
            
        }else{
                  
        }
    }
    
}
