/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Modelo.Cliente;
import conf.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author EMMANUEL
 */
public class ClienteDao implements ICliente {

    @Override
    public boolean add(Cliente obj) {
        String sql = "INSERT INTO cliente (nombre, apellido, email, telefono) VALUES (?, ?, ?, ?)";
        try (Connection conn = DataSource.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, obj.getNombre());
            stmt.setString(2, obj.getApellido());
            stmt.setString(3, obj.getEmail());
            stmt.setString(4, obj.getTelefono());
            return stmt.executeUpdate() > 0; // Devuelve verdadero si se inserta correctamente
        } catch (SQLException e) {
            System.err.println("Error al agregar cliente capa dao: " + e.getMessage());
            return false; // Devuelve falso en caso de error
        }
    }

    @Override
    public boolean update(Cliente obj) {
        String sql = "UPDATE cliente SET nombre = ?, apellido = ?, email = ?, telefono = ? WHERE idCliente = ?";
        try (Connection conn = DataSource.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, obj.getNombre());
            stmt.setString(2, obj.getApellido());
            stmt.setString(3, obj.getEmail());
            stmt.setString(4, obj.getTelefono());
            stmt.setInt(5, obj.getIdCliente());
            return stmt.executeUpdate() > 0; // Devuelve verdadero si se actualiza correctamente
        } catch (SQLException e) {
            System.err.println("Error al actualizar cliente: " + e.getMessage());
            return false; // Devuelve falso en caso de error
        }
    }

    @Override
    public boolean delete(int login) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Cliente> getClientes() {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM cliente";
        try (Connection conn = DataSource.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                // Crea un nuevo objeto Cliente para cada registro
                Cliente cliente = new Cliente(
                    rs.getInt("idCliente"),
                    rs.getString("nombre"),
                    rs.getString("apellido"),
                    rs.getString("email"),
                    rs.getString("telefono")
                );
                clientes.add(cliente); // Añade el cliente a la lista
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener lista de clientes: " + e.getMessage());
        }
        return clientes; // Retorna la lista de clientes
        }

    @Override
    public Cliente getCliente(int login) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
        
}
