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








    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == boton_Fanta) {
            comprasComprador(Expendedor.FANTA);
        } else if(e.getSource() == boton_Sprite){
            System.out.println("COMPRASTE SPRITE");
        } else if(e.getSource() == boton_CocaCola){
            System.out.println("COMPRASTE COCAINA");
        } else if(e.getSource() == boton_Snickers){
            System.out.println("COMPRASTE SNICKERS");
        } else if(e.getSource() == boton_Super8){
            System.out.println("COMPRASTE SUPER88");
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
