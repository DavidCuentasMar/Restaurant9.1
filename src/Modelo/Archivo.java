/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author dacuentas
 */
public class Archivo {
    
    public void GenerarMenu(JPanel platosPanel, JPanel bebidasPanel, JPanel postresPanel){
        String platosSrc="archivos/platos.txt";        
        formarMenu(platosSrc, platosPanel, bebidasPanel, postresPanel);
        String productosSrc ="archivos/productos.txt";
        formarMenu(productosSrc , platosPanel, bebidasPanel, postresPanel);
    }
    public int getPriceProducto(String name) {
        String cadena;
        String archivo="archivos/productos.txt";
        try(FileReader f = new FileReader("archivos/productos.txt")){
            BufferedReader b = new BufferedReader(f);            
            while((cadena = b.readLine())!=null) {
                StringTokenizer st = new StringTokenizer(cadena,",");
                while(st.hasMoreElements()){
                    String token=st.nextElement().toString();
                    token=st.nextElement().toString();
                    if (name.equals(token)) {
                        token=st.nextElement().toString();
                        token=st.nextElement().toString();
                        return Integer.parseInt(token);                        
                    }                    
                }
            }
            b.close();
        } catch (IOException ex) {
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return -666;
    }

    private void formarMenu(String ruta, JPanel platosPanel, JPanel bebidasPanel, JPanel postresPanel) {
    String token = "";
    String p="";
    String c="";
        File archivo = new File(ruta);
        try(Scanner lector = new Scanner(archivo)){
            while(lector.hasNextLine()){
                String linea = lector.nextLine();
                StringTokenizer st = new StringTokenizer(linea,",");
                if (ruta.equals("archivos/platos.txt")) {
                    boolean Sw = true;
                    while(Sw){
                        token = st.nextElement().toString();
                        p = st.nextElement().toString();
                        Sw = false;
                    }
                    c = token+" $"+p;
                    JButton B = new JButton(c);
                    platosPanel.add(B);
                    B.setName(token);                    
                }
                if (ruta.equals("archivos/productos.txt")) {
                    boolean Sw = true;
                    while(Sw){
                        token = st.nextElement().toString();
                        if (token.equals("Bebida")) {
                            token = st.nextElement().toString();
                            p = st.nextElement().toString();
                            p = st.nextElement().toString();
                            c = token+" $"+p;
                            JButton B = new JButton(c);
                            bebidasPanel.add(B);
                            B.setName(token);                               
                        }
                        if (token.equals("Postre")) {
                            token = st.nextElement().toString();
                            p = st.nextElement().toString();
                            p = st.nextElement().toString();
                            c = token+" $"+p;
                            JButton B = new JButton(c);
                            postresPanel.add(B);
                            B.setName(token);                            
                        } 
                        Sw=false;
                    }                                     
                }                                             
            }
            
            
            
        }catch(FileNotFoundException ex){
            
        }
    }

    public int getPricePlato(String name) {
        String cadena;
        try(FileReader f = new FileReader("archivos/platos.txt")){
            BufferedReader b = new BufferedReader(f);            
            while((cadena = b.readLine())!=null) {
                StringTokenizer st = new StringTokenizer(cadena,",");
                while(st.hasMoreElements()){
                    String token=st.nextElement().toString();                    
                    if (name.equals(token)) {
                        token=st.nextElement().toString();
                        return Integer.parseInt(token);                        
                    }                    
                }
            }
            b.close();
        } catch (IOException ex) {
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return -666;
    }
}

