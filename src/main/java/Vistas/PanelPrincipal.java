package Vistas;

import Modelos.Moneda;
import Modelos.Moneda100;

import javax.swing.*;
import java.awt.*;

public class PanelPrincipal extends JPanel {
    private PanelComprador com;
    private PanelExpendedor exp;

    public PanelPrincipal(){
        this.setLayout(new BorderLayout());
        exp = new PanelExpendedor();
        com = new PanelComprador(exp);

        this.add(com, BorderLayout.SOUTH);
        this.add(exp, BorderLayout.CENTER);




        this.setBackground(Color.LIGHT_GRAY);
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
    }
}
