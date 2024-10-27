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
     // Agrega una nueva reserva
    boolean add(Reserva reserva);

    // Actualiza una reserva existente
    boolean update(Reserva reserva);

    // Elimina una reserva por ID
    boolean delete(int idReserva);

    // Obtiene una lista de todas las reservas
    List<Reserva> getReservas();

    // Obtiene una reserva por ID
    Reserva getReserva(int idReserva);

    // Opcional: busca reservas por cliente
    List<Reserva> getReservasByCliente(int idCliente);

    // Opcional: busca reservas por estado
    List<Reserva> getReservasByEstado(String estadoReserva);
}
