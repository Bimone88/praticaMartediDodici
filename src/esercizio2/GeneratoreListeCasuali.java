package esercizio2;

import java.util.*;

public class GeneratoreListeCasuali {
    public static void main(String[] args) {

        System.out.println("Quanti numeri vuoi generare? Premi Invio dopo l'inserimento.");
        Scanner inputUtente = new Scanner(System.in);
        int dimensione = inputUtente.nextInt();
        List<Integer> serieNumerica = generaSerieNumerica(dimensione);
        System.out.println("PRIMA ELABORAZIONE");
        visualizzaElementi(serieNumerica);
        System.out.println("SECONDA ELABORAZIONE");
        List<Integer> serieRiflessa = riflettiSerie(serieNumerica);
        visualizzaElementi(serieRiflessa);
        System.out.println("TERZA ELABORAZIONE");
        filtraEStampa(serieRiflessa, false); // Dispari
        filtraEStampa(serieRiflessa, true); // Pari

        inputUtente.close();
    }

    public static List<Integer> generaSerieNumerica(int lunghezza) {
        List<Integer> listaNumeri = new ArrayList<>();
        Random generatoreRandom = new Random();
        for (int i = 0; i < lunghezza; i++) {
            listaNumeri.add(generatoreRandom.nextInt(0, 101));
        }
        Collections.sort(listaNumeri);
        return listaNumeri;
    }

    public static List<Integer> riflettiSerie(List<Integer> originale) {
        List<Integer> serieInvertita = new ArrayList<>(originale);
        Collections.reverse(serieInvertita);
        serieInvertita.addAll(originale);
        return serieInvertita;
    }

    public static void visualizzaElementi(List<Integer> lista) {
        System.out.println("La lista contiene " + lista.size() + " elementi.");
        for (int i = 0; i < lista.size(); i++) {
            System.out.println("Elemento " + i + ": " + lista.get(i));
        }
    }

    public static void filtraEStampa(List<Integer> lista, boolean cercaPari) {
        String tipoNumeri = cercaPari ? "Pari" : "Dispari";
        System.out.println("Elencazione " + tipoNumeri);
        for (int i = 0; i < lista.size(); i++) {
            if ((i % 2 == 0 && cercaPari) || (i % 2 != 0 && !cercaPari)) {
                System.out.println("Posizione " + (i + 1) + ": " + lista.get(i));
            }
        }
    }
}


