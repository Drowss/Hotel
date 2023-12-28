/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hostexpanse2.persistencia;

import com.mycompany.hostexpanse2.model.Habitacion;
import com.mycompany.hostexpanse2.model.Reserva;
import com.mycompany.hostexpanse2.model.Usuario;
import com.mycompany.hostexpanse2.persistencia.exceptions.NonexistentEntityException;
import java.util.List;

/**
 *
 * @author Drow
 */
public class ControladoraPersistencia {
    
     UsuarioJpaController userJpa = new UsuarioJpaController();
     HabitacionJpaController roomJpa = new HabitacionJpaController();
     ReservaJpaController reservaJpa = new ReservaJpaController();

    public void agregar(Usuario user) {
        userJpa.create(user);
    }

    public void eliminarByCedula(int cedula) throws NonexistentEntityException {
        userJpa.destroy(userJpa.encontrarIdByCedula(cedula));
    }
    
    public void editar(Usuario usuario) throws Exception{
        userJpa.edit(usuario);
    }

    public void editarByCedula(int cedula) {
        int usuarioId = userJpa.encontrarIdByCedula(cedula);
        Usuario user = userJpa.findUsuario(usuarioId);
    }

    public int encontrarIdByCedula(int cedula) {
        int userId = userJpa.encontrarIdByCedula(cedula);
        return userId;
    }
    
    public Usuario encontrarUserById(int userId){
        Usuario userObj = userJpa.findUsuario(userId);
        return userObj;
    }
    
    public void agregarHabitacion(Habitacion habitacion){
        roomJpa.create(habitacion);
    }
    
    public void editarHabitacion(Habitacion habitacion) throws Exception{
        roomJpa.edit(habitacion);
    }
    
    public void eliminarHabitacionById(Integer idHabitacion) throws NonexistentEntityException{
        roomJpa.destroy(idHabitacion);
    }
    
    public Integer encontrarIdByNumeroPiso(String numeroPiso){
        return roomJpa.encontrarIdByNumeroHabitacion(numeroPiso);
    }
    
    public void agregarReserva(Reserva reserva){
        reservaJpa.create(reserva);
    }
    
    public List<Habitacion> encontrarHabitaciones(){
        return roomJpa.findHabitacionEntities();
    }
    
    public Habitacion findHabitacion(Integer idHabitacion){
        return roomJpa.findHabitacion(idHabitacion);
    }
    
    public Reserva encontrarReservaById(Integer idReserva){
        return reservaJpa.findReserva(idReserva);
    }
    
    public Integer encontrarReservaByCedula(String cedula){
        return reservaJpa.encontrarIdByCedula(cedula);
    }
    
    public void editarReserva(Reserva reserva) throws Exception{
        reservaJpa.edit(reserva);
    }
    
    public List<Reserva> encontrarReservas(){
        return reservaJpa.findReservaEntities();
    }
    
    public void eliminarReserva(Integer idReserva) throws NonexistentEntityException{
        reservaJpa.destroy(idReserva);
    }
}
