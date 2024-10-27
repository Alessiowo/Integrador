/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Modelo.Cliente;
import Modelo.Empleado;
import Modelo.Usuario;
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
public class UsuarioDao implements IUsuario{

    @Override
    public boolean add(Usuario obj) {
        String sql = "INSERT INTO usuario (login, clave, rol, idEmpleado, idCliente) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = DataSource.obtenerConexion();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, obj.getLogin());
            stmt.setString(2, obj.getClave());
            stmt.setString(3, obj.getRol());
            
            // Asociar idEmpleado o idCliente según el rol
            if ("Empleado".equals(obj.getRol()) && obj.getEmp() != null) {
                stmt.setInt(4, obj.getEmp().getIdEmpleado());
                stmt.setNull(5, java.sql.Types.INTEGER);
            } else if ("Cliente".equals(obj.getRol()) && obj.getCliente() != null) {
                stmt.setNull(4, java.sql.Types.INTEGER);
                stmt.setInt(5, obj.getCliente().getIdCliente());
            } else {
                throw new IllegalArgumentException("El usuario debe tener un rol válido y un objeto asociado.");
            }
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Usuario obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(String login) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Usuario> getUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM usuario";
        try (Connection connection = DataSource.obtenerConexion();
             PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Usuario usuario = mapResultSetToUsuario(rs);
                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuarios;
    }

    @Override
    public Usuario getUsuario(String login) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Usuario validarCredenciales(String login, String clave) {
        String sql = "SELECT * FROM usuario WHERE login = ? AND clave = ?";
        try (Connection connection = DataSource.obtenerConexion();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, login);
            stmt.setString(2, clave);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapResultSetToUsuario(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    // Método auxiliar para mapear ResultSet a objeto Usuario
    private Usuario mapResultSetToUsuario(ResultSet rs) throws SQLException {
        String login = rs.getString("login");
        String clave = rs.getString("clave");
        String rol = rs.getString("rol");
        
        Usuario usuario;
        if ("Empleado".equals(rol)) {
            Empleado emp = new Empleado();
            emp.setIdEmpleado(rs.getInt("idEmpleado"));
            usuario = new Usuario(login, clave, rol, emp);
        } else if ("Cliente".equals(rol)) {
            Cliente cliente = new Cliente();
            cliente.setIdCliente(rs.getInt("idCliente"));
            usuario = new Usuario(login, clave, rol, cliente);
        } else {
            usuario = new Usuario(login, clave, rol, (Empleado) null);
        }
        
        return usuario;
    }
}
