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
      Random rand = new Random();
        int direccion = rand.nextInt(4); 

        
        int nuevX = xEnemigo;
        int nuevY = yEnemigo;

        switch (direccion) {
            case 0: // Arriba
                nuevY--;
                break;
            case 1: // Abajo
                nuevY++;
                break;
            case 2: // Izquierda
                nuevX--;
                break;
            case 3: // Derecha
                nuevX++;
                break;
        }

       
        if (nuevY >= 0 && nuevY < laberinto.length && nuevX >= 0 && nuevX < laberinto[0].length) {
            if (laberinto[nuevY][nuevX] == 0) { 
                xEnemigo = nuevX;
                yEnemigo = nuevY;
            }
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
