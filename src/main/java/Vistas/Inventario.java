package Vistas;

import javax.swing.*;
import java.awt.*;

public class Inventario extends JFrame {
    public int billetera;

    public Panel_Inventario panel_inventario;

    public Inventario(int inv_coca, int inv_sprite, int inv_fanta, int inv_snickers, int inv_super8){
        billetera = 6000;
        panel_inventario = new Panel_Inventario(billetera);
        panel_inventario.modificarInventario();
        this.add(panel_inventario);
    }

    public void activarPanel(){

        this.setVisible(true);
        this.setTitle("Inventario");
        this.setResizable(false);
        this.setSize(320, 350);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.black);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void modificar(int selection){
        switch (selection){
            case 1:
                panel_inventario.inv_cocacola++;
                break;
            case 2:
                panel_inventario.inv_sprite++;
                break;
            case 3:
                panel_inventario.inv_fanta++;
                break;
            case 4:
                panel_inventario.inv_snickers++;
                break;
            case 5:
                panel_inventario.inv_super8++;
                break;
        }
        panel_inventario.modificarInventario();
    }
}
