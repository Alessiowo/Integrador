/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.util.List;

/**
 *
 * @author EMMANUEL
 */
public interface ICliente {
    public boolean add(Object obj);
    public boolean update(Cliente obj);
    public boolean delete(String login);
    public List<Cliente> getClientes();
    public Cliente getCliente(String login);
}
