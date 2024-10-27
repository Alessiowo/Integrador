/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import Modelo.Usuario;
import java.util.List;

/**
 *
 * @author EMMANUEL
 */
public interface IUsuario {
    public boolean add(Usuario obj);
    public boolean update(Usuario obj);
    public boolean delete(String login);
    public List<Usuario> getUsuarios();
    public Usuario getUsuario(String login);
    public Usuario validarCredenciales(String login, String clave);
}
