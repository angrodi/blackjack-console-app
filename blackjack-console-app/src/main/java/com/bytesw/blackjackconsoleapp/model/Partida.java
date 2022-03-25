package com.bytesw.blackjackconsoleapp.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "partida")
@Data
public class Partida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "partida_id")
    private Integer id;

    @Transient
    private Baraja baraja;

    @Transient
    private Mano manoJugador;

    @Transient
    private Mano manoCrupier;

    @Column(name = "apuesta")
    private Double apuesta;

    @Column(name = "fecha")
    private LocalDateTime fecha;

    public Partida() {
        this.baraja = new Baraja();
        this.manoJugador = new Mano();
        this.manoCrupier = new Mano();
    }

}
