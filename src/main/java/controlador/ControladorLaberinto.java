/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import modelo.Enemigo;
import modelo.MatrizLaberinto;
import modelo.Personaje;
import vista.DerrotaGUI;
import vista.JuegoGUI;
import vista.PanelJuego;
import vista.VictoriaGUI;

/**
 *
 * @author pablo
 */
public class ControladorLaberinto implements KeyListener, ActionListener
{
    private JuegoGUI juegoGUI;
    private DerrotaGUI derrotaGUI;
    private VictoriaGUI victoriaGUI;
    private MatrizLaberinto matriz;
    private PanelJuego panelJuego;
    private Enemigo enemigo;
    private Personaje personaje;
    private Hilo hilo;


    public ControladorLaberinto(MatrizLaberinto matriz, PanelJuego panelJuego, Enemigo enemigo, Personaje personaje, DerrotaGUI derrotaGUI, 
            VictoriaGUI victoriaGUI)
    {
        this.matriz = matriz;
        this.panelJuego = panelJuego;
        this.enemigo = enemigo;
        this.personaje = personaje;
        this.derrotaGUI = derrotaGUI;
        this.victoriaGUI = victoriaGUI;
        this.juegoGUI = juegoGUI;
        
        hilo=new Hilo(this,matriz,enemigo,panelJuego);
        hilo.start();
    }
    

    
    @Override
    public void keyPressed(KeyEvent e) {
        int Tecla = e.getKeyCode();
       
       switch (Tecla){
          case KeyEvent.VK_UP:
            personaje.mover("ARRIBA", matriz.getlaberinto());
//              System.out.println("Funciona");
            break;
        case KeyEvent.VK_DOWN:
            personaje.mover("ABAJO", matriz.getlaberinto());
//            System.out.println("Funciona");
            break;
        case KeyEvent.VK_LEFT:
            personaje.mover("IZQUIERDA", matriz.getlaberinto());
//            System.out.println("Funciona");           
            break;
        case KeyEvent.VK_RIGHT:
            personaje.mover("DERECHA", matriz.getlaberinto());
//            System.out.println("Funciona");
            break;  
       }
        enemigo.movAleatorio(matriz.getlaberinto());
        panelJuego.repaint();
        panelJuego.requestFocusInWindow();
        muerteTrampa();
        muerteEnemigo();
        victoria();
    }
    
    
    public boolean muerteEnemigo()
    {
        boolean muerte = false;
        if (personaje.getxPersonaje() == enemigo.getxEnemigo() && personaje.getyPersonaje() == enemigo.getyEnemigo()) {
            System.out.println("Te atrapó Solaire");
            muerte = true;
        }

        if (muerte == true)
        {
            personaje.setxPersonaje(1);
            personaje.setyPersonaje(1);
            
            enemigo.setxEnemigo(5);
            enemigo.setyEnemigo(9);
            
            derrotaGUI.setVisible(true);
        }
        return muerte;
    }
        public void muerteTrampa()
        {
            if(personaje.isMuerte()==true)
            {
            derrotaGUI.setVisible(true);
            
            personaje.setxPersonaje(1);
            personaje.setyPersonaje(1);
            
            enemigo.setxEnemigo(5);
            enemigo.setyEnemigo(9);
            }
        }
        
    public void victoria()
    {
       if(personaje.isVictoria()==true)
            {
            victoriaGUI.setVisible(true);
            
            personaje.setxPersonaje(1);
            personaje.setyPersonaje(1);
            
            enemigo.setxEnemigo(5);
            enemigo.setyEnemigo(9);
            
            }   
    }

     @Override
    public void actionPerformed(ActionEvent e) 
    {
   
        switch (e.getActionCommand()) 
        {
            case "btnReintentarDerrota":
                derrotaGUI.setVisible(false);
                break;

           case "btnVolverAlMenuDerrota":
                juegoGUI.setVisible(true);
                derrotaGUI.setVisible(false);
                break;
                
             case "btnReintentaVictoria":
                derrotaGUI.setVisible(false);
                break;

           case "btnVolverAlMenuVictoria":
                juegoGUI.setVisible(true);
                derrotaGUI.setVisible(false);
                break;
        }
    }
    @Override
    public void keyTyped(KeyEvent e)
    {
    }
    @Override
    public void keyReleased(KeyEvent e) 
    {
    }

   
    
}