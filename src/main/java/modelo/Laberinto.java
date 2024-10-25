/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author lab2-11
 */
public class Laberinto
{
    private int [][] laberinto;
    
    public Laberinto()    
    {
        
        int[][] laberinto=
        {
            
            {0,0,1,0,0,0,1,0,0,0,
            0,0,1,0,1,0,1,0,0,0,
            0,0,1,0,1,0,1,1,1,0,
            0,1,1,0,1,0,0,0,0,0,
            0,0,0,0,0,0,0,1,0,1,
            0,0,1,0,1,1,1,1,0,1,
            0,1,1,0,0,1,0,0,0,0,
            0,1,0,0,0,1,1,0,1,1,
            0,1,1,1,0,1,0,0,2,0,
            0,0,0,1,0,1,0,0,1,0}
                
         };
        
          this.laberinto=laberinto;
            
        }
        public int getCelda(int fila,int columna)
        {
            return laberinto[fila][columna];
        }
          
        
    }
    

