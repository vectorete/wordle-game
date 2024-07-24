/*
 * Clase ConfPanelIzquierdo
 *  
 * Entornos de Usuario, Practica final
 * 
 */
package es.uv.eu.wordle.view;

import java.awt.Dimension;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * @author Victor Kravchuk Vorkevych
 * @author Guillem Parreño Martinez
 * @version 1.0
 */
public class ConfPanelIzquierdo extends JPanel{
    private JLabel l1, l2; // JLabel informativo
    public ConfPanelIzquierdo(){
        // Layout del panel
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        // Creamos los label
        l1 = new JLabel("Numero de intentos: ");
        l2 = new JLabel("  Minimo de letras: ");
        // Anyadimos al panel los label
        this.add(Box.createRigidArea(new Dimension(0,30))); // Separacion vacia
        this.add(l1);
        this.add(Box.createRigidArea(new Dimension(0,30))); // Separacion vacia
        this.add(l2);
        // Borde Panel
        this.setBorder(new EmptyBorder(0,10,0,0));
    }
}
