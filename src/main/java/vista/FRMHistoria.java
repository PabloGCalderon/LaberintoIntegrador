/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import controlador.Controlador;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
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
public class FRMHistoria extends JFrame
{
    public FRMHistoria(Controlador controlador) {
        setTitle("Instrucciones");
        setSize(1200, 900);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        JPanel southPanel = new JPanel(new GridBagLayout());
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = GridBagConstraints.RELATIVE;
        gbc.insets = new Insets(20, 0, 20, 0);  // Espaciado entre los botones
        
        ImageIcon iconoVolver = new ImageIcon(new ImageIcon("./src/main/resources/img/BotonVolver.png").getImage().getScaledInstance(428, 154, Image.SCALE_SMOOTH));
        JButton btnVolver = new JButton( iconoVolver);

        // Definir tamaño preferido para los botones
        Dimension buttonSize = new Dimension(428, 154);
        btnVolver.setPreferredSize(buttonSize);
        btnVolver.setBackground(new Color(0, 0, 0, 0));  // Fondo transparente
        btnVolver.setOpaque(false);  // Elimina la opacidad del botón
        btnVolver.setContentAreaFilled(false);  // Asegura que el área del contenido sea transparente
        btnVolver.setBorderPainted(false);  // Elimina el borde del botón para que no interfiera con la transparencia

        
        btnVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controlador.regresarAlMenu();
            }
        });
        
        
       southPanel.add(btnVolver,gbc); 
       add(southPanel, BorderLayout.SOUTH);
       
        
        
        JPanel rightPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon background = new ImageIcon("./src/main/resources/img/MenuHistoria.png");
                g.drawImage(background.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        
      
        add(rightPanel,BorderLayout.CENTER);
     
        
    }
}
