package Vistas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Panel_Inventario extends JPanel implements ActionListener {
    // ------------- Botones ---------------
    private JButton consumir_cocacola;
    private JButton consumir_sprite;
    private JButton consumir_fanta;
    private JButton consumir_snickers;
    private JButton consumir_super8;

    // ----------- Imagenes ---------------
    private Image coca;
    private Image sprite;
    private Image fanta;
    private Image snickers;
    private Image super8;

    // ----------- Int ---------------
    public int inv_cocacola = 0;
    public int inv_sprite = 0;
    public int inv_fanta = 0;
    public int inv_snickers = 0;
    public int inv_super8 = 0;

    // ---------- JLabel -----------------
    JLabel dinero;
    JLabel label_fanta;
    JLabel label_cocacola;
    JLabel label_sprite;
    JLabel label_snickers;
    JLabel label_super8;

    JLabel cuanta_fanta;
    JLabel cuanta_cocacola;
    JLabel cuanta_sprite;
    JLabel cuanta_snickers;
    JLabel cuanta_super8;

    MusicPlayer musica_comer;

    public Panel_Inventario(int billetera){
        this.setLayout(null);


        // ---------- Instancia Imagenes --------------------
        fanta = new ImageIcon("./src/main/java/Vistas/Fotos/fanta.png").getImage();
        coca = new ImageIcon("./src/main/java/Vistas/Fotos/cocacola.png").getImage();
        snickers = new ImageIcon("./src/main/java/Vistas/Fotos/snickers.png").getImage();
        sprite =  new ImageIcon("./src/main/java/Vistas/Fotos/sprite.png").getImage();
        super8 =  new ImageIcon("./src/main/java/Vistas/Fotos/super8.png").getImage();
        musica_comer = new MusicPlayer();

        // ----------- Escalar -----------------------

        fanta = escalarImagen(fanta, 60, 45);
        coca = escalarImagen(coca, 60, 45);
        sprite = escalarImagen(sprite, 60, 45);
        snickers = escalarImagen(snickers, 60, 45);
        super8 = escalarImagen(super8, 60, 45);


        // ----------- Label Imagenes ---------------
        dinero = new JLabel();
        label_fanta = new JLabel(new ImageIcon(fanta));
        label_cocacola = new JLabel(new ImageIcon(coca));
        label_sprite = new JLabel(new ImageIcon(sprite));
        label_snickers = new JLabel(new ImageIcon(snickers));
        label_super8 = new JLabel(new ImageIcon(super8));

        // -------------- Font ------------------------
        Font fuente = new Font("monospace", Font.PLAIN, 18);
        Font fuente_boton = new Font("monospace", Font.PLAIN, 10);

        // --------- Personalizar Label -----------------------
        dinero.setOpaque(true);
        dinero.setFont(fuente);
        dinero.setBackground(new Color(0x0000));
        dinero.setForeground(Color.CYAN);
        dinero.setPreferredSize(new Dimension(200, 60));
        cambiarText(dinero, "Dinero actual: " + billetera);


        // ------------------ Add Label in Panel -------------------
        this.add(dinero);
        this.add(label_fanta);
        this.add(label_cocacola);
        this.add(label_sprite);
        this.add(label_snickers);
        this.add(label_super8);

        dinero.setBounds(10, 10, 280, 45);
        label_fanta.setBounds(10, 60, 60, 45);
        label_cocacola.setBounds(10, 110, 60, 45);
        label_sprite.setBounds(10, 160, 60, 45);
        label_snickers.setBounds(10, 210, 60, 45);
        label_super8.setBounds(10, 260, 60, 45);

        // ----------- Botones ----------------

        consumir_fanta = new JButton("Consumir");
        consumir_cocacola = new JButton("Consumir");
        consumir_sprite = new JButton("Consumir");
        consumir_snickers = new JButton("Consumir");
        consumir_super8 = new JButton("Consumir");

        consumir_super8.setFont(fuente_boton);
        consumir_fanta.setFont(fuente_boton);
        consumir_cocacola.setFont(fuente_boton);
        consumir_sprite.setFont(fuente_boton);
        consumir_snickers.setFont(fuente_boton);

        // ----------- Add Button in Panel -------------
        this.add(consumir_fanta);
        this.add(consumir_cocacola);
        this.add(consumir_sprite);
        this.add(consumir_snickers);
        this.add(consumir_super8);

        consumir_fanta.setBounds(210, 60, 80, 40);
        consumir_cocacola.setBounds(210, 110, 80, 40);
        consumir_sprite.setBounds(210, 160, 80, 40);
        consumir_snickers.setBounds(210, 210, 80, 40);
        consumir_super8.setBounds(210, 260, 80, 40);

        // ---------- Label cuantos Productos ----------

        cuanta_fanta = new JLabel();
        cuanta_cocacola = new JLabel();
        cuanta_sprite = new JLabel();
        cuanta_snickers = new JLabel();
        cuanta_super8 = new JLabel();

        editorLabel(cuanta_fanta, fuente_boton);
        editorLabel(cuanta_cocacola, fuente_boton);
        editorLabel(cuanta_sprite, fuente_boton);
        editorLabel(cuanta_snickers, fuente_boton);
        editorLabel(cuanta_super8, fuente_boton);

        // ----------- Add Label Productos in Panel ----------

        this.add(cuanta_fanta);
        this.add(cuanta_cocacola);
        this.add(cuanta_sprite);
        this.add(cuanta_snickers);
        this.add(cuanta_super8);

        cuanta_fanta.setBounds(80, 60, 120, 40);
        cuanta_cocacola.setBounds(80, 110, 120, 40);
        cuanta_sprite.setBounds(80, 160, 120, 40);
        cuanta_snickers.setBounds(80, 210, 120, 40);
        cuanta_super8.setBounds(80, 260, 120, 40);


        // ---------- actionListener -------------------
        consumir_fanta.addActionListener(this);
        consumir_cocacola.addActionListener(this);
        consumir_sprite.addActionListener(this);
        consumir_snickers.addActionListener(this);
        consumir_super8.addActionListener(this);

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // ------------- Manejo de eventos -------------------

        if(e.getSource() == consumir_fanta){
            if(inv_fanta != 0){
                musica_comer.play("./src/main/java/Vistas/Sonidos/sonido_comer.wav");
                inv_fanta--;
                cambiarText(cuanta_fanta, "Cantidad: " + inv_fanta);
            }
        } else if(e.getSource() == consumir_cocacola){
            if(inv_cocacola != 0){
                musica_comer.play("./src/main/java/Vistas/Sonidos/sonido_comer.wav");
                inv_cocacola--;
                cambiarText(cuanta_cocacola, "Cantidad: " + inv_cocacola);
            }
        } else if(e.getSource() == consumir_sprite) {
            if(inv_sprite != 0){
                musica_comer.play("./src/main/java/Vistas/Sonidos/sonido_comer.wav");
                inv_sprite--;
                cambiarText(cuanta_sprite, "Cantidad: " + inv_sprite);
            }
        } else if(e.getSource() == consumir_snickers){
            if(inv_snickers != 0){
                musica_comer.play("./src/main/java/Vistas/Sonidos/sonido_comer.wav");
                inv_snickers--;
                cambiarText(cuanta_snickers, "Cantidad: " + inv_snickers);
            }
        } else if(e.getSource() == consumir_super8){
            if(inv_super8 != 0){
                musica_comer.play("./src/main/java/Vistas/Sonidos/sonido_comer.wav");
                inv_super8--;
                cambiarText(cuanta_super8, "Cantidad: " + inv_super8);
            }
        }
        repaint();
    }

    public Image escalarImagen(Image imagen, int ancho, int alto){
        return imagen.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
    }

    public void cambiarText(JLabel label, String texto){
        label.setText(texto);
    }

    public void editorLabel(JLabel label, Font fuente){
        label.setOpaque(true);
        label.setFont(fuente);
        label.setForeground(Color.BLACK);
        label.setPreferredSize(new Dimension(200, 60));
    }

    public void modificarInventario(){
        cambiarText(cuanta_cocacola, "Cantidad: " + inv_cocacola);
        cambiarText(cuanta_sprite, "Cantidad: " + inv_sprite);
        cambiarText(cuanta_fanta, "Cantidad: " + inv_fanta);
        cambiarText(cuanta_snickers, "Cantidad: " + inv_snickers);
        cambiarText(cuanta_super8, "Cantidad: " + inv_super8);
    }
}
