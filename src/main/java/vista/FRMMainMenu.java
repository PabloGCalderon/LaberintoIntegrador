/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import controlador.ControladorPrincipal;
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
public class FRMMainMenu extends JFrame
{
 
    public FRMMainMenu(ControladorPrincipal controlador)
    {
        
    JLayeredPane layeredPane = new JLayeredPane();
    layeredPane.setPreferredSize(new Dimension(1920, 1080));
    
        setTitle("Main Menu");
        setSize(1920, 1080);  // Tamaño de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
        
          // Panel izquierdo para los botones de menú (con tamaño reducido)
        JPanel leftPanel = new JPanel(new GridBagLayout());  // Usamos GridBagLayout para centrar verticalmente
   
         GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = GridBagConstraints.RELATIVE;
        gbc.insets = new Insets(20, 0, 20, 0);  // Espaciado entre los botones
        
         // Crear ImageIcons para los botones y escalarlas al tamaño del botón
        ImageIcon iconoHistoria = new ImageIcon(new ImageIcon("./src/main/resources/img/BotonHistoria.png").getImage().getScaledInstance(428, 154, Image.SCALE_SMOOTH));
        ImageIcon iconoInstrucciones = new ImageIcon(new ImageIcon("./src/main/resources/img/BotonInstrucciones.png").getImage().getScaledInstance(428, 154, Image.SCALE_SMOOTH));
        ImageIcon iconoSalir = new ImageIcon(new ImageIcon("./src/main/resources/img/BotonSalir.png").getImage().getScaledInstance(428, 154, Image.SCALE_SMOOTH));
        ImageIcon iconoJugar = new ImageIcon(new ImageIcon("./src/main/resources/img/BotonJuego.png").getImage().getScaledInstance(428, 154, Image.SCALE_SMOOTH));
        
          // Botones del menú con tamaño específico e imágenes escaladas
        JButton btnHistoria = new JButton( iconoHistoria);
        JButton btnInstrucciones = new JButton( iconoInstrucciones);
        JButton btnJugar = new JButton( iconoJugar);
        JButton btnSalir = new JButton( iconoSalir);
        
        

        // Definir tamaño preferido para los botones
        Dimension buttonSize = new Dimension(428, 154);
        btnHistoria.setPreferredSize(buttonSize);
        btnHistoria.setBackground(new Color(0, 0, 0, 0));  // Fondo transparente
        btnHistoria.setOpaque(false);  // Elimina la opacidad del botón
        btnHistoria.setContentAreaFilled(false);  // Asegura que el área del contenido sea transparente
        btnHistoria.setBorderPainted(false);  // Elimina el borde del botón para que no interfiera con la transparencia
        

        btnInstrucciones.setPreferredSize(buttonSize);
        
        btnInstrucciones.setBackground(new Color(0, 0, 0, 0));  // Fondo transparente
        btnInstrucciones.setOpaque(false);  // Elimina la opacidad del botón
        btnInstrucciones.setContentAreaFilled(false);  // Asegura que el área del contenido sea transparente
        btnInstrucciones.setBorderPainted(false);  // Elimina el borde del botón para que no interfiera con la transparencia
     

        btnJugar.setPreferredSize(buttonSize);
        
        btnJugar.setBackground(new Color(0, 0, 0, 0));  // Fondo transparente
        btnJugar.setOpaque(false);  // Elimina la opacidad del botón
        btnJugar.setContentAreaFilled(false);  // Asegura que el área del contenido sea transparente
        btnJugar.setBorderPainted(false);  // Elimina el borde del botón para que no interfiera con la transparencia
      

        btnSalir.setPreferredSize(buttonSize);
        
        btnSalir.setBackground(new Color(0, 0, 0, 0));  // Fondo transparente
        btnSalir.setOpaque(false);  // Elimina la opacidad del botón
        btnSalir.setContentAreaFilled(false);  // Asegura que el área del contenido sea transparente
        btnSalir.setBorderPainted(false);  // Elimina el borde del botón para que no interfiera con la transparencia
      

        leftPanel.add(btnHistoria, gbc);
        leftPanel.add(btnInstrucciones, gbc);
        leftPanel.add(btnJugar, gbc);
        leftPanel.add(btnSalir, gbc);

     
        JPanel rightPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon background = new ImageIcon("./src/main/resources/img/MainMenuLaberinto.jpg");
                g.drawImage(background.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };

         rightPanel.setLayout(null);  // Usar layout null para posicionar los botones manualmente
         
         rightPanel.setBounds(0, 0, 1920, 1080);  // Posicionar el panel en toda la ventana
         layeredPane.add(rightPanel, Integer.valueOf(0));  // Agregar a la capa 0 (fondo)

      
        leftPanel.setOpaque(false);  // Hacer el panel transparente para que el fondo se vea a través
        leftPanel.setBounds(0, 100, 500, 800);  // Posiciona el panel donde desees, sobre el fondo
        
        
       
       
        layeredPane.add(leftPanel, Integer.valueOf(1));
        
        add(layeredPane);
       
        leftPanel.setOpaque(false);
         btnHistoria.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controlador.mostrarHistoria();
            }
        });

        btnInstrucciones.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controlador.mostrarInstrucciones();
            }
        });
         btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controlador.mostrarSalir();
            }
        });

        btnJugar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controlador.mostrarJuego();
            }
        });
    }
    
    
    
}
