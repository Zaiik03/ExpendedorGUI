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
    private JButton inventario_boton;

    int seleccion_moneda;
    private Moneda moneda;

    private PanelExpendedor panel_expendedor;

    private Timer timer;

    Font fontRadioButton = new Font("Arial", Font.PLAIN, 14);

    Image moneda100_img;
    Image moneda500_img;
    Image moneda1000_img;
    Image moneda100_opaca;
    Image moneda500_opaca;
    Image moneda1000_opaca;
    MusicPlayer musica_moneda;

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

        moneda100 = new JRadioButton();
        moneda500 = new JRadioButton();
        moneda1000 = new JRadioButton();

        /* JPanel contenedor_monedas = new JPanel();
        this.add(contenedor_monedas, BorderLayout.EAST);

        JPanel panel_monedas = new JPanel(); */

        config_botones(moneda100, moneda100_img);
        config_botones(moneda500, moneda500_img);
        config_botones(moneda1000, moneda1000_img);

        confirmar_moneda = new JButton("Enviar");
        confirmar_moneda.setFocusable(false);
        confirmar_moneda.addActionListener(this);

        inventario_boton = new JButton("Inventario");
        inventario_boton.setFocusable(false);
        inventario_boton.addActionListener(this);





        moneda100.addActionListener(this);
        moneda500.addActionListener(this);
        moneda1000.addActionListener(this);
        musica_moneda = new MusicPlayer();

        listener_mouse(moneda100, 1);
        listener_mouse(moneda500, 2);
        listener_mouse(moneda1000, 3);

        /* contenedor_monedas.setOpaque(false);
        panel_monedas.setOpaque(false);
        panel_expendedor.setOpaque(false);


        contenedor_monedas.add(panel_monedas);
        panel_monedas.setLayout(new GridLayout(4,1,10,10));
        panel_monedas.add(moneda100);
        panel_monedas.add(moneda500);
        panel_monedas.add(moneda1000);
        panel_monedas.add(confirmar_moneda); */

//        JPanel panel_monedas = new JPanel();
//        panel_monedas.setLayout(null);
//        panel_monedas.setOpaque(true);
//        panel_monedas.setPreferredSize(new Dimension(20,20));
//        panel_monedas.setBorder(BorderFactory.createLineBorder(Color.GREEN, 10));
//        panel_expendedor.panel_botones.add(panel_monedas);
//        moneda100.setBounds(0,0, 50, 50);
//        moneda500.setBounds(20,20, 50, 50);
//        moneda1000.setBounds(30,30, 50, 50);

//        panel_expendedor.panel_botones.add(Box.createVerticalStrut(50));
//        panel_expendedor.panel_botones.add(moneda100);
//        panel_expendedor.panel_botones.add(moneda500);
//        panel_expendedor.panel_botones.add(moneda1000);
//        panel_expendedor.panel_botones.add(confirmar_moneda);
//        panel_expendedor.panel_botones.add(Box.createVerticalStrut(30));
//        panel_expendedor.panel_botones.add(inventario_boton);
        this.setBorder(BorderFactory.createLineBorder(Color.GREEN, 50));

        ButtonGroup grupo_monedas = new ButtonGroup();
        grupo_monedas.add(moneda100);
        grupo_monedas.add(moneda500);
        grupo_monedas.add(moneda1000);



        timer = new Timer(100, null);
        timer.addActionListener(this);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == moneda100){
            seleccion_moneda = 100;
        } else if(e.getSource() == moneda500){
            seleccion_moneda = 500;
        } else if(e.getSource() == moneda1000){
            seleccion_moneda = 1000;
        } else if(e.getSource() == confirmar_moneda){
            if(seleccion_moneda == 100){
                panel_expendedor.moneda = new Moneda100();
                moneda100.setEnabled(false);
                moneda500.setEnabled(false);
                moneda1000.setEnabled(false);
            } else if(seleccion_moneda == 500){
                panel_expendedor.moneda = new Moneda500();
                moneda100.setEnabled(false);
                moneda500.setEnabled(false);
                moneda1000.setEnabled(false);
            } else if(seleccion_moneda == 1000){
                panel_expendedor.moneda = new Moneda1000();
                moneda100.setEnabled(false);
                moneda500.setEnabled(false);
                moneda1000.setEnabled(false);
            }
        } else if(e.getSource() == timer){
            if(panel_expendedor.moneda == null){
                moneda100.setEnabled(true);
                moneda500.setEnabled(true);
                moneda1000.setEnabled(true);
            }
        } else if(e.getSource() == inventario_boton){
            new Inventario();
        }
    }

    public void paintComponent(Graphics g){

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
