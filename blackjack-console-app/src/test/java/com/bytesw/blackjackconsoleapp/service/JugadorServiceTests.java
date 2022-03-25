package com.bytesw.blackjackconsoleapp.service;

import com.bytesw.blackjackconsoleapp.model.Cuenta;
import com.bytesw.blackjackconsoleapp.model.Jugador;
import com.bytesw.blackjackconsoleapp.repository.JugadorRepository;
import com.bytesw.blackjackconsoleapp.service.impl.JugadorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class JugadorServiceTests {

    @Mock
    private JugadorRepository jugadorRepository;

    @InjectMocks
    private JugadorService jugadorService;

    private Jugador jugador;

    @BeforeEach
    public void setup() {
        jugador = Jugador.builder()
                .id(1)
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
        given(jugadorRepository.save(jugador))
                .willReturn(jugador);

        // when - action or the behaviour that we are going test
        Jugador jugadorGuardado = jugadorRepository.save(jugador);

        // then - verify the output
        assertThat(jugadorGuardado).isNotNull();
        assertThat(jugadorGuardado.getId()).isGreaterThan(0);
    }

    @Test
    public void givenJugador_whenFindByCorreo_thenReturnJugador() {
        // given - precondition or setup
        given(jugadorRepository.findByCorreo(jugador.getCorreo()))
                .willReturn(jugador);

        // when - action or the behaviour that we are going test
        Jugador jugadorDB = jugadorService.findByCorreo(jugador.getCorreo());

        // then - verify the output
        assertThat(jugadorDB).isNotNull();
    }

    @Test
    public void givenJugadorYMonto_whenAbonarCuenta_thenTrue() {
        // given - precondition or setup
        given(jugadorRepository.save(jugador))
                .willReturn(jugador);

        // when - action or the behaviour that we are going test
        boolean exito = jugadorService.abonarCuenta(jugador, 100.0);

        // then - verify the output
        assertThat(exito).isTrue();
        assertThat(jugador.getCuenta().getSaldo()).isEqualTo(100.0);
    }

    @Test
    public void givenJugadorYMonto_whenCargarCuenta_thenTrue() {
        // given - precondition or setup
        jugador.getCuenta().setSaldo(200.0);

        given(jugadorRepository.save(jugador))
                .willReturn(jugador);

        // when - action or the behaviour that we are going test
        boolean exito = jugadorService.cargarCuenta(jugador, 100.0);

        // then - verify the output
        assertThat(exito).isTrue();
        assertThat(jugador.getCuenta().getSaldo()).isEqualTo(100.0);
    }

    @Test
    public void givenJugadorYMonto_whenCargarCuenta_thenFalse() {
        // given - precondition or setup
        jugador.getCuenta().setSaldo(200.0);

        // when - action or the behaviour that we are going test
        boolean exito = jugadorService.cargarCuenta(jugador, 300.0);

        // then - verify the output
        assertThat(exito).isFalse();
        assertThat(jugador.getCuenta().getSaldo()).isEqualTo(200.0);
    }

}
