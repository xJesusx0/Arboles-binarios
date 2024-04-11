package main.arbolesbinarios;

import static main.Main.*;
import static main.Input.Estilos.*;

public class Nodo {
    public String nombre;
    public int saldo;
    public int grado = 0;
    public Nodo nodoIzquierdo = null;
    public Nodo nodoDerecho = null;

    public static void imprimirNodo(Nodo nodo){
        System.out.print(green("[ "));

        System.out.print("Nombre: " + nodo.nombre + ", ");
        System.out.print("Saldo: " + nodo.saldo + ", ");
        System.out.print("Grado: " + nodo.grado);

        if(nodo == raiz){
            System.out.print(yellow(" (Raiz)"));

        }

        System.out.print(green(" ]"));

        System.out.println("");
    }

    public static int obtenerGrado(Nodo nodo){
        int grado = 0;

        if(nodo.nodoDerecho != null){
            grado++;
        }

        if(nodo.nodoIzquierdo != null){
            grado++;
        }
        
        return grado;
    }
}
