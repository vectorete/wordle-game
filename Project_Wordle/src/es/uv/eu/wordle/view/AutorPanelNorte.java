/*
 * Clase AutorPanelNorte
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

/**
 * @author Victor Kravchuk Vorkevych
 * @author Guillem Parreño Martinez
 * @version 1.0
 */
public class AutorPanelNorte extends JPanel{
    private JLabel l1, l2; // Label con nombre de los autores
    public AutorPanelNorte(){
        // Layout del panel
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        // Creamos los label
        l1 = new JLabel("Victor Kravchuk Vorkevych");
        l2 = new JLabel("Guillem Parrenyo Martinez");
        // Anyadimos al panel los label
        this.add(Box.createRigidArea(new Dimension(20,0))); // Separacion vacia
        this.add(l1);
        this.add(Box.createRigidArea(new Dimension(240,0))); // Separacion vacia
        this.add(l2);
    }
}
