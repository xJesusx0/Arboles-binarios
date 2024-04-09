package main.Input;

import static main.Input.Estilos.*;
import static main.Input.Mensajes.*;

import java.util.Scanner;

public class Input {

    

    public static String input(String mensaje) {
        Scanner input = new Scanner(System.in);
        while (true) {

            System.out.println("┌──( " + green(mensaje) + " )");
            System.out.print("└─ " + green("$ "));

            String UserInput = input.nextLine();

            if (!UserInput.trim().isEmpty()) {
                return UserInput;

            } else {
                mostrarError("La entrada esta vacia, intentelo denuevo");
            }
        }
    }

    public static int inputIntLimite(String mensaje,int limiteInferior,int limiteSuperior) {
        while (true) {
            String entrada = input(mensaje);

            try {
                int numero = Integer.parseInt(entrada);

                if (numero > limiteInferior && numero <= limiteSuperior) {
                    return numero;
                } else {
                    mostrarError("Ingrese un número mayor a 0, inténtelo de nuevo");
                }

            } catch (NumberFormatException e) {
                mostrarError("Entrada inválida, inténtelo de nuevo");
            }
        }
    }

    public static int inputTamaño(String mensaje) {
        while (true) {
            String entrada = input(mensaje);

            try {
                int numero = Integer.parseInt(entrada);

                if (numero > 0) {
                    return numero;
                } else {
                    mostrarError("Ingrese un número mayor a 0, inténtelo de nuevo");
                }

            } catch (NumberFormatException e) {
                mostrarError("Entrada inválida, inténtelo de nuevo");
            }
        }
    }

    public static int inputInt(String mensaje) {
        while (true) {
            String entrada = input(mensaje);

            try {
                return Integer.parseInt(entrada);

            } catch (NumberFormatException e) {
                mostrarError("Entrada invalida, intenelo denuevo");

            }
        }
    }

    public static double inputDouble(String mensaje) {
        while (true) {
            String entrada = input(mensaje);

            try {
                return Double.parseDouble(entrada);

            } catch (NumberFormatException e) {
                mostrarError("Entrada invalida, intentelo denuevo");

            }
        }
    }

    public static byte inputByte(String mensaje) {
        while (true) {
            String entrada = input(mensaje);
            try {
                return Byte.valueOf(entrada);

            } catch (NumberFormatException e) {
                mostrarError("Entrada invalida, intentelo denuevo");
            }
        }
    }
}