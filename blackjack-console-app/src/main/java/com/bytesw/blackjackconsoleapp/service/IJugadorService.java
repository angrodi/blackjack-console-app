package com.bytesw.blackjackconsoleapp.service;

import com.bytesw.blackjackconsoleapp.model.Jugador;

public interface IJugadorService {

    Jugador save(Jugador jugador);
    Jugador findByCorreo(String correo);
    boolean abonarCuenta(Jugador jugador, Double monto);
    boolean cargarCuenta(Jugador jugador, Double monto);

}
