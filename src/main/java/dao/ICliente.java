/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import Modelo.Cliente;
import java.util.List;

/**
 *
 * @author EMMANUEL
 */
public interface ICliente {
    public boolean add(Cliente obj);
    public boolean update(Cliente obj);
    public boolean delete(int login);
    public List<Cliente> getClientes();
    public Cliente getCliente(int login);
}
