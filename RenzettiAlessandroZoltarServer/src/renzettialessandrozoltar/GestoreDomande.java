/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package renzettialessandrozoltar;

import java.util.Random;

/**
 *
 * @author renzetti.alessandro
 */
public class GestoreDomande {
public String tipo = "saggio";
    private final Random random = new Random();

    private final String[] saggio = {
        "Il tempo rivelerà la verità.", 
        "Ascolta il tuo cuore, ma usa la testa.", 
        "La pazienza è la chiave.",
        "Ogni grande viaggio inizia con un piccolo passo.",
        "Non cercare le risposte nel mondo, guarda dentro di te."
    };
    private final String[] sarcastico = {
        "NOOO, giura?",
        "Ti serviva una sfera di cristallo per questo?",
        "E io che pensavo di averle sentite tutte.",
        "Fossi in te chiederei a Google, farebbe meno fatica.",
        "Certo, come no. E domani pioveranno soldi.",
    };
    private final String[] buso = {
        "Eh noooooooooo",
        "Il trapano",
        "Una a sega una a ramiccia", 
        "Eldegooooooooooo"
    };

    public String getRisposta(String domanda) {
        String[] pool = switch (tipo.toLowerCase()) {
            case "sarcastico" -> sarcastico;
            case "buso" -> buso;
            default -> saggio;
        };
        return pool[random.nextInt(pool.length)];
    }
}
