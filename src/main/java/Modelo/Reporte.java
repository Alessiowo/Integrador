/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author EMMANUEL
 */
public class Reporte {
    private int idReporte;
    private String fechaCreacion;
    private String tipo;// por ejemplo, (reporte de reservas, reporte de pedidos)
    private Empleado Empleado;

    public Reporte() {
    }

    public Reporte(int idReporte, String fechaCreacion, String tipo, Empleado Empleado) {
        this.idReporte = idReporte;
        this.fechaCreacion = fechaCreacion;
        this.tipo = tipo;
        this.Empleado = Empleado;
    }

    public int getIdReporte() {
        return idReporte;
    }

    public void setIdReporte(int idReporte) {
        this.idReporte = idReporte;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Empleado getEmpleado() {
        return Empleado;
    }

    public void setEmpleado(Empleado Empleado) {
        this.Empleado = Empleado;
    }
    
    
}
