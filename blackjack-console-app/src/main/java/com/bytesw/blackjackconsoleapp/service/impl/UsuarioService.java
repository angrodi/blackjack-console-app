package com.bytesw.blackjackconsoleapp.service.impl;

import com.bytesw.blackjackconsoleapp.model.Cuenta;
import com.bytesw.blackjackconsoleapp.model.Jugador;
import com.bytesw.blackjackconsoleapp.model.Usuario;
import com.bytesw.blackjackconsoleapp.repository.JugadorRepository;
import com.bytesw.blackjackconsoleapp.repository.UsuarioRepository;
import com.bytesw.blackjackconsoleapp.service.IUsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UsuarioService implements IUsuarioService {

    private final JugadorRepository jugadorRepository;
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public boolean registro(Jugador jugador) {
        if (usuarioRepository.existsByCorreo(jugador.getCorreo())) {
            return false;
        }

        jugador.setContrasenia(passwordEncoder.encode(jugador.getContrasenia()));
        jugador.setCuenta(new Cuenta());
        jugador.setEstado(1);
        jugadorRepository.save(jugador);
        return true;
    }

    public boolean iniciarSesion(Usuario usuario) {
        if (usuarioRepository.existsByCorreo(usuario.getCorreo())) {
            Usuario usuarioDB = usuarioRepository.findByCorreo(usuario.getCorreo());
            if (passwordEncoder.matches(usuario.getContrasenia(), usuarioDB.getContrasenia())) {
                usuarioDB.setFechaUltimaSesion(LocalDateTime.now());
                usuarioRepository.save(usuarioDB);
                return true;
            }
        }
        return false;
    }

}
