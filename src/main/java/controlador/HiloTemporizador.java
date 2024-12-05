/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.concurrent.atomic.AtomicBoolean;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import vista.DerrotaGUI;

/**
 *
 * @author pablo
 */
public class HiloTemporizador implements Runnable {

    private ControladorLaberinto controladorLaberinto;
    private DerrotaGUI derrotaGUI;
    private int tiempoRestante;
    private JLabel lblTimer;
    private AtomicBoolean enEjecucion;
    private boolean pausado = false;

    public HiloTemporizador(int tiempoInicial, JLabel lblTimer) 
    {
        derrotaGUI = new DerrotaGUI(controladorLaberinto);
        this.tiempoRestante = tiempoInicial;
        this.lblTimer = lblTimer;
        this.enEjecucion = new AtomicBoolean(true);
    }

    public void pausar() {
        pausado = !pausado;
    }

    
    @Override
    public void run() {
        while (enEjecucion.get() && tiempoRestante > 0) {
            if (!pausado) {
                tiempoRestante--;
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        lblTimer.setText("" + tiempoRestante);
                    }
                });
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
        if (tiempoRestante == 0) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                       derrotaGUI.setVisible(true);                       
                }
            });
        }
    }

    public int getTiempoRestante() {
        return tiempoRestante;
    }
    
    
}
