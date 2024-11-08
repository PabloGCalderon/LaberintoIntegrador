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
    private MainMenuGUI mainMenuGUI;
    private JuegoGUI juegoGUI;
    private HistoriaGUI historiaGUI;
    private InstruccionesGUI instruccionesGUI;
    private SalirGUI salirGUI;
    private MenuPausaGUI menuPausaGUI;
    public ControladorPrincipal()
    { 
     mainMenuGUI = new MainMenuGUI(this);
       instruccionesGUI= new InstruccionesGUI(this);
       historiaGUI= new HistoriaGUI(this);
       salirGUI= new SalirGUI(this);
       juegoGUI= new JuegoGUI(this);
       menuPausaGUI= new MenuPausaGUI(this); 
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
    switch(e.getActionCommand()){
                    case "btnInstrucciones":
                           instruccionesGUI.setVisible(true);
                           break;
                    case "btnJugar":
                          juegoGUI.setVisible(true);
                          mainMenuGUI.setVisible(false);
                           break;
                    case "btnHistoria":
                           historiaGUI.setVisible(true);
                           break;
                    case "btnSalir":
                           salirGUI.setVisible(true);
                           break;
                    case "btnPausa":
                            menuPausaGUI.setVisible(true);
                            break;
                            
                    case "btnVolverHistoria":
                            historiaGUI.setVisible(false);
                            break;
                    case "btnVolverInstrucciones":
                            instruccionesGUI.setVisible(false);
                            break;
                    case "btnNo":
                            salirGUI.setVisible(false);
                            break;
                    case "btnSi":
                             System.exit(0);
                            break;
                    case "btnReanudar":
                            menuPausaGUI.setVisible(false);
                            break;
                    case "btnVolverAlMenu":
                            menuPausaGUI.setVisible(false);
                            mainMenuGUI.setVisible(true);
                            break;
             }
    }

}
