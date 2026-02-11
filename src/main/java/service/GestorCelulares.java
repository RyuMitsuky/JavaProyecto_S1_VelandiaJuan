package service;

import java.util.Scanner;
import model.Celular;
import model.CategoriaGama;
import dao.CelularDAO;

public class GestorCelulares {

    private Scanner sc = new Scanner(System.in);
    private CelularDAO celularDAO = new CelularDAO();

    public void menu() {
        int opcion;
        do {
            System.out.println("\n=== GESTIÓN DE CELULARES ===");
            System.out.println("1. Listar celulares");
            System.out.println("2. Registrar celular");
            System.out.println("0. Volver");
            System.out.print("Opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // 

            switch (opcion) {
                case 1 -> listarCelulares();
                case 2 -> registrarCelular(); // 
            }
        } while (opcion != 0);
    }

    private void listarCelulares() {
        celularDAO.listarCelulares();
    }

    // 
    private void registrarCelular() {
        try {
            System.out.println("\n=== REGISTRAR NUEVO CELULAR ===");

            // 
            System.out.print("ID de la marca: ");
            int idMarca = sc.nextInt();
            sc.nextLine(); // 

            // 
            System.out.print("Modelo: ");
            String modelo = sc.nextLine();

            // 
            System.out.print("Sistema operativo: ");
            String so = sc.nextLine();

            // Gama
            System.out.print("Gama (ALTA, MEDIA, BAJA): ");
            String gamaInput = sc.nextLine().toUpperCase();
            CategoriaGama gama;
            try {
                gama = CategoriaGama.valueOf(gamaInput);
            } catch (IllegalArgumentException e) {
                System.out.println("Gama inválida. Usando MEDIA por defecto.");
                gama = CategoriaGama.MEDIA;
            }

            // 
            System.out.print("Precio: ");
            double precio = sc.nextDouble();

            // 
            System.out.print("Stock: ");
            int stock = sc.nextInt();

            // 
            Celular celular = new Celular(idMarca, modelo, so, gama, precio, stock);

            // 
            celularDAO.insertarCelular(celular);

        } catch (Exception e) {
            System.out.println("Error al registrar el celular.");
            e.printStackTrace();
        }
    }

}
