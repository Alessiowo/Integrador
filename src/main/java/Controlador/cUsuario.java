/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Usuario;
import dao.UsuarioDao;
import java.util.List;

/**
 *
 * @author EMMANUEL
 */
public class cUsuario {
    public List<Usuario> getUsuarios() { 
       UsuarioDao obj = new UsuarioDao();
       return obj.getUsuarios();
   }
   
   public Usuario validarCredenciales(String login, String clave) {
       UsuarioDao obj = new UsuarioDao();
       return obj.validarCredenciales(login, clave);
   }
   
   public boolean add(Usuario obj) {
       UsuarioDao objD = new UsuarioDao();
       return objD.add(obj);
   }
}
