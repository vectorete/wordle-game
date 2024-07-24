/*
 * Clase WordleModel
 *  
 * Entornos de Usuario, Practica final
 * 
 */
package es.uv.eu.wordle.model;

/**
 * @author Victor Kravchuk Vorkevych
 * @author Guillem Parreño Martinez
 * @version 1.0
 */
public class WordleModel {
    private String palabra,prueba;
    private int tam,tam_min,num_int,pos,max_int,cant_jug,numint_aux;
    private int[] vector_result,intentos_jugadores, acert;
    private String[] jugadores;
    /**
    * Constructor del model de Wordle
    */
    public WordleModel()
    {
        //inicializamos los valores que necesitan un valor incial
        intentos_jugadores = new int[10];
        jugadores = new String[10];
        num_int = 0;
        prueba = "";
        cant_jug = 0;
        tam_min = 4;
        pos = 0;
        max_int = 3;
    }
    
    /**
     * Funcion que comprueba si la palabra guardada en prueba es correcta
     * @return Devuelve un array con las posiciones correctas y equivocadas de la palabra
     */
    public int[] comprobarpalabra()
    {
        vector_result = new int[tam];
        int aux, resta2, resta, cont;
        char c_aux;
        palabra = palabra.toUpperCase();
        prueba = prueba.toUpperCase();
        num_int++;
        pos = 0;
        for(int i = 0; i < tam; i++){
            c_aux = prueba.charAt(i);
            if(c_aux == palabra.charAt(i))
                vector_result[i] = 2;
            else if(!palabra.contains(c_aux+""))
                vector_result[i] = 0;
            else if( 1 == nveces(prueba,c_aux) || nveces(palabra,c_aux) 
                >= nveces(prueba,c_aux ))
                vector_result[i] = 1;
            else if(nveces(palabra,c_aux) < nveces(prueba,c_aux )){
                vector_result[i] = 0;
                cont = 0;
                aux = -1;
                //Comprobamos cuantas veces se acierta la letra en la misma posicion en la palabra de prueba y en la otra plabra
                for(int j = 0; j < nveces(palabra,c_aux); j++){
                    aux = posiciondec(palabra,c_aux,aux+1);
                    if(prueba.charAt(aux) == palabra.charAt(aux))
                        cont++;
                }
                resta2 = nveces(prueba,c_aux)-cont;//veces que aparece la letra en la palabra de prueba sin acertar
                resta = nveces(palabra,c_aux)-cont;//veces que aparece la letra en la palabra sin acertar
                aux = -1;
                
                while(resta2>0 && resta>0){
                    aux = posiciondec(prueba,c_aux,aux+1);
                    if(!(prueba.charAt(aux) == palabra.charAt(aux))){
                        resta--;
                    }
                }
                if(aux == i)
                    vector_result[i] = 1;
            }    
        }
        for(int i = 0; i < tam; i++){
            //if(vector_result[i] == )
        }
        prueba = "";
        return vector_result;
    }
    /**
     * Funcion a la que le pasas un caracter y una palabra y busca la primera 
     * del caracter en la palabra
     * @param pal palabra a comprobar
     * @param comp caracter a comprobar
     * @param aux_pos posicion desde donde iniciar la busqueda
     * @return posicion donde se encuentra el caracter en la plabra
     */
    public int posiciondec(String pal,char comp,int aux_pos){
        int aux = -1, i = aux_pos;
        while(i < pal.length() && aux == -1){
            if(pal.charAt(i) == comp)
                aux = i;
            i++;
        }
        return aux;
    }
    /**
     * Funcion que cuenta la cantidad de veces que aparece un caracter en una
     * palabra
     * @param pal palabra a comprobar
     * @param comp caracter a comprobar
     * @return Cantidad de veces que aparece la letra
     */
    public int nveces(String pal, char comp)
    {
        int cont = 0;
        for(int i = 0; i < pal.length(); i++)
            if(comp == pal.charAt(i))
                cont++;
       
        return cont;
    }
    /**
     * Funcion que inserta un caracter correcto a la palabra de prueba
     * @param caracter caracter a insertar
     * @return si se ha podido insertar o no
     */
    public boolean insertarcaracter(String caracter)
    {
        caracter = caracter.toUpperCase();
        char aux = caracter.charAt(0);
        boolean bul = false;
        if('A' <= aux && aux <= 'Z' && pos < tam){
            prueba += aux;
            pos++;
            bul = true;
        }
        return bul;
    }
    /**
     * Funcion que intenta eliminar un caracter de la palabra prueba
     * @return Devuelve si se puede eliminar caracter
     */
    public boolean eliminarcaracter(){
        boolean bul = false;
        if(pos > 0){
            prueba = prueba.substring(0, prueba.length()-1);
            pos--;
            bul = true;
        }
        return bul;
    }
    
    /**
     * Funcion que setea la palabra
     */
    public boolean setpalabra(String palabra){
        this.palabra = palabra;
        acert = new int[tam];
        return tam == palabra.length();
    }
    
    /**
     * Funcion que setea el tamanyo de letra
     */
    public void settam(int tam){
        this.tam = tam;
    }
    
    /**
     * Funcion que devuelve el tamanyo de la palabra
     * @return Devuelve el tamanyo de la palabra
     */
    public int gettam(){
        return tam;
    }
    
    /**
     * Funcion que setea el tamanyo minimo de letras
     */
    public void settammin(int min){
        this.tam_min = min;
    }
    
    /**
     * Funcion que devuelve el minimo de letras
     * @return minimo letras
     */
    public int gettammin(){
        return this.tam_min;
    }
    
    /**
     * Funcion que devuelve cuantos intentos llevamos
     * @return intentos realizados
     */
    public int getintentos(){
        return this.num_int;
    }
    
     /**
     * Funcion que devuelve la posicion en que nos situamos
     * @return posicion
     */
    public int getposicion(){
        return this.pos;
    }
    
    /**
     * Funcion que setea el maximo de intentos
     */
    public void setmaxint(int max){
        this.max_int = max;
    }
    
    /**
     * Funcion que devuelve maximo de intentos
     * @return maximo de intento
     */
    public int getmaxint(){
        return this.max_int;
    }
    
    /**
     * Funcion que anyade una participante al ranking en orden por numero de 
     * intentos
     * @param nom nombre del participante
     */
    public void anadirtoranking(String nom){
        int aux_n=0;
        if(cant_jug == 0){
            this.jugadores[0] = nom;
            this.intentos_jugadores[0] = this.numint_aux;
            cant_jug++;
        }
        else{
            while(intentos_jugadores[aux_n] < numint_aux && aux_n < cant_jug){
                aux_n++;
            }
            if(aux_n < 9){
                System.out.println(""+aux_n);
                for(int i = cant_jug; i >= aux_n; i--){
                    if(i < 9){
                        intentos_jugadores[i+1]=intentos_jugadores[i];
                        jugadores[i+1]=jugadores[i];
                    }                
                }
                cant_jug++;
                System.out.println(""+cant_jug);
                intentos_jugadores[aux_n] = numint_aux;
                jugadores[aux_n] = nom;
            }
        }  
    }
    
    /**
     * Funcion que devuelve un array con los intentos de cada jugador
     * @return devuelve array con intento de cada jugador
     */
    public int[] getintentosranking(){
        return this.intentos_jugadores;
    } 
    
    /**
     * Funcion que devuelve un array con los nombres de cada jugador
     * @return devuelve array con nombre de cada jugador
     */
    public String[] getnombresranking(){
        return this.jugadores;
    }
    
    /**
     * Funcion que devuelve la cantidad de jugadores
     * @return cantidad de jugadores
     */
    public int getnumparticipantes(){
        return this.cant_jug;
    }
    
    /**
     * Funcion que resetea el numero de intentos que ha usado el participante
     */
    public void resertint(){
        this.numint_aux = this.num_int;
        this.num_int = 0;
    }
    
    /**
     * Funcion que devuelve el numero de intentos
     * @return numero de intentos
     */
    public int getintaux(){
        return numint_aux;
    }
}
