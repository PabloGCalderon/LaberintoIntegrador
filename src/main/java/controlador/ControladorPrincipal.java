/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.HistoriaGUI;
import vista.InstruccionesGUI;
import vista.JuegoGUI;
import vista.MainMenuGUI;
import vista.MenuPausaGUI;
import vista.SalirGUI;


/**
 *
 * @author pablo
 */
public class ControladorPrincipal implements ActionListener
{
    private Hilo hilo;
    private HiloTemporizador hiloTemporizador;
    private ControladorLaberinto controladorLaberinto;
    private MainMenuGUI mainMenuGUI;
    private JuegoGUI juegoGUI;
    private HistoriaGUI historiaGUI;
    private InstruccionesGUI instruccionesGUI;
    private SalirGUI salirGUI;
    private MenuPausaGUI menuPausaGUI;
    
    private boolean pausado;

   
    public ControladorPrincipal()
    { 
        this.controladorLaberinto = controladorLaberinto;
        mainMenuGUI = new MainMenuGUI(this);
       
        this.hiloTemporizador = hiloTemporizador;
        this.mainMenuGUI = mainMenuGUI; 
        this.instruccionesGUI = instruccionesGUI;
        this.historiaGUI = historiaGUI;
        this.salirGUI = salirGUI;
        this.juegoGUI = juegoGUI;
        this.menuPausaGUI = menuPausaGUI; 
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
    switch(e.getActionCommand())
    {    
            case "btnInstrucciones":
                System.out.println("BotonIntrucciones");
                instruccionesGUI = new InstruccionesGUI(this);
                instruccionesGUI.setVisible(true);
                break;
                
            case "btnJugar":
                  System.out.println("BotonJugar");
                  mainMenuGUI.dispose();
                  juegoGUI = new JuegoGUI(this);
                
                  juegoGUI.setVisible(true);
                break;
                
            case "btnHistoria":
                System.out.println("BotonHistoria");
                historiaGUI = new HistoriaGUI(this); 
                historiaGUI.setVisible(true);
                break;
            case "btnSalir":
                 System.out.println("BotonSalir");
                salirGUI = new SalirGUI(this);
                salirGUI.setVisible(true);
                break;
            case "btnPausa":
                menuPausaGUI = new MenuPausaGUI(this);
                menuPausaGUI.setVisible(true);
                juegoGUI.pausarTemporizador();
                setPausado(true);
                break;

            case "btnVolverHistoria":
                historiaGUI.dispose();
                break;
                
            case "btnVolverInstrucciones":
                instruccionesGUI.dispose();
                break;
                
            case "btnNo":
                salirGUI.dispose();
                break;
                
            case "btnSi":
                System.exit(0);
                break;
                
            case "btnReanudar":
                menuPausaGUI.dispose();          
                juegoGUI.reanudarTemporizador();
                juegoGUI.isAutoRequestFocus();
                break;
                
            case "btnVolverAlMenu":
                menuPausaGUI.dispose();
                mainMenuGUI = new MainMenuGUI(this);
                mainMenuGUI.setVisible(true);
                break;
        }
    }

    public boolean isPausado() {
        return pausado;
    }

    public void setPausado(boolean pausado) {
        this.pausado = pausado;
    }

}
