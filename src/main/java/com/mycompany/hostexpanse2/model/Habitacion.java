package com.mycompany.hostexpanse2.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Habitacion implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idHabitacion;
    private String numeroPiso;
    private String cantidadCamas;
    private String estadoHabitacion;
    
    public void hacerOcupado(){
        this.estadoHabitacion = "Ocupado";
    }
    
    public void hacerDesocupado(){
        this.estadoHabitacion = "Desocupado";
    }
    
    public void hacerAseo(){
        this.estadoHabitacion = "Aseo";
    }
    
}
