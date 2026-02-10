package service;

import java.util.Scanner;

public class GestorCelulares {

    private Scanner sc = new Scanner(System.in);

    public void menu() {
        int opcion;
        do {
            System.out.println("\n=== GESTIÓN DE CELULARES ===");
            System.out.println("1. Listar celulares");
            System.out.println("2. Registrar celular");
            System.out.println("0. Volver");
            System.out.print("Opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1 -> listarCelulares();
                case 2 -> registrarCelular();
            }
        } while (opcion != 0);
    }

    private void listarCelulares() {
        System.out.println("Listado de celulares (OK)");
    }

    private void registrarCelular() {
        System.out.println("Registro de celular (pendiente)");
    }
}
