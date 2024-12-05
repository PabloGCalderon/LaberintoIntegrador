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

        
        if (laberinto[nuevY][nuevX] == 2) {
            
            setxPersonaje(1);
            setyPersonaje(1);
            
            setMuerte(true);
        } else if (laberinto[nuevY][nuevX] == 4) { 
         
            
            setxPersonaje(1);
            setyPersonaje(1);
            
            setVictoria(true);
        } else {
           
            int valorCelda = laberinto[nuevY][nuevX];
            if (valorCelda == 0) {  
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
