/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Enemigo;
import modelo.MatrizLaberinto;
import vista.PanelJuego;

/**
 *
 * @author pablo
 */
public class Hilo extends Thread
{
    private ControladorLaberinto controlador;
    private MatrizLaberinto matriz;
    private Enemigo enemigo;
    private PanelJuego panelJuego;
    
  public Hilo(ControladorLaberinto controlador, MatrizLaberinto matriz, Enemigo enemigo, PanelJuego panelJuego) {
    this.controlador = controlador;
    this.enemigo = enemigo;
    this.matriz = matriz;
    this.panelJuego = panelJuego;
}    
  
    public void run()
    {
        while(true)
        {
            try {
                 enemigo.movAleatorio(matriz.getlaberinto());
                 panelJuego.repaint();
                sleep(200);
            } catch (InterruptedException ex) {
                Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }    
    
}
