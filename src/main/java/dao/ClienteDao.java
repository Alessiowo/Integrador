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
 * Clase que implementa la interfaz ICliente para gestionar operaciones de
 * acceso a datos relacionadas con la entidad Cliente en la base de datos.
 * 
 * Esta clase proporciona métodos para agregar, actualizar, eliminar y obtener
 * clientes desde la base de datos.
 * 
 * @author EMMANUEL
 */
public class ClienteDao implements ICliente {
    
    /**
     * Agrega un nuevo cliente a la base de datos.
     * 
     * @param obj El objeto Cliente que se desea agregar.
     * @return true si se inserta correctamente, false en caso contrario.
     */
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
    
    
    /**
     * Actualiza la información de un cliente en la base de datos.
     * 
     * @param obj El objeto Cliente que contiene los nuevos datos del cliente.
     * @return true si se actualiza correctamente, false en caso contrario.
     */
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
    
    /**
     * Elimina un cliente de la base de datos.
     * 
     * @param idCliente El ID del cliente que se desea eliminar.
     * @return true si se elimina correctamente, false en caso contrario.
     * @throws UnsupportedOperationException si este método no está implementado.
     */
    @Override
    public boolean delete(int idCliente) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    /**
     * Obtiene una lista de todos los clientes de la base de datos.
     * 
     * @return Una lista de objetos Cliente que representan a todos los clientes.
     */
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
    
    /**
     * Obtiene un cliente específico de la base de datos.
     * 
     * @param idCliente El ID del cliente que se desea obtener.
     * @return El objeto Cliente correspondiente al ID, o null si no se encuentra.
     */
    @Override
    public Cliente getCliente(int idCliente) {
        String sql = "SELECT * FROM cliente WHERE idCliente=?";
        try (Connection conn = DataSource.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idCliente);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                // Retorna un nuevo objeto Cliente con los datos obtenidos
                return new Cliente(
                    rs.getInt("idCliente"),
                    rs.getString("nombre"),
                    rs.getString("apellido"),
                    rs.getString("email"),
                    rs.getString("telefono")
                );
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener cliente: " + e.getMessage());
        }
        return null; // Retorna null si no se encuentra el cliente
    }
        
}
