package com.bytesw.blackjackconsoleapp.repository;

import com.bytesw.blackjackconsoleapp.model.Cuenta;
import com.bytesw.blackjackconsoleapp.model.Jugador;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class JugadorRepositoryTests {

    @Autowired
    private JugadorRepository jugadorRepository;
    private Jugador jugador;

    @BeforeEach
    public void setup() {
        jugador = Jugador.builder()
                .correo("angel@demo.com")
                .contrasenia("123")
                .nombres("Angel")
                .cuenta(new Cuenta())
                .dni("77777777")
                .estado(1)
                .build();
    }

    @Test
    public void givenJugador_whenSave_thenReturnJugadorGuardado() {
        // given - precondition or setup

        // when - action or the behaviour that we are going test
        Jugador jugadorGuardado = jugadorRepository.save(jugador);

        // then - verify the output
        assertThat(jugadorGuardado).isNotNull();
        assertThat(jugadorGuardado.getId()).isGreaterThan(0);
    }

    @Test
    public void givenJugador_whenFindByCorreo_thenReturnJugador() {
        // given - precondition or setup
        jugadorRepository.save(jugador);

        // when - action or the behaviour that we are going test
        Jugador jugadorDB = jugadorRepository.findByCorreo(jugador.getCorreo());

        // then - verify the output
        assertThat(jugadorDB).isNotNull();
    }
}
