package Vistas;

import javax.swing.*;
import java.awt.*;

public class Inventario extends JFrame {
    public Inventario(){
        this.setVisible(true);
        this.setTitle("Inventario");
        this.setResizable(false);
        this.setSize(300, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.black);
    }
}
