/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todo;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Zuriel PC
 */
public class juego {
   JFrame ventana;
   JPanel panelPresentacion;
   JLabel fondopresentacion;
   JLabel fondojuego;
   JLabel Botonjugar;
    JPanel paneljuego;
   JLabel matriz [][];
    int mat [] [];
     String jugador;
    Random aleatoria;
    JLabel nombrejugador;
    int matAux[][];
    Timer tiempo;
    Timer tiempoEspera;
Timer tiempoEspera1;
    JLabel cronometro;
    int min;
    int seg;
    int contador;
    int contSeg;
    int ban;
    int ban1;
   
    
   
   public juego(){
       ventana= new JFrame("Juego de Memoria");
       ventana.setSize(2000,1125);
       ventana.setLayout(null);
       ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       ventana.setLocationRelativeTo(null);
       ventana.setResizable(false);
       
       panelPresentacion = new JPanel();
       panelPresentacion.setSize(ventana.getWidth(),ventana.getHeight());
       panelPresentacion.setLocation(0,0);
       panelPresentacion.setLayout(null);
       panelPresentacion.setVisible(true);
      
       
       fondopresentacion= new JLabel(); 
       fondopresentacion.setSize(ventana.getWidth(),ventana.getHeight());
       fondopresentacion.setLocation(0,0);
       fondopresentacion.setIcon(new ImageIcon("fondos/fondochido.jpg"));
       fondopresentacion.setVisible(true);
       panelPresentacion.add(fondopresentacion,0);
       ventana.add(panelPresentacion);
       
       Botonjugar= new JLabel(); 
       Botonjugar.setSize(110,110);
       Botonjugar.setLocation(25,0);
       Botonjugar.setIcon(new ImageIcon("fondos/america.png"));
       Botonjugar.setVisible(true);
       panelPresentacion.add(Botonjugar,0);
      
       
       paneljuego = new JPanel();
       paneljuego.setSize(ventana.getWidth(),ventana.getHeight());
       paneljuego.setLocation(0,0);
       paneljuego.setLayout(null);
       paneljuego.setVisible(true);
       
       
         fondojuego= new JLabel(); 
       fondojuego.setSize(ventana.getWidth(),ventana.getHeight());
       fondojuego.setLocation(0,0);
       fondojuego.setIcon(new ImageIcon("fondos/fondo2.jpg"));
       fondojuego.setVisible(true);
       paneljuego.add(fondojuego,0);
     
       
       nombrejugador= new JLabel(); 
       nombrejugador.setSize(150,20);
       nombrejugador.setLocation(10,10);
       nombrejugador.setForeground(Color.WHITE);
       nombrejugador.setVisible(true);
       paneljuego.add(nombrejugador,0);
       
       
        cronometro= new JLabel(); 
       cronometro.setSize(150,25);
       cronometro.setLocation(ventana.getWidth()-200,10);
       cronometro.setForeground(Color.WHITE);
       cronometro.setVisible(true);
       paneljuego.add(cronometro,0);
       
       mat= new int [4][5];
         matAux= new int [4][5];
       aleatoria= new Random();
       this.numerosAleatorios();
         
       matriz= new JLabel[4][5];
       for (int i = 0; i < 4; i++) {
           for (int j = 0; j < 5; j++) {
               matriz[i][j]=new JLabel();
             matriz[i][j].setBounds(200 + (j * 150), 400 + (i * 150), 150, 150);
               matriz[i][j].setIcon(new ImageIcon("imagenes/"+matAux[i][j]+".jpg"));
                matriz[i][j].setVisible(true);
                paneljuego.add(matriz[i][j],0);
               
               
           }
           
       }
      
       min=0;
       seg=0;
        tiempo= new Timer (1000, new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                seg++;
                if(seg==60){
                    min++;
                    seg=0;
                }
                cronometro.setText("tiempo : "+min+":"+seg);
            }});
        
        //espera
        contSeg=0;
         tiempoEspera= new Timer (1000, new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
               contSeg++;
            }});
        tiempoEspera.start();
        tiempoEspera.stop();
        contSeg=0;
        ban=0;
        ban1=0;
        
        contador=0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
              matriz[i][j].addMouseListener(new MouseAdapter(){
                  @Override
                  public void mousePressed(MouseEvent e){
                      for (int k = 0; k < 4; k++) {
                          for (int l = 0; l < 5; l++) {
                            if(e.getSource()== matriz [k][l]){
                                //System.out.println(k+" "+l);
                               
                               
                                
                                if(matAux [k][l]==0&& contador !=2){
                                    
                                
                                    matAux[k][l]= mat[k][l];
                                    
                                    matriz[k][l].setIcon(new ImageIcon("imagenes/"+matAux[k][l]+".jpg"));
                                    contador++;
                                   
                                     
                                          tiempoEspera1= new Timer (500, new ActionListener()
                                          {
                                          public void actionPerformed(ActionEvent e)
                                          {
                
                                         
                
                                   
                                     if(contador==2 && ban1==0){
                                        tiempoEspera.restart();
                                        ban1=1;
                                     }
                                    if(contador==2 && contSeg==2){
                                        tiempoEspera.stop();
                                        contSeg=0;
                                        for (int m = 0; m < 4; m++) {
                                            for (int n = 0; n < 5; n++) {
                                                if(matAux[m][n] !=0 && matAux[m][n]!=-1){
                                                   matAux[m][n]= 0;
                                                   matriz[m][n].setIcon(new ImageIcon("imagenes/"+matAux[m][n]+".jpg"));
                                                    System.out.println("hola mundo");
                                                    contador=0;
                                                }
                                                 System.out.println("");
                                            }
                                                
                                            }
                                        tiempoEspera1.stop();
                                        ban1=0;
                                       
                                        }
                                     }});
                                          if(ban==0){
                                              
                                          
                                             tiempoEspera1.start();
                                             ban=1;
                                          }
                                            if(contador==2)
                                        tiempoEspera1.restart();
                                        }
                                       
                                    }
                            }
                            }
                                
                              
                          }
                          
                      
                      
                  
                  
              });
                
            }
           
       }
      
       
       
       Botonjugar.addMouseListener(new MouseAdapter(){
           @Override
           public void mousePressed(MouseEvent e){
               //System.out.print("Presione el boton");
               
             
               jugador=JOptionPane.showInputDialog(ventana,"nombre del jugador","escriba aqui");
               while(jugador==null||jugador.compareTo("escriba qui")==0||jugador.compareTo("")==0){
                   jugador= JOptionPane.showInputDialog(ventana,"Debes ingresar usuario","escribe aqui");
               }
               nombrejugador.setText("Jugador: "+jugador);
               tiempo.start();
               panelPresentacion.setVisible(false);
               ventana.add(paneljuego);
               paneljuego.setVisible(true);
               
           }});
          ventana.add(panelPresentacion);
       ventana.setVisible(true);
   }
public void numerosAleatorios(){
    int acum=0;
     for (int i = 0; i <4; i++) 
        for (int j = 0; j <5; j++) {
    mat[i][j]=0;
    matAux[i][j]=0;
        }
    for (int i = 0; i <4; i++) {
        for (int j = 0; j < 5; j++) {
           mat[i][j]=aleatoria.nextInt(10)+1;
           do{
               acum=0;
           for(int k=0;k< 4; k++){
            for (int l = 0; l < 5; l++) {
                if (mat[i][j]== mat[k][l]){
                    acum +=1;
                    
                }
           
                
            }
            
        }
          if(acum==3)  {
                mat[i][j]=aleatoria.nextInt(10)+1;
              
          }
           }while(acum == 3);
        }
        
    }
    for (int i = 0; i <4; i++) {
        for (int j = 0; j < 5; j++) {
           // System.out.print(mat[i][j]+"  ");
}
          //System.out.println("  ");
}}
}
