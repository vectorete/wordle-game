/*
 * Clase ConfPanelCentro
 *  
 * Entornos de Usuario, Practica final
 * 
 */
package es.uv.eu.wordle.view;

import java.awt.Dimension;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.border.EmptyBorder;

/**
 * @author Victor Kravchuk Vorkevych
 * @author Guillem Parreño Martinez
 * @version 1.0
 */
public class ConfPanelCentro extends JPanel{
    private JSlider sld1, sld2; // Sliders
    public ConfPanelCentro(int attempt, int minletr){
        // Layout del panel
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        // Creamos los slider
        sld1 = new JSlider(JSlider.HORIZONTAL, 1, 10, attempt);
        sld2 = new JSlider(JSlider.HORIZONTAL, 3, 6, minletr);
        // Configuramos los slider
        // Slider1
        sld1.setMajorTickSpacing(1);
        sld1.setPaintTicks(true);
        sld1.setPaintLabels(true);
        // Slider2
        sld2.setMajorTickSpacing(1);
        sld2.setPaintTicks(true);
        sld2.setPaintLabels(true);
        // Anyadimos al panel los slider
        this.add(Box.createRigidArea(new Dimension(0,30))); // Separacion vacia
        this.add(sld1);
        this.add(Box.createRigidArea(new Dimension(0,5))); // Separacion vacia
        this.add(sld2);
        // Borde Panel
        this.setBorder(new EmptyBorder(0,0,0,10));
    }
    
    /**
     * Funcion que devuelve el valor del slide del numero de intentos
     * @return numero de intentos seleccionado
     */
    public int getSlide1Value(){
        return sld1.getValue();
    }
    
    /**
     * Funcion que devuelve el valor del slide del minimo de letras
     * @return numero de minimo de letrass
     */
    public int getSlide2Value(){
        return sld2.getValue();
    }
}
