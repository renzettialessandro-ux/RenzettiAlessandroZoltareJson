/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package renzettialessandrozoltar;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

/**
 * @author renzetti.alessandro
 */
public class GestoreDomande implements DataManager {

    private Risposte risposte;
    public String tipo = "";
    private final String percorso = "Gestore_Risposte.json";
    private final Random random = new Random();

    public String getRisposta(String domanda) {
        List<String> listaScelta;
        switch (tipo.toLowerCase()) {
            case "sarcastico":
                listaScelta = risposte.sarcastico;
                break;
            case "buso":
                listaScelta = risposte.buso;
                break;
            case "saggio":
            default:
                listaScelta = risposte.saggio;
                break;
        }
        if (listaScelta != null && !listaScelta.isEmpty()) {
            int indiceCasuale = random.nextInt(listaScelta.size());
            return listaScelta.get(indiceCasuale);
        }
        return "Nessuna risposta disponibile per questa personalità.";
    }

    @Override
    public void ser() {
        try (FileWriter writer = new FileWriter(percorso)) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(this.risposte, writer);
        } catch (IOException e) {
            System.err.println("Errore nel salvataggio del file JSON: " + e.getMessage());
        }
    }

    @Override
    public void des() {
        String json = Files.readString(Paths.get(percorso));
        Gson gson = new Gson();
        this.risposte = gson.fromJson(json, Risposte.class);
    }

}
