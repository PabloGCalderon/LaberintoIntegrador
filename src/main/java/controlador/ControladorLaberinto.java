/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import modelo.Enemigo;
import modelo.MatrizLaberinto;
import modelo.Personaje;
import vista.DerrotaGUI;
import vista.JuegoGUI;
import vista.MainMenuGUI;
import vista.PanelJuego;
import vista.VictoriaGUI;

/**
 *
 * @author pablo
 */
public class ControladorLaberinto implements KeyListener, ActionListener
{
    private HiloTemporizador hiloTemporizador;
    private ControladorPrincipal controladorPrincipal;
    private MainMenuGUI mainMenuGUI;
    private JuegoGUI juegoGUI;
    private DerrotaGUI derrotaGUI;
    private VictoriaGUI victoriaGUI;
    private MatrizLaberinto matriz;
    private PanelJuego panelJuego;
    private Enemigo enemigo;
    private Personaje personaje;
    private Hilo hilo;

    public ControladorLaberinto(MatrizLaberinto matriz, PanelJuego panelJuego, Enemigo enemigo, Personaje personaje, DerrotaGUI derrotaGUI, 
            VictoriaGUI victoriaGUI)
    {
        this.controladorPrincipal= controladorPrincipal;
        this.matriz = matriz;
        this.panelJuego = panelJuego;
        this.enemigo = enemigo;
        this.personaje = personaje;
        this.derrotaGUI = derrotaGUI;
        this.victoriaGUI =victoriaGUI;
        this.derrotaGUI = new DerrotaGUI(this);
        this.victoriaGUI = new VictoriaGUI(this);
        this.juegoGUI =  juegoGUI;
        this.mainMenuGUI = mainMenuGUI;
        
        
        this.hiloTemporizador = hiloTemporizador;
        
        hilo=new Hilo(this,matriz,enemigo,panelJuego,controladorPrincipal);
        hilo.start();
        
       
    }
    

    
    @Override
    public void keyPressed(KeyEvent e) {
        int Tecla = e.getKeyCode();
       
       switch (Tecla){
          case KeyEvent.VK_UP:
            personaje.mover("ARRIBA", matriz.getlaberinto());
//              System.out.println("Funciona");
            break;
        case KeyEvent.VK_DOWN:
            personaje.mover("ABAJO", matriz.getlaberinto());
//            System.out.println("Funciona");
            break;
        case KeyEvent.VK_LEFT:
            personaje.mover("IZQUIERDA", matriz.getlaberinto());
//            System.out.println("Funciona");           
            break;
        case KeyEvent.VK_RIGHT:
            personaje.mover("DERECHA", matriz.getlaberinto());
//            System.out.println("Funciona");
            break;  
       }
       
        enemigo.movAleatorio(matriz.getlaberinto());
        panelJuego.repaint();
        panelJuego.requestFocusInWindow();
        muerteTrampa();
        muerteEnemigo();
        victoria();
  
    }
    
    
    public boolean muerteEnemigo()
    {
        boolean muerte = false;
        if (personaje.getxPersonaje() == enemigo.getxEnemigo() && personaje.getyPersonaje() == enemigo.getyEnemigo()) {
            System.out.println("Te atrapó Solaire");
            muerte = true;
        }
        if (muerte == true)
        {
            personaje.setxPersonaje(1);
            personaje.setyPersonaje(1);
            
            enemigo.setxEnemigo(5);
            enemigo.setyEnemigo(9);
            
            this.derrotaGUI = new DerrotaGUI(this);
            derrotaGUI.setVisible(true);
        }
        return muerte;
    }
        public void muerteTrampa()
        {
            if(personaje.isMuerte()==true)
            {
            this.derrotaGUI = new DerrotaGUI(this);
            derrotaGUI.setVisible(true);
            
            personaje.setxPersonaje(1);
            personaje.setyPersonaje(1);
            
            enemigo.setxEnemigo(5);
            enemigo.setyEnemigo(9);
            }
        }
      
        
   public void victoria()
    {
       if(personaje.isVictoria()==true)
            {
            victoriaGUI.setVisible(true);
            }   
    }
    
    public void reiniciar()
    {
        
            personaje.setxPersonaje(1);
            personaje.setyPersonaje(1);
            
            enemigo.setxEnemigo(5);
            enemigo.setyEnemigo(9);
            
            
            closeAllWindowsExcept(mainMenuGUI);
            juegoGUI = new JuegoGUI(controladorPrincipal);
    }
    
    public void reintentar()
    {
        personaje.setVictoria(false);
        personaje.setMuerte(false);
        derrotaGUI.setVisible(false);
        victoriaGUI.setVisible(false);
        reiniciar();       
    }
    
    
    public void salirMenu() {

   if (derrotaGUI != null) 
    {
        derrotaGUI.dispose();
    }
   
    if (juegoGUI != null)
    {
        juegoGUI.dispose();
    }
    
    if (mainMenuGUI != null)
    {
        mainMenuGUI.dispose();
    }
    
    if (victoriaGUI != null) 
    {
        victoriaGUI.dispose();
    }

    }


     @Override
    public void actionPerformed(ActionEvent e) 
    {
   
       switch (e.getActionCommand()) 
        {
            case "btnReintentarDerrota":
                System.out.println("FuncionaReintentarDerrota");
                reintentar();
                break;

           case "btnVolverAlMenuDerrota":
              System.out.println("FuncionaVolverDerrota");
              salirMenu();
              //closeAllWindowsExcept(mainMenuGUI); // Cierra todo excepto el menú principal
              new ControladorPrincipal();
                break;
                
             case "btnReintentarVictoria":
                 System.out.println("FuncionaReintentarVictoria");
                reintentar();
                break;

           case "btnVolverAlMenuVictoria":
              salirMenu();
              //closeAllWindowsExcept(mainMenuGUI); // Cierra todo excepto el menú principal
              new ControladorPrincipal();
                break;
        }
    }
     /**
     * Método para cerrar todas las ventanas activas excepto una específica.
     *
     * @param excludeWindow La ventana que no debe cerrarse (puede ser null).
     */
    private void closeAllWindowsExcept(java.awt.Window excludeWindow) {
        java.awt.Window[] windows = java.awt.Window.getWindows();
        for (java.awt.Window window : windows) {
            if (window.isVisible() && window != excludeWindow) {
                window.dispose();
            }
        }
    }
    @Override
    public void keyTyped(KeyEvent e)
    {
    }
    @Override
    public void keyReleased(KeyEvent e) 
    {
    }

   
    
}