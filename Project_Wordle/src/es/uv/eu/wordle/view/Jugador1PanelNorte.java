/*
 * Clase Jugador1PanelNorte
 *  
 * Entornos de Usuario, Practica final
 * 
 */
package es.uv.eu.wordle.view;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.border.EmptyBorder;

/**
 * @author Victor Kravchuk Vorkevych
 * @author Guillem Parreño Martinez
 * @version 1.0
 */
public class Jugador1PanelNorte extends JPanel{
    JSlider slide;
    JLabel lab;
    public Jugador1PanelNorte(int let){
        // Layout del JPanel
        this.setLayout(new GridLayout(2,1));
        // Creamos los slider y label
        slide = new JSlider(JSlider.HORIZONTAL, let, let+3, let+2);
        lab = new JLabel("Numero de letras:\t\t\t\t\t\t\t\t");
        // Configuramos el slider
        slide.setMajorTickSpacing(1);
        slide.setPaintTicks(true);
        slide.setPaintLabels(true);
        // Anyadimos el label y slider al panel
        this.add(lab);
        this.add(slide);
        // Borde del panel
        this.setBorder(new EmptyBorder(6,20,6,20));
    }
    
    /**
     * Cambia valores del slider
     * @param let numero de letras minimo
     */
    public void SetMinLet(int let){
        slide.setMinimum(let);
        slide.setMaximum(let+3);
        slide.setValue(let+2);
    }
    
    /**
     * Devuelve el valor del slide, numero de letras
     * @return Valor slide, numero letras
     */
    public int gettam(){
        return slide.getValue();
    }
}
