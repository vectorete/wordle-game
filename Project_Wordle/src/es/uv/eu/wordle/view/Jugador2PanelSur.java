/*
 * Clase Jugador2PanelSur
 *  
 * Entornos de Usuario, Practica final
 * 
 */
package es.uv.eu.wordle.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * @author Victor Kravchuk Vorkevych
 * @author Guillem Parreño Martinez
 * @version 1.0
 */
public class Jugador2PanelSur extends JPanel{
    // Array con cada caracter del teclado
    private String[] keybrd = {"Q","W","E","R","T","Y","U","I","O","P","A",
                              "S","D","F","G","H","I","J","K","L","Z",
                              "X","C","V","B","N","M"};
    private JButton auxbut, delbut, entbut; //Boton auxiliar, borrado y enter
    private JButton[] buts; // Array de botones
    private JPanel fp1, fp2, fp3, fp3aux; // JPanel que conforman el teclado
    public Jugador2PanelSur(){
        // Cramos JPanels y ponemos su LayoutManager
        fp1 = new JPanel(new GridLayout(1,10,2,2));
        fp2 = new JPanel(new GridLayout(1,9,2,2));
        fp3aux = new JPanel(new GridLayout(1,7,2,2));
        fp3 = new JPanel();
        fp3.setLayout(new BoxLayout(fp3, BoxLayout.X_AXIS));
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        // Iconos del boton del y enter
        Icon enter = new ImageIcon("imagensrc/enter.png");
        Icon del = new ImageIcon("imagensrc/del.png");
        // Creamos array de botones y anyadimos todos los botones
	buts = new JButton[27];
        for(int i = 0; i < 27; i++){
            // Estilo del boton
            auxbut = new JButton(keybrd[i]); 
            auxbut.setBackground(Color.GRAY);
            auxbut.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));
            auxbut.setBorder(BorderFactory.createLineBorder(Color.GRAY));
            auxbut.setForeground(Color.WHITE);
            buts[i] = auxbut;
            if (i <= 9){ // Primera fila botones
                fp1.add(buts[i]);
            }
            else if(i <= 19){ // Segunda fila botones
                fp2.add(buts[i]);
            }
            else if(i <= 26){ // Tercera fila botones
                fp3aux.add(buts[i]);
            }  
        }
        // creamos botones de del y enter
        delbut = new JButton(enter);
        entbut = new JButton(del);
        delbut.setBackground(Color.GRAY);
        entbut.setBackground(Color.GRAY);
        // Pones empty border a los JPanel para alinear
        fp3aux.setBorder(new EmptyBorder(0, 2, 0, 2));
        fp3.setBorder(new EmptyBorder(0, 4, 1, 4));
        fp2.setBorder(new EmptyBorder(2, 24, 2, 24));
        fp1.setBorder(new EmptyBorder(2, 4, 0, 4));
        // Anyadimos del, botones y enter al panel tercera fila
        fp3.add(delbut);
        fp3.add(fp3aux);
        fp3.add(entbut);
        // Anyadimos los paneles
        this.add(fp1);
        this.add(fp2);
        this.add(fp3);
    }
    
    /**
     * Anyadimos listener a cada boton del JPanel
     * @param act listener 
     */
    public void numAddListener(ActionListener act){
        delbut.setActionCommand("ent");
        entbut.setActionCommand("del");
        delbut.addActionListener(act);
        entbut.addActionListener(act);
        for(JButton b: buts){
            b.addActionListener(act);
        }
    }
}
