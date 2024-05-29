package Vistas;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import Modelos.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class PanelComprador extends JPanel implements ActionListener {


    private Expendedor expendedor;
    private Moneda1000 m = new Moneda1000();
    private Comprador c;

    public PanelComprador(){
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(1280,300));

        JPanel panel_monedas = new JPanel();
        this.add(panel_monedas, BorderLayout.CENTER);
        panel_monedas.setBackground(Color.GREEN);

        JPanel panel_compra = new JPanel();
        this.add(panel_compra, BorderLayout.EAST);
        panel_compra.setBackground(Color.BLUE);
        panel_compra.setPreferredSize(new Dimension(400, 5));



    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public void comprasComprador(int producto){
        try{
            expendedor = new Expendedor(10);
            c =  new Comprador(m, producto, expendedor);
            System.out.println(c.queConsumiste()+", " + c.cuantoVuelto());
        } catch (PagoIncorrectoException a){
            System.out.println("Error de tipo pago: " + a.getMessage());
        } catch (PagoInsuficienteException a){
            System.out.println("Error de pago: " + a.getMessage() + ". Aqui tiene su dinero: " + m.getValor());
        } catch (NoHayProductoException a){
            System.out.println("Error de inventario: " + a.getMessage() + ". Aqui tiene su dinero: " + m.getValor());
        }

    }

    public void paintComponent(Graphics g){

    }
}
