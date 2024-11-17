/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import modelo.Enemigo;
import modelo.MatrizLaberinto;
import modelo.Personaje;
import vista.PanelJuego;

/**
 *
 * @author pablo
 */
public class ControladorLaberinto implements KeyListener
{
    private MatrizLaberinto matriz;
    private PanelJuego panelJuego;
    private Enemigo enemigo;
    private Personaje personaje;
    private Hilo hilo;
     

    public ControladorLaberinto(MatrizLaberinto matriz, PanelJuego panelJuego, Enemigo enemigo, Personaje personaje) {
        this.matriz = matriz;
        this.panelJuego = panelJuego;
        this.enemigo = enemigo;
        this.personaje = personaje;
        hilo=new Hilo(this,matriz,enemigo,panelJuego);
        hilo.start();
    }
    

    
    @Override
    public void keyPressed(KeyEvent e) {
        int Tecla = e.getKeyCode();
       
       switch (Tecla){
          case KeyEvent.VK_UP:
            personaje.mover("ARRIBA", matriz.getlaberinto());
              System.out.println("Funciona");
            break;
        case KeyEvent.VK_DOWN:
            personaje.mover("ABAJO", matriz.getlaberinto());
            System.out.println("Funciona");
            break;
        case KeyEvent.VK_LEFT:
            personaje.mover("IZQUIERDA", matriz.getlaberinto());
            System.out.println("Funciona");           
            break;
        case KeyEvent.VK_RIGHT:
            personaje.mover("DERECHA", matriz.getlaberinto());
            System.out.println("Funciona");
            break;  
       }
        enemigo.movAleatorio(matriz.getlaberinto());
        panelJuego.repaint();
        panelJuego.requestFocusInWindow();

    }
    
    @Override
    public void keyTyped(KeyEvent e)
    {
    }


    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
