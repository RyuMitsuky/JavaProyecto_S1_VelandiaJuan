package service;

import dao.ClienteDAO;
import model.Cliente;
import util.Validador;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class GestorClientes {

    private Scanner sc = new Scanner(System.in);
    private ClienteDAO dao = new ClienteDAO();

    public void menu() {
        int opcion;
        do {
            System.out.println("\n=== GESTIÓN DE CLIENTES ===");
            System.out.println("1. Registrar cliente");
            System.out.println("2. Listar clientes");
            System.out.println("0. Volver");
            System.out.print("Opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> registrarCliente();
                case 2 -> listarClientes();
            }
        } while (opcion != 0);
    }

    private void registrarCliente() {
        try {
            System.out.print("Nombre: ");
            String nombre = sc.nextLine();

            System.out.print("Identificación: ");
            String identificacion = sc.nextLine();

            if (dao.existeIdentificacion(identificacion)) {
                System.out.println("La identificación ya existe");
                return;
            }

            System.out.print("Correo: ");
            String correo = sc.nextLine();

            if (!Validador.correoValido(correo)) {
                System.out.println("Correo inválido");
                return;
            }

            System.out.print("Teléfono: ");
            String telefono = sc.nextLine();

            Cliente c = new Cliente(0, nombre, identificacion, correo, telefono);
            dao.registrar(c);

            System.out.println("Cliente registrado correctamente");

        } catch (SQLException e) {
            System.out.println("Error al registrar cliente");
        }
    }

    private void listarClientes() {
        try {
            List<Cliente> clientes = dao.listar();

            System.out.println("\n--- CLIENTES REGISTRADOS ---");
            for (Cliente c : clientes) {
                System.out.println(
                        c.getId() + " | " +
                        c.getNombre() + " | " +
                        c.getIdentificacion() + " | " +
                        c.getCorreo()
                );
            }
        } catch (SQLException e) {
            System.out.println("Error al listar clientes");
        }
    }
}
