package main;

import main.arbolesbinarios.Nodo;
import static main.Input.Input.*;
import static main.arbolesbinarios.ArbolBinario.*;
import static main.metodos.Mensajes.*;
import static main.Input.Estilos.*;

public class Main {

    public static Nodo raiz = null;

    public static void main(String[] args) {
        
        while (true) {

            menu();

            byte eleccion = inputByte("Ingrese su opcion");

            if( opciones.length > eleccion && eleccion > -1){
                System.out.println(green("─── ") + "Arbol binario - " + green(opciones[eleccion]) + green(" ──"));
            }

            switch (eleccion) {

                case 0 -> mostrarAviso("Saliendo...");
                case 1 -> crearArbol();

                case 2 ->{ 

                    if(!existeArbol()){
                        mostrarError("El arbol no ha sido creado");
                        break;
                    }

                    String nombre = input("Ingrese el nombre");
                    int saldo = inputInt("Ingrese el saldo");

                    Nodo auxiliar = raiz;
                    Nodo nuevoNodo = new Nodo();
                    nuevoNodo.nombre = nombre;
                    nuevoNodo.saldo = saldo;

                    insertarOrdenadoPorNombres(nombre,saldo, nuevoNodo, auxiliar);
                }
                
                case 3 -> {
                    if(!existeArbol()){
                        mostrarError("El arbol no ha sido creado");
                        break;
                    }

                    imprimirNombresPreOrden(raiz);
                }

                case 4 -> {
                    if(!existeArbol()){
                        mostrarError("El arbol no ha sido creado");
                        break;
                    }

                    imprimirNombresInOrden(raiz);
                }

                case 5 -> {
                    if(!existeArbol()){
                        mostrarError("El arbol no ha sido creado");
                        break;
                    }

                    imprimirNombresPosOrden(raiz);
                }
                
                case 6 -> {
                    imprimirNodosHoja(raiz,0);
                }

                case 7 -> {
                    imprimirNombresArbol(raiz,0,false);
                } 
                
                case 8 -> {

                    imprimirNodosHoja(raiz, 0);
                    mostrarEstado("Se eliminaran los siquientes nodos");

                    eliminarNodosHoja(null,raiz);

                    if(confirmacion != 1){
                        break;
                    }
                    
                    mostrarEstado("Nodos eliminados correctamente");
                }

                case 9 -> {

                    int contador[] = {0};
                    cantidadNodos(raiz, contador);
                    System.out.println(cyan("Cantidad de nodos (incluyendo la raiz): ") + contador[0]);
                }

                case 10 -> {


                    //contador[0] es la cantidad de nodos a la izquierda y contador[1] es la cantidad a la derecha
                    int contadores[] = {0,0};

                    cantidadNodosIzquierdaYDerecha(raiz, contadores);

                    System.out.println(bold(cyan("┌─── Cantidad de nodos ───")));
                    System.out.println(bold(cyan("├─ izquierda: ") + contadores[0]));
                    System.out.println(bold(cyan("├─ Derecha: ") + contadores[1]));
                    System.out.println(bold(cyan("└─────────────────────────")));
                }

                case 11 -> {
                    String nombre = input("Ingrese el nombre a buscar");
                    buscarNombre(nombre, raiz);
                }

                case 12 -> {
                    int saldo = inputInt("Ingrese el saldo a buscar");
                    buscarSaldo(saldo, raiz);
                }

                case 13 -> {
                    int grado = inputInt("Ingrese el grado a buscar");
                    buscarGrado(grado, raiz);
                }

                default -> {
                    mostrarError("opcion invalida");
                }
            }

            if(eleccion == 0){
                break;
            }

        }

        
        
    }
}