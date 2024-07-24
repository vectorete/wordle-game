/*
 * Clase AutorWordle
 *  
 * Entornos de Usuario, Practica final
 * 
 */
package es.uv.eu.wordle.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

/**
 * @author Victor Kravchuk Vorkevych
 * @author Guillem Parreño Martinez
 * @version 1.0
 */
public class AutorWordle extends JFrame{
    private Autor1 at1; // Panel con foto autor1
    private Autor2 at2; // Panel con foto autor2
    private AutorPanelNorte nortpan;    // Panel con nombre de autores
    private JTextArea tarea; // TextArea con informacion
    private JPanel jp; // Panel donde esta´a el text area
    public AutorWordle(){
        // Titulo Ventana
        super("Autores");
        // Layout del frame
        this.setLayout(new BorderLayout());
        // Creamos los componentes del JFrame
        nortpan = new AutorPanelNorte();
        at1 = new Autor1();
        at2 = new Autor2();
        jp = new JPanel();
        jp.setLayout(new GridLayout(1,1, 8, 8));
        // Configuramos el textarea de abajo
        tarea = new JTextArea(4, 8);
        tarea.setText("  Este trabajo ha sido realizado por Victor "
                + "Kravchuk Vorkevych y Guillem Parrenyo Martinez, donde "
                + "hemos \n  realizado el popular juego conocido como 'Wordle', "
                + "en una aplicacion de java.");
        tarea.setEditable(false);
        // Configuramos el panel del textarea
        jp.setBorder(new EmptyBorder(0,4,4,4)); // Separacion en bordes
        jp.add(tarea); // Anyadimos textarea al panel
        // Anyadimos paneles al frame
        this.add(nortpan, BorderLayout.NORTH);
        this.add(at1, BorderLayout.WEST);
        at1.setPreferredSize(new Dimension(200, 300)); // Tamanyo del panel west
        this.add(at2, BorderLayout.EAST);
        at2.setPreferredSize(new Dimension(200, 300)); // Tamanyo del panel east
        this.add(jp, BorderLayout.SOUTH);
        // Tamanyo del frame y hacemos visible
        this.setSize(600,300); // Tamanyo frame
        this.setVisible(false); // Hacemos visible frame
    }
}
