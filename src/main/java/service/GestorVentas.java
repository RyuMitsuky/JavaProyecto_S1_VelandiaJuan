package service;

import java.util.Scanner;

public class GestorVentas {

    public void menu() {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- GESTIÓN DE VENTAS ---");
            System.out.println("1. Registrar venta");
            System.out.println("2. Listar ventas");
            System.out.println("0. Volver");
            System.out.print("Opción: ");

            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Registrar venta...");
                    break;
                case 2:
                    System.out.println("Listar ventas...");
                    break;
                case 0:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción inválida");
            }

        } while (opcion != 0);
    }
}
