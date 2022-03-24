package com.bytesw.blackjackconsoleapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "jugador")
@NoArgsConstructor
@AllArgsConstructor
@Data
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
