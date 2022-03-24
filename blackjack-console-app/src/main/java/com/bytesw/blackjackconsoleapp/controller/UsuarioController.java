package com.bytesw.blackjackconsoleapp.controller;

import com.bytesw.blackjackconsoleapp.model.Jugador;
import com.bytesw.blackjackconsoleapp.model.Usuario;
import com.bytesw.blackjackconsoleapp.service.impl.JugadorService;
import com.bytesw.blackjackconsoleapp.service.impl.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

import java.util.Scanner;

@Controller
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;
    private final JugadorService jugadorService;
    private final Scanner scanner = new Scanner(System.in);

    public boolean iniciarSesion(Usuario usuario) {
        boolean exito = true;

        do {
            System.out.println("##################################################################");
            System.out.println("##                        INICIAR SESIÓN                        ##");
            System.out.println("##################################################################");
            System.out.println();

            if (!exito) {
                System.out.println("Correo y/o contraseña incorrectos!");
                System.out.print("Ingrese s|S si desea reintentar o n|N si desea cancelar: ");
                String rpta = scanner.nextLine();

                if (rpta.equals("N") || rpta.equals("n")) {
                    return false;
                }

                System.out.println();
            }

            System.out.print("Correo: ");
            usuario.setCorreo(scanner.nextLine());

            System.out.print("Contraseña: ");
            usuario.setContrasenia(scanner.nextLine());

            exito = usuarioService.iniciarSesion(usuario);
        } while (!exito);

        return true;
    }

    public boolean registro(Jugador jugador) {
        boolean exito = true;
        String opcion;

        do {
            System.out.println("##################################################################");
            System.out.println("##                           REGISTRO                           ##");
            System.out.println("##################################################################");
            System.out.println();

            if (!exito) {
                System.out.println("El correo ya esta registrado!");
                System.out.print("Ingrese s|S si desea reintentar o n|N si desea cancelar: ");
                String rpta = scanner.nextLine();

                if (rpta.equals("N") || rpta.equals("n")) {
                    return false;
                }

                System.out.println();
            }

            System.out.print("Correo: ");
            jugador.setCorreo(scanner.nextLine());

            System.out.print("Contraseña: ");
            jugador.setContrasenia(scanner.nextLine());

            System.out.print("Nombres: ");
            jugador.setNombres(scanner.nextLine());

            System.out.print("DNI: ");
            jugador.setDni(scanner.nextLine());

            exito = usuarioService.registro(jugador);
        } while (!exito);

        System.out.println("##################################################################");
        System.out.println("##                           REGISTRO                           ##");
        System.out.println("##################################################################");
        System.out.println();

        do {
            System.out.println("Registro exitoso!");
            System.out.print("Presione [enter] para continuar...");
            opcion = scanner.nextLine();
        } while (!opcion.equals(""));

        return true;
    }

    public Jugador obtenerJugador(String correo) {
        return jugadorService.findByCorreo(correo);
    }
}
