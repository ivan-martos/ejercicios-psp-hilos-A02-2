import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Ejercicio 39. CyclicBarrier.
 *
 * Cuatro hilos trabajan en tres rondas. Ninguno empieza la ronda siguiente hasta que los cuatro
 * han terminado la actual. Cuando la barrera se completa, escribe "--- Ronda N completa ---". Lo
 * que hay que completar está en trabajador().
 */
public class Ej39BarreraCiclica {

    static final int HILOS = 4;
    static final int RONDAS = 3;

    public static void main(String[] args) {
        int[] ronda = {0};
        CyclicBarrier barrera = new CyclicBarrier(HILOS,
                () -> System.out.println("--- Ronda " + (++ronda[0]) + " completa ---"));

        try (ExecutorService hilos = Executors.newFixedThreadPool(HILOS)) {
            for (int i = 1; i <= HILOS; i++) {
                int id = i;
                hilos.submit(() -> trabajador(id, barrera, RONDAS));
            }
        }
        System.out.println("Tendrían que verse 3 rondas completas, sin mezclarse");
    }

    /** Hace las rondas: en cada una trabaja id * 50 ms, lo escribe y espera en la barrera. */
    static void trabajador(int id, CyclicBarrier barrera, int rondas) {
        // TODO (12 líneas): en un try/catch, repite rondas veces: Thread.sleep(id * 50L), escribe
        //     "hilo " + id + " termina la ronda " + (r + 1) y espera con barrera.await().
        //     Captura InterruptedException y BrokenBarrierException en un solo catch
        //     (catch (InterruptedException | BrokenBarrierException e)) y restaura la interrupción
    }
}
