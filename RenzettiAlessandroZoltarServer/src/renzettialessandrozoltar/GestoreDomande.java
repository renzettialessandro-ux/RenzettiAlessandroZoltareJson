package renzettialessandrozoltar;

import com.google.gson.Gson;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Random;

/**
 * @author renzetti.alessandro
 */
public class GestoreDomande {
    public static class RisposteModel {
        public List<String> saggio;
        public List<String> sarcastico;
        public List<String> buso;
    }

    private RisposteModel risposte;
    public String tipo = "";
    private final Random random = new Random();

    public GestoreDomande() {
        try (FileReader reader = new FileReader("Gestore_Risposte.json")) {
            Gson gson = new Gson();
            this.risposte = gson.fromJson(reader, RisposteModel.class);
        } catch (IOException e) {
            System.err.println("Errore nel caricamento del file JSON: " + e.getMessage());
        }
    }
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
}