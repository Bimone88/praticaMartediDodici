package esercizio1;

import java.util.*;

public class MainInputUnico {
    public static void main(String[] args) {
        Scanner scannerDiInput = new Scanner(System.in);
        Set<String> insiemeParole = new HashSet<>();
        List<String> elencoDuplicati = new ArrayList<>();

        System.out.println("Inserisci la quantità di parole da elaborare e premi Invio. Usa 0 per uscire.");
        int numeroParole = Integer.parseInt(scannerDiInput.nextLine());

        if (numeroParole > 0) {

            for (int i = 0; i < numeroParole; i++) {
                System.out.println("Aggiungi un vocabolo all'elenco");
                String vocabolo = scannerDiInput.nextLine();
                if (!insiemeParole.add(vocabolo)) {
                    System.out.println(vocabolo + " è già stato inserito precedentemente");
                    elencoDuplicati.add(vocabolo);
                }
            }

            System.out.println("Numero totale di vocaboli distinti: " + insiemeParole.size());
            System.out.println("Elenco vocaboli distinti: " + insiemeParole);
            System.out.println("Elenco vocaboli duplicati: " + elencoDuplicati);
        } else {
            System.err.println("Il numero inserito non è valido. Riprova con un valore superiore a 0.");
        }

        scannerDiInput.close();
    }
}


