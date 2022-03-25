package com.bytesw.blackjackconsoleapp.repository;

import com.bytesw.blackjackconsoleapp.model.Cuenta;
import com.bytesw.blackjackconsoleapp.model.Jugador;
import com.bytesw.blackjackconsoleapp.model.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

public class UsuarioRepositoryTests {

    @Autowired
    private UsuarioRepository usuarioRepository;
    private Usuario usuario;

    @BeforeEach
    public void setup() {
        usuario = Usuario.builder()
                .correo("angel@demo.com")
                .contrasenia("123")
                .build();
    }

    @Test
    public void givenUsuario_whenSave_thenReturnUsuarioGuardado() {
        // given - precondition or setup

        // when - action or the behaviour that we are going test
        Usuario usuarioGuardado = usuarioRepository.save(usuario);

        // then - verify the output
        assertThat(usuarioGuardado).isNotNull();
        assertThat(usuarioGuardado.getId()).isGreaterThan(0);
    }

    @Test
    public void givenUsuario_whenExistsByCorreo_thenReturnTrue() {
        // given - precondition or setup
        usuarioRepository.save(usuario);

        // when - action or the behaviour that we are going test
        boolean existe = usuarioRepository.existsByCorreo(usuario.getCorreo());

        // then - verify the output
        assertThat(existe).isTrue();
    }

    @Test
    public void givenUsuario_whenExistsByCorreo_thenReturnFalse() {
        // given - precondition or setup

        // when - action or the behaviour that we are going test
        boolean existe = usuarioRepository.existsByCorreo(usuario.getCorreo());

        // then - verify the output
        assertThat(existe).isFalse();
    }

    @Test
    public void givenUsuario_whenFindByCorreo_thenReturnUsuario() {
        // given - precondition or setup
        usuarioRepository.save(usuario);

        // when - action or the behaviour that we are going test
        Usuario usuarioDB = usuarioRepository.findByCorreo(usuario.getCorreo());

        // then - verify the output
        assertThat(usuarioDB).isNotNull();
    }
}
