package com.bytesw.blackjackconsoleapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "usuario")
@Inheritance(strategy = InheritanceType.JOINED)
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuario_id")
    private Integer id;

    @Column(name = "correo")
    private String correo;

    @Column(name = "contrasenia")
    private String contrasenia;

    @Column(name = "fecha_ultima_sesion")
    private LocalDateTime fechaUltimaSesion;

    @Column(name = "ip")
    private String ip;

    @Column(name = "estado")
    private Integer estado;

}
