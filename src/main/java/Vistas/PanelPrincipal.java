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

    BufferedImage bg;
    public PanelPrincipal(){

        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(750,900));
        exp = new PanelExpendedor();
        com = new PanelComprador(exp);
        this.add(com, BorderLayout.SOUTH);
        this.add(exp, BorderLayout.EAST);
        exp.setOpaque(false);
        com.setOpaque(false);

        try{
            bg = ImageIO.read(new File("./src/main/java/Vistas/Fotos/expendedor.jpeg"));
        } catch (IOException e){
            System.out.println(e);
        }

        // this.setBackground(Color.LIGHT_GRAY);
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        if(bg != null){
            Image escalada = bg.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
            g2d.drawImage(escalada, 0,0,this);
        }
    }
}
