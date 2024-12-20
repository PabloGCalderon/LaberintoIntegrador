/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import controlador.ControladorLaberinto;
import java.awt.Color;

/**
 *
 * @author pablo
 */
public class DerrotaGUI extends javax.swing.JFrame {

    /**
     * Creates new form DerrotaGUI
     */
    public DerrotaGUI(ControladorLaberinto controlador) 
    {
        setUndecorated(true); 
        setBackground(new Color(0, 0, 0, 0));
        
        initComponents();
        escuchar(controlador);
        
        setLocationRelativeTo(null);

   
        setLocationRelativeTo(null); 
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public void escuchar(ControladorLaberinto controlador)
    {
        btnReintentarDerrota.setActionCommand("btnReintentarDerrota");
        btnReintentarDerrota.addActionListener(controlador);
         
        btnVolverAlMenuDerrota.setActionCommand("btnVolverAlMenuDerrota");
        btnVolverAlMenuDerrota.addActionListener(controlador);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnReintentarDerrota = new javax.swing.JButton();
        btnVolverAlMenuDerrota = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnReintentarDerrota.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/BotonReintentar.png"))); // NOI18N
        btnReintentarDerrota.setBorderPainted(false);
        btnReintentarDerrota.setContentAreaFilled(false);
        getContentPane().add(btnReintentarDerrota, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 360, -1, -1));

        btnVolverAlMenuDerrota.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/BotonVolverMenu.png"))); // NOI18N
        btnVolverAlMenuDerrota.setBorderPainted(false);
        btnVolverAlMenuDerrota.setContentAreaFilled(false);
        getContentPane().add(btnVolverAlMenuDerrota, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 650, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/PantallaDerrota.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1500, 1080));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReintentarDerrota;
    private javax.swing.JButton btnVolverAlMenuDerrota;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
