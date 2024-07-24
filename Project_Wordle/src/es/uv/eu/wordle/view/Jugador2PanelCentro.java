/*
 * Clase Jugador2PanelCentro
 *  
 * Entornos de Usuario, Practica final
 * 
 */
package es.uv.eu.wordle.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

/**
 * @author Victor Kravchuk Vorkevych
 * @author Guillem Parreño Martinez
 * @version 1.0
 */
public class Jugador2PanelCentro extends JPanel{
    private JLabel[] arrlab; // Array de JLabel que conforman los intentoss
    private JLabel auxlab; // JLabel auxiliar
    private int[] resultado; // Array con posiciones acertadas
    private int tam; // Cantidad de letras
    private Color[] colores = {new Color(117,117,117),new Color(228,168,29)
                               ,new Color(67,160,71)}; // Color acierto o no
    public Jugador2PanelCentro(int let, int at){
        this.tam = let; // Guardamos el numero de letras
        this.setLayout(new GridLayout(10, let, 3, 3)); // Layout del JPanel
        arrlab = new JLabel[10*let]; // Creamos el array en funcion de letras
        // Bucle que crea las casillas de intentos
        for(int i = 0; i < 10*let; i++)
        {
            if(i < let*at){
                // Estilo del JLabel
                auxlab = new JLabel("");
                auxlab.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
                auxlab.setHorizontalAlignment(SwingConstants.CENTER);
                auxlab.setVerticalAlignment(SwingConstants.CENTER);
                auxlab.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
                auxlab.setBackground(Color.WHITE);
                auxlab.setOpaque(true);
                arrlab[i] = auxlab; // Anyadimos JLabel al array
                this.add(arrlab[i]); // y anyadimos  al panel
            }
            else{ // Si no hay mas intentos serqan JLabel vacios
                arrlab[i] = new JLabel("");
                this.add(arrlab[i]);
            }
        }
        // Ponemos un borde que cambiara en funcion del numero de letras
        this.setBorder(new EmptyBorder(6, 30 + 30/2*(10-let), 4, 30 + 30/2*(10-let)));
    }
    
    /**
     * Comprobamos el intento cambiando los colores de las casillas
     * @param result array que indica el resultado de cada letras
     * @param num_int el numero de intento en el que estamos
     */
    public void setresult(int[] result,int num_int){
        this.resultado = result;
        for(int i = 0; i < tam; i++){
            if(result[i] == 0)
                arrlab[i+num_int*tam].setBackground(colores[0]);
            else if(result[i] == 1)
                arrlab[i+num_int*tam].setBackground(colores[1]);
            else
                arrlab[i+num_int*tam].setBackground(colores[2]);
        }
        
    }
    
    /**
     * Cuando el usuario introduce una letra se pone en el JLabel
     * @param pos posicion en la que estamos
     * @param num_int intento en el que estamos
     * @param c caracter a introducir
     */
    public void setcaracter(int pos, int num_int, String c){
        arrlab[pos+num_int*tam].setText(c);
    }
    
    /**
     * Cuando el usuario introduce delete se elimina el ultimo caracter
     * @param pos posicion del caracter a eliminar
     * @param num_int intento en el que estamos
     */
    public void eliminarcaracter(int pos, int num_int){
        arrlab[pos+num_int*tam].setText("");
    }
}
