package Vistas;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import Modelos.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class PanelComprador extends JPanel implements ActionListener {

    public JRadioButton moneda100;
    public JRadioButton moneda500;
    public JRadioButton moneda1000;
    private JButton confirmar_moneda;

    int seleccion_moneda;
    private Moneda moneda;

    private PanelExpendedor panel_expendedor;

    private Timer timer;

    public PanelComprador(PanelExpendedor panel_expendedorr){
        panel_expendedor = panel_expendedorr;

        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(1280,300));

        JPanel contenedor_monedas = new JPanel();
        this.add(contenedor_monedas, BorderLayout.CENTER);
        contenedor_monedas.setBackground(Color.GREEN);

        JPanel panel_monedas = new JPanel();
        moneda100 = new JRadioButton("Moneda de 100");
        moneda500 = new JRadioButton("Moneda de 500");
        moneda1000 = new JRadioButton("Moneda de 1000");
        confirmar_moneda = new JButton("Enviar");

        confirmar_moneda.addActionListener(this);
        moneda100.addActionListener(this);
        moneda500.addActionListener(this);
        moneda1000.addActionListener(this);


        contenedor_monedas.add(panel_monedas);
        panel_monedas.setLayout(new GridLayout(4,1,10,10));
        panel_monedas.add(moneda100);
        panel_monedas.add(moneda500);
        panel_monedas.add(moneda1000);
        panel_monedas.add(confirmar_moneda);

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
