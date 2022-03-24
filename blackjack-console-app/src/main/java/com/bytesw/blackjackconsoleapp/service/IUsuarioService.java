package com.bytesw.blackjackconsoleapp.service;

import com.bytesw.blackjackconsoleapp.model.Jugador;
import com.bytesw.blackjackconsoleapp.model.Usuario;

public interface IUsuarioService {

    boolean registro(Jugador jugador);
    boolean iniciarSesion(Usuario usuario);

}
