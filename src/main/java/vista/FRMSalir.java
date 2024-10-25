/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import controlador.ControladorPrincipal;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author pablo
 */
public class FRMSalir extends JFrame
{
    public FRMSalir(ControladorPrincipal controlador) {
        setTitle("Salir");
        setSize(1200, 980);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());
        
         setUndecorated(true); // Opcional: elimina bordes y decoraciones
        setBackground(new Color(0, 0, 0, 0)); // Hace el fondo del JFrame transparente

        JPanel southPanel = new JPanel(new FlowLayout());
      
        southPanel.setOpaque(false);
         
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = GridBagConstraints.RELATIVE;
        gbc.insets = new Insets(-20, 0, 20, 0);  // Espaciado entre los botones
     
        
        ImageIcon iconoNo = new ImageIcon(new ImageIcon("./src/main/resources/img/BotonNo.png").getImage().getScaledInstance(428, 154, Image.SCALE_SMOOTH));
        JButton btnNo = new JButton( iconoNo);
        
        ImageIcon iconoSi = new ImageIcon(new ImageIcon("./src/main/resources/img/BotonSí.png").getImage().getScaledInstance(428, 154, Image.SCALE_SMOOTH));
        JButton btnSi = new JButton( iconoSi);

        // Definir tamaño preferido para los botones
        Dimension buttonSize = new Dimension(428, 154);
         btnNo.setPreferredSize(buttonSize);
         btnNo.setBackground(new Color(0, 0, 0, 0));  // Fondo transparente
         btnNo.setOpaque(false);  // Elimina la opacidad del botón
         btnNo.setContentAreaFilled(false);  // Asegura que el área del contenido sea transparente
         btnNo.setBorderPainted(false);  // Elimina el borde del botón para que no interfiera con la transparencia
        
         btnSi.setPreferredSize(buttonSize);
         btnSi.setBackground(new Color(0, 0, 0, 0));  // Fondo transparente
         btnSi.setOpaque(false);  // Elimina la opacidad del botón
         btnSi.setContentAreaFilled(false);  // Asegura que el área del contenido sea transparente
         btnSi.setBorderPainted(false);  // Elimina el borde del botón para que no interfiera con la transparencia

        
        btnNo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controlador.regresarAlMenu();
            }
        });
        
          btnSi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
        
       southPanel.add(btnNo,gbc); 
       southPanel.add(btnSi,gbc); 
       southPanel.setOpaque(false);
       add(southPanel, BorderLayout.SOUTH);
        
        
        JPanel rightPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon background = new ImageIcon("./src/main/resources/img/MenuSalir.png");
                g.drawImage(background.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        
        rightPanel.setOpaque(false);
        add(rightPanel,BorderLayout.CENTER);        
    }
    
}
