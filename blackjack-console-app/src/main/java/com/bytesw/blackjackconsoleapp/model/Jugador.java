package com.bytesw.blackjackconsoleapp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "jugador")
@NoArgsConstructor
@Data
@SuperBuilder
public class Jugador extends Usuario {

    @Column(name = "nombres")
    private String nombres;

    @Column(name = "dni")
    private String dni;

    @Transient
    private Mano mano;

    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "cuenta_id")
    private Cuenta cuenta;

}
