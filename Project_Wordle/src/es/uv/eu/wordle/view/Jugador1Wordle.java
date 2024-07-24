/*
 * Clase Jugador 1 Wordle
 *  
 * Entornos de Usuario, Practica final
 * 
 */
package es.uv.eu.wordle.view;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * @author Victor Kravchuk Vorkevych
 * @author Guillem Parreño Martinez
 * @version 1.0
 */
public class Jugador1Wordle extends JFrame{
    private Jugador1PanelCentro centpan; // Panel centro
    private Jugador1PanelNorte nortpan; // Panel norte
    private JPanel jp; // Panel sur con but
    private JButton but; // Boton en panel sur
    private JMenuBar menu;
    private JMenu men;
    private JMenuItem rank;
    public Jugador1Wordle(int let){
        // Titulo Ventana
        super("Jugador 1");
        // Layout del frame
        this.setLayout(new BorderLayout());
        // Creamos los componentes del JFrame
        centpan = new Jugador1PanelCentro();
        nortpan = new Jugador1PanelNorte(let);
        jp = new JPanel(); // JPanel que contendra el boton de debajo
        but = new JButton("Aceptar"); // Boton que se encontrara debajo
        men = new JMenu("Opciones");
        rank = new JMenuItem("Ranking");
        menu = new JMenuBar();
        // Configuramos JMenu y anyadimos al panel
        men.add(rank);
        menu.add(men);
        this.setJMenuBar(menu);
        // Configuramos el panel que contendra el JButton
        jp.setLayout(new BorderLayout());
        jp.setBorder(new EmptyBorder(6,240, 6, 240));
        jp.add(but);
        // Anyadimos componentes al JFrame
        this.add(nortpan, BorderLayout.NORTH);
        this.add(centpan, BorderLayout.CENTER);
        this.add(jp, BorderLayout.SOUTH);
        // Tamanyo del frame y hacemos visible
        this.setSize(600,300); // Tamanyo frame
        this.setVisible(false); // Hacemos visible frame
    }
    
    /**
     * Cambia el minimo de letras del slide
     * @param let minimo de letras
     */
    public void setMinletras(int let){
        nortpan.SetMinLet(let);
    }
    
    /**
     * Anyadimos listeners a los botones
     * @param act listener
     */
    public void addMyActionListener(ActionListener act){
        but.setActionCommand("aceptar2");
        but.addActionListener(act);
        rank.addActionListener(act);
    }
    
    /**
     * Obtenemos palabra escrita
     * @return palabra escrita
     */
    public String getpalabra(){
        return centpan.getpalabra();
    }
    
    /**
     * Obtenemos numero de letras del slide
     * @return numero letras
     */
    public int gettam(){
        return nortpan.gettam();
    }
}
