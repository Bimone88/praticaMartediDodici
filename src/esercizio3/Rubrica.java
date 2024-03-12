package esercizio3;

import java.util.HashMap;
import java.util.Map;

public class Rubrica {
    private static final Map<String, String> elencoTelefonico = new HashMap<>();

    public static void main(String[] args) {
        System.out.println("NSERIMENTO CONTATTI");
        try {
            inserisciContatto("Gigi Finizio", "+39 3301234567");
            inserisciContatto("Paolo Bitta", "+39 3307654321");
            inserisciContatto("Eustass Kid", "+39 3309876543");
            System.out.println("Numero di contatti inseriti: " + elencoTelefonico.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("ELIMINAZIONE CONTATTO");
        int contattiPrima = elencoTelefonico.size();
        eliminaContatto("Anna Verdi");
        System.out.println("Contatti eliminati: " + (contattiPrima - elencoTelefonico.size()));

        System.out.println("RICERCA PER NUMERO");
        cercaPersonaDaNumero("+39 3301234567");

        System.out.println("RICERCA PER NOME");
        cercaNumeroDaNome("Gigi Finizio");
        System.out.println("ELENCO CONTATTI");
        stampaElenco();
    }

    private static void inserisciContatto(String nome, String telefono) {
        elencoTelefonico.put(nome, telefono);
    }

    private static void eliminaContatto(String nome) {
        elencoTelefonico.remove(nome);
    }

    private static void cercaPersonaDaNumero(String numero) {
        String nomeTrovato = elencoTelefonico.entrySet().stream()
                .filter(entry -> numero.equals(entry.getValue()))
                .map(Map.Entry::getKey)
                .findFirst().orElse("Contatto non trovato");
        System.out.println(nomeTrovato);
    }

    private static void cercaNumeroDaNome(String nome) {
        String numero = elencoTelefonico.getOrDefault(nome, "Numero non disponibile");
        System.out.println(numero);
    }

    private static void stampaElenco() {
        elencoTelefonico.forEach((nome, numero) ->
                System.out.println("Contatto: " + nome + ", Telefono: " + numero));
    }
}

