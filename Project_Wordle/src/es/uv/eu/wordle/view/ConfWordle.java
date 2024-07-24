/*
 * Clase ConfWordle
 *  
 * Entornos de Usuario, Practica final
 * 
 */
package es.uv.eu.wordle.view;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * @author Victor Kravchuk Vorkevych
 * @author Guillem Parreño Martinez
 * @version 1.0
 */
public class ConfWordle extends JFrame{
    private ConfPanelCentro centrpan;
    private ConfPanelIzquierdo izqpan;
    private JPanel jp;
    private JButton but;
    public ConfWordle(int at, int lmin){
        // Titulo Ventana
        super("Configuracion");
        // Layout del frame
        this.setLayout(new BorderLayout());
        // Creamos los componentes del JFrame
        centrpan = new ConfPanelCentro(at, lmin);
        izqpan = new ConfPanelIzquierdo();
        jp = new JPanel();
        but = new JButton("Aceptar");
        // Configuramos el panel del boton
        jp.setLayout(new BorderLayout());
        jp.setBorder(new EmptyBorder(6,240, 6, 240));
        jp.add(but);
        // Anyadimos paneles al frame
        this.add(izqpan, BorderLayout.WEST);
        this.add(centrpan, BorderLayout.CENTER);
        this.add(jp, BorderLayout.SOUTH);
        // Hacemos que no se pueda cambiar tamanyo de ventana
        this.setResizable(false);
        // Tamanyo del frame y hacemos visible
        this.setSize(600,200); // Tamanyo frame
        this.setVisible(false); // Hacemos visible frame
    }
    
    /**
     * Anyadimos listener al boton de aceptar
     * @param act listener
     */
    public void addMyActionListener(ActionListener act)
    {
        but.setActionCommand("aceptar1");
        but.addActionListener(act);
    }
    
    /**
     * Funcion que devuelve el valor del slide del numero de intentos
     * @return numero de intentos seleccionado
     */
    public int getSlide1Value(){
        return this.centrpan.getSlide1Value();
    }
    
    /**
     * Funcion que devuelve el valor del slide del minimo de letras
     * @return numero de minimo de letrass
     */
    public int getSlide2Value(){
        return this.centrpan.getSlide2Value();
    }
}
