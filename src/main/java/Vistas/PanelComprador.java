package Vistas;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import Modelos.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;


public class PanelComprador extends JPanel implements ActionListener {

    public JRadioButton moneda100;
    public JRadioButton moneda500;
    public JRadioButton moneda1000;
    private JButton confirmar_moneda;

    int seleccion_moneda;
    private Moneda moneda;

    private PanelExpendedor panel_expendedor;

    private Timer timer;

    Font fontRadioButton = new Font("Arial", Font.PLAIN, 14);

    Image moneda100_img;
    Image moneda500_img;
    Image moneda1000_img;
    public PanelComprador(PanelExpendedor panel_expendedorr){
        panel_expendedor = panel_expendedorr;
        this.setOpaque(false);
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(800,100));

        moneda100_img = new ImageIcon("./src/main/java/Vistas/Fotos/moneda 100.png").getImage();
        moneda500_img = new ImageIcon("./src/main/java/Vistas/Fotos/moneda 500.png").getImage();
        moneda1000_img = new ImageIcon("./src/main/java/Vistas/Fotos/moneda1000.png").getImage();


        /* JPanel contenedor_monedas = new JPanel();
        this.add(contenedor_monedas, BorderLayout.EAST);

        JPanel panel_monedas = new JPanel(); */

        moneda100 = new JRadioButton("$100");
        moneda500 = new JRadioButton("$500");
        moneda1000 = new JRadioButton("$1000");
        moneda100.setIcon(new ImageIcon(moneda100_img));
        moneda500.setIcon(new ImageIcon(moneda500_img));
        moneda1000.setIcon(new ImageIcon(moneda1000_img));
        moneda100.setOpaque(false);
        moneda500.setOpaque(false);
        moneda1000.setOpaque(false);
        moneda100.setForeground(Color.WHITE);
        moneda500.setForeground(Color.WHITE);
        moneda1000.setForeground(Color.WHITE);
        moneda100.setFont(fontRadioButton);
        moneda500.setFont(fontRadioButton);
        moneda1000.setFont(fontRadioButton);
        confirmar_moneda = new JButton("Enviar");

        confirmar_moneda.addActionListener(this);
        moneda100.addActionListener(this);
        moneda500.addActionListener(this);
        moneda1000.addActionListener(this);

        /* contenedor_monedas.setOpaque(false);
        panel_monedas.setOpaque(false);
        panel_expendedor.setOpaque(false);


        contenedor_monedas.add(panel_monedas);
        panel_monedas.setLayout(new GridLayout(4,1,10,10));
        panel_monedas.add(moneda100);
        panel_monedas.add(moneda500);
        panel_monedas.add(moneda1000);
        panel_monedas.add(confirmar_moneda); */

        panel_expendedor.panel_botones.add(Box.createVerticalStrut(55));
        panel_expendedor.panel_botones.add(moneda100);
        panel_expendedor.panel_botones.add(moneda500);
        panel_expendedor.panel_botones.add(moneda1000);
        panel_expendedor.panel_botones.add(confirmar_moneda);

        ButtonGroup grupo_monedas = new ButtonGroup();
        grupo_monedas.add(moneda100);
        grupo_monedas.add(moneda500);
        grupo_monedas.add(moneda1000);



        timer = new Timer(100, null);
        timer.addActionListener(this);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == moneda100){
            seleccion_moneda = 100;
        } else if(e.getSource() == moneda500){
            seleccion_moneda = 500;
        } else if(e.getSource() == moneda1000){
            seleccion_moneda = 1000;
        } else if(e.getSource() == confirmar_moneda){
            if(seleccion_moneda == 100){
                panel_expendedor.moneda = new Moneda100();
                moneda100.setEnabled(false);
                moneda500.setEnabled(false);
                moneda1000.setEnabled(false);
            } else if(seleccion_moneda == 500){
                panel_expendedor.moneda = new Moneda500();
                moneda100.setEnabled(false);
                moneda500.setEnabled(false);
                moneda1000.setEnabled(false);
            } else if(seleccion_moneda == 1000){
                panel_expendedor.moneda = new Moneda1000();
                moneda100.setEnabled(false);
                moneda500.setEnabled(false);
                moneda1000.setEnabled(false);
            }
        } else if(e.getSource() == timer){
            if(panel_expendedor.moneda == null){
                moneda100.setEnabled(true);
                moneda500.setEnabled(true);
                moneda1000.setEnabled(true);
            }
        }
    }

    public void paintComponent(Graphics g){

    }
}
