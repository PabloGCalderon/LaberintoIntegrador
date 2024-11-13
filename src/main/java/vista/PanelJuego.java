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
    private ControladorLaberinto controladorLaberinto;
    private Image imgpersonaje, imgenemigo;
    private Image camino, montaña, agua, arbol;

    public PanelJuego() {
        
        initComponents();
        
        // Crear la matriz y obtener personaje y enemigo
        this.matriz = new MatrizLaberinto();
        this.personaje = matriz.getPersonaje();
        this.enemigo = matriz.getEnemigo();
        
        // Inicializar imágenes
        cargarImagenes();
        
        // Inicializar controlador y asignarlo como KeyListener
        this.controladorLaberinto = new ControladorLaberinto(matriz, this, enemigo, personaje);
        this.addKeyListener(controladorLaberinto);
        
        // Configuración del panel
        this.setPreferredSize(new Dimension(400, 400));
        this.setFocusable(true);
        this.requestFocusInWindow(); // Para asegurar que el panel reciba eventos de teclado
    }
    
    
    public void addNotify() {
        super.addNotify();
        this.requestFocusInWindow(); // Solicitar foco después de ser añadido al contenedor
    }

    private void cargarImagenes() {
        camino = new ImageIcon(getClass().getResource("/img/Tierra.png")).getImage();
        arbol = new ImageIcon(getClass().getResource("/img/Arbol.png")).getImage();
        agua = new ImageIcon(getClass().getResource("/img/aguaLaberinto.png")).getImage();
        montaña = new ImageIcon(getClass().getResource("/img/Montaña.png")).getImage();
        imgpersonaje = new ImageIcon(getClass().getResource("/img/PersonajeMain.png")).getImage();
        imgenemigo = new ImageIcon(getClass().getResource("/img/Solaire.png")).getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Dibuja el laberinto
        int[][] laberinto = matriz.getlaberinto();
        int size = 50; // Tamaño de cada celda

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
                }
            }
        }

        // Dibuja al personaje y al enemigo en sus posiciones
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

