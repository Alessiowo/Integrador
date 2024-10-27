/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Modelo.Empleado;
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
public class EmpleadoDao implements IEmpleado {

    @Override
    public boolean add(Object obj) {
      if (!(obj instanceof Empleado)) return false;
        Empleado empleado = (Empleado) obj;

        String sql = "INSERT INTO empleado (nombreEmpleado, cargo, turno) VALUES (?, ?, ?)";
        try (Connection connection = DataSource.obtenerConexion();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, empleado.getNombreEmp());
            stmt.setString(2, empleado.getCargo());
            stmt.setString(3, empleado.getTurno());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Empleado obj) {
        String sql = "UPDATE empleado SET nombreEmpleado = ?, cargo = ?, turno = ? WHERE idEmpleado = ?";
        try (Connection connection = DataSource.obtenerConexion();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, obj.getNombreEmp());
            stmt.setString(2, obj.getCargo());
            stmt.setString(3, obj.getTurno());
            stmt.setInt(4, obj.getIdEmpleado());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(String login) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Empleado> getEmpleados() {
        List<Empleado> empleados = new ArrayList<>();
        String sql = "SELECT * FROM empleado";
        try (Connection connection = DataSource.obtenerConexion();
             PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Empleado empleado = new Empleado(
                    rs.getInt("idEmpleado"),
                    rs.getString("nombreEmpleado"),
                    rs.getString("cargo"),
                    rs.getString("turno")
                );
                empleados.add(empleado);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return empleados;
    }

    @Override
    public Empleado getEmpleado(String login) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
