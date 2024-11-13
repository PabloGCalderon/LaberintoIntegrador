/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.Random;

/**
 *
 * @author pablo
 */
public class Enemigo 
{
 private int xEnemigo;
 private int yEnemigo;
 private Random random = new Random();

    public Enemigo(int xEnemigo, int yEnemigo) {
        this.xEnemigo = xEnemigo;
        this.yEnemigo = yEnemigo;
    }
 
 public void movAleatorio(int[][] laberinto)
 {
     int mover = random.nextInt(1);
     switch(mover)
     {
         case 0://mover arriba
             if(yEnemigo > 0 && laberinto[yEnemigo - 1][xEnemigo]==0)
             {
                 yEnemigo--;
             }
           break;
         case 1://Mver abajo
              if(yEnemigo < laberinto.length -1 && laberinto[yEnemigo + 1][xEnemigo]==0)
             {
                 yEnemigo++;
             }
           break;
           
         case 2://Mover izq
              if(xEnemigo > 0 && laberinto[yEnemigo][xEnemigo-1]==0)
             {
                 xEnemigo--;
             }
             break;
             
         case 3://mover der
             if(xEnemigo <  laberinto[0].length - 1 && laberinto[yEnemigo][xEnemigo+1]==0)
             {
                 xEnemigo++;
             }
             break;
     }

 }

    public int getxEnemigo() {
        return xEnemigo;
    }

    public void setxEnemigo(int xEnemigo) {
        this.xEnemigo = xEnemigo;
    }

    public int getyEnemigo() {
        return yEnemigo;
    }

    public void setyEnemigo(int yEnemigo) {
        this.yEnemigo = yEnemigo;
    }
}
