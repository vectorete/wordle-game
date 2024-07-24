/*
 * Clase MenuPanelDerecha
 *  
 * Entornos de Usuario, Practica final
 * 
 */
package es.uv.eu.wordle.view;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * @author Victor Kravchuk Vorkevych
 * @author Guillem Parreño Martinez
 * @version 1.0
 */
public class MenuPanelDerecha extends JPanel{
    JButton aut, conf; // Botones del panel derecho
    public MenuPanelDerecha(){
        // Layout del JPanel
        this.setLayout(new GridLayout(2,1,2,2));
        // Obtenemos un icono de las fotos para los botones
        Icon autfot = new ImageIcon("imagensrc/autor.png");
        Icon config = new ImageIcon("imagensrc/gear.png");
        // Creamos Botones y anyadimos 
        aut = new JButton(autfot);
        conf = new JButton(config);
        // Movemos los botones
        EmptyBorder b1 = new EmptyBorder(400,0,4,4);
        this.setBorder(b1);
        this.setOpaque(false); // Para que no oculte fondo
        // Anyadimos al panel
        this.add(aut);
        this.add(conf);
    }
    
    /**
     * Anyadimos listener a botones del menu
     * @param act listener 
     */
    public void numAddListener(ActionListener act){
        aut.setActionCommand("autfot");
        conf.setActionCommand("config");
        aut.addActionListener(act);
        conf.addActionListener(act);
    }
}
