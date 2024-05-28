package Vistas;

import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {
    public Ventana(){
        this.setVisible(true);
        this.setTitle("ExpendedorGUI");
        this.setResizable(false);
        this.setSize(800, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.black);
    }
}
