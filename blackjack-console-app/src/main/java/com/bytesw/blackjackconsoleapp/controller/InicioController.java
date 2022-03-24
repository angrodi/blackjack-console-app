package com.bytesw.blackjackconsoleapp.controller;

import com.bytesw.blackjackconsoleapp.model.Usuario;
import org.springframework.stereotype.Controller;

import java.util.Scanner;

@Controller
public class InicioController {

    private final Scanner scanner = new Scanner(System.in);

    public String inicio() {
        System.out.println("###################################################################");
        System.out.println("##                         BLACKJACK APP                         ##");
        System.out.println("###################################################################");
        System.out.println();

        System.out.println("1. Iniciar sesión");
        System.out.println("2. Registro");
        System.out.println("3. Salir");
        System.out.print("\nOpción: ");

        return scanner.nextLine();
    }


}
