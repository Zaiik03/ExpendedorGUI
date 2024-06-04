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


public class PanelComprador extends JPanel implements ActionListener {

    public JRadioButton moneda100;
    public JRadioButton moneda500;
    public JRadioButton moneda1000;
    private JButton confirmar_moneda;
    private JButton inventario;

    public JPanel panel_monedas;
    int seleccion_moneda = 0;
    private Moneda moneda;

    private PanelExpendedor panel_expendedor;

    private Timer timer_monedaNull;
    private Timer animacion_moneda;

    Font fontRadioButton = new Font("Arial", Font.PLAIN, 14);

    Image moneda100_img;
    Image moneda500_img;
    Image moneda1000_img;
    Image moneda100_opaca;
    Image moneda500_opaca;
    Image moneda1000_opaca;
    Image monedero_img;
    MusicPlayer musica_moneda;


    int velocidadX = 4, velocidadY = 8, pos_baseX, pos_baseY;
    JLabel label_moneda100;
    JLabel label_moneda500;
    JLabel label_moneda1000;
    public PanelComprador(PanelExpendedor panel_expendedor){
        this.panel_expendedor = panel_expendedor;
        this.setOpaque(false);
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(800,100));

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



        /* JPanel contenedor_monedas = new JPanel();
        this.add(contenedor_monedas, BorderLayout.EAST);

        JPanel panel_monedas = new JPanel(); */

        config_botones(moneda100, moneda100_img);
        config_botones(moneda500, moneda500_img);
        config_botones(moneda1000, moneda1000_img);
        moneda100.setBorder(BorderFactory.createLineBorder(Color.GREEN, 20));
        moneda500.setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
        moneda1000.setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));

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
        panel_monedas.setPreferredSize(new Dimension(175,150));
        panel_monedas.setBorder(BorderFactory.createLineBorder(Color.RED, 5));
        //panel_monedas.setBorder(BorderFactory.createLineBorder(Color.GREEN, 10));
        panel_monedas.add(moneda100);
        panel_monedas.add(moneda500);
        panel_monedas.add(moneda1000);
        moneda100.setBounds(30,0, 70, 70);
        moneda500.setBounds(100,3, 70, 70);
        moneda1000.setBounds(65,40, 70, 70);
        confirmar_moneda = new JButton("Confirmar moneda");
        confirmar_moneda.setFocusable(false);
        confirmar_moneda.addActionListener(this);
        confirmar_moneda.setBounds(3, 120, 175,25);
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

        JLabel monedero = new JLabel();
        monedero.setIcon(new ImageIcon(monedero_img));
        // monedero.setBounds(10, 10, 128,128);
        panel_expendedor.contenedor_monedas.add(monedero);

        timer_monedaNull = new Timer(100, null);
        timer_monedaNull.addActionListener(this);
        timer_monedaNull.start();

        animacion_moneda = new Timer(100, null);
        animacion_moneda.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == moneda100){
            if(panel_expendedor.inventario.panel_inventario.billetera_comprador - 100 > 0){
                seleccion_moneda = 100;
                panel_expendedor.inventario.panel_inventario.billetera_comprador -= 100;
            }
        } else if(e.getSource() == moneda500){
            if(panel_expendedor.inventario.panel_inventario.billetera_comprador - 500 > 0){
                seleccion_moneda = 500;
                panel_expendedor.inventario.panel_inventario.billetera_comprador -= 500;
            }
        } else if(e.getSource() == moneda1000){
            if(panel_expendedor.inventario.panel_inventario.billetera_comprador - 1000 > 0){
                seleccion_moneda = 1000;
                panel_expendedor.inventario.panel_inventario.billetera_comprador -= 1000;
            }
        } else if(e.getSource() == confirmar_moneda){
            if(seleccion_moneda == 100){
                panel_expendedor.moneda = new Moneda100();
                moneda100.setEnabled(false);
                moneda500.setEnabled(false);
                moneda1000.setEnabled(false);

                pos_baseX = 30;
                pos_baseY = 0;
                animacion_moneda.start();
                repaint();
            } else if(seleccion_moneda == 500){
                panel_expendedor.moneda = new Moneda500();
                moneda100.setEnabled(false);
                moneda500.setEnabled(false);
                moneda1000.setEnabled(false);

                pos_baseX = 100;
                pos_baseY = 3;
                animacion_moneda.start();
                repaint();
            } else if(seleccion_moneda == 1000){
                panel_expendedor.moneda = new Moneda1000();
                moneda100.setEnabled(false);
                moneda500.setEnabled(false);
                moneda1000.setEnabled(false);

                pos_baseX = 65;
                pos_baseY = 40;
                animacion_moneda.start();
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
            if(seleccion_moneda == 100){

            }
        }
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics g2d = (Graphics2D) g;
        // DIBUJAR COSO MONEDAS
        // HACER APARECER LABELS CON IMAGEN DE LA MONEDA CORRESPONDIENTE
        g2d.drawImage(monedero_img,10,10, null);

        if(seleccion_moneda == 100){
            label_moneda100 = new JLabel(new ImageIcon(moneda100_img));
            label_moneda100.setBounds(pos_baseX,0,pos_baseY,70);
            panel_expendedor.contenedor_monedas.add(label_moneda100);
        } else if(seleccion_moneda == 500){
            label_moneda500 = new JLabel(new ImageIcon(moneda500_img));
            label_moneda500.setBounds(100,3,70,70);
            panel_expendedor.contenedor_monedas.add(label_moneda500);
        } else if(seleccion_moneda == 1000){
            label_moneda1000 = new JLabel(new ImageIcon(moneda1000_img));
            label_moneda1000.setBounds(30,0,70,70);
            panel_expendedor.contenedor_monedas.add(label_moneda1000);
        }


    }

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

    public void config_botones(JRadioButton radio_boton, Image ruta_imagen){
        radio_boton.setIcon(new ImageIcon(ruta_imagen));
        radio_boton.setOpaque(false);
        radio_boton.setFocusable(false);
        radio_boton.setForeground(Color.WHITE);
        radio_boton.setFont(fontRadioButton);
    }
}
