/*
 * Clase Autor2
 *  
 * Entornos de Usuario, Practica final
 * 
 */
package es.uv.eu.wordle.view;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * @author Victor Kravchuk Vorkevych
 * @author Guillem Parreño Martinez
 * @version 1.0
 */
public class Autor2 extends JPanel{
    private BufferedImage imagen; // Almacenamos imagen del autor
    private String imagendest = ""; // Almacenamos direccion foto
    public Autor2(){
        // Con un tryncatch comprobamos si toma correctamente la foto
        try {
            imagendest = "imagensrc/autor2.jpg";
            imagen = ImageIO.read(new File(imagendest));
        }
        catch (IOException e) {
            System.out.println("Problemas leyendo imagen: " + this.imagendest);
            System.out.println("Motivo: " + e.getLocalizedMessage());
        }
        // Ponemos borde a la foto
        this.setBorder(new EmptyBorder(0,0,10,10));
    }
    // Funcion encargada de pintar la foto autor
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(imagen, 10, 10, this.getWidth()-20, this.getHeight()-20, this);
    }
}

