package com.bytesw.blackjackconsoleapp.model;

import com.bytesw.blackjackconsoleapp.util.enums.CartaEnum;
import com.bytesw.blackjackconsoleapp.util.enums.PaloEnum;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Data
public class Baraja {

    private List<Carta> cartas;

    public Baraja() {
        cartas = new ArrayList<>();

        for (PaloEnum palo: PaloEnum.values()) {
            for (CartaEnum carta: CartaEnum.values()) {
                cartas.add(new Carta(carta, palo));
            }
        }
    }

    public Carta retirarCarta() {
        Random random = new Random();
        int index = random.nextInt(cartas.size());
        return cartas.remove(index);
    }


}