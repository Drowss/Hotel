package com.mycompany.hostexpanse2.model;

import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-12-01T20:46:02", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Reserva.class)
public class Reserva_ { 

    public static volatile SingularAttribute<Reserva, String> apellidoHuesped;
    public static volatile SingularAttribute<Reserva, String> nombreHuesped;
    public static volatile SingularAttribute<Reserva, String> numeroHabitacion;
    public static volatile SingularAttribute<Reserva, Date> fechaReservaSalida;
    public static volatile SingularAttribute<Reserva, String> cedulaHuesped;
    public static volatile SingularAttribute<Reserva, Integer> noches;
    public static volatile SingularAttribute<Reserva, Date> fechaReservaEntrada;
    public static volatile SingularAttribute<Reserva, Integer> numeroPersonas;
    public static volatile SingularAttribute<Reserva, Integer> precioReserva;
    public static volatile SingularAttribute<Reserva, Integer> nochePrecio;
    public static volatile SingularAttribute<Reserva, Integer> precioTotal;
    public static volatile SingularAttribute<Reserva, Integer> idReserva;
    public static volatile SingularAttribute<Reserva, String> numeroTelefono;

}