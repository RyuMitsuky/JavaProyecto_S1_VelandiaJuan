package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class MarcaDAO {

    public void listarMarcas() {
        String sql = "SELECT id, nombre FROM marcas";

        try (
            Connection conn = ConexionDB.getConexion();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)
        ) {

            System.out.println("\n--- MARCAS REGISTRADAS ---");

            while (rs.next()) {
                System.out.println(
                    rs.getInt("id") + " - " + rs.getString("nombre")
                );
            }

        } catch (Exception e) {
            System.out.println("Error al listar marcas");
            e.printStackTrace();
        }
    }
}
