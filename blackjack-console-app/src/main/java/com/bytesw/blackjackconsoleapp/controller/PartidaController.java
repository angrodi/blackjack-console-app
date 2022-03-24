package com.bytesw.blackjackconsoleapp.controller;

import com.bytesw.blackjackconsoleapp.model.Carta;
import com.bytesw.blackjackconsoleapp.model.Jugador;
import com.bytesw.blackjackconsoleapp.model.Partida;
import com.bytesw.blackjackconsoleapp.service.impl.JugadorService;
import com.bytesw.blackjackconsoleapp.service.impl.PartidaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

import java.util.InputMismatchException;
import java.util.Scanner;

@Controller
@RequiredArgsConstructor
public class PartidaController {

    private final JugadorService jugadorService;
    private final PartidaService partidaService;
    private final Scanner scanner = new Scanner(System.in);

    public void iniciarPartida(Jugador jugador) {
        Partida partida = new Partida();
        Double apuesta = 0.0;
        String opcion = "";
        jugador = jugadorService.findByCorreo(jugador.getCorreo());

        System.out.println("###################################################################");
        System.out.println("##                         BLACKJACK APP                         ##");
        System.out.println("###################################################################");
        System.out.println();

        apostar(partida, jugador, apuesta);

        jugar(partida, opcion);

        obtenerGanador(partida, jugador, apuesta, opcion);
    }

    private void apostar(Partida partida, Jugador jugador, Double apuesta) {
        do {
            System.out.print("Ingresar apuesta: ");
            try {
                apuesta = scanner.nextDouble();
            } catch (InputMismatchException e) {
                scanner.nextLine();
                apuesta = -1.0;
            }
        } while (apuesta <= 0.0 || jugador.getCuenta().getSaldo() < apuesta);
        scanner.nextLine();
        partida.setApuesta(apuesta);
        jugadorService.cargarCuenta(jugador, apuesta);
    }

    private void jugar(Partida partida, String opcion) {
        do {
            System.out.println("###################################################################");
            System.out.println("##                         BLACKJACK APP                         ##");
            System.out.println("###################################################################");
            System.out.println();

            Carta carta1 = partida.getBaraja().retirarCarta();
            partida.getManoJugador().agregarCarta(carta1);

            if (partida.getManoCrupier().calcularMenorSuma() < 12) {
                Carta carta2 = partida.getBaraja().retirarCarta();
                partida.getManoCrupier().agregarCarta(carta2);
            }

            System.out.println("Mano (Jugador): " + partida.getManoJugador().getCartas());

            if (partida.getManoCrupier().getCartas().size() < 2) {
                System.out.println("Mano (Crupier): " + partida.getManoCrupier().getCartas());
            }

            if (partida.getManoJugador().calcularSumaOptima() == 21 || partida.getManoJugador().calcularMenorSuma() >= 21) {
                break;
            }

            do {
                System.out.println();
                System.out.println("1. Pedir carta");
                System.out.println("2. Plantarse");
                System.out.print("Opción: ");
                opcion = scanner.nextLine();
            } while (!opcion.equals("1") && !opcion.equals("2"));

        } while (opcion.equals("1"));

        while (partida.getManoCrupier().calcularMenorSuma() < 12) {
            Carta carta2 = partida.getBaraja().retirarCarta();
            partida.getManoCrupier().agregarCarta(carta2);
        }
    }

    private void obtenerGanador(Partida partida, Jugador jugador, Double apuesta, String opcion) {
        System.out.println("###################################################################");
        System.out.println("##                         BLACKJACK APP                         ##");
        System.out.println("###################################################################");
        System.out.println();
        System.out.println("Mano (Jugador): " + partida.getManoJugador().getCartas());
        System.out.println("Mano (Crupier): " + partida.getManoCrupier().getCartas());

        if (partida.getManoJugador().calcularSumaOptima() > 21) {
            System.out.println("Perdiste");
        } else if (partida.getManoJugador().calcularSumaOptima() == partida.getManoCrupier().calcularSumaOptima()) {
            System.out.println("Recuperas tu apuesta");
            jugadorService.abonarCuenta(jugador, apuesta);
        } else if (partida.getManoJugador().calcularSumaOptima() == 21) {
            System.out.println("Ganaste");
            jugadorService.abonarCuenta(jugador, apuesta * 4);
        } else if (partida.getManoJugador().calcularSumaOptima() > partida.getManoCrupier().calcularSumaOptima()) {
            System.out.println("Ganaste");
            jugadorService.abonarCuenta(jugador, apuesta * 2);
        } else {
            System.out.println("Perdiste");
        }

        partidaService.guardar(partida);

        do {
            System.out.print("Presione [enter] para continuar...");
            opcion = scanner.nextLine();
        } while (!opcion.equals(""));
    }
}
