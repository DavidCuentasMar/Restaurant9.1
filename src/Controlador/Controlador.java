/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Archivo;
import Modelo.Restaurant91;
import Vista.GeneralView;
import Vista.MeseroView;
import javax.swing.JPanel;

/**
 *
 * @author dacuentas
 */
public class Controlador {
    Restaurant91 restaurant;
    Archivo archivo = new Archivo();

    public void setRestaurant(Restaurant91 restaurant) {
        this.restaurant = restaurant;
    }

    public void setMeseroViewToGeneralView(MeseroView meseroView,GeneralView generalView) {
        generalView.setMeseroView(meseroView);
    }

    public void setGeneralViewToMeseroView(MeseroView meseroView, GeneralView generalView) {
        meseroView.setGeneralView(generalView);
    }

    public void GenerarMenu(JPanel platosPanel, JPanel bebidasPanel, JPanel postresPanel) {
        archivo.GenerarMenu(platosPanel,bebidasPanel,postresPanel);
    }
    
    
}
