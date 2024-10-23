/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import Modelo.Empleado;
import java.util.List;

/**
 *
 * @author EMMANUEL
 */
public interface IEmpleado {
    public boolean add(Object obj);
    public boolean update(Empleado obj);
    public boolean delete(String login);
    public List<Empleado> getEmpleados();
    public Empleado getEmpleado(String login);
}
