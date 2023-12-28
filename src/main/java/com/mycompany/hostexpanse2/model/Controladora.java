/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hostexpanse2.model;

import com.mycompany.hostexpanse2.persistencia.ControladoraPersistencia;
import com.mycompany.hostexpanse2.persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author Drow
 */
public class Controladora {
    
    ControladoraPersistencia control = new ControladoraPersistencia();

    public void agregar(String nombre, String apellido, Integer cedula, String correo, String direccion, String contrasena) {
        
        Usuario user = new Usuario();
        user.setNombre(nombre);
        user.setApellido(apellido);
        user.setCedula(cedula);
        user.setCorreo(correo);
        user.setDireccion(direccion);
        user.setContrasena(contrasena);
        
        
        control.agregar(user);
    }
    
    public void editar(Usuario usuario) throws Exception{
        control.editar(usuario);
    }
    
    public int encontrarIdByCedula(int cedula){
        return control.encontrarIdByCedula(cedula);
    }

    public void borrarByCedula(Integer cedula) throws NonexistentEntityException {
        control.eliminarByCedula(cedula);
    }

    public void editarByCedula(int cedula) {
        control.editarByCedula(cedula);
    }
    
    public Usuario encontrarUserById(int userId){
        return control.encontrarUserById(userId);
    }
    
    public Integer encontrarIdByNumeroPiso(String numeroPiso){
        return control.encontrarIdByNumeroPiso(numeroPiso);
    }
    
    public void eliminarHabitacionById(Integer idHabitacion) throws NonexistentEntityException{
        control.eliminarHabitacionById(idHabitacion);
    }

    public Integer encontrarReservaByCedula(String cedula) {
        return control.encontrarReservaByCedula(cedula);
    }
    
    public Reserva encontrarReservaById(Integer idReserva){
        return control.encontrarReservaById(idReserva);
    }
}
