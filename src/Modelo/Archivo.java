/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;
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
}

