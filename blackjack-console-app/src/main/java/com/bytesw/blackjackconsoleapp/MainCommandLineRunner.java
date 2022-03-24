package com.bytesw.blackjackconsoleapp;

import com.bytesw.blackjackconsoleapp.controller.FacadeController;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MainCommandLineRunner implements CommandLineRunner {

    private final FacadeController facadeController;

    @Override
    public void run(String... args) throws Exception {
        facadeController.iniciar();
    }

}
