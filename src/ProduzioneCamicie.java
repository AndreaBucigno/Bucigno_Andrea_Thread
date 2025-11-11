import java.util.Scanner;

/**
 * La classe {@code ProduzioneCamicie} rappresenta il punto di ingresso del programma
 * che simula un processo di produzione di camicie.
 * <p>
 * Il processo prevede diverse fasi eseguite in parallelo tramite thread:
 * taglio del tessuto, cucitura e controllo qualità.
 * </p>
 *
 * @author
 * @version 1.0
 */
public class ProduzioneCamicie {

    /** Numero di camicie prodotte con successo. ES. la variabile "Primo nella corsaCavalli" */
    private static int camicieCompletate = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continua = true;

        while (continua) {
            System.out.println("=================================================================");
            System.out.println("       SISTEMA DI PRODUZIONE CAMICIE - MENU PRINCIPALE");
            System.out.println("=================================================================");
            System.out.println("1. Avvia produzione");
            System.out.println("2. Visualizza statistiche");
            System.out.println("3. Pulisci lo schermo");
            System.out.println("4. Esci");
            System.out.println("-----------------------------------------------------------------");
            System.out.print("Seleziona un'opzione: ");

            int scelta = scanner.nextInt();
            scanner.nextLine();

            switch (scelta) {
                case 1:
                    avviaProduzione(scanner);
                    break;

                case 2:
                    visualizzaStatistiche();
                    break;

                case 3:
                    PulisciSchermo();
                    break;

                case 4:
                    continua = false;
                    System.out.println("\nChiusura sistema di produzione...");
                    break;

                default:
                    System.out.println("\nOpzione non valida!\n");
                    break;
            }
        }

        scanner.close();
    }

    /**
     * Avvia il processo di produzione delle camicie in parallelo.
     *
     * @param scanner oggetto Scanner per input utente
     */
    private static void avviaProduzione(Scanner scanner) {
        System.out.println("\n-----------------------------------------------------------------");
        System.out.print("Inserisci il numero di camicie da produrre: ");

        //numeroCamicie  è l'attributo che permette l'interazione con l'utente

        int numeroCamicie = scanner.nextInt();
        scanner.nextLine();

        System.out.println("\n=================================================================");
        System.out.println("    INIZIO CICLO DI PRODUZIONE - " + numeroCamicie + " CAMICIE");
        System.out.println("=================================================================\n");

        long tempoInizio = System.currentTimeMillis();

        // Creazione dei thread per le diverse fasi di produzione
        TagliaTessuto tagliatore = new TagliaTessuto(numeroCamicie);
        CucitoreCamicie cucitore = new CucitoreCamicie(numeroCamicie);
        ControlloQualita controllore = new ControlloQualita(numeroCamicie);

        // Avvio dei thread
        tagliatore.start();

        try {
            // Il cucitore aspetta che il tagliatore finisca
            tagliatore.join();
            cucitore.start();

            // Il controllo qualità aspetta che il cucitore finisca
            cucitore.join();
            controllore.start();

            // Aspetta che il controllo qualità termini
            controllore.join();

        } catch (InterruptedException e) {
            System.out.println("Errore nella produzione delle camicie " + e.getMessage());
            e.printStackTrace();
        }

        long tempoFine = System.currentTimeMillis();
        //tempo inizio - tempofine = risultato in milli secondi  => diviso mille per averlo in secondi
        long durataTotale = (tempoFine - tempoInizio) / 1000;

        camicieCompletate += numeroCamicie;

        System.out.println("\n=================================================================");
        System.out.println("    PRODUZIONE COMPLETATA CON SUCCESSO!");
        System.out.println("=================================================================");
        System.out.println("Camicie prodotte: " + numeroCamicie);
        System.out.println("Tempo totale: " + durataTotale + " secondi");
        System.out.println("Totale camicie completate nella sessione: " + camicieCompletate);
        System.out.println("=================================================================\n");
    }

    /**
     * Visualizza le statistiche di produzione correnti.
     */
    private static void visualizzaStatistiche() {
        System.out.println("\n=================================================================");
        System.out.println("    STATISTICHE DI PRODUZIONE");
        System.out.println("=================================================================");
        System.out.println("Totale camicie completate: " + camicieCompletate);
        System.out.println("=================================================================\n");
    }

    /** Metodo per pulire lo schermo per fare pulizia visiva **/

    private static void PulisciSchermo(){
        for(int i = 0 ; i<50; i++)
            System.out.println("\n");
    }
}