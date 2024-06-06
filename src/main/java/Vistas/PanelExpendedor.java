package Vistas;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import Modelos.*;

/**
 * Clase Panel Expendedor
 */
public class PanelExpendedor extends JPanel implements ActionListener {

    //  ------------------ Botones -----------------
    /**
     * Button boton comprar
     */
    private JButton boton_comprar;
    /**
     * Button boton recoger producto
     */
    private JButton boton_recoger;
    /**
     * Button boton fanta
     */
    private JButton boton_Fanta;
    /**
     * Button boton sprite
     */
    private JButton boton_Sprite;
    /**
     * Button boton cocacola
     */
    private JButton boton_CocaCola;
    /**
     * Button boton snickers
     */
    private JButton boton_Snickers;
    /**
     * Button boton super8
     */
    private JButton boton_Super8;
    /**
     * Button boton rellenar expendedor
     */
    private JButton boton_rellenar;

    //  ------------------ Labels -----------------
    /**
     * Array Labels fanta
     */
    private ArrayList<JLabel> labels_fanta;
    /**
     * Array Labels cocacola
     */
    private ArrayList<JLabel> labels_cocacola;
    /**
     * Array Labels sprite
     */
    private ArrayList<JLabel> labels_sprite;
    /**
     * Array Labels snickers
     */
    private ArrayList<JLabel> labels_snickers;
    /**
     * Array Labels super8
     */
    private ArrayList<JLabel> labels_super8;
    /**
     * Labels precio
     */
    private JLabel label_precios;
    /**
     * Array Labels de los productos borrado para animaciones
     */
    private JLabel label_borrado = null;

    // ----------- Paneles ---------------
    /**
     * Panel de botones expendedor
     */
    public JPanel panel_botones;
    /**
     * Panel de contenedor de monedas
     */
    public JPanel contenedor_monedas;
    /**
     * Panell de productos del expendedor
     */
    private JPanel panel_productos;

    public JPanel panel_vacio1;

    /**
     * Expendedor con el cual inicia el codigo
     */
    private Expendedor expendedor;
    /**
     * Moneda
     */
    public Moneda moneda;
    /**
     * Comprador para interactuar con el expendedor
     */
    private Comprador c;
    // -------------- Int -------------
    /**
     * Int seleccion del producto
     */
    private int seleccion = 0;
    /**
     * Int suma cocacola
     */
    private int suma_coca = 0;
    /**
     * Int suma sprite
     */
    private int suma_sprite = 0;
    /**
     * Int suma fanta
     */
    private int suma_fanta = 0;
    /**
     * Int suma snickers
     */
    private int suma_snickers = 0;
    /**
     * Int suma super8
     */
    private int suma_super8 = 0;
    /**
     * Int vuelto
     */
    private int vuelto = 0;
    /**
     * Velocidad en X
     */
    int velocidadX = 4;
    /**
     * Volcidad en Y
     */
    int velocidadY = 8;
    /**
     * Posicion de los labels en X
     */
    int pos_baseX;
    /**
     * Posicion de los labels en y
     */
    int pos_baseY;
    /**
     * Imagen fanta
     */
    Image fanta;
    /**
     * Imagen cocacola
     */
    Image cocacola;
    /**
     * Imagen snickers
     */
    Image snickers;
    /**
     * Imagen super8
     */
    Image super8;
    /**
     * Imagen sprite
     */
    Image sprite;
    /**
     * Timer para las animaciones
     */
    Timer timer_compra;
    /**
     * Boolean para los estados
     */
    public boolean producto_borrado = false;
    /**
     * Inventario para desplegar ventana de inventario
     */
    public Inventario inventario;
    /**
     * MusicPlayer para la musica de fondo
     */
    MusicPlayer musica_bg;
    /**
     * Metodo Constructor
     */
    public PanelExpendedor(){
        this.setLayout(new BorderLayout());

        fanta = new ImageIcon("./src/main/java/Vistas/Fotos/fanta.png").getImage();
        cocacola = new ImageIcon("./src/main/java/Vistas/Fotos/cocacola.png").getImage();
        snickers = new ImageIcon("./src/main/java/Vistas/Fotos/snickers.png").getImage();
        sprite =  new ImageIcon("./src/main/java/Vistas/Fotos/sprite.png").getImage();
        super8 =  new ImageIcon("./src/main/java/Vistas/Fotos/super8.png").getImage();

        this.setOpaque(false);

        inventario = new Inventario();

        expendedor = new Expendedor(3);

        this.setPreferredSize(new Dimension(777,1023));

        panel_botones = new JPanel();
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
        panel_botones.add(Box.createVerticalStrut(20));

        boton_Fanta = new JButton("Fanta");
        boton_Fanta.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        boton_Fanta.setFocusable(false);
        boton_Fanta.setForeground(Color.WHITE);
        boton_Fanta.setBackground(new Color(255,128,0));
        boton_Fanta.addActionListener(this);
        panel_botones.add(boton_Fanta);
        listener_mouse(boton_Fanta, 1);
        panel_botones.add(Box.createVerticalStrut(10));

        panel_botones.add(Box.createVerticalStrut(10));

        boton_Sprite = new JButton("Sprite");
        boton_Sprite.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        boton_Sprite.setFocusable(false);
        boton_Sprite.setForeground(Color.WHITE);
        boton_Sprite.setBackground(new Color(51,201,31));
        boton_Sprite.addActionListener(this);
        panel_botones.add(boton_Sprite);
        listener_mouse(boton_Sprite, 2);
        panel_botones.add(Box.createVerticalStrut(10));

        boton_CocaCola = new JButton("CocaCola");
        boton_CocaCola.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        boton_CocaCola.setForeground(Color.WHITE);
        boton_CocaCola.setFocusable(false);
        boton_CocaCola.setBackground(new Color(218,49,20));
        boton_CocaCola.addActionListener(this);
        panel_botones.add(boton_CocaCola);
        listener_mouse(boton_CocaCola, 3);
        panel_botones.add(Box.createVerticalStrut(10));

        boton_Snickers = new JButton("Snickers");
        boton_Snickers.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        boton_Snickers.setForeground(new Color(0, 99, 255));
        boton_Snickers.setFocusable(false);
        boton_Snickers.setBackground(new Color(89, 57, 53));
        boton_Snickers.addActionListener(this);
        panel_botones.add(boton_Snickers);
        listener_mouse(boton_Snickers, 4);
        panel_botones.add(Box.createVerticalStrut(10));

        boton_Super8 = new JButton("Super8");
        boton_Super8.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        boton_Super8.setForeground(Color.YELLOW);
        boton_Super8.setFocusable(false);
        boton_Super8.setBackground(new Color(24, 19, 18));
        boton_Super8.addActionListener(this);
        panel_botones.add(boton_Super8);
        listener_mouse(boton_Super8, 5);
        panel_botones.add(Box.createVerticalStrut(25));

        boton_comprar = new JButton("Comprar");
        boton_comprar.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        boton_comprar.setFocusable(false);
        boton_comprar.addActionListener(this);
        boton_comprar.setEnabled(false);
        panel_botones.add(boton_comprar);
        panel_botones.add(Box.createVerticalStrut(25));

        boton_recoger = new JButton("Recoger");
        boton_recoger.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        boton_recoger.setForeground(Color.WHITE);
        boton_recoger.setBackground(new Color(40,39,53));
        boton_recoger.setFocusable(false);
        boton_recoger.setEnabled(false);
        boton_recoger.addActionListener(this);
        this.add(boton_recoger);
        boton_recoger.setBounds(120,700, 270, 50);


        boton_rellenar = new JButton("Rellenar");
        boton_rellenar.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        boton_rellenar.setFocusable(false);
        boton_rellenar.setBackground(new Color(54, 46, 46));
        boton_rellenar.setForeground(Color.WHITE);
        boton_rellenar.setToolTipText("Presione este botón para rellenar los depósitos de cada producto");
        boton_rellenar.addActionListener(this);
        panel_botones.add(boton_rellenar);
        listener_mouse(boton_rellenar, 7);
        panel_botones.add(Box.createVerticalStrut(5));

        contenedor_monedas = new JPanel();
        this.add(contenedor_monedas);
        contenedor_monedas.setLayout(new FlowLayout());
        contenedor_monedas.setOpaque(false);
        contenedor_monedas.setBounds(552,521, 175,220);

        // -------------------------- CODIGO PRODUCTOS --------------------------
        JPanel panel_vacio = new JPanel();
        panel_vacio.setOpaque(false);
        this.add(panel_vacio, BorderLayout.NORTH);
        panel_vacio.setPreferredSize(new Dimension(0,20));

        panel_vacio1 = new JPanel();
        panel_vacio1.setOpaque(false);
        panel_vacio1.setLayout(null);
        this.add(panel_vacio1, BorderLayout.SOUTH);
        panel_vacio1.setPreferredSize(new Dimension(0,265));



        panel_productos = new JPanel();
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

        musica_bg = new MusicPlayer();
        musica_bg.play("./src/main/java/Vistas/Sonidos/musica_fondo.wav");
        musica_bg.loop();

        timer_compra = new Timer(30,this);
    }

    /**
     * Metodo actionPerformed
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == boton_Fanta) {
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
                vuelto = c.recogerProducto(expendedor);
                moneda = null;
                inventario.panel_inventario.billetera_comprador += vuelto;
                vuelto = 0;
                inventario.panel_inventario.modificarInventario();
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
                    if(pos_baseY <= 560) {
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
                    if(pos_baseY <= 560) {
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
                    if(pos_baseY <= 560) {
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
                    if(pos_baseY <= 560) {
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
                    if(pos_baseY <= 560) {
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

    /**
     * Metodo comprasComprador
     * @param producto se le ingresa un int con el numero de producto
     */
    public void comprasComprador(int producto){
        try{
            c =  new Comprador(moneda, producto, expendedor);
            actualizarInventario(seleccion);
            producto_borrado = true;
            if (seleccion == Expendedor.FANTA){
                imagenProductos(fanta, labels_fanta, expendedor.fanta);
                int dep_size = expendedor.fanta.getSize();
                pos_baseX = 49 + (dep_size * 10) + 10;
                pos_baseY = 189;
                repaint();
            } else if(seleccion == Expendedor.COCA){
                imagenProductos(cocacola, labels_cocacola, expendedor.coca);
                int dep_size = expendedor.coca.getSize();
                pos_baseX = 239 + (dep_size * 10) + 10;
                pos_baseY = 389;
                repaint();
            } else if(seleccion == Expendedor.SPRITE){
                imagenProductos(sprite, labels_sprite, expendedor.sprite);
                int dep_size = expendedor.sprite.getSize();
                pos_baseX = 39 + (dep_size * 10) + 10;
                pos_baseY = 389;
                repaint();
            } else if(seleccion == Expendedor.SNICKERS){
                imagenProductos(snickers, labels_snickers, expendedor.snickers);
                int dep_size = expendedor.snickers.getSize();
                pos_baseX = 40 + (dep_size * 10) + 10;
                pos_baseY = 27;
                repaint();
            } else if(seleccion == Expendedor.SUPER8){
                imagenProductos(super8, labels_super8, expendedor.super8);
                int dep_size = expendedor.super8.getSize();
                pos_baseX = 234 + (dep_size * 10) + 10;
                pos_baseY = 29;
                repaint();
            }
            repaint();
        } catch (PagoIncorrectoException a){
            System.out.println("Error de tipo pago: " + a.getMessage());
            JOptionPane.showMessageDialog(null, "Moneda nula, presione Aceptar y luego Recoger", "Error de tipo de pago", JOptionPane.PLAIN_MESSAGE);
        } catch (PagoInsuficienteException a) {
            if(c != null){
                vuelto = c.recogerProducto(expendedor);
                inventario.panel_inventario.billetera_comprador += vuelto;
                vuelto = 0;
                inventario.panel_inventario.modificarInventario();
            }
            JOptionPane.showMessageDialog(null, "Moneda inferior al precio, presione Aceptar y luego Recoger", "Error de pago", JOptionPane.PLAIN_MESSAGE);
            moneda = null;
        } catch (NoHayProductoException a){
            vuelto = c.recogerProducto(expendedor);
            inventario.panel_inventario.billetera_comprador += vuelto;
            vuelto = 0;
            inventario.panel_inventario.modificarInventario();
            moneda = null;
        }
    }

    /**
     * Metodo paintComponent
     * @param g the <code>Graphics</code> object to protect
     */
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        panel_productos.removeAll();

        int i = 0;
        for(JLabel j: labels_fanta){
            i += 10;
            g2d.drawImage(fanta, 63+i, 205, null);
            panel_productos.add(j);
        }

        i = 0;
        for(JLabel j: labels_cocacola){
            i += 10;
            g2d.drawImage(cocacola, 255+i, 405, null);
            panel_productos.add(j);
        }

        i = 0;
        for(JLabel j: labels_sprite){
            i += 10;
            g2d.drawImage(sprite, 55+i, 405, null);
            panel_productos.add(j);
        }

        i = 0;
        for(JLabel j: labels_snickers){
            i += 10;
            g2d.drawImage(snickers, 50+i, 43, null);
            panel_productos.add(j);
        }

        i = 0;
        for(JLabel j: labels_super8){
            i += 10;
            g2d.drawImage(super8, 250+i, 45, null);
            panel_productos.add(j);
        }

        if (producto_borrado && seleccion == Expendedor.FANTA){
            label_borrado = new JLabel(new ImageIcon(fanta));
            label_borrado.setBounds(pos_baseX, pos_baseY, 160, 120);
            panel_productos.add(label_borrado);
            timer_compra.start();
        } else if(producto_borrado && seleccion == Expendedor.COCA){
            label_borrado = new JLabel(new ImageIcon(cocacola));
            label_borrado.setBounds(pos_baseX, pos_baseY, 160, 120);
            panel_productos.add(label_borrado);
            timer_compra.start();
        } else if(producto_borrado && seleccion == Expendedor.SPRITE){
            label_borrado = new JLabel(new ImageIcon(sprite));
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
            label_borrado.setBounds(pos_baseX, pos_baseY, 160, 120);
            panel_productos.add(label_borrado);
            timer_compra.start();
        }

        panel_vacio1.repaint();
        panel_productos.repaint();

    }

    /**
     * Metodo imagenProductos, actualiza los productos en stock
     * @param imagen Imagen
     * @param labels arraylist con las imagenes
     * @param dep Deposito con los productos en stock
     */
    public void imagenProductos(Image imagen, ArrayList<JLabel> labels, Deposito dep){
        labels.clear();
        for(int i = 0;i < dep.getSize();i++){
            labels.add(new JLabel(new ImageIcon(imagen)));
        }
    }

    /**
     * Metodo para mostrar los precios de los productos
     * @param label le ingresamos un label
     * @param texto texto que tendra el Label
     */
    public void label_precio_act(JLabel label, String texto){
        label.setText(texto);
    }

    /**
     * Metodo para manejo de eventos del mouse
     * @param boton Boton al que se le quiere manejar eventos
     * @param i valor numerico
     */
    public void listener_mouse(JButton boton, int i){
        boton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {

            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseEntered(MouseEvent mouseEvent) {
                if(i == 1){
                    boton.setBackground(new Color(146, 76, 7));
                } else if(i == 2){
                    boton.setBackground(new Color(16, 115, 9));
                } else if(i == 3){
                    boton.setBackground(new Color(138, 24, 5));
                } else if(i == 4){
                    boton.setBackground(new Color(59, 40, 38));
                } else if(i == 5){
                    boton.setBackground(new Color(126, 119, 119));
                } else if(i == 7){
                    boton.setBackground(new Color(0, 0, 0));
                }
            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {
                if(i == 1){
                    boton.setBackground(new Color(255,128,0));
                } else if(i == 2){
                    boton.setBackground(new Color(51,201,31));
                } else if(i == 3){
                    boton.setBackground(new Color(218,49,20));
                } else if(i == 4){
                    boton.setBackground(new Color(89, 57, 53));
                } else if(i == 5){
                    boton.setBackground(new Color(24, 19, 18));
                } else if(i == 7){
                    boton.setBackground(new Color(54, 46, 46));
                }
            }
        });
    }

    /**
     * Metodo actualizarInventario
     * @param seleccion numero del producto a comprar
     */
    public void actualizarInventario(int seleccion){
        switch(seleccion){
            case 1:
                inventario.modificar(1);
                break;
            case 2:
                inventario.modificar(2);
                break;
            case 3:
                inventario.modificar(3);
                break;
            case 4:
                inventario.modificar(4);
                break;
            case 5:
                inventario.modificar(5);
                break;
        }
    }


}
