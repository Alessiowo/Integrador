/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Cliente;
import dao.ClienteDao;
import java.util.List;

/**
 *
 * @author EMMANUEL
 */
public class cCliente {
    public List<Cliente> getCliente(){
        ClienteDao objC = new ClienteDao();
        return objC.getClientes();
    }
    
    public boolean add(Cliente obj){
        ClienteDao objCD = new ClienteDao();
        return objCD.add(obj);
    }
}
