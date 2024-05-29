package Vistas;

import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {
    private PanelPrincipal panelPrincipal;

    public Ventana(){
        panelPrincipal = new PanelPrincipal();
        this.setVisible(true);
        this.setTitle("ExpendedorGUI");
        this.setResizable(true);
        this.setSize(777, 1023);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.black);


        this.add(panelPrincipal);
        // this.setContentPane(panelPrincipal);

    }
}
