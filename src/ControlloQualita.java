/**
 * La classe {@code ControlloQualita} rappresenta la fase finale del processo di produzione
 * di camicie: il controllo qualità e il confezionamento.
 * <p>
 * Estende la classe {@link Thread} per consentire l'esecuzione parallela della fase di controllo.
 * </p>
 *
 * @author
 * @version 1.0
 */
public class ControlloQualita extends Thread {

    /** Numero di camicie da processare. */
    private final int numeroCamicie;

    /** Tempo di sleep per simulare il lavoro (in millisecondi). */
    private static final int TEMPO_CONTROLLO = 400;


    public ControlloQualita(int numeroCamicie) {
        super();
        this.numeroCamicie = numeroCamicie;
    }

    /**
     * Metodo principale del thread che simula il controllo qualità.
     */
    @Override
    public void run() {
        System.out.println("FASE 3 - Controllo QUALITÀ => Inizio controllo qualità finale...");

        try {
            sleep(300);
            System.out.println("FASE 3 - Controllo QUALITÀ => Postazione di controllo pronta");

            for (int i = 1; i <= numeroCamicie; i++) {
                sleep(TEMPO_CONTROLLO);
                System.out.println("FASE 3 - Controllo QUALITÀ => Camicia n." + i + " controllata e confezionata (" + i + "/" + numeroCamicie + ")");
            }

            sleep(400);
            System.out.println("FASE 3 - Controllo QUALITÀ => Tutte le camicie hanno superato il controllo qualità!");
            System.out.println("FASE 3 - Controllo QUALITÀ => Fase finale completata! " + numeroCamicie + " camicie pronte per la spedizione\n");

        } catch (InterruptedException e) {
            System.out.println("FASE 3 - Controllo QUALITÀ => Si è verificato un errore duarante il processo di controllo.");
            e.printStackTrace();
        }
    }
}