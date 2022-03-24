package com.bytesw.blackjackconsoleapp.service.impl;

import com.bytesw.blackjackconsoleapp.model.Jugador;
import com.bytesw.blackjackconsoleapp.repository.JugadorRepository;
import com.bytesw.blackjackconsoleapp.service.IJugadorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JugadorService implements IJugadorService {

    private final JugadorRepository jugadorRepository;

    public Jugador save(Jugador jugador) {
        return jugadorRepository.save(jugador);
    }

    public Jugador findByCorreo(String correo) {
        return jugadorRepository.findByCorreo(correo);
    }

    public boolean abonarCuenta(Jugador jugador, Double monto) {
        jugador.getCuenta().abono(monto);
        jugadorRepository.save(jugador);
        return true;
    }

    public boolean cargarCuenta(Jugador jugador, Double monto) {
        if (jugador.getCuenta().getSaldo() - monto < 0) {
            return false;
        }
        jugador.getCuenta().cargo(monto);
        jugadorRepository.save(jugador);
        return true;
    }

}
