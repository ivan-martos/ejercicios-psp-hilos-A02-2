import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Ejercicio 9. Semáforos.
 *
 * Seis clientes quieren usar los probadores de una tienda, pero solo hay dos. Cada cliente tarda
 * un segundo en probarse la ropa.
 */
public class Ej09Semaforo {

    static final int PROBADORES = 2;
    static final int CLIENTES = 6;
    static final long INICIO = System.currentTimeMillis();

    public static void main(String[] args) {
        Semaphore probadores = new Semaphore(PROBADORES);

        try (ExecutorService tienda = Executors.newFixedThreadPool(CLIENTES)) {
            for (int i = 1; i <= CLIENTES; i++) {
                int cliente = i;
                tienda.submit(() -> probarse(cliente, probadores));
            }
        }
        System.out.println(segundos() + " s: todos se han probado la ropa");
    }

    /** El cliente espera a que haya un probador libre, lo usa un segundo y lo deja libre. */
    static void probarse(int cliente, Semaphore probadores) {
        // TODO (11 líneas): espera a que haya un probador libre; escribe
        //     segundos() + " s: el cliente " + cliente + " entra en un probador";
        //     tarda un segundo (Thread.sleep) y deja libre el probador aunque haya una excepción.
        //     Si interrumpen al hilo, termina


    }

    /** Segundos transcurridos desde que empezó el programa. Ya está hecho. */
    static long segundos() {
        return Math.round((System.currentTimeMillis() - INICIO) / 1000.0);
    }
}
