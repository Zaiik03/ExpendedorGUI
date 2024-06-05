package Vistas;

import javax.swing.*;
import java.awt.*;

/**
 * Clase ventana
 */
public class Ventana extends JFrame {
    /**
     * Variable privada que se utiliza para hacer un nuevo panel
     */
    private PanelPrincipal panelPrincipal;

    /**
     * Constructor de clase Ventana
     */
    public Ventana(){
        panelPrincipal = new PanelPrincipal();
        this.setVisible(true);
        this.setTitle("ExpendedorGUI");
        this.setResizable(false);
        this.setSize(790, 900);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.black);


        this.add(panelPrincipal);
    }
}
