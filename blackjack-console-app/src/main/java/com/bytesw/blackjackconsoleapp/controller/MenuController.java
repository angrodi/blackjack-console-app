package com.bytesw.blackjackconsoleapp.controller;

import com.bytesw.blackjackconsoleapp.model.Usuario;
import org.springframework.stereotype.Controller;

import java.util.Scanner;

@Controller
public class MenuController {

    private final Scanner scanner = new Scanner(System.in);

    public String mostrarMenu(Usuario usuario) {
        System.out.println("###################################################################");
        System.out.println("##                         BLACKJACK APP                         ##");
        System.out.println("###################################################################");
        System.out.println();

        System.out.println("1. Iniciar partida");
        System.out.println("2. Mostrar saldo");
        System.out.println("3. Recargar saldo");
        System.out.println("4. Salir");
        System.out.print("Opción: ");

        return scanner.nextLine();
    }

}
