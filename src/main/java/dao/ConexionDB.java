package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {

    public static Connection conectar() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tecnostore_db", "campus2023", "campus2023");
            System.out.println(" Conexión exitosa a la base de datos TecnoStore");
            return conn;
        } catch (SQLException e) {
            System.out.println(" Error al conectar a la base de datos");
            System.out.println(e.getMessage());
            return null;
        }
    }
}
