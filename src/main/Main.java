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
                    System.out.println(blue("┌── ") + "Arbol binario" + blue(" ──"));
                    imprimirNombresInOrder(raiz,0,false);
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