package com.bytesw.blackjackconsoleapp.repository;

import com.bytesw.blackjackconsoleapp.model.Jugador;
import org.springframework.data.repository.CrudRepository;

public interface JugadorRepository extends CrudRepository<Jugador, Integer> {

    Jugador findByCorreo(String correo);

}
