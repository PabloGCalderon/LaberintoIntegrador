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
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

/**
 *
 * @author pablo
 */
public class FRMJuego extends JFrame
{
    
     public FRMJuego(Controlador controlador) {
         
            JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(1920, 1080));

        setTitle("Juego");
        setSize(1920, 1080);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Crear el panel norte
        JPanel NorthPanel = new JPanel(new GridBagLayout());
        NorthPanel.setOpaque(false); // Hacer el panel transparente
        NorthPanel.setBounds(440, 30, 1920, 154); // Posicionar en la parte superior

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = GridBagConstraints.RELATIVE;
        gbc.insets = new Insets(20, 0, 20, 0); // Espaciado entre los botones

        // Crear el botón de menú
        ImageIcon iconoMenu = new ImageIcon(new ImageIcon("./src/main/resources/img/BotonMenu.png").getImage().getScaledInstance(428, 154, Image.SCALE_SMOOTH));
        JButton btnMenu = new JButton(iconoMenu);

        // Definir tamaño preferido para los botones
        Dimension buttonSize = new Dimension(428, 154);
        btnMenu.setPreferredSize(buttonSize);
        btnMenu.setBackground(new Color(0, 0, 0, 0)); // Fondo transparente
        btnMenu.setOpaque(false); // Elimina la opacidad del botón
        btnMenu.setContentAreaFilled(false); // Asegura que el área del contenido sea transparente
        btnMenu.setBorderPainted(false); // Elimina el borde del botón para que no interfiera con la transparencia

        btnMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controlador.menuPausa();
            }
        });

        // Agregar el botón al panel norte
        NorthPanel.add(btnMenu, gbc);

        // Crear el panel de fondo
        JPanel rightPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon background = new ImageIcon(new ImageIcon("./src/main/resources/img/Laberinto.png").getImage());
                g.drawImage(background.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };

        rightPanel.setLayout(null); // Usar layout null para posicionar manualmente
        rightPanel.setBounds(0, 0, 1920, 1080); // Posicionar el panel en toda la ventana
        layeredPane.add(rightPanel, Integer.valueOf(0)); // Agregar a la capa 0 (fondo)

        // Agregar NorthPanel a layeredPane en una capa superior
        layeredPane.add(NorthPanel, Integer.valueOf(1));

        // Agregar el layeredPane al marco
        add(layeredPane, BorderLayout.CENTER);
    }
}
