/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Archivo;
import Modelo.Restaurant91;
import static Modelo.Restaurant91.generalView;
import Vista.GeneralView;
import Vista.MeseroView;
import Vista.StockView;
import javax.swing.JPanel;
import javax.swing.JTable;

/**
 *
 * @author dacuentas
 */
public class Controlador {
    Restaurant91 restaurant;
    GeneralView generalview;
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
    public void ActualizarMenu(JPanel platosPanel, JPanel bebidasPanel, JPanel postresPanel) {
        archivo.GenerarMenu(platosPanel,bebidasPanel,postresPanel);
    }

    public int getPrice(String name) {
       return archivo.getPrice(name);
    }

    public void setStockViewToGeneralView(StockView stockView, GeneralView generalView) {
        generalView.setStockView(stockView);
    }

    public void nuevoProducto(JTable Table, int i) {
        archivo.nuevoProducto(Table,i);
    }
    public void setGeneralviewToControlador(GeneralView generalview) {
        this.generalview = generalview;
    }
    public void setFtGeneralView(boolean ft){
        generalView.setFt(ft);
    }

    public void agregarBotonesPĺatoView(JPanel botonesPanel) {
        archivo.agregarBotonesPlatoView(botonesPanel);
    }

    public void nuevoPlato(JPanel botonesPanel, String name, String price) {
        archivo.nuevoPlato(botonesPanel, name, price);
    }

    

    
    
}
