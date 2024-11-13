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

    public Personaje(int xPersonaje, int yPersonaje) {
        this.xPersonaje = xPersonaje;
        this.yPersonaje = yPersonaje;
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
        
        if(nuevY >=0 && nuevY < laberinto.length && 
           nuevX >=0 && nuevX < laberinto[0].length)
        {
            int valorCelda = laberinto[nuevY][nuevX];
            
            switch(valorCelda)
            {
                case 0:
                    xPersonaje = nuevX;
                    yPersonaje = nuevY;
                    break;
            }
        }
        
        
    }

    public int getxPersonaje() {
        return xPersonaje;
    }

    public int getyPersonaje() {
        return yPersonaje;
    }
      
      
}
