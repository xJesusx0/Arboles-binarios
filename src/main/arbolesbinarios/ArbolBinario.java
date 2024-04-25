package main.arbolesbinarios;

import static main.Main.*;
import static main.metodos.Mensajes.*;
import static main.Input.Input.*;
import static main.metodos.Metodos.*;
import static main.Input.Estilos.*;
import static main.arbolesbinarios.Nodo.*;

public class ArbolBinario {

    public static boolean existeArbol() {
        return raiz != null;
    }

    public static void crearArbol() {

        if (existeArbol()) {
            mostrarError("El arbol ya ha sido creado");
            return;
        }

        raiz = new Nodo();
        mostrarAviso("Estas configurando el nodo raiz");
        raiz.nombre = input("Ingrese el nombre");
        raiz.saldo = inputInt("Ingrese el saldo");
        raiz.grado = 0;
    }

    public static void insertarOrdenadoPorSaldo(String nombre, int dato, Nodo nuevoNodo, Nodo auxiliar) {

        if (!existeArbol()) {
            mostrarError("El arbol no ha sido creado");
            return;
        }

        if (dato < auxiliar.saldo) {
            if (auxiliar.nodoIzquierdo == null) {
                auxiliar.nodoIzquierdo = nuevoNodo;
                return;
            }
            auxiliar = auxiliar.nodoIzquierdo;
            insertarOrdenadoPorSaldo(nombre, dato, nuevoNodo, auxiliar);
        }

        if (dato > auxiliar.saldo) {
            if (auxiliar.nodoDerecho == null) {
                auxiliar.nodoDerecho = nuevoNodo;
                return;
            }

            auxiliar = auxiliar.nodoDerecho;
            insertarOrdenadoPorSaldo(nombre, dato, nuevoNodo, auxiliar);
        }
    }

    public static void insertarOrdenadoPorNombres(String nombre, int dato, Nodo nuevoNodo, Nodo auxiliar) {

        if (!existeArbol()) {
            mostrarError("El arbol no ha sido creado");
            return;
        }
        
        if (esMenor(nombre, auxiliar.nombre)) {
            if (auxiliar.nodoIzquierdo == null) {
                auxiliar.nodoIzquierdo = nuevoNodo;
                auxiliar.grado++;
                return;
            }
            auxiliar = auxiliar.nodoIzquierdo;
            insertarOrdenadoPorNombres(nombre, dato, nuevoNodo, auxiliar);
        }

        if (esMayor(nombre, auxiliar.nombre)) {
            if (auxiliar.nodoDerecho == null) {
                auxiliar.nodoDerecho = nuevoNodo;
                auxiliar.grado++;
                return;
            }

            auxiliar = auxiliar.nodoDerecho;
            insertarOrdenadoPorNombres(nombre, dato, nuevoNodo, auxiliar);
        }
    }

    public static void imprimirSaldosArbol(Nodo nodo, int nivel) {

        if (!existeArbol()) {
            mostrarError("El arbol no ha sido creado");
            return;
        }

        if (nodo == null) {
            return;
        }

        for (int i = 0; i < nivel; i++) {
            System.out.print(" ");
        }
        System.out.print(blue("└── "));
        System.out.println(nodo.saldo);

        imprimirSaldosArbol(nodo.nodoDerecho, nivel + 1);

        imprimirSaldosArbol(nodo.nodoIzquierdo, nivel + 1);

    }

    public static void imprimirNombresArbol(Nodo nodo, int nivel, boolean esIzquierdo) {

        if (!existeArbol()) {
            mostrarError("El arbol no ha sido creado");
            return;
        }

        if (nodo == null) {
            return;
        }

        for (int i = 0; i < nivel; i++) {
            System.out.print(cyan("-"));
        }

        if (nodo == raiz) {
            System.out.println(blue("└┬─ ") + nodo.nombre + yellow(" (Raiz)"));

        } else if (esIzquierdo) {
            System.out.print(blue("└── "));
            System.out.println(nodo.nombre + yellow(" (Izq)"));

        } else {
            System.out.print(blue("└── "));
            System.out.println(nodo.nombre + yellow(" (Der)"));
        }

        imprimirNombresArbol(nodo.nodoDerecho, nivel + 1, false);

        imprimirNombresArbol(nodo.nodoIzquierdo, nivel + 1, true);

    }
    
    public static void imprimirNombresPreOrden(Nodo nodo){
        if (!existeArbol()) {
            mostrarError("El arbol no ha sido creado");
            return;
        }

        if(nodo == null){
            return;
        }

        imprimirNodo(nodo);

        imprimirNombresPreOrden(nodo.nodoIzquierdo);
        imprimirNombresPreOrden(nodo.nodoDerecho);
    }

    public static void imprimirNombresInOrden(Nodo nodo){
        if (!existeArbol()) {
            mostrarError("El arbol no ha sido creado");
            return;
        }

        if(nodo == null){
            return;
        }

        imprimirNombresInOrden(nodo.nodoIzquierdo);

        imprimirNodo(nodo);

        imprimirNombresInOrden(nodo.nodoDerecho);
    }

    public static void imprimirNombresPosOrden(Nodo nodo){
        if (!existeArbol()) {
            mostrarError("El arbol no ha sido creado");
            return;
        }

        if(nodo == null){
            return;
        }

        imprimirNombresPosOrden(nodo.nodoIzquierdo);
        
        imprimirNombresPosOrden(nodo.nodoDerecho);

        imprimirNodo(nodo);
    }

    public static void imprimirNodosHoja(Nodo nodo,int nivel) {
        if (!existeArbol()) {
            mostrarError("El arbol no ha sido creado");
            return;
        }

        if (nodo == null) {
            return;
        }


        if(nodo.nodoIzquierdo == null && nodo.nodoDerecho == null){
            for(int i = 0 ; i < nivel ; i++){
                System.out.print(green("-"));
            }
            System.out.println(nodo.nombre);
        }

        imprimirNodosHoja(nodo.nodoIzquierdo,nivel+1);
        
        imprimirNodosHoja(nodo.nodoDerecho,nivel+1);

    }

    public static int confirmacion = 0;

    public static void eliminarNodosHoja(Nodo padre,Nodo nodo) {
        
        if (nodo == null) {
            return;
        }


        if(nodo.nodoIzquierdo == null && nodo.nodoDerecho == null){

            if(nodo == raiz){
                mostrarAviso("Esta seguro que desea eliminar el nodo raiz?");
                confirmacion = inputInt("(1 = si / cualquier otro numero = no)");

                if(confirmacion != 1){
                    return;
                }
                
                raiz = null;
                return;
            }

            if (padre.nodoIzquierdo == nodo) {
                padre.grado--;
                padre.nodoIzquierdo = null;
                

            } else if (padre.nodoDerecho == nodo) {
                padre.grado--;
                padre.nodoDerecho = null;

            }
            
        }

        eliminarNodosHoja(nodo, nodo.nodoIzquierdo);
        eliminarNodosHoja(nodo, nodo.nodoDerecho);

    }

    public static void cantidadNodosIzquierdaYDerecha(Nodo nodo, int contadores[]) {
        if (nodo == null) {
            return;
        }
        
        if(esMayor(nodo.nombre, raiz.nombre)){
            contadores[1]++;

        }
        if(esMenor(nodo.nombre, raiz.nombre)){
            contadores[0]++;
        }
        
        cantidadNodosIzquierdaYDerecha(nodo.nodoIzquierdo, contadores);
        
        cantidadNodosIzquierdaYDerecha(nodo.nodoDerecho, contadores);
        
    }

    public static void cantidadNodos(Nodo nodo,int contador[]){

        if (!existeArbol()) {
            mostrarError("El arbol no ha sido creado");
            return;
        }

        if(nodo == null){
            return;
        }
        
        contador[0]++;
            
        cantidadNodos(nodo.nodoIzquierdo,contador);
    
        cantidadNodos(nodo.nodoDerecho,contador);
        
    }

    public static void buscarNombre(String nombre,Nodo nodo){
        if (!existeArbol()) {
            mostrarError("El arbol no ha sido creado");
            return;
        }

        if (nodo == null) {
            return;
        }

        if(esIgual(nombre, nodo.nombre)){
            mostrarEstado("Nombre encontrado");
            imprimirNodo(nodo);

            return;
        }

        buscarNombre(nombre, nodo.nodoIzquierdo);
        
        buscarNombre(nombre, nodo.nodoDerecho);
    }

    public static void buscarSaldo(int saldo,Nodo nodo){
        if (!existeArbol()) {
            mostrarError("El arbol no ha sido creado");
            return;
        }

        if (nodo == null) {
            return;
        }

        if(saldo == nodo.saldo){
            mostrarEstado("Saldo encontrado");
            imprimirNodo(nodo);
        }

        buscarSaldo(saldo, nodo.nodoIzquierdo);
        
        buscarSaldo(saldo, nodo.nodoDerecho);
    }

    public static void buscarGrado(int grado,Nodo nodo){
        if (!existeArbol()) {
            mostrarError("El arbol no ha sido creado");
            return;
        }

        if (nodo == null) {
            return;
        }

        if(grado == nodo.grado){
            mostrarEstado("Grado encontrado");

            imprimirNodo(nodo);
        }

        buscarGrado(grado, nodo.nodoIzquierdo);
        
        buscarGrado(grado, nodo.nodoDerecho);
    }

    public static void actualizarNodo(Nodo nodo,String nombre ,int saldo){

        if (!existeArbol()) {
            mostrarError("El arbol no ha sido creado");
            return;
        }

        if(nodo == null){
            return;
        }

        if(esIgual(nodo.nombre, nombre)){
            mostrarEstado("Actualizando nodo");
            nodo.saldo = saldo;
            mostrarEstado("nodo actualizado");
            return;
        }

        actualizarNodo(nodo.nodoIzquierdo, nombre,saldo);
        actualizarNodo(nodo.nodoDerecho, nombre,saldo);
    }

    public static boolean esHoja(Nodo nodo){
        return nodo.nodoDerecho == null && nodo.nodoIzquierdo == null;
    }

    public static void eliminarNombre(String nombre, Nodo nodo, Nodo padre) {
        if (nodo == null) {
            return;
        }
    
        if (esIgual(nombre, nodo.nombre)) {

            if (esHoja(nodo)) {
                
                if (padre.nodoIzquierdo == nodo) {
                    padre.nodoIzquierdo = null;
                } 

                if(padre.nodoDerecho == nodo){
                    padre.nodoDerecho = null;
                }

                nodo = null;
                
                return;
            } 
            Nodo auxiliarPadre = nodo;

            if (nodo.nodoIzquierdo != null) {
                Nodo maxIzquierdo = nodo;

                while (maxIzquierdo.nodoDerecho != null) {
                    auxiliarPadre = maxIzquierdo;
                    maxIzquierdo = maxIzquierdo.nodoDerecho;
                }

                nodo.nombre = maxIzquierdo.nombre;
                nodo.saldo = maxIzquierdo.saldo;
                nodo.grado = maxIzquierdo.grado;

                auxiliarPadre.nodoDerecho = null;
                maxIzquierdo = null;

                return;

            } 

            if(nodo.nodoIzquierdo == null) {
                Nodo minDerecho = nodo;

                while (minDerecho.nodoIzquierdo != null) {
                    auxiliarPadre = minDerecho;
                    minDerecho = minDerecho.nodoIzquierdo;
                }

                nodo.nombre = minDerecho.nombre;
                nodo.saldo = minDerecho.saldo;
                nodo.grado = minDerecho.grado;

                auxiliarPadre.nodoIzquierdo = null;
                minDerecho = null;
                return;
            }
        }
        eliminarNombre(nombre, nodo.nodoIzquierdo, nodo);
        eliminarNombre(nombre, nodo.nodoDerecho, nodo);
    }     
}
