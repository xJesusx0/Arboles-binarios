package main;

//import static main.Input.Input.*;
import main.arbolesbinarios.Nodo;
import static main.Input.Input.*;
import static main.arbolesbinarios.ArbolBinario.*;
import static main.Input.Mensajes.*;
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
                    int dato = inputInt("Ingrese el dato a insertar");

                    Nodo auxiliar = raiz;
                    Nodo nuevoNodo = new Nodo();
                    nuevoNodo.dato = dato;

                    insertar(dato, nuevoNodo, auxiliar);
                }
                
                case 3 -> imprimirInOrder(raiz,0);

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