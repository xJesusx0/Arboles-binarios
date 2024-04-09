package main.Input;
import static main.Input.Estilos.*;

public class Mensajes {
    public static void mostrarError(String mensaje){
        System.out.println(bold(red("[x] - " + mensaje)));
    }

    public static void mostrarAviso(String mensaje){
        System.out.println(bold(yellow("[!] - " + mensaje)));
    }

    public static void menu(){
        System.out.println("[0] - Salir");
        System.out.println("[1] - Crear arbol");
        System.out.println("[2] - Insertar nodo");
        System.out.println("[3] - Imprimir in orden");
    }
}
