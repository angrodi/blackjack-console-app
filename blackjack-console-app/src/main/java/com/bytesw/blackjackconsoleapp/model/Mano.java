package com.bytesw.blackjackconsoleapp.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Mano {

    private List<Carta> cartas;

    public Mano() {
        cartas = new ArrayList<>();
    }

    public void agregarCarta(Carta carta) {
        this.cartas.add(carta);
    }

    public int calcularMenorSuma() {
        return cartas.stream()
                .mapToInt(c -> c.getValor().getValor())
                .sum();
    }

    public int calcularSumaOptima() {
        int sumaMenor = calcularMenorSuma();
        int sumaOptima = sumaMenor;
        int numAses = (int) cartas.stream()
                .mapToInt(c -> c.getValor().getValor())
                .filter(num -> num == 1)
                .count();

        if (numAses > 0 && sumaMenor + 10 <= 21) {
            sumaOptima = sumaMenor + 10;
        }

        return sumaOptima;
    }
}
