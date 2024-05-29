package Vistas;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOError;
import java.io.File;
import java.io.IOException;

public class PanelPrincipal extends JPanel {
    private PanelComprador com;
    private PanelExpendedor exp;


    public PanelPrincipal(){

        this.setLayout(new BorderLayout());
        exp = new PanelExpendedor();
        com = new PanelComprador(exp);
        this.add(com, BorderLayout.EAST);
        this.add(exp, BorderLayout.WEST);
        exp.setOpaque(false);
        com.setOpaque(false);



        // this.setBackground(Color.LIGHT_GRAY);
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);

    }
}
