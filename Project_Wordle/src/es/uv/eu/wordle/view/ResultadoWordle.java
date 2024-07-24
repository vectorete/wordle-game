/*
 * Clase ResultadoWordle
 *  
 * Entornos de Usuario, Practica final
 * 
 */
package es.uv.eu.wordle.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 * @author Victor Kravchuk Vorkevych
 * @author Guillem Parreño Martinez
 * @version 1.0
 */
public class ResultadoWordle extends JFrame{
    private ResultadoPanelNorte nortpan; // Panel norte
    private JLabel lab; // Label para indicar que hacer
    private JTextField field; // TextField donde pondremos nombre
    private JPanel centpan, surpan; // Paneles para centro y sur
    private JButton but; // Boton para aceptar nombre
    public ResultadoWordle(){
        // Titulo Ventana
        super("Resultado");
        // Layout del frame
        this.setLayout(new BorderLayout());
        // Creamos los componentes del JFrame
        lab = new JLabel("Introduce tu nombre: ");
        field = new JTextField();
        centpan = new JPanel();
        surpan = new JPanel();
        but = new JButton("Aceptar");
        // Anyadimos de forma auxiliar el panel norte
        nortpan = new ResultadoPanelNorte(1);
        this.add(nortpan);
        // Modificamos el panel centro y anyadimos elementos
        centpan.setLayout(new BoxLayout(centpan, BoxLayout.X_AXIS));
        centpan.add(lab);
        centpan.add(field);
        centpan.setBorder(new EmptyBorder(10, 60, 10, 60));
        // Configuramos el panel del sur y anyadimos boton
        surpan.setLayout(new BorderLayout());
        surpan.setBorder(new EmptyBorder(6, 140, 6, 140));
        surpan.add(but);
        // Anyadimos los JPanel al frame
        this.add(centpan, BorderLayout.CENTER);
        this.add(surpan, BorderLayout.SOUTH);
        // Hacemos que no se pueda cambiar tamanyo de ventana
        this.setResizable(false);
        // Hacemos visible la ventana
        this.setVisible(false);
        // Tamanyo ventana
        this.setSize(400, 420);  
    }
    
    /**
     * Cambiamos la imagen antigua por la nueva
     * @param result tipo de victoria o derrota
     */
    public void setresult(int result){
        this.remove(nortpan);
        nortpan = new ResultadoPanelNorte(result);
        nortpan.setPreferredSize(new Dimension(300, 300));
        this.add(nortpan, BorderLayout.NORTH);
    }
    
    /**
     * Anyadimos listener al boton
     * @param act listener
     */
    public void addMyActionListener(ActionListener act)
    {
        but.setActionCommand("aceptar3");
        but.addActionListener(act);
    }
    
    /**
     * Obtenemos nombre del jugador
     * @return nombre del jugador
     */
    public String getnom(){
        String aux = field.getText();
        field.setText("");
        return aux;
    }
}
