package Vistas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Modelos.*;

public class PanelExpendedor extends JPanel implements ActionListener {

    private JButton boton_Fanta;
    private JButton boton_Sprite;
    private JButton boton_CocaCola;
    private JButton boton_Snickers;
    private JButton boton_Super8;

    private Expendedor expendedor = new Expendedor(10);
    private Moneda1000 m = new Moneda1000();
    private Comprador c;

    public PanelExpendedor(){
        this.setLayout(new GridLayout(5,1,10,30));

        boton_Fanta = new JButton("Fanta");
        boton_Fanta.setFocusable(false);
        boton_Fanta.addActionListener(this);
        this.add(boton_Fanta);

        boton_Sprite = new JButton("Sprite");
        boton_Sprite.addActionListener(this);
        this.add(boton_Sprite);

        boton_CocaCola = new JButton("CocaCola");
        boton_CocaCola.addActionListener(this);
        this.add(boton_CocaCola);

        boton_Snickers = new JButton("Snickers");
        boton_Snickers.addActionListener(this);
        this.add(boton_Snickers);

        boton_Super8 = new JButton("Super8");
        boton_Super8.addActionListener(this);
        this.add(boton_Super8);







        this.setBackground(Color.LIGHT_GRAY);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == boton_Fanta) {
            comprasComprador(Expendedor.FANTA);
            if(expendedor.fanta.checkSize()){
                boton_Fanta.setEnabled(false);
            }
        } else if(e.getSource() == boton_Sprite){
            comprasComprador(Expendedor.SPRITE);
            if(expendedor.sprite.checkSize()){
                boton_Sprite.setEnabled(false);
            }
        } else if(e.getSource() == boton_CocaCola){
            comprasComprador(Expendedor.COCA);
            if(expendedor.coca.checkSize()){
                boton_CocaCola.setEnabled(false);
            }
        } else if(e.getSource() == boton_Snickers){
            comprasComprador(Expendedor.SNICKERS);
            if(expendedor.snickers.checkSize()){
                boton_Snickers.setEnabled(false);
            }
        } else if(e.getSource() == boton_Super8){
            comprasComprador(Expendedor.SUPER8);
            if(expendedor.super8.checkSize()){
                boton_Super8.setEnabled(false);
            }
        }

    }

    public void comprasComprador(int producto){
        try{
            Comprador c =  new Comprador(m, producto, expendedor);
            System.out.println(c.queConsumiste()+", " + c.cuantoVuelto());
        } catch (PagoIncorrectoException a){
            System.out.println("Error de tipo pago: " + a.getMessage());
        } catch (PagoInsuficienteException a){
            System.out.println("Error de pago: " + a.getMessage() + ". Aqui tiene su dinero: " + m.getValor());
        } catch (NoHayProductoException a){
            System.out.println("Error de inventario: " + a.getMessage() + ". Aqui tiene su dinero: " + m.getValor());
        }

    }
}
