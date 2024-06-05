package Vistas;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import Modelos.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

/**
 * Clase PanelComprador
 */
public class PanelComprador extends JPanel implements ActionListener {

    /**
     *RadioButton para moneda de 100
     */
    public JRadioButton moneda100;
    /**
     *RadioButtonpara moneda de 500
     */
    public JRadioButton moneda500;
    /**
     *RadioButton para moneda de 1000
     */
    public JRadioButton moneda1000;
    /**
     *Boton para confirmar la elección de la moneda
     */
    private JButton confirmar_moneda;
    /**
     *Boton para abrir el inventario
     */
    private JButton inventario;
    /**
     * Panel para las monedas
     */
    public JPanel panel_monedas;
    /**
     * Panel para el monedero
     */
    public JPanel panel_monedero;
    /**
     * Valor númerico que nos dira que moneda fue seleccionada
     */
    int seleccion_moneda = 0;
    /**
     *Variable moneda
     */
    private Moneda moneda;
    /**
     * Variable para crear una panel para el expendedor
     */
    private PanelExpendedor panel_expendedor;
    /**
     * Variable un timer para las monedas
     */
    private Timer timer_monedaNull;
    /**
     * Variable timer para las animaciones de las monedas
     */
    private Timer animacion_moneda;
    /**
     * Crea un timer para las monedas
     */
    Font fontRadioButton = new Font("Arial", Font.PLAIN, 14);

    /**
     * Variable Imagen para la moneda de 100
     */
    Image moneda100_img;
    /**
     * Variable Imagen para la moneda de 500
     */
    Image moneda500_img;
    /**
     * Variable Imagen para la moneda de 1000
     */
    Image moneda1000_img;
    /**
     * Variable Imagen para la moneda de 100 cuando es selccionada
     */
    Image moneda100_opaca;
    /**
     * Variable Imagen para la moneda de 500 cuando es selccionada
     */
    Image moneda500_opaca;
    /**
     * Variable Imagen para la moneda de 1000 cuando es selccionada
     */
    Image moneda1000_opaca;
    /**
     * Variable Imagen para el monedero
     */
    Image monedero_img;
    /**
     * Variable MusicPlayer para agregar sonido a las monedas
     */
    MusicPlayer musica_moneda;
    /**
     * Variables enteras para la velocidad de las animaciones
     */
    int velocidadX = 4, velocidadY = 8, pos_baseX, pos_baseY;
    /**
     * Variable JLabel para la moneda de 100
     */
    JLabel label_moneda100;
    /**
     * Variable JLabel para la moneda de 500
     */
    JLabel label_moneda500;
    /**
     * Variable JLabel para la moneda de 1000
     */
    JLabel label_moneda1000;

    /**
     * Validacion para animacion monedas
     */
    Boolean moneda_destino = false;
    /**
     * Sonido de moneda entrando al expendedor
     */
    MusicPlayer moneda_entrando;
    /**
     * Metodo PanelComprador
     * @param panel_expendedor para manipular sus propiedades
     */
    public PanelComprador(PanelExpendedor panel_expendedor){
        this.panel_expendedor = panel_expendedor;
        this.setOpaque(false);
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(800,1));
        timer_monedaNull = new Timer(100, null);
        timer_monedaNull.addActionListener(this);
        timer_monedaNull.start();

        animacion_moneda = new Timer(100, null);
        animacion_moneda.addActionListener(this);

        moneda100_img = new ImageIcon("./src/main/java/Vistas/Fotos/moneda100.png").getImage();
        moneda500_img = new ImageIcon("./src/main/java/Vistas/Fotos/moneda500.png").getImage();
        moneda1000_img = new ImageIcon("./src/main/java/Vistas/Fotos/moneda1000.png").getImage();
        moneda100_opaca = new ImageIcon("./src/main/java/Vistas/Fotos/moneda100_opaca.png").getImage();
        moneda500_opaca = new ImageIcon("./src/main/java/Vistas/Fotos/moneda500_opaca.png").getImage();
        moneda1000_opaca = new ImageIcon("./src/main/java/Vistas/Fotos/moneda1000_opaca.png").getImage();
        monedero_img = new ImageIcon("./src/main/java/Vistas/Fotos/monedero.png").getImage();

        moneda100 = new JRadioButton();
        moneda500 = new JRadioButton();
        moneda1000 = new JRadioButton();

        config_botones(moneda100, moneda100_img);
        config_botones(moneda500, moneda500_img);
        config_botones(moneda1000, moneda1000_img);

        inventario = new JButton("Inventario");
        inventario.setFocusable(false);
        inventario.addActionListener(this);

        moneda100.addActionListener(this);
        moneda500.addActionListener(this);
        moneda1000.addActionListener(this);
        musica_moneda = new MusicPlayer();

        listener_mouse(moneda100, 1);
        listener_mouse(moneda500, 2);
        listener_mouse(moneda1000, 3);

        panel_monedas = new JPanel();
        panel_monedas.setLayout(null);
        panel_monedas.setOpaque(false);
        panel_monedas.setPreferredSize(new Dimension(175,220));
        panel_monedas.add(moneda100);
        panel_monedas.add(moneda500);
        panel_monedas.add(moneda1000);
        moneda100.setBounds(5,0, 70, 70);
        moneda500.setBounds(120,0, 70, 70);
        moneda1000.setBounds(65,45, 70, 70);
        confirmar_moneda = new JButton("Confirmar moneda");
        confirmar_moneda.setFocusable(false);
        confirmar_moneda.addActionListener(this);
        confirmar_moneda.setBounds(5, 110, 150,25);
        panel_monedas.add(confirmar_moneda);


        panel_expendedor.contenedor_monedas.add(panel_monedas);


        ButtonGroup grupo_monedas = new ButtonGroup();
        grupo_monedas.add(moneda100);
        grupo_monedas.add(moneda500);
        grupo_monedas.add(moneda1000);

        timer_monedaNull = new Timer(100, null);
        timer_monedaNull.addActionListener(this);
        timer_monedaNull.start();

        panel_expendedor.panel_botones.add(inventario);

        moneda_entrando = new MusicPlayer();

    }

    /**
     * Metodo actionPerformed
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == moneda100){
            if(panel_expendedor.inventario.panel_inventario.billetera_comprador - 100 >= 0){
                seleccion_moneda = 100;
            } else {
                JOptionPane.showMessageDialog(null, "Dinero insuficiente, usted cuenta con " + panel_expendedor.inventario.panel_inventario.billetera_comprador + ". Revise inventario", "Error dinero insuficiente", JOptionPane.PLAIN_MESSAGE);
            }
        } else if(e.getSource() == moneda500){
            if(panel_expendedor.inventario.panel_inventario.billetera_comprador - 500 >= 0){
                seleccion_moneda = 500;
            } else {
                JOptionPane.showMessageDialog(null, "Dinero insuficiente, usted cuenta con " + panel_expendedor.inventario.panel_inventario.billetera_comprador + ". Revise inventario", "Error dinero insuficiente", JOptionPane.PLAIN_MESSAGE);
            }
        } else if(e.getSource() == moneda1000){
            if(panel_expendedor.inventario.panel_inventario.billetera_comprador - 1000 >= 0){
                seleccion_moneda = 1000;
            } else {
                JOptionPane.showMessageDialog(null, "Dinero insuficiente, usted cuenta con " + panel_expendedor.inventario.panel_inventario.billetera_comprador + ". Revise inventario", "Error dinero insuficiente", JOptionPane.PLAIN_MESSAGE);
            }
        } else if(e.getSource() == confirmar_moneda){
            if(seleccion_moneda == 100 && panel_expendedor.inventario.panel_inventario.billetera_comprador - 100 >= 0 ){
                panel_expendedor.moneda = new Moneda100();
                moneda100.setEnabled(false);
                moneda500.setEnabled(false);
                moneda1000.setEnabled(false);

                pos_baseX = 750;
                pos_baseY = 0;
                animacion_moneda.start();
                moneda_destino = false;
                panel_expendedor.inventario.panel_inventario.billetera_comprador -= 100;
                panel_expendedor.inventario.panel_inventario.modificarInventario();
                repaint();
            } else if(seleccion_moneda == 500 && panel_expendedor.inventario.panel_inventario.billetera_comprador - 500 >= 0){
                panel_expendedor.moneda = new Moneda500();
                moneda100.setEnabled(false);
                moneda500.setEnabled(false);
                moneda1000.setEnabled(false);

                pos_baseX = 750;
                pos_baseY = 0;
                animacion_moneda.start();
                moneda_destino = false;
                panel_expendedor.inventario.panel_inventario.billetera_comprador -= 500;
                panel_expendedor.inventario.panel_inventario.modificarInventario();
                repaint();
            } else if(seleccion_moneda == 1000 && panel_expendedor.inventario.panel_inventario.billetera_comprador - 1000 >= 0){
                panel_expendedor.moneda = new Moneda1000();
                moneda100.setEnabled(false);
                moneda500.setEnabled(false);
                moneda1000.setEnabled(false);

                pos_baseX = 750;
                pos_baseY = 0;
                animacion_moneda.start();
                moneda_destino = false;
                panel_expendedor.inventario.panel_inventario.billetera_comprador -= 1000;
                panel_expendedor.inventario.panel_inventario.modificarInventario();
                repaint();
            }
        } else if(e.getSource() == timer_monedaNull){
            if(panel_expendedor.moneda == null){
                moneda100.setEnabled(true);
                moneda500.setEnabled(true);
                moneda1000.setEnabled(true);
            }
        } else if(e.getSource() == inventario){
            panel_expendedor.inventario.activarPanel();
        } else if(e.getSource() == animacion_moneda){
            if(panel_expendedor.moneda != null){
                if(panel_expendedor.moneda.getValor() == 100){
                    if(pos_baseX >= 710){
                        pos_baseX -= velocidadX;
                    } else{
                        if(pos_baseY <= 72) {
                            pos_baseY += velocidadY;
                        } else {
                            if(pos_baseX >= 600 ){
                                pos_baseX -= velocidadX;
                            } else{
                                moneda_entrando.play("./src/main/java/Vistas/Sonidos/moneda_entrando.wav");
                                label_moneda1000 = null;
                                moneda_destino = true;
                                animacion_moneda.stop();
                                pos_baseX = 0;
                                pos_baseY = 0;
                            }
                        }
                    }
                } else if(panel_expendedor.moneda.getValor() == 500){
                    if(pos_baseX >= 710){
                        pos_baseX -= velocidadX;
                    } else{
                        if(pos_baseY <= 72) {
                            pos_baseY += velocidadY;
                        } else {
                            if(pos_baseX >= 600 ){
                                pos_baseX -= velocidadX;
                            } else{
                                moneda_entrando.play("./src/main/java/Vistas/Sonidos/moneda_entrando.wav");
                                label_moneda1000 = null;
                                moneda_destino = true;
                                animacion_moneda.stop();
                                pos_baseX = 0;
                                pos_baseY = 0;
                            }
                        }
                    }
                } else if(seleccion_moneda == 1000){
                    if(pos_baseX >= 710){
                        pos_baseX -= velocidadX;
                    } else{
                        if(pos_baseY <= 72) {
                            pos_baseY += velocidadY;
                        } else {
                            if(pos_baseX >= 600 ){
                                pos_baseX -= velocidadX;
                            } else{
                                moneda_entrando.play("./src/main/java/Vistas/Sonidos/moneda_entrando.wav");
                                label_moneda1000 = null;
                                moneda_destino = true;
                                animacion_moneda.stop();
                                pos_baseX = 0;
                                pos_baseY = 0;
                            }
                        }
                    }
                }
            }
        }
        repaint();
    }

    /**
     * Metodo paintComponent
     * @param g the <code>Graphics</code> object to protect
     */
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        panel_expendedor.panel_vacio1.removeAll();
        if (panel_expendedor.moneda != null) {
            if (label_moneda100 != null) {
                panel_expendedor.panel_vacio1.remove(label_moneda100);
            }
            if (label_moneda500 != null) {
                panel_expendedor.panel_vacio1.remove(label_moneda500);
            }
            if (label_moneda1000 != null) {
                panel_expendedor.panel_vacio1.remove(label_moneda1000);
            }
        }

        if (panel_expendedor.moneda != null && !moneda_destino) {
            if (panel_expendedor.moneda.getValor() == 100) {
                label_moneda100 = new JLabel(new ImageIcon(moneda100_img));
                label_moneda100.setBounds(pos_baseX, pos_baseY, 70, 70);
                panel_expendedor.panel_vacio1.add(label_moneda100);

            } else if (panel_expendedor.moneda.getValor() == 500) {
                label_moneda500 = new JLabel(new ImageIcon(moneda500_img));
                label_moneda500.setBounds(pos_baseX, pos_baseY, 70, 70);
                panel_expendedor.panel_vacio1.add(label_moneda500);

            } else if (panel_expendedor.moneda.getValor() == 1000) {
                label_moneda1000 = new JLabel(new ImageIcon(moneda1000_img));
                label_moneda1000.setBounds(pos_baseX, pos_baseY, 70, 70);
                panel_expendedor.panel_vacio1.add(label_moneda1000);

            }
        }
    }

    /**
     * Metodo listener mouse
     * @param radio_boton RadioButton al que se le manejara eventos
     * @param i valor numerico
     */
    public void listener_mouse(JRadioButton radio_boton, int i){
        radio_boton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                musica_moneda.play("./src/main/java/Vistas/Sonidos/select_moneda.wav");
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                if(i == 1){
                    radio_boton.setIcon(new ImageIcon(moneda100_opaca));
                } else if(i == 2){
                    radio_boton.setIcon(new ImageIcon(moneda500_opaca));
                } else if(i == 3){
                    radio_boton.setIcon(new ImageIcon(moneda1000_opaca));
                }

            }

            @Override
            public void mouseExited(MouseEvent e) {
                if(i == 1){
                    radio_boton.setIcon(new ImageIcon(moneda100_img));
                } else if(i == 2){
                    radio_boton.setIcon(new ImageIcon(moneda500_img));
                } else if(i == 3){
                    radio_boton.setIcon(new ImageIcon(moneda1000_img));
                }
            }
        });
    }

    /**
     * Metodo configuracion de botones
     * @param radio_boton Radio Button que quieremos configurar
     * @param imagen icono de cada boton
     */
    public void config_botones(JRadioButton radio_boton, Image imagen){
        radio_boton.setIcon(new ImageIcon(imagen));
        radio_boton.setOpaque(false);
        radio_boton.setFocusable(false);
        radio_boton.setForeground(Color.WHITE);
        radio_boton.setFont(fontRadioButton);
        radio_boton.setPreferredSize(new Dimension(70,70));
        radio_boton.setMargin(new Insets(0,0,0,0));
    }
}
