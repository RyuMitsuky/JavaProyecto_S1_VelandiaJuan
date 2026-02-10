package main;

import java.util.Scanner;
import service.GestorVentas;
import service.GestorMarcas;
import service.GestorCelulares;
import service.GestorClientes;

public class TecnoStore {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        GestorVentas gestorVentas = new GestorVentas();
        GestorMarcas gestorMarcas = new GestorMarcas();
        GestorCelulares gestorCelulares = new GestorCelulares();
        GestorClientes gestorClientes = new GestorClientes();

        int opcion;

        do {
            System.out.println("\n===== TECNOSTORE =====");
            System.out.println("1. Gestionar ventas");
            System.out.println("2. Gestionar marcas");
            System.out.println("3. Gestionar celulares");
            System.out.println("4. Gestionar clientes");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    gestorVentas.menu();
                    break;
                case 2:
                    gestorMarcas.menu();
                    break;
                case 3:
                    gestorCelulares.menu();
                    break;
                case 4:
                    gestorClientes.menu();
                    break;
                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción inválida");
            }

        } while (opcion != 0);

        sc.close();
    }
}
