/*
 * Clase Wordle
 *  
 * Entornos de Usuario, Practica final
 * 
 */
package es.uv.eu.wordle;

import es.uv.eu.wordle.model.WordleModel;
import es.uv.eu.wordle.view.*;
import es.uv.wordle.controller.WordleController;

/**
 * @author Victor Kravchuk Vorkevych
 * @author Guillem Parreño Martinez
 * @version 1.0
 */
public class Wordle {

    /**
     * Funcion principal del programa
     */
    public static void main(String[] args) {
        WordleModel model = new WordleModel();
        MenuWordle menu = new MenuWordle();
        WordleController controller = new WordleController(model,menu);
    }
    
}
