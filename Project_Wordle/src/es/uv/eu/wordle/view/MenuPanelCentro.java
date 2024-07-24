/*
 * Clase MenuPanelCentro
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
public class MenuPanelCentro extends JPanel{
    private JButton jug, sal; // Botones panel centro
    public MenuPanelCentro(){
        // Layout del JPanel
        this.setLayout(new GridLayout(1,2, 8, 8));
        // Iconos de las fotos
        Icon play = new ImageIcon("imagensrc/play.png");
        Icon exit = new ImageIcon("imagensrc/exit.png");
        // Creamos botones
        jug = new JButton(play);
        //jug.setBackground(Color.WHITE);
        sal = new JButton(exit);
        // Anyadimos los botones al panel
        this.add(jug);
        this.add(sal);
        // Movemos de posicion los botones
        EmptyBorder empty = new EmptyBorder(217, 355, 217, 290);
        this.setBorder(empty);
        this.setOpaque(false); // Para que no oculte fondo
    }
    
    /**
     * Anyadimos listener a botones del menu
     * @param act listener
     */
    public void numAddListener(ActionListener act){
        sal.setActionCommand("exit1");
        jug.setActionCommand("play");
        jug.addActionListener(act);
        sal.addActionListener(act);
    }
}
