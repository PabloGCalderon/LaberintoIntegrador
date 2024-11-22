/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author pablo
 */
public class MatrizLaberinto {
    
    private int [][] laberinto;
    private Personaje personaje;
    private Enemigo enemigo;
    
    public MatrizLaberinto () {
        //Definir tamaño matriz
        laberinto = new int [][]{
        {3,3,3,3,3,3,3,3,3,3,3,3},
        {3,0,0,3,0,0,0,3,0,0,0,3},
        {3,0,0,3,0,2,0,1,0,0,0,3},
        {3,0,0,3,0,2,0,2,2,2,0,3},
        {3,0,3,3,0,2,0,0,0,0,0,3},
        {3,0,0,0,0,0,0,0,3,0,1,3},
        {3,0,0,2,0,1,1,1,1,0,1,3},
        {3,0,1,2,0,0,3,0,0,0,0,3},
        {3,0,1,0,0,0,3,2,0,1,1,3},
        {3,0,1,3,1,0,3,0,0,0,0,3},
        {3,0,0,0,1,0,3,0,0,3,4,3},
        {3,3,3,3,3,3,3,3,3,3,3,3}
        };
        
        //Inicializar al personaje y al enemigo
        
         personaje = new Personaje(1,1);
         enemigo = new Enemigo(5,9);
    }
    
    public int [][] getlaberinto(){
        return laberinto;
    }

    public Personaje getPersonaje() {
        return personaje;
    }

    public Enemigo getEnemigo() {
        return enemigo;
    }
    
}
