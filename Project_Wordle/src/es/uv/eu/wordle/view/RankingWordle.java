/*
 * Clase RankingWordle
 *  
 * Entornos de Usuario, Practica final
 * 
 */
package es.uv.eu.wordle.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

/**
 * @author Victor Kravchuk Vorkevych
 * @author Guillem Parreño Martinez
 * @version 1.0
 */
public class RankingWordle extends JFrame{
    private JLabel auxlab, emptlab; // JLabel auxiliar y vacios
    private JPanel jp; // JPanel para poner ranking
    private ImageIcon icon, icon2; // Imagen para borde
    public RankingWordle(){
        // Titulo Ventana
        super("Ranking");
        // Layout del frame
        this.setLayout(new BorderLayout());
        // Creamos JPanel y seteamos Layout
        jp = new JPanel();
        jp.setLayout(new GridLayout(11, 3));
        // Fotos para usar como borde
        icon = new ImageIcon("imagensrc/borde3.png");
        icon2 = new ImageIcon("imagensrc/borde.png"); 
        // Anyadimos labels con jugadores y sus intentos al grid layout
        // Anyadimos primero los titulos posicion, jugador y intentos
        // Posicion
        auxlab = new JLabel("Posicion");
        auxlab.setHorizontalAlignment(SwingConstants.CENTER);
        auxlab.setFont(new Font("SANS_SERIF", 3, 24));
        auxlab.setBorder(BorderFactory.createMatteBorder(2, 4, 2, 2, icon));
        jp.add(auxlab);
        // Jugador
        auxlab = new JLabel("Jugador");
        auxlab.setHorizontalAlignment(SwingConstants.CENTER);
        auxlab.setFont(new Font("SANS_SERIF", 3, 20));
        auxlab.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, icon));
        jp.add(auxlab);
        // Intentos
        auxlab = new JLabel("Intentos");
        auxlab.setHorizontalAlignment(SwingConstants.CENTER);
        auxlab.setFont(new Font("SANS_SERIF", 3, 22));
        auxlab.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 4, icon));
        jp.add(auxlab);
        
        // Anyadimos borde al jpanel que anyadiremos al frame
        jp.setBorder(new EmptyBorder(10,20,4,10));
        this.add(jp, BorderLayout.CENTER);
        // Tamanyo del frame y hacemos visible
        this.setSize(600,300); // Tamanyo frame
        this.setVisible(false); // Hacemos visible frame
    }
    
    /**
     * Setea el Ranking
     * @param nom Nombre del desafiante
     * @param at su numero de intentos 
     * @param n cantidad de jugadores
     */
    public void setRanking(String[] nom, int[] at, int n){
        // Bucle que anyadira a todos los jugadores por posicion con intentos
        jp.removeAll(); // Elimina el resultado anterior
        auxlab = new JLabel("Posicion");
        auxlab.setHorizontalAlignment(SwingConstants.CENTER);
        auxlab.setFont(new Font("SANS_SERIF", 3, 24));
        auxlab.setBorder(BorderFactory.createMatteBorder(2, 4, 2, 2, icon));
        jp.add(auxlab);
        // Jugador
        auxlab = new JLabel("Jugador");
        auxlab.setHorizontalAlignment(SwingConstants.CENTER);
        auxlab.setFont(new Font("SANS_SERIF", 3, 20));
        auxlab.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, icon));
        jp.add(auxlab);
        // Intentos
        auxlab = new JLabel("Intentos");
        auxlab.setHorizontalAlignment(SwingConstants.CENTER);
        auxlab.setFont(new Font("SANS_SERIF", 3, 22));
        auxlab.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 4, icon));
        jp.add(auxlab);
        for (int i = 0; i < 10; i++){
            if (i < n){ //Anyadimos los jugadores disponibles
                // Anyadimos posicion jugador
                auxlab = new JLabel(Integer.toString(i+1));
                if (i == 0) // Cambiamos color si esta en el podio
                    auxlab.setForeground(new Color(234, 190, 63)); // Top 1
                else if (i == 1)
                    auxlab.setForeground(new Color(192, 192, 192)); // Top 2
                else if (i == 2)
                    auxlab.setForeground(new Color(205, 127, 50)); // Top 3
                if(i == n-1)
                    auxlab.setBorder(BorderFactory.createMatteBorder(0, 2, 2, 1, icon2));
                else
                    auxlab.setBorder(BorderFactory.createMatteBorder(0, 2, 0, 1, icon2));
                auxlab.setFont(new Font(Font.SERIF, Font.BOLD, 18));
                auxlab.setHorizontalAlignment(SwingConstants.CENTER);
                jp.add(auxlab);
                // Anyadimos nombre jugador
                auxlab = new JLabel(nom[i]);
                if(i == n-1)
                    auxlab.setBorder(BorderFactory.createMatteBorder(0, 1, 2, 1, icon2));
                else
                    auxlab.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 1, icon2));
                auxlab.setFont(new Font(Font.MONOSPACED, Font.BOLD, 14));
                auxlab.setHorizontalAlignment(SwingConstants.CENTER);
                jp.add(auxlab);
                // Anyadimos intentos jugador
                auxlab = new JLabel(Integer.toString(at[i]));
                if(i == n-1)
                    auxlab.setBorder(BorderFactory.createMatteBorder(0, 1, 2, 2, icon2));
                else
                    auxlab.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 2, icon2));
                auxlab.setFont(new Font(Font.SANS_SERIF, Font.ITALIC, 12));
                auxlab.setHorizontalAlignment(SwingConstants.CENTER);
                jp.add(auxlab);
            }
            else{ // Anyadimos jlabel vacios si no hay mas jugadores
               emptlab = new JLabel("");
               emptlab.setHorizontalAlignment(SwingConstants.CENTER);
               jp.add(emptlab);
               emptlab = new JLabel("");
               emptlab.setHorizontalAlignment(SwingConstants.CENTER);
               jp.add(emptlab);
               emptlab = new JLabel("");
               emptlab.setHorizontalAlignment(SwingConstants.CENTER);
               jp.add(emptlab);
            }
        }
    }
}
