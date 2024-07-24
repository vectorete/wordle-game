/*
 * Clase Jugador1PanelCentro
 *  
 * Entornos de Usuario, Practica final
 * 
 */
package es.uv.eu.wordle.view;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

/**
 * @author Victor Kravchuk Vorkevych
 * @author Guillem Parreño Martinez
 * @version 1.0
 */
public class Jugador1PanelCentro extends JPanel{
    private JLabel lab;
    private JPasswordField word;
    public Jugador1PanelCentro(){
        // Layout del panel
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        // Creamos los slider
        lab = new JLabel("Introducir Palabra: ");
        word = new JPasswordField(10);
        // Centramos los componentes
        lab.setAlignmentX(CENTER_ALIGNMENT);
        word.setAlignmentX(CENTER_ALIGNMENT);
        // Anyadimos al panel
        this.add(lab);
        this.add(word);
        // Borde del panel
        this.setBorder(new EmptyBorder(40, 140, 40, 200));
    }
    
    /**
     * Devuelve la palabra escrita
     * @return Palabra escrita
     */
    public String getpalabra(){
        String aux = String.valueOf(word.getPassword());
        word.setText("");
        return aux;
        
    }
}
