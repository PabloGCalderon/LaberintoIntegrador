/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import controlador.ControladorLaberinto;

/**
 *
 * @author pablo
 */
public class Personaje 
{
    private int xPersonaje;
    private int yPersonaje;
    private boolean muerte;
    private boolean victoria;
    
    public Personaje(int xPersonaje, int yPersonaje) {
        this.xPersonaje = xPersonaje;
        this.yPersonaje = yPersonaje;
        this.muerte=muerte;
        this.victoria=victoria;
    }
    
      public void mover(String direccion, int[][] laberinto)
    {
        int nuevX = xPersonaje;
        int nuevY = yPersonaje;
        
        switch(direccion)
        {
              case "ARRIBA":
                nuevY--;
                break;
              case "ABAJO":
                nuevY++;
                break;
              case "IZQUIERDA":
                nuevX--;
                break;
                
               case "DERECHA":
                nuevX++;
                break;
        }
        
       if (nuevY >= 0 && nuevY < laberinto.length && nuevX >= 0 && nuevX < laberinto[0].length) {

        // Comprobar si el personaje cayó en el agua (valor 2) o en una celda especial (valor 4)
        if (laberinto[nuevY][nuevX] == 2) {
            
            setxPersonaje(1);
            setyPersonaje(1);
            
            setMuerte(true);
        } else if (laberinto[nuevY][nuevX] == 4) { // Verifica si la celda es 4 (puede ser una trampa, obstáculo, etc.)
         
            
            setxPersonaje(1);
            setyPersonaje(1);
            
            setVictoria(true);
        } else {
            // Mover el personaje solo si la celda no es agua, trampa, ni está fuera de los límites
            int valorCelda = laberinto[nuevY][nuevX];
            if (valorCelda == 0) {  // Si la celda es válida para el movimiento (por ejemplo, 0 es camino libre)
                xPersonaje = nuevX;
                yPersonaje = nuevY;
            }
        }
    }
}

    public int getxPersonaje() {
        return xPersonaje;
    }

    public int getyPersonaje() {
        return yPersonaje;
    }

    public void setxPersonaje(int xPersonaje) {
        this.xPersonaje = xPersonaje;
    }

    public void setyPersonaje(int yPersonaje) {
        this.yPersonaje = yPersonaje;
    }

    public boolean isMuerte() {
        return muerte;
    }

    public void setMuerte(boolean muerte) {
        this.muerte = muerte;
    }

    public boolean isVictoria() {
        return victoria;
    }

    public void setVictoria(boolean victoria) {
        this.victoria = victoria;
    }
    
    
      
      
}
