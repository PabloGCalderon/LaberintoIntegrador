/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vista;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import modelo.Enemigo;
import modelo.MatrizLaberinto;
import modelo.Personaje;

/**
 *
 * @author pablo
 */
public class PanelJuego extends javax.swing.JPanel {
    private MatrizLaberinto matriz;
    private Personaje personaje;
    private Enemigo enemigo;
    private Image imgpersonaje,imgenemigo;
    private Image camino,montaña, agua,arbol, meta;
    
    public PanelJuego()
    {
        
        initComponents();
        this.personaje=personaje;//declarar personaje
        this.enemigo =enemigo;//declarar enemigo
        this.matriz = new MatrizLaberinto ();//declarar matriz
        cargarImagenes();// declarar imagenes
        this.setPreferredSize(new Dimension(400,400)); // tamaño de preferencia
        this.setFocusable(true); // mantener el panel en foco
        this.requestFocusInWindow();
    }
    
  private void cargarImagenes()
{
        camino = new ImageIcon(getClass().getResource("/img/Tierra.png")).getImage();
        arbol = new ImageIcon(getClass().getResource("/img/Arbol.png")).getImage();
        agua = new ImageIcon(getClass().getResource("/img/aguaLaberinto.png")).getImage();
        montaña = new ImageIcon(getClass().getResource("/img/Montaña.png")).getImage();
        //meta = new ImageIcon(getClass().getResource("/img/meta.png")).getImage();
        imgpersonaje = new ImageIcon(getClass().getResource("/img/PersonajeMain.png")).getImage();
        imgenemigo = new ImageIcon(getClass().getResource("/img/Solaire.png")).getImage();
    }
  
  
  
      @Override
    protected void paintComponent (Graphics g){
        super.paintComponent(g);
        // La matriz debe existir
        int [][] laberinto = matriz.getlaberinto();
        
        // tamaño celdas
        int size =50;
        
        for (int y =0; y< laberinto.length;y++){
            for (int x = 0; x< laberinto[y].length;x++){
                switch(laberinto[y][x]){
                    case 0:
                        g.drawImage(camino,x* size, y * size,size,size,this);
                        break;
                    case 1:
                        g.drawImage(arbol,x* size, y * size,size,size,this);
                        break;
                    case 2:
                        g.drawImage(agua,x* size, y * size,size,size,this);
                        break;
                    case 3:
                        g.drawImage(montaña,x* size, y * size,size,size,this);
                        break;
                    //case 4:
                       // g.drawImage(meta,x* size, y * size,size,size,this);
                        //break;    
                }
            }
        }
        g.drawImage(agua, size, size, this);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

