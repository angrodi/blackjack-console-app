package com.bytesw.blackjackconsoleapp.service.impl;

import com.bytesw.blackjackconsoleapp.model.Partida;
import com.bytesw.blackjackconsoleapp.repository.PartidaRepository;
import com.bytesw.blackjackconsoleapp.service.IPartidaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class PartidaService implements IPartidaService {

    private final PartidaRepository partidaRepository;

    public Partida guardar(Partida partida) {
        partida.setFecha(LocalDateTime.now());
        return partidaRepository.save(partida);
    }

}
