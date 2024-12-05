/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vista;

import controlador.ControladorLaberinto;
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
public class PanelJuego extends javax.swing.JPanel 
{
     private MatrizLaberinto matriz;
    private Personaje personaje;
    private Enemigo enemigo;
    private DerrotaGUI derrotaGUI;
    private VictoriaGUI victoriaGUI;
    private ControladorLaberinto controladorLaberinto;
    private Image imgpersonaje, imgenemigo;
    private Image camino, montaña, agua, arbol, cuerno;

    public PanelJuego() {
       
        if (java.beans.Beans.isDesignTime()) 
        {    
        initComponents();
        }
        if (java.beans.Beans.isDesignTime())
        {
            
        matriz = new MatrizLaberinto();
        this.personaje = matriz.getPersonaje();
        this.enemigo = matriz.getEnemigo();
        }
        else
        {
        matriz = new MatrizLaberinto();
        this.personaje = matriz.getPersonaje();
        this.enemigo = matriz.getEnemigo();
        this.controladorLaberinto = controladorLaberinto;
        
        this.derrotaGUI = new DerrotaGUI(controladorLaberinto);
        this.victoriaGUI = new VictoriaGUI(controladorLaberinto); 



        cargarImagenes();

  
        this.controladorLaberinto = new ControladorLaberinto(matriz, this, enemigo, personaje, derrotaGUI, victoriaGUI);
        this.addKeyListener(controladorLaberinto);

        this.setPreferredSize(new Dimension(400, 400));
        this.setFocusable(true);
        this.requestFocusInWindow();
          
    }
    }
    
    public void addNotify() 
    {
        super.addNotify();
        this.requestFocusInWindow(); 
    }

    private void cargarImagenes() {
        camino = new ImageIcon(getClass().getResource("/img/Tierra.png")).getImage();
        arbol = new ImageIcon(getClass().getResource("/img/Arbol.png")).getImage();
        agua = new ImageIcon(getClass().getResource("/img/aguaLaberinto.png")).getImage();
        montaña = new ImageIcon(getClass().getResource("/img/Montaña.png")).getImage();
        cuerno = new ImageIcon(getClass().getResource("/img/ObjetoVictoria.png")).getImage();
        imgpersonaje = new ImageIcon(getClass().getResource("/img/PersonajeMain.png")).getImage();
        imgenemigo = new ImageIcon(getClass().getResource("/img/Solaire.png")).getImage(); 
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

         if(java.beans.Beans.isDesignTime())
        {
            g.drawString("PanelJuego(diseno)", 10, 20);
            return;
        }
       
        int[][] laberinto = matriz.getlaberinto();
        int size = 50; 

        for (int y = 0; y < laberinto.length; y++) {
            for (int x = 0; x < laberinto[y].length; x++) {
                switch (laberinto[y][x]) {
                    case 0:
                        g.drawImage(camino, x * size, y * size, size, size, this);
                        break;
                    case 1:
                        g.drawImage(arbol, x * size, y * size, size, size, this);
                        break;
                    case 2:
                        g.drawImage(agua, x * size, y * size, size, size, this);
                        break;
                    case 3:
                        g.drawImage(montaña, x * size, y * size, size, size, this);
                        break;
                    case 4:
                        g.drawImage(cuerno, x * size, y * size, size, size, this);
                        break;
                }
            }
        }

      
        int personajeX = personaje.getxPersonaje();
        int personajeY = personaje.getyPersonaje();
        g.drawImage(imgpersonaje, personajeX * size, personajeY * size, size, size, this);

        int enemigoX = enemigo.getxEnemigo();
        int enemigoY = enemigo.getyEnemigo();
        g.drawImage(imgenemigo, enemigoX * size, enemigoY * size, size, size, this);
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

