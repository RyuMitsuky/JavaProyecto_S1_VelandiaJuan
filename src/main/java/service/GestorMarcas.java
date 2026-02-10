package service;

import dao.MarcaDAO;
import java.util.Scanner;

public class GestorMarcas {

    private final MarcaDAO marcaDAO = new MarcaDAO();
    private final Scanner sc = new Scanner(System.in);

    public void menu() {
        int opcion;

        do {
            System.out.println("\n=== GESTIÓN DE MARCAS ===");
            System.out.println("1. Listar marcas");
            System.out.println("0. Volver");
            System.out.print("Opción: ");

            opcion = sc.nextInt();

            switch (opcion) {
                case 1 -> marcaDAO.listarMarcas();
                case 0 -> System.out.println("Volviendo...");
                default -> System.out.println("Opción inválida");
            }
        } while (opcion != 0);
    }
}
