/*
 * Clase WordleController
 *  
 * Entornos de Usuario, Practica final
 * 
 */
package es.uv.wordle.controller;

import es.uv.eu.wordle.model.WordleModel;
import es.uv.eu.wordle.view.AutorWordle;
import es.uv.eu.wordle.view.ConfWordle;
import es.uv.eu.wordle.view.Jugador1Wordle;
import es.uv.eu.wordle.view.Jugador2Wordle;
import es.uv.eu.wordle.view.MenuWordle;
import es.uv.eu.wordle.view.RankingWordle;
import es.uv.eu.wordle.view.ResultadoWordle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

/**
 * @author Victor Kravchuk Vorkevych
 * @author Guillem Parreño Martinez
 * @version 1.0
 */
public class WordleController {
    private WordleModel model;
    private MenuWordle menu;
    private RankingWordle ranking;
    private ConfWordle config;
    private Jugador1Wordle jug1;
    private Jugador2Wordle jug2;
    private AutorWordle autor;
    private ResultadoWordle resultado;
    /**
    * Constructor del model de Model
    */
    public WordleController(WordleModel model,MenuWordle menu)
    {
        this.autor = new AutorWordle();
        this.config = new ConfWordle(3,4);
        this.jug1 = new Jugador1Wordle(model.gettammin());
        this.resultado = new ResultadoWordle();
        this.menu = menu;
        this.model = model;
        this.ranking = new RankingWordle();
        this.jug2 = new Jugador2Wordle();
        
        ButtonControllerActionListener controler_Buttons = new ButtonControllerActionListener();
        KeyControllerActionListener key_controler = new KeyControllerActionListener();
        KeyController key = new KeyController();
        this.menu.addMyActionListener(controler_Buttons);
        config.addMyActionListener(controler_Buttons);
        jug1.addMyActionListener(controler_Buttons);
        resultado.addMyActionListener(controler_Buttons);
        jug2.addMyActionListener(key_controler);
        jug2.addKeyListener(key);
    }
    /**
     * Clase que maneja las teclas pulsadas
     */
    class KeyController extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent k){
            int cont = 0;
            String aux;
            if(k.getKeyCode() == 8)
                if(model.eliminarcaracter()){
                    
                }
            else if(k.getKeyCode() == 10)
                if(model.getposicion() == model.gettam() 
                        && model.getintentos()<model.getmaxint()){
                    cont = 0;
                    int[] result = model.comprobarpalabra();
                    for(int a: result){
                        if(a == 2)
                            cont++;
                    }
                    if(cont == model.gettam()){
                        jug2.dispose();
                        if(model.getintentos() == 1)
                            resultado.setresult(2);
                        else
                            resultado.setresult(1);
                        resultado.setVisible(true);
                    }
                    else if(model.getintentos() == model.getmaxint()+1){
                        jug2.dispose();
                        resultado.setresult(0);
                        resultado.setVisible(true);
                    }
                    resultado.repaint();
                }
            else{                        

                System.out.println(""+k.getKeyChar());
                aux = ""+k.getKeyChar();
                if(model.insertarcaracter(aux)){
                    jug2.setcaracter(model.getposicion(), model.getintentos(), aux);
                }
            }
        }
    }
    /**
     * Clase que maneja el teclado que aparece por pantalla en la ventana de 
     * jugador 2
     */
    class KeyControllerActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            String command = ae.getActionCommand();
            int cont = 0,aux;
            //En funcion del action command llamaremos a un metodo u otro
            switch (command) {
                case "ent":
                    if(model.getposicion() == model.gettam() 
                        && model.getintentos()<model.getmaxint()){
                        cont = 0;
                        int[] result = model.comprobarpalabra();
                        jug2.setresultado(result, model.getintentos()-1);
                        for(int a: result){
                            if(a == 2)
                                cont++;
                        }
                        if(cont == model.gettam()){
                            jug2.dispose();
                            if(model.getintentos() == 1)
                                resultado.setresult(2);
                            else
                                resultado.setresult(1);
                            resultado.setVisible(true);
                            model.resertint();
                        }
                        else if(model.getintentos() == model.getmaxint()){
                            jug2.dispose();
                            model.resertint();
                            resultado.setresult(0);
                            resultado.setVisible(true);
                        } 
                        
                    }
                    break;
                case "del":
                    if(model.eliminarcaracter()){
                        jug2.dessetcaracter(model.getposicion(),model.getintentos());
                    }
                    break;
                default:
                    aux = model.getposicion();
                    if(model.insertarcaracter(command)){
                        jug2.setcaracter(aux, model.getintentos(), command);
                    }
            }
        }
    }
    /**
     * Clase que maneja todos los botones del programa
     */
    class ButtonControllerActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            String command = ae.getActionCommand();
            //En funcion del action command llamaremos a un metodo u otro
            switch (command) {
                case "play":
                    jug1.setMinletras(model.gettammin());
                    jug1.setVisible(true);
                    menu.setVisible(false);
                    break;
                case "exit1":
                    System.out.println ("Saliendo del Programa");
                    System.exit(0);
                    break;
                case "autfot":
                    autor.setVisible(true);
                    break;
                case "config":
                    config.setVisible(true);
                    break;
                case "aceptar1":
                    model.setmaxint(config.getSlide1Value());
                    model.settammin(config.getSlide2Value());
                    config.dispose();
                    break;
                case "aceptar2":
                    model.settam(jug1.gettam());
                    if(model.setpalabra(jug1.getpalabra())){
                        jug1.dispose();
                        jug2.setcentralpanel(model.gettam(),model.getmaxint());
                        jug2.setVisible(true);
                    }
                    else
                        JOptionPane.showMessageDialog(null, "La cantidad de caracteres no coincide.");
                    break;
                case "aceptar3":
                    model.anadirtoranking(resultado.getnom());
                    ranking.setRanking(model.getnombresranking(), model.getintentosranking(), model.getnumparticipantes());
                    resultado.dispose();
                    menu.setVisible(true);
                    break;
                case "Ranking":
                    ranking.setVisible(true);
                    break;
            }
        }
    }
}