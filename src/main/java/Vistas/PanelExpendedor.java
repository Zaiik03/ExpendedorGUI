package Vistas;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import Modelos.*;

public class PanelExpendedor extends JPanel implements ActionListener {

    // Botones
    private JButton boton_comprar;
    private JButton boton_recoger;
    private JButton boton_Fanta;
    private JButton boton_Sprite;
    private JButton boton_CocaCola;
    private JButton boton_Snickers;
    private JButton boton_Super8;
    private JButton boton_reset;
    public JPanel panel_botones;

    // Prueba
    private Expendedor expendedor;
    public Moneda moneda;
    private Comprador c;
    private int seleccion = 0;

    Image fanta;
    Image cocacola;
    Image snickers;
    Image super8;
    Image sprite;

    BufferedImage bg;
    public PanelExpendedor(){
        this.setLayout(new BorderLayout());
        try {
            bg = ImageIO.read(new File("./src/main/java/Vistas/Fotos/expendedor.png"));
            fanta = new ImageIcon("./src/main/java/Vistas/Fotos/fanta.png").getImage();
            cocacola = new ImageIcon("./src/main/java/Vistas/Fotos/cocacola.png").getImage();
            snickers = new ImageIcon("./src/main/java/Vistas/Fotos/snickers.png").getImage();
            sprite =  new ImageIcon("./src/main/java/Vistas/Fotos/sprite.png").getImage();
            super8 =  new ImageIcon("./src/main/java/Vistas/Fotos/super8.png").getImage();
        } catch (IOException e){
            System.out.println(e);
        }
        // this.setOpaque(false);

        expendedor = new Expendedor(3);

        this.setPreferredSize(new Dimension(777,1023));

        panel_botones = new JPanel();
        this.add(panel_botones, BorderLayout.EAST);
        panel_botones.setLayout(new BoxLayout(panel_botones, BoxLayout.Y_AXIS));
        panel_botones.setOpaque(false);
        panel_botones.setPreferredSize(new Dimension(125,0));



        panel_botones.add(Box.createVerticalStrut(60));
        boton_Fanta = new JButton("Fanta");
        boton_Fanta.setFocusable(false);
        boton_Fanta.addActionListener(this);
        panel_botones.add(boton_Fanta);
        panel_botones.add(Box.createVerticalStrut(10));

        boton_Sprite = new JButton("Sprite");
        boton_Sprite.setFocusable(false);
        boton_Sprite.addActionListener(this);
        panel_botones.add(boton_Sprite);
        panel_botones.add(Box.createVerticalStrut(10));

        boton_CocaCola = new JButton("CocaCola");
        boton_CocaCola.setFocusable(false);
        boton_CocaCola.addActionListener(this);
        panel_botones.add(boton_CocaCola);
        panel_botones.add(Box.createVerticalStrut(10));

        boton_Snickers = new JButton("Snickers");
        boton_Snickers.setFocusable(false);
        boton_Snickers.addActionListener(this);
        panel_botones.add(boton_Snickers);
        panel_botones.add(Box.createVerticalStrut(10));

        boton_Super8 = new JButton("Super8");
        boton_Super8.setFocusable(false);
        boton_Super8.addActionListener(this);
        panel_botones.add(boton_Super8);
        panel_botones.add(Box.createVerticalStrut(70));

        boton_comprar = new JButton("Comprar");
        boton_comprar.setFocusable(false);
        boton_comprar.addActionListener(this);
        boton_comprar.setEnabled(false);
        panel_botones.add(boton_comprar);
        panel_botones.add(Box.createVerticalStrut(10));

        boton_recoger = new JButton("Recoger");
        boton_recoger.setFocusable(false);
        boton_recoger.setEnabled(false);
        boton_recoger.addActionListener(this);
        panel_botones.add(boton_recoger);
        panel_botones.add(Box.createVerticalStrut(10));

        boton_reset = new JButton("Rellenar");
        boton_reset.setFocusable(false);
        boton_reset.addActionListener(this);
        panel_botones.add(boton_reset);
        panel_botones.add(Box.createVerticalStrut(10));

        // -------------------------- CODIGO PRODUCTOS --------------------------
        JPanel panel_vacio = new JPanel();
        panel_vacio.setOpaque(false);
        this.add(panel_vacio, BorderLayout.NORTH);
        panel_vacio.setPreferredSize(new Dimension(0,75));

        JPanel panel_vacio1 = new JPanel();
        panel_vacio1.setOpaque(false);
        this.add(panel_vacio1, BorderLayout.SOUTH);
        panel_vacio1.setPreferredSize(new Dimension(0,75));


        JPanel panel_productos = new JPanel();

//        Border borde = BorderFactory.createLineBorder(Color.GREEN, 10);
//        panel_productos.setBorder(borde);

        this.add(panel_productos, BorderLayout.CENTER);
        panel_productos.setOpaque(false);
        panel_productos.setLayout(new GridLayout(4,3, 1,15));

        JLabel label_fanta = new JLabel(new ImageIcon(fanta));
        JLabel label_cocacola = new JLabel(new ImageIcon(cocacola));
        JLabel label_sprite = new JLabel(new ImageIcon(sprite));
        JLabel label_snickers = new JLabel(new ImageIcon(snickers));
        JLabel label_super8 = new JLabel(new ImageIcon(super8));

        panel_productos.add(label_fanta);
        panel_productos.add(label_sprite);
        panel_productos.add(label_cocacola);
        panel_productos.add(label_snickers);
        panel_productos.add(label_super8);

        /* INTENTO DE ANIMACIONES */
        Timer timer_fanta = new Timer(100,this);
        timer_fanta.start();





    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == boton_Fanta) {
            seleccion = Expendedor.FANTA;
            boton_comprar.setEnabled(true);
            if(expendedor.fanta.checkSize()){
                boton_Fanta.setEnabled(false);
            }
        } else if(e.getSource() == boton_Sprite){
            seleccion = Expendedor.SPRITE;
            boton_comprar.setEnabled(true);
            if(expendedor.sprite.checkSize()){
                boton_Sprite.setEnabled(false);
            }
        } else if(e.getSource() == boton_CocaCola){
            seleccion = Expendedor.COCA;
            boton_comprar.setEnabled(true);
            if(expendedor.coca.checkSize()){
                boton_CocaCola.setEnabled(false);
            }
        } else if(e.getSource() == boton_Snickers){
            seleccion = Expendedor.SNICKERS;
            boton_comprar.setEnabled(true);
            if(expendedor.snickers.checkSize()){
                boton_Snickers.setEnabled(false);
            }
        } else if(e.getSource() == boton_Super8){
            seleccion = Expendedor.SUPER8;
            boton_comprar.setEnabled(true);
            if(expendedor.super8.checkSize()){
                boton_Super8.setEnabled(false);
            }
        } else if(e.getSource() == boton_recoger) {
            boton_comprar.setEnabled(false);
            if (!expendedor.coca.checkSize()) {
                boton_CocaCola.setEnabled(true);
            }

            if (!expendedor.sprite.checkSize()) {
                boton_Sprite.setEnabled(true);
            }
            if (!expendedor.fanta.checkSize()) {
                boton_Fanta.setEnabled(true);
            }
            if(!expendedor.snickers.checkSize()) {
                boton_Snickers.setEnabled(true);
            }
            if(!expendedor.super8.checkSize()){
                boton_Super8.setEnabled(true);
            }
            if(c != null){
                c.recogerProducto(expendedor);
                moneda = null;
            }
            seleccion = 0;
            boton_recoger.setEnabled(false);
        } else if(e.getSource() == boton_comprar){
            boton_recoger.setEnabled(true);
            comprasComprador(seleccion);
            boton_comprar.setEnabled(false);
            boton_Fanta.setEnabled(false);
            boton_Sprite.setEnabled(false);
            boton_CocaCola.setEnabled(false);
            boton_Snickers.setEnabled(false);
            boton_Super8.setEnabled(false);
        } else if(e.getSource() == boton_reset){
            expendedor = new Expendedor(2);
            boton_Super8.setEnabled(true);
            boton_Fanta.setEnabled(true);
            boton_Sprite.setEnabled(true);
            boton_Snickers.setEnabled(true);
            boton_CocaCola.setEnabled(true);
        }

        
    }

    public void comprasComprador(int producto){
        try{
            c =  new Comprador(moneda, producto, expendedor);
        } catch (PagoIncorrectoException a){
            System.out.println("Error de tipo pago: " + a.getMessage());
        } catch (PagoInsuficienteException a){
            System.out.println("Error de pago: " + a.getMessage() + ". Aqui tiene su dinero: " + moneda.getValor());
        } catch (NoHayProductoException a){
            System.out.println("Error de inventario: " + a.getMessage() + ". Aqui tiene su dinero: " + moneda.getValor());
        }

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        int x = 0;
        int y = 0;
        int velocidadX = 1;
        int velocidadY = 1;


        Graphics2D g2d = (Graphics2D) g;
        if(bg != null){
//            Image escalada = bg.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
            g2d.drawImage(bg, 0,0,this);
        }

        g2d.drawImage(fanta,x,y,null);



    }



}
