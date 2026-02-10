package service;

import java.util.Scanner;

public class GestorVentas {

    private Scanner sc = new Scanner(System.in);

    public void menu() {
        int opcion;
        do {
            System.out.println("\n=== GESTIÓN DE VENTAS ===");
            System.out.println("1. Registrar venta");
            System.out.println("2. Listar ventas");
            System.out.println("0. Volver");
            System.out.print("Opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1 -> registrarVenta();
                case 2 -> listarVentas();
            }
        } while (opcion != 0);
    }

    private void registrarVenta() {
        System.out.println("Registrar venta (pendiente)");
    }

    private void listarVentas() {
        System.out.println("Listar ventas (pendiente)");
    }
}
