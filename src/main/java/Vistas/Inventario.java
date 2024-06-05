package Vistas;

import javax.swing.*;
import java.awt.*;

/**
 * Clase INventario
 */
public class Inventario extends JFrame {
    /**
     * Variable Inventario
     */
    public Panel_Inventario panel_inventario;

    /**
     * Metodo constructor
     * @param inv_coca cantidad de cocacolas en inventario
     * @param inv_sprite cantidad de sprite en inventario
     * @param inv_fanta cantidad de fanta en inventario
     * @param inv_snickers cantidad de snickers en inventario
     * @param inv_super8 cantidad de super8 en inventario
     */
    public Inventario(int inv_coca, int inv_sprite, int inv_fanta, int inv_snickers, int inv_super8){
        panel_inventario = new Panel_Inventario(10000);
        panel_inventario.modificarInventario();
        this.add(panel_inventario);
    }

    /**
     * Metodo para mostrar la ventana
     */
    public void activarPanel(){

        this.setVisible(true);
        this.setTitle("Inventario");
        this.setResizable(false);
        this.setSize(320, 350);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.black);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    /**
     * Metodo que modifica los valores en el inventario
     * @param selection variable que representa que producto se compro
     */
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
