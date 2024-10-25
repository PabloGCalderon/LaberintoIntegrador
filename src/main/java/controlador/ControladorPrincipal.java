/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import vista.FRMHistoria;
import vista.FRMInstrucciones;
import vista.FRMJuego;
import vista.FRMMainMenu;
import vista.FRMPausa;
import vista.FRMSalir;


/**
 *
 * @author pablo
 */
public class ControladorPrincipal
{
    private FRMMainMenu frmMainMenu;
    private FRMJuego frmJuego;
    private FRMHistoria frmHistoria;
    private FRMInstrucciones frmInstrucciones;
    private FRMSalir frmSalir;
    private FRMPausa frmPausa;
    public ControladorPrincipal()
    { 
      frmMainMenu = new FRMMainMenu(this);
      frmInstrucciones= new FRMInstrucciones(this);
      frmHistoria= new FRMHistoria(this);
      frmSalir= new FRMSalir(this);
      frmJuego= new FRMJuego(this);
      frmPausa= new FRMPausa(this); 
    }

  
   public void mostrarMainMenu() 
   {
        frmMainMenu.setVisible(true);
    }  
   public void mostrarHistoria() 
   {
      
        frmHistoria.setVisible(true);
    }  
   public void mostrarInstrucciones() 
   {
    
        frmInstrucciones.setVisible(true);

    }  
   public void mostrarSalir() 
   {
       
        frmSalir.setVisible(true);

    }  
    public void mostrarJuego() 
   {
        frmMainMenu.setVisible(false);
        frmJuego.setVisible(true);

    }  
    public void menuPausa() 
   {
       
        frmPausa.setVisible(true);

    }  

     public void regresarAlMenu() {
        frmHistoria.setVisible(false);
        frmInstrucciones.setVisible(false);
        frmMainMenu.setVisible(true);
    }

}
