/**
 * La classe {@code CucitoreCamicie} rappresenta la seconda fase del processo di produzione
 * di camicie: la cucitura dei pezzi tagliati.
 * <p>
 * Estende la classe {@link Thread} per consentire l'esecuzione parallela della fase di cucitura.
 * </p>
 *
 * @author
 * @version 1.0
 */
public class CucitoreCamicie extends Thread {

    /** Numero di camicie da processare. */
    private final int numeroCamicie;

    private static final int TEMPO_CUCITURA = 700;

    public CucitoreCamicie(int numeroCamicie) {
        super();
        this.numeroCamicie = numeroCamicie;
    }

    /**
     * Metodo principale del thread che simula la cucitura delle camicie.
     */
    @Override
    public void run() {
        System.out.println("FASE 2 - CUCITURA => Inizio cucitura camicie...");

        try {
            sleep(400);
            System.out.println("FASE 2 - CUCITURA => Macchine da cucire pronte");

            for (int i = 1; i <= numeroCamicie; i++) {
                sleep(TEMPO_CUCITURA);
                System.out.println("FASE 2 - CUCITURA => Camicia n." + i + " cucita (corpo, maniche, colletto, bottoni) - (" + i + "/" + numeroCamicie + ")");
            }
            //Sleep time per simulare il processo di cucitura
            sleep(300);
            System.out.println("FASE 2 - CUCITURA => Fase di cucitura completata! Totale: " + numeroCamicie + " camicie cucite\n");

            //controllo degli errori tramite il bollo try catch
        } catch (InterruptedException e) {
            System.out.println("FASE 2 - CUCITURA => è stata rilevata un anomalia nel sistema");
            e.printStackTrace();
        }
    }
}