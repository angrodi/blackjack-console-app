package com.bytesw.blackjackconsoleapp.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "cuenta")
@Data
public class Cuenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cuenta_id")
    private Integer id;

    @Column(name = "saldo")
    private Double saldo;

    public Cuenta() {
        this.saldo = 0.0;
    }

    public void cargo(Double monto) {
        this.saldo -= monto;
    }

    public void abono(Double monto) {
        this.saldo += monto;
    }
}
