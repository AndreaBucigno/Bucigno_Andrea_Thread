/**
 * La classe {@code TagliatoreTessuto} rappresenta la prima fase del processo di produzione
 * di camicie: il taglio del tessuto secondo i cartamodelli.
 * <p>
 * Estende la classe {@link Thread} per consentire l'esecuzione parallela della fase di taglio.
 * </p>
 *
 * @author
 * @version 1.0
 */
public class TagliaTessuto extends Thread {

    /** Numero di camicie da processare. */
    private final int numeroCamicie;

    private static final int TEMPO_TAGLIO = 300;

    public TagliaTessuto(int numeroCamicie) {
        super();
        this.numeroCamicie = numeroCamicie;
    }

    /**metodo pricipale che consente di simulare il taglio delle camicie**/

    @Override
    public void run() {
        System.out.println("FASE 1 - TAGLIO => Inizio taglio tessuto per " + numeroCamicie + " camicie...");

        try {
            //assegno lo sleep time così da simulare il taglio del tessuto
            sleep(TEMPO_TAGLIO);
            System.out.println("FASE 1 - TAGLIO => Postazione di taglio pronta, cartamodelli posizionati");

            for (int i = 1; i <= numeroCamicie; i++) {
                sleep(TEMPO_TAGLIO);
                System.out.println("FASE 1 - TAGLIO => Tessuto tagliato per camicia n." + i + " (" + i + "/" + numeroCamicie + ")");
            }
            //sleep time per simulare il taglio delle camicie
            sleep(200);
            System.out.println("FASE 1 - TAGLIO => Fase di taglio completata! Totale: " + numeroCamicie + " set di pezzi pronti\n");

        } catch (InterruptedException e) {
            System.out.println("FASE 1 - TAGLIO => ERRORE: Processo di taglio interrotto!");
            e.printStackTrace();
        }
    }
}