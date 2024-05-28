package Vistas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelExpendedor extends JPanel implements ActionListener {

    private JButton boton_Fanta;
    private JButton boton_Sprite;
    private JButton boton_CocaCola;
    private JButton boton_Snickers;
    private JButton boton_Super8;


    public PanelExpendedor(){
        boton_Fanta = new JButton("Clickeame Expendedor");
        boton_Fanta.addActionListener(this);

        this.add(boton_1);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == boton_1){
            System.out.println("Expendedor");
        }


    }
}
