package com.bytesw.blackjackconsoleapp.repository;

import com.bytesw.blackjackconsoleapp.model.Partida;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class PartidaRepositoryTests {

    @Autowired
    private PartidaRepository partidaRepository;
    private Partida partida;

    @BeforeEach
    public void setup() {
        partida = new Partida();
        partida.setApuesta(100.0);
        partida.setFecha(LocalDateTime.now());
    }

    @Test
    public void givenPartida_whenSave_thenReturnPartidaGuardada() {
        // given - precondition or setup

        // when - action or the behaviour that we are going test
        Partida partidaGuardada = partidaRepository.save(partida);

        // then - verify the output
        assertThat(partidaGuardada).isNotNull();
        assertThat(partidaGuardada.getId()).isGreaterThan(0);
    }

}
