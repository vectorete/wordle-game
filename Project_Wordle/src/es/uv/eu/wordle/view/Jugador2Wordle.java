/*
 * Clase Jugador2Wordle
 *  
 * Entornos de Usuario, Practica final
 * 
 */
package es.uv.eu.wordle.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 * @author Victor Kravchuk Vorkevych
 * @author Guillem Parreño Martinez
 * @version 1.0
 */
public class Jugador2Wordle extends JFrame{
    private Jugador2PanelCentro centpan; // Panel centro
    private Jugador2PanelSur surpan; // Panel sur
    public Jugador2Wordle(){
        // Nombre de la ventana
        super("Jugador 2");
        // Creamos y seteamos Layouts a JPanel y frame
        this.setLayout(new BorderLayout());
        centpan = new Jugador2PanelCentro(4, 5);
        surpan = new Jugador2PanelSur();
        // Anyadimos paneles al frame
        this.add(centpan, BorderLayout.CENTER);
        this.add(surpan, BorderLayout.SOUTH);
        // Tamanyo del panel sur
        surpan.setPreferredSize(new Dimension(160,160));
        // Hacemos visible y damos tamanyo al frame
        this.setVisible(false);
        this.setSize(400, 533);
    }
    
    /**
     * Cambiamos panelcentral de partida anterior por nueva partida
     * @param let Cantidad de letras
     * @param at Cantidad de intentos
     */
    public void setcentralpanel(int let, int at){
        this.remove(centpan); 
        centpan = new Jugador2PanelCentro(let, at);
        this.add(centpan, BorderLayout.CENTER);
    }
    
    /**
     * Anyadimos listener a botones del teclado
     * @param act listener
     */
    public void addMyActionListener(ActionListener act){
        surpan.numAddListener(act);
    }
    
    /**
     * Comprobamos el intento cambiando los colores de las casillas
     * @param result array que indica el resultado de cada letras
     * @param num_int el numero de intento en el que estamos
     */
    public void setresultado(int[] result,int num_int){
        centpan.setresult(result,num_int);
    }
    
    /**
     * Cuando el usuario introduce una letra se pone en el JLabel
     * @param pos posicion en la que estamos
     * @param num_int intento en el que estamos
     * @param c caracter a introducir
     */
    public void setcaracter(int pos, int num_int, String c){
        centpan.setcaracter(pos, num_int, c);
    }
    
    /**
     * Cuando el usuario introduce delete se elimina el ultimo caracter
     * @param pos posicion del caracter a eliminar
     * @param num_int intento en el que estamos
     */
    public void dessetcaracter(int pos, int num_int){
        centpan.eliminarcaracter(pos, num_int);
    }
}
