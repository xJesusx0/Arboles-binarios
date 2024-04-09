package main.arbolesbinarios;

import static main.Main.*;
import static main.Input.Input.*;
import static main.Input.Mensajes.*;

public class ArbolBinario {
    
    public static boolean existeArbol(){
        return raiz != null;
    }

    public static void crearArbol(){

        if(existeArbol()){
            mostrarError("El arbol ya ha sido creado");
            return;
        }

        raiz = new Nodo();
        raiz.dato = inputInt("Ingrese el dato del nodo raiz");
    }

    public static void insertar(int dato, Nodo nuevoNodo, Nodo auxiliar){

        if(!existeArbol()){
            mostrarError("El arbol no ha sido creado");
            return;
        }
        
        if(dato < auxiliar.dato){
            if(auxiliar.nodoIzquierdo == null){
                auxiliar.nodoIzquierdo = nuevoNodo;
                return;
            }
            auxiliar = auxiliar.nodoIzquierdo;
            insertar(dato, nuevoNodo, auxiliar);   
        }
        
        if(dato > auxiliar.dato){
            if(auxiliar.nodoDerecho == null){
                auxiliar.nodoDerecho = nuevoNodo;
                return;
            }

            auxiliar = auxiliar.nodoDerecho;
            insertar(dato, nuevoNodo, auxiliar); 
        }
    }

    public static void imprimirInOrder(Nodo nodo, int nivel) {

        if(nodo != null){
            
            imprimirInOrder(nodo.nodoDerecho, nivel + 1);

            System.out.println( nodo.dato);
            imprimirInOrder(nodo.nodoIzquierdo, nivel + 1);
        }
    }
}
