package main.arbolesbinarios;

import static main.Main.*;
import static main.Input.Estilos.*;

public class Nodo {
    public String nombre;
    public int saldo;
    public Nodo nodoIzquierdo = null;
    public Nodo nodoDerecho = null;

    public static void imprimirNodo(Nodo nodo){
        System.out.print(green("[ "));

        if (nodo == raiz) {
            System.out.print(nodo.nombre + yellow(" (Raiz)"));

        } else {
            System.out.print("Nombre: " + nodo.nombre + " ");
        }

        System.out.print(green(" ]"));
    }

}
