package com.mycompany.hostexpanse2.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Reserva implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idReserva;
    private String cedulaHuesped;
    private Integer numeroPersonas;
    private String nombreHuesped;
    private String apellidoHuesped;
    private String numeroHabitacion;
    private String numeroTelefono;
    private Integer nochePrecio;
    private Integer noches;
    @Temporal(TemporalType.DATE)
    private Date fechaReservaEntrada;
    @Temporal(TemporalType.DATE)
    private Date fechaReservaSalida;
    private Integer precioReserva;
    private Integer precioTotal;
    
    public void calcularReserva(){
        this.precioReserva = 40000*this.numeroPersonas;
    }
    
    public void calcularTotal(){
        this.precioTotal = precioReserva + (nochePrecio * noches);
    }
}
