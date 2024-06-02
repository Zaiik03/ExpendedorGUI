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
import java.util.ArrayList;

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
    private JButton boton_rellenar;
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

    private ArrayList<JLabel> labels_fanta;
    private ArrayList<JLabel> labels_cocacola;
    private ArrayList<JLabel> labels_sprite;
    private ArrayList<JLabel> labels_snickers;
    private ArrayList<JLabel> labels_super8;
    private JLabel label_precios;
    private JPanel panel_productos;
    private JLabel label_borrado = null;

    /* PRUEBA ANIMACIONES */
    int velocidadX = 3, velocidadY = 3, pos_baseX, pos_baseY;;
    Timer timer_compra;
    boolean producto_borrado = false;


    public PanelExpendedor(){
        this.setLayout(new BorderLayout());
        try {
            bg = ImageIO.read(new File("./src/main/java/Vistas/Fotos/expendedor.jpeg"));
            fanta = new ImageIcon("./src/main/java/Vistas/Fotos/fanta.png").getImage();
            cocacola = new ImageIcon("./src/main/java/Vistas/Fotos/cocacola.png").getImage();
            snickers = new ImageIcon("./src/main/java/Vistas/Fotos/snickers.png").getImage();
            sprite =  new ImageIcon("./src/main/java/Vistas/Fotos/sprite.png").getImage();
            super8 =  new ImageIcon("./src/main/java/Vistas/Fotos/super8.png").getImage();
        } catch (IOException e){
            System.out.println(e);
        }
        // this.setOpaque(false);

        expendedor = new Expendedor(1);

        this.setPreferredSize(new Dimension(777,1023));

        panel_botones = new JPanel();
        Border borde = BorderFactory.createLineBorder(Color.green, 10);
        panel_botones.setBorder(borde);

        this.add(panel_botones, BorderLayout.EAST);
        panel_botones.setLayout(new BoxLayout(panel_botones, BoxLayout.Y_AXIS));
        panel_botones.setOpaque(false);
        panel_botones.setPreferredSize(new Dimension(190,0));
        // ---------- TABLERO ---------------
        panel_botones.add(Box.createVerticalStrut(30));
        Font fuente = new Font("monospace", Font.PLAIN, 18);
        label_precios = new JLabel("");
        label_precios.setOpaque(true);
        label_precios.setFont(fuente);
        label_precios.setBackground(new Color(0x0000));
        label_precios.setForeground(Color.CYAN);
        label_precios.setPreferredSize(new Dimension(200, 60));
        label_precio_act(label_precios, "Precio:       ");
        panel_botones.add(label_precios);


        panel_botones.add(Box.createVerticalStrut(30));
        boton_Fanta = new JButton("Fanta");
        boton_Fanta.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        boton_Fanta.setFocusable(false);
        boton_Fanta.setBackground(Color.WHITE);
        boton_Fanta.addActionListener(this);
        panel_botones.add(boton_Fanta);
        panel_botones.add(Box.createVerticalStrut(10));

        boton_Sprite = new JButton("Sprite");
        boton_Sprite.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        boton_Sprite.setFocusable(false);
        boton_Sprite.setBackground(Color.WHITE);
        boton_Sprite.addActionListener(this);
        panel_botones.add(boton_Sprite);
        panel_botones.add(Box.createVerticalStrut(10));

        boton_CocaCola = new JButton("CocaCola");
        boton_CocaCola.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        boton_CocaCola.setFocusable(false);
        boton_CocaCola.setBackground(Color.WHITE);
        boton_CocaCola.addActionListener(this);
        panel_botones.add(boton_CocaCola);
        panel_botones.add(Box.createVerticalStrut(10));

        boton_Snickers = new JButton("Snickers");
        boton_Snickers.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        boton_Snickers.setFocusable(false);
        boton_Snickers.setBackground(Color.WHITE);
        boton_Snickers.addActionListener(this);
        panel_botones.add(boton_Snickers);
        panel_botones.add(Box.createVerticalStrut(10));

        boton_Super8 = new JButton("Super8");
        boton_Super8.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        boton_Super8.setFocusable(false);
        boton_Super8.setBackground(Color.WHITE);
        boton_Super8.addActionListener(this);
        panel_botones.add(boton_Super8);
        panel_botones.add(Box.createVerticalStrut(35));

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

        boton_rellenar = new JButton("Rellenar");
        boton_rellenar.setFocusable(false);
        boton_rellenar.setToolTipText("Presione este botón para rellenar los depósitos de cada producto");
        boton_rellenar.addActionListener(this);
        panel_botones.add(boton_rellenar);
        panel_botones.add(Box.createVerticalStrut(10));

        // -------------------------- CODIGO PRODUCTOS --------------------------
        JPanel panel_vacio = new JPanel();
        panel_vacio.setOpaque(false);
        this.add(panel_vacio, BorderLayout.NORTH);
        panel_vacio.setPreferredSize(new Dimension(0,20));

        JPanel panel_vacio1 = new JPanel();
        panel_vacio1.setOpaque(false);
        this.add(panel_vacio1, BorderLayout.SOUTH);
        panel_vacio1.setPreferredSize(new Dimension(0,75));


        panel_productos = new JPanel();
        Border borde1 = BorderFactory.createLineBorder(Color.GREEN, 10);
        panel_productos.setBorder(borde1);

        this.add(panel_productos, BorderLayout.CENTER);
        panel_productos.setOpaque(false);
        panel_productos.setLayout(null);

        //  ------------ Label de las imagenes ------------
        labels_fanta = new ArrayList<JLabel>();
        labels_cocacola = new ArrayList<JLabel>();
        labels_sprite = new ArrayList<JLabel>();
        labels_snickers = new ArrayList<JLabel>();
        labels_super8 = new ArrayList<JLabel>();

        imagenProductos(fanta, labels_fanta, expendedor.fanta);
        imagenProductos(cocacola, labels_cocacola, expendedor.coca);
        imagenProductos(sprite, labels_sprite, expendedor.sprite);
        imagenProductos(snickers, labels_snickers, expendedor.snickers);
        imagenProductos(super8, labels_super8, expendedor.super8);


        /* INTENTO DE ANIMACIONES */
        timer_compra = new Timer(50,this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == boton_Fanta) {
            // Label con el precio
            label_precio_act(label_precios, "Precio: " + Precios.FANTA.getPrecio());
            seleccion = Expendedor.FANTA;
            boton_comprar.setEnabled(true);
            if(expendedor.fanta.checkSize()){
                boton_Fanta.setEnabled(false);
            }
            repaint();
        } else if(e.getSource() == boton_Sprite){
            label_precio_act(label_precios, "Precio: " + Precios.SPRITE.getPrecio());
            seleccion = Expendedor.SPRITE;
            boton_comprar.setEnabled(true);
            if(expendedor.sprite.checkSize()){
                boton_Sprite.setEnabled(false);
            }
            repaint();
        } else if(e.getSource() == boton_CocaCola){
            label_precio_act(label_precios, "Precio: " + Precios.COCA.getPrecio());
            seleccion = Expendedor.COCA;
            boton_comprar.setEnabled(true);
            if(expendedor.coca.checkSize()){
                boton_CocaCola.setEnabled(false);
            }
            repaint();
        } else if(e.getSource() == boton_Snickers){
            label_precio_act(label_precios, "Precio: " + Precios.SNICKERS.getPrecio());
            seleccion = Expendedor.SNICKERS;
            boton_comprar.setEnabled(true);
            if(expendedor.snickers.checkSize()){
                boton_Snickers.setEnabled(false);
            }
            repaint();
        } else if(e.getSource() == boton_Super8){
            label_precio_act(label_precios, "Precio: " + Precios.SUPER8.getPrecio());
            seleccion = Expendedor.SUPER8;
            boton_comprar.setEnabled(true);
            if(expendedor.super8.checkSize()){
                boton_Super8.setEnabled(false);
            }
            repaint();
        } else if(e.getSource() == boton_recoger) {
            producto_borrado = false;
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
            label_precio_act(label_precios, "Precio:       ");
            boton_recoger.setEnabled(true);
            comprasComprador(seleccion);
            boton_comprar.setEnabled(false);
            boton_Fanta.setEnabled(false);
            boton_Sprite.setEnabled(false);
            boton_CocaCola.setEnabled(false);
            boton_Snickers.setEnabled(false);
            boton_Super8.setEnabled(false);
            repaint();
        } else if(e.getSource() == boton_rellenar){
            expendedor = new Expendedor(5);
            imagenProductos(fanta, labels_fanta, expendedor.fanta);
            imagenProductos(cocacola, labels_cocacola, expendedor.coca);
            imagenProductos(sprite, labels_sprite, expendedor.sprite);
            imagenProductos(snickers, labels_snickers, expendedor.snickers);
            imagenProductos(super8, labels_super8, expendedor.super8);
            boton_Super8.setEnabled(true);
            boton_Fanta.setEnabled(true);
            boton_Sprite.setEnabled(true);
            boton_Snickers.setEnabled(true);
            boton_CocaCola.setEnabled(true);
            repaint();
        } else if(e.getSource() == timer_compra){
            if (seleccion == Expendedor.FANTA){
                if(pos_baseX <= 180){
                    pos_baseX += velocidadX;
                } else{
                    if(pos_baseY <= 480) {
                        pos_baseY += velocidadY;
                    } else {
                        timer_compra.stop();
                        producto_borrado = false;
                    }
                }
            } else if(seleccion == Expendedor.COCA){
                if(pos_baseX >= 180){
                    pos_baseX -= velocidadX;
                } else{
                    if(pos_baseY <= 480) {
                        pos_baseY += velocidadY;
                    } else {
                        timer_compra.stop();
                        producto_borrado = false;
                    }
                }
            } else if(seleccion == Expendedor.SPRITE){
                if(pos_baseX <= 180){
                    pos_baseX += velocidadX;
                } else{
                    if(pos_baseY <= 480) {
                        pos_baseY += velocidadY;
                    } else {
                        timer_compra.stop();
                        producto_borrado = false;
                    }
                }
            } else if(seleccion == Expendedor.SNICKERS){
                if(pos_baseX <= 180){
                    pos_baseX += velocidadX;
                } else{
                    if(pos_baseY <= 480) {
                        pos_baseY += velocidadY;
                    } else {
                        timer_compra.stop();
                        producto_borrado = false;
                    }
                }
            } else if(seleccion == Expendedor.SUPER8){
                if(pos_baseX >= 180){
                    pos_baseX -= velocidadX;
                } else{
                    if(pos_baseY <= 480) {
                        pos_baseY += velocidadY;
                    } else {
                        timer_compra.stop();
                        producto_borrado = false;
                    }
                }
            }
        }
        repaint();
    }

    public void comprasComprador(int producto){
        try{
            c =  new Comprador(moneda, producto, expendedor);
            producto_borrado = true;
            if (seleccion == Expendedor.FANTA){
                imagenProductos(fanta, labels_fanta, expendedor.fanta);
                int dep_size = expendedor.fanta.getSize();
                pos_baseX = 63 + (dep_size * 10) + 10;
                pos_baseY = 185;
                repaint();
            } else if(seleccion == Expendedor.COCA){
                imagenProductos(cocacola, labels_cocacola, expendedor.coca);
                int dep_size = expendedor.coca.getSize();
                pos_baseX = 255 + (dep_size * 10) + 10;
                pos_baseY = 385;
                repaint();
            } else if(seleccion == Expendedor.SPRITE){
                imagenProductos(sprite, labels_sprite, expendedor.sprite);
                int dep_size = expendedor.sprite.getSize();
                pos_baseX = 60 + (dep_size * 10) + 10;
                pos_baseY = 385;
                repaint();
            } else if(seleccion == Expendedor.SNICKERS){
                imagenProductos(snickers, labels_snickers, expendedor.snickers);
                int dep_size = expendedor.snickers.getSize();
                pos_baseX = 45 + (dep_size * 10) + 10;
                pos_baseY = 17;
                repaint();
            } else if(seleccion == Expendedor.SUPER8){
                imagenProductos(super8, labels_super8, expendedor.super8);
                int dep_size = expendedor.super8.getSize();
                pos_baseX = 258 + (dep_size * 10) + 10;
                pos_baseY = 29;
                repaint();
            }
            repaint();
        } catch (PagoIncorrectoException a){
            System.out.println("Error de tipo pago: " + a.getMessage());
        } catch (PagoInsuficienteException a){
            System.out.println("Error de pago: " + a.getMessage() + ". Aqui tiene su dinero: " + moneda.getValor());
        } catch (NoHayProductoException a){
            System.out.println("Error de inventario: " + a.getMessage() + ". Aqui tiene su dinero: " + moneda.getValor());
        }


    }

    /**
     * Metodo paintComponent
     * @param g
     */
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        panel_productos.removeAll();

        if(bg != null){
            Image escalada = bg.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
            g2d.drawImage(escalada, 0,0,this);
        }

        int i = 0;
        for(JLabel j: labels_fanta){
            i += 10;
            g2d.drawImage(fanta, 63+i, 205, null);
            // j.setBounds(50+i,185, 160,120);
            panel_productos.add(j);
        }

        i = 0;
        for(JLabel j: labels_cocacola){
            i += 10;
            g2d.drawImage(cocacola, 305+i, 405, null);
            // j.setBounds(50+i,185, 160,120);
            panel_productos.add(j);
        }

        i = 0;
        for(JLabel j: labels_sprite){
            i += 10;
            g2d.drawImage(sprite, 104+i, 405, null);
            // j.setBounds(50+i,185, 160,120);
            panel_productos.add(j);
        }

        i = 0;
        for(JLabel j: labels_snickers){
            i += 10;
            g2d.drawImage(snickers, 67+i, 20, null);
            // j.setBounds(50+i,185, 160,120);
            panel_productos.add(j);
        }

        i = 0;
        for(JLabel j: labels_super8){
            i += 10;
            g2d.drawImage(super8, 275+i, 45, null);
            // j.setBounds(50+i,185, 160,120);
            panel_productos.add(j);
        }

        if (producto_borrado && seleccion == Expendedor.FANTA){
            label_borrado = new JLabel(new ImageIcon(fanta));
            // g2d.drawImage(fanta, pos_baseX, 205, null);
            label_borrado.setBounds(pos_baseX, pos_baseY, 160, 120);
            panel_productos.add(label_borrado);
            timer_compra.start();
        } else if(producto_borrado && seleccion == Expendedor.COCA){
            label_borrado = new JLabel(new ImageIcon(cocacola));
            // g2d.drawImage(fanta, pos_baseX, 205, null);
            label_borrado.setBounds(pos_baseX, pos_baseY, 160, 120);
            panel_productos.add(label_borrado);
            timer_compra.start();
        } else if(producto_borrado && seleccion == Expendedor.SPRITE){
            label_borrado = new JLabel(new ImageIcon(sprite));
            // g2d.drawImage(fanta, pos_baseX, 205, null);
            label_borrado.setBounds(pos_baseX, pos_baseY, 160, 120);
            panel_productos.add(label_borrado);
            timer_compra.start();
        } else if(producto_borrado && seleccion == Expendedor.SNICKERS){
            label_borrado = new JLabel(new ImageIcon(snickers));
            // g2d.drawImage(fanta, pos_baseX, 205, null);
            label_borrado.setBounds(pos_baseX, pos_baseY, 160, 120);
            panel_productos.add(label_borrado);
            timer_compra.start();
        } else if(producto_borrado && seleccion == Expendedor.SUPER8){
            label_borrado = new JLabel(new ImageIcon(super8));
            // g2d.drawImage(fanta, pos_baseX, 205, null);
            label_borrado.setBounds(pos_baseX, pos_baseY, 160, 120);
            panel_productos.add(label_borrado);
            timer_compra.start();
        }

        panel_productos.repaint();

    }

    /**
     * Metodo imagenProductos, actualiza los productos en stock
     * @param imagen Imagen
     * @param labels arraylist con las imagenes
     * @param dep Deposito con los productos en stock
     */
    public void imagenProductos(Image imagen, ArrayList<JLabel> labels, Deposito dep){
        labels.clear(); // Para evitar colocar más productos de los necesarios
        System.out.println(dep.getSize());
        // Agregar cada label al array
        for(int i = 0;i < dep.getSize();i++){
            labels.add(new JLabel(new ImageIcon(imagen)));
        }
    }

    public void label_precio_act(JLabel label, String texto){
        label.setText(texto);
    }
}
