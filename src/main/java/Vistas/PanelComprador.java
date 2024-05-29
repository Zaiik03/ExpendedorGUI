package Vistas;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import Modelos.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class PanelComprador extends JPanel implements ActionListener {

    private JRadioButton moneda100;
    private JRadioButton moneda500;
    private JRadioButton moneda1000;
    private JButton seleccion_moneda;

    public PanelComprador(){
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(1280,300));

        JPanel contenedor_monedas = new JPanel();
        this.add(contenedor_monedas, BorderLayout.CENTER);
        contenedor_monedas.setBackground(Color.GREEN);

        JPanel panel_monedas = new JPanel();
        moneda100 = new JRadioButton("Moneda de 100");
        moneda500 = new JRadioButton("Moneda de 500");
        moneda1000 = new JRadioButton("Moneda de 1000");
        seleccion_moneda = new JButton("a");

        contenedor_monedas.add(panel_monedas);
        panel_monedas.setLayout(new GridLayout(4,1,10,10));
        panel_monedas.add(moneda100);
        panel_monedas.add(moneda500);
        panel_monedas.add(moneda1000);
        panel_monedas.add(seleccion_moneda);

        ButtonGroup grupo_monedas = new ButtonGroup();
        grupo_monedas.add(moneda100);
        grupo_monedas.add(moneda500);
        grupo_monedas.add(moneda1000);





    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public void paintComponent(Graphics g){

    }
}
