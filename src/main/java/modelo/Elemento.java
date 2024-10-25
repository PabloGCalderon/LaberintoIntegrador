/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.awt.Graphics;
import javax.swing.ImageIcon;

/**
 *
 * @author lab2-11
 */
public class Elemento
{
    protected int fila;
    protected int x;
    protected int y;
    protected int columna;
    protected ImageIcon imagen;

    public Elemento(int fila, int x, int y, int columna, ImageIcon imagen) {
        this.fila = fila;
        this.x = x;
        this.y = y;
        this.columna = columna;
        this.imagen = imagen;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public ImageIcon getImagen() {
        return imagen;
    }

    public void setImagen(ImageIcon imagen) {
        this.imagen = imagen;
    }
    
    
    public void show(Graphics g)
    {
        imagen.paintIcon(null,g,x,y);
    }
    
    
}
