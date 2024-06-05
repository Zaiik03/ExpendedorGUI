package Vistas;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOError;
import java.io.File;
import java.io.IOException;

/**
 * Clase PanelPrincipal
 */
public class PanelPrincipal extends JPanel {
    /**
     * Variable PanelComprador
     */
    private PanelComprador com;
    /**
     * Variable PanelExpendedor
     */
    private PanelExpendedor exp;
    /**
     * Variable BufferedImage
     */
    BufferedImage bg;

    /**
     * Metodo Constructor
     */
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

    /**
     * Metodo paintComponent
     * @param g the <code>Graphics</code> object to protect
     */
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        if(bg != null){
            Image escalada = bg.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
            g2d.drawImage(escalada, 0,0,this);
        }
    }
}
