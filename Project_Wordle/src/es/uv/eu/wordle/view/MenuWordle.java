/*
 * Clase MenuWordle
 *  
 * Entornos de Usuario, Practica final
 * 
 */
package es.uv.eu.wordle.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * @author Victor Kravchuk Vorkevych
 * @author Guillem Parreño Martinez
 * @version 1.0
 */
public class MenuWordle extends JFrame{
    private MenuPanelCentro centpan;
    private MenuPanelDerecha derpan;
    private JLabel lab;
    public MenuWordle(){
        // Titulo Ventana
        super("Menu Wordle");
        // Layout del frame
        this.setLayout(new FlowLayout());
        // Creamos un label donde pondremos el fondo e insertaremos paneles
        lab = new JLabel(new ImageIcon("imagensrc/fondo.jpg"));
        this.setContentPane(lab);
        lab.setLayout(new BorderLayout()); // Layout del label
        // Creamos y añadimos los JPanel al frame
        centpan = new MenuPanelCentro();
        derpan = new MenuPanelDerecha();
        derpan.setSize(400, 200);
        lab.add(centpan, BorderLayout.CENTER);
        lab.add(derpan, BorderLayout.EAST);
        // Hacemos que no se pueda cambiar tamanyo de ventana
        this.setResizable(false);
        // Hacemos visible la ventana
        this.setVisible(true);
        // Tamanyo ventana
        this.setSize(900, 540);
    }
    
    /**
     * Anyadimos listeners a los botones del menu
     * @param act listener
     */
    public void addMyActionListener(ActionListener act){
        centpan.numAddListener(act);
        derpan.numAddListener(act);
    }
}
