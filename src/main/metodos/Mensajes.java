package main.metodos;
import static main.Input.Estilos.*;

public class Mensajes {
    public static void mostrarError(String mensaje){
        System.out.println(bold(red("[x] - " + mensaje)));
    }

    public static void mostrarAviso(String mensaje){
        System.out.println(bold(yellow("[!] - " + mensaje)));
    }

    public static void mostrarEstado(String mensaje){
        System.out.println(bold(blue("[/] - " + mensaje)));

    }

    public static final String opciones[] = {
                            "Salir",
                            "Crear arbol",
                            "Insertar nodo",
                            "imprimir pre-orden",
                            "Imprimir in-orden",
                            "imprimir pos-orden",
                            "Imprimir nodos hoja",
                            "imprimir forma de arbol",
                            "Eliminar nodos hoja",
                            "Ver cuantos nodos hay a la izquierda y a la derecha"
                        };

    public static void menu(){
        System.out.println("");
        System.out.println(bold(cyan("────────────────────────┐")));
        System.out.println(bold(cyan("┌───────── Menu ────────┘")));
        
        for(int i = 0 ; i < opciones.length ; i++){
            System.out.println(bold(cyan("├─[" + i + "] ") + opciones[i]));
        }

        System.out.println(bold(cyan("└─────────────────────────")));
    }
}
