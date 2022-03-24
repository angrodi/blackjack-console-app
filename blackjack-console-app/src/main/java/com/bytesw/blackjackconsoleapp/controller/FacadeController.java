package com.bytesw.blackjackconsoleapp.controller;

import com.bytesw.blackjackconsoleapp.model.Jugador;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class FacadeController {

    private final InicioController inicioController;
    private final UsuarioController usuarioController;
    private final MenuController menuController;
    private final SaldoController saldoController;
    private final PartidaController partidaController;

    private Jugador jugador = new Jugador();

    public void iniciar() {
        String opcionInicio;
        String opcionMenu;

        do {
            opcionInicio = inicioController.inicio();

            if (opcionInicio.equals("1")) {
                if (usuarioController.iniciarSesion(jugador)) {
                    do {
                        opcionMenu = menuController.mostrarMenu(jugador);

                        if (opcionMenu.equals("1")) {
                            partidaController.iniciarPartida(jugador);
                        }

                        if (opcionMenu.equals("2")) {
                            saldoController.mostrarSaldo(jugador);
                        }

                        if (opcionMenu.equals("3")) {
                            saldoController.recargarSaldo(jugador);
                        }

                    } while(!opcionMenu.equals("4"));
                }
            } else if (opcionInicio.equals("2")) {
                usuarioController.registro(jugador);
            }
        } while(!opcionInicio.equals("3"));
    }
}
