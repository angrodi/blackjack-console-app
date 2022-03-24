package com.bytesw.blackjackconsoleapp.controller;

import com.bytesw.blackjackconsoleapp.model.Jugador;
import com.bytesw.blackjackconsoleapp.service.impl.JugadorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

import java.util.InputMismatchException;
import java.util.Scanner;

@Controller
@RequiredArgsConstructor
public class SaldoController {

    private final JugadorService jugadorService;
    private final Scanner scanner = new Scanner(System.in);

    public void mostrarSaldo(Jugador jugador) {
        jugador = jugadorService.findByCorreo(jugador.getCorreo());
        String opcion;

        System.out.println("###################################################################");
        System.out.println("##                         BLACKJACK APP                         ##");
        System.out.println("###################################################################");
        System.out.println();

        System.out.println("Su saldo disponible es: " + jugador.getCuenta().getSaldo() + " soles.");
        do {
            System.out.print("Presione [enter] para continuar...");
            opcion = scanner.nextLine();
        } while (!opcion.equals(""));
    }

    public void recargarSaldo(Jugador jugador) {
        jugador = jugadorService.findByCorreo(jugador.getCorreo());
        Double monto = 0.0;
        String opcion;

        do {
            System.out.println("###################################################################");
            System.out.println("##                         BLACKJACK APP                         ##");
            System.out.println("###################################################################");
            System.out.println();
            if (monto < 0) {
                System.out.println("Ingrese un monto válido!");
            }
            System.out.print("Ingresar monto a recargar: ");
            try {
                monto = scanner.nextDouble();
            } catch (InputMismatchException e) {
                scanner.nextLine();
                monto = -1.0;
            }
        } while (monto <= 0.0);

        jugadorService.abonarCuenta(jugador, monto);
        System.out.println("Saldo recargado.");
        do {
            System.out.print("Presione [enter] para continuar...");
            scanner.nextLine();
            opcion = scanner.nextLine();
        } while (!opcion.equals(""));
    }


}
