/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import controlador.ControladorPrincipal;
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
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

/**
 *
 * @author pablo
 */
public class FRMPausa extends JFrame
{
    
     public FRMPausa(ControladorPrincipal controlador) {
      JLayeredPane layeredPane = new JLayeredPane();
    layeredPane.setPreferredSize(new Dimension(1270, 1061));

    setTitle("Pausa");
    setSize(1200, 1080);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setLayout(new BorderLayout());
    
     setUndecorated(true); // Opcional: elimina bordes y decoraciones
     setBackground(new Color(0, 0, 0, 0)); // Hace el fondo del JFrame transparente

    // Crear el panel norte
    JPanel NorthPanel = new JPanel(new GridBagLayout());
    NorthPanel.setOpaque(false); // Hacer el panel transparente
    NorthPanel.setBounds(0, 200, 1200, 1080); // Posicionar en la parte superior

    //
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.gridx = 0;
    gbc.gridy = GridBagConstraints.RELATIVE;
    gbc.insets = new Insets(-100, 0, 250, 0); // Espaciado entre los botones

    // Crear el botón de menú
    ImageIcon iconoReanudar = new ImageIcon(new ImageIcon("./src/main/resources/img/BotonReanudar.png").getImage().getScaledInstance(428, 154, Image.SCALE_SMOOTH));
    JButton btnReanudar = new JButton(iconoReanudar);
    
     ImageIcon iconoSalirMenu = new ImageIcon(new ImageIcon("./src/main/resources/img/SalirAlMenuPausa.png").getImage().getScaledInstance(428, 154, Image.SCALE_SMOOTH));
    JButton btnSalirMenu = new JButton(iconoSalirMenu);

    // Definir tamaño preferido para los botones
    Dimension buttonSize = new Dimension(428, 154);
    btnReanudar.setPreferredSize(buttonSize);
    btnReanudar.setBackground(new Color(0, 0, 0, 0)); // Fondo transparente
    btnReanudar.setOpaque(false); // Elimina la opacidad del botón
    btnReanudar.setContentAreaFilled(false); // Asegura que el área del contenido sea transparente
    btnReanudar.setBorderPainted(false); // Elimina el borde del botón para que no interfiera con la transparencia
    
     btnSalirMenu.setPreferredSize(buttonSize);
    btnSalirMenu.setBackground(new Color(0, 0, 0, 0)); // Fondo transparente
    btnSalirMenu.setOpaque(false); // Elimina la opacidad del botón
    btnSalirMenu.setContentAreaFilled(false); // Asegura que el área del contenido sea transparente
    btnSalirMenu.setBorderPainted(false); // Elimina el borde del botón para que no interfiera con la transparencia


    btnReanudar.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            setVisible(false);
        }
    });
    
    btnSalirMenu.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            controlador.regresarAlMenu();
        }
    });

    // Agregar el botón al panel norte
    NorthPanel.add(btnReanudar, gbc);
    NorthPanel.add(btnSalirMenu, gbc); 
    NorthPanel.setOpaque(false);
    
    
    // Crear el panel de fondo
    JPanel rightPanel = new JPanel() {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            ImageIcon background = new ImageIcon(new ImageIcon("./src/main/resources/img/MenuPausa.png").getImage());
            g.drawImage(background.getImage(), 0, 0, getWidth(), getHeight(), this);
        }
    };
    rightPanel.setOpaque(false);
    rightPanel.setLayout(null); // Usar layout null para posicionar manualmente
    rightPanel.setBounds(0, 0, 1200, 1080); // Posicionar el panel en toda la ventana
    layeredPane.add(rightPanel, Integer.valueOf(0)); // Agregar a la capa 0 (fondo)

    // Agregar NorthPanel a layeredPane en una capa superior
    layeredPane.add(NorthPanel, Integer.valueOf(1));

    // Agregar el layeredPane al marco
    add(layeredPane, BorderLayout.CENTER);
    
    // Asegurarse de que la ventana sea visible
    setVisible(true);
    
   }
}
