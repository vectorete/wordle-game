/*
 * Clase ResultadoPanelNorte
 *  
 * Entornos de Usuario, Practica final
 * 
 */
package es.uv.eu.wordle.view;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * @author Victor Kravchuk Vorkevych
 * @author Guillem Parreño Martinez
 * @version 1.0
 */
public class ResultadoPanelNorte extends JPanel{
        private BufferedImage imagen; // Almacenamos imagen
    private String imagendest = ""; // Almacenamos direccion foto
    public ResultadoPanelNorte(int res){
        Random aleat = new Random();
        // Con un tryncatch comprobamos si toma correctamente la foto
        try {
            switch(res){
                case 0:
                    if (aleat.nextInt(1, 3)  == 1)
                        imagendest = "imagensrc/derrota1.jpg";
                    else
                        imagendest = "imagensrc/derrota2.jpg";
                    break;
                case 1:
                    if (aleat.nextInt(1, 3) == 1)
                        imagendest = "imagensrc/victoria1.jpg";
                    else
                        imagendest = "imagensrc/victoria2.jpg";
                    break;
                case 2:
                    if (aleat.nextInt(1, 3) == 1)
                        imagendest = "imagensrc/aplastante1.jpg";
                    else
                        imagendest = "imagensrc/aplastante2.jpg";
                    break;
            }
            imagen = ImageIO.read(new File(imagendest));
        }
        catch (IOException e) {
            System.out.println("Problemas leyendo imagen: " + this.imagendest);
            System.out.println("Motivo: " + e.getLocalizedMessage());
        }
        // Ponemos borde a la foto
        this.setBorder(new EmptyBorder(10,60,10,60));
    }
    // Funcion encargada de pintar la foto autor
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(imagen, 60, 10, this.getWidth()-120, this.getHeight()-20, this);
    }
}
