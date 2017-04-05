/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.awt.Component;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JToggleButton;

/**
 *
 * @author dacuentas
 */
public class Archivo {
    
    public void GenerarMenu(JPanel platosPanel, JPanel bebidasPanel, JPanel postresPanel){
        File archivo = new File("archivos/productos.txt");        
        try(Scanner lector = new Scanner(archivo)){            
                while(lector.hasNextLine()){
                    String linea = lector.nextLine();
                    StringTokenizer st = new StringTokenizer(linea,",");
                    while(st.hasMoreElements()){
                        String token=st.nextElement().toString();
                        if (token.equals("Bebida")) {
                            token=st.nextElement().toString();
                            JButton B = new JButton(token);
                            bebidasPanel.add(B);
                            B.setName(token);                      
                        }
                        if (token.equals("Postre")) {
                            token=st.nextElement().toString();
                            JButton B = new JButton(token);
                            postresPanel.add(B);
                            B.setName(token);                      
                        }
                        if (token.equals("Plato")) {
                            //addplatoToView
                            token=st.nextElement().toString();
                            JButton B = new JButton(token);
                            postresPanel.add(B);
                            B.setName(token);                      
                        }
                                       
                    }
                                  
                }   
                bebidasPanel.updateUI();
            }catch(FileNotFoundException ex){            
            }
//        String token = "";
//        String name="";
//        String c="";
//        String linea="";
//        StringTokenizer st = new StringTokenizer(linea,",");
//        File archivo = new File("archivos/productos.txt");
//        try(Scanner lector = new Scanner(archivo)){
//            while(lector.hasNextLine()){
//                linea = lector.nextLine();
//                st = new StringTokenizer(linea,",");
//                token = st.nextElement().toString();
//                if (token.equals("Plato")) { 
//                 
//                }
//                if (token.equals("Bebida")) {
//                    token = st.nextElement().toString();
//                    c = token+" $"+st.nextElement().toString();
//                    JButton B = new JButton(c);
//                    bebidasPanel.add(B);
//                    B.setName(token);                               
//                }
//                if (token.equals("Postre")) {
//                    token = st.nextElement().toString();
//                    c = token+" $"+st.nextElement().toString();
//                    JButton B = new JButton(c);
//                    postresPanel.add(B);
//                    B.setName(token);                            
//                }                                                                                                
//            }                                   
//        }catch(FileNotFoundException ex){
//            
//        }
    }
    public int getPrice(String name) {
        String cadena;
        try(FileReader f = new FileReader("archivos/productos.txt")){
            BufferedReader b = new BufferedReader(f);            
            while((cadena = b.readLine())!=null) {
                StringTokenizer st = new StringTokenizer(cadena,",");
                while(st.hasMoreElements()){
                    String token=st.nextElement().toString();
                    token=st.nextElement().toString();
                    if (name.equals(token)) {
                        return Integer.parseInt(st.nextElement().toString());                        
                    }                    
                }
            }
            b.close();
        } catch (IOException ex) {
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return -666;
    }

    public void nuevoProducto(JTable Table, int i) {
        try(FileWriter bw = new FileWriter("archivos/productos.txt", true)){         
            BufferedWriter w = new BufferedWriter(bw);
                Object tipo = Table.getValueAt(i, 0);
                Object nombre = Table.getValueAt(i, 1);
                Object cantidad = Table.getValueAt(i, 2);
                Object precio = Table.getValueAt(i, 3);                
                w.write(tipo+","+nombre+","+cantidad+","+precio);
                w.newLine();
            w.close();
        } catch (IOException ex) {

        }
    }

    public void agregarBotonesPlatoView(JPanel botonesPanel) {
        botonesPanel.removeAll();
        File archivo = new File("archivos/productos.txt");        
        try(Scanner lector = new Scanner(archivo)){            
                while(lector.hasNextLine()){
                    String linea = lector.nextLine();
                    StringTokenizer st = new StringTokenizer(linea,",");
                    while(st.hasMoreElements()){
                        String token=st.nextElement().toString();
                        if (token.equals("Ingrediente")) {
                            token=st.nextElement().toString();
                            JToggleButton JRB = new JToggleButton(token);        
                            botonesPanel.add(JRB);
                            JRB.setName(token);
                            botonesPanel.add(JRB);                        
                        }
                                       
                    }
                                  
                }   
                botonesPanel.updateUI();
            }catch(FileNotFoundException ex){            
            }       
    }

    public void nuevoPlato(JPanel botonesPanel, String name, String price) {
        if (!name.equals("")) {
            Component[] component = botonesPanel.getComponents();
            for (Component component1 : component) {
                if (component1 instanceof JToggleButton){
                    if (((JToggleButton)component1).isSelected()) {
                       System.out.println(((JToggleButton)component1).getName());                        
                    }
                }
            }
        }

    }

    private void addPlatoToMenu(String token) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}

