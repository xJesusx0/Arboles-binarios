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
                return;
            }
            auxiliar = auxiliar.nodoIzquierdo;
            insertarOrdenadoPorNombres(nombre, dato, nuevoNodo, auxiliar);
        }

        if (esMayor(nombre, auxiliar.nombre)) {
            if (auxiliar.nodoDerecho == null) {
                auxiliar.nodoDerecho = nuevoNodo;
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

        System.out.print(green("[ "));

        if (nodo == raiz) {
            System.out.print(nodo.nombre + yellow(" (Raiz)"));

        } else {
            System.out.print("Nombre: " + nodo.nombre + " ");
        }

        System.out.print(green(" ]"));
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

    public static void eliminarNodosHoja(Nodo padre,Nodo nodo) {
        
        if (nodo == null) {
            return;
        }


        if(nodo.nodoIzquierdo == null && nodo.nodoDerecho == null){

            if(nodo == raiz){
                mostrarAviso("Esta seguro que desea eliminar el nodo raiz?");
                int confirmacion = inputInt("(1 = si / cualquier otro numero = no)");

                if(confirmacion != 1){
                    return;
                }

                raiz = null;
            }

            if (padre != null) {
                if (padre.nodoIzquierdo == nodo) {
                    padre.nodoIzquierdo = null;
                } else if (padre.nodoDerecho == nodo) {
                    padre.nodoDerecho = null;
                }
            }
        }

        eliminarNodosHoja(nodo, nodo.nodoIzquierdo);
        eliminarNodosHoja(nodo, nodo.nodoDerecho);

    }

    public static void cantidadNodosIzquierdaYDerecha(Nodo nodo,int contadores[]){

        if (!existeArbol()) {
            mostrarError("El arbol no ha sido creado");
            return;
        }

        if(nodo == null){
            return;
        }

        if(nodo.nodoIzquierdo != null){
            contadores[0]++;
            cantidadNodosIzquierdaYDerecha(nodo.nodoIzquierdo,contadores);

        }

        if(nodo.nodoDerecho != null){
            contadores[1]++;
            cantidadNodosIzquierdaYDerecha(nodo.nodoDerecho,contadores);
        }
    }

    public static void cantidadNodos(Nodo nodo,int contador[]){

        if (!existeArbol()) {
            mostrarError("El arbol no ha sido creado");
            return;
        }

        if(nodo == null){
            return;
        }

        if(nodo.nodoIzquierdo != null){
            contador[0]++;
            cantidadNodos(nodo.nodoIzquierdo,contador);

        }

        if(nodo.nodoDerecho != null){
            contador[0]++;
            cantidadNodos(nodo.nodoDerecho,contador);
        }
    }
}
