package Vistas;

import javax.swing.*;
import Modelos.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class PanelComprador extends JPanel implements ActionListener {
    private JButton boton_1;

    public PanelComprador(){
        boton_1 = new JButton("Clickeame Comprador");
        boton_1.addActionListener(this);

        this.add(boton_1);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == boton_1){
            System.out.println("Comprador");
        }
    }
}
