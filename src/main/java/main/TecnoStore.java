package main;

import dao.ConexionDB;
import dao.ConexionDB;
import java.sql.Connection;

public class TecnoStore {

    public static void main(String[] args) {

        System.out.println("Iniciando TecnoStore...");

        Connection conn = ConexionDB.conectar();

        if (conn != null) {
            System.out.println("Sistema listo para usar.");
        } else {
            System.out.println("Sistema detenido por error de conexión.");
        }
    }
}
