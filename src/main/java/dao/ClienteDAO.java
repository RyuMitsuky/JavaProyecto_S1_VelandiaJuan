package dao;

import model.Cliente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    public void registrar(Cliente c) throws SQLException {
        String sql = "INSERT INTO clientes (nombre, identificacion, correo, telefono) VALUES (?, ?, ?, ?)";

        try (Connection con = ConexionDB.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, c.getNombre());
            ps.setString(2, c.getIdentificacion());
            ps.setString(3, c.getCorreo());
            ps.setString(4, c.getTelefono());

            ps.executeUpdate();
        }
    }

    public List<Cliente> listar() throws SQLException {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM clientes";

        try (Connection con = ConexionDB.getConexion();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Cliente c = new Cliente(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("identificacion"),
                        rs.getString("correo"),
                        rs.getString("telefono")
                );
                clientes.add(c);
            }
        }
        return clientes;
    }

    public boolean existeIdentificacion(String identificacion) throws SQLException {
        String sql = "SELECT 1 FROM clientes WHERE identificacion = ?";

        try (Connection con = ConexionDB.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, identificacion);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        }
    }
}
