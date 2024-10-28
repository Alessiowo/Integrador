/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import Modelo.Cliente;
import java.util.List;

/**
 * Interfaz que define las operaciones de acceso a datos para la entidad Cliente.
 * 
 * Esta interfaz proporciona métodos para agregar, actualizar, eliminar y obtener
 * clientes desde la base de datos. Debe ser implementada por cualquier clase que
 * maneje operaciones relacionadas con clientes.
 * 
 * @author EMMANUEL
 */
public interface ICliente {
    /**
     * Agrega un nuevo cliente a la base de datos.
     * 
     * @param obj El objeto Cliente que se desea agregar.
     * @return true si se inserta correctamente, false en caso contrario.
     */
    public boolean add(Cliente obj);
    
    /**
     * Actualiza la información de un cliente en la base de datos.
     * 
     * @param obj El objeto Cliente que contiene los nuevos datos del cliente.
     * @return true si se actualiza correctamente, false en caso contrario.
     */
    public boolean update(Cliente obj);
    
    /**
     * Elimina un cliente de la base de datos.
     * 
     * @param idCliente El ID del cliente que se desea eliminar.
     * @return true si se elimina correctamente, false en caso contrario.
     */
    public boolean delete(int idCliente);
    
    /**
     * Obtiene una lista de todos los clientes de la base de datos.
     * 
     * @return Una lista de objetos Cliente que representan a todos los clientes.
     */
    public List<Cliente> getClientes();
    
    /**
     * Obtiene un cliente específico de la base de datos.
     * 
     * @param idCliente El ID del cliente que se desea obtener.
     * @return El objeto Cliente correspondiente al ID, o null si no se encuentra.
     */
    public Cliente getCliente(int idCliente);
}
