/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Empleado;
import dao.EmpleadoDao;
import java.util.List;

/**
 *
 * @author EMMANUEL
 */
public class cEmpleado {
    public List<Empleado> getEmpleado(){
        EmpleadoDao objE = new EmpleadoDao();
        return objE.getEmpleados();
    }
}
