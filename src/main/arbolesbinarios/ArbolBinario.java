package main.arbolesbinarios;

import static main.Main.*;
import static main.metodos.Mensajes.*;
import static main.Input.Input.*;
import static main.metodos.Metodos.*;
import static main.Input.Estilos.*;

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
        mostrarAviso("Estas configurando el nodo raiz");
        raiz.nombre = input("Ingrese el nombre");
        raiz.saldo = inputInt("Ingrese el saldo");
    }

    public static void insertarOrdenadoPorSaldo(String nombre,int dato, Nodo nuevoNodo, Nodo auxiliar){

        if(!existeArbol()){
            mostrarError("El arbol no ha sido creado");
            return;
        }
        
        if(dato < auxiliar.saldo){
            if(auxiliar.nodoIzquierdo == null){
                auxiliar.nodoIzquierdo = nuevoNodo;
                return;
            }
            auxiliar = auxiliar.nodoIzquierdo;
            insertarOrdenadoPorSaldo(nombre,dato, nuevoNodo, auxiliar);   
        }
        
        if(dato > auxiliar.saldo){
            if(auxiliar.nodoDerecho == null){
                auxiliar.nodoDerecho = nuevoNodo;
                return;
            }

            auxiliar = auxiliar.nodoDerecho;
            insertarOrdenadoPorSaldo(nombre,dato, nuevoNodo, auxiliar); 
        }
    }

    public static void insertarOrdenadoPorNombres(String nombre,int dato, Nodo nuevoNodo, Nodo auxiliar){

        if(!existeArbol()){
            mostrarError("El arbol no ha sido creado");
            return;
        }
        
        if(esMenor(nombre, auxiliar.nombre)){
            if(auxiliar.nodoIzquierdo == null){
                auxiliar.nodoIzquierdo = nuevoNodo;
                return;
            }
            auxiliar = auxiliar.nodoIzquierdo;
            insertarOrdenadoPorNombres(nombre,dato, nuevoNodo, auxiliar);   
        }
        
        if(esMayor(nombre, auxiliar.nombre)){
            if(auxiliar.nodoDerecho == null){
                auxiliar.nodoDerecho = nuevoNodo;
                return;
            }

            auxiliar = auxiliar.nodoDerecho;
            insertarOrdenadoPorNombres(nombre,dato, nuevoNodo, auxiliar); 
        }
    }

    public static void imprimirSaldosInOrder(Nodo nodo, int nivel) {

        if(!existeArbol()){
            mostrarError("El arbol no ha sido creado");
            return;
        }

        if(nodo != null){
            for (int i = 0; i < nivel; i++) {
                System.out.print(" ");
            }
            System.out.print(blue("└── "));
            System.out.println(nodo.saldo);
            imprimirSaldosInOrder(nodo.nodoDerecho, nivel + 1);
            
            
            imprimirSaldosInOrder(nodo.nodoIzquierdo, nivel + 1);
        }
    }

    public static void imprimirNombresInOrder(Nodo nodo, int nivel,boolean esIzquierdo) {

        if(!existeArbol()){
            mostrarError("El arbol no ha sido creado");
            return;
        }

        
        if(nodo != null){
            
            for (int i = 0; i < nivel; i++) {
                System.out.print(cyan("-"));
            }
            

            if(nodo == raiz){
                System.out.println(blue("└┬─ ") + nodo.nombre + yellow(" (Raiz)"));
            }else if (esIzquierdo) {
                System.out.print(blue("└── "));
                System.out.println(nodo.nombre + yellow(" (Izq)"));
            } else {
                System.out.print(blue("└── "));
                System.out.println(nodo.nombre + yellow(" (Der)"));
            }


            imprimirNombresInOrder(nodo.nodoDerecho, nivel + 1,false);  
            
            imprimirNombresInOrder(nodo.nodoIzquierdo, nivel + 1,true);
        }
    }
}
