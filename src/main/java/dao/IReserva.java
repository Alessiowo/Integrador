/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import Modelo.Reserva;
import java.util.List;

/**
 *
 * @author EMMANUEL
 */
public interface IReserva {
    boolean add(Reserva reserva);
    boolean update(Reserva reserva);
    boolean delete(int idReserva);
    List<Reserva> getReservas();
    Reserva getReserva(int idReserva);
    List<Reserva> getReservasByCliente(int idCliente);
    List<Reserva> getReservasByEstado(String estadoReserva);
}
