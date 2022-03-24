package com.bytesw.blackjackconsoleapp.model;

import com.bytesw.blackjackconsoleapp.util.enums.CartaEnum;
import com.bytesw.blackjackconsoleapp.util.enums.PaloEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Carta {

    private CartaEnum valor;
    private PaloEnum palo;

    @Override
    public String toString() {
        return valor.getValor() + palo.getValue();
    }
}
