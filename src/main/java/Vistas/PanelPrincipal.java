package Vistas;

import javax.swing.*;
import java.awt.*;

public class PanelPrincipal extends JPanel {
    private PanelComprador com;
    private PanelExpendedor exp;

    public PanelPrincipal(){



        exp = new PanelExpendedor();
        com = new PanelComprador();
        this.add(exp, BorderLayout.CENTER);
        this.add(com, BorderLayout.NORTH);


        this.setBackground(Color.LIGHT_GRAY);
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
    }
}
