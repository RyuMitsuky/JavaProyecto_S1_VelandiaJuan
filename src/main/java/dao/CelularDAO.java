package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class CelularDAO {

    public void listarCelulares() {
        String sql = """
            SELECT 
                c.id,
                m.nombre AS marca,
                c.modelo,
                c.sistema_operativo,
                c.gama,
                c.precio,
                c.stock
            FROM celulares c
            JOIN marcas m ON c.id_marca = m.id
            ORDER BY c.id
        """;

        try (
            Connection conn = ConexionDB.getConexion();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)
        ) {

            System.out.println("\n--- LISTADO DE CELULARES ---");
            System.out.printf(
                "%-3s %-12s %-18s %-10s %-7s %-10s %-5s%n",
                "ID", "MARCA", "MODELO", "SO", "GAMA", "PRECIO", "STOCK"
            );

            while (rs.next()) {
                System.out.printf(
                    "%-3d %-12s %-18s %-10s %-7s %-10.2f %-5d%n",
                    rs.getInt("id"),
                    rs.getString("marca"),
                    rs.getString("modelo"),
                    rs.getString("sistema_operativo"),
                    rs.getString("gama"),
                    rs.getDouble("precio"),
                    rs.getInt("stock")
                );
            }

        } catch (Exception e) {
            System.out.println("Error al listar celulares");
            e.printStackTrace();
        }
    }
}
